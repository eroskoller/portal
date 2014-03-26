/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eros
 */
@Embeddable
public class ErpItemxprecooldPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FDO_ST_CODIGO")
    private String fdoStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IPR_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date iprDtData;

    public ErpItemxprecooldPK() {
    }

    public ErpItemxprecooldPK(String itmStCodigo, String fdoStCodigo, Date iprDtData) {
        this.itmStCodigo = itmStCodigo;
        this.fdoStCodigo = fdoStCodigo;
        this.iprDtData = iprDtData;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getFdoStCodigo() {
        return fdoStCodigo;
    }

    public void setFdoStCodigo(String fdoStCodigo) {
        this.fdoStCodigo = fdoStCodigo;
    }

    public Date getIprDtData() {
        return iprDtData;
    }

    public void setIprDtData(Date iprDtData) {
        this.iprDtData = iprDtData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        hash += (fdoStCodigo != null ? fdoStCodigo.hashCode() : 0);
        hash += (iprDtData != null ? iprDtData.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemxprecooldPK)) {
            return false;
        }
        ErpItemxprecooldPK other = (ErpItemxprecooldPK) object;
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        if ((this.fdoStCodigo == null && other.fdoStCodigo != null) || (this.fdoStCodigo != null && !this.fdoStCodigo.equals(other.fdoStCodigo))) {
            return false;
        }
        if ((this.iprDtData == null && other.iprDtData != null) || (this.iprDtData != null && !this.iprDtData.equals(other.iprDtData))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemxprecooldPK[ itmStCodigo=" + itmStCodigo + ", fdoStCodigo=" + fdoStCodigo + ", iprDtData=" + iprDtData + " ]";
    }
    
}
