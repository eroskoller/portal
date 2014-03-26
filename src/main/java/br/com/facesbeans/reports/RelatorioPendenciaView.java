/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.reports;

import br.com.facesbeans.jobpush.RelatorioStorage;
import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabExame;
import br.com.hibernate.entities.LabLocal;
import br.com.hibernate.entities.LabLocalPK;
import br.com.hibernate.entities.LabOrigem;
import br.com.hibernate.entities.LabOrigemPK;
import br.com.hibernate.entities.LabRelatorios;
import br.com.hibernate.entities.LabSetor;
import br.com.hibernate.entities.LabSetorPK;
import br.com.hibernate.entities.LabUnidade;
//import br.com.hibernate.entities.mysql.RelatorioDados;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
//import br.com.hibernate.utils.mysql.MySQLHelper;

import br.com.utils.pdfmaker.PdfDados;
import br.com.utils.pdfmaker.PdfDadosSender;
import br.com.utils.tipstricks.DateRange;
import br.com.utils.tipstricks.ZerosFabrica;
import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
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
import org.primefaces.component.effect.Effect;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name = "relatorioPendenciaViewBean")
public class RelatorioPendenciaView implements Serializable {

    private Integer rating ;
    
    private String strJasperFormat = "pdf";
    
    public static final String AUCTION_RENDER_GROUP = "auctionRenderGroup";
    
    
    private PortalView portal;
//    private Date dtBase;
    private boolean blMarcarTudo;
//    private int intRange = 1;
    private String strMsg;
    private boolean blPopMsg;
    private boolean blBarMsg;
//    private List<ServicoDocumento> listServicoDocumentos;
//    private PieChartModel livePieModel;   
//    private LabUsuario labUsuario;
    private String strOptionQuery;
    private Date dtInicioQuery;
    private Date dtFinalQuery;
    private String strDateType = "dr";
    private String strUniStCodigoCadastro;
    private LabUnidade labUnidadeCadastro;
    private boolean blPopLabUnidadeCadastro;
    private String strUniStCodigoExcucao;
    private LabUnidade labUnidadeExcucao;
//    private List<LabUnidade> listUnidades;
    private boolean blPopLabUnidadeExecucao;
    private String strOriStCodigo;
    private LabOrigem labOrigem;
    private Set<LabOrigem> listLabOrigem;
    private List<LabOrigem> listLabOrigemPop;
    private boolean blPopLabOrigem;
//    private MenuModel menuLabOrigem = new org.primefaces.model.DefaultMenuModel();
    private String strLocStCodigo;
    private LabLocal labLocal;
    private Set<LabLocal> listLabLocal;
    private List<LabLocal> listLabLocalPop;
    private boolean blPopLabLocal;
//    private MenuModel menuLabLocal = new org.primefaces.model.DefaultMenuModel();
//    private MenuBar menuLabLocal;
    private String strSetStCodigo;
    private LabSetor labSetor;
    private Set<LabSetor> listLabSetor;
    private List<LabSetor> listLabSetorPop;
    private boolean blPopLabSetor;
//    private MenuModel menuLabSetor = new org.primefaces.model.DefaultMenuModel();
    private String strExaStCodigo;
    private LabExame labExame;
    private Set<LabExame> listLabExame;
    private boolean blPopLabExame;
//    private MenuModel menuLabExame = new org.primefaces.model.DefaultMenuModel();
//    private List<RelatorioDados> listRelatorioDados;
    private boolean blCadastro = true;
    private boolean blConfCad = true;
    private boolean blPreTriado = true;
    private boolean blTriagem = true;
    private boolean blTrIadoAP = true;
    private boolean blRecSetor;
    private boolean blPendente = true;
    private boolean blCompleto;
    private boolean blIngresso;
    private boolean blLibTec;
    private boolean blAssinado;
    private boolean blConfirma;
    private boolean blCancelado;
    private boolean blArmazenado;
    private boolean blDescartado;
    private boolean blImpresso;
    private boolean bl2Amostra;
    private boolean blLaudado;
    private boolean blNaoColetado;
    private boolean blDeletado;
    private boolean blDevMat;
    private boolean blRemarcado;
    private boolean blPreConf;
    private boolean blOmitidos;
    private boolean blParcial;
//   private boolean blnNaoConfFat;
//   private boolean blFaturados;
//   private boolean blConConfFat;
    private String strLegStCodigoFat = "";
//    @ManagedProperty("#{letMeInBean}")
//    private RelatorioPush relatorioPush;
//    private RelatorioStorage relStorage;
    private boolean blShowTabelaRel = false;

//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
//            SimpleDateFormat formatDefault = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//dd/MM/yyyy HH:MM:ss
    public RelatorioPendenciaView() {


        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");

    }

