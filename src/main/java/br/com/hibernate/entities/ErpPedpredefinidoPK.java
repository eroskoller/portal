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
public class ErpPedpredefinidoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PPD_ST_CODIGO")
    private String ppdStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;

    public ErpPedpredefinidoPK() {
    }

    public ErpPedpredefinidoPK(String ppdStCodigo, String ccuStCodigo) {
        this.ppdStCodigo = ppdStCodigo;
        this.ccuStCodigo = ccuStCodigo;
    }

    public String getPpdStCodigo() {
        return ppdStCodigo;
    }

    public void setPpdStCodigo(String ppdStCodigo) {
        this.ppdStCodigo = ppdStCodigo;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ppdStCodigo != null ? ppdStCodigo.hashCode() : 0);
        hash += (ccuStCodigo != null ? ccuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedpredefinidoPK)) {
            return false;
        }
        ErpPedpredefinidoPK other = (ErpPedpredefinidoPK) object;
        if ((this.ppdStCodigo == null && other.ppdStCodigo != null) || (this.ppdStCodigo != null && !this.ppdStCodigo.equals(other.ppdStCodigo))) {
            return false;
        }
        if ((this.ccuStCodigo == null && other.ccuStCodigo != null) || (this.ccuStCodigo != null && !this.ccuStCodigo.equals(other.ccuStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedpredefinidoPK[ ppdStCodigo=" + ppdStCodigo + ", ccuStCodigo=" + ccuStCodigo + " ]";
    }
    
}
