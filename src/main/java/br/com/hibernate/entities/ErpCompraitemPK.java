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
public class ErpCompraitemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPR_IN_CODIGO")
    private BigInteger cprInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;

    public ErpCompraitemPK() {
    }

    public ErpCompraitemPK(BigInteger cprInCodigo, String itmStCodigo) {
        this.cprInCodigo = cprInCodigo;
        this.itmStCodigo = itmStCodigo;
    }

    public BigInteger getCprInCodigo() {
        return cprInCodigo;
    }

    public void setCprInCodigo(BigInteger cprInCodigo) {
        this.cprInCodigo = cprInCodigo;
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
        hash += (cprInCodigo != null ? cprInCodigo.hashCode() : 0);
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCompraitemPK)) {
            return false;
        }
        ErpCompraitemPK other = (ErpCompraitemPK) object;
        if ((this.cprInCodigo == null && other.cprInCodigo != null) || (this.cprInCodigo != null && !this.cprInCodigo.equals(other.cprInCodigo))) {
            return false;
        }
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCompraitemPK[ cprInCodigo=" + cprInCodigo + ", itmStCodigo=" + itmStCodigo + " ]";
    }
    
}
