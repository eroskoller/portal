/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author eros
 */

@ApplicationScoped
@ManagedBean(name="portalCounterBean")
public class PortalCounter {
    
    private long longCounter ;

    public long getLongCounter() {
        return longCounter;
    }

    public void setLongCounter(long longCounter) {
        this.longCounter = longCounter;
    }
    
    public void incrementCounter(){
        longCounter ++;
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<< longCounter: "+longCounter+">>>>>>>>>>>>>>>>>>>>>>");
//        RequestContextSeilah.getCurrentInstance().push("counter", longCounter);
    }
    
}
