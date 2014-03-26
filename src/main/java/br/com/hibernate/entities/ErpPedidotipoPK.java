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
public class ErpPedidotipoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PTI_IN_CODIGO")
    private BigInteger ptiInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PTI_ST_CODIGOTIPO")
    private String ptiStCodigotipo;

    public ErpPedidotipoPK() {
    }

    public ErpPedidotipoPK(BigInteger ptiInCodigo, String ptiStCodigotipo) {
        this.ptiInCodigo = ptiInCodigo;
        this.ptiStCodigotipo = ptiStCodigotipo;
    }

    public BigInteger getPtiInCodigo() {
        return ptiInCodigo;
    }

    public void setPtiInCodigo(BigInteger ptiInCodigo) {
        this.ptiInCodigo = ptiInCodigo;
    }

    public String getPtiStCodigotipo() {
        return ptiStCodigotipo;
    }

    public void setPtiStCodigotipo(String ptiStCodigotipo) {
        this.ptiStCodigotipo = ptiStCodigotipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ptiInCodigo != null ? ptiInCodigo.hashCode() : 0);
        hash += (ptiStCodigotipo != null ? ptiStCodigotipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedidotipoPK)) {
            return false;
        }
        ErpPedidotipoPK other = (ErpPedidotipoPK) object;
        if ((this.ptiInCodigo == null && other.ptiInCodigo != null) || (this.ptiInCodigo != null && !this.ptiInCodigo.equals(other.ptiInCodigo))) {
            return false;
        }
        if ((this.ptiStCodigotipo == null && other.ptiStCodigotipo != null) || (this.ptiStCodigotipo != null && !this.ptiStCodigotipo.equals(other.ptiStCodigotipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedidotipoPK[ ptiInCodigo=" + ptiInCodigo + ", ptiStCodigotipo=" + ptiStCodigotipo + " ]";
    }
    
}
