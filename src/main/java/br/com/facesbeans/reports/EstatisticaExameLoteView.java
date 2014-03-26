/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.reports;

import br.com.facesbeans.jobpush.BlockPdf;
import br.com.facesbeans.jobpush.RelatorioStorage;
import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabLote;
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
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

/** 
 *
 * @author ricardo
 */
@SessionScoped //TODO change to ViewScope
@ManagedBean(name = "estatisticaexameloteViewBean")
public class EstatisticaExameLoteView implements Serializable {

//    private LabLote labLote;
    
    private String strJasperFormat = "pdf";
    
    private PortalView portal;
    private Set<LabLote> setLabLote;
    private Set<LabLote> setLabLotePop;
    private List<LabLote> listLabLotePop;
    private String strLoteCodigo;
    private String strLoteCodigoPop;
    private String strTipoImpressao = "ana";
    private String strDescExame = "normal";
    private String strTipoPesquisa = "lote";
    private String strMsg;
    private String strUsuGeraLote;
    private String strSizeInputPop = "10";
    private String strMensagemLotePop;
    private String strOrdemDoRel = "U";
    private String strDescricaoBotaoPesquisa;// = "Pesquisar algum lote especifico por login, valor ou numero de exames";
    private boolean blFaturado;
    private boolean blConferido;
    private boolean blNaoConferido;
    private boolean blLogo = false;
    private boolean blSaltaPGUniPosto = true;
    private boolean blResumo = true;
    private boolean blRelLotes = true;
    private boolean blSaltaPGResumo = false;
    private boolean blImprRegrasFat = true;
    private boolean blImprValores = true;
    private boolean blpopLote;
    private boolean blPopMsg;
    private boolean blBarMsg;
//    private HtmlInputText htmlLoteCodigo;
    private Date dtBase;

