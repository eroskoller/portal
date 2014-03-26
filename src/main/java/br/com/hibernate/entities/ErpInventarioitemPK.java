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
public class ErpInventarioitemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "INV_IN_CODIGO")
    private BigInteger invInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_LOTE")
    private String itmStLote;

    public ErpInventarioitemPK() {
    }

    public ErpInventarioitemPK(BigInteger invInCodigo, String itmStCodigo, String itmStLote) {
        this.invInCodigo = invInCodigo;
        this.itmStCodigo = itmStCodigo;
        this.itmStLote = itmStLote;
    }

    public BigInteger getInvInCodigo() {
        return invInCodigo;
    }

    public void setInvInCodigo(BigInteger invInCodigo) {
        this.invInCodigo = invInCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getItmStLote() {
        return itmStLote;
    }

    public void setItmStLote(String itmStLote) {
        this.itmStLote = itmStLote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invInCodigo != null ? invInCodigo.hashCode() : 0);
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        hash += (itmStLote != null ? itmStLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpInventarioitemPK)) {
            return false;
        }
        ErpInventarioitemPK other = (ErpInventarioitemPK) object;
        if ((this.invInCodigo == null && other.invInCodigo != null) || (this.invInCodigo != null && !this.invInCodigo.equals(other.invInCodigo))) {
            return false;
        }
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        if ((this.itmStLote == null && other.itmStLote != null) || (this.itmStLote != null && !this.itmStLote.equals(other.itmStLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpInventarioitemPK[ invInCodigo=" + invInCodigo + ", itmStCodigo=" + itmStCodigo + ", itmStLote=" + itmStLote + " ]";
    }
    
}
