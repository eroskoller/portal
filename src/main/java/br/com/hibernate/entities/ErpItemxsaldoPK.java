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
public class ErpItemxsaldoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "AMZ_ST_CODIGO")
    private String amzStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISD_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date isdDtData;

    public ErpItemxsaldoPK() {
    }

    public ErpItemxsaldoPK(String itmStCodigo, String amzStCodigo, Date isdDtData) {
        this.itmStCodigo = itmStCodigo;
        this.amzStCodigo = amzStCodigo;
        this.isdDtData = isdDtData;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getAmzStCodigo() {
        return amzStCodigo;
    }

    public void setAmzStCodigo(String amzStCodigo) {
        this.amzStCodigo = amzStCodigo;
    }

    public Date getIsdDtData() {
        return isdDtData;
    }

    public void setIsdDtData(Date isdDtData) {
        this.isdDtData = isdDtData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        hash += (amzStCodigo != null ? amzStCodigo.hashCode() : 0);
        hash += (isdDtData != null ? isdDtData.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemxsaldoPK)) {
            return false;
        }
        ErpItemxsaldoPK other = (ErpItemxsaldoPK) object;
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        if ((this.amzStCodigo == null && other.amzStCodigo != null) || (this.amzStCodigo != null && !this.amzStCodigo.equals(other.amzStCodigo))) {
            return false;
        }
        if ((this.isdDtData == null && other.isdDtData != null) || (this.isdDtData != null && !this.isdDtData.equals(other.isdDtData))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemxsaldoPK[ itmStCodigo=" + itmStCodigo + ", amzStCodigo=" + amzStCodigo + ", isdDtData=" + isdDtData + " ]";
    }
    
}
