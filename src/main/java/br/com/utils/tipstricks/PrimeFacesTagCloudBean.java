/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.tipstricks;

import br.com.facesbeans.utils.JSFHelper;
import br.com.portal.beans.login.PortalView;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudModel;

/**
 *
 * @author ricardo
 */
@ManagedBean(name="tagCloudBean")
@ViewScoped
public class PrimeFacesTagCloudBean implements Serializable{
    
    private TagCloudModel model;  
    private PortalView portal;
    
  
    public PrimeFacesTagCloudBean() {  
        model = new DefaultTagCloudModel();  
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        
        for (int i = 0; i < 16; i++) {
            
        model.addTag(new DefaultTagCloudItem(portal.getStrDbName().toUpperCase(), "#", 5));
        
        model.addTag(new DefaultTagCloudItem("Laboratórios", "#", 2));
        model.addTag(new DefaultTagCloudItem("Hospitalar", "#", 4));
        model.addTag(new DefaultTagCloudItem("OnLine", "#", 1));
        model.addTag(new DefaultTagCloudItem("Interfaceamento", "#", 3));
        
        model.addTag(new DefaultTagCloudItem(portal.getStrDbName().toUpperCase(), "#", 1));
        
        model.addTag(new DefaultTagCloudItem("Interface", "#", 3));
        model.addTag(new DefaultTagCloudItem("LabLis", "#", 1));
        model.addTag(new DefaultTagCloudItem("Portal", "#", 5));
        model.addTag(new DefaultTagCloudItem("Clínicas", "#", 5));
        
        model.addTag(new DefaultTagCloudItem(portal.getStrDbName().toUpperCase(), "#", 3));
        
        
        if(portal.getLabUsuario() != null){
            model.addTag(new DefaultTagCloudItem(portal.getLabUsuario().getUsuStCodigo(), "#", 5));
        }
        
        
        model.addTag(new DefaultTagCloudItem("TMInterface", "#", 3));
        
        
        }
        
        
    }  
  
    public TagCloudModel getModel() {  
        return model;  
    }  
}
