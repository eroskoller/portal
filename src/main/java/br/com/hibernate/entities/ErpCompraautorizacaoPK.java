/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
public class ErpCompraautorizacaoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPR_IN_CODIGO")
    private BigInteger cprInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;

    public ErpCompraautorizacaoPK() {
    }

    public ErpCompraautorizacaoPK(BigInteger cprInCodigo, String usuStCodigo) {
        this.cprInCodigo = cprInCodigo;
        this.usuStCodigo = usuStCodigo;
    }

    public BigInteger getCprInCodigo() {
        return cprInCodigo;
    }

    public void setCprInCodigo(BigInteger cprInCodigo) {
        this.cprInCodigo = cprInCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cprInCodigo != null ? cprInCodigo.hashCode() : 0);
        hash += (usuStCodigo != null ? usuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCompraautorizacaoPK)) {
            return false;
        }
        ErpCompraautorizacaoPK other = (ErpCompraautorizacaoPK) object;
        if ((this.cprInCodigo == null && other.cprInCodigo != null) || (this.cprInCodigo != null && !this.cprInCodigo.equals(other.cprInCodigo))) {
            return false;
        }
        if ((this.usuStCodigo == null && other.usuStCodigo != null) || (this.usuStCodigo != null && !this.usuStCodigo.equals(other.usuStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCompraautorizacaoPK[ cprInCodigo=" + cprInCodigo + ", usuStCodigo=" + usuStCodigo + " ]";
    }
    
}
