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
public class ErpTransferenciaitemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRF_IN_CODIGO")
    private BigInteger trfInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;

    public ErpTransferenciaitemPK() {
    }

    public ErpTransferenciaitemPK(BigInteger trfInCodigo, String itmStCodigo) {
        this.trfInCodigo = trfInCodigo;
        this.itmStCodigo = itmStCodigo;
    }

    public BigInteger getTrfInCodigo() {
        return trfInCodigo;
    }

    public void setTrfInCodigo(BigInteger trfInCodigo) {
        this.trfInCodigo = trfInCodigo;
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
        hash += (trfInCodigo != null ? trfInCodigo.hashCode() : 0);
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpTransferenciaitemPK)) {
            return false;
        }
        ErpTransferenciaitemPK other = (ErpTransferenciaitemPK) object;
        if ((this.trfInCodigo == null && other.trfInCodigo != null) || (this.trfInCodigo != null && !this.trfInCodigo.equals(other.trfInCodigo))) {
            return false;
        }
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpTransferenciaitemPK[ trfInCodigo=" + trfInCodigo + ", itmStCodigo=" + itmStCodigo + " ]";
    }
    
}
