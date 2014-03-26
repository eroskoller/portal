/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.reports;

import br.com.facesbeans.jobpush.BlockPdf;
import br.com.facesbeans.jobpush.RelatorioStorage;
import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabPaciente;
import br.com.hibernate.entities.LabRelatorios;
import br.com.hibernate.entities.LabUsuarioUnidade;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import br.com.utils.pdfmaker.PdfDados;
import br.com.utils.pdfmaker.PdfDadosSender;
import br.com.utils.tipstricks.ResumeStrings;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.context.RequestContext;


/**
 *
 * @author ricardo
 */
@SessionScoped //TODO change to ViewScope
@ManagedBean(name = "estatisticaexameprontuarioViewBean")
public class EstatisticaExameProntuarioView implements Serializable{

    private String strJasperFormat = "pdf";
    
//    private LabPaciente paciente;
    private Date today =  new Date();// OracleHelper.getDateFromDB();
    private Date dtStartQuery = new Date();
    private Date dtEndQuery = new Date();
    private PortalView portal;
    
    private List<MenuItem> itensMenuProntuario;
    private Set<LabPaciente> setLabPaciente;
    private List<LabPaciente> listLabPacientePop;
    private SelectItem[] itensMeses;
    
    private String strTipoImpressao = "ana";
    private String strOrdemDoRel = "U";
    private String strProntuario;
    private String strMsg;
    private String strMes = "vazio";
    private String strTipoPesquisaProntuarioPop = "prontuario";
    private String strSizeInputPop;
    private String strMensagemProntuarioPop;
    private String strProntuarioCodigoPop;
    
