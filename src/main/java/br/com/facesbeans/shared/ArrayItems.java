/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.shared;

/**
 *
 * @author eros
 */
/**
 *
 * @author eros
 */
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabConfigIngresso;
import br.com.hibernate.entities.LabErroAuditoria;
import br.com.hibernate.entities.LabLegenda;
import br.com.hibernate.entities.LabUnidadeMedida;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.IFrameHolder;
import br.com.portal.beans.login.IFramePage;
import br.com.utils.tipstricks.IOUtils;
import com.thoughtworks.xstream.XStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

@ManagedBean(name = "arrayitems")
@ApplicationScoped
public class ArrayItems implements Serializable {

    SelectItem[] calendarioDemoItens;
    SelectItem[] crachaTipoItens;
    SelectItem[] equipamentoTipoItens;
    SelectItem[] pessoaTipoItens;
    SelectItem[] enderecoTipoItens;
    SelectItem[] telTipoItens;
    SelectItem[] perfilItens;
    
    
    private List<LabErroAuditoria> listErroAuditoria;
    
    public static Integer intMaxDaysRelStorage = 7;
    public static Integer intMaximumOneMonths = 1;
    public static Integer intMaximumTwoMonths = 2;
    public static Integer intMaximumThreeMonths = 3;
    
    public static Integer intMaximumBillingMonths = 3;
    public static Integer intMaximumPendingMonths = 2;
    
    public static Integer intMinimumTime = -1;
    public static Integer intMinimumSec = 2;
    public static Integer intMaximumRelatorios = 2;
    public final static String strURLPdfPath = "/home/pdfshop/";
//    public final static String strURLPdfPath = "c:\\home\\pdfshop'";
    public static Integer intMaximumReqsConsultaLaudo = 10000;
    public static Integer intMaximumAuditoriaResults = 10000;
    private Integer intPollCounterRelStorage = 5;
    private String strIdleMaxTime = "400000";
    private String strRefreshMaxTime = "7200";
    private String strPollInterval = "10";
//    public final static String strURLPdfPath = "/home/eros/WebContainers/glassfish-3.1/glassfish/domains/domain1/applications/icehell/icerel_war/pdfshop/";
//    public final String strUrlPdfStreamer = "http://localhost:8080/relMakerService/PdfStreamer?relincodigo=";
    private static Map<LabConfigIngresso, LabConfigIngresso> mapLabConfigIngresso = null;//new HashMap<LabConfigIngresso, LabConfigIngresso>();
    private static Map<String, LabUnidadeMedida> mapLabUnidadeMedida = null;//new HashMap<String, LabUnidadeMedida>();
    private static Map<LabLegenda, LabLegenda> mapLabLegenda = null;//new HashMap<LabLegenda,LabLegenda>();
    private static Map<String, LabLegenda> mapLabLegendaConsultaLaudo = null;//new HashMap<LabLegenda,LabLegenda>();
    public static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat formatOnlyDay = new SimpleDateFormat("dd");
    public static final SimpleDateFormat formatOnlyHrs = new SimpleDateFormat("HH");
    public static final SimpleDateFormat formatOnlyDayOfWeek = new SimpleDateFormat("E");
    public static final SimpleDateFormat formatOnlyMonthAndYear = new SimpleDateFormat("MM/yyyy");
    public static final SimpleDateFormat formatOnlyWeekMonthAndYear = new SimpleDateFormat("W/MM/yyyy");
    public static final SimpleDateFormat format4PdfName = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
    public static Locale locBrasil = new Locale("pt", "BR");
    public static NumberFormat nfBrasil = NumberFormat.getCurrencyInstance(locBrasil);
    private static Map<String, String> mapMenuIcon = new HashMap<String, String>();
    public static IFrameHolder iframeHolder = new IFrameHolder();
    
    
    