    @PostConstruct
    public void init() {

        if (portal != null && portal.getLabUsuario() != null) {

            
             //TODO fixing fucking DB Date
//            dtInicioQuery = OracleHelper.getDateFromDB(portal.getStrDbName());
//            dtFinalQuery = OracleHelper.getDateFromDB(portal.getStrDbName());
            
            dtInicioQuery = new Date();
            dtFinalQuery = new Date();
            
            labUnidadeExcucao = portal.getLabUnidade();
            strUniStCodigoExcucao = labUnidadeExcucao.getUniStCodigo();
            rating = portal.returnIframeBaseOnIndex(portal.getIntActiveIndex()).getRating();
        } else {
            try {
                JSFHelper.getExternalContext().redirect("/portal");

            } catch (IOException ex) {
                Logger.getLogger(RelatorioPendenciaView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getStrJasperFormat() {
        return strJasperFormat;
    }

    public void setStrJasperFormat(String strJasperFormat) {
        this.strJasperFormat = strJasperFormat;
    }
    
    public List<LabLocal> getListLabLocalPop() {
        return listLabLocalPop;
    }

    public void setListLabLocalPop(List<LabLocal> listLabLocalPop) {
        this.listLabLocalPop = listLabLocalPop;
    }

    
    
    public List<LabOrigem> getListLabOrigemPop() {
        return listLabOrigemPop;
    }

    public void setListLabOrigemPop(List<LabOrigem> listLabOrigemPop) {
        this.listLabOrigemPop = listLabOrigemPop;
    }

    
    
    public boolean isBlShowTabelaRel() {
        return blShowTabelaRel;
    }

    public void setBlShowTabelaRel(boolean blShowTabelaRel) {
        this.blShowTabelaRel = blShowTabelaRel;
    }

    public String getStrDateType() {
        return strDateType;
    }

    public void setStrDateType(String strDateType) {
        this.strDateType = strDateType;
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

    public boolean isBlPopMsg() {
        return blPopMsg;
    }

    public void setBlPopMsg(boolean blPopMsg) {
        this.blPopMsg = blPopMsg;
    }

    public String getStrLegStCodigoFat() {
        return strLegStCodigoFat;
    }

    public void setStrLegStCodigoFat(String strLegStCodigoFat) {
        this.strLegStCodigoFat = strLegStCodigoFat;
    }

    public boolean isBlPopLabUnidadeExecucao() {
        return blPopLabUnidadeExecucao;
    }

    public void setBlPopLabUnidadeExecucao(boolean blPopLabUnidadeExecucao) {
        this.blPopLabUnidadeExecucao = blPopLabUnidadeExecucao;
    }

    public boolean isBlPopLabExame() {
        return blPopLabExame;
    }

    public void setBlPopLabExame(boolean blPopLabExame) {
        this.blPopLabExame = blPopLabExame;
    }

    public boolean isBlPopLabLocal() {
        return blPopLabLocal;
    }

    public void setBlPopLabLocal(boolean blPopLabLocal) {
        this.blPopLabLocal = blPopLabLocal;
    }

    public boolean isBlPopLabOrigem() {
        return blPopLabOrigem;
    }

    public void setBlPopLabOrigem(boolean blPopLabOrigem) {
        this.blPopLabOrigem = blPopLabOrigem;
    }

    public boolean isBlPopLabSetor() {
        return blPopLabSetor;
    }

    public void setBlPopLabSetor(boolean blPopLabSetor) {
        this.blPopLabSetor = blPopLabSetor;
    }

    public boolean isBlPopLabUnidadeCadastro() {
        return blPopLabUnidadeCadastro;
    }

    public void setBlPopLabUnidadeCadastro(boolean blPopLabUnidadeCadastro) {
        this.blPopLabUnidadeCadastro = blPopLabUnidadeCadastro;
    }

    public List<LabSetor> getListLabSetorPop() {
        return listLabSetorPop;
    }

    public void setListLabSetorPop(List<LabSetor> listLabSetorPop) {
        this.listLabSetorPop = listLabSetorPop;
    }
    
    

    public void grabUnidadeExcucao() {

        if (strUniStCodigoExcucao != null) {
            this.labUnidadeExcucao = portal.getMapLinkedLabUnidade().get(strUniStCodigoExcucao);
            if (labUnidadeExcucao != null) {
//                labUnidadeExcucao = br.com.utils.shared.RelatorioItens.getMapLabUnidade().get(luu.getUniStCodigo());//(LabUnidade)OracleHelper.getObject(LabUnidade.class, luu.getUniStCodigo());
                labUnidadeExcucao = (LabUnidade) OracleHelper.getObject(LabUnidade.class, strUniStCodigoExcucao, portal.getStrDbName());

                if (labUnidadeCadastro != null) {
                    labUnidadeCadastro = null;
                }
                if (strUniStCodigoCadastro != null) {
                    strUniStCodigoCadastro = null;
                }
                if (listLabOrigem != null) {
                    listLabOrigem = null;
                }
                if (labOrigem != null) {
                    labOrigem = null;
                }
                if (listLabLocal != null) {
                    listLabLocal = null;
                }
                if (labLocal != null) {
                    labLocal = null;
                }
                if (listLabSetor != null) {
                    listLabSetor = null;
                }
                if (labSetor != null) {
                    labSetor = null;
                }

            } else {
                labUnidadeExcucao = null;
                portal.popMsg(0, true, "Unidade Inexistente ou o seu login não tem esta Unidade.");
            }

        }
    }

    public void grabUnidadeExcucaoOnChange(ValueChangeEvent event) {

        setStrUniStCodigoExcucao((String) event.getNewValue().toString().toUpperCase());
        grabUnidadeExcucao();

    }

    public void popUnidadeExecucao() {

        if (portal.getListLabUnidade() != null && portal.getListLabUnidade().size() > 1) {
            blPopLabUnidadeExecucao = true;
        } else if (portal.getListLabUnidade() != null && portal.getListLabUnidade().size() == 1) {
            labUnidadeExcucao = (LabUnidade) portal.getListLabUnidade().get(0);
            strUniStCodigoExcucao = labUnidadeCadastro.getUniStCodigo();
            blPopLabUnidadeExecucao = false;
        }

    }

    public void grabUnidadeExecucaoFromList(ActionEvent event) {

        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatoriopendenciapoplistlabunidadesexparam");
        strUniStCodigoExcucao = paramValue;
        
        grabUnidadeExcucao();

    }

    public void closePopUnidadeEx() {
        blPopLabUnidadeExecucao = false;
    }

    public void grabUnidadeCadastro() {

        if (strUniStCodigoCadastro != null
                && labUnidadeExcucao != null) {


            if (portal.getMapLinkedLabUnidade().containsKey(strUniStCodigoCadastro)) {
                labUnidadeCadastro = portal.getMapLinkedLabUnidade().get(strUniStCodigoCadastro);
            } else {
                labUnidadeCadastro = null;
                portal.popMsg(1, true, "Unidade Inexistente ou o seu login não tem esta Unidade.");
            }

            if (listLabOrigem != null && !listLabOrigem.isEmpty()) {
                listLabOrigem = null;
            }
            if (labOrigem != null) {
                labOrigem = null;
            }
            if (listLabLocal != null && !listLabLocal.isEmpty()) {
                listLabLocal = null;
            }
            if (labLocal != null) {
                labLocal = null;
            }
            if (listLabSetor != null && !listLabSetor.isEmpty()) {
                listLabSetor = null;
            }
            if (labSetor != null) {
                labSetor = null;
            }


        } else {
            portal.popMsg(1, true, "Escolha uma Unidade e Execução ...");
        }
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("widgetvarrelatoriopendenciapoplistlaborigem.hide()");
        
    }

    public void grabUnidadeCadastroOnChange(ValueChangeEvent event) {
        setStrUniStCodigoCadastro((String) event.getNewValue().toString().toUpperCase());
        grabUnidadeCadastro();

    }

    public void grabUnidadeCadastroFromList(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        strUniStCodigoCadastro =  (String) map.get("relatoriopendenciapoplistlabunidadesparam");
        grabUnidadeCadastro();
    }

    public void popUnidadeCadastro() {

        if (portal.getListLabUnidade() != null && portal.getListLabUnidade().size() > 1) {
            blPopLabUnidadeCadastro = true;
        } else if (portal.getListLabUnidade() != null && portal.getListLabUnidade().size() == 1) {
            labUnidadeCadastro = (LabUnidade) portal.getListLabUnidade().get(0);
            strUniStCodigoCadastro = labUnidadeCadastro.getUniStCodigo();
            blPopLabUnidadeCadastro = false;
        } else {
            portal.popMsg(1, true, "Unidade de Execução é um  campo obrigatório...");
        }


    }

    public void closePopUnidade() {
        blPopLabUnidadeCadastro = false;
    }

    private void grabOrigemCadastro() {

        if (labUnidadeCadastro != null
                && labUnidadeExcucao != null) {
            labOrigem = null;
            labOrigem = OracleHelper.getLabOrigemByUniStCodigo(labUnidadeCadastro.getUniStCodigo(), strOriStCodigo, portal.getStrDbName());
            if (labOrigem != null) {
                buildMenu4Origem();
                setStrOriStCodigo("");
            } else {
                popOrigemCadastro();
                portal.popMsg(1, true, "Origem Inexistente");
            }
        } else {
            portal.popMsg(1, true, "Unidade de Execução e Unidade de Cadastro são  campos obrigatórios...");
        }
//        strOriStCodigo = null;
    }

    public void grabOrigemCadastroOnChange(ValueChangeEvent event) {
        setStrOriStCodigo((String) event.getNewValue().toString().toUpperCase());
        grabOrigemCadastro();


    }

    private void buildMenu4Origem() {

        if (listLabOrigem == null) {
            listLabOrigem = new LinkedHashSet<LabOrigem>();
        }

        if (listLabOrigem.add(labOrigem)) {

            portal.popMsg(10, false, "Incluido com Sucesso......");

        } else {
            portal.popMsg(1, true, "Posto repetido");
        }

    }

    public void delOrigemCadastro() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatoriopendenciaorigem");
        if (paramValue != null && !this.listLabOrigem.isEmpty()) {
            for (LabOrigem lo : listLabOrigem) {
                if (lo.getOriStCodigo().equalsIgnoreCase(paramValue)) {
                    if(listLabOrigem.remove(lo)){
                        portal.popMsg(0, false, "Convênio excluido.........");
                        break;
                    }

                }
            }
        } else {
            this.portal.popMsg(0, true, "Não há convênios a serem removidas");
        }
        
    }

    public void popOrigemCadastro() {
        
        this.listLabOrigemPop = null;
            
            if(this.labUnidadeExcucao != null && labUnidadeCadastro != null){
                this.listLabOrigemPop = (List<LabOrigem>) OracleHelper
                .getListOfObjectByKeyEq(LabOrigem.class, "uniStCodigo", labUnidadeCadastro.getUniStCodigo(), "oriStCodigo", true,portal.getStrDbName());
            System.out.println("Inside popOrigemCadastro");
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("widgetvarrelatoriopendenciapoplistlaborigem.show()");
            }else{
                            portal.popMsg(1, true, "Unidade de Execução e Unidade de Cadastro são  campos obrigatórios...");
            }   

    }

    public void closePopOrigem() {
        blPopLabOrigem = false;
    }
    public void popOrigemCadastroListener(ActionEvent event){
        popOrigemCadastro();
    }
    

    public void grabOrigemCadastroFromList(ActionEvent event) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        strOriStCodigo =  (String) map.get("relatoriopendenciapoplistlaborigemparam");
        grabOrigemCadastro();
        
    }

    private void grabLocalCadastro() {

        if (labUnidadeCadastro != null
                && labUnidadeExcucao != null) {
            labLocal = null;
            LabLocalPK pk = new LabLocalPK(labUnidadeCadastro.getUniStCodigo(), strLocStCodigo);
            labLocal = (LabLocal) OracleHelper.getObject(LabLocal.class, pk, portal.getStrDbName());
            if (labLocal != null) {
                buildMenu4Local();
            } else {
                labLocal = null;
                portal.popMsg(1, true, "Local Inexistente");
            }
        } else {
            portal.popMsg(1, true, "Unidade de Execução e Unidade de Cadastro são  campos obrigatórios...");
        }
//        strLocStCodigo = null;
    }

    public void grabLocalCadastroOnChange(ValueChangeEvent event) {

        setStrLocStCodigo((String) event.getNewValue().toString().toUpperCase());
        grabLocalCadastro();

    }

    private void buildMenu4Local() {
        if (listLabLocal == null) {
            listLabLocal = new LinkedHashSet<LabLocal>();
        }

        if (listLabLocal.add(labLocal)) {

            portal.popMsg(10, false, "Incluido com Sucesso....");

        } else {
            portal.popMsg(1, true, "Local Repetido");
        }
    }

    public void delLocalCadastro() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatoriopendencialocal");
        if (paramValue != null && !this.listLabLocal.isEmpty()) {
            for (LabLocal lc : listLabLocal) {
                if (lc.getLocStCodigo().equalsIgnoreCase(paramValue)) {
                    if(listLabLocal.remove(lc)){
                        portal.popMsg(0, false, "Local excluido.........");
                        break;
                    }

                }
            }
        } else {
            this.portal.popMsg(0, true, "Não há locais a serem removidas");
        }
    }

    public void popLocalCadastroListener(ActionEvent event) {
        popLocalCadastro();
    }
    
    public void popLocalCadastro() {
        
        if (labUnidadeCadastro != null) {
            this.listLabLocalPop = (List<LabLocal>) 
                    OracleHelper.getListOfObjectByKeyEq(LabLocal.class, "uniStCodigo", labUnidadeCadastro.getUniStCodigo(), "locStCodigo", true,portal.getStrDbName());
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("widgetvarrelatoriopendenciapoplistlablocal.show()");
        } else {
            portal.popMsg(1, true, "Unidade de Execução e Unidade de Cadastro são  campos obrigatórios...");
        }
    }

    public void closePopLocal() {
        blPopLabLocal = false;
    }

    public void grabLocalCadastroFromList(ActionEvent event) {
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        strLocStCodigo =  (String) map.get("relatoriopendenciapoplistlablocalparam");
        grabLocalCadastro();
        
    }

    private void grabSetorCadastro() {
        if (labUnidadeCadastro != null
                && labUnidadeExcucao != null) {
            labSetor = null;
            LabSetorPK pk = new LabSetorPK(labUnidadeCadastro.getUniStCodigo(), strSetStCodigo);
            labSetor = (LabSetor) OracleHelper.getObject(LabSetor.class, pk, portal.getStrDbName());
            if (labSetor != null) {
                buildMenu4Setor();
                strLocStCodigo = null;
            } else {
                labSetor = null;
                portal.popMsg(1, true, "Setor Inexistente");
            }
        } else {
            portal.popMsg(1, true, "Unidade de Execução e Unidade de Cadastro são  campos obrigatórios...");
        }
//        strSetStCodigo = null;
    }

    public void grabSetorCadastroOnChange(ValueChangeEvent event) {

        setStrSetStCodigo((String) event.getNewValue().toString().toUpperCase());
        grabSetorCadastro();

    }

    private void buildMenu4Setor() {
        if (listLabSetor == null) {
            listLabSetor = new LinkedHashSet<LabSetor>();
        }
        if (listLabSetor.add(labSetor)) {

            portal.popMsg(10, false, "Incluido com Sucesso..");
        } else {
            portal.popMsg(1, true, "Setor Repetido");
        }
    }

    public void delSetorCadastro() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatoriopendenciasetor");
        if (paramValue != null && !this.listLabSetor.isEmpty()) {
            for (LabSetor ls : listLabSetor) {
                if (ls.getSetStCodigo().equalsIgnoreCase(paramValue)) {
                    if(listLabSetor.remove(ls)){
                        portal.popMsg(0, false, "Setor excluido.........");
                        break;
                    }

                }
            }
        } else {
            this.portal.popMsg(0, true, "Não há setores a serem removidas");
        }
    }

    public void popSetorCadastro() {

        if (labUnidadeCadastro != null ) {
            this.listLabSetorPop = (List<LabSetor>) OracleHelper.getListOfObjectByKeyEq(LabSetor.class, "uniStCodigo", labUnidadeCadastro.getUniStCodigo(), "setStCodigo", true,portal.getStrDbName());
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("widgetvarrelatoriopendenciapoplistlabsetor.show()");
            
            
        } else {
            portal.popMsg(1, true, "Unidade de Execução e Unidade de Cadastro são  campos obrigatórios...");
        }
    }

    public void closePopSetor() {
        blPopLabSetor = false;
    }

    public void grabSetorCadastroFromList(ActionEvent event) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        strSetStCodigo =  (String) map.get("relatoriopendenciapoplistlabsetorparam");
        grabSetorCadastro();
        
    }

