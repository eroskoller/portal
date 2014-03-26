/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.reports.faturamento;

import br.com.facesbeans.utils.CentroDeCustoConverter;
import br.com.facesbeans.utils.ClienteBanco;
import br.com.facesbeans.utils.ClienteBancoConverter;
import br.com.facesbeans.utils.JSFHelper;
import br.com.portal.beans.login.PortalView;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author eros
 */
@ManagedBean(name="erpFaturamentoClientesViewBean")
@SessionScoped
public class ErpFaturamentoClientesView implements Serializable{
    
    private PortalView portal;
    private String strJasperFormat = "pdf";
    private List<ClienteBanco>  listClienteBancoItems = null; 
    private List<ClienteBanco>  listClienteBancoSelected = null; 
    
    
    private Date dtStart;
    private Date dtEnd;

    public ErpFaturamentoClientesView() {
        portal = (PortalView) JSFHelper.getSessionAttribute("portalViewBean");
        listClienteBancoItems = ClienteBancoConverter.clienteBancoDB;
    }
    
    @PostConstruct
    private void initPost(){
        dtStart = new Date();
        dtEnd = new Date();
    }

    public String getStrJasperFormat() {
        return strJasperFormat;
    }

    public void setStrJasperFormat(String strJasperFormat) {
        this.strJasperFormat = strJasperFormat;
    }

    public List<ClienteBanco> getListClienteBancoItems() {
        return listClienteBancoItems;
    }

    public void setListClienteBancoItems(List<ClienteBanco> listClienteBancoItems) {
        this.listClienteBancoItems = listClienteBancoItems;
    }

    public List<ClienteBanco> getListClienteBancoSelected() {
        return listClienteBancoSelected;
    }

    public void setListClienteBancoSelected(List<ClienteBanco> listClienteBancoSelected) {
        this.listClienteBancoSelected = listClienteBancoSelected;
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
    
    
}
