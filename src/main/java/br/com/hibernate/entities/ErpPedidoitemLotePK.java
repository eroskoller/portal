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
public class ErpPedidoitemLotePK implements Serializable{
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "PED_IN_CODIGO")
    private Long pedInCodigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String iTmStCodigo;

    public ErpPedidoitemLotePK() {
    }

    public String getiTmStCodigo() {
        return iTmStCodigo;
    }

    public void setiTmStCodigo(String iTmStCodigo) {
        this.iTmStCodigo = iTmStCodigo;
    }

    public Long getPedInCodigo() {
        return pedInCodigo;
    }

    public void setPedInCodigo(Long pedInCodigo) {
        this.pedInCodigo = pedInCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErpPedidoitemLotePK other = (ErpPedidoitemLotePK) obj;
        if (this.pedInCodigo != other.pedInCodigo && (this.pedInCodigo == null || !this.pedInCodigo.equals(other.pedInCodigo))) {
            return false;
        }
        if ((this.iTmStCodigo == null) ? (other.iTmStCodigo != null) : !this.iTmStCodigo.equals(other.iTmStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.pedInCodigo != null ? this.pedInCodigo.hashCode() : 0);
        hash = 53 * hash + (this.iTmStCodigo != null ? this.iTmStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ErpPedidoitemLotePK{" + "pedInCodigo=" + pedInCodigo + ", iTmStCodigo=" + iTmStCodigo + '}';
    }
    
    
    
    
}
