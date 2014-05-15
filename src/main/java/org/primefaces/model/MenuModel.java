/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.primefaces.model;

/**
 *
 * @author eros
 */
import java.util.List;
import javax.faces.component.UIComponent;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.separator.Separator;
import org.primefaces.component.submenu.Submenu;

public interface MenuModel {

    public List<UIComponent> getContents();

    public void addSubmenu(Submenu sbmn);

    public void addMenuItem(MenuItem mi);

    public void addSeparator(Separator sprtr);
}
