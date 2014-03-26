/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.laudo;

import br.com.facesbeans.shared.ArrayItems;
import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabLocal;
import br.com.hibernate.entities.LabLocalPK;
import br.com.hibernate.entities.LabOrigem;
import br.com.hibernate.entities.LabPaciente;
import br.com.hibernate.entities.LabRequisicao;
import br.com.hibernate.utils.OracleHelper;
import br.com.portal.beans.login.PortalView;
import br.com.utils.tipstricks.DateRange;
import br.com.utils.tipstricks.ZerosFabrica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author eros
 */
@SessionScoped
@ManagedBean(name="consultaLaudoViewBean")
public class ConsultaLaudoView implements Serializable{

    
    private String strSearchType = "c";
    
    private LabRequisicaoBean selectedLabRequisicaoBean;
    
    
    private boolean blCombinada = true;
    private boolean blRequisicao_Prontuario;
    private boolean blNome;
    
    private PortalView portal =  null;
    private String strOriStCodigo;
    private LabOrigem labOrigem;
    private List<LabOrigem> listLabOrigem;
    private LabLocal labLocal;
    private List<LabLocal>  listLabLocal;
    private String strLocStCodigo;
    
    
    private Date  dtStart;
    private Date  dtEnd;
    
    private String strAno;
    private String strReqStCodigo;
    private String strNomePaciente;
    private String strPacStProntuario;
    private LabPaciente labPaciente;
    
    
    private List<LabRequisicaoBean>  listLabRequisicaoBeans;
    