    public EstatisticaExameLoteView() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        
    }

    @PostConstruct
    public void init() {
        if (portal != null) {
        } else {
            try {
                JSFHelper.getExternalContext().redirect("/portal");
            } catch (IOException ex) {
                Logger.getLogger(EstatisticaExameRequisicaoView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Calendar dtCBase = Calendar.getInstance();
         //TODO fixing fucking DB Date
        dtCBase.setTime(OracleHelper.getDateFromDB(portal.getStrDbName()));
//        dtCBase.setTime(new Date());
        dtCBase.add(Calendar.HOUR, -10);
        dtBase = dtCBase.getTime();
    }

    public String getStrJasperFormat() {
        return strJasperFormat;
    }

    public void setStrJasperFormat(String strJasperFormat) {
        this.strJasperFormat = strJasperFormat;
    }
    
    public void  pesquisaPop(){
        Set s = pesquisaPopSet();
        listLabLotePop = new ArrayList<LabLote>(s);
    }
    
    public void pesquisaPopValueChange(ValueChangeEvent event){
//        this.strLoteCodigoPop = event.getNewValue().toString().toUpperCase();
        setStrLoteCodigoPop(event.getNewValue().toString());
        pesquisaPop();
    }
    
    
    private Set pesquisaPopSet() {
        strMensagemLotePop = "";

        List lLote = new ArrayList();
        setLabLotePop = new LinkedHashSet<LabLote>();
        
        if (strTipoPesquisa.equalsIgnoreCase("lote")) {
           LabLote   labLote = (LabLote) OracleHelper.getObject(LabLote.class, strLoteCodigoPop, portal.getStrDbName());
            setLabLotePop.add(labLote);
            return setLabLotePop;
        } else if (strTipoPesquisa.equalsIgnoreCase("dtLote")) {
            Date d = new Date(strLoteCodigoPop);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            lLote = OracleHelper.getListObjectsByAnds_Ors_Dates(LabLote.class, null, null, "lotDtData", new Date(sdf.format(d)), new Date(sdf.format(d)), portal.getStrDbName());
        } else if (strTipoPesquisa.equalsIgnoreCase("usuGeraLote")) {
            if (strLoteCodigoPop.length() >= 4) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("usuStCodigoInclusao", strLoteCodigoPop);
                lLote = OracleHelper.getListObjectsByAnds(LabLote.class, map, 500, "lotStCodigo", false, portal.getStrDbName());
            } else {
                strMensagemLotePop = "Favor digitar mais de 4 caracteres";
                System.out.println(strMensagemLotePop);
            }
        } else if (strTipoPesquisa.equalsIgnoreCase("usuExclLote")) {
            if (strLoteCodigoPop.length() >= 4) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("usuStCodigoExclusao", strLoteCodigoPop);
                lLote = OracleHelper.getListObjectsByAnds(LabLote.class, map, 500, "lotStCodigo", false, portal.getStrDbName());
            } else {
                strMensagemLotePop = "Favor digitar mais de 4 caracteres";
            }
        } else if (strTipoPesquisa.equalsIgnoreCase("usuFechaLote")) {
            if (strLoteCodigoPop.length() >= 4) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("usuStCodigoFechamento", strLoteCodigoPop);
                lLote = OracleHelper.getListObjectsByAnds(LabLote.class, map, 500, "lotStCodigo", false, portal.getStrDbName());
            } else {
                strMensagemLotePop = "Favor digitar mais de 4 caracteres";
            }
        } else if (strTipoPesquisa.equalsIgnoreCase("qtdExa") && strLoteCodigoPop.replaceAll("\\D", "").length() > 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("usuInQtdExames", new Integer(strLoteCodigoPop.replaceAll("\\D", "")));
            lLote = OracleHelper.getListObjectsByAnds(LabLote.class, map, 500, "lotStCodigo", false, portal.getStrDbName());
        } else if (strTipoPesquisa.equalsIgnoreCase("vlrExa") && strLoteCodigoPop.replaceAll("\\D", "").length() > 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("usuFlValorLote", new Float(strLoteCodigoPop.replaceAll("\\D", "")));
            lLote = OracleHelper.getListObjectsByAnds(LabLote.class, map, portal.getStrDbName());
        }
        setLabLotePop.addAll(lLote);
        Collections.sort(lLote);
        setStrLoteCodigoPop("");
        return setLabLotePop;
    }
 
    
    public void grabLotePopFromList(ActionEvent event) {
//        int index = portal.getIntActiveIndex();
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatorioexamelotelablotesparam");
        
        if(paramValue != null){
            if(setLabLote == null){setLabLote = new LinkedHashSet<LabLote>();}
            if(setLabLote.add((LabLote)OracleHelper.getObject(LabLote.class, paramValue, portal.getStrDbName()))){
                portal.popMsg(1, false, "Lote incluido com sucesso......................");
            }else{
                portal.popMsg(0, true, "Lote repetido......................");
            }
            
            
        }
        
        portal.setIntActiveIndex(portal.getMapTabIndex().get("00111").getTabIndex());
    }

    public void grabLabLote(ActionEvent event) {
        if (event != null) {
            grabLabLote();
        }
    }

    public void grabLabLote() {

        strLoteCodigo = strLoteCodigo.replaceAll("\\D", "");
        if (strLoteCodigo != null && !strLoteCodigo.isEmpty()) {
           LabLote   labLote = (LabLote) OracleHelper.getObject(LabLote.class, strLoteCodigo, portal.getStrDbName());
            if (labLote != null) {
                if (validatesLabLote(labLote)) {
                    buildMenu4LabLote(labLote);
                }
            }
        }
    }

    private boolean validatesLabLote(LabLote ll) {
        if (portal != null) {
            if (portal.getMapLinkedLabUnidade() != null && !portal.getMapLinkedLabUnidade().isEmpty()) {
//                LabPaciente lp = (LabPaciente) OracleHelper.getObject(LabPaciente.class, new Long(ll.getPacInCodigo().toString()), portal.getStrDbName());
//                if (lp != null) {
//                    if (portal.getMapLinkedLabUnidade().containsKey(lp.getUniStCodigo())) {
                        return true;
//                    } else {
//                        popMsg(1, true, "tem a Unidade desta  no seu login...");
//                        return false;
//                    }
//                } else {
//                    popMsg(1, true, "Paciente existe...");
//                    return false;
//                }
            } else {
                portal.popMsg(1, true, "Você não tem Unidades registradas no seu login...");
                return false;
            }
        } else {
            portal.popMsg(1, true, "Logue corretamente no sistema....");
            return false;
        }
    }

    private void buildMenu4LabLote(LabLote ll) {
        if (setLabLote == null) {
            setLabLote = new LinkedHashSet<LabLote>();
        }
        if (setLabLote.add(ll)) {
            portal.popMsg(1, false, "Lote Incluido com Sucesso....");
        } else {
            portal.popMsg(1, true, "Lote Repetido....");
        }
        setStrLoteCodigo("");
    }

    public void delLote() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatorioloteparam");
        if (paramValue != null && !setLabLote.isEmpty()) {
            for (LabLote ll : setLabLote) {
                if (ll.getLotStCodigo().equalsIgnoreCase(paramValue)) {
                    setLabLote.remove(ll);
                    break;
                }
            }
        } else {
            portal.popMsg(1, true, "A lista de lotes está vazia, escolha pelo menos um lote.");
        }
    }

    public void pesquisar() {
        if (setLabLote != null) {
            makePdf();
        } else {
            portal.popMsg(1, true, "Lista de lotes inexistente");
        }
    }

    private void makePdf() {
//            String id = portal.getLogin().toUpperCase()+portal.getStrDbName().toUpperCase();
        RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");

        if (relatorioStorage.blockByPdfUnfinish()) {
            if (relatorioStorage.blockByPdfUnfinish()) {
                if (setLabLote != null && !setLabLote.isEmpty()) {
                    if (portal != null) {
                        List<Object> listLotes = new ArrayList<Object>();
                        StringBuffer sb = new StringBuffer();
                        for (LabLote ll : setLabLote) {
                            sb.append(ll.getLotStCodigo() + " | ");
                            listLotes.add(ll.getLotStCodigo());
                        }
                        String strDescricaoRel = ResumeStrings.resumeString(400, "Estatástica de Lote: " + sb.toString().substring(0, sb.length() - 3), "...etc");

                        Map<String, List> mapOrs4Det = new HashMap<String, List>();
                        mapOrs4Det.put("lotStCodigo", listLotes);
                        List<LabUsuarioUnidade> usuUnidades = portal.getLabUsuario().getListLabUnidadeUsuario();
                        List<String> listStrUsuUnidades = null;

                        if (usuUnidades != null) {
                            listStrUsuUnidades = new ArrayList<String>(usuUnidades.size());
                            for (LabUsuarioUnidade labUnidade : usuUnidades) {
                                String strUnidade = labUnidade.getUniStCodigo();
                                listStrUsuUnidades.add(strUnidade);
                            }
                        }
                        mapOrs4Det.put("uniStCodigo", listStrUsuUnidades);

                        PdfDados pd = new PdfDados("", "estatisticalote", strDescricaoRel, mapOrs4Det, portal.getLabUsuario().getUsuStCodigo(), strDescricaoRel, portal.getStrDbName());
                        //TODO fixing fucking DB Date
                        Date rightNow = OracleHelper.getDateFromDB(portal.getStrDbName());
//                        Date rightNow = new Date();

                        String fileName = portal.getStrLogin() + "_ESTATISTICA_LOTE_" + ArrayItems.format4PdfName.format(rightNow) + "." + this.strJasperFormat;
                        pd.setStrPdfName(ArrayItems.strURLPdfPath + fileName);
                        pd.setStrDateFieldName(sb.toString().substring(0, sb.length() - 3));

                        if (strTipoImpressao.equalsIgnoreCase("ana")) {
                            pd.setStrTipoRelatorio("analitico");
                        } else {
                            pd.setStrTipoRelatorio("sintetico");
                        }

                        if (strOrdemDoRel.equalsIgnoreCase("U")) {
                            pd.setStrOrdemDoRel("unidade");
                        } else {
                            pd.setStrOrdemDoRel("convenio");
                        }

                        Map mapAnds4Det = new HashMap();
                        if (blFaturado && !blConferido && !blNaoConferido) {
                            mapAnds4Det.put("mainTitle", "Faturado");
                        } else if (blConferido && !blNaoConferido && !blFaturado) {
                            mapAnds4Det.put("mainTitle", "Conferido");
                        } else if (blNaoConferido && !blFaturado && !blConferido) {
                            mapAnds4Det.put("mainTitle", "Não Conferido");
                        } else if (blFaturado && blConferido && !blNaoConferido) {
                            mapAnds4Det.put("mainTitle", "Faturados e Conferidos");
                        } else if (blFaturado && blNaoConferido && !blConferido) {
                            mapAnds4Det.put("mainTitle", "Faturados e Não Conferidos");
                        } else if (blConferido && blNaoConferido && !blFaturado) {
                            mapAnds4Det.put("mainTitle", "Conferidos e Não Conferidos");
                        } else {
                            mapAnds4Det.put("mainTitle", "Faturados, Conferidos e Não Conferidos");
                        }
                        pd.setMapAnds4Det(mapAnds4Det);
                        pd.setStrDbName(portal.getStrDbName());
                        pd.setStrUserNome(portal.getStrLogin());

                        LabRelatorios r = new LabRelatorios(OracleHelper.getLabRelatorioNextId(portal.getStrDbName()),
                                rightNow,
                                rightNow,
                                'L', "vazio",
                                portal.getLabUsuario().getUsuStCodigo(),
                                fileName,
                                "relatório em execução \n aguarde.",
                                ResumeStrings.resumeString(490, strDescricaoRel, "etc"));
                        OracleHelper.saveObject(r, portal.getStrDbName().toUpperCase());
                        relatorioStorage.addAndSorReports(r);
//                        RelatorioStorage.addRelatorioToUser(portal.getStrLogin().toUpperCase(),portal.getStrDbName().toUpperCase(), r);
                        pd.setStrId(r.getRelInCodigo().toString());
                        XStream xstream = new XStream();
                        String strPdfDados = xstream.toXML(pd);
                        PdfDadosSender pds = new PdfDadosSender();
                        pds.pdfSender(strPdfDados);
                        portal.popMsg(1, false, "Gerando Relatório...");

                    } else {
                        portal.popMsg(1, true, "LMI eh null");
                    }
                } else {
                    portal.popMsg(1, true, "é necessário incluir pelo menos um lote");
                }
            }
        } else {
            portal.popMsg(0, true, "Não é possivel solicitar mais relatorios enquanto " + ArrayItems.intMaximumRelatorios + " ou mais estiverem ainda sendo feitos.");
        }

    }

    
    
    public void marcarTudo() {
        blConferido = true;
        blFaturado = true;
        blImprRegrasFat = true;
        blImprValores = true;
        blLogo = true;
        blNaoConferido = true;
        blRelLotes = true;
        blResumo = true;
        blSaltaPGResumo = true;
        blSaltaPGUniPosto = true;
    }

    public void desmarcarTudo() {
        blConferido = false;
        blFaturado = false;
        blImprRegrasFat = false;
        blImprValores = false;
        blLogo = false;
        blNaoConferido = false;
        blRelLotes = false;
        blResumo = false;
        blSaltaPGResumo = false;
        blSaltaPGUniPosto = false;
    }

    public String getStrDescricaoBotaoPesquisa() {
        return strDescricaoBotaoPesquisa;
    }

    public void setStrDescricaoBotaoPesquisa(String strDescricaoBotaoPesquisa) {
        this.strDescricaoBotaoPesquisa = strDescricaoBotaoPesquisa;
    }

    public String getStrOrdemDoRel() {
        return strOrdemDoRel;
    }

    public void setStrOrdemDoRel(String strOrdemDoRel) {
        this.strOrdemDoRel = strOrdemDoRel;
    }

    public String getStrMensagemLotePop() {
        return strMensagemLotePop;
    }

    public void setStrMensagemLotePop(String strMensagemLotePop) {
        this.strMensagemLotePop = strMensagemLotePop;
    }

    public Set<LabLote> getSetLabLotePop() {
        return setLabLotePop;
    }

    public void setSetLabLotePop(Set<LabLote> setLabLotePop) {
        this.setLabLotePop = setLabLotePop;
    }

    public String getStrLoteCodigo() {
        return strLoteCodigo;
    }

    public void setStrLoteCodigo(String strLoteCodigo) {
        this.strLoteCodigo = strLoteCodigo.trim().toUpperCase();
    }

    public String getStrDescExame() {
        return strDescExame;
    }

    public void setStrDescExame(String strDescExame) {
        this.strDescExame = strDescExame;
    }

    public String getStrTipoImpressao() {
        return strTipoImpressao;
    }

    public void setStrTipoImpressao(String strTipoImpressao) {
        this.strTipoImpressao = strTipoImpressao;
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

    public boolean isBlImprRegrasFat() {
        return blImprRegrasFat;
    }

    public void setBlImprRegrasFat(boolean blImprRegrasFat) {
        this.blImprRegrasFat = blImprRegrasFat;
    }

    public boolean isBlImprValores() {
        return blImprValores;
    }

    public void setBlImprValores(boolean blImprValores) {
        this.blImprValores = blImprValores;
    }

    public boolean isBlLogo() {
        return blLogo;
    }

    public void setBlLogo(boolean blLogo) {
        this.blLogo = blLogo;
    }

    public boolean isBlRelLotes() {
        return blRelLotes;
    }

    public void setBlRelLotes(boolean blRelLotes) {
        this.blRelLotes = blRelLotes;
    }

    public boolean isBlResumo() {
        return blResumo;
    }

    public void setBlResumo(boolean blResumo) {
        this.blResumo = blResumo;
    }

    public boolean isBlSaltaPGResumo() {
        return blSaltaPGResumo;
    }

    public void setBlSaltaPGResumo(boolean blSaltaPGResumo) {
        this.blSaltaPGResumo = blSaltaPGResumo;
    }

    public boolean isBlSaltaPGUniPosto() {
        return blSaltaPGUniPosto;
    }

    public void setBlSaltaPGUniPosto(boolean blSaltaPGUniPosto) {
        this.blSaltaPGUniPosto = blSaltaPGUniPosto;
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

    public boolean isBlpopLote() {
        return blpopLote;
    }

    public void setBlpopLote(boolean blpopLote) {
        this.blpopLote = blpopLote;
    }

    public Set<LabLote> getSetLabLote() {
        return setLabLote;
    }

    public void setSetLabLote(Set<LabLote> setLabLote) {
        this.setLabLote = setLabLote;
    }

    public String getStrLoteCodigoPop() {
        return strLoteCodigoPop;
    }

    public void setStrLoteCodigoPop(String strLoteCodigoPop) {
        this.strLoteCodigoPop = strLoteCodigoPop.trim().toUpperCase();
    }

    public String getStrUsuGeraLote() {
        return strUsuGeraLote;
    }

    public void setStrUsuGeraLote(String strUsuGeraLote) {
        this.strUsuGeraLote = strUsuGeraLote;
    }

    public String getStrTipoPesquisa() {
        return strTipoPesquisa;
    }

    public void setStrTipoPesquisa(String strTipoPesquisa) {
        this.strTipoPesquisa = strTipoPesquisa;
        if (this.strTipoPesquisa.equalsIgnoreCase("lote") || this.strTipoPesquisa.equalsIgnoreCase("dtLote") || this.strTipoPesquisa.equalsIgnoreCase("qtdExa") || this.strTipoPesquisa.equalsIgnoreCase("vlrExa")) {
            this.strSizeInputPop = "8";
        } else if (this.strTipoPesquisa.equalsIgnoreCase("usuGeraLote") || this.strTipoPesquisa.equalsIgnoreCase("usuExclLote") || this.strTipoPesquisa.equalsIgnoreCase("usuFechaLote")) {
            this.strSizeInputPop = "20";
        }
    }

    public String getStrSizeInputPop() {
        return strSizeInputPop;
    }

    public void setStrSizeInputPop(String strSizeInputPop) {
        this.strSizeInputPop = strSizeInputPop;
    }

    public Date getDtBase() {
        return dtBase;
    }

    public void setDtBase(Date dtBase) {
        this.dtBase = dtBase;
    }

    public PortalView getPortal() {
        return portal;
    }

    public void setPortal(PortalView portal) {
        this.portal = portal;
    }

    public List<LabLote> getListLabLotePop() {
        return listLabLotePop;
    }

    public void setListLabLotePop(List<LabLote> listLabLotePop) {
        this.listLabLotePop = listLabLotePop;
    }
    
    public void cleanUpEveryThing(){
        if(setLabLote != null){
           setLabLote.clear(); 
        }
        
        if(setLabLotePop != null){
           setLabLotePop.clear(); 
        }
    }
    
}
