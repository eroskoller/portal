/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.exame;

import br.com.facesbeans.laudo.LabRequisicaoBean;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabExameUnidade;
import br.com.hibernate.entities.LabExameUnidadePK;
import br.com.hibernate.entities.LabManualExame;
import br.com.hibernate.entities.LabSetor;
import br.com.hibernate.entities.LabSetorPK;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author eros
 */

@SessionScoped
@ManagedBean(name="pesquisaManualExViewBean")
public class PesquisaManualExView implements Serializable{
    
    private PortalView portal =  null;
    
    
    private String strMnemonicCodigo;
    private String strDescExame;
    private String strSynonymies;
    
    private LabSetor labSetor;
    private LabExameUnidade labExameUnidade;
    private LabManualExame selectedlabManualExame;
    private List<LabManualExame> listLabManualExames;

    public PesquisaManualExView() {
         portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
    }

    public LabSetor getLabSetor() {
        return labSetor;
    }

    public void setLabSetor(LabSetor labSetor) {
        this.labSetor = labSetor;
    }

    public LabExameUnidade getLabExameUnidade() {
        return labExameUnidade;
    }

    public void setLabExameUnidade(LabExameUnidade labExameUnidade) {
        this.labExameUnidade = labExameUnidade;
    }

    
    public LabManualExame getSelectedlabManualExame() {
        return selectedlabManualExame;
    }

    public void setSelectedlabManualExame(LabManualExame selectedlabManualExame) {
        this.selectedlabManualExame = selectedlabManualExame;
    }

    
    
    public List<LabManualExame> getListLabManualExames() {
        return listLabManualExames;
    }

    public void setListLabManualExames(List<LabManualExame> listLabManualExames) {
        this.listLabManualExames = listLabManualExames;
    }

    public String getStrSynonymies() {
        return strSynonymies;
    }

    public void setStrSynonymies(String strSynonymies) {
        this.strSynonymies = strSynonymies;
    }

    public String getStrMnemonicCodigo() {
        return strMnemonicCodigo;
    }

    public void setStrMnemonicCodigo(String strMnemonicCodigo) {
        this.strMnemonicCodigo = strMnemonicCodigo;
    }

    public String getStrDescExame() {
        return strDescExame;
    }

    public void setStrDescExame(String strDescExame) {
        this.strDescExame = strDescExame;
    }
    
    
    
    public void onRowSelect(SelectEvent event) {  
        selectedlabManualExame = (LabManualExame) event.getObject();
        if(selectedlabManualExame != null){
            LabExameUnidadePK pk = new LabExameUnidadePK(portal.getLabUnidade().getUniStCodigo(), selectedlabManualExame.getExaStCodigo().getExaStCodigo());
            labExameUnidade = (LabExameUnidade) OracleHelper.getObject(LabExameUnidade.class, pk, portal.getStrDbName());
            LabSetorPK pk2 = new LabSetorPK(portal.getLabUnidade().getUniStCodigo(), selectedlabManualExame.getSetStCodigo());
            labSetor = (LabSetor) OracleHelper.getObject(LabSetor.class, pk2, portal.getStrDbName());
        }
    }
    
    
    public void grabListLabManualExameByMnemonic(ValueChangeEvent event){
        System.out.println("Inside grabListLabManualExameByMnemonic");
        strMnemonicCodigo = (String)  event.getNewValue();
        grabListLabManualExameByMnemonic();
        
    }
    public void grabListLabManualExameByMnemonic(){
        System.out.println("Inside grabListLabManualExameByMnemonic");
        this.listLabManualExames = null;
        if(portal != null && strMnemonicCodigo != null && strMnemonicCodigo.length() > 1){
            this.listLabManualExames = PesquisaManualDao.grabListLabManualExameByMnemonic(strMnemonicCodigo, portal.getStrDbName());
        }else{
            portal.popMsg(1, true, "Campo está vazio ou é menor que 5 caracteres...");
        }
    }
    public void grabListLabManualExameByExameDesc(ValueChangeEvent event){
        strDescExame = (String)  event.getNewValue();
        grabListLabManualExameByExameDesc();
    }
    
    public void grabListLabManualExameByExameDesc(){
        this.listLabManualExames = null;
        if(portal != null && strDescExame != null && strDescExame.length() > 1){
            this.listLabManualExames = PesquisaManualDao.grabListLabManualExameByExameDesc(strDescExame, portal.getStrDbName());
        }else{
            portal.popMsg(1, true, "Campo está vazio ou é menor que 2 caracteres...");
        }
    }
    public void grabListLabManualExameBySynonymies(ValueChangeEvent event){
        strSynonymies = (String)  event.getNewValue();
        grabListLabManualExameBySynonymies();
    }
    public void grabListLabManualExameBySynonymies(){
        this.listLabManualExames = null;
        if(portal != null && strSynonymies != null && strSynonymies.length() >= 5){
            this.listLabManualExames = PesquisaManualDao.grabListLabManualExameBySynonymies(strSynonymies, portal.getStrDbName());
        }else{
            portal.popMsg(1, true, "Campo está vazio ou é menor que 5 caracteres...");
        }
    }
    
    
}
