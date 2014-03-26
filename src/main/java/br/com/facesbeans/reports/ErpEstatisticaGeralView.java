/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.reports;

import br.com.facesbeans.jobpush.RelatorioStorage;
import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.*;
import br.com.hibernate.entities.*;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import br.com.utils.pdfmaker.PdfDados;
import br.com.utils.pdfmaker.PdfDadosSender;
import br.com.utils.tipstricks.DateRange;
import com.thoughtworks.xstream.XStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author eros
 */
@ManagedBean(name="erpEstatisticaGeralViewBean")
@SessionScoped
public class ErpEstatisticaGeralView implements Serializable{
    
    
    private PortalView portal;
    private String strJasperFormat = "pdf";
    
    private String strReportType = "MP";
    
    private Date dtStart;
    private Date dtEnd;
    
    private Date dtValidade;
    private boolean blValidade;
    
    //All
    private ErpUnidade erpUnidade;
    private List<ErpUnidade> listErpUnidade;
    
    
    
    
//    private String strMarca ;
    private ErpMarcas erpMarcas;
    
    
    private ErpRegional erpRegiona;
    
//    private String strRegional;
    private String strUnidade;
//    private String strEstabelecimento;
    
    private ErpEstabelecimento erpEstabelecimento;
    
    
    //Top Items
    private String strQtdItems = "10";
    
    //Solicitados //RINA //Custos // Demanda Urgente // Items a Vencer // Status dos Pedidos // Tipos de Pedido //Abastecimento
    private ErpCcusto  erpCcusto;
//    private String strRequisitante;
//    private String strPosto;
    private ErpOrigem erpOrigem;
    
    //RINA
    private boolean blDestacarCentroDeCusto = false;
    private String strItemType ;

    //Custos  // Geral // Itens Parametrizados
    private String strCentroCustoType ;
    
    //Custos
    private String strRotaType ;
    private boolean blAgruparVlrPorUnidades = false;
    private boolean blAgruparVlrPorUnidadesMostrarSubValores = false;
    private String strDataType  = "cadastro";
    private List<CentroDeCusto>  listCentroDeCustoItems;
    private List<CentroDeCusto>  listSelectedCentroDeCusto;
    
    private List<Rota>  listRotaItems;
    private List<Rota>  listSelectedRota;
    
    // Demanda Urgente
    private boolean blSomenteAumentoDemanda = false;
    private boolean blSomenteUrgente = false;
    
    // Geral
    private String strFiltroRelatorioGeral = "t";
    private boolean blOrdenarPorCentroDeCusto = false;
    
    
    
    // Items a Vencer
    private Date dtValidadeItemsAVencer;
    private boolean blSomenteVencidos = false;
    private boolean blSomenteItemsValidadeSelecionada = false;
    private boolean blSomenteAVencerProximoMes = false;
    
    
    // Items a Parametrizado
    private CentroDeCusto centroCusto;
    
    
    
    // Postos
//    private String strCodigoDoItem;
    private ErpItem  erpItem;
    
    // Tipos de Pedido //Abastecimento
    private String strUF;
    private List<UnidadeDeNegocio>  listUnidadeDeNegocioItems;
    private List<UnidadeDeNegocio>  listSelectedUnidadeDeNegocio;
    
    
    // Tipos de Pedido
    private boolean blTipoPedidoNormal = false;
    private boolean blTipoPedidoUrgente = false;
    private boolean blTipoPedidoPendencia = false;
    private boolean blTipoPedidoSelab = false;
    private boolean blTipoPedidoApoio = false;
    private boolean blTipoPedidoPatrimonio = false;
    private boolean blTipoPedidoControlados = false;
    private boolean blTipoPedidoMaisDemanda = false;
    private boolean blTipoPedidoManuais = false;
    private boolean blTipoPedidoVacinas = false;
    private boolean blTipoPedidoAhVencer = false;
    private boolean blTipoPedidoMedicamentos = false;
    
    
    private boolean blTopReports = true;
    private boolean blSolicitadosReports = false;
    private boolean blRINAReports = false;
    private boolean blCustosReports = false;
    private boolean blDemandaUrgenteReports = false;
    private boolean blGeralReports = false;
    private boolean blItemsAVencerReports = false;
    private boolean blItemsPostosReports = false;
    private boolean blStatusPedidoReports = false;
    private boolean blTiposPedidoReports = false;
    private boolean blAbastecimentoReports = false;
    private boolean blItensParametrizados = false;
    private boolean blInspecaoDeItensReports = false;
    
    

