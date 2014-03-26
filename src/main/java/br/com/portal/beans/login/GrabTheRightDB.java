/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;

import br.com.facesbeans.utils.JSFHelper;
import java.io.Serializable;
import java.util.StringTokenizer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author eros
 */
@ViewScoped
@ManagedBean(name = "grabTheRightDBBen")
public class GrabTheRightDB implements Serializable{

    private String strDbName = "DEFAULT";

    public GrabTheRightDB() {

        Object request = JSFHelper.getExternalContext().getRequest();
        String strToken = ".";
        HttpServletRequest hr = ((HttpServletRequest) request);
        String url = ((HttpServletRequest) request).getRequestURL().toString();
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<URL Completa: "+url+">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        url = url.substring(7, url.length());
        if(url.subSequence(0, 9).toString().equalsIgnoreCase("localhost") ){
//            System.out.println("<<<<<<<<<<<<<<<<"+url.subSequence(0, 10).toString()+">>>>>>>>>>>>>>>>");
            strToken = ":";
            strDbName = "DEFAULT";
        }
        System.out.println("<<<<<<<<<"+this.strDbName+">>>>>>>>>>");
        StringTokenizer stPoint = new StringTokenizer(url, strToken);
        while (stPoint.hasMoreElements()) {
            this.strDbName = stPoint.nextElement().toString().toUpperCase();
            if( !strDbName.equalsIgnoreCase("www") ){
                break;
            }
            
        }
        strDbName = strDbName.toUpperCase();
        
        if(strDbName.equalsIgnoreCase("LOCALHOST")  ||  strDbName.equalsIgnoreCase("ICEREL")||  strDbName.equalsIgnoreCase("lisintranet")||  strDbName.equalsIgnoreCase("186")||  strDbName.equalsIgnoreCase("186.202.50.162")
                 ||  strDbName.equalsIgnoreCase("10") ){//||  strDbName.equalsIgnoreCase("lisnet")
//            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<< Porra da URL: "+strDbName+">>>>>>>>>>>>>>>>>>>>>>>>>>>");
            strDbName = "DEFAULT";
        }
        
        
        PortalView portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        if(portal != null){
            portal.setStrDbName(strDbName);
        }
        
        
    }

    public String getInitializeRightDb() {
        return "yep";
    }
}
