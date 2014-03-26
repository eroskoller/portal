/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.shared;

import br.com.facesbeans.jobpush.RelatorioStorage;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabRelatorios;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name="fileStreamerBean")
public class FileStreamer implements Serializable{

    private PortalView portal;
    private RelatorioStorage relStorage; 
    
    public FileStreamer() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        relStorage = (RelatorioStorage) JSFHelper.getSessionAttribute("relatorioStorageBean");
    }
    
    
    
    private StreamedContent file;  
      
    
  
    public StreamedContent getFile() {  
        
            file = null;
            FacesContext context = FacesContext.getCurrentInstance();
            Map map = context.getExternalContext().getRequestParameterMap();
            String paramValue = (String) map.get("reportcodigodownloadparam");
            System.out.println("paramValue: "+paramValue);
            if(paramValue != null && portal != null ){
                LabRelatorios lr = (LabRelatorios) OracleHelper.getObject(LabRelatorios.class, new Long(paramValue.replaceAll("\\D", "")),portal.getStrDbName().toUpperCase());
                if(lr != null){
                    System.out.println("ArrayItems.strURLPdfPath+lr.getRelStPdfNome(): "+ArrayItems.strURLPdfPath+lr.getRelStPdfNome());
//                    InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(ArrayItems.strURLPdfPath+lr.getRelStPdfNome());  
                     File pdfFile = new File(ArrayItems.strURLPdfPath+lr.getRelStPdfNome());
                     try{
                         InputStream stream = new FileInputStream(pdfFile);
                        file = new DefaultStreamedContent(stream, "application/pdf", lr.getRelStPdfNome());  
                        relStorage.changeToRead(lr.getRelInCodigo().toString());
                        return file;
                     }catch(Exception xcp){
                         
                     }
                    
                }else{
                    System.out.println("lr == null");
                }
                
            }else{
                if(portal == null){
                    System.out.println("Portal == null");
                }else{
                    System.out.println("paramValue == null");
                }
                
            }
        
        
        return file;  
    }    
    
}