    private boolean blPopup;
    private boolean blPopMsg;
    private boolean blBarMsg;
    private boolean blDetalhaPorExame = true;
    
    
    SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM/yyyy", new Locale("pt", "BR"));
    SimpleDateFormat sdf2 = new SimpleDateFormat("MMMM", new Locale("pt", "BR"));
    
    
    public EstatisticaExameProntuarioView() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
    }
    
    
    @PostConstruct
    public void init() {
        if (portal != null && portal.getLabUsuario() != null) {
        } else {
            try {
                JSFHelper.getExternalContext().redirect("/portal");
            } catch (IOException ex) {
                Logger.getLogger(EstatisticaExameRequisicaoView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public SelectItem[] getItensMeses(){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(today);
        c1.add(Calendar.MONTH, -1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(today);
        c2.add(Calendar.MONTH, -2);
        Calendar c3 = Calendar.getInstance();
        c3.setTime(today);
        c3.add(Calendar.MONTH, -3);
        
        itensMeses = new SelectItem[4];
        itensMeses[0] = new SelectItem("vazio", "--Selecione o Mês--");
        itensMeses[1] = new SelectItem(c1.getTime(), sdf1.format(c1.getTime()));
        itensMeses[2] = new SelectItem(c2.getTime(), sdf1.format(c2.getTime()));
        itensMeses[3] = new SelectItem(c3.getTime(), sdf1.format(c3.getTime()));
        return itensMeses;
    }
    
    
    public void grabLabProntuarioValueChangeEvent(ValueChangeEvent event){
        strProntuario = (String) event.getNewValue();
        System.out.println("grabLabProntuarioValueChangeEvent: "+strProntuario);
        this.grabLabProntuario();
    }
    
    public void grabLabProntuario(){
        
        if(strProntuario != null && !strProntuario.isEmpty()){
            
            List<LabPaciente>  list = OracleHelper
                    .getListOfObjectByKeyEq(LabPaciente.class, "pacStProntuario", strProntuario, "pacStNome", true, portal.getStrDbName());
            if(list != null){
                if(list.size()  == 1   && !list.isEmpty()){
                    buildMenu4LabProntuario(list.get(0));
                }else  if(list.size()  > 1   && !list.isEmpty()) {
                    listLabPacientePop = list;
                    this.showListPopPac();
                }
            }else{
                portal.popMsg(1, true, "Não houve resultados com este prontuário............");
            }
            
        }
    }
    
    private void showListPopPac(){
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("widgetvarrelatorioprontuariopoplistlabprontuarios.show()");
    }
    
    
    
    private void buildMenu4LabProntuario(LabPaciente lp) {
        if (setLabPaciente == null) {
            setLabPaciente = new LinkedHashSet<LabPaciente>();
        }
        if (this.validatesLabProntuario(lp)) {
            if (setLabPaciente.add(lp)) {
                portal.popMsg(1, false, "Prontuário Incluido com Sucesso....");
            } else {
                portal.popMsg(1, true, "Prontuário Repetido....");
            }
        }

        setStrProntuario("");
    }
    
    
    private boolean validatesLabProntuario(LabPaciente lp) {
        if (portal != null) {
            if (portal.getMapLinkedLabUnidade() != null && !portal.getMapLinkedLabUnidade().isEmpty()) {
                if (lp != null) {
                    if (portal.getMapLinkedLabUnidade().containsKey(lp.getUniStCodigo())) {
                        return true;
                    } else {
                        portal.popMsg(1, true, "Você não tem a Unidade desta requisição no seu login...");
                        return false;
                    }
                } else {
                    portal.popMsg(1, true, "Paciente não existe...");
                    return false;
                }
            } else {
                portal.popMsg(1, true, "Você não tem Unidades registradas no seu login...");
                return false;
            }
        } else {
            portal.popMsg(1, true, "Logue corretamente no sistema....");
            return false;
        }
    }
    
    
    public void delProntuario(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatorioprontuarioparam");
        if (paramValue != null && !setLabPaciente.isEmpty()) {
            for (LabPaciente lp : setLabPaciente) {
                if (lp.getPacInCodigo().toString().equalsIgnoreCase(paramValue)) {
                    setLabPaciente.remove(lp);
                    break;
                }
            }
        } else {
            portal.popMsg(1, true, "A lista de lotes está vazia, escolha pelo menos um lote.");
        }
    }
    
    public void pesquisar(){
        if(setLabPaciente != null && setLabPaciente.size()>0){
            if(!(strMes.equalsIgnoreCase("vazio"))){
                if(!strTipoImpressao.equalsIgnoreCase("ana") && blDetalhaPorExame){
                    portal.popMsg(1, true, "Não existe relatorio sintático e detalhado");
                }else{
                    makePdf();
                }
            }else{
                portal.popMsg(1, true, "Favor selecionar um mês para pesquisa");
            }
        }else{
            portal.popMsg(1, true, "Lista de Prontuários vazia");
        }
    }
    
    private void makePdf(){
//        RelStorageKey relkey = new RelStorageKey(lmi.getLogin(), lmi.getStrDbName());
        String id = portal.getLabUsuario().getUsuStCodigo().toUpperCase()+portal.getStrDbName().toUpperCase();
        RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
        
        if(relatorioStorage.blockByPdfUnfinish()){
            List<String> listPac = new ArrayList<String>();
            StringBuffer sbPac = new StringBuffer();
            for (LabPaciente lp : setLabPaciente) {
                sbPac.append(lp.getPacStProntuario() + " | ");
                listPac.add(lp.getPacInCodigo().toString());
            }
            
            List<LabUsuarioUnidade> usuUnidades = portal.getLabUsuario().getListLabUnidadeUsuario();
            List<String> listStrUsuUnidades = null;
            if(usuUnidades != null){
                listStrUsuUnidades = new ArrayList<String>(usuUnidades.size());
                for (LabUsuarioUnidade labUnidade : usuUnidades) {
                    String strUnidade = labUnidade.getUniStCodigo();
                    listStrUsuUnidades.add(strUnidade);
                }
            }
            String strResumo = ResumeStrings.resumeString(400, "Estatística de Prontuário ("+sdf2.format(dtStartQuery) +"): " + sbPac.toString().substring(0, sbPac.length()-3), "...etc");
            
            Map<String, List> mapOrs4Det = new HashMap<String, List>();
            mapOrs4Det.put("pacInCodigo", listPac);
            mapOrs4Det.put("uniStCodigo", listStrUsuUnidades);
            
            PdfDados pDados = new PdfDados("", strResumo, portal.getLabUsuario().getUsuStCodigo(),
                dtStartQuery,  dtEndQuery,
                mapOrs4Det, strTipoImpressao, strOrdemDoRel,portal.getStrDbName());
//            PdfDados pDados = new PdfDados("", "estatisticaprontuario", strResumo, mapOrs4Det, lmi.getUsuario().getUsuStCodigo(), strResumo);
            pDados.setStrTipoDePdf("estatisticaprontuario");
             //TODO fixing fucking DB Date
            Date rigthNow = OracleHelper.getDateFromDB(portal.getStrDbName());
//            Date rigthNow = new Date();
            String strFileName = portal.getLabUsuario().getUsuStCodigo() + "_ESTATISTICA_PRONTUARIO_" + ArrayItems.format4PdfName.format(rigthNow)+ "."+strJasperFormat; 
            pDados.setStrPdfName(ArrayItems.strURLPdfPath + strFileName);
            pDados.setStrDateFieldName(sbPac.toString().substring(0, sbPac.length()-3));
            
            Map<String, Object> mapAnds4Det = new HashMap<String, Object>();
            if(blDetalhaPorExame){
                mapAnds4Det.put("detalhaPorExame", "detalhaPorExame");
            }
            pDados.setMapAnds4Det(mapAnds4Det);
            
            if(strTipoImpressao.equalsIgnoreCase("ana")){
                pDados.setStrTipoRelatorio("analitico");
            }else{
                pDados.setStrTipoRelatorio("sintetico"); 
            }
            
            LabRelatorios lr = new LabRelatorios(OracleHelper.getLabRelatorioNextId(portal.getStrDbName()),
                    rigthNow, rigthNow, 'L', "vazio", portal.getLabUsuario().getUsuStCodigo(),
                    strFileName, "relatório em execuçâo \n aguarde.", ResumeStrings.resumeString(490, strResumo, "etc"));
            OracleHelper.saveObject(lr,portal.getStrDbName());
            relatorioStorage.addAndSorReports(lr);
//            RelatorioStorage.addRelatorioToUser(portal.getLabUsuario().getUsuStCodigo().toUpperCase(),portal.getStrDbName().toUpperCase(), lr);
            pDados.setStrId(lr.getRelInCodigo().toString());
            pDados.setStrDbName(portal.getStrDbName());
            pDados.setStrUserNome(portal.getLabUsuario().getUsuStCodigo());
            XStream xstream = new XStream();
            String strPdfDados = xstream.toXML(pDados);
            PdfDadosSender pds = new PdfDadosSender();
            pds.pdfSender(strPdfDados);
            portal.popMsg(100, false, "");
        }
    }
    
    private void setDate() {
        if (dtStartQuery != null && dtEndQuery != null) {
            Calendar calStartOfTheMonth = Calendar.getInstance();
            calStartOfTheMonth.setTime(dtStartQuery);
            calStartOfTheMonth.set(dtStartQuery.getYear() + 1900, dtStartQuery.getMonth(), 1, 00, 00, 00);
            dtStartQuery = calStartOfTheMonth.getTime();

            Calendar calEndOfTheMonth = Calendar.getInstance();
            calEndOfTheMonth.setTime(dtEndQuery);
            calEndOfTheMonth.set(dtEndQuery.getYear() + 1900, dtEndQuery.getMonth(), calEndOfTheMonth.getActualMaximum(calEndOfTheMonth.DAY_OF_MONTH), 23, 59, 59);
            dtEndQuery = calEndOfTheMonth.getTime();
        }
    }
    
    public void valueChangePesquisaPop(ValueChangeEvent event){
        System.out.println("Inside valueChangePesquisaPop");
        if(event != null){
            setStrProntuarioCodigoPop(event.getNewValue().toString());
            pesquisaPop();
        }
    }
    
    public void pesquisaPop(){
        setStrMensagemProntuarioPop("");
        listLabPacientePop = null;
        if(listLabPacientePop == null){listLabPacientePop = new ArrayList<LabPaciente>();}
        
        List<LabPaciente> l = new ArrayList<LabPaciente>();
        if(strTipoPesquisaProntuarioPop.equalsIgnoreCase("prontuario")){
            l = OracleHelper.getListLabPacienteByProntuario(strProntuarioCodigoPop,portal.getStrDbName());
            for (LabPaciente lp : l) {
                
                    listLabPacientePop.add(lp);
                    
            }
        }else if(strTipoPesquisaProntuarioPop.equalsIgnoreCase("nome")){
            if(strProntuarioCodigoPop.length()>8){
                l = OracleHelper.getListLabPacienteByPacStNome(strProntuarioCodigoPop, portal.getStrDbName());
                for(LabPaciente lp : l){
                    listLabPacientePop.add(lp);
                }
            }else{
                strMensagemProntuarioPop = "Digite mais que 8 caracteres.";
            }
        }
        Collections.sort(listLabPacientePop);
    }

    
    
    
    
    public void grabProntuarioPopFromList(ActionEvent event){
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatorioexameprontuariolabprontuariosparam");
        if(paramValue != null){
//            if(setLabPaciente == null){setLabPaciente = new LinkedHashSet<LabPaciente>();}
//            if(setLabPaciente.add((LabPaciente)OracleHelper.getObject(LabPaciente.class, new Long(paramValue), portal.getStrDbName()))){
//                portal.popMsg(1, false, "Prontuario incluido com sucesso......................");
//            }else{
//                portal.popMsg(0, true, "Prontuario repetido......................");
//            }
            
            for (LabPaciente pac : this.listLabPacientePop) {
                if(pac.getPacInCodigo().toString().equalsIgnoreCase(paramValue)){
                    buildMenu4LabProntuario(pac);
                    break;
                }
            }
        }
    }
    
    public void cleanUpEveryThing(){
        if(setLabPaciente != null){
            setLabPaciente.clear();
        }
        if(listLabPacientePop != null){
            listLabPacientePop.clear();
        }
    }

    
    
    public String getStrJasperFormat() {
        return strJasperFormat;
    }

    public void setStrJasperFormat(String strJasperFormat) {
        this.strJasperFormat = strJasperFormat;
    }
    
    public Set<LabPaciente> getSetLabPaciente() {
        return setLabPaciente;
    }

    public void setSetLabPaciente(Set<LabPaciente> setLabPaciente) {
        this.setLabPaciente = setLabPaciente;
    }
    
    public boolean isBlDetalhaPorExame() {
        return blDetalhaPorExame;
    }

    public void setBlDetalhaPorExame(boolean blDetalhaPorExame) {
        if(!strTipoImpressao.equalsIgnoreCase("ana")){
            blDetalhaPorExame = false;
        }
        this.blDetalhaPorExame = blDetalhaPorExame;
    }
    
    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public List<LabPaciente> getListLabPacientePop() {
        return listLabPacientePop;
    }

    public void setListLabPacientePop(List<LabPaciente> listLabPacientePop) {
        this.listLabPacientePop = listLabPacientePop;
    }
    
    public String getStrProntuarioCodigoPop() {
        return strProntuarioCodigoPop;
    }

    public void setStrProntuarioCodigoPop(String strProntuarioCodigoPop) {
        this.strProntuarioCodigoPop = strProntuarioCodigoPop;
    }
    
    public String getStrMensagemProntuarioPop() {
        return strMensagemProntuarioPop;
    }

    public void setStrMensagemProntuarioPop(String strMensagemProntuarioPop) {
        this.strMensagemProntuarioPop = strMensagemProntuarioPop;
    }
    
    public String getStrSizeInputPop() {
        return strSizeInputPop;
    }

    public void setStrSizeInputPop(String strSizeInputPop) {
        this.strSizeInputPop = strSizeInputPop;
    }

    public String getStrTipoPesquisaProntuarioPop() {
        return strTipoPesquisaProntuarioPop;
    }

    public void setStrTipoPesquisaProntuarioPop(String strTipoPesquisaProntuarioPop) {
        if(strTipoPesquisaProntuarioPop.equalsIgnoreCase("prontuario")){
            strSizeInputPop = "15";
        }else if(strTipoPesquisaProntuarioPop.equalsIgnoreCase("nome")){
            strSizeInputPop = "30";
        }
        this.strTipoPesquisaProntuarioPop = strTipoPesquisaProntuarioPop;
    }
    
    public String getStrMes() {
        return strMes;
    }

    public void setStrMes(String strMes) {
        for(SelectItem si : itensMeses){
            if(si.getValue().toString() != "vazio" && si.getValue().toString().equalsIgnoreCase(strMes)){
                dtStartQuery = (Date) si.getValue();
                dtEndQuery = (Date) si.getValue();
            }
        }
        setDate();
//        System.out.println("imprimindo essa porra....." + strMes);
//        System.out.println(ArrayItems.format4PdfName.format(dtStartQuery) + " - " + ArrayItems.format4PdfName.format(dtEndQuery));
        this.strMes = strMes;
    }

    public PortalView getPortal() {
        return portal;
    }

    public void setPortal(PortalView portal) {
        this.portal = portal;
    }
    
    public List<MenuItem> getItensMenuProntuario() {
        return itensMenuProntuario;
    }

    public void setItensMenuProntuario(List<MenuItem> itensMenuProntuario) {
        this.itensMenuProntuario = itensMenuProntuario;
    }
    
    public boolean isBlBarMsg() {
        return blBarMsg;
    }

    public void setBlBarMsg(boolean blBarMsg) {
        this.blBarMsg = blBarMsg;
    }

    public boolean isBlPopMsg() {
        return blPopMsg;
    }

    public void setBlPopMsg(boolean blPopMsg) {
        this.blPopMsg = blPopMsg;
    }

   

    public String getStrMsg() {
        return strMsg;
    }

    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }
    
    public String getStrProntuario() {
        return strProntuario;
    }

    public void setStrProntuario(String strProntuario) {
        this.strProntuario = strProntuario;
    }
    
    public boolean isBlPopup() {
        return blPopup;
    }

    public void setBlPopup(boolean blPopup) {
        this.blPopup = blPopup;
    }

    public String getStrOrdemDoRel() {
        return strOrdemDoRel;
    }

    public void setStrOrdemDoRel(String strOrdemDoRel) {
        this.strOrdemDoRel = strOrdemDoRel;
    }
    
    public String getStrTipoImpressao() {
        return strTipoImpressao;
    }

    public void setStrTipoImpressao(String strTipoImpressao) {
        if(strTipoImpressao.equalsIgnoreCase("sin")){
            blDetalhaPorExame = false;
        }
        this.strTipoImpressao = strTipoImpressao;
    }
}
