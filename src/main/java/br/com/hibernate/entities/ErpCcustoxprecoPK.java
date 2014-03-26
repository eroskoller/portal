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
public class ErpCcustoxprecoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPR_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date cprDtData;

    public ErpCcustoxprecoPK() {
    }

    public ErpCcustoxprecoPK(String ccuStCodigo, Date cprDtData) {
        this.ccuStCodigo = ccuStCodigo;
        this.cprDtData = cprDtData;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    public Date getCprDtData() {
        return cprDtData;
    }

    public void setCprDtData(Date cprDtData) {
        this.cprDtData = cprDtData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccuStCodigo != null ? ccuStCodigo.hashCode() : 0);
        hash += (cprDtData != null ? cprDtData.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCcustoxprecoPK)) {
            return false;
        }
        ErpCcustoxprecoPK other = (ErpCcustoxprecoPK) object;
        if ((this.ccuStCodigo == null && other.ccuStCodigo != null) || (this.ccuStCodigo != null && !this.ccuStCodigo.equals(other.ccuStCodigo))) {
            return false;
        }
        if ((this.cprDtData == null && other.cprDtData != null) || (this.cprDtData != null && !this.cprDtData.equals(other.cprDtData))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCcustoxprecoPK[ ccuStCodigo=" + ccuStCodigo + ", cprDtData=" + cprDtData + " ]";
    }
    
}
