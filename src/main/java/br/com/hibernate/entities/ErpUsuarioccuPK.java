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
public class ErpUsuarioccuPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;

    public ErpUsuarioccuPK() {
    }

    public ErpUsuarioccuPK(String usuStCodigo, String ccuStCodigo) {
        this.usuStCodigo = usuStCodigo;
        this.ccuStCodigo = ccuStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
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
        hash += (usuStCodigo != null ? usuStCodigo.hashCode() : 0);
        hash += (ccuStCodigo != null ? ccuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpUsuarioccuPK)) {
            return false;
        }
        ErpUsuarioccuPK other = (ErpUsuarioccuPK) object;
        if ((this.usuStCodigo == null && other.usuStCodigo != null) || (this.usuStCodigo != null && !this.usuStCodigo.equals(other.usuStCodigo))) {
            return false;
        }
        if ((this.ccuStCodigo == null && other.ccuStCodigo != null) || (this.ccuStCodigo != null && !this.ccuStCodigo.equals(other.ccuStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpUsuarioccuPK[ usuStCodigo=" + usuStCodigo + ", ccuStCodigo=" + ccuStCodigo + " ]";
    }
    
}
