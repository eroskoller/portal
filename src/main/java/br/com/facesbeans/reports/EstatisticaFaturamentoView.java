/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.reports;

import br.com.facesbeans.jobpush.BlockPdf;
import br.com.facesbeans.jobpush.RelatorioStorage;
import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.*;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.IFramePage;
import br.com.portal.beans.login.PortalView;


import br.com.utils.pdfmaker.PdfDados;
import br.com.utils.pdfmaker.PdfDadosSender;
import br.com.utils.tipstricks.DateRange;
import br.com.utils.tipstricks.ResumeStrings;


import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name = "estatisticafaturamentoViewBean")
public class EstatisticaFaturamentoView implements Serializable {

    private PortalView portal;
    private Integer rating;
    
    private String strJasperFormat = "pdf";
    
    private String strCodigoUnidade;
    private String strCodigoConvenio;
    private String strTipoRelatorio = "A";
    private String strOrdemDoRel = "U";
    private String strPfeStCodigo = null;
    private boolean blPeriodoDeFechamento = false;
    private boolean blDetalhadoPorExames = false;
    private boolean blConferido = false;
    private boolean blFaturado = false;
    private boolean blNaoConferido = false;
    private Date dtInicioQuery = null;//OracleHelper.getDateFromDB();
    private Date dtFinalQuery = null;//OracleHelper.getDateFromDB();
    private LabUnidade labUnidade;
    private Set<LabUnidade> listSetLabUnidade = new LinkedHashSet<LabUnidade>();
    private LabConvenio labConveio;
    private Set<LabConvenio> listSetLabConvenio = new LinkedHashSet<LabConvenio>();
    private boolean blBarMsg = false;
    private boolean blPopMsg = false;
    private boolean blPopUnidade = false;
    private boolean blPopConvenio = false;
    private SelectItem[] itensPeriodoFechamento = null;
    private String strMsg = "";
    private String strStylePaddingLeftSelecaoExames = "100px;";
    private List<LabConvenio> listLabConvenioPop = null;