    public ErpEstatisticaGeralView() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        listCentroDeCustoItems = CentroDeCustoConverter.centroCustoDB;
        listRotaItems = RotaConverter.rotaDB;
        listUnidadeDeNegocioItems = UnidadeDeNegocioConverter.unidadeDeNegocioDB;
        listErpUnidade = ErpEstatisticaGeralDao.grabErpUnidadeByExpression(portal.getLabUsuario().getUsuStCodigo(), portal.getStrDbName());
    }
    
    @PostConstruct
    private void initPostConstruction(){
         //TODO fixing fucking DB Date
//        this.dtStart = OracleHelper.getDateFromDB(portal.getStrDbName());
//        this.dtEnd = OracleHelper.getDateFromDB(portal.getStrDbName());
//        this.dtValidade = OracleHelper.getDateFromDB(portal.getStrDbName());
        
        this.dtStart = new Date();
        this.dtEnd = new Date();
        this.dtValidade = new Date();
        this.dtValidadeItemsAVencer = new Date();
    }
    
    
    
    public SelectItem[] getErpUnidadeTypeItens() {
        SelectItem[] d = null;
        if(this.listErpUnidade != null && this.listErpUnidade.size()>0){
            d = new SelectItem[listErpUnidade.size()+2];
            d[0] = new SelectItem("-------------------------------", "-------------------------------");
            d[1] = new SelectItem(portal.getLabUnidade().getUniStCodigo(), portal.getLabUnidade().getUniStCodigo()+" "+portal.getLabUnidade().getUniStDescricao());
//            this.erpUnidade = new ErpUnidade(portal.getLabUnidade().getUniStCodigo(), portal.getLabUnidade().getUniStDescricao());
            for (int i = 0; i < listErpUnidade.size(); i++) {
                ErpUnidade uni = listErpUnidade.get(i);
                d[i+2] = new SelectItem(uni.getUniStCodigo(), uni.getUniStCodigo()+" "+uni.getUniStDescricao());
            }
        }else{
            d = new SelectItem[2];
            d[0] = new SelectItem("-------------------------------", "-------------------------------");
            d[1] = new SelectItem(portal.getLabUnidade().getUniStCodigo(), portal.getLabUnidade().getUniStCodigo()+" "+portal.getLabUnidade().getUniStDescricao());
        }
        return d;
    }

    public List<ErpMarcas>   autoCompleteMarca(String query){
               List<ErpMarcas> list = ErpEstatisticaGeralDao.grabErpMarcasByExpression(query.toUpperCase(), portal.getLabUsuario().getUsuStCodigo(),portal.getStrDbName());
           if(list == null){
               portal.popMsg(1, true, "Não há Marcas com o código :"+query);
           }
           return list;
    }
    
    
    public List<ErpRegional>   autoCompleteRegional(String query){
               List<ErpRegional> list = ErpEstatisticaGeralDao.grabErpRegionalByExpression(query.toUpperCase(), portal.getStrDbName());
           if(list == null){
               portal.popMsg(1, true, "Não há Regional  :"+query);
           }
           return list;
    }
    
     public List<ErpEstabelecimento>   autoCompleteEstabelecimento(String query){
         List<ErpEstabelecimento> list = null;
         if(erpRegiona != null){
              list = ErpEstatisticaGeralDao.grabErpEstabelecimentoByExpression(query.toUpperCase(), erpRegiona,portal.getStrDbName());
         }else{
             portal.popMsg(1, true, "Escolha uma Regional primerio ");
         }
           if(list == null){
               portal.popMsg(1, true, "Não há Estabelecimento :"+query);
           }
           return list;
    }
     
     public List<ErpCcusto>   autoCompleteCentroDeCusto(String query){
         List<ErpCcusto> list = null;
         if(erpEstabelecimento != null){
             list = ErpEstatisticaGeralDao
                     .grabErpCcustoByExpression(query.toUpperCase(), portal.getLabUsuario().getUsuStCodigo(),erpEstabelecimento.getErpEstabelecimentoPK().getEstStCodigo(),erpUnidade.getUniStCodigo(),portal.getStrDbName());
                if(list == null){
                    portal.popMsg(1, true, "Não há Centro de Custo  :"+query);
                }
         }else{
             portal.popMsg(1, true, "Escolha primeiro um Estabelecimento......");
         }
               
           return list;
    }
     
     public List<ErpItem>   autoCompleteErpItem(String query){
               List<ErpItem> list = ErpEstatisticaGeralDao.grabErpItemByExpression(query.toUpperCase(), portal.getStrDbName());  
           if(list == null){
               portal.popMsg(1, true, "Não há Itens com  :"+query);
           }
           return list;
    }
     
     public List<ErpOrigem>   autoCompleteErpOrigem(String query){
               List<ErpOrigem> list = ErpEstatisticaGeralDao.grabErpOrigemByExpression(query.toUpperCase(),portal.getLabUnidade().getUniStCodigo(), portal.getStrDbName()); 
           if(list == null){
               portal.popMsg(1, true, "Não há Origens com  :"+query);
           }
           return list;
    }

    public List<ErpUnidade> getListErpUnidade() {
        return listErpUnidade;
    }

    public void setListErpUnidade(List<ErpUnidade> listErpUnidade) {
        this.listErpUnidade = listErpUnidade;
    }

    public ErpUnidade getErpUnidade() {
        return erpUnidade;
    }

    public void setErpUnidade(ErpUnidade erpUnidade) {
        this.erpUnidade = erpUnidade;
    }
     

    public ErpEstabelecimento getErpEstabelecimento() {
        return erpEstabelecimento;
    }

    public void setErpEstabelecimento(ErpEstabelecimento erpEstabelecimento) {
        this.erpEstabelecimento = erpEstabelecimento;
    }

    public ErpItem getErpItem() {
        return erpItem;
    }

    public void setErpItem(ErpItem erpItem) {
        this.erpItem = erpItem;
    }

    public ErpRegional getErpRegiona() {
        return erpRegiona;
    }

    public void setErpRegiona(ErpRegional erpRegiona) {
        this.erpRegiona = erpRegiona;
    }

    public ErpMarcas getErpMarcas() {
        return erpMarcas;
    }

    public void setErpMarcas(ErpMarcas erpMarcas) {
        this.erpMarcas = erpMarcas;
    }

    public CentroDeCusto getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(CentroDeCusto centroCusto) {
        this.centroCusto = centroCusto;
    }

    public ErpCcusto getErpCcusto() {
        return erpCcusto;
    }

    public void setErpCcusto(ErpCcusto erpCcusto) {
        this.erpCcusto = erpCcusto;
    }

    
    
    public boolean isBlSomenteAVencerProximoMes() {
        return blSomenteAVencerProximoMes;
    }

    public void setBlSomenteAVencerProximoMes(boolean blSomenteAVencerProximoMes) {
        this.blSomenteAVencerProximoMes = blSomenteAVencerProximoMes;
    }

    public boolean isBlSomenteItemsValidadeSelecionada() {
        return blSomenteItemsValidadeSelecionada;
    }

    public void setBlSomenteItemsValidadeSelecionada(boolean blSomenteItemsValidadeSelecionada) {
        this.blSomenteItemsValidadeSelecionada = blSomenteItemsValidadeSelecionada;
    }

    public boolean isBlSomenteVencidos() {
        return blSomenteVencidos;
    }

    public void setBlSomenteVencidos(boolean blSomenteVencidos) {
        this.blSomenteVencidos = blSomenteVencidos;
    }

    public boolean isBlValidade() {
        return blValidade;
    }

    public void setBlValidade(boolean blValidade) {
        this.blValidade = blValidade;
    }

    public Date getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(Date dtValidade) {
        this.dtValidade = dtValidade;
    }
    
    public void handleSelectCompleteMarca(SelectEvent event) {  
        portal.popMsg(999, false, "Marca Escolhida:" + event.getObject());
    }  
    
    public void handleSelectCompleteRegional(SelectEvent event) {  
        portal.popMsg(999, false, "Regional Escolhida "+this.erpRegiona.getRgiStDescricao() );
        erpEstabelecimento = null;
    }  

    public void handleSelectCompleteEstabelecimento(SelectEvent event) {  
        if(erpEstabelecimento != null){
            portal.popMsg(999, false, "Estabelecimento Escolhida "+this.erpEstabelecimento.getEstStDescricao() );
            erpCcusto = null;
        }
        
    }  
    
    public void handleSelectCompleteCentroCusto(SelectEvent event) {  
        portal.popMsg(999, false, "Requisitante/Centro Custo Escolhido "+this.erpCcusto.getCcuStCodigo()+" - "+this.erpCcusto.getCcuStDescricao() );
    }  
    
    public void handleSelectCompleteErpItem(SelectEvent event) {  
        portal.popMsg(999, false, "Item Escolhido "+this.erpItem.getItmStCodigo()+" - "+this.erpItem.getItmStDescricao() );
    }  
    
    public void handleSelectCompleteErpOrigem(SelectEvent event) {  
        portal.popMsg(999, false, "Item Escolhido "+this.erpOrigem.getErpOrigemPK().getOriStCodigo()+" - "+this.erpOrigem.getOriStDescricao() );
    }  
    
    public boolean isBlItensParametrizados() {
        return blItensParametrizados;
    }

    public void setBlItensParametrizados(boolean blItensParametrizados) {
        this.blItensParametrizados = blItensParametrizados;
    }

    public List<UnidadeDeNegocio> getListUnidadeDeNegocioItems() {
        return listUnidadeDeNegocioItems;
    }

    public void setListUnidadeDeNegocioItems(List<UnidadeDeNegocio> listUnidadeDeNegocioItems) {
        this.listUnidadeDeNegocioItems = listUnidadeDeNegocioItems;
    }

    public List<UnidadeDeNegocio> getListSelectedUnidadeDeNegocio() {
        return listSelectedUnidadeDeNegocio;
    }

    public void setListSelectedUnidadeDeNegocio(List<UnidadeDeNegocio> listSelectedUnidadeDeNegocio) {
        this.listSelectedUnidadeDeNegocio = listSelectedUnidadeDeNegocio;
    }

    public List<Rota> getListRotaItems() {
        return listRotaItems;
    }

    public void setListRotaItems(List<Rota> listRotaItems) {
        this.listRotaItems = listRotaItems;
    }

    public List<Rota> getListSelectedRota() {
        return listSelectedRota;
    }

    public void setListSelectedRota(List<Rota> listSelectedRota) {
        this.listSelectedRota = listSelectedRota;
    }

    public List<CentroDeCusto> getListCentroDeCustoItems() {
        return listCentroDeCustoItems;
    }

    public void setListCentroDeCustoItems(List<CentroDeCusto> listCentroDeCustoItems) {
        this.listCentroDeCustoItems = listCentroDeCustoItems;
    }
    
    

    public List<CentroDeCusto> getListSelectedCentroDeCusto() {
        return listSelectedCentroDeCusto;
    }

    public void setListSelectedCentroDeCusto(List<CentroDeCusto> listSelectedCentroDeCusto) {
        this.listSelectedCentroDeCusto = listSelectedCentroDeCusto;
    }
    
    

    public boolean isBlAgruparVlrPorUnidades() {
        return blAgruparVlrPorUnidades;
    }

    public void setBlAgruparVlrPorUnidades(boolean blAgruparVlrPorUnidades) {
        this.blAgruparVlrPorUnidades = blAgruparVlrPorUnidades;
    }

    public boolean isBlAgruparVlrPorUnidadesMostrarSubValores() {
        return blAgruparVlrPorUnidadesMostrarSubValores;
    }

    public void setBlAgruparVlrPorUnidadesMostrarSubValores(boolean blAgruparVlrPorUnidadesMostrarSubValores) {
        this.blAgruparVlrPorUnidadesMostrarSubValores = blAgruparVlrPorUnidadesMostrarSubValores;
    }

    public boolean isBlDestacarCentroDeCusto() {
        return blDestacarCentroDeCusto;
    }

    public void setBlDestacarCentroDeCusto(boolean blDestacarCentroDeCusto) {
        this.blDestacarCentroDeCusto = blDestacarCentroDeCusto;
    }

    public boolean isBlOrdenarPorCentroDeCusto() {
        return blOrdenarPorCentroDeCusto;
    }

    public void setBlOrdenarPorCentroDeCusto(boolean blOrdenarPorCentroDeCusto) {
        this.blOrdenarPorCentroDeCusto = blOrdenarPorCentroDeCusto;
    }

    public boolean isBlSomenteAumentoDemanda() {
        return blSomenteAumentoDemanda;
    }

    public void setBlSomenteAumentoDemanda(boolean blSomenteAumentoDemanda) {
        this.blSomenteAumentoDemanda = blSomenteAumentoDemanda;
    }

    public boolean isBlSomenteUrgente() {
        return blSomenteUrgente;
    }

    public void setBlSomenteUrgente(boolean blSomenteUrgente) {
        this.blSomenteUrgente = blSomenteUrgente;
    }

    public boolean isBlTipoPedidoAhVencer() {
        return blTipoPedidoAhVencer;
    }

    public void setBlTipoPedidoAhVencer(boolean blTipoPedidoAhVencer) {
        this.blTipoPedidoAhVencer = blTipoPedidoAhVencer;
    }

    public boolean isBlTipoPedidoApoio() {
        return blTipoPedidoApoio;
    }

    public void setBlTipoPedidoApoio(boolean blTipoPedidoApoio) {
        this.blTipoPedidoApoio = blTipoPedidoApoio;
    }

    public boolean isBlTipoPedidoControlados() {
        return blTipoPedidoControlados;
    }

    public void setBlTipoPedidoControlados(boolean blTipoPedidoControlados) {
        this.blTipoPedidoControlados = blTipoPedidoControlados;
    }

    public boolean isBlTipoPedidoMaisDemanda() {
        return blTipoPedidoMaisDemanda;
    }

    public void setBlTipoPedidoMaisDemanda(boolean blTipoPedidoMaisDemanda) {
        this.blTipoPedidoMaisDemanda = blTipoPedidoMaisDemanda;
    }

    public boolean isBlTipoPedidoManuais() {
        return blTipoPedidoManuais;
    }

    public void setBlTipoPedidoManuais(boolean blTipoPedidoManuais) {
        this.blTipoPedidoManuais = blTipoPedidoManuais;
    }

    public boolean isBlTipoPedidoMedicamentos() {
        return blTipoPedidoMedicamentos;
    }

    public void setBlTipoPedidoMedicamentos(boolean blTipoPedidoMedicamentos) {
        this.blTipoPedidoMedicamentos = blTipoPedidoMedicamentos;
    }

    public boolean isBlTipoPedidoNormal() {
        return blTipoPedidoNormal;
    }

    public void setBlTipoPedidoNormal(boolean blTipoPedidoNormal) {
        this.blTipoPedidoNormal = blTipoPedidoNormal;
    }

    public boolean isBlTipoPedidoPatrimonio() {
        return blTipoPedidoPatrimonio;
    }

    public void setBlTipoPedidoPatrimonio(boolean blTipoPedidoPatrimonio) {
        this.blTipoPedidoPatrimonio = blTipoPedidoPatrimonio;
    }

    public boolean isBlTipoPedidoPendencia() {
        return blTipoPedidoPendencia;
    }

    public void setBlTipoPedidoPendencia(boolean blTipoPedidoPendencia) {
        this.blTipoPedidoPendencia = blTipoPedidoPendencia;
    }

    public boolean isBlTipoPedidoSelab() {
        return blTipoPedidoSelab;
    }

    public void setBlTipoPedidoSelab(boolean blTipoPedidoSelab) {
        this.blTipoPedidoSelab = blTipoPedidoSelab;
    }

    public boolean isBlTipoPedidoUrgente() {
        return blTipoPedidoUrgente;
    }

    public void setBlTipoPedidoUrgente(boolean blTipoPedidoUrgente) {
        this.blTipoPedidoUrgente = blTipoPedidoUrgente;
    }

    public boolean isBlTipoPedidoVacinas() {
        return blTipoPedidoVacinas;
    }

    public void setBlTipoPedidoVacinas(boolean blTipoPedidoVacinas) {
        this.blTipoPedidoVacinas = blTipoPedidoVacinas;
    }

    public Date getDtValidadeItemsAVencer() {
        return dtValidadeItemsAVencer;
    }

    public void setDtValidadeItemsAVencer(Date dtValidadeItemsAVencer) {
        this.dtValidadeItemsAVencer = dtValidadeItemsAVencer;
    }

    public String getStrCentroCustoType() {
        return strCentroCustoType;
    }

    public void setStrCentroCustoType(String strCentroCustoType) {
        this.strCentroCustoType = strCentroCustoType;
    }

    

    public String getStrDataType() {
        return strDataType;
    }

    public void setStrDataType(String strDataType) {
        this.strDataType = strDataType;
    }

    public String getStrFiltroRelatorioGeral() {
        return strFiltroRelatorioGeral;
    }

    public void setStrFiltroRelatorioGeral(String strFiltroRelatorioGeral) {
        this.strFiltroRelatorioGeral = strFiltroRelatorioGeral;
    }

    public String getStrItemType() {
        return strItemType;
    }

    public void setStrItemType(String strItemType) {
        this.strItemType = strItemType;
    }

    public ErpOrigem getErpOrigem() {
        return erpOrigem;
    }

    public void setErpOrigem(ErpOrigem erpOrigem) {
        this.erpOrigem = erpOrigem;
    }


    public String getStrRotaType() {
        return strRotaType;
    }

    public void setStrRotaType(String strRotaType) {
        this.strRotaType = strRotaType;
    }

    public String getStrUF() {
        return strUF;
    }

    public void setStrUF(String strUF) {
        this.strUF = strUF;
    }
    
    public String getStrQtdItems() {
        return strQtdItems;
    }

    public void setStrQtdItems(String strQtdItems) {
        this.strQtdItems = strQtdItems;
    }

    public boolean isBlInspecaoDeItensReports() {
        return blInspecaoDeItensReports;
    }

    public void setBlInspecaoDeItensReports(boolean blInspecaoDeItensReports) {
        this.blInspecaoDeItensReports = blInspecaoDeItensReports;
    }

    
    
    public void changePageByReportTypePicListener(){
        this.everyBooleanToDefault();
        if(this.strReportType.equalsIgnoreCase("MP")){
            everyBooleanToDefault();
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("IS")){
            everyBooleanToDefault();
            blTopReports = false;
            blSolicitadosReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("RINA")){
            everyBooleanToDefault();
            blTopReports = false;
            blRINAReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("C")){
            everyBooleanToDefault();
            blTopReports = false;
            blCustosReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("DU")){
            everyBooleanToDefault();
            blTopReports = false;
            blDemandaUrgenteReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("G")){
            everyBooleanToDefault();
            blTopReports = false;
            blGeralReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("IV")){
            everyBooleanToDefault();
            blTopReports = false;
            blItemsAVencerReports = true;
            blValidade = true;
        }else if(this.strReportType.equalsIgnoreCase("P")){
            everyBooleanToDefault();
            blTopReports = false;
            blItemsPostosReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("SP")){
            everyBooleanToDefault();
            blTopReports = false;
            blStatusPedidoReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("TP")){
            everyBooleanToDefault();
            blTopReports = false;
            blTiposPedidoReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("A")){
            everyBooleanToDefault();
            blTopReports = false;
            blAbastecimentoReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("II")){
            everyBooleanToDefault();
            blTopReports = false;
            blInspecaoDeItensReports = true;
            blValidade = false;
        }else if(this.strReportType.equalsIgnoreCase("IP")){
            everyBooleanToDefault();
            blTopReports = false;
            blItensParametrizados = true;
            blValidade = false;
        }
    }
    
    private void everyBooleanToDefault(){
        blTopReports = true;
        blSolicitadosReports = false;
        blRINAReports = false;
        blCustosReports = false;
        blDemandaUrgenteReports = false;
        blGeralReports = false;
        blItemsAVencerReports = false;
        blItemsPostosReports = false;
        blStatusPedidoReports = false;
        blTiposPedidoReports = false;
        blAbastecimentoReports = false;
        blInspecaoDeItensReports = false;
        blItensParametrizados = false;
    }
    
    

   
    public String getStrUnidade() {
        return strUnidade;
    }

    public void setStrUnidade(String strUnidade) {
        this.strUnidade = strUnidade;
    }
    
    public void changeErpUnidadePicListener(){
        if(strUnidade != null){
            erpUnidade = (ErpUnidade) OracleHelper.getObject(ErpUnidade.class, strUnidade, portal.getStrDbName());
            if(erpUnidade == null){
                portal.popMsg(0, true, "Unidade Invalida..........");
            }else{
                portal.popMsg(0, false, "Unidade Escolhida: "+erpUnidade.getUniStCodigo()+" - "+erpUnidade.getUniStDescricao());
            }
        }
    }

    public String getStrReportType() {
        return strReportType;
    }

    public void setStrReportType(String strReportType) {
        this.strReportType = strReportType;
    }

    public String getStrJasperFormat() {
        return strJasperFormat;
    }

    public void setStrJasperFormat(String strJasperFormat) {
        this.strJasperFormat = strJasperFormat;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    public Date getDtStart() {
        return dtStart;
    }

    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
    }


    public boolean isBlAbastecimentoReports() {
        return blAbastecimentoReports;
    }

    public void setBlAbastecimentoReports(boolean blAbastecimentoReports) {
        this.blAbastecimentoReports = blAbastecimentoReports;
    }

    public boolean isBlCustosReports() {
        return blCustosReports;
    }

    public void setBlCustosReports(boolean blCustosReports) {
        this.blCustosReports = blCustosReports;
    }

    public boolean isBlDemandaUrgenteReports() {
        return blDemandaUrgenteReports;
    }

    public void setBlDemandaUrgenteReports(boolean blDemandaUrgenteReports) {
        this.blDemandaUrgenteReports = blDemandaUrgenteReports;
    }

    public boolean isBlGeralReports() {
        return blGeralReports;
    }

    public void setBlGeralReports(boolean blGeralReports) {
        this.blGeralReports = blGeralReports;
    }

    public boolean isBlItemsAVencerReports() {
        return blItemsAVencerReports;
    }

    public void setBlItemsAVencerReports(boolean blItemsAVencerReports) {
        this.blItemsAVencerReports = blItemsAVencerReports;
    }

    public boolean isBlItemsPostosReports() {
        return blItemsPostosReports;
    }

    public void setBlItemsPostosReports(boolean blItemsPostosReports) {
        this.blItemsPostosReports = blItemsPostosReports;
    }

    public boolean isBlRINAReports() {
        return blRINAReports;
    }

    public void setBlRINAReports(boolean blRINAReports) {
        this.blRINAReports = blRINAReports;
    }

    public boolean isBlSolicitadosReports() {
        return blSolicitadosReports;
    }

    public void setBlSolicitadosReports(boolean blSolicitadosReports) {
        this.blSolicitadosReports = blSolicitadosReports;
    }

    public boolean isBlStatusPedidoReports() {
        return blStatusPedidoReports;
    }

    public void setBlStatusPedidoReports(boolean blStatusPedidoReports) {
        this.blStatusPedidoReports = blStatusPedidoReports;
    }

    public boolean isBlTiposPedidoReports() {
        return blTiposPedidoReports;
    }

    public void setBlTiposPedidoReports(boolean blTiposPedidoReports) {
        this.blTiposPedidoReports = blTiposPedidoReports;
    }

    public boolean isBlTopReports() {
        return blTopReports;
    }

    public void setBlTopReports(boolean blTopReports) {
        this.blTopReports = blTopReports;
    }
    
    
    public void validateDateRange(DateSelectEvent event) {

        if (!DateRange.rangeVerifierMonths(3, dtStart, dtEnd)) {
            this.portal.popMsg(2, true, "O intervalo entre datas é de no maximo " + 3 + " mês.");
        } else {
            this.portal.popMsg(1000, false, "");
        }
    }
    
    public void cleanUpEveryThing() {

        
        
        
        strJasperFormat = "pdf";
//        strReportType = "MP";
        dtStart = new Date();
        dtEnd = new Date();
        dtValidade = new Date();
        
        erpUnidade = new ErpUnidade(portal.getLabUnidade().getUniStCodigo(), portal.getLabUnidade().getUniStDescricao());
        
        erpMarcas= null;
        erpRegiona= null;
        
        strUnidade= null;
        erpEstabelecimento = null;
        strQtdItems = "10";
        erpCcusto = null;
        erpOrigem = null;
        blDestacarCentroDeCusto = false;
        strItemType = null;
        strCentroCustoType = null;
        strRotaType = null;
        blAgruparVlrPorUnidades = false;
        blAgruparVlrPorUnidadesMostrarSubValores = false;
        strDataType = "cadastro";
        listSelectedCentroDeCusto = null;
        listSelectedRota = null;
        blSomenteAumentoDemanda = false;
        blSomenteUrgente = false;
        strFiltroRelatorioGeral = "t";
        blOrdenarPorCentroDeCusto = false;
        dtValidadeItemsAVencer = null;
        blSomenteVencidos = false;
        blSomenteItemsValidadeSelecionada = false;
        blSomenteAVencerProximoMes = false;
        centroCusto = null;
        erpItem = null;
        strUF = null;
        listSelectedUnidadeDeNegocio = null;
        blTipoPedidoNormal = false;
        blTipoPedidoUrgente = false;
        blTipoPedidoPendencia = false;
        blTipoPedidoSelab = false;
        blTipoPedidoApoio = false;
        blTipoPedidoPatrimonio = false;
        blTipoPedidoControlados = false;
        blTipoPedidoMaisDemanda = false;
        blTipoPedidoManuais = false;
        blTipoPedidoVacinas = false;
        blTipoPedidoAhVencer = false;
        blTipoPedidoMedicamentos = false;
        
//        blTopReports = true;
//        blSolicitadosReports = false;
//        blRINAReports = false;
//        blCustosReports = false;
//        blDemandaUrgenteReports = false;
//        blGeralReports = false;
//        blItemsAVencerReports = false;
//        blItemsPostosReports = false;
//        blStatusPedidoReports = false;
//        blTiposPedidoReports = false;
//        blAbastecimentoReports = false;
//        blItensParametrizados = false;
//        blInspecaoDeItensReports = false;

    }
    
    public void makeErpRelatorioGeral() {

        RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
        if (relatorioStorage.blockByPdfUnfinish()) {
            if (!DateRange.rangeVerifierMonths(ArrayItems.intMaximumThreeMonths, dtStart, dtEnd)) {
                this.portal.popMsg(2, true, "O intervalo entre datas é de no maximo " + ArrayItems.intMaximumThreeMonths + " mês.");
            } else {
                makePdf();
            }
        } else {
            portal.popMsg(0, true, "Não é possivel solicitar mais relatorios enquanto " + ArrayItems.intMaximumRelatorios + " ou mais estiverem ainda sendo feitos.");
        }

    }
    
    private void makePdf(){
        
        Date dtRightNow = OracleHelper.getDateFromDB(portal.getStrDbName());
        
         boolean blMakePdf = true;
         
//         if (erpUnidade == null) {
//            blMakePdf = false;
//            portal.popMsg(1, true, "Escolha uma Unidade e faça a pesquisa....");
//        }
         
        List<String> listStrRotas = new ArrayList<String>();
        List<String> listStrCentroCusto = new ArrayList<String>();
        List<String> listStrUnidadeDeNegocio = new ArrayList<String>();
        if(listSelectedCentroDeCusto != null && listStrCentroCusto.size()>0){
                for (CentroDeCusto cdc : listSelectedCentroDeCusto) {
                    listStrCentroCusto.add(cdc.getCodigo());
                }
        }
        
        if(listSelectedRota != null && listSelectedRota.size()>0){for (Rota rota : listSelectedRota) {listStrRotas.add(rota.getCodigo());}}
        
        if(listSelectedUnidadeDeNegocio != null && listSelectedUnidadeDeNegocio.size()>0){for (UnidadeDeNegocio  un : listSelectedUnidadeDeNegocio) {listStrUnidadeDeNegocio.add(un.getCodigo());}}
        
        RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
        
        Map<String,Object> mapAnds4Req  = new HashMap<String, Object>();
        String strDescLabRelatorio = "ERP =>  ";
        mapAnds4Req.put("strReportType", strReportType);
        
        if(erpUnidade != null){
            mapAnds4Req.put("uniStCodigo", erpUnidade); 
        }

        
        if(erpMarcas != null){mapAnds4Req.put("marStCodigo", erpMarcas);}
        if(erpRegiona != null){mapAnds4Req.put("rgiStCodigo", erpRegiona);}
        if(erpEstabelecimento != null){mapAnds4Req.put("estStCodigo", erpEstabelecimento);}
        if(erpCcusto != null){mapAnds4Req.put("ccuStCodigo", erpCcusto);}
        if(erpOrigem != null){mapAnds4Req.put("oriStCodigo", erpOrigem);}
        
        if(this.strReportType.equalsIgnoreCase("MP") && blMakePdf){
            strDescLabRelatorio = strDescLabRelatorio+" Mais Pedidos (Top: "+strQtdItems+")";
            mapAnds4Req.put("top", this.strQtdItems);
        }else if(this.strReportType.equalsIgnoreCase("IS") && blMakePdf){
            strDescLabRelatorio = strDescLabRelatorio+"  Items Solicitados";
        }else if(this.strReportType.equalsIgnoreCase("RINA") && blMakePdf){
            strDescLabRelatorio = strDescLabRelatorio+"RINA  Items não atendidos.";
            mapAnds4Req.put("strItemType", this.strItemType);
        }else if(this.strReportType.equalsIgnoreCase("C") && blMakePdf){
            strDescLabRelatorio = strDescLabRelatorio+" Custos";
            mapAnds4Req.put("listSelectedCentroDeCusto", listStrCentroCusto);
            mapAnds4Req.put("listSelectedRota", listStrRotas);
            mapAnds4Req.put("blAgruparVlrPorUnidades", blAgruparVlrPorUnidades);
            mapAnds4Req.put("blAgruparVlrPorUnidadesMostrarSubValores", blAgruparVlrPorUnidadesMostrarSubValores);
            mapAnds4Req.put("strDataType", strDataType);
            if(this.listSelectedCentroDeCusto != null && this.listSelectedCentroDeCusto.size()>0){
                List<String> cuChTipoList = new ArrayList<String>();
              for(CentroDeCusto cc : listSelectedCentroDeCusto){
                  cuChTipoList.add(cc.getCodigo());
              }  
            mapAnds4Req.put("cuChTipoList", cuChTipoList);  
            }
            
            
        }else if(this.strReportType.equalsIgnoreCase("DU") && blMakePdf ){
            strDescLabRelatorio = strDescLabRelatorio+" Demandas Urgentes";
            mapAnds4Req.put("blSomenteAumentoDemanda", blSomenteAumentoDemanda);
            mapAnds4Req.put("blSomenteUrgente", blSomenteUrgente);
        }else if(this.strReportType.equalsIgnoreCase("G")  && blMakePdf ){
            strDescLabRelatorio = strDescLabRelatorio+" ";
            if(this.listSelectedCentroDeCusto != null && this.listSelectedCentroDeCusto.size()>0){
                List<String> cuChTipoList = new ArrayList<String>();
              for(CentroDeCusto cc : listSelectedCentroDeCusto){
                  cuChTipoList.add(cc.getCodigo());
              }  
            mapAnds4Req.put("cuChTipoList", cuChTipoList);  
            }
            mapAnds4Req.put("strFiltroRelatorioGeral", strFiltroRelatorioGeral);
            if(erpItem != null){
                mapAnds4Req.put("itmStCodigo", erpItem);
            }
            
            mapAnds4Req.put("blOrdenarPorCentroDeCusto", blOrdenarPorCentroDeCusto);
            
        }else if(this.strReportType.equalsIgnoreCase("IV")  && blMakePdf ){
            strDescLabRelatorio = strDescLabRelatorio+"  Itens a vencer";
//            mapAnds4Req.put("listSelectedCentroDeCusto", listStrCentroCusto);
            mapAnds4Req.put("dtValidadeItemsAVencer", this.dtValidadeItemsAVencer);
        }else if(this.strReportType.equalsIgnoreCase("P") && blMakePdf ){
            strDescLabRelatorio = strDescLabRelatorio+"  Postos";
            mapAnds4Req.put("erpItem", this.erpItem);
        }else if(this.strReportType.equalsIgnoreCase("SP")  && blMakePdf ){
            strDescLabRelatorio = strDescLabRelatorio+"  Status do Pedido";
        }else if(this.strReportType.equalsIgnoreCase("TP") && blMakePdf ){
            strDescLabRelatorio = strDescLabRelatorio+"  Tipos do Pedido";
            mapAnds4Req.put("strUF", this.strUF);
            mapAnds4Req.put("blTipoPedidoNormal", this.blTipoPedidoNormal);
            mapAnds4Req.put("blTipoPedidoUrgente", blTipoPedidoUrgente);
            mapAnds4Req.put("blTipoPedidoPendencia", blTipoPedidoPendencia);
            mapAnds4Req.put("blTipoPedidoSelab", blTipoPedidoSelab);
            mapAnds4Req.put("blTipoPedidoApoio", blTipoPedidoApoio);
            mapAnds4Req.put("blTipoPedidoPatrimonio", blTipoPedidoPatrimonio);
            mapAnds4Req.put("blTipoPedidoControlados", blTipoPedidoControlados);
            mapAnds4Req.put("blTipoPedidoMaisDemanda", blTipoPedidoMaisDemanda);
            mapAnds4Req.put("blTipoPedidoManuais", blTipoPedidoManuais);
            mapAnds4Req.put("blTipoPedidoVacinas", blTipoPedidoVacinas);
            mapAnds4Req.put("blTipoPedidoAhVencer", blTipoPedidoAhVencer);
            mapAnds4Req.put("blTipoPedidoMedicamentos", blTipoPedidoMedicamentos);
            
        }else if(this.strReportType.equalsIgnoreCase("A")  && blMakePdf ){
            strDescLabRelatorio = strDescLabRelatorio+"  Abastecimento";
            mapAnds4Req.put("strUF", this.strUF);
            mapAnds4Req.put("usuStCodigo", portal.getLabUsuario().getUsuStCodigo());
            mapAnds4Req.put("listSelectedUnidadeDeNegocio", listStrUnidadeDeNegocio);
        }else if(this.strReportType.equalsIgnoreCase("II") && blMakePdf ){
            strDescLabRelatorio = strDescLabRelatorio+"  Inpeção de Itens";
            mapAnds4Req.put("strUF", this.strUF);
            
            if(this.centroCusto != null){mapAnds4Req.put("centroCusto", centroCusto.getCodigo());}
            
        }else if(this.strReportType.equalsIgnoreCase("IP") && blMakePdf ){
            strDescLabRelatorio = strDescLabRelatorio+"  Itens Parametrizados/Contas";
            mapAnds4Req.put("dtValidade", this.dtValidade);
            mapAnds4Req.put("blSomenteVencidos", blSomenteVencidos);
            mapAnds4Req.put("blSomenteItemsValidadeSelecionada", blSomenteItemsValidadeSelecionada);
            mapAnds4Req.put("blSomenteAVencerProximoMes", blSomenteAVencerProximoMes);
        }
        
        
        if(blMakePdf){
                 XStream xstream = new XStream();
                String fileName = portal.getLabUsuario().getUsuStCodigo() + "_ERP_RELATORIO_GERAL_" + ArrayItems.format4PdfName.format(new Date()) + "."+strJasperFormat; 
                
                PdfDados pd = new PdfDados("",
                "strDateFieldName",
                strDescLabRelatorio ,
                "erprelatoriogeral",
                dtStart,
                dtEnd,
                mapAnds4Req,
                null,
                null,
                null,
                "", 
                portal.getLabUsuario().getUsuStCodigo(), 
                portal.getStrDbName());
                pd.setStrPdfName(ArrayItems.strURLPdfPath + fileName);
                
                LabRelatorios r = new LabRelatorios(
                OracleHelper.getLabRelatorioNextId(portal.getStrDbName()),
                dtRightNow, dtRightNow, 'L', "vazio", portal.getLabUsuario().getUsuStCodigo(), fileName, "relatório em execução \n aguarde.",
                strDescLabRelatorio+ " Dt Inicio: " + ArrayItems.format4PdfName.format(dtStart) + " Dt Fim: " + ArrayItems.format4PdfName.format(dtEnd));
                r.setRelDtTermino(null);
                r.setRelHrTermino(null);
                pd.setStrId(r.getRelInCodigo().toString());
                pd.setStrDbName(portal.getStrDbName());
                pd.setStrUserNome(portal.getLabUsuario().getUsuStCodigo());
                OracleHelper.saveObject(r, portal.getStrDbName());
                relatorioStorage.addAndSorReports(r);
                PdfDadosSender pds = new PdfDadosSender();
                pds.pdfSender(xstream.toXML(pd));
                portal.popMsg(999, false, "Relatório enviado com sucesso......");
        }
        

        
    }
    
    public SelectItem[] getDataTypeItems() {
        SelectItem[] d = {new SelectItem("C", "Data de Cadastro"), new SelectItem("E", "Data de Entrega")};
        return d;
    }
    
    public SelectItem[] getFiltroRelatorioGeralItems() {
        SelectItem[] d = {new SelectItem("T", "Todos"), new SelectItem("IA", "Somente items atendidos"), new SelectItem("IN", "Somente items não atendidos")};
        return d;
    }
    
    public void selectAllRotas(){
        this.listRotaItems = RotaConverter.rotaDB;
    }

    
    
}
