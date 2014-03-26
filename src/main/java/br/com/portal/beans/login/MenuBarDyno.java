/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;

import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.MenuModel;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.separator.Separator;

/**
 *
 * @author eros
 */
public class MenuBarDyno implements MenuModel, ActionListener, Serializable {
    
    private static final long serialVersionUID = -2866930830066526910L;
//    protected Category category;
    protected List<UIComponent> contents = new ArrayList<UIComponent>();
    protected static UIViewRoot uiViewRoot = new UIViewRoot();

    // Creates and adds the MenuItems to the Menu base on list of tuplas

    
    
    
    
    public void builSubAndMenus(List list) {
        MenuBuilderHelper mb = new MenuBuilderHelper();
        this.buildMenuBaseOnListMenuItemBean(mb.buildMenuItemBean(list));
        
    }
    
    
    
    private String grabRightTitle(String modStCodigo ,String originalTitle){
        if(ArrayItems.iframeHolder.getMapIFramePages().containsKey(modStCodigo)
                &&  ArrayItems.iframeHolder.getMapIFramePages().get(modStCodigo).getTitle()  != null ){
            return ArrayItems.iframeHolder.getMapIFramePages().get(modStCodigo).getTitle();
        }else{
            return originalTitle;
        }
    }
    
    public void buildMenuBaseOnListMenuItemBean(List<MenuItemBean> listMenuItemBeans) {
        resetContents();
        
        Submenu sub1 = null;
        Submenu sub2 = null;

        for (MenuItemBean m1 : listMenuItemBeans) {

            sub1 = new Submenu();
            sub1.setLabel(m1.getStrMenuName());

            sub1.setIcon(ArrayItems.getIcoByName(m1.getId()));
            sub1.setStyle(m1.getStrMenuName());


            

            if (m1.getListMenuItemBeans().size() > 0) {
                for (MenuItemBean m2 : m1.getListMenuItemBeans()) {

                    if (m2.getListMenuItemBeans().size() > 0) {
                        sub2 = new Submenu();
                        sub2.setLabel(m2.getStrMenuName());
                        sub2.setIcon(ArrayItems.getIcoByName(m2.getId()));

                        for (MenuItemBean m3 : m2.getListMenuItemBeans()) {
                            if (ArrayItems.iframeHolder.getMapIFramePages().containsKey(m3.getId())) {
                                MenuItem item = new MenuItem();
                                IFramePage iframe = ArrayItems.iframeHolder.getMapIFramePages().get(m3.getId());
                                item.setValue( grabRightTitle(m3.getId(), m3.getStrMenuName()) );
                                item.addActionListener(this);
                                item.setAjax(iframe.isBlAjax());
                                item.setIcon(iframe.getIconCss());//ArrayItems.getIcoByName(m3.getId()));
                                item.setStyle(m3.getId());

                                item.setUpdate(":tw");
                                item.setAjax(iframe.isBlAjax());
                                item.setProcess("@this");
                                item.setPartialSubmit(iframe.isBlAjax());
                                item.setId("sub" + idGeneratorRandom());
                                sub2.getChildren().add(item);
                            }
                            
                        }
                        if(sub2.getChildren() != null && !sub2.getChildren().isEmpty()){
                            sub1.getChildren().add(sub2);
                        }
                        
                    } else {
//                                        System.out.println("m2 : "+m2.getStrMenuName());
                        if (ArrayItems.iframeHolder.getMapIFramePages().containsKey(m2.getId())  ) {

                            MenuItem item = new MenuItem();
                            IFramePage iframe = ArrayItems.iframeHolder.getMapIFramePages().get(m2.getId());
//                                            item.setIcon("ui-icon ui-icon-document");
//                            item.setValue(m2.getStrMenuName());
                            item.setValue(grabRightTitle(m2.getId(), m2.getStrMenuName()));
                            item.addActionListener(this); 
                            item.setAjax(iframe.isBlAjax());
//                                            item.setId(m2.getId());
                            item.setIcon(iframe.getIconCss());//ArrayItems.getIcoByName(m2.getId()));
//                                            String tbId = "tab"+idGeneratorRandom();
//                                            item.setStyleClass(m2.getStrMenuName());
                            item.setStyle(m2.getId());
//                                             item.setStyleClass(tbId);
//                                             item.setUpdate("panelGroupTabsPortal:"+tbId);
//                            item.setUpdate(":formcenter:tw");
//                            item.setUpdate(":formcenter:panelGroupTabsPortal");
                            item.setUpdate(":tw");
//                            if (m2.getId().equalsIgnoreCase("00062")) {
//                                item.setAjax(false);
//                            } else {
//                                
//                            }

                            item.setId("sub" + idGeneratorRandom());
                            item.setProcess("@this");
                            item.setPartialSubmit(iframe.isBlAjax());
                            sub1.getChildren().add(item);

                        }

                    }
                }
            }
            
            if(sub1 != null && !sub1.getChildren().isEmpty()){
                this.addSubmenu(sub1);
            }
            

        }

//        PortalView p = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
//        if (p != null && p.getLabUsuario() != null && p.getLabUsuario().getPusStCodigo() != null
//                && p.getLabUsuario().getPusStCodigo().getPusStCodigo() != null
//                && p.getLabUsuario().getPusStCodigo().getPusStCodigo().equalsIgnoreCase("9")  ) {
//            Submenu subERP = new Submenu();
//            subERP.setLabel("ERP");
//            subERP.setIcon("ui-icon-calculator");
//            MenuItem item = new MenuItem();
//            IFramePage iframe = ArrayItems.iframeHolder.getMapIFramePages().get("10077");
//            item.setValue(iframe.getTitle());
//            item.addActionListener(this);
//            item.setAjax(iframe.isBlAjax());
//            item.setIcon(iframe.getIconCss());//ArrayItems.getIcoByName(m2.getId()));
//            item.setStyle("10077");
//            item.setUpdate(":tw");
//            item.setId("item" + idGeneratorRandom());
//            item.setProcess("@this");
//            item.setPartialSubmit(iframe.isBlAjax());
//            subERP.getChildren().add(item);
//            this.addSubmenu(subERP);
//        }
                            
        
//                            MenuItem item2 = new MenuItem();
//                            IFramePage iframe2 = ArrayItems.iframeHolder.getMapIFramePages().get("10078");
//                            item2.setValue(iframe2.getTitle());
//                            item2.addActionListener(this); 
//                            item2.setAjax(iframe2.isBlAjax());
//                            item2.setIcon(iframe2.getIconCss());//ArrayItems.getIcoByName(m2.getId()));
//                            item2.setStyle("10078");
//                            item2.setUpdate(":tw");
//                            item2.setId("item" + idGeneratorRandom());
//                            item2.setProcess("@this");
//                            item2.setPartialSubmit(iframe2.isBlAjax());
                            
                            
//                            subERP.getChildren().add(item2);
                             

                             
                             
                             
                             
//        MenuItem itemPg1 = new MenuItem();
//        itemPg1.setValue("Pagina1");
//        itemPg1.addActionListener(this);
//        itemPg1.setAjax(true);
//        itemPg1.setStyle("zorak1");
//        itemPg1.setUpdate(":tw");
//
//        MenuItem itemPg2 = new MenuItem();
//        itemPg2.setValue("Pagina2");
//        itemPg2.addActionListener(this);
//        itemPg2.setAjax(true);
//        itemPg2.setStyle("zorak2");
//        itemPg2.setUpdate(":tw");
//
//        subERP.getChildren().add(itemPg1);
//        subERP.getChildren().add(itemPg2);
//        this.addSubmenu(subERP);



        MenuItem item3 = new MenuItem();
        item3.setValue("Fechar Abas");
        item3.addActionListener(this);
        item3.setAjax(true);
        item3.setIcon(ArrayItems.getIcoByName("Fechar Abas"));
        item3.setId("sub"+idGeneratorRandom());
        item3.setUpdate(":tw");
        this.addMenuItem(item3);
    }
    
    
    
    
    
    public String idGeneratorRandom() {
        String log = "";
        Random randomGenerator = new Random();
        for (int idx = 1; idx <= 10; ++idx) {
            long randomInt = randomGenerator.nextLong();
            log = "" + randomInt;
        }
        return log;
    }

    // Gets called when a MenuItem is clicked. The clicked MenuItem becomes the new top level MenuItem.
    @Override
    public void processAction(ActionEvent event)
            throws AbortProcessingException {
        if (event.getSource().getClass() == MenuItem.class) {
            MenuItem sourceItem = (MenuItem) event.getSource();
            PortalView p = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
            p.findRighTab(sourceItem);
        }
    }
    
    @Override
    public List<UIComponent> getContents() {
        return contents;
    }
    
    @Override
    public void addMenuItem(org.primefaces.component.menuitem.MenuItem mi) {
        contents.add(mi);
    }
    
    @Override
    public void addSubmenu(Submenu sbmn) {
        contents.add(sbmn);
    }
    
    protected void resetContents() {
        contents = new ArrayList<UIComponent>();
    }

    @Override
    public void addSeparator(Separator sprtr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
}