    private void grabExameCadastro() {
        if (labUnidadeCadastro != null
                && labUnidadeExcucao != null) {
            labExame = null;
            labExame = (LabExame) OracleHelper.getObject(LabExame.class, strExaStCodigo, portal.getStrDbName());
            if (labExame != null) {
                if (listLabExame == null) {
                    listLabExame = new LinkedHashSet<LabExame>();
                }

                if (listLabExame.add(labExame)) {
                    portal.popMsg(10, false, "Incluido com Sucesso...");
                } else {
                    portal.popMsg(1, true, "Exame Repetido");
                }

            } else {
                portal.popMsg(1, true, "Exame Inexistente");
            }
        } else {
            portal.popMsg(1, true, "Unidade de Execução e Unidade de Cadastro são  campos obrigatórios...");
        }

//        strExaStCodigo = null;
    }

    public void grabExameCadastroOnChange(ValueChangeEvent event) {

        setStrExaStCodigo((String) event.getNewValue());
        grabExameCadastro();

    }

    public void delExaCadastro() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("relatoriopendenciaexame");
        if (paramValue != null && !this.listLabExame.isEmpty()) {
            for (LabExame le : listLabExame) {
                if (le.getExaStCodigo().equalsIgnoreCase(paramValue)) {
                    if(listLabExame.remove(le)){
                        portal.popMsg(0, false, "Exame excluido.........");
                        break;
                    }

                }
            }
        } else {
            this.portal.popMsg(0, true, "Não há exames a serem removidas");
        }
    }

    public boolean isBlCadastro() {
        return blCadastro;
    }

    public void setBlCadastro(boolean blCadastro) {
        this.blCadastro = blCadastro;
    }

    public boolean isBl2Amostra() {
        return bl2Amostra;
    }

    public void setBl2Amostra(boolean bl2Amostra) {
        this.bl2Amostra = bl2Amostra;
    }

    public boolean isBlArmazenado() {
        return blArmazenado;
    }

    public void setBlArmazenado(boolean blArmazenado) {
        this.blArmazenado = blArmazenado;
    }

    public boolean isBlAssinado() {
        return blAssinado;
    }

    public void setBlAssinado(boolean blAssinado) {
        this.blAssinado = blAssinado;
    }

    public boolean isBlCancelado() {
        return blCancelado;
    }

    public void setBlCancelado(boolean blCancelado) {
        this.blCancelado = blCancelado;
    }

    public boolean isBlCompleto() {
        return blCompleto;
    }

    public void setBlCompleto(boolean blCompleto) {
        this.blCompleto = blCompleto;
    }

    public boolean isBlConfCad() {
        return blConfCad;
    }

    public void setBlConfCad(boolean blConfCad) {
        this.blConfCad = blConfCad;
    }

    public boolean isBlConfirma() {
        return blConfirma;
    }

    public void setBlConfirma(boolean blConfirma) {
        this.blConfirma = blConfirma;
    }

    public boolean isBlDeletado() {
        return blDeletado;
    }

    public void setBlDeletado(boolean blDeletado) {
        this.blDeletado = blDeletado;
    }

    public boolean isBlDescartado() {
        return blDescartado;
    }

    public void setBlDescartado(boolean blDescartado) {
        this.blDescartado = blDescartado;
    }

    public boolean isBlDevMat() {
        return blDevMat;
    }

    public void setBlDevMat(boolean blDevMat) {
        this.blDevMat = blDevMat;
    }

    public boolean isBlImpresso() {
        return blImpresso;
    }

    public void setBlImpresso(boolean blImpresso) {
        this.blImpresso = blImpresso;
    }

    public boolean isBlIngresso() {
        return blIngresso;
    }

    public void setBlIngresso(boolean blIngresso) {
        this.blIngresso = blIngresso;
    }

    public boolean isBlLaudado() {
        return blLaudado;
    }

    public void setBlLaudado(boolean blLaudado) {
        this.blLaudado = blLaudado;
    }

    public boolean isBlLibTec() {
        return blLibTec;
    }

    public void setBlLibTec(boolean blLibTec) {
        this.blLibTec = blLibTec;
    }

    public boolean isBlNaoColetado() {
        return blNaoColetado;
    }

    public void setBlNaoColetado(boolean blNaoColetado) {
        this.blNaoColetado = blNaoColetado;
    }

    public boolean isBlOmitidos() {
        return blOmitidos;
    }

    public void setBlOmitidos(boolean blOmitidos) {
        this.blOmitidos = blOmitidos;
    }

    public boolean isBlParcial() {
        return blParcial;
    }

    public void setBlParcial(boolean blParcial) {
        this.blParcial = blParcial;
    }

    public boolean isBlPendente() {
        return blPendente;
    }

    public void setBlPendente(boolean blPendente) {
        this.blPendente = blPendente;
    }

    public boolean isBlPreConf() {
        return blPreConf;
    }

    public void setBlPreConf(boolean blPreConf) {
        this.blPreConf = blPreConf;
    }

    public boolean isBlPreTriado() {
        return blPreTriado;
    }

    public void setBlPreTriado(boolean blPreTriado) {
        this.blPreTriado = blPreTriado;
    }

    public boolean isBlRecSetor() {
        return blRecSetor;
    }

    public void setBlRecSetor(boolean blRecSetor) {
        this.blRecSetor = blRecSetor;
    }

    public boolean isBlRemarcado() {
        return blRemarcado;
    }

    public void setBlRemarcado(boolean blRemarcado) {
        this.blRemarcado = blRemarcado;
    }

    public boolean isBlTrIadoAP() {
        return blTrIadoAP;
    }

    public void setBlTrIadoAP(boolean blTrIadoAP) {
        this.blTrIadoAP = blTrIadoAP;
    }

    public boolean isBlTriagem() {
        return blTriagem;
    }

    public void setBlTriagem(boolean blTriagem) {
        this.blTriagem = blTriagem;
    }

    public Date getDtInicioQuery() {
        return dtInicioQuery;
    }

    public void setDtInicioQuery(Date dtInicioQuery) {
        this.dtInicioQuery = dtInicioQuery;
    }

    public LabExame getLabExame() {
        return labExame;
    }

    public void setLabExame(LabExame labExame) {
        this.labExame = labExame;
    }

    public LabLocal getLabLocal() {
        return labLocal;
    }

    public void setLabLocal(LabLocal labLocal) {
        this.labLocal = labLocal;
    }

    public LabOrigem getLabOrigem() {
        return labOrigem;
    }

    public void setLabOrigem(LabOrigem labOrigem) {
        this.labOrigem = labOrigem;
    }

    public LabSetor getLabSetor() {
        return labSetor;
    }

    public void setLabSetor(LabSetor labSetor) {
        this.labSetor = labSetor;
    }

    public LabUnidade getLabUnidadeCadastro() {
        return labUnidadeCadastro;
    }

    public void setLabUnidadeCadastro(LabUnidade labUnidadeCadastro) {
        this.labUnidadeCadastro = labUnidadeCadastro;
    }

    public LabUnidade getLabUnidadeExcucao() {
        return labUnidadeExcucao;
    }

    public void setLabUnidadeExcucao(LabUnidade labUnidadeExcucao) {
        this.labUnidadeExcucao = labUnidadeExcucao;
    }

    public String getStrExaStCodigo() {
        return strExaStCodigo;
    }

    public void setStrExaStCodigo(String strExaStCodigo) {
        this.strExaStCodigo = strExaStCodigo.toUpperCase().trim();
    }

    public String getStrLocStCodigo() {
        return strLocStCodigo;
    }

    public void setStrLocStCodigo(String strLocStCodigo) {
        this.strLocStCodigo = ZerosFabrica.makeZeros(strLocStCodigo, 6);
    }

    public String getStrOptionQuery() {
        return strOptionQuery;
    }

    public void setStrOptionQuery(String strOptionQuery) {
        this.strOptionQuery = strOptionQuery;
    }

    public String getStrOriStCodigo() {
        return strOriStCodigo;
    }

    public void setStrOriStCodigo(String strOriStCodigo) {
        this.strOriStCodigo = ZerosFabrica.makeZeros(strOriStCodigo, 6);
    }

    public String getStrSetStCodigo() {
        return strSetStCodigo;
    }

    public void setStrSetStCodigo(String strSetStCodigo) {
        this.strSetStCodigo = strSetStCodigo.toUpperCase();
    }

    public String getStrUniStCodigoCadastro() {
        return strUniStCodigoCadastro;
    }

    public void setStrUniStCodigoCadastro(String strUniStCodigoCadastro) {
        this.strUniStCodigoCadastro = strUniStCodigoCadastro.toUpperCase();
    }

    public String getStrUniStCodigoExcucao() {
        return strUniStCodigoExcucao;
    }

    public void setStrUniStCodigoExcucao(String strUniStCodigoExcucao) {
        this.strUniStCodigoExcucao = strUniStCodigoExcucao.toUpperCase();
    }

    public SelectItem[] getFatutadosStatus() {
        SelectItem[] d = {new SelectItem("NCO", "NCO - Nao Conferido"), new SelectItem("CCF", "CCF - Conferido Faturado"), new SelectItem("FAT", "Faturados")};
        return d;
    }

    public SelectItem[] getDateTypesItens() {
        SelectItem[] d = {new SelectItem("dr", "Data de Requisição"), new SelectItem("de", "Data de Entrega"), new SelectItem("dx", "Data Exame")};
        return d;
    }

    public Date getDtFinalQuery() {
        return dtFinalQuery;
    }

    public void setDtFinalQuery(Date dtFinalQuery) {
        this.dtFinalQuery = dtFinalQuery;
    }

    public SelectItem[] getOpcoestens() {

        SelectItem[] d = {new SelectItem("P", "Pendentes"), new SelectItem("P", "Pendentes")};
        return d;
    }

    public Set<LabExame> getListLabExame() {
        return listLabExame;
    }

    public void setListLabExame(Set<LabExame> listLabExame) {
        this.listLabExame = listLabExame;
    }

    public Set<LabLocal> getListLabLocal() {
        return listLabLocal;
    }

    public void setListLabLocal(Set<LabLocal> listLabLocal) {
        this.listLabLocal = listLabLocal;
    }

    public Set<LabOrigem> getListLabOrigem() {
        return listLabOrigem;
    }

    public void setListLabOrigem(Set<LabOrigem> listLabOrigem) {
        this.listLabOrigem = listLabOrigem;
    }

    public Set<LabSetor> getListLabSetor() {
        return listLabSetor;
    }

    public void setListLabSetor(Set<LabSetor> listLabSetor) {
        this.listLabSetor = listLabSetor;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    
    
    public void validateDateRange(DateSelectEvent event) {

        if (!DateRange.rangeVerifierMonths(ArrayItems.intMaximumPendingMonths, dtInicioQuery, dtFinalQuery)) {
            this.portal.popMsg(2, true, "O intervalo entre datas é de no maximo " + ArrayItems.intMaximumPendingMonths + " mês.");
        } else {
            this.portal.popMsg(1000, false, "");
        }
    }
    
    

    public void makeRelatorio() {
        RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
//        if (DateRange.timerInterval(ArrayItems.intMinimumSec, portal.getDtBase(), new Date()) || true) {
        
        if (true) {
            portal.setDtBase(new Date());

            if (dtInicioQuery != null
                    && dtFinalQuery != null
                    && labUnidadeCadastro != null
                    && labUnidadeExcucao != null) {



                if (DateRange.rangeVerifierMonths(ArrayItems.intMaximumPendingMonths, dtInicioQuery, dtFinalQuery)) {


                    if (relatorioStorage.blockByPdfUnfinish()) {
                        makePdf();
                    } else {
                        portal.popMsg(0, true, "Não é possivel solicitar mais relatorios enquanto " + ArrayItems.intMaximumRelatorios + " ou mais estiverem ainda sendo feitos.");
                    }

                } else {

                    portal.popMsg(0, true, "O intervalo entre datas é de no maximo " + (ArrayItems.intMaximumPendingMonths) + " mês.");
                }

            } else {
                portal.popMsg(0, true, "Unidade de Execução e Unidade de Cadastro são  campos obrigatórios...");
            }

            blShowTabelaRel = true;

        } else {
            portal.popMsg(1, true, "Não é permitido clicar repetidamente.....espere por no minimo " + ArrayItems.intMinimumSec + " segundos...");
        }

    }

    private void makePdf() {

        RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
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


        Map<String, Object> mapAnds4Req1 = new HashMap<String, Object>();
        Map<String, Object> mapAnds4Det1 = new HashMap<String, Object>();
        Map<String, List> mapOrs4Req1 = new HashMap<String, List>();
        Map<String, List> mapOrs4Det1 = new HashMap<String, List>();
        mapAnds4Req1.put("uniStCodigo", labUnidadeCadastro.getUniStCodigo());

        mapAnds4Det1.put("uniStCodigo", labUnidadeCadastro.getUniStCodigo());

        mapAnds4Det1.put("derStUnidadeEx", labUnidadeExcucao.getUniStCodigo());

        if (listLabOrigem != null && listLabOrigem.size() > 0) {
            List<String> linO = new ArrayList<String>();
            for (LabOrigem lo : listLabOrigem) {

                linO.add(lo.getOriStCodigo());

            }
            mapOrs4Det1.put("oriStCodigo", linO);
        }


        if (listLabSetor != null && !listLabSetor.isEmpty()) {
            List<String> linS = new ArrayList<String>();
            for (LabSetor ls : listLabSetor) {
//                    listOrs4Det3.add(ls.getSetStCodigo());
                linS.add(ls.getSetStCodigo());

            }
            mapOrs4Det1.put("setStCodigo", linS);
        }

//             strstrFieldNameOrsDet4 = "exaStCodigo";
        if (listLabExame != null && !listLabExame.isEmpty()) {
            List<String> linE = new ArrayList<String>(listLabExame.size());
            for (LabExame le : listLabExame) {
//                    listOrs4Det4.add(le.getExaStCodigo());
                linE.add(le.getExaStCodigo());

            }
            mapOrs4Det1.put("exaStCodigo", linE);
        }

        if (listLabLocal != null && !listLabLocal.isEmpty()) {
            List<String> linc = new ArrayList<String>(listLabLocal.size());
            for (LabLocal lc : listLabLocal) {
//                    listOrs4Det4.add(le.getExaStCodigo());
                linc.add(lc.getLocStCodigo());

            }
            mapOrs4Req1.put("locStCodigo", linc);
        }


//            strstrFieldNameOrsDet5 = "legStCodigo";
        List<String> linLegStCodio = new ArrayList<String>(20);
        if (blCadastro) {
            linLegStCodio.add("001");
        }
        if (blConfCad) {
            linLegStCodio.add("002");
        }
        if (blPreTriado) {
            linLegStCodio.add("003");
        }
        if (blTriagem) {
            linLegStCodio.add("004");
        }
        if (blTrIadoAP) {
            linLegStCodio.add("005");
        }
        if (blRecSetor) {
            linLegStCodio.add("006");
        }
        if (blPendente) {
            linLegStCodio.add("007");
        }
        if (blCompleto) {
            linLegStCodio.add("008");
        }
        if (blIngresso) {
            linLegStCodio.add("009");
        }
        if (blLibTec) {
            linLegStCodio.add("010");
        }
        if (blAssinado) {
            linLegStCodio.add("011");
        }
        if (blConfirma) {
            linLegStCodio.add("012");
        }
        if (blCancelado) {
            linLegStCodio.add("013");
        }
        if (blArmazenado) {
            linLegStCodio.add("014");
        }
        if (blDescartado) {
            linLegStCodio.add("015");
        }
        if (blImpresso) {
            linLegStCodio.add("016");
        }
        if (bl2Amostra) {
            linLegStCodio.add("017");
        }
        if (blLaudado) {
            linLegStCodio.add("018");
        }
        if (blNaoColetado) {
            linLegStCodio.add("020");
        }
        if (blDeletado) {
            linLegStCodio.add("040");
        }
        if (blDevMat) {
            linLegStCodio.add("041");
        }
        if (blRemarcado) {
            linLegStCodio.add("042");
        }
        if (blPreConf) {
            linLegStCodio.add("043");
        }

        if (linLegStCodio != null && !linLegStCodio.isEmpty()) {
            if (linLegStCodio.size() < 23) {
                mapOrs4Det1.put("legStCodigo", linLegStCodio);
            }
        }


        if (strLegStCodigoFat != null && !strLegStCodigoFat.trim().isEmpty()) {
            mapAnds4Det1.put("legStCodigoFat", strLegStCodigoFat);
        }



        if (blParcial) {
            mapAnds4Det1.put("derChParcial", 'S');
//                mapAnds4Det1.put("derChParcial",'S');
        }

        if (blOmitidos) {
            mapAnds4Det1.put("derChOmiteCad", 'S');
//                  mapAnds4Det1.put("derChOmiteCad", 'S');
        }



        String fileName = "";

        fileName = portal.getLabUsuario().getUsuStCodigo() + "_PENDENCIA_" + ArrayItems.format4PdfName.format(new Date()) + "."+strJasperFormat; //

        XStream xstream = new XStream();

        String strDateFieldName = "reqDtCadastro";
        if (strDateType.equalsIgnoreCase("dr")) {
            strDateFieldName = "reqDtCadastro";
        } else if (strDateType.equalsIgnoreCase("de")) {
            strDateFieldName = "derDtDataPrevistaEntrega";
        } else if (strDateType.equalsIgnoreCase("dx")) {
            strDateFieldName = "reqDtCadastro2";
        }

        PdfDados pd = new PdfDados("",
                strDateFieldName,
                "Pendencia => Ex:" + labUnidadeExcucao.getUniStCodigo() + ">" + "Uni: " + labUnidadeCadastro.getUniStCodigo()
                + " Dt Inicio: " + ArrayItems.format4PdfName.format(dtInicioQuery) + " Dt Fim: " + ArrayItems.format4PdfName.format(dtFinalQuery),
                "pendencia",
                dtInicioQuery, dtFinalQuery,
                mapAnds4Req1,
                mapOrs4Req1,
                mapAnds4Det1,
                mapOrs4Det1,
                "", portal.getLabUsuario().getUsuStCodigo(), portal.getStrDbName());

//        pd.setStrPdfName("/home/eros/WebContainers/glassfish-3.1/glassfish/domains/domain1/applications/icehell/icerel_war/pdfshop/" + fileName);
        pd.setStrPdfName(ArrayItems.strURLPdfPath + fileName);
//        String strPdfDados = xstream.toXML(pd);


         //TODO fixing fucking DB Date
        Date dtRightNow = OracleHelper.getDateFromDB(portal.getStrDbName());
//        Date dtRightNow =  new Date();

        LabRelatorios r = new LabRelatorios(
                OracleHelper.getLabRelatorioNextId(portal.getStrDbName()),
                dtRightNow, dtRightNow, 'L', "vazio", portal.getLabUsuario().getUsuStCodigo(), fileName, "relatório em execução \n aguarde.",
                "Pendencia => Ex:" + labUnidadeExcucao.getUniStCodigo() + " >> " + "Uni: " + labUnidadeCadastro.getUniStCodigo() + " >> Dt Inicio: " + ArrayItems.format4PdfName.format(dtInicioQuery) + " >> Dt Fim: " + ArrayItems.format4PdfName.format(dtFinalQuery));
        r.setRelDtTermino(null);
        r.setRelHrTermino(null);

        pd.setStrId(r.getRelInCodigo().toString());
        pd.setStrDbName(portal.getStrDbName());
        pd.setStrUserNome(portal.getLabUsuario().getUsuStCodigo());
        
        OracleHelper.saveObject(r, portal.getStrDbName());
        relatorioStorage.addAndSorReports(r);
        PdfDadosSender pds = new PdfDadosSender();
        pds.pdfSender(xstream.toXML(pd));

    }

    public void cleanUpEveryThing() {

        strOptionQuery = "Pendencias";
        dtInicioQuery = new Date();
        dtFinalQuery = new Date();

        strUniStCodigoCadastro = null;
        labUnidadeCadastro = null;
        labUnidadeExcucao = portal.getLabUnidade();
        strUniStCodigoExcucao = labUnidadeExcucao.getUniStCodigo();

        strOriStCodigo = null;
        labOrigem = null;
        listLabOrigem = null;

        strLocStCodigo = null;
        labLocal = null;
        listLabLocal = null;

        strSetStCodigo = null;
        labSetor = null;
        listLabSetor = null;

        strExaStCodigo = null;
        labExame = null;
        listLabExame = null;
//    listRelatorioDados = null;
        blCadastro = true;
        blConfCad = true;
        blPreTriado = true;
        blTriagem = true;
        blTrIadoAP = true;
        blRecSetor = false;
        blPendente = true;
        blCompleto = false;
        blIngresso = false;
        blLibTec = false;
        blAssinado = false;
        blConfirma = false;
        blCancelado = false;
        blArmazenado = false;
        blDescartado = false;
        blImpresso = false;
        bl2Amostra = false;
        blLaudado = false;
        blNaoColetado = false;
        blDeletado = false;
        blDevMat = false;
        blRemarcado = false;
        blPreConf = false;

        blOmitidos = false;
        blParcial = false;

        strLegStCodigoFat = null;
//    
//    blnNaoConfFat= false;
//    blFaturados= false;
//    blConConfFat = false;

    }

    public void allChecked(ActionListener event) {
        blCadastro = true;
        blConfCad = true;
        blPreTriado = true;
        blTriagem = true;
        blTrIadoAP = true;
        blRecSetor = true;
        blPendente = true;
        blCompleto = true;
        blIngresso = true;
        blLibTec = true;
        blAssinado = true;
        blConfirma = true;
        blCancelado = true;
        blArmazenado = true;
        blDescartado = true;
        blImpresso = true;
        bl2Amostra = true;
        blLaudado = true;
        blNaoColetado = true;
        blDeletado = true;
        blDevMat = true;
        blRemarcado = true;
        blPreConf = true;

    }

    public void allUnChecked(ActionEvent event) {

        blCadastro = false;
        blConfCad = false;
        blPreTriado = false;
        blTriagem = false;
        blTrIadoAP = false;
        blRecSetor = false;
        blPendente = false;
        blCompleto = false;
        blIngresso = false;
        blLibTec = false;
        blAssinado = false;
        blConfirma = false;
        blCancelado = false;
        blArmazenado = false;
        blDescartado = false;
        blImpresso = false;
        bl2Amostra = false;
        blLaudado = false;
        blNaoColetado = false;
        blDeletado = false;
        blDevMat = false;
        blRemarcado = false;
        blPreConf = false;
    }
    
    
    
    
    
    
}