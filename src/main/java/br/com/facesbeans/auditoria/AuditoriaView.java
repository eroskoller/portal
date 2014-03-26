/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.auditoria;

import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabAuditoria;
import br.com.hibernate.entities.LabErroAuditoria;
import br.com.hibernate.entities.LabSistema;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import br.com.utils.tipstricks.DateRange;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.DateSelectEvent;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name="auditoriaViewBean")
public class AuditoriaView implements Serializable{
    
    private String strSearchType = "c";
    
    private boolean blCombinada = true;
    private boolean blRequisicao;
    private boolean blSolicitacao;
    
    
    private PortalView portal;
    private String sisStCodigo;
    private List<LabSistema>  listLabSistema;
    private Long errInCodigo;
    private List<LabErroAuditoria> listLabErroAuditoria;
    
    private String strReqStCodigo;
        private String strReqStCodigoAlt;
    private String strMsg;
    
    private boolean  blTodos = true;
    private boolean  blPendentes = true;
    private boolean  blVerificados = true;
    
    private List<LabAuditoria> listAuditorias;
    
    private Date dtStart;
    private Date dtEnd;
    
    private Character strStatusExame = '0';
    

    public AuditoriaView() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        if(portal != null){
            listLabErroAuditoria = AuditoriaDao.grabAllLabErros(portal.getStrDbName());
            listLabSistema = AuditoriaDao.grabAllLabSistemaByUser(portal.getLabUsuario(),portal.getStrDbName());
            dtStart = DateRange.shiftDayto00hrs(new Date());//OracleHelper.getDateFromDB(portal.getStrDbName());
            dtEnd = DateRange.shiftDayto24hrs(new Date());//OracleHelper.getDateFromDB(portal.getStrDbName());
        }
    }

    public boolean isBlCombinada() {
        return blCombinada;
    }

    public void setBlCombinada(boolean blCombinada) {
        this.blCombinada = blCombinada;
    }

    public boolean isBlRequisicao() {
        return blRequisicao;
    }

    public void setBlRequisicao(boolean blRequisicao) {
        this.blRequisicao = blRequisicao;
    }

    public boolean isBlSolicitacao() {
        return blSolicitacao;
    }

    public void setBlSolicitacao(boolean blSolicitacao) {
        this.blSolicitacao = blSolicitacao;
    }

    public String getStrSearchType() {
        return strSearchType;
    }

    public void setStrSearchType(String strSearchType) {
        this.strSearchType = strSearchType;
    }

    public List<LabAuditoria> getListAuditorias() {
        return listAuditorias;
    }

    public void setListAuditorias(List<LabAuditoria> listAuditorias) {
        this.listAuditorias = listAuditorias;
    }

    public String getStrReqStCodigoAlt() {
        return strReqStCodigoAlt;
    }

    public void setStrReqStCodigoAlt(String strReqStCodigoAlt) {
        this.strReqStCodigoAlt = strReqStCodigoAlt.trim();
    }

    
    public String getSisStCodigo() {
        return sisStCodigo;
    }

    public void setSisStCodigo(String sisStCodigo) {
        this.sisStCodigo = sisStCodigo;
    }

    public Long getErrInCodigo() {
        return errInCodigo;
    }

    public void setErrInCodigo(Long errInCodigo) {
        this.errInCodigo = errInCodigo;
    }

    public String getStrReqStCodigo() {
        return strReqStCodigo;
    }

    public void setStrReqStCodigo(String strReqStCodigo) {
        this.strReqStCodigo = strReqStCodigo.trim();
    }

    public String getStrMsg() {
        return strMsg;
    }

    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }

    public boolean isBlTodos() {
        return blTodos;
    }

    public void setBlTodos(boolean blTodos) {
        this.blTodos = blTodos;
        if(blTodos){
            blPendentes = true;
            blVerificados = true;
        }else{
            blPendentes = false;
            blVerificados = false;
        }
    }

    public boolean isBlPendentes() {
        return blPendentes;
    }

    public void setBlPendentes(boolean blPendentes) {
        this.blPendentes = blPendentes;
        if(!blPendentes){
            blTodos = false;
        }
    }

    public boolean isBlVerificados() {
        return blVerificados;
    }

    public void setBlVerificados(boolean blVerificados) {
        this.blVerificados = blVerificados;
        if(!blVerificados){
            blTodos = false;
        }
    }

    public Date getDtStart() {
        return dtStart;
    }

    public void setDtStart(Date dtStart) {
        this.dtStart = dtStart;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    
    
    
    public List<LabErroAuditoria> getListLabErroAuditoria() {
        if(listLabErroAuditoria == null){
            listLabErroAuditoria = AuditoriaDao.grabAllLabErros(portal.getStrDbName());
        }
        return listLabErroAuditoria;
    }

    public SelectItem[] getErrosItens() {
        SelectItem[] retorno = null;
        if(listLabErroAuditoria != null && !listLabErroAuditoria.isEmpty()){
            retorno = new SelectItem[listLabErroAuditoria.size() + 1];
            
        retorno[0] = new SelectItem(0L, "------------------");   
            for (int i = 0; i < listLabErroAuditoria.size() ; i++) {
                LabErroAuditoria le = listLabErroAuditoria.get(i);
                retorno[i+1] = new SelectItem(le.getErrInCodigo(),le.getErrInCodigo()+" - "+ le.getErrStDescricao());
            }
            
        }else{
            retorno = new SelectItem[1];
            retorno[0] = new SelectItem(0L, "------------------");
        }
        return retorno;
    }

    public List<LabSistema> getListLabSistema() {
        return listLabSistema;
    }

    public SelectItem[] getSistemaItens() {
        SelectItem[] retorno = null;
        if(listLabSistema != null && !listLabSistema.isEmpty() ){
            retorno = new SelectItem[listLabSistema.size() ];
//            retorno[0] = new SelectItem("999999", "------------------");
            for (int i = 0; i < listLabSistema.size() ; i++) {
                LabSistema ls = listLabSistema.get(i);
                retorno[i] = new SelectItem(ls.getSisStCodigo(),ls.getSisStCodigo());
            }
            
        }else{
            retorno = new SelectItem[1];
            retorno[0] = new SelectItem("999999", "------------------");
        }
        return retorno;
    }
    
    public void validateDateRange(DateSelectEvent event) {

        if (!DateRange.rangeVerifierMonths(3, dtStart, dtEnd)) {
            this.portal.popMsg(2, true, "O intervalo entre datas é de no maximo " + 3 + " mês.");
        } else {
            this.portal.popMsg(1000, false, "");
        }
    }
    
    private String grabStatusErro(){
        if(blPendentes && !blVerificados){
            return  "pendentes";    
        }else if(!blPendentes && blVerificados){
            return  "verificados";
        }else{
            return  "todos";
        }
    }
    
    private void popStatusPesquisa() {
        if (listAuditorias == null) {
            portal.popMsg(0, false, "Sua pesquisa não retornou resultados.....");
        } else if (listAuditorias != null && listAuditorias.isEmpty()) {
            portal.popMsg(0, false, "Sua pesquisa não retornou resultados.....");
        }
    }
    
    public void grabListErrosByDate(){
        this.listAuditorias =  null;
        if(sisStCodigo != null && !sisStCodigo.equalsIgnoreCase("999999")){
            if (!DateRange.rangeVerifierMonths(3, dtStart, dtEnd)) {
            this.portal.popMsg(2, true, "O intervalo entre datas é de no maximo " + 3 + " mês.");
            } else {
                    this.listAuditorias = 
                            AuditoriaDao.grabListLabAuditoriaByDt
                            (portal.getStrDbName(), dtStart, dtEnd, this.sisStCodigo, this.errInCodigo, this.strMsg, grabStatusErro());
                    this.popStatusPesquisa();
            }
            
        }else{
            portal.popMsg(1, true, "O campo sistema é obrigatório..................");
        }
    }
    
    public void grabListErrosByReqByValueChange(ValueChangeEvent event){
        this.strReqStCodigo = (String) event.getNewValue();
        grabListErrosByReq();
    }
    
    public void grabListErrosByReq(){
        this.listAuditorias =  null;
        if(this.strReqStCodigo != null){
            this.listAuditorias = OracleHelper.getListOfObjectByKeyEq(LabAuditoria.class, "reqStCodigo", this.strReqStCodigo, "audDtData", false, portal.getStrDbName());
            popStatusPesquisa();
        }else{
            this.portal.popMsg(2, true, "O código da requisição é obrigatório");
        }
    }
    
    
    public void grabListErrosByReqAltByValueChange(ValueChangeEvent event){
        this.strReqStCodigoAlt = (String) event.getNewValue();
        grabListErrosByReqAlt();
    }
    
    public void grabListErrosByReqAlt(){
        this.listAuditorias =  null;
        if(this.strReqStCodigoAlt != null){
            this.listAuditorias = OracleHelper.getListOfObjectByKeyEq(LabAuditoria.class, "reqStCodigoAlt", this.strReqStCodigoAlt , "audDtData", false, portal.getStrDbName());
            popStatusPesquisa();
        }else{
            this.portal.popMsg(2, true, "O código da requisição é obrigatório");
        }
    }
    
    
     public SelectItem[] getSearchTypeItens() {
        SelectItem[] d = {new SelectItem("c", "Sistema / Datas"), new SelectItem("req", "Requisição / Solicitante")};
        return d;
    }
    private void everyBooleanToDefault() {
        blCombinada = true;
        blRequisicao = false;
    }
    
      
    public void changePageBySearchTypePicListener(){
        this.everyBooleanToDefault();
//        System.out.println("Inside changePageBySearchTypePicListener   strSearchType : "+strSearchType);
        switch(strSearchType){
            case "c":
                everyBooleanToDefault();
            break;
            case "req":
                everyBooleanToDefault();
                blCombinada = false;
                blRequisicao =  true;
            break;
//            case "n":
//                everyBooleanToDefault();
//                blCombinada = false;
//                blNome =  true;
//            break;  
            default:
                everyBooleanToDefault();
        }
        
    }
    
    
   public void cleanUpEveryThing(){
       
     strSearchType = "c";
    everyBooleanToDefault();
    listAuditorias = null; 
    sisStCodigo  = null;
    errInCodigo = 0L;
    strReqStCodigo = null;
    strReqStCodigoAlt = null;
    strMsg = null;
    dtStart = DateRange.shiftDayto00hrs(new Date());//OracleHelper.getDateFromDB(portal.getStrDbName());
    dtEnd = DateRange.shiftDayto24hrs(new Date());//OracleHelper.getDateFromDB(portal.getStrDbName());
       
   }
   
   
   public void checkUnCheckLabAuditoria(){
        
//        System.out.println("Inside   checkUnCheckLabAuditoria");
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("paramauincodigo");
        if(paramValue != null  && listAuditorias != null ){
//            System.out.println("paramValue: "+ paramValue); 
            for (LabAuditoria au : listAuditorias) {
                if(au.getAudInCodigo().toString().equalsIgnoreCase(paramValue)){
                    checkUnCheck(au);
                    OracleHelper.updateObject(au, portal.getStrDbName());
                    break;
                }
            }
        }
    }

    private LabAuditoria checkUnCheck(LabAuditoria au) {
        if (au.getAudChVerificado() != null && au.getAudChVerificado().toString().equalsIgnoreCase("1")) {
            au.setAudChVerificado('0');
            au.setAudStUsuario(null);
            au.setAudDtDataVerificado(null);
        } else {
            au.setAudChVerificado('1');
            au.setAudStUsuario(portal.getLabUsuario().getUsuStCodigo());
            au.setAudDtDataVerificado(OracleHelper.getDateFromDB(portal.getStrDbName()));
        }
        return au;
    }
    
    
    
}
