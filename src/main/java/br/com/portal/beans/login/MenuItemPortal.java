/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;

import java.util.Map;
import javax.el.ValueExpression;
import org.primefaces.component.menuitem.MenuItem;

/**
 *
 * @author eros
 */
public class MenuItemPortal extends MenuItem{
    
    protected enum PropertyKeys {

        url, target, style, styleClass, onclick, update, process, onstart, disabled, oncomplete, onerror, onsuccess, global, async, ajax, icon,modStCodigo;
        String toString;

        private PropertyKeys(String toString) {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        private PropertyKeys() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }

        public String toString() {
            //compiled code
            throw new RuntimeException("Compiled Code");
        }
    }
    
    
    private String modStCodigo;

    public MenuItemPortal() {
        super();
    }

    public String getModStCodigo() {
        return modStCodigo;
    }

    public void setModStCodigo(String modStCodigo) {
        this.modStCodigo = modStCodigo;
    }
    
    

    
    
    
    
}
