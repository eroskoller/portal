/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.reports;

import br.com.facesbeans.jobpush.RelatorioStorage;
import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabRelatorios;
import br.com.hibernate.entities.LabRequisicao;
import br.com.hibernate.entities.LabUnidade;
import br.com.hibernate.entities.LabUsuario;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import br.com.utils.pdfmaker.PdfDados;
import br.com.utils.pdfmaker.PdfDadosSender;



import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;  
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ActionListener;
import javax.faces.model.SelectItem;

    



/**
 *
 * @author eros
 */
@SessionScoped   //TODO change to ViewScope at the end...
@ManagedBean(name="estatisticaexamerequisicaoViewBean")
public class EstatisticaExameRequisicaoView implements Serializable{
    
    
    private PortalView portal;
    private String strReqCodigo;
    private String strJasperFormat = "pdf";
//    private HtmlInputText htmlReqCodigo;
//    private  Effect valueChangeEffectReqList = new Highlight("#fda505");
    private LabRequisicao labRequisicao;
    private Set<LabRequisicao> setLabRequisicao = new LinkedHashSet<LabRequisicao>();
//    private List<MenuItem> listMenuItens;
    
    
    private String strTipoRelatorio = "A";
    private boolean blBarMsg =  false;
    private boolean blPopMsg =  false;
    private String strMsg = "";
//    private Effect valueChangeEffectMsgBar ;
    
    
    
    
//    private LabUsuario labUsuario;

    public EstatisticaExameRequisicaoView() {
        
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
//        init();
    }
    