    public EstatisticaFaturamentoView() {
        super();
    }

    
    
    
    @PostConstruct
    public void init() {

        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
         //TODO fixing fucking DB Date
//        dtInicioQuery = OracleHelper.getDateFromDB(portal.getStrDbName());
//        dtFinalQuery = OracleHelper.getDateFromDB(portal.getStrDbName());
        dtInicioQuery = new Date();
        dtFinalQuery = new Date();


        if (portal != null && portal.getLabUsuario() != null) {
            rating = portal.returnIframeBaseOnIndex(portal.getIntActiveIndex()).getRating();
        } else {
            try {
                JSFHelper.getExternalContext().redirect("/portal");
            } catch (IOException ex) {
                Logger.getLogger(EstatisticaExameRequisicaoView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    
    
    
    public boolean isBlDetalhadoPorExames() {
        return blDetalhadoPorExames;
    }

    public void setBlDetalhadoPorExames(boolean blDetalhadoPorExames) {
        
        this.blDetalhadoPorExames = blDetalhadoPorExames;
        
        if(blDetalhadoPorExames && this.strTipoRelatorio.equalsIgnoreCase("S")){
            System.out.println("----------------  Inside setBlDetalhadoPorExames >>>>>");
            this.strTipoRelatorio = "A";
            this.portal.popMsg(1, true, "A Estatística não pode ser Sintática quando o 'Det. por Ex' estiver marcado ' ... marcando Estatistica como Analítica..");
        }
        
    }

    public String getStrPfeStCodigo() {
        return strPfeStCodigo;
    }

    public void setStrPfeStCodigo(String strPfeStCodigo) {
        this.strPfeStCodigo = strPfeStCodigo;
    }

    public boolean isBlConferido() {
        return blConferido;
    }

    public void setBlConferido(boolean blConferido) {
        this.blConferido = blConferido;
    }

    public boolean isBlFaturado() {
        return blFaturado;
    }

    public void setBlFaturado(boolean blFaturado) {
        this.blFaturado = blFaturado;
    }

    public boolean isBlNaoConferido() {
        return blNaoConferido;
    }

    public void setBlNaoConferido(boolean blNaoConferido) {
        this.blNaoConferido = blNaoConferido;
    }

    public boolean isBlPeriodoDeFechamento() {
        return blPeriodoDeFechamento;
    }

    public String getStrJasperFormat() {
        return strJasperFormat;
    }

    public void setStrJasperFormat(String strJasperFormat) {
        this.strJasperFormat = strJasperFormat;
    }

    public void setBlPeriodoDeFechamento(boolean blPeriodoDeFechamento) {
        if(blPeriodoDeFechamento){
            strStylePaddingLeftSelecaoExames = "5px;";
        }else{
            strStylePaddingLeftSelecaoExames = "100px;";
        }
        this.blPeriodoDeFechamento = blPeriodoDeFechamento;
    }

    public String getStrStylePaddingLeftSelecaoExames() {
        return strStylePaddingLeftSelecaoExames;
    }

    public void setStrStylePaddingLeftSelecaoExames(String strStylePaddingLeftSelecaoExames) {
        this.strStylePaddingLeftSelecaoExames = strStylePaddingLeftSelecaoExames;
    }
    
    public List<LabConvenio> getListLabConvenioPop() {
        if(listLabConvenioPop == null  && portal != null  && portal.getLabUsuario() != null   && portal.getLabUsuario().getUsuStCodigo() != null){
            listLabConvenioPop = this.getListLabConvenio(portal.getLabUsuario().getUsuStCodigo(), portal.getStrDbName());
        }
        return listLabConvenioPop;
    }

    public void setListLabConvenioPop(List<LabConvenio> listLabConvenioPop) {
        this.listLabConvenioPop = listLabConvenioPop;
    }

    public boolean isBlPopUnidade() {
        return blPopUnidade;
    }

    public void setBlPopUnidade(boolean blPopUnidade) {
        this.blPopUnidade = blPopUnidade;
    }

    public LabConvenio getLabConveio() {
        return labConveio;
    }

    public void setLabConveio(LabConvenio labConveio) {
        this.labConveio = labConveio;
    }

    public Set<LabConvenio> getListSetLabConvenio() {
        return listSetLabConvenio;
    }

    public void setListSetLabConvenio(Set<LabConvenio> listSetLabConvenio) {
        this.listSetLabConvenio = listSetLabConvenio;
    }

    public String getStrCodigoConvenio() {
        return strCodigoConvenio;
    }

    public void setStrCodigoConvenio(String strCodigoConvenio) {
        this.strCodigoConvenio = strCodigoConvenio;
    }

    public String getStrOrdemDoRel() {
        return strOrdemDoRel;
    }

    public void setStrOrdemDoRel(String strOrdemDoRel) {
        this.strOrdemDoRel = strOrdemDoRel;
    }

    public String getStrTipoRelatorio() {
        return strTipoRelatorio;
    }

    public void setStrTipoRelatorio(String strTipoRelatorio) {
        this.strTipoRelatorio = strTipoRelatorio;
        if(strTipoRelatorio.equalsIgnoreCase("S")  && blDetalhadoPorExames){
            System.out.println("   setStrTipoRelatorio   ");
            blDetalhadoPorExames = false;
            this.portal.popMsg(1, true, "A Estatística não pode ser Sintática quando o 'Det. por Ex' estiver marcado '");
        }

    }

    public SelectItem[] getTipoRelatorio() {
        SelectItem[] d = {new SelectItem("A", "Analítico"), new SelectItem("S", "Sintético")};
        return d;
    }

    public SelectItem[] getOrdemRelatorio() {
        SelectItem[] d = {new SelectItem("U", "Unidade"), new SelectItem("C", "Convênio")};
        return d;
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

    public Date getDtFinalQuery() {
        return dtFinalQuery;
    }

    public void setDtFinalQuery(Date dtFinalQuery) {
        this.dtFinalQuery = dtFinalQuery;
    }

    public Date getDtInicioQuery() {
        return dtInicioQuery;
    }

    public void setDtInicioQuery(Date dtInicioQuery) {
        this.dtInicioQuery = dtInicioQuery;
    }

    public Set<LabUnidade> getListSetLabUnidade() {
        return listSetLabUnidade;
    }

    public void setListSetLabUnidade(Set<LabUnidade> listSetLabUnidade) {
        this.listSetLabUnidade = listSetLabUnidade;
    }

    public String getStrCodigoUnidade() {
        return strCodigoUnidade;
    }

    public void setStrCodigoUnidade(String strCodigoUnidade) {
        this.strCodigoUnidade = strCodigoUnidade;
    }

    public String getStrMsg() {
        return strMsg;
    }

    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }

    public LabUnidade getLabUnidade() {
        return labUnidade;
    }

    public void setLabUnidade(LabUnidade labUnidade) {
        this.labUnidade = labUnidade;
    }

    public boolean isBlPopConvenio() {
        return blPopConvenio;
    }

    public void setBlPopConvenio(boolean blPopConvenio) {
        this.blPopConvenio = blPopConvenio;
    }
    
    public List<LabConvenio>   getListLabConvenio(){
        if(listSetLabConvenio != null && !listSetLabConvenio.isEmpty()){
            ArrayList<LabConvenio> list = new ArrayList<LabConvenio>();
            for(LabConvenio lc : listSetLabConvenio){
                list.add(lc);
            }
            
            return  list;
        }else{
            return  new ArrayList<LabConvenio>();
        }
    }

    public void grabLabUnidade(ValueChangeEvent event) {
        if (event != null) {
            if (!((String) event.getNewValue()).equalsIgnoreCase((String) event.getOldValue())) {

                setStrCodigoUnidade((String) event.getNewValue().toString().toUpperCase());
                grabLabUnidade();

            } else {
                this.portal.popMsg(1, true, "Codigo Repetido....");
            }
        } else {
            this.portal.popMsg(1, true, "Event is NULL..................");
        }

    }

    public void grabLabUnidade() {
        if (portal == null) {
            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        }

        labUnidade = null;

//        strCodigoUnidade = strReqCodigo.replaceAll("\\D", "");

        if (strCodigoUnidade != null && !strCodigoUnidade.isEmpty()) {

            strCodigoUnidade = strCodigoUnidade.toUpperCase();

            if (portal.getMapLinkedLabUnidade().containsKey(strCodigoUnidade)) {
                labUnidade = (LabUnidade) OracleHelper.getObject(LabUnidade.class, strCodigoUnidade, portal.getStrDbName());
                if (labUnidade != null) {
                    strCodigoUnidade = "";
                    buildMenu4LabUnidade(labUnidade);
                } else {
                    this.portal.popMsg(1, true, "Vc não tem está unidade ou Unidade Inexistente...");
                }

            } else {
                this.portal.popMsg(1, true, "Vc não tem está unidade ou Unidade Inexistente...");
            }

        }
    }

    private void buildMenu4LabUnidade(LabUnidade labU) {

        if (listSetLabUnidade == null) {
            listSetLabUnidade = new LinkedHashSet<LabUnidade>();
        }

        if (listSetLabUnidade.add(labU)) {
            this.portal.popMsg(100, false, "");

        } else {
            this.portal.popMsg(1, true, "Unidade Repetida....");
        }

    }

    public void delLabUnidade(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatoriofaturamentoparamunidade");
        if (paramValue != null && !this.listSetLabUnidade.isEmpty()) {
            for (LabUnidade lu : listSetLabUnidade) {
                if (lu.getUniStCodigo().equalsIgnoreCase(paramValue)) {
                    if(listSetLabUnidade.remove(lu)){
                        portal.popMsg(0, false, "Unidade excluida.........");
                        break;
                    }

                }
            }
        } else {
            this.portal.popMsg(0, true, "Não há unidades a serem removidas");
        }

    }

    public void grabUnidadeFromList(ActionEvent event) {
        
        int index = portal.getIntActiveIndex();
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatorioproducaopoplistlabunidadesparam");
        if(paramValue != null){
            LabUnidade lu = portal.getMapLinkedLabUnidade().get(paramValue);
            
            if(this.listSetLabUnidade.add(lu)){
                this.portal.popMsg(1, false, "Unidade incluida.................");
            }else{
                this.portal.popMsg(1, true, "Unidade repetida.................");
            }
        }
        portal.setIntActiveIndex(portal.getMapTabIndex().get("00067").getTabIndex());
    }

    public void grabLabConvenio(ValueChangeEvent event) {
        if (event != null) {
            if (!((String) event.getNewValue()).equalsIgnoreCase((String) event.getOldValue())) {

                setStrCodigoConvenio((String) event.getNewValue());
                grabLabConvenio();

            } else {
                this.portal.popMsg(1, true, "Codigo Repetido....");
            }
        } else {
            this.portal.popMsg(1, true, "Event is NULL..................");
        }

    }

    public void grabLabConvenio() {
        if (portal == null) {
            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        }

        labConveio = null;


        if (strCodigoConvenio != null && !strCodigoConvenio.isEmpty()) {

            strCodigoConvenio = strCodigoConvenio.toUpperCase().trim();
            LabUsuarioConvenioPK pk = new LabUsuarioConvenioPK();
            pk.setConStCodigo(new LabConvenio(strCodigoConvenio));
            pk.setUsuStCodigo(portal.getLabUsuario().getUsuStCodigo());
            LabUsuarioConvenio luc = (LabUsuarioConvenio) OracleHelper.getObject(LabUsuarioConvenio.class, pk, portal.getStrDbName());
            if (luc != null) {
                labConveio = luc.getConStCodigo();
                if (labConveio != null) {
                    buildMenu4LabConvenio(labConveio);
                } else {
                    this.portal.popMsg(1, true, "Convênio Inexistente...");
                }
            } else {
                this.portal.popMsg(1, true, "Convênio Inexistente...ou Você não tem permissão para usar este Convenio...");
            }


        }
    }

    private void buildMenu4LabConvenio(LabConvenio labC) {

        if (listSetLabConvenio == null) {
            listSetLabConvenio = new LinkedHashSet<LabConvenio>();
        }

        if (this.listSetLabConvenio.add(labC)) {
            this.portal.popMsg(1, false, "Requisição Incluida com Sucesso....");
        } else {
            this.portal.popMsg(1, true, "Requisição Repetida....");
        }

    }

    public void delLabConvenio(ActionEvent event) {

        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValeu = (String) map.get("relatorioproducaoconvenioparam");
        if (paramValeu != null && !listSetLabConvenio.isEmpty()) {
            for (LabConvenio lc : listSetLabConvenio) {
                if (lc.getConStCodigo().equalsIgnoreCase(paramValeu)) {
                    if(listSetLabConvenio.remove(lc)){
                        portal.popMsg(0, false, "Convênio excluido...");
                        break;
                    }
                }
            }
        } else {
            this.portal.popMsg(0, true, "Não há requisições a serem removidas");
        }

    }

    public void grabConvenioFromList(ActionEvent event) {

        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatorioproducaopoplistlabconvenioparam");
        if (paramValue != null) {
            getListLabConvenioPop();
            if (listLabConvenioPop != null && !listLabConvenioPop.isEmpty()) {

                for (LabConvenio lc : listLabConvenioPop) {
                    if (lc.getConStCodigo().equalsIgnoreCase(paramValue)) {
                        if (listSetLabConvenio.add(lc)) {
                            this.portal.popMsg(1, false, "Convenio incluido.................");
                        } else {
                            this.portal.popMsg(1, true, "Convenios repetido.........");
                        }
                        break;
                    }
                }

            } else {
                this.portal.popMsg(1, true, "Você não tem Convenios registrados no seu login..........");
            }

        }
        portal.setIntActiveIndex(portal.getMapTabIndex().get("00067").getTabIndex());
    }
    

    public void validateDateRange(DateSelectEvent event) {

        
        if (!DateRange.rangeVerifierMonths(ArrayItems.intMaximumBillingMonths, this.dtInicioQuery, this.dtFinalQuery)) {
            this.portal.popMsg(2, true, "O intervalo entre datas é de no maximo " + ArrayItems.intMaximumBillingMonths + " mes.");
        } else {
            this.portal.popMsg(1000, false, "");
        }
    }

    public void makePdf() {

        RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");

        if (relatorioStorage.blockByPdfUnfinish()) {

            if (portal == null) {
                portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
            }

            if (DateRange.rangeVerifierMonths(ArrayItems.intMaximumBillingMonths, dtInicioQuery, dtFinalQuery)) {

                if (dtInicioQuery != null && dtFinalQuery != null) {

                    Calendar calStartOfTheDay = Calendar.getInstance();
                    calStartOfTheDay.setTime(dtInicioQuery);
                    calStartOfTheDay.set(dtInicioQuery.getYear() + 1900, dtInicioQuery.getMonth(), dtInicioQuery.getDate(), 00, 00, 00);
                    dtInicioQuery = calStartOfTheDay.getTime();

                    Calendar calEndOfTheDay = Calendar.getInstance();
                    calEndOfTheDay.setTime(dtFinalQuery);
                    calEndOfTheDay.set(dtFinalQuery.getYear() + 1900, dtFinalQuery.getMonth(), dtFinalQuery.getDate(), 23, 59, 59);
                    dtFinalQuery = calEndOfTheDay.getTime();

                }


//            if (DateRange.timerInterval(ArrayItems.intMinimumSec, portal.getDtBase(), OracleHelper.getDateFromDB(portal.getStrDbName())) || true) {
                if (true) {
                    portal.setDtBase(new Date());
                    if (relatorioStorage.blockByPdfUnfinish() || true) {

                        boolean blAutoUnidade = false;

                        if (listSetLabUnidade.isEmpty()) {
                            listSetLabUnidade = new LinkedHashSet<LabUnidade>(10);
                            Iterator iter = portal.getMapLinkedLabUnidade().entrySet().iterator();
                            while (iter.hasNext()) {
                                Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                                listSetLabUnidade.add((LabUnidade) pair.getValue());
                            }
                            blAutoUnidade = true;
                        }

                        boolean blAutoConvenio = false;
                        if (listSetLabConvenio.isEmpty()) {

                            List<LabConvenio> listC = getListLabConvenioPop();
                            if (listC != null) {
                                listSetLabConvenio = new LinkedHashSet<LabConvenio>(listC.size());
                                for (LabConvenio lc : listC) {
                                    listSetLabConvenio.add(lc);
                                }
                                blAutoConvenio = true;
                            }


                        }

                        //TODO fixing fucking DB Date
                    Date dtRightNow = OracleHelper.getDateFromDB(portal.getStrDbName());
//                        Date dtRightNow = new Date();


//                            listSetLabUnidade != null && !listSetLabUnidade.isEmpty()) {;

                        Map<String, Object> mapAnd4Det = new HashMap<String, Object>();
                        mapAnd4Det.put("derChFatura", new Character('S'));

                        Map<String, List> mapOrs4Det = new HashMap<String, List>();
                        List<Object> listU = new ArrayList<Object>();
                        List<Object> listC = new ArrayList<Object>();

                        String strDescricaoRelatorio = "Estatástica de Faturamento: ";

                        if (!listSetLabUnidade.isEmpty()) {
                            for (LabUnidade lu : listSetLabUnidade) {
                                listU.add(lu.getUniStCodigo());
                                if (!blAutoUnidade) {
                                    strDescricaoRelatorio = strDescricaoRelatorio + " | " + lu.getUniStCodigo() + "- " + lu.getUniStDescricaoResumida7();
                                }
                            }
                            if (blAutoUnidade) {
                                strDescricaoRelatorio = strDescricaoRelatorio + " Todas as suas Unidades.";
                            }
                        } else {
                            strDescricaoRelatorio = strDescricaoRelatorio + " Todas as Unidades ";
                        }

                        if (listSetLabConvenio != null) {
//                                System.out.println("listSetLabConvenio is not null...........");
                            for (LabConvenio lc : listSetLabConvenio) {
                                listC.add(lc.getConStCodigo());
                                if (!blAutoConvenio) {
                                    strDescricaoRelatorio = strDescricaoRelatorio + " | " + lc.getConStCodigo() + "- " + lc.getConStDescricaoResumida();
                                }
                            }

                            if (blAutoConvenio) {
                                strDescricaoRelatorio = strDescricaoRelatorio + " Todos os seus Convènios";
                            }

                        } else {
                            strDescricaoRelatorio = strDescricaoRelatorio + " Todos os Convênios..";
                        }

                        List<Object> listLegStCodigoFat = new ArrayList<Object>();

                        if (!blPeriodoDeFechamento) {
                            if (blFaturado) {
                                listLegStCodigoFat.add("FAT");
                            }
                            if (blConferido) {
                                listLegStCodigoFat.add("CON");
                            }
                            if (blNaoConferido) {
                                listLegStCodigoFat.add("NCO");
                            }
                            if (listLegStCodigoFat != null && listLegStCodigoFat.size() > 0) {
                                mapOrs4Det.put("legStCodigoFat", listLegStCodigoFat);
                            }
                        } else {
                            mapAnd4Det.put("pfeStCodigo", strPfeStCodigo);
                        }

                        if (blDetalhadoPorExames) {
                            mapAnd4Det.put("exame", "exame");
                        }


                        mapOrs4Det.put("uniStCodigo", listU);
                        mapOrs4Det.put("conStCodigo", listC);
//                        mapOrs4Det.put("legStCodigo", listLegStCodigo);
                        PdfDados pd = new PdfDados // (null, null, labUsuario.getUsuStCodigo(),dtInicioQuery, dtFinalQuery, mapOrs4Det,"estatisticafaturamento" , null);
                                ("", "", "", "estatisticafaturamento", dtInicioQuery, dtFinalQuery, null, null, mapAnd4Det, mapOrs4Det, "", portal.getLabUsuario().getUsuStCodigo(), portal.getStrDbName());
                        if (strTipoRelatorio.equalsIgnoreCase("A")) {
                            pd.setStrTipoRelatorio("analitico");
                        } else {
                            pd.setStrTipoRelatorio("sintetico");
                        }
                        if (strOrdemDoRel.equalsIgnoreCase("U")) {
                            pd.setStrOrdemDoRel("unidade");
                        } else {
                            pd.setStrOrdemDoRel("convenio");
                        }

                        String fileName = portal.getLabUsuario().getUsuStCodigo() + "_ESTATISTICA_FATURAMENTO_" + ArrayItems.format4PdfName.format(new Date()) + "." + strJasperFormat;
//                            pd.setStrPdfName("/home/eros/WebContainers/glassfish-3.1/glassfish/domains/domain1/applications/icehell/icerel_war/pdfshop/" + fileName);
                        pd.setStrPdfName(ArrayItems.strURLPdfPath + fileName);



                        XStream xstream = new XStream();
                        String strPdfDados = null;
                        LabRelatorios r = new LabRelatorios(
                                OracleHelper.getLabRelatorioNextId(portal.getStrDbName()),
                                dtRightNow, dtRightNow,
                                'L',
                                "vazio",
                                portal.getLabUsuario().getUsuStCodigo(),
                                fileName,
                                "relatório em execução \n aguarde.", ResumeStrings.resumeString(490, strDescricaoRelatorio, "etc"));
                        r.setRelClXml("vazio");
                        r.setRelDtTermino(null);
                        r.setRelHrTermino(null);
                        OracleHelper.saveObject(r, portal.getStrDbName());
                        relatorioStorage.addAndSorReports(r);

//                            RelatorioStorage.getMapRelStorage().get(lmi.getUsuario().getUsuStCodigo()).add(r);
//                            RelatorioStorage.addRelatorioToUser(lmi.getLogin().toUpperCase(),lmi.getStrDbName().toUpperCase(), r);
                        pd.setStrId(r.getRelInCodigo().toString());
                        pd.setStrDbName(portal.getStrDbName());
                        pd.setStrUserNome(portal.getLabUsuario().getUsuStCodigo());
                        strPdfDados = xstream.toXML(pd);
                        PdfDadosSender pds = new PdfDadosSender();
                        pds.pdfSender(strPdfDados);

                        this.portal.popMsg(10, false, "");

                        if (blAutoUnidade) {
                            listSetLabUnidade.clear();
                        }
                        if (blAutoConvenio) {
                            listSetLabConvenio.clear();
                        }

                    } else {
                        this.portal.popMsg(1, true, "Não é possivel solicitar mais relatorios enquanto " + ArrayItems.intMaximumRelatorios + " ou mais estiverem ainda sendo feitos.");
                    }

                } else {
                    this.portal.popMsg(1, true, "Não é permitido clicar repetidamente.....espere por no minimo " + ArrayItems.intMinimumSec + " segundos...");
                }


            } else {
                this.portal.popMsg(1, true, "O intervalo entre datas é de no maximo " + ArrayItems.intMaximumBillingMonths + " mês");
            }

        } else {
            portal.popMsg(0, true, "Não é possivel solicitar mais relatorios enquanto " + ArrayItems.intMaximumRelatorios + " ou mais estiverem ainda sendo feitos.");
        }







    }

    public void cleanUpEveryThing() {
        listSetLabConvenio.clear();
        listSetLabUnidade.clear();
        dtInicioQuery = new Date();
        dtFinalQuery = new Date();
    }

    public void popUnidade() {
        if (portal == null) {
            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        }
        this.portal.popMsg(1000, false, "");
//        if(lmi != null && lmi.getListUnidades() != null){

        if (portal == null) {
            System.out.println("LMI is null");
        } else if (portal.getMapLinkedLabUnidade().isEmpty()) {
            System.out.println("   lmi.getUnidades() == null   ");
        }

        if (portal.getMapLinkedLabUnidade() != null && !portal.getMapLinkedLabUnidade().isEmpty()) {
            blPopUnidade = true;
        } else {
            this.portal.popMsg(1, true, "Você não está logado ou não tem Unidades...");
        }


    }

    public void closePopUnidade() {
        blPopUnidade = false;
    }

    public void popConvenio() {
        if (portal == null) {
            portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        }
        this.portal.popMsg(1000, false, "");
//        List<LabUsuarioConvenio> listLUC = 
//                OracleHelper.getListOfObjectByKeyEq(LabUsuarioConvenio.class, "usuStCodigo", lmi.getUsuario().getUsuStCodigo(), "conStCodigo", true,lmi.getStrDbName());
        listLabConvenioPop = this.getListLabConvenio(portal.getLabUsuario().getUsuStCodigo(), portal.getStrDbName());
        if (listLabConvenioPop != null && !listLabConvenioPop.isEmpty()) {
            blPopConvenio = true;
        } else {
            this.portal.popMsg(1, true, "Você não tem Convenios registrados em seu usuário..............");
        }
    }

    public void closePopConvenio() {
        blPopConvenio = false;
        listLabConvenioPop.clear();
    }

    public SelectItem[] getItensPeriodoFechamento() {
        if (itensPeriodoFechamento == null) {
            List<LabPeriodoFechamento> list =
                    OracleHelper.getListOfObjectByKeyEq(LabPeriodoFechamento.class, "pfeChAtivo", new Character('S'), "pfeStAnome", false, portal.getStrDbName());
            if (list != null && list.size() > 0) {
                itensPeriodoFechamento = new SelectItem[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    LabPeriodoFechamento lp = list.get(i);
                    itensPeriodoFechamento[i] = new SelectItem(lp.getPfeStCodigo(), lp.getPfeStDescricao());
                }
            }
        }
        return itensPeriodoFechamento;
    }

    private List<LabConvenio> getListLabConvenio(String usuStCodigo, String strDbName) {


        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        List result;
        List<LabConvenio> list = new ArrayList<LabConvenio>(30);
        String strQuery =
                " select uc.con_St_Codigo,con.con_St_Descricao"
                + " \n from  Lab_UsuarioConvenio uc, Lab_Convenio con"
                + " \n where uc.con_St_Codigo = con.con_St_Codigo "
                + "\n  and uc.usu_St_Codigo = :usuStCodigo "
                + "\n order by uc.CON_ST_CODIGO asc";


        try {
            org.hibernate.Query query = session.createSQLQuery(strQuery);
            query.setString("usuStCodigo", usuStCodigo);

            result = query.list();

            if (result != null && !result.isEmpty()) {
                for (int i = 0; i < result.size(); i++) {
                    Object[] tupla = (Object[]) result.get(i);
                    LabConvenio lc = new LabConvenio((String) tupla[0], (String) tupla[1]);
                    list.add(lc);
                }
            }

            tx.commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return list;

    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    public Integer getRating(){
        return rating;
        
    }
    
    
}
