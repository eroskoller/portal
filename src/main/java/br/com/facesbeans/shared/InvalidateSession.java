/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.shared;

import br.com.facesbeans.utils.JSFHelper;
import br.com.facesbeans.utils.SessionCounter;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eros
 */
@ViewScoped
@ManagedBean(name="invalidateSession")
public class InvalidateSession {

    private String ok;
    private String mobileok;
    
    public InvalidateSession() {
        
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

    public String getOk() {
        HttpSession session = (HttpSession)  JSFHelper.getExternalContext().getSession(false);
        try {
                        JSFHelper.getExternalContext().redirect("/portal");
                        invalidateSession(session);
                        System.out.println("SessionCounter.getCount():"+SessionCounter.getCount());
                        SessionCounter.getCount();
                    } catch (IOException ex) {
//                        Logger.getLogger(LetMeIn.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
//                        session.invalidate();
                    }
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public String getMobileok() {
        HttpSession session = (HttpSession)  JSFHelper.getExternalContext().getSession(false);
        try {
                        JSFHelper.getExternalContext().redirect("/portal/mobile.lis");
                        invalidateSession(session);
//                        FacesContext.getCurrentInstance().getExternalContext().redirect("/icerel");
                    } catch (IOException ex) {
//                        Logger.getLogger(LetMeIn.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
//                        session.invalidate();
                    }
        return mobileok;
    }

    public void setMobileok(String mobileok) {
        this.mobileok = mobileok;
    }
    
    
    
}
