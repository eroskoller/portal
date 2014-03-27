/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;

import br.com.facesbeans.shared.ArrayItems;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;

/**
 *
 * @author eros
 */
public class MenuBuilderHelper implements Serializable {

    public List<MenuItemBean> buildMenuItemBean(List list) {

        List<MenuItemBean> listMenuItemBeans = new ArrayList<MenuItemBean>();


        for (int i = 0; i < list.size(); i++) {

            Object[] tupla = (Object[]) list.get(i);

            if ((Long) tupla[1] == 0) {
                listMenuItemBeans.add(new MenuItemBean((String) tupla[2], (String) tupla[3]));
            }
            if ((Long) tupla[1] == 1) {
                listMenuItemBeans.get(listMenuItemBeans.size() - 1).getListMenuItemBeans().add(new MenuItemBean((String) tupla[2], (String) tupla[3]));
            }

            if ((Long) tupla[1] == 2) {
                int indexSub = listMenuItemBeans.get(listMenuItemBeans.size() - 1).getListMenuItemBeans().size();
                MenuItemBean mSub = null;
                if(listMenuItemBeans.get(listMenuItemBeans.size() - 1) != null 
                        && listMenuItemBeans.get(listMenuItemBeans.size() - 1).getListMenuItemBeans().get(indexSub - 1) != null){
                    mSub = listMenuItemBeans.get(listMenuItemBeans.size() - 1).getListMenuItemBeans().get(indexSub - 1);
                    mSub.getListMenuItemBeans().add(new MenuItemBean((String) tupla[2], (String) tupla[3]));
                }
                
            }

        }
        return listMenuItemBeans;
    }

    public List<MenuItemBean> cleanUpListMenuItemBeans(List<MenuItemBean> listMenuItemBeans) {

        List<MenuItemBean> returnList = new ArrayList<MenuItemBean>();

        MenuItemBean sub1 = null;
        MenuItemBean sub2 = null;

        for (MenuItemBean m1 : listMenuItemBeans) {

            sub1 = new MenuItemBean();
            sub1.setLabel(m1.getStrMenuName());

            sub1.setIcon(ArrayItems.getIcoByName(m1.getId()));
            sub1.setStrMenuName(m1.getStrMenuName());
            sub1.setLabel(m1.getStrMenuName());
            
            

            if (m1.getListMenuItemBeans().size() > 0) {
                for (MenuItemBean m2 : m1.getListMenuItemBeans()) {

                    if (m2.getListMenuItemBeans().size() > 0) {
                        sub2 = new MenuItemBean();
                        sub2.setLabel(m2.getStrMenuName());
                        sub2.setIcon(ArrayItems.getIcoByName(m2.getId()));
                        sub1.getListMenuItemBeans().add(sub2);

                        for (MenuItemBean m3 : m2.getListMenuItemBeans()) {

                            if (ArrayItems.iframeHolder.getMapIFramePages().containsKey(m3.getId())) {
                                MenuItemBean item = new MenuItemBean();
                                
                                IFramePage iframe = ArrayItems.iframeHolder.getMapIFramePages().get(m3.getId());
                                item.setLabel(grabRightTitle(m3));

                                item.setIcon(iframe.getIconCss());//ArrayItems.getIcoByName(m3.getId()));
                                item.setId(iframe.getModStCodigo());
                                sub2.getListMenuItemBeans().add(item);
                            }

                        }

                    } else {
//                                        System.out.println("m2 : "+m2.getStrMenuName());
                        if (ArrayItems.iframeHolder.getMapIFramePages().containsKey(m2.getId())) {

                            MenuItemBean item = new MenuItemBean();
                            IFramePage iframe = ArrayItems.iframeHolder.getMapIFramePages().get(m2.getId());

                            item.setLabel(grabRightTitle(m2));

                            item.setIcon(iframe.getIconCss());//ArrayItems.getIcoByName(m2.getId()));
                            item.setId(iframe.getModStCodigo());
//                            System.out.println(grabRightTitle(m2));
                            sub1.getListMenuItemBeans().add(item);

                        }

                    }
                }
            }
            
            if(!sub1.getListMenuItemBeans().isEmpty()){
                returnList.add(sub1);
            }
            

        }

        

        return returnList;

    }

    private String grabRightTitle(MenuItemBean menuItemBean) {
        if (ArrayItems.iframeHolder.getMapIFramePages().containsKey(menuItemBean.getId())
                && ArrayItems.iframeHolder.getMapIFramePages().get(menuItemBean.getId()).getTitle() != null) {
            return ArrayItems.iframeHolder.getMapIFramePages().get(menuItemBean.getId()).getTitle();
        } else {
            return menuItemBean.getStrMenuName();
        }
    }
}
