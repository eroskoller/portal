/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.jobpush;

import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabRelatorios;
import br.com.hibernate.entities.LabUsuario;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
/**
 *
 * @author eros
 */

@SessionScoped
@ManagedBean(name="relatorioStorageBean")
public class RelatorioStorage implements Serializable{
    
    
    
    
    
    
    private long counterRelStorage = 10;
    private List<LabRelatorios>  listLabRelatoriose = new ArrayList<LabRelatorios>();
    
    private LabRelatorios selectedLabRelatorio;
    
    PortalView portal;

    public RelatorioStorage() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
    }

    public LabRelatorios getSelectedLabRelatorio() {
        return selectedLabRelatorio;
    }

    public void setSelectedLabRelatorio(LabRelatorios selectedLabRelatorio) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  setSelectedLabRelatorio    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        this.selectedLabRelatorio = selectedLabRelatorio;
    }
    
    
    
    

    
    public void addAndSorReports(LabRelatorios lr){
        listLabRelatoriose.add(lr);
        sortRelByID();
    }
    
    public long getCounterRelStorage() {
        return counterRelStorage;
    }

    public void setCounterRelStorage(long counterRelStorage) {
        this.counterRelStorage = counterRelStorage;
    }
    

    public List<LabRelatorios> getListLabRelatoriose() {
        return listLabRelatoriose;
    }
    
    
    public void incrementUpdateAndFindNewReports() {  
        
        if(loopAndNotify()){
            System.out.println("incrementUpdateAndFindNewReports");
            counterRelStorage = 1;
            refreshTableRel();
        }else{
            System.out.println("counterRelStorage: "+counterRelStorage);
            if(counterRelStorage < 120){
                counterRelStorage++;  
            }
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("widgetvarpollcounterRelStorage.stop()");
        }
//                    this.findReadedLabRelatorios();  
    }  
    

    public void setListLabRelatoriose(List<LabRelatorios> listLabRelatoriose) {
        this.listLabRelatoriose = listLabRelatoriose;
    }

    
    
    public void refreshTableRel() {
        
        if (this.listLabRelatoriose != null && !this.listLabRelatoriose.isEmpty()) {

            for (int i = 0; i < this.listLabRelatoriose.size(); i++) {
                LabRelatorios rd = this.listLabRelatoriose.get(i);

                if (rd.getRelChStatus().toString().equalsIgnoreCase("L")) {
                   System.out.println("FOUND A MATCH........................");

                    
                    LabRelatorios lr = (LabRelatorios) OracleHelper.getObject(LabRelatorios.class, rd.getRelInCodigo(), portal.getStrDbName());
                    this.listLabRelatoriose.remove(i);
                    this.listLabRelatoriose.add(i, lr);
                    portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
                    if(!lr.getRelChStatus().toString().equalsIgnoreCase("L")){  
                        portal.popMsg(0, false, "Execucao ");
                    }
                    
                }
            }
        }

    }
    
    
    public boolean loopAndNotify() {
        RequestContext context = RequestContext.getCurrentInstance();
        if (this.listLabRelatoriose != null && !this.listLabRelatoriose.isEmpty()) {
            for (int i = 0; i < this.listLabRelatoriose.size(); i++) {
                LabRelatorios rd = this.listLabRelatoriose.get(i);
                if (rd.getRelChStatus().toString().equalsIgnoreCase("L")  ) {
                    return true;
                }
            }
        }else{
            context.execute("widgetvarpollcounterRelStorage.stop()");
        }
        context.execute("widgetvarpollcounterRelStorage.stop()");
        return  false;
    }
    
    
//   else if (rd.getRelChNew().toString().equalsIgnoreCase("S")) {
//                   System.out.println("FOUND A MATCH........................UnRead Report");
//
//                    this.listLabRelatoriose.remove(i);
//                    LabRelatorios lr = (LabRelatorios) OracleHelper.getObject(LabRelatorios.class, rd.getRelInCodigo(), portal.getStrDbName());
//                    this.listLabRelatoriose.add(i, lr);
//                    
//                }
    
    
    public  boolean updateRelatorioDados(LabRelatorios lr){
        return  loopAndPlaceNewRelatorioDados(lr, listLabRelatoriose);
    }
    
    public  boolean sendRelatorioToUser(LabRelatorios lr,String strDbName){
        if(lr != null && strDbName != null){

               LabRelatorios rNew = new LabRelatorios(lr, strDbName.toUpperCase());
               
               OracleHelper.saveObject(rNew,strDbName.toUpperCase());
               updateRelatorioDados(rNew);
               return true;
//            }
        }
        return  false;
    }
    
    private  boolean loopAndPlaceNewRelatorioDados(LabRelatorios rNew , List<LabRelatorios>  l){

        if(l.isEmpty()){
            l.add(rNew);
        }else{
            for (int i = 0; i < l.size(); i++) {
                LabRelatorios rOld = l.get(i);
                
                if(rOld.getRelInCodigo().equals(rNew.getRelInCodigo())){
                    l.remove(i);
                    l.add(i, rNew);

                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    
    public boolean blockByPdfUnfinish() {

        int i = 0;

        for (LabRelatorios r : this.listLabRelatoriose) {
            if (r.getRelChStatus().toString().equalsIgnoreCase("L")) {
                i++;
            }
        }


        if (i < ArrayItems.intMaximumRelatorios) {
            return true;
        }
        return false;

    }
    
public int getAmountOfReports(){
    if(listLabRelatoriose == null){
        return 0;
    }else{
       return listLabRelatoriose.size();
    }
}
    
    
public  void sortRelByID(){
        
        
        if(listLabRelatoriose != null  && 
               ! listLabRelatoriose.isEmpty()
                && listLabRelatoriose.size()>1){
            
                 Collections.sort(listLabRelatoriose, LabRelatorios.ID_COMPARATOR9To1);

        }
    }

public void changeToRead(){
            FacesContext context = FacesContext.getCurrentInstance();
            Map map = context.getExternalContext().getRequestParameterMap();
            String paramValue = (String) map.get("reportcodigodownloadparam");
            for (int i = 0; i < this.listLabRelatoriose.size(); i++) {
                LabRelatorios lr = listLabRelatoriose.get(i);
                if(lr.getRelInCodigo().toString().equalsIgnoreCase(paramValue)){
                    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+paramValue+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    listLabRelatoriose.get(i).setRelChNew('N');
                    break;
                }
            }
            
    }


    public void changeToRead(String relInCodigo){
            FacesContext context = FacesContext.getCurrentInstance();
            Map map = context.getExternalContext().getRequestParameterMap();
            String paramValue = (String) map.get("reportcodigodownloadparam");
            System.out.println("reportcodigodownloadparam: "+paramValue);
    }
    
}
