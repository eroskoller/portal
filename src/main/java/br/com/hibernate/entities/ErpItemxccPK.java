/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eros
 */
@Embeddable
public class ErpItemxccPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;

    public ErpItemxccPK() {
    }

    public ErpItemxccPK(String ccuStCodigo, String itmStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
        this.itmStCodigo = itmStCodigo;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccuStCodigo != null ? ccuStCodigo.hashCode() : 0);
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemxccPK)) {
            return false;
        }
        ErpItemxccPK other = (ErpItemxccPK) object;
        if ((this.ccuStCodigo == null && other.ccuStCodigo != null) || (this.ccuStCodigo != null && !this.ccuStCodigo.equals(other.ccuStCodigo))) {
            return false;
        }
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemxccPK[ ccuStCodigo=" + ccuStCodigo + ", itmStCodigo=" + itmStCodigo + " ]";
    }
    
}
