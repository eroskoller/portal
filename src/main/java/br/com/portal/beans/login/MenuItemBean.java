/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eros
 */
public class MenuItemBean implements Serializable{
    
    private String strMenuName;
    private List<MenuItemBean> listMenuItemBeans = new ArrayList<MenuItemBean>();
    private String id;
    
    
    private String label;
    private String icon;
    
    
    public MenuItemBean() {
    }

    
//    public MenuItemBean(String strMenuName) {
//        this.strMenuName = strMenuName;
//    }
    public MenuItemBean(String id, String strMenuName) {
        this.strMenuName = strMenuName;
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public List<MenuItemBean> getListMenuItemBeans() {
        return listMenuItemBeans;
    }
    
    public void setListMenuItemBeans(List<MenuItemBean> listMenuItemBeans) {
        this.listMenuItemBeans = listMenuItemBeans;
    }
    
    public String getStrMenuName() {
        return strMenuName;
    }
    
    public void setStrMenuName(String strMenuName) {
        this.strMenuName = strMenuName;
    }

   
    
}
