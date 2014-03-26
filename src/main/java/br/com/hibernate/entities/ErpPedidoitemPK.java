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
public class ErpPedidoitemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PED_IN_CODIGO")
    private BigInteger pedInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;

    public ErpPedidoitemPK() {
    }

    public ErpPedidoitemPK(BigInteger pedInCodigo, String itmStCodigo) {
        this.pedInCodigo = pedInCodigo;
        this.itmStCodigo = itmStCodigo;
    }

    public BigInteger getPedInCodigo() {
        return pedInCodigo;
    }

    public void setPedInCodigo(BigInteger pedInCodigo) {
        this.pedInCodigo = pedInCodigo;
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
        hash += (pedInCodigo != null ? pedInCodigo.hashCode() : 0);
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedidoitemPK)) {
            return false;
        }
        ErpPedidoitemPK other = (ErpPedidoitemPK) object;
        if ((this.pedInCodigo == null && other.pedInCodigo != null) || (this.pedInCodigo != null && !this.pedInCodigo.equals(other.pedInCodigo))) {
            return false;
        }
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedidoitemPK[ pedInCodigo=" + pedInCodigo + ", itmStCodigo=" + itmStCodigo + " ]";
    }
    
}