    static {

        //Menus
        mapMenuIcon.put("00001", "ui-icon-calendar");//00001 Menu Diario
        mapMenuIcon.put("00003", "ui-icon-document");//00003 Cadastros
        mapMenuIcon.put("00007", "ui-icon-image");//00007 Estat�sticas
        mapMenuIcon.put("00005", "ui-icon-clipboard");//00005 Faturamento
        mapMenuIcon.put("00008", "ui-icon-wrench");//00008 Ferramentas
        mapMenuIcon.put("00047", "ui-icon-help");//00047 Ajuda
        mapMenuIcon.put("Fechar Abas", "ui-icon-closethick");//
        mapMenuIcon.put("Fechar Aba Selecionada", "ui-icon-circle-close");//

        //Sub Menus
        mapMenuIcon.put("00064", "ui-icon-arrow-1-e");//00064 Exame Menu
        mapMenuIcon.put("00006", "ui-icon-arrow-1-e");//00006 Conv?nios
        mapMenuIcon.put("00128", "ui-icon-arrow-1-e");//00128 Estat�stica Faturamento
        mapMenuIcon.put("00129", "ui-icon-arrow-1-e");//00129 Estat�stica T�cnica

        //Itens
        mapMenuIcon.put("00022", "ui-icon-comment");//00022 Frases para Laudo
        mapMenuIcon.put("00010", "ui-icon-document");//00010 Cadastro de Conv�nios
        mapMenuIcon.put("00007", "ui-icon-image");//00007 Estat�stica
        mapMenuIcon.put("00062", "ui-icon-image");//00062 Estat�stica Geral
        mapMenuIcon.put("00082", "ui-icon-document");//00082 Estat�stica por Unidade/Posto/Exames
        mapMenuIcon.put("00093", "ui-icon-document");//00082 Estat�stica por Unidade/Posto/Exames
        mapMenuIcon.put("00067", "ui-icon-document");//00067 Estat�stica por Unidade/Conv�nios
        mapMenuIcon.put("00112", "ui-icon-document");//00112 Estat�stica de Produ��o de Exames por Unidade/Postos
        mapMenuIcon.put("00114", "ui-icon-document");//00114 Estat�stica de Pend�ncias
        mapMenuIcon.put("00111", "ui-icon-document");//00114 Estat�stica de Pend�ncias




    }

    public ArrayItems() {
    }

