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
public class ErpPedidoitemtempPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PED_IN_CODIGO_TEMP")
    private BigInteger pedInCodigoTemp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO_TEMP")
    private String itmStCodigoTemp;

    public ErpPedidoitemtempPK() {
    }

    public ErpPedidoitemtempPK(BigInteger pedInCodigoTemp, String itmStCodigoTemp) {
        this.pedInCodigoTemp = pedInCodigoTemp;
        this.itmStCodigoTemp = itmStCodigoTemp;
    }

    public BigInteger getPedInCodigoTemp() {
        return pedInCodigoTemp;
    }

    public void setPedInCodigoTemp(BigInteger pedInCodigoTemp) {
        this.pedInCodigoTemp = pedInCodigoTemp;
    }

    public String getItmStCodigoTemp() {
        return itmStCodigoTemp;
    }

    public void setItmStCodigoTemp(String itmStCodigoTemp) {
        this.itmStCodigoTemp = itmStCodigoTemp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedInCodigoTemp != null ? pedInCodigoTemp.hashCode() : 0);
        hash += (itmStCodigoTemp != null ? itmStCodigoTemp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedidoitemtempPK)) {
            return false;
        }
        ErpPedidoitemtempPK other = (ErpPedidoitemtempPK) object;
        if ((this.pedInCodigoTemp == null && other.pedInCodigoTemp != null) || (this.pedInCodigoTemp != null && !this.pedInCodigoTemp.equals(other.pedInCodigoTemp))) {
            return false;
        }
        if ((this.itmStCodigoTemp == null && other.itmStCodigoTemp != null) || (this.itmStCodigoTemp != null && !this.itmStCodigoTemp.equals(other.itmStCodigoTemp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedidoitemtempPK[ pedInCodigoTemp=" + pedInCodigoTemp + ", itmStCodigoTemp=" + itmStCodigoTemp + " ]";
    }
    
}
