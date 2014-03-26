/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;  

import br.com.facesbeans.jobpush.RelatorioStorage;
import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabRelatorios;
import br.com.hibernate.entities.LabUnidade;
import br.com.hibernate.entities.LabUsuario;
import br.com.hibernate.utils.OracleHelper;
import br.com.utils.tipstricks.DescricaoResumida;
import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jcifs.util.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.component.layout.LayoutUnit;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.RateEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name = "portalViewBean")
public class PortalView implements Serializable {

//    private Menubar menuBarMain = new Menubar();
//    private MenuModel menuModelMain = new DefaultMenuModel();
    private String strDbName = "DEFAULT";
    private Date dtBase;
    private TabView tabMain = new TabView();
    private int intActiveIndex = 0;
    
//    private List<IFramePage> listIFramePages = new ArrayList<IFramePage>();
    private MenuBarDyno menuBarMain = new MenuBarDyno();
    private List<MenuItemBean> listMenuItemBean ;
    private List<MenuItemBean> listMenuItemBeanMobile ;
    
    private Map<String, IFramePage> mapTabIndex = new LinkedHashMap<String, IFramePage>();
    
//    private TabViewPortal tabViewPortal = new TabViewPortal();
    private boolean blFooterCollpsed = false;
    private LayoutUnit layOutUnitFooter;
    private boolean blEastCollpsed = true;
    private String strLogin;
    private String strPass;
    private String strContrato;
    private String strMsgs;
    private String strContentPath;
    
    
    private boolean blTabRelatorioExameLote = false;
    private boolean blTabRelatorioExameRequisicao = false;
    private boolean blTabRelatorioFaturamento = false;
    private boolean blTabMonitorFaturamento = false;
    private boolean blTabConsultaLaudos = false;
    private boolean blTabRelatorioPendencia = false;
    private Map<String, List<String>> mapMenuAndSubMenu = new LinkedHashMap<String, List<String>>();
    Map<String, String> mapModulos = null;
    private LabUsuario labUsuario;
    private LabUnidade labUnidade;
    private Map<String,LabUnidade> mapLinkedLabUnidade  = new LinkedHashMap<String, LabUnidade>(10);
    private String strUniStCodigo ;
    private SelectItem[] unidadeItens;

    public PortalView() {
        
        
        IFramePage ifr = new IFramePage("Portal","Portal", "../../main.xhtml", 0, "newstab", null, null, false, true, "news");
//        listIFramePages.add(ifr);
        mapTabIndex.put("Noticias", ifr);
//        dtBase = OracleHelper.getDateFromDB(strDbName);  //TODO fixing fucking DB Date
        dtBase  = new Date();
        
        strContentPath = JSFHelper.getExternalContext().getRequestContextPath(); 
        
    }

    public String getStrUniStCodigo() {
        return strUniStCodigo;
    }

    public void setStrUniStCodigo(String strUniStCodigo) {
        this.strUniStCodigo = strUniStCodigo;
    }
    
    
    
    public SelectItem[] getUnidadeItens() {

        if(unidadeItens == null){
            unidadeItens = new SelectItem[1];
            unidadeItens[0] = new SelectItem("99999", "------------");
        }

        return unidadeItens;
    }

    public void setUnidadeItens(SelectItem[] unidadeItens) {
        this.unidadeItens = unidadeItens;
    }
    

    public Date getDtBase() {
        return dtBase;
    }

    public void setDtBase(Date dtBase) {
        this.dtBase = dtBase;
    }



    public String getStrDbName() {
        return strDbName;
    }

    public void setStrDbName(String strDbName) {
        this.strDbName = strDbName.toUpperCase();
    }

    public String getStrContentPath() {
        return strContentPath;
    }

    public void setStrContentPath(String strContentPath) {
        this.strContentPath = strContentPath;
    }

    public LayoutUnit getLayOutUnitFooter() {
        return layOutUnitFooter;
    }

    public void setLayOutUnitFooter(LayoutUnit layOutUnitFooter) {
        this.layOutUnitFooter = layOutUnitFooter;
    }