    @PostConstruct
    public void loadIFrameHolder() {
        XStream xstream = new XStream();
        xstream.alias("iframeHolder", IFrameHolder.class);
        InputStream i = ((InputStream) FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/xml/iframeholder.xml"));  // .servletContext.getResourceAsStream("/WEB-INF/myfile");
        iframeHolder = (IFrameHolder) xstream.fromXML(IOUtils.getStringFromInputStream(i));
    }

    public static String getIcoByName(String menuName) {
        if (mapMenuIcon.containsKey(menuName)) {
            return mapMenuIcon.get(menuName);
        } else {
            return "ui-icon-arrow-1-e";
        }
    }

    public static IFrameHolder getIframeHolder() {
        return iframeHolder;
    }

    
    public Integer getIntPollCounterRelStorage() {
        return intPollCounterRelStorage;
    }

    public void setIntPollCounterRelStorage(Integer intPollCounterRelStorage) {
        this.intPollCounterRelStorage = intPollCounterRelStorage;
    }

    public String getStrPollInterval() {
        return strPollInterval;
    }

    public void setStrPollInterval(String strPollInterval) {
        this.strPollInterval = strPollInterval;
    }

    public String getStrIdleMaxTime() {
        return strIdleMaxTime;
    }

    public void setStrIdleMaxTime(String strIdleMaxTime) {
        this.strIdleMaxTime = strIdleMaxTime;
    }

    public String getStrRefreshMaxTime() {
        return strRefreshMaxTime;
    }

    public void setStrRefreshMaxTime(String strRefreshMaxTime) {
        this.strRefreshMaxTime = strRefreshMaxTime;
    }

//    public static  String getUrlByMenuName(String strMenuName){
//        if(mapMenuUrl4Iframe.containsKey(strMenuName)){
//            return  mapMenuUrl4Iframe.get(strMenuName);
//        }else{
//            return  "/icerel";
//        }
//    }
    public Integer getIntMaxDaysRelStorage() {
        return intMaxDaysRelStorage;
    }

    
    
    public SelectItem[] getUnidadeDeNegocioItens() {
        SelectItem[] d = {new SelectItem("--", "--"), new SelectItem("NTO", "NTO"), new SelectItem("NTH", "NTH"), new SelectItem("H", "Hospitais"), new SelectItem("A", "Administrativo")};
        return d;
    }
    
    
    
    public SelectItem[] getCentroCustoType() {
        SelectItem[] d = {new SelectItem("", "-------------"),new SelectItem("CA", "Cadastro"),new SelectItem("CO", "Coleta"),new SelectItem("AD", "Administrativo")
                ,new SelectItem("AT", "Área Técnica"),new SelectItem("SH", "Setor Hospitalar")};
        return d;
    }
    
    public SelectItem[] getRotaType() {
        int intLoop = 100;
        SelectItem[] d = new SelectItem[intLoop];
        for (int i = 0; i < intLoop; i++) {
            d[i] = new SelectItem((new Integer(i+1).toString()), (new Integer(i+1).toString()));
        }
        return d;
    }

    

    
    
    
    public SelectItem[] getQtdItensType() {
        SelectItem[] d = {new SelectItem(null, "-------------"),new SelectItem("001", "Itens Normais"),new SelectItem("003", "Apoio"),new SelectItem("005", "Itens Controlados"),new SelectItem("IM", "Itens Manuais")
        ,new SelectItem("007", "Medicamentos"),new SelectItem("004", "Patrimônio"),new SelectItem("002", "Selab"),new SelectItem("006", "Vacinas")};
        return d;
    }
    
    
    public SelectItem[] getReportERPTypeItens() {
        SelectItem[] d = {new SelectItem("MP", "Mais Pedidos"), new SelectItem("IS", "Itens Solicitados"), new SelectItem("RINA", "RINA-Itens não atendidos"), 
       new SelectItem("C", "Custos"), new SelectItem("DU", "Demandas Urgentes"), new SelectItem("G", "Geral"), new SelectItem("IV", "Itens a Vencer")
       ,  new SelectItem("SP", "Status dos Pedidos"),  new SelectItem("TP", "Tipos de Pedido"),  new SelectItem("A", "Abastecimento")}; //new SelectItem("P", "Postos"),  new SelectItem("IP", "Itens Parametrizados/Cotas"), ,new SelectItem("II", "Inspeção de Itens")
        return d;
    }
    
    public SelectItem[] getQtdItens() {

        SelectItem[] d = {new SelectItem("5", "5"), new SelectItem("10", "10"), new SelectItem("20", "20"),new SelectItem("30", "30"),new SelectItem("40", "40"),new SelectItem("50", "50")
        ,new SelectItem("60", "60"),new SelectItem("70", "70"),new SelectItem("80", "80"),new SelectItem("90", "90"),new SelectItem("100", "100")
                ,new SelectItem("200", "200"),new SelectItem("300", "300"),new SelectItem("400", "400"),new SelectItem("500", "500")};
        return d;
    }
    
    
    public SelectItem[] getSexoItens() {
        SelectItem[] d = {new SelectItem("-", "-"), new SelectItem("M", "M"), new SelectItem("F", "F")};
        return d;
    }

    public SelectItem[] getCorItens() {

        SelectItem[] d = {new SelectItem("-", "-"), new SelectItem("B", "BRANCO"), new SelectItem("N", "NEGRO"), new SelectItem("P", "PARDO"), new SelectItem("A", "AMARELO")};
        return d;
    }

   
    public SelectItem[] getUFItens() {

        SelectItem[] d = {new SelectItem(null, "--"),new SelectItem("SP", "SP"), new SelectItem("AC", "AC"), new SelectItem("AL", "AL"), new SelectItem("AM", "AM"), new SelectItem("AP", "AP"), new SelectItem("BA", "BA"), new SelectItem("CE", "CE"), new SelectItem("DF", "DF"), new SelectItem("ES", "ES"), new SelectItem("GO", "GO"), new SelectItem("MA", "MA"), new SelectItem("MG", "MG"), new SelectItem("MS", "MS"), new SelectItem("MT", "MT"), new SelectItem("PA", "PA"), new SelectItem("PB", "PB"), new SelectItem("PR", "PR"), new SelectItem("PE", "PE"), new SelectItem("PI", "PI"), new SelectItem("RJ", "RJ"), new SelectItem("RN", "RN"), new SelectItem("RO", "RO"), new SelectItem("RR", "RR"), new SelectItem("RS", "RS"), new SelectItem("SC", "SC"), new SelectItem("SE", "SE"), new SelectItem("SP", "SP"), new SelectItem("TO", "TO")};
        return d;
    }

    public SelectItem[] getSangueItens() {

        SelectItem[] d = {new SelectItem("-", "-"), new SelectItem("+A", "+A"), new SelectItem("-A", "-A"), new SelectItem("+B", "+B"), new SelectItem("-B", "-B"), new SelectItem("+AB", "+AB"), new SelectItem("-AB", "-AB"), new SelectItem("+O", "+O"), new SelectItem("-O", "-O")};
        return d;
    }

    public SelectItem[] getDoencaBasicaItens() {

        SelectItem[] d = {new SelectItem("-", "-"), new SelectItem("H.A.S", "H.A.S"), new SelectItem("CHAGAS", "CHAGAS"), new SelectItem("CANCER", "CANCER")};
        return d;
    }

    public SelectItem[] getStatusItens() {

        SelectItem[] d = {new SelectItem("-", "-"), new SelectItem("Apto", "Apto"), new SelectItem("Afastamento Provis�rio", "Afastamento Provis�rio"), new SelectItem("Afastamento Definitivo", "Afastamento Definitivo"), new SelectItem("Transplantado", "Transplantado"), new SelectItem("�bto", "�bto")};
        return d;
    }

    public SelectItem[] getYearItens() {

        SelectItem[] d = {new SelectItem("2012", "2012"), new SelectItem("2011", "2011"), new SelectItem("2010", "2010"), new SelectItem("2009", "2009"), new SelectItem("2008", "2008"), new SelectItem("2007", "2007"), new SelectItem("2006", "2006"), new SelectItem("2005", "2005")
        };
        return d;
    }

    public SelectItem[] getEstadoCivilItens() {

        SelectItem[] d = {new SelectItem("-", "--"), new SelectItem("S", "SOLTEIRO"), new SelectItem("C", "CASADO"), new SelectItem("D", "DISQUITADO"), new SelectItem("N", "NI")};
        return d;
    }

    public SelectItem[] getGestasItens() {

        SelectItem[] d = {new SelectItem("-", "--"), new SelectItem("S", "Sim"), new SelectItem("N", "Não"), new SelectItem("NI", "NI")};
        return d;
    }

    public SelectItem[] getRnItens() {

        SelectItem[] d = {new SelectItem("--", "--"), new SelectItem("S", "Sim"), new SelectItem("N", "N'ão"), new SelectItem("NI", "NI")};
        return d;
    }

    public SelectItem[] getJobsItens() {

        SelectItem[] d = {new SelectItem("1", "MÉDICO (A)"), new SelectItem("3", "ENFERMEIRO(A)"), new SelectItem("4", "NUTRICIONISTA"), new SelectItem("9", "DENTISTA")};
        return d;
    }

    public SelectItem[] getUnidExecItens() {

        SelectItem[] d = {new SelectItem("--", "--"), new SelectItem("Solteiro", "Solteiro"), new SelectItem("Casado", "Casado"), new SelectItem("Disquitado", "Disquitado"), new SelectItem("Emancipado", "Emancipado"), new SelectItem("Outros", "Outros")};
        return d;
    }

    public SelectItem[] getSituacaoResultadosItens() {

        SelectItem[] d = {new SelectItem("T", "TODOS"), new SelectItem("N", "NORMAIS"), new SelectItem("F", "FLAG"), new SelectItem("B", "BLOQUEADOS"), new SelectItem("I", "INCONPATIVEL")};
        return d;
    }

    public SelectItem[] getSituacaoColetaItens() {

        SelectItem[] d = {new SelectItem("T", "TODOS"), new SelectItem("C", "COLETADOS"), new SelectItem("N", "NÃO COLETADOS")};
        return d;
    }

    public SelectItem[] getSituacaoReqItens() {

        SelectItem[] d = {new SelectItem("T", "TODOS"), new SelectItem("R", "ROTINA"), new SelectItem("U", "URGENTES"), new SelectItem("A", "AGENDADOS"), new SelectItem("RE", "RESTRIÇÃO")};
        return d;
    }

    public SelectItem[] getSearchTypeItens() {
        SelectItem[] d = {new SelectItem("RG", "RG"), new SelectItem("CPF", "CPF"), new SelectItem("SUS", "SUS"), new SelectItem("R.C.", "R.C."), new SelectItem("Req", "Req"), new SelectItem("Nome", "Nome"), new SelectItem("Pront.", "Pront.")};
        return d;
    }

    public SelectItem[] getSelecaoMes() {
        SelectItem[] d = {new SelectItem("jan", "Janeiro"), new SelectItem("fev", "Fevereiro"), new SelectItem("mar", "Mar�o"), new SelectItem("abr", "Abril"), new SelectItem("mai", "Maio"), new SelectItem("jun", "Junho"), new SelectItem("jul", "Julho"), new SelectItem("ago", "Agosto"), new SelectItem("set", "Setembro"), new SelectItem("out", "Outubro"), new SelectItem("nov", "Novembro"), new SelectItem("dez", "Dezembro")};
        return d;
    }

    public SelectItem[] getTipoImpressao() {
        SelectItem[] d = {new SelectItem("ana", "Analitico"), new SelectItem("sin", "Sintético")};
        return d;
    }

    public SelectItem[] getDescExame() {
        SelectItem[] d = {new SelectItem("normal", "Tabela Normal"), new SelectItem("original", "Tabela Original")};
        return d;
    }

    public SelectItem[] getSelecaoAtravezDeData() {
        SelectItem[] d = {new SelectItem("cadastro", "do cadastra"), new SelectItem("faturamento", "do faturamento")};
        return d;
    }

    public SelectItem[] getTipoPesquisa() {
        SelectItem[] d = {new SelectItem("lote", "Lote"), new SelectItem("usuGeraLote", "Usu. Gera Lote"), new SelectItem("usuExclLote", "Usu. Exclui Lote"), new SelectItem("usuFechaLote", "Usu. Fecha Lote"), new SelectItem("qtdExa", "Qtd. Exames")};
        return d;
    }

    public SelectItem[] getTipoPesquisaProntuarioPop() {
        SelectItem[] d = {new SelectItem("prontuario", "Prontuário"), new SelectItem("nome", "Nome")};
        return d;
    }

    public SelectItem[] getOrdemRelatorio() {
        SelectItem[] d = {new SelectItem("U", "Unidade"), new SelectItem("C", "Convênio")};
        return d;
    }
    
    public SelectItem[] getJasperFormatstens() {

        SelectItem[] d = {new SelectItem("pdf", "pdf"), new SelectItem("xlsx", "xlsx")};
        return d;
    }

    public static Map<LabConfigIngresso, LabConfigIngresso> getMapLabConfigIngresso(String strDbName) {
        if (mapLabConfigIngresso == null) {
            List<LabConfigIngresso> llci = (List<LabConfigIngresso>) OracleHelper.getListObject(LabConfigIngresso.class, strDbName);
            mapLabConfigIngresso = new HashMap<LabConfigIngresso, LabConfigIngresso>();
            for (LabConfigIngresso lci : llci) {
                mapLabConfigIngresso.put(lci, lci);
            }
        }
        return mapLabConfigIngresso;
    }

    public static Map<String, LabUnidadeMedida> getMapLabUnidadeMedida(String strDbName) {
        if (mapLabUnidadeMedida == null) {
            List<LabUnidadeMedida> l = (List<LabUnidadeMedida>) OracleHelper.getListObject(LabUnidadeMedida.class, strDbName);
            mapLabUnidadeMedida = new HashMap<String, LabUnidadeMedida>();
            for (LabUnidadeMedida lum : l) {
                mapLabUnidadeMedida.put(lum.getUnmStCodigo()+strDbName, lum);
            }
        }
        return mapLabUnidadeMedida;
    }

    public static Map<LabLegenda, LabLegenda> getMapLabLegenda(String strDbName) {
        if (mapLabLegenda == null) {
            List<LabLegenda> l = (List<LabLegenda>) OracleHelper.getListObject(LabLegenda.class, strDbName);
            mapLabLegenda = new HashMap<LabLegenda, LabLegenda>();
            for (LabLegenda ll : l) {
                mapLabLegenda.put(ll, ll);
            }
        }
        return mapLabLegenda;
    }

    public static Map<String, LabLegenda> getMapLabLegendaConsultaLaudo() {
        if (mapLabLegendaConsultaLaudo == null) {
            mapLabLegendaConsultaLaudo = new HashMap<String, LabLegenda>(3);
            mapLabLegendaConsultaLaudo.put("016", new LabLegenda("016", "IMPRESSO", 0, 65535));
            mapLabLegendaConsultaLaudo.put("011", new LabLegenda("011", "ASSINADO", 16777215, 14117632));
            mapLabLegendaConsultaLaudo.put("999", new LabLegenda("999", "EM ANDAMENTO", 16777215, 14117632));
        }
        return mapLabLegendaConsultaLaudo;
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[4096];
        int len = 0;
        while ((len = input.read(buf)) > -1) {
            output.write(buf, 0, len);
        }
        return output.toByteArray();
    }
}
