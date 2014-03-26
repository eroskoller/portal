/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;

import br.com.facesbeans.utils.JSFHelper;
import java.io.Serializable;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.tabview.TabView;

/**
 *
 * @author eros
 */
public class TabViewPortal extends TabView implements Serializable{
    
    
    public String getOnTabClose() {
        return  "<<<<<<<<<<<<<<<<<<<<<<<<<<<<  getOnTabClose  >>>>>>>>>>>>>>>>>>>>>>>>>>>>";
    }

    public void setOnTabClose(String _onTabChange) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<  setOnTabClose  >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
    
    public void processAction(ActionEvent event)
            throws AbortProcessingException {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<tabViewPortal processAction>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
    
    
    
}