    public boolean isBlEastCollpsed() {
        return blEastCollpsed;
    }

    public void setBlEastCollpsed(boolean blEastCollpsed) {
        this.blEastCollpsed = blEastCollpsed;
    }

    public boolean isBlFooterCollpsed() {
        return blFooterCollpsed;
    }

    public void setBlFooterCollpsed(boolean blFooterCollpsed) {
        this.blFooterCollpsed = blFooterCollpsed;
    }

    public MenuBarDyno getMenuBarMain() {
        return menuBarMain;
    }

    public void setMenuBarMain(MenuBarDyno menuBarMain) {
        this.menuBarMain = menuBarMain;
    }

    public int getIntActiveIndex() {
        return intActiveIndex;
    }

    public void setIntActiveIndex(int intActiveIndex) {
        this.intActiveIndex = intActiveIndex;
    }

    public List<MenuItemBean> getListMenuItemBean() {
        return listMenuItemBean;
    }

    public void setListMenuItemBean(List<MenuItemBean> listMenuItemBean) {
        this.listMenuItemBean = listMenuItemBean;
    }
    
    

//    public Menubar getMenuBarMain() {
//        return menuBarMain;
//    }
//
//    public void setMenuBarMain(Menubar menuBarMain) {
//        this.menuBarMain = menuBarMain;
//    }
    public List<IFramePage> getListIFramePages() {
        ArrayList<IFramePage> listIFrames = new ArrayList<IFramePage>();
        if(mapTabIndex != null && !mapTabIndex.isEmpty()){
            Iterator iter = mapTabIndex.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                listIFrames.add((IFramePage)pair.getValue());
            }
            
        }
        return listIFrames;
    }



    public boolean isBlTabConsultaLaudos() {
        return blTabConsultaLaudos;
    }

    public void setBlTabConsultaLaudos(boolean blTabConsultaLaudos) {
        this.blTabConsultaLaudos = blTabConsultaLaudos;
    }

    public boolean isBlTabMonitorFaturamento() {
        return blTabMonitorFaturamento;
    }

    public void setBlTabMonitorFaturamento(boolean blTabMonitorFaturamento) {
        this.blTabMonitorFaturamento = blTabMonitorFaturamento;
    }

    public boolean isBlTabRelatorioExameLote() {
        return blTabRelatorioExameLote;
    }

    public void setBlTabRelatorioExameLote(boolean blTabRelatorioExameLote) {
        this.blTabRelatorioExameLote = blTabRelatorioExameLote;
    }

    public boolean isBlTabRelatorioExameRequisicao() {
        return blTabRelatorioExameRequisicao;
    }

    public void setBlTabRelatorioExameRequisicao(boolean blTabRelatorioExameRequisicao) {
        this.blTabRelatorioExameRequisicao = blTabRelatorioExameRequisicao;
    }

    public boolean isBlTabRelatorioFaturamento() {
        return blTabRelatorioFaturamento;
    }

    public void setBlTabRelatorioFaturamento(boolean blTabRelatorioFaturamento) {
        this.blTabRelatorioFaturamento = blTabRelatorioFaturamento;
    }

    public boolean isBlTabRelatorioPendencia() {
        return blTabRelatorioPendencia;
    }

    public void setBlTabRelatorioPendencia(boolean blTabRelatorioPendencia) {
        this.blTabRelatorioPendencia = blTabRelatorioPendencia;
    }

    public TabView getTabMain() {
        return tabMain;
    }

    public void setTabMain(TabView tabMain) {
        this.tabMain = tabMain;
    }

    public LabUsuario getLabUsuario() {
        return labUsuario;
    }

    public void setLabUsuario(LabUsuario labUsuario) {
        this.labUsuario = labUsuario;
    }

    public Map<String, List<String>> getMapMenuAndSubMenu() {
        return mapMenuAndSubMenu;
    }

    public void setMapMenuAndSubMenu(Map<String, List<String>> mapMenuAndSubMenu) {
        this.mapMenuAndSubMenu = mapMenuAndSubMenu;
    }

    public String getStrContrato() {
        return strContrato;
    }

    public void setStrContrato(String strContrato) {
        this.strContrato = strContrato;
    }

    public String getStrLogin() {
        return strLogin;
    }

    public void setStrLogin(String strLogin) {
        this.strLogin = strLogin.toUpperCase();
    }

    public String getStrMsgs() {
        return strMsgs;
    }

    public void setStrMsgs(String strMsgs) {
        this.strMsgs = strMsgs;
    }

    public String getStrPass() {
        return strPass;
    }

    public void setStrPass(String strPass) {
        this.strPass = strPass;
    }

    public LabUnidade getLabUnidade() {
        return labUnidade;
    }

    public void setLabUnidade(LabUnidade labUnidade) {
        this.labUnidade = labUnidade;
    }

    public Map<String, LabUnidade> getMapLinkedLabUnidade() {
        return mapLinkedLabUnidade;
    }

    public void setMapLinkedLabUnidade(Map<String, LabUnidade> mapLinkedLabUnidade) {
        this.mapLinkedLabUnidade = mapLinkedLabUnidade;
    }

    public Map<String, IFramePage> getMapTabIndex() {
        return mapTabIndex;
    }

    public void setMapTabIndex(Map<String, IFramePage> mapTabIndex) {
        this.mapTabIndex = mapTabIndex;
    }

    public List<MenuItemBean> getListMenuItemBeanMobile() {
        return listMenuItemBeanMobile;
    }

    public void setListMenuItemBeanMobile(List<MenuItemBean> listMenuItemBeanMobile) {
        this.listMenuItemBeanMobile = listMenuItemBeanMobile;
    }
    
    
    
    
    
    
    

    public void letMeIn(ActionEvent event) {
        this.letMeIn();
    }
    
    
    public String letMeInMobile() {
        this.letMeIn();
        if(this.labUsuario != null){

            buildUnidadeItens();
            return "pm:unidadeselector";
            
        }else{
            return "pm:mobilelogin";    
        }
    }
    
    public void goToMobileMenuLinks(ActionEvent event){
        if(labUsuario != null && labUnidade != null){
            if(strUniStCodigo != null){labUnidade = this.mapLinkedLabUnidade.get(strUniStCodigo); }
            try {
                JSFHelper.getExternalContext().redirect("mobilemenulinks.lis");
            } catch (IOException ex) {
                Logger.getLogger(PortalView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            
            System.out.println("labUsuario ou labUnidade = null");
            try {
                JSFHelper.getExternalContext().redirect("mobile.lis");
            } catch (IOException ex) {
                Logger.getLogger(PortalView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
    }
    
    
    
    public void letMeIn() {

        
        
        
//        listIFramePages.clear();
        mapTabIndex.clear();
        IFramePage ifr = new IFramePage("Notícias","Notícias", "../../news.xhtml", 0, "newstab", null, null, false, true, "news");
//        listIFramePages.add(ifr);
        mapTabIndex.put("Noticias", ifr);


        if (strLogin != null && strPass != null && strLogin.length() > 1 && strPass.length() > 1) {

            labUsuario = PortalDao.grabUser(strLogin, strPass, strDbName);

            if (labUsuario != null) {
                this.buildMenuBarByUser(labUsuario);
                this.initilizeRelatorioList();
                this.grabLabUnidadeByUser();
//                try {
//                    JSFHelper.getExternalContext().redirect("index.jsp");
//                    
//    //                              System.out.println("Map LabUnidade.size: "+mapLinkedLabUnidade.size());
//                } catch (IOException ex) {
//                    Logger.getLogger(PortalView.class.getName()).log(Level.SEVERE, null, ex);
//                }
            } else {
                strMsgs = "Login ou Senha incorretos.....................................................!!!!!!!!!!!!!!!!!";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Problemas", strMsgs));

            }

        } else {
            strMsgs = "Login ou Senha invalidos ou em branco........!!!!!!!!!!!!!!!!!!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Problemas", strMsgs));
        }



    }

    public void letMeOut(ActionEvent event) { 
        cleanUpEveryThing();

//        HttpSession session = (HttpSession) JSFHelper.getExternalContext().getSession(false);//   context.getExternalContext().getSession(false);
        try {
            JSFHelper.getExternalContext().redirect("/portal/invalidate.lis");
//            invalidateSession(session);
//            FacesContext.getCurrentInstance().getExternalContext().redirect("/icerel");
        } catch (Exception ex) {
//                        Logger.getLogger(LetMeIn.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//                        session.invalidate();
        }
//                 FacesContext context = FacesContext.getCurrentInstance();

    }

    public void invalidateSession(HttpSession session) {
        String[] extraAttrs = {
            "loggedUserInfo",};
        java.util.Enumeration attrs = session.getAttributeNames();
        while (attrs.hasMoreElements()) {
            String attr = (String) attrs.nextElement();
//            System.out.println(attr);
            session.removeAttribute(attr);
//            if (attr.endsWith("Bean")) {
//                session.removeAttribute(attr);
//            }
        }
        for (int i = 0; i < extraAttrs.length; i++) {
            session.removeAttribute(extraAttrs[i]);
        }

    }

    private void cleanUpEveryThing() {

//        menuBarMain = new Menubar();
        this.labUsuario = null;
        this.mapMenuAndSubMenu = null;
        this.mapModulos = null;
        this.strContrato = null;
        this.strLogin = null;
        this.strMsgs = null;
        this.strPass = null;
        this.mapTabIndex = null;

        blTabRelatorioExameLote = false;
        blTabRelatorioExameRequisicao = false;
        blTabRelatorioFaturamento = false;
        blTabMonitorFaturamento = false;
        blTabConsultaLaudos = false;
        blTabRelatorioPendencia = false;
        intActiveIndex = 0;

    }

    public void buildMenuBarByUser(LabUsuario labUser) {

        if (labUser != null) {

            String sqlQuery =
                    " select  "
                    + "\n pus.pusInSequencia,"
                    + "\n pus.pusInSequenciaPai,"
                    + "\n pus.modStCodigo.modStCodigo,"
                    + "\n mdl.modStDescricao"
                    //                    + "\n mdl.modStBrowser"
                    + "\n from LabPerfilUsuarioModulo pus,"
                    + "\n LabModulo              mdl,"
                    + "\n LabUsuario             usu,"
                    + "\n LabUsuarioModulo       umo"
                    + "\n where pus.modStCodigo= mdl.modStCodigo"
                    + "\n and umo.usuStCodigo = usu.usuStCodigo"
                    + "\n and umo.modStCodigo = mdl.modStCodigo"
                    + "\n and pus.pusStCodigo = :pusStCodigo"
                    + "\n and usu.usuStCodigo = :usuStCodigo"   
//                    + "\n and pus.pusInVersao = (select max(pusInVersao) from LabPerfilUsuarioModulo where pusStCodigo = pus.pusStCodigo)"  
                    + "\n    order by pus.pusInSequencia,pus.pusInSequenciaPai"
                    + "";


            Session session = OracleHelper.getSessionDude(strDbName);
            Transaction tx = session.beginTransaction();

            try {
                Query query = session.createQuery(sqlQuery);
                query.setString("usuStCodigo", labUser.getUsuStCodigo());
                query.setString("pusStCodigo", labUser.getPusStCodigo().getPusStCodigo());

                List list = query.list();
                tx.commit();

                if (list != null && !list.isEmpty()) {
                    MenuBuilderHelper mb = new MenuBuilderHelper();
                    this.listMenuItemBean = mb.buildMenuItemBean(list);
                    this.listMenuItemBeanMobile = mb.cleanUpListMenuItemBeans(listMenuItemBean);
//                    menuBarMain.builSubAndMenus(list);
                    menuBarMain.buildMenuBaseOnListMenuItemBean(listMenuItemBean);
                }

            } catch (Exception xcp) {
                xcp.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }

        }
    }

    public void getOnTabChange(TabChangeEvent event) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Inside getOnTabChange >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public void tabClose(TabCloseEvent event) {
        onTabClose(event);
    }
    
    
    public void onTabClose(TabCloseEvent event) {

        TabView tw = (TabView) event.getTab().getParent();
        int index = tw.getChildren().indexOf(event.getTab());
        
     
        Iterator  iter = this.mapTabIndex.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
            String key  = pair.getKey();
            IFramePage iframe = (IFramePage) pair.getValue();
            if(iframe.getTabIndex() == index){
                mapTabIndex.remove(key);
                break;
            }
        }
        
        
        Iterator  iter2 = this.mapTabIndex.entrySet().iterator();
        while(iter2.hasNext()){
            Map.Entry<String, Object> pair2 = (Map.Entry<String, Object>) iter2.next();
            String key  = pair2.getKey();
            IFramePage iframe = (IFramePage) pair2.getValue();
            
            if(iframe.getTabIndex() > index){
               iframe.setTabIndex(iframe.getTabIndex() -1);
            }
        }
        
        this.intActiveIndex = index - 1;
        this.tightenTabTitles();
    }

    public void findRighTab(MenuItem m) {


        String strTabName = m.getValue().toString();

        if (strTabName.equalsIgnoreCase("Fechar Abas")) {
            closeAllTabs();
        }else {
            if (mapTabIndex.containsKey(m.getStyle())) {
                intActiveIndex = mapTabIndex.get(m.getStyle()).getTabIndex() ;
//                intActiveIndex = 0;
            } else {
                IFramePage iframe = ArrayItems.iframeHolder.getMapIFramePages().get(m.getStyle());
                iframe.setId("tab"+m.getId());
                iframe.setTabId("tab"+m.getStyle());
                iframe.setTitle((String)m.getValue());
                iframe.setTitleResumido((String)m.getValue());
                iframe.setTabIndex(mapTabIndex.size());
                mapTabIndex.put(m.getStyle(), iframe);
                
                if(!iframe.isBlNative()){
//                    String encode = "LISNETSISTEMAS|"+this.strDbName+"|"+labUsuario.getUsuStCodigo();
//                    encode = Base64.encodeString(encode);
//                    encode = Base64.encodeString(encode);
//                    iframe.setUrl(iframe.getUrl()+encode);
                    //http://paranalise
                    
//                    iframe.setUrl("http://paranalise"+iframe.getUrl());    
                    
//                    String msg = "http://{0}.lisnet.com.br/lisupdate/auditoria";
                    String[] values =  new String[10];
                    if(this.strDbName.equalsIgnoreCase("DEFAULT")){
                        values[0] = "paranalise";
                    }else{
                      values[0] = strDbName.toLowerCase();
                    }
                    values[1] = labUsuario.getUsuStCodigo();
                    iframe.setUrl(MessageFormat.format(iframe.getUrl(), (Object[]) values));  
//                    System.out.println("--------------------------------- "+iframe.getUrl()+" ----------------------------------------");
                      
                }
                
//                listIFramePages.add(frame);
                intActiveIndex = mapTabIndex.size() - 1;
//                if(intActiveIndex == 0){
//                   intActiveIndex = 0 ;
//                }else{
//                       intActiveIndex -= 1;
//                }
                
            }
        }

        this.tightenTabTitles();
    }

   

//    public String getFooterUrl() {
//        if (labUsuario != null) {
//            return "/icerel/mirror/relatoriolistportal.cie?user=" + labUsuario.getUsuStCodigo() + "&portal=yes&dbname=" + strDbName.toUpperCase();
//        } else {
//            return "index";
//        }
//    }

    public void closeAllTabs() {
//        System.out.println("Closing Tabs............");
//        listIFramePages.clear();
        mapTabIndex.clear();
        IFramePage ifr = new IFramePage("Notícias","Notícias", "../../news.xhtml", 0, "newstab", null, null, false, true, "news");
//        listIFramePages.add(ifr);
        mapTabIndex.put("Noticias", ifr);
        intActiveIndex = 0;
    }
   
    
    public void closeAllTabs(ActionEvent event) {
        closeAllTabs();
    }
    
    
    public void testValueChange(ValueChangeEvent event ){
        System.out.println("Inside testValueChange");
    }
    
    
    
    private void initilizeRelatorioList(){
            
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_YEAR, -ArrayItems.intMaxDaysRelStorage);
//            RelStorageKey relkey = new RelStorageKey(this.usuario.getUsuStCodigo(), strDbName.toUpperCase());
//            String id = this.labUsuario.getUsuStCodigo().toUpperCase()+ strDbName.toUpperCase();
            RelatorioStorage relatorioStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
            relatorioStorage.setListLabRelatoriose((List<LabRelatorios>)OracleHelper
                    .getListOfObjectByDate(LabRelatorios.class, "usuStCodigo", labUsuario.getUsuStCodigo(), "relDtConsulta",cal.getTime() , true,strDbName.toUpperCase()));
            relatorioStorage.sortRelByID();
                
        }
    
    private void grabLabUnidadeByUser(){
        if(labUsuario != null){
            mapLinkedLabUnidade = PortalDao.grabLabUnidadesByUser(labUsuario, strDbName);
            if(mapLinkedLabUnidade != null){
                labUnidade = mapLinkedLabUnidade.get(labUsuario.getUniStCodigo());
                if(labUnidade == null){
                    System.out.println("este Usuario ao tem Unidade Padrao");
                    labUnidade = getListLabUnidade().get(0);
                }else{
                    mapLinkedLabUnidade.get(labUsuario.getUniStCodigo()).setBlSelected(true);
                }
                strMsgs = "Você não tem uma Unidade Padrao, por favor entrar em contato com o suporte.";
            }else{
                System.out.println("mapLabUnidade is null");
            }
                
        }
    }
    
    public void grabLabUnidadeFromListSwitch(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("labunidadeswitchparam");
        this.labUnidade = mapLinkedLabUnidade.get(paramValue);
        
    }
    
    
    public String getUrlRelDownloadDbName(){
            return "&dbname="+strDbName;
   }
    
    
    public String getFormIdCentral(){
        return ":formcenter:tw:";
    }
    
    public ArrayList<LabUnidade> getListLabUnidade(){
        ArrayList<LabUnidade> listUni = new ArrayList<LabUnidade>();
        if(mapLinkedLabUnidade != null && !mapLinkedLabUnidade.isEmpty()){
            
            Iterator iter = mapLinkedLabUnidade.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                listUni.add((LabUnidade)pair.getValue());
            }
           
        }
        
        return  listUni;
    }
    
    
    
    public void  checkAllUnidades(){
        checkAllUnidades(true);
    }
    
     public void  unCheckAllUnidades(){
         checkAllUnidades(false);
    }
     
     private void  checkAllUnidades(boolean status){
        if(mapLinkedLabUnidade != null && !mapLinkedLabUnidade.isEmpty()){
            Iterator iter = mapLinkedLabUnidade.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                ((LabUnidade) pair.getValue()).setBlSelected(status);
            }
        }
        
    }
    
    
    
    public ArrayList<LabUnidade> getListLabUnidadeSelected(){
        ArrayList<LabUnidade> listUni = new ArrayList<LabUnidade>();
        if(mapLinkedLabUnidade != null && !mapLinkedLabUnidade.isEmpty()){
            
            Iterator iter = mapLinkedLabUnidade.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                LabUnidade lu = (LabUnidade) pair.getValue();
                if(lu.isBlSelected()){
                    listUni.add((LabUnidade)pair.getValue());
                }
                
            }
        }
        
        return listUni;
    }
    
    
    public void grabUnidadeFromList() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("portalviewlabunidadesparam");
        
        System.out.println("Grabing paramValue Unidade: "+paramValue );
        
        if(this.mapLinkedLabUnidade.get(paramValue).isBlSelected()){
            System.out.println("Setting Unidade: "+paramValue+" to "+true);
            mapLinkedLabUnidade.get(paramValue).setBlSelected(true);
        }else{
            System.out.println("Setting Unidade: "+paramValue+" to "+false);
            mapLinkedLabUnidade.get(paramValue).setBlSelected(false);
        }
        
    }
    
    
    
    
    
    
      public void popMsg(int severity, boolean blVisible, String msg) {

        FacesContext context = FacesContext.getCurrentInstance();
        if (blVisible) {

            switch (severity) {
                case 0:
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Problemas", msg));
                    break;
                case 1:
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Problemas", msg));
                    break;
                case 2:
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Problemas", msg));
                    break;

                default:
                     context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Problemas", msg));
            }

        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", msg));
        }


    }
    
      
      
      private void tightenTabTitles() {

        if (mapTabIndex != null && !mapTabIndex.isEmpty()) {
            if (mapTabIndex.size() >= 5  && mapTabIndex.size() < 8) {
                tightenTabTitles(28);
            }else if(mapTabIndex.size() >= 8  && mapTabIndex.size() < 13){
                tightenTabTitles(20);
            }else if(mapTabIndex.size() >= 13  && mapTabIndex.size() < 21){
                tightenTabTitles(16);
            }else if(mapTabIndex.size() >= 21  && mapTabIndex.size() < 25){
                tightenTabTitles(12);
            }else if(mapTabIndex.size() >= 25  && mapTabIndex.size() < 29){
                tightenTabTitles(10);
            }else if(mapTabIndex.size() >= 29 ){
                tightenTabTitles(6);
            } else {
                Iterator iter = mapTabIndex.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    IFramePage iframe = (IFramePage) pair.getValue();
                    iframe.setTitleResumido(iframe.getTitle());
                }
            }
        }

    }
      private void tightenTabTitles(int maxChars){
          Iterator iter = mapTabIndex.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    IFramePage iframe = (IFramePage) pair.getValue();
                        iframe.setTitleResumido(DescricaoResumida.descResuminda(iframe.getTitle(), maxChars));
                    
                }
      }
      
      
      public void onrate(RateEvent rateEvent) {
        popMsg(1, false, "Colocando página no menu de preferência....");
          System.out.println("ratin............");
//        rateUnRatePage(true);
    }

    public void oncancel() {
        popMsg(1, false, "Tirando página do menu de preferência....");
        System.out.println("unratin............");
//        rateUnRatePage(false);
    }
    
    public  void setRating(Integer rating){
            System.out.println("setRating: "+returnIframeBaseOnIndex(intActiveIndex).getTitle()+" index: "+returnIframeBaseOnIndex(intActiveIndex).getTabIndex());
        returnIframeBaseOnIndex(intActiveIndex).setRating(rating);
    }
    public  Integer getRating(){
        return returnIframeBaseOnIndex(intActiveIndex).getRating();
    }
    
    
    public IFramePage returnIframeBaseOnIndex(int intIndex){
        
        Iterator iter = this.mapTabIndex.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
            IFramePage iframe = (IFramePage) pair.getValue();
            if(iframe.getTabIndex() == intIndex){
                return iframe;
            }
        }
        return new IFramePage();
    }

    
    private void buildUnidadeItens() {
        if (labUsuario != null && this.mapLinkedLabUnidade != null) {
            unidadeItens = new SelectItem[this.getListLabUnidade().size() + 1];
            int x = 0;
            unidadeItens[0] = new SelectItem(labUnidade.getUniStCodigo(), labUnidade.getUniStCodigo() + ":" + labUnidade.getUniStDescricaoResumida());
            x = 1;

            for (int i = 0; i < this.getListLabUnidade().size(); i++) {

                LabUnidade lu = (LabUnidade) OracleHelper.getObject(LabUnidade.class, this.getListLabUnidade().get(i).getUniStCodigo(), strDbName);
                unidadeItens[i + x] = new SelectItem(lu.getUniStCodigo(), lu.getUniStCodigo() + ":" + lu.getUniStDescricaoResumida());

            }

        }
    }
    
    
    
}