    @PostConstruct
     public void init(){
        
        if (portal != null &&portal.getLabUsuario()!= null) {
            
        }else {
            try {
                JSFHelper.getExternalContext().redirect("/portal");
            } catch (IOException ex) {
                Logger.getLogger(EstatisticaExameRequisicaoView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public String getStrJasperFormat() {
        return strJasperFormat;
    }

    public void setStrJasperFormat(String strJasperFormat) {
        this.strJasperFormat = strJasperFormat;
    }
    

    public boolean isBlPopMsg() {
        return blPopMsg;
    }

    public void setBlPopMsg(boolean blPopMsg) {
        this.blPopMsg = blPopMsg;
    }

    public boolean isBlBarMsg() {
        return blBarMsg;
    }

    public void setBlBarMsg(boolean blBarMsg) {
        this.blBarMsg = blBarMsg;
    }

    public String getStrMsg() {
        return strMsg;
    }

    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }

 
    public LabRequisicao getLabRequisicao() {
        return labRequisicao;
    }

    public void setLabRequisicao(LabRequisicao labRequisicao) {
        this.labRequisicao = labRequisicao;
    }


    public Set<LabRequisicao> getSetLabRequisicao() {
        return setLabRequisicao;
    }

    public void setSetLabRequisicao(Set<LabRequisicao> setLabRequisicao) {
        this.setLabRequisicao = setLabRequisicao;
    }

    public String getStrReqCodigo() {
        return strReqCodigo;
    }

    public void setStrReqCodigo(String strReqCodigo) {
        this.strReqCodigo = strReqCodigo;
    }
    public SelectItem[] getTipoRelatorio() {
        SelectItem[] d = {new SelectItem("A", "Analítico"), new SelectItem("S", "Sintático")};
        return d;
    }

    public String getStrTipoRelatorio() {
        return strTipoRelatorio;
    }

    public void setStrTipoRelatorio(String strTipoRelatorio) {
        this.strTipoRelatorio = strTipoRelatorio;
    }
    
    
    public void grabLabRequicao(ValueChangeEvent event){
        this.portal.popMsg(100, false, "");
        if (event != null) {
            if (!((String) event.getNewValue()).equalsIgnoreCase((String) event.getOldValue())) {

                setStrReqCodigo((String) event.getNewValue());
                grabLabRequisicao();

            } else {
                this.portal.popMsg(1, true, "Codigo Repetido....");
            }
        } else {
            this.portal.popMsg(1, true, "Event is NULL..................");
        }
            
    }
    
    
    public void grabLabRequicao(ActionEvent event){
        grabLabRequisicao();
    }
    

    
    
    
    public void grabLabRequisicao(){
        
        labRequisicao = null;
        strReqCodigo = strReqCodigo.replaceAll("\\D", "");
        
        if (strReqCodigo != null && !strReqCodigo.isEmpty()) {

            Long codigo = Long.parseLong(strReqCodigo);

            labRequisicao = (LabRequisicao) OracleHelper.getObject(LabRequisicao.class, codigo,portal.getStrDbName());
            if (labRequisicao != null) {
                if (validatesLabRequisicao(labRequisicao)) {
                    buildMenu4LabRequisicao(labRequisicao);
                }
            } else {
                this.portal.popMsg(1, true, "Numero de Requisicao Inexistente...");
            }

        } else {
            this.portal.popMsg(1, true, "Digite um numero valido de Requisi��o...");
        }
    }
    private boolean validatesLabRequisicao(LabRequisicao lr){
        if(portal != null){
            if(portal.getMapLinkedLabUnidade() != null && !portal.getMapLinkedLabUnidade().isEmpty()){
                    if(portal.getMapLinkedLabUnidade().containsKey(lr.getUniStCodigo())){
                        return true;
                    }else{
                        this.portal.popMsg(1, true, "Você não tem a Unidade desta requisição no seu login...");
                        return false;
                    }
                    
            }else{
                this.portal.popMsg(1, true, "Você não tem Unidades registradas no seu login...");
                return false;
            }
        }else{
            this.portal.popMsg(1, true, "Loge corretamente no sistema....");
            return false;
        }
    }
    
    private void buildMenu4LabRequisicao(LabRequisicao labR) {

        if (setLabRequisicao == null) {setLabRequisicao = new LinkedHashSet<LabRequisicao>();}
        
        if (setLabRequisicao.add(labR)) {
            this.portal.popMsg(1, false, "Requisição Incluida com Sucesso....");
        } else {
            this.portal.popMsg(1, true, "Requisição Repetida....");
        }

    }

    
    public void delLabRequisicao(ActionEvent event ) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValeu = (String) map.get("relatorioexamereqparam");
        if(paramValeu != null   && !setLabRequisicao.isEmpty()){
            for (LabRequisicao lr : setLabRequisicao) {
                if(lr.getReqStCodigo().equalsIgnoreCase(paramValeu)){
                    if(setLabRequisicao.remove(lr)){
                        portal.popMsg(0, false, "Requisição excluida........");
                        break;
                    }
                }
            }
        }else{
            this.portal.popMsg(0, true, "Não há requisições a serem removidas");
        }

    }

    public void makeEstatisticaExameRequisicao() {
        if (setLabRequisicao != null && !setLabRequisicao.isEmpty()) {
            RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
            if (relatorioStorage.blockByPdfUnfinish()) {
                makepdf();
            } else {
                portal.popMsg(0, true, "Não é possivel solicitar mais relatorios enquanto " + ArrayItems.intMaximumRelatorios + " ou mais estiverem ainda sendo feitos.");
            }
        } else {
            this.portal.popMsg(1, true, "A lista de requisições está vazia, escolha pelo menos uma requisição.");
        }

    }
    
//    public void makeEstatisticaExameRequisicao(ActionEvent event){
//        if (setLabRequisicao != null && ! setLabRequisicao.isEmpty()) {
//            RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
//            if (relatorioStorage.blockByPdfUnfinish()) {
//                        makepdf();
//                    } else {
//                        portal.popMsg(0, true, "Não é possivel solicitar mais relatorios enquanto " + ArrayItems.intMaximumRelatorios + " ou mais estiverem ainda sendo feitos.");
//                    }
//            
//            
//            
//        } else {
//            this.portal.popMsg(1, true, "A lista de requisições está vazia, escolha pelo menos uma requisição.");
//        }
//
//    }
    
    
    
    

public void cleanUpEveryThing(ActionEvent event){
//    listMenuItens = null;
    setLabRequisicao = null;
    labRequisicao = null;
    strReqCodigo = null;
//    htmlReqCodigo.requestFocus();
    this.portal.popMsg(0, false, "A tela foi limpa............");
}

    private void makepdf() {
        RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
         //TODO fixing fucking DB Date
        Date dtRightNow = OracleHelper.getDateFromDB(portal.getStrDbName());
//        Date dtRightNow = new Date();
        Map<String,List> mapOrs4Det = new HashMap<String, List>();
        List<Object> list = new ArrayList<Object>();
        for(LabRequisicao lr : setLabRequisicao){
            list.add(lr.getReqStCodigo()); 
        }
        mapOrs4Det.put("reqStCodigo", list);
           PdfDados pd = new PdfDados//("String strPdfName", "String strPdfName", "String strPdfName",mapOrs4Det);
                   ("","",
            "",
            "examerequisicao",
            dtRightNow, dtRightNow,
            null, null,
            null, mapOrs4Det,"","sei lah ",portal.getStrDbName());
           if (strTipoRelatorio.equalsIgnoreCase("A")) {
                pd.setStrTipoRelatorio("analitico");
            } else {
                pd.setStrTipoRelatorio("sintetico");
            }
            
         String fileName = portal.getLabUsuario().getUsuStCodigo()+ "_UNIDADE_REQ_"+ArrayItems.format4PdfName.format(new Date()) + "."+strJasperFormat; 
         pd.setStrPdfName(ArrayItems.strURLPdfPath + fileName);
         pd.setStrDbName(portal.getStrDbName());
         pd.setStrUserNome(portal.getLabUsuario().getUsuStCodigo());
         XStream xstream = new XStream();
//        String strPdfDados = xstream.toXML(pd);
        LabRelatorios r = new LabRelatorios(
                OracleHelper.getLabRelatorioNextId(portal.getStrDbName()),
                dtRightNow, dtRightNow, 
                'L', 
                "vazio", 
                portal.getLabUsuario().getUsuStCodigo(), 
                fileName,
                "relatório em execução \n aguarde.",
                "Estatistica Unidade/Requisicao"
                );
        r.setRelDtTermino(null);
        r.setRelHrTermino(null);
        OracleHelper.saveObject(r,portal.getStrDbName());
        String id = portal.getLabUsuario().getUsuStCodigo()+portal.getStrDbName().toUpperCase();
//        RelatorioStorage.addRelatorioToUser(portal.getStrLogin().toUpperCase(),portal.getStrDbName().toUpperCase(), r);
        relatorioStorage.addAndSorReports(r);
        
        pd.setStrId(r.getRelInCodigo().toString()); 
        PdfDadosSender pds = new PdfDadosSender();
        pds.pdfSender(xstream.toXML(pd));
        
        this.portal.popMsg(0, true, "Relatório enviado com Sucesso.........");
        
    }
    
}
