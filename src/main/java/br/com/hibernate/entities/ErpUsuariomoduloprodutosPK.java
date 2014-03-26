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
public class ErpUsuariomoduloprodutosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "MPR_ST_CODIGO")
    private String mprStCodigo;

    public ErpUsuariomoduloprodutosPK() {
    }

    public ErpUsuariomoduloprodutosPK(String usuStCodigo, String mprStCodigo) {
        this.usuStCodigo = usuStCodigo;
        this.mprStCodigo = mprStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getMprStCodigo() {
        return mprStCodigo;
    }

    public void setMprStCodigo(String mprStCodigo) {
        this.mprStCodigo = mprStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuStCodigo != null ? usuStCodigo.hashCode() : 0);
        hash += (mprStCodigo != null ? mprStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpUsuariomoduloprodutosPK)) {
            return false;
        }
        ErpUsuariomoduloprodutosPK other = (ErpUsuariomoduloprodutosPK) object;
        if ((this.usuStCodigo == null && other.usuStCodigo != null) || (this.usuStCodigo != null && !this.usuStCodigo.equals(other.usuStCodigo))) {
            return false;
        }
        if ((this.mprStCodigo == null && other.mprStCodigo != null) || (this.mprStCodigo != null && !this.mprStCodigo.equals(other.mprStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpUsuariomoduloprodutosPK[ usuStCodigo=" + usuStCodigo + ", mprStCodigo=" + mprStCodigo + " ]";
    }
    
}