    private boolean blLiberados;
    private boolean blImpressos;
    private boolean blTodos;
    
    
    public ConsultaLaudoView() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        if(portal != null){
            dtStart = OracleHelper.getDateFromDB(portal.getStrDbName());
            dtEnd = OracleHelper.getDateFromDB(portal.getStrDbName());
        }
        
    }

    public LabRequisicaoBean getSelectedLabRequisicaoBean() { 
        if(selectedLabRequisicaoBean != null){
            System.out.println("Inside getSelectedLabRequisicaoBean(): "+selectedLabRequisicaoBean.getLabRequisicao().getReqInCodigo());
        }
        
        return selectedLabRequisicaoBean;
    }

    public void setSelectedLabRequisicaoBean(LabRequisicaoBean selectedLabRequisicaoBean) {
        this.selectedLabRequisicaoBean = selectedLabRequisicaoBean;
    }

    
    
    public List<LabRequisicaoBean> getListLabRequisicaoBeans() {
        return listLabRequisicaoBeans;
    }

    public void setListLabRequisicaoBeans(List<LabRequisicaoBean> listLabRequisicaoBeans) {
        this.listLabRequisicaoBeans = listLabRequisicaoBeans;
    }
    
    public String getStrOriStCodigo() {
        return strOriStCodigo;
    }

    public void setStrOriStCodigo(String strOriStCodigo) {
        this.strOriStCodigo =  ZerosFabrica.makeZeros(strOriStCodigo.toUpperCase(), 6)  ;
    }

    public LabOrigem getLabOrigem() {
        return labOrigem;
    }

    public void setLabOrigem(LabOrigem labOrigem) {
        this.labOrigem = labOrigem;
    }

    public LabLocal getLabLocal() {
        return labLocal;
    }

    public void setLabLocal(LabLocal labLocal) {
        this.labLocal = labLocal;
    }

    public String getStrLocStCodigo() {
        return strLocStCodigo;
    }

    public void setStrLocStCodigo(String strLocStCodigo) {
        this.strLocStCodigo =  ZerosFabrica.makeZeros(strLocStCodigo.toUpperCase(), 6)  ; 
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

    public String getStrAno() {
        return strAno;
    }

    public void setStrAno(String strAno) {
        this.strAno = strAno;
    }

    public String getStrReqStCodigo() {
        return strReqStCodigo;
    }

    public void setStrReqStCodigo(String strReqStCodigo) {
        this.strReqStCodigo = strReqStCodigo;
    }

    public String getStrNomePaciente() {
        return strNomePaciente;
    }

    public void setStrNomePaciente(String strNomePaciente) {
        this.strNomePaciente = strNomePaciente;
    }

    public String getStrPacStProntuario() {
        return strPacStProntuario;
    }

    public void setStrPacStProntuario(String strPacStProntuario) {
        this.strPacStProntuario = strPacStProntuario;
    }

    public LabPaciente getLabPaciente() {
        return labPaciente;
    }

    public void setLabPaciente(LabPaciente labPaciente) {
        this.labPaciente = labPaciente;
    }

    public boolean isBlLiberados() {
        return blLiberados;
    }

    public void setBlLiberados(boolean blLiberados) {
        this.blLiberados = blLiberados;
    }

    public boolean isBlImpressos() {
        return blImpressos;
    }

    public void setBlImpressos(boolean blImpressos) {
        this.blImpressos = blImpressos;
    }

    public String getStrSearchType() {
        return strSearchType;
    }

    public void setStrSearchType(String strSearchType) {
        this.strSearchType = strSearchType;
    }

    public boolean isBlCombinada() {
        return blCombinada;
    }

    public void setBlCombinada(boolean blCombinada) {
        this.blCombinada = blCombinada;
    }

    public boolean isBlRequisicao_Prontuario() {
        return blRequisicao_Prontuario;
    }

    public void setBlRequisicao_Prontuario(boolean blRequisicao_Prontuario) {
        this.blRequisicao_Prontuario = blRequisicao_Prontuario;
    }

    

    public boolean isBlNome() {
        return blNome;
    }

    public void setBlNome(boolean blNome) {
        this.blNome = blNome;
    }

    public boolean isBlTodos() {
        return blTodos;
    }

    public List<LabOrigem> getListLabOrigem() {
        if(listLabOrigem == null ){
          listLabOrigem =   OracleHelper.getListOfObjectByKeyEq(LabOrigem.class, "uniStCodigo", portal.getLabUnidade().getUniStCodigo(), "oriStCodigo", true,portal.getStrDbName());
        }
        return listLabOrigem;
    }

    public void setListLabOrigem(List<LabOrigem> listLabOrigem) {
        this.listLabOrigem = listLabOrigem;
    }

    public List<LabLocal> getListLabLocal() {
        if(listLabLocal == null){
            listLabLocal =
                        OracleHelper.getListOfObjectByKeyEq(LabLocal.class, "uniStCodigo", portal.getLabUnidade().getUniStCodigo(), "locStCodigo", true,portal.getStrDbName());
        }
        return listLabLocal;
    }

    public void setListLabLocal(List<LabLocal> listLabLocal) {
        this.listLabLocal = listLabLocal;
    }
    

    public void setBlTodos(boolean blTodos) {
        this.blTodos = blTodos;
        if(blTodos){
            blImpressos = true;
            blLiberados = true;
        }else{
            blImpressos = false;
            blLiberados = false;
        }
    }
    
    
    
    public SelectItem[] getSearchTypeItens() {
        SelectItem[] d = {new SelectItem("c", "Posto / Local"), new SelectItem("req", "Requisição / Prontuário"), new SelectItem("n", "Nome do Paciente")};
        return d;
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
                blRequisicao_Prontuario =  true;
            break;
            case "n":
                everyBooleanToDefault();
                blCombinada = false;
                blNome =  true;
            break;  
            default:
                everyBooleanToDefault();
        }
        
    }

    private void everyBooleanToDefault() {
        blCombinada = true;
        blRequisicao_Prontuario= false;
        blNome= false;
    }
    
    public void validateDateRange(DateSelectEvent event) {
        if (!DateRange.rangeVerifierMonths(ArrayItems.intMaximumBillingMonths, this.dtStart, this.dtEnd)) {
            this.portal.popMsg(2, true, "O intervalo entre datas é de no maximo " + ArrayItems.intMaximumBillingMonths + " mes.");
        } else {
            this.portal.popMsg(1000, false, "");
        }
    }
    
    
    public void grabOrigem(ValueChangeEvent event) {
        setStrOriStCodigo((String) event.getNewValue());
        grabOrigem();
    }
    
    public void grabOrigem() {
        System.out.println("Inside grabOrigem()...............................");
        if (strOriStCodigo != null) {
            System.out.println("Inside grabOrigem()............................... strOriStCodigo: "+strOriStCodigo);
            labOrigem = null;
            labOrigem = OracleHelper.getLabOrigemByUniStCodigo(portal.getLabUnidade().getUniStCodigo(), strOriStCodigo,portal.getStrDbName());
            if (labOrigem != null) {
            } else {
                listLabOrigem =
                        OracleHelper.getListOfObjectByKeyEq(LabOrigem.class, "uniStCodigo", portal.getLabUnidade().getUniStCodigo(), "oriStCodigo", true,portal.getStrDbName());
                if (listLabOrigem != null) {
                    if (listLabOrigem.size() == 1) {
                        labOrigem = listLabOrigem.get(0);
//                        htmlLocStCodigo.requestFocus();
                    } else {
//                        blPopLabOrigem = true;
                    }
                }
            }
        }
    }
    
    
    public void grabLabOrigemFromList(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("consultalaudolistlaborigemparam");
        if (paramValue != null) {
            if (listLabOrigem != null && !listLabOrigem.isEmpty()) {

                for (LabOrigem lo : listLabOrigem) {
                    if (lo.getOriStCodigo().equalsIgnoreCase(paramValue)) {
                        setStrOriStCodigo(lo.getOriStCodigo());
                        grabOrigem();
                        break;
                    }
                }

            }

        }
    }
    
    
    public void grabLocal(ValueChangeEvent event) {
        setStrLocStCodigo((String) event.getNewValue());
        grabLocal();
    }
    public void grabLocal() {
        System.out.println("Inside grabLocal()..............");
        if (strLocStCodigo != null) {
            System.out.println("Inside grabLocal()..............   strLocStCodigo: "+strLocStCodigo);
            labLocal = null;
            LabLocalPK pk = new LabLocalPK(portal.getLabUnidade().getUniStCodigo(), strLocStCodigo);
            labLocal = (LabLocal) OracleHelper.getObject(LabLocal.class, pk,portal.getStrDbName());
            if (labLocal != null) {
//                htmlLocStCodigo.requestFocus();
            } else {
                listLabLocal =
                        OracleHelper.getListOfObjectByKeyEq(LabLocal.class, "uniStCodigo", portal.getLabUnidade().getUniStCodigo(), "locStCodigo", true,portal.getStrDbName());
                if (listLabLocal != null) {
                    if (listLabLocal.size() == 1) {
                        labLocal = listLabLocal.get(0);
//                        htmlLocStCodigo.requestFocus();
                    } else {
//                        blPopLabLocal = true;
                    }
                }
            }
        }
    }
    
    
    public void grabLabLocalFromList(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String paramValue = (String) map.get("consultalaudolistlablocalparam");
        if (paramValue != null) {
            if (listLabLocal != null && !listLabLocal.isEmpty()) {
                for (LabLocal lc : listLabLocal) {
                    if (lc.getLocStCodigo().equalsIgnoreCase(paramValue)) {
                        setStrLocStCodigo(lc.getLocStCodigo());
                        grabLocal();
                        break;
                    }
                }

            }

        }
    }
    
    public void grabListLabRequisicaoBeanByPacProntuario(ValueChangeEvent value) {
        this.strPacStProntuario = (String) value.getNewValue();
        grabListLabRequisicaoBeanByPacProntuario();
    }

    
    public void grabListLabRequisicaoBeanByPacProntuario() {
        listLabRequisicaoBeans = null;
        if (this.strPacStProntuario != null && this.strPacStProntuario.trim().length() > 0) {

            List<LabRequisicao> list = 
                    ConsultaLaudoDao.grabListLabRequisicaoByPacProntuario(strPacStProntuario.trim().toUpperCase(), portal.getStrDbName());

            if (list != null && !list.isEmpty()) {
                listLabRequisicaoBeans = new ArrayList<>(list.size());
                for (LabRequisicao lr : list) {
                    listLabRequisicaoBeans.add(new LabRequisicaoBean(portal, lr));
                }
            }
        } else {
            portal.popMsg(1, true, "Prontuário está vaizo................");
        }

    }
    
    
    public void grabListLabRequisicaoBeanByPacName(ValueChangeEvent value) {
        this.strNomePaciente = (String) value.getNewValue();
        grabListLabRequisicaoBeanByPacName();
    }
    
     public void grabListLabRequisicaoBeanByPacName() {
        listLabRequisicaoBeans = null;
        if (this.strNomePaciente != null && this.strNomePaciente.trim().length() >= 6) {

            List<LabRequisicao> list = ConsultaLaudoDao.grabListLabRequisicaoByPacName(strNomePaciente, portal.getStrDbName());

            if (list != null && !list.isEmpty()) {
                listLabRequisicaoBeans = new ArrayList<>(list.size());
                for (LabRequisicao lr : list) {
                    listLabRequisicaoBeans.add(new LabRequisicaoBean(portal, lr));
                }
                if(listLabRequisicaoBeans != null && listLabRequisicaoBeans.size() == 1000){
                    portal.popMsg(1, false, "Sua pesquisa foi limitada a 1000 resultados.....");
                }
                
            }
        } else {
            portal.popMsg(1, true, "Nome do Paciente está vaizo ou é menor que 6 caracteres................");
        }

    }
    
     
     public void grabListLabRequisicaoBeanByReq(ValueChangeEvent value) {
        this.strReqStCodigo = (String) value.getNewValue();
        grabListLabRequisicaoBeanByReq();
    }
    
    public void grabListLabRequisicaoBeanByReq() {
        listLabRequisicaoBeans = null;
        if (this.strReqStCodigo != null && this.strReqStCodigo.trim().length() > 0) {
            
            List<LabRequisicao> list = ConsultaLaudoDao.grabListLabRequisicaoByReqStCodigo(strReqStCodigo, portal.getStrDbName());

            if (list != null && !list.isEmpty()) {
                listLabRequisicaoBeans = new ArrayList<>(list.size());
                for (LabRequisicao lr : list) {
                    listLabRequisicaoBeans.add(new LabRequisicaoBean(portal, lr));
                }
                if (listLabRequisicaoBeans.size() >= ArrayItems.intMaximumReqsConsultaLaudo) {
                    portal.popMsg(1, true, "Sua pesquisa foi limitada à " + ArrayItems.intMaximumReqsConsultaLaudo + " resultados.");
                }
            }
        } else {
            portal.popMsg(1, true, "Código da requisição está vaizo................");
        }

    }
    
    
    
    public void grabListLabRequisicaoBeanCombinado(){
       
        System.out.println("Inside grabListLabRequisicaoBeanCombinado.............");
        listLabRequisicaoBeans = null;
       if(DateRange.rangeVerifierMonths(ArrayItems.intMaximumBillingMonths, this.dtStart, this.dtEnd)){
       
       
       if(portal != null){
           
           Map<String,Object> mapAnds4Req = new HashMap<String, Object>();
           mapAnds4Req.put("uniStCodigo", portal.getLabUnidade().getUniStCodigo()); 
           if(labOrigem != null){
               mapAnds4Req.put("oriStCodigo", labOrigem.getOriStCodigo());
           }
           
           
           if(labLocal != null){
               mapAnds4Req.put("locStCodigo", labLocal.getLocStCodigo());
           }
           Map<String,List> mapOrs4Req = new HashMap<String, List>();
           List listOrs = new ArrayList();
           if(blImpressos){listOrs.add("009");}
           if(blLiberados){listOrs.add("010");}
           if(blImpressos || blLiberados){listOrs.add("011");}
           
           mapOrs4Req.put("legStCodigoFat", listOrs);
           List<LabRequisicao> list  
                   = ConsultaLaudoDao.grabListLabRequisicao(LabRequisicao.class,  mapAnds4Req,mapOrs4Req , "reqDtCadastro", DateRange.shiftDayto00hrs(dtStart), DateRange.shiftDayto00hrs(dtEnd),ArrayItems.intMaximumReqsConsultaLaudo,portal.getStrDbName());
           if(list != null && !list.isEmpty()){
               Collections.sort(list, LabRequisicao.DT_CADASTRO_COMPARATOR_1_0);
                listLabRequisicaoBeans = new ArrayList<>(list.size());
                for(LabRequisicao lr : list){
                    listLabRequisicaoBeans.add(new LabRequisicaoBean(portal, lr));
                }
                if(listLabRequisicaoBeans.size()>= ArrayItems.intMaximumReqsConsultaLaudo ){
                   portal.popMsg(1, true, "Sua pesquisa foi limitada à "+ArrayItems.intMaximumReqsConsultaLaudo +" resultados."); 
                }
           }
           
       }
       
       }else{
           this.portal.popMsg(2, true, "O intervalo entre datas é de no maximo " + ArrayItems.intMaximumBillingMonths + " mes.");
        }
        
       if(listLabRequisicaoBeans == null ){
           this.portal.popMsg(2, true, "Sua pesquisa não retornou resultados......................");
       }
       
   }
    
    public void cleanUPEveryThing() {

        strSearchType = "c";
        selectedLabRequisicaoBean = null;
        blCombinada = true;
        blRequisicao_Prontuario = false;
        blNome = false;
        strOriStCodigo = null;
        labOrigem = null;
        listLabOrigem = null;
        labLocal = null;
        listLabLocal = null;
        strLocStCodigo = null;
        dtStart = OracleHelper.getDateFromDB(portal.getStrDbName());
        dtEnd = OracleHelper.getDateFromDB(portal.getStrDbName());
        strAno = null;
        strReqStCodigo = null;
        strNomePaciente = null;
        strPacStProntuario = null;
        labPaciente = null;
        listLabRequisicaoBeans = null;

    }
    
    
     public void onRowSelect(SelectEvent event) {  
//         System.out.println("Inside onRowSelect...........");
        selectedLabRequisicaoBean = (LabRequisicaoBean) event.getObject();
//        portal.popMsg(1, false, "Selecting ....   Requisição: "+selectedLabRequisicaoBean.getLabRequisicao().getReqInCodigo());
    }  
  
    public void onRowUnselect(UnselectEvent event) {  
//        portal.popMsg(1, true, "Unselecting ....   Requisição: "+selectedLabRequisicaoBean.getLabRequisicao().getReqInCodigo());
//            System.out.println("Inside onRowUnselect...........");
                selectedLabRequisicaoBean = null;
    }  
    
    
}
