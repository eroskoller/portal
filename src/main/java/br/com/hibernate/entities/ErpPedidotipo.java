/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_PEDIDOTIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpPedidotipo.findAll", query = "SELECT e FROM ErpPedidotipo e"),
    @NamedQuery(name = "ErpPedidotipo.findByPtiInCodigo", query = "SELECT e FROM ErpPedidotipo e WHERE e.erpPedidotipoPK.ptiInCodigo = :ptiInCodigo"),
    @NamedQuery(name = "ErpPedidotipo.findByPtiStCodigotipo", query = "SELECT e FROM ErpPedidotipo e WHERE e.erpPedidotipoPK.ptiStCodigotipo = :ptiStCodigotipo"),
    @NamedQuery(name = "ErpPedidotipo.findByPtiStDescricaotipo", query = "SELECT e FROM ErpPedidotipo e WHERE e.ptiStDescricaotipo = :ptiStDescricaotipo")})
public class ErpPedidotipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpPedidotipoPK erpPedidotipoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PTI_ST_DESCRICAOTIPO")
    private String ptiStDescricaotipo;

    public ErpPedidotipo() {
    }

    public ErpPedidotipo(ErpPedidotipoPK erpPedidotipoPK) {
        this.erpPedidotipoPK = erpPedidotipoPK;
    }

    public ErpPedidotipo(ErpPedidotipoPK erpPedidotipoPK, String ptiStDescricaotipo) {
        this.erpPedidotipoPK = erpPedidotipoPK;
        this.ptiStDescricaotipo = ptiStDescricaotipo;
    }

    public ErpPedidotipo(BigInteger ptiInCodigo, String ptiStCodigotipo) {
        this.erpPedidotipoPK = new ErpPedidotipoPK(ptiInCodigo, ptiStCodigotipo);
    }

    public ErpPedidotipoPK getErpPedidotipoPK() {
        return erpPedidotipoPK;
    }

    public void setErpPedidotipoPK(ErpPedidotipoPK erpPedidotipoPK) {
        this.erpPedidotipoPK = erpPedidotipoPK;
    }

    public String getPtiStDescricaotipo() {
        return ptiStDescricaotipo;
    }

    public void setPtiStDescricaotipo(String ptiStDescricaotipo) {
        this.ptiStDescricaotipo = ptiStDescricaotipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpPedidotipoPK != null ? erpPedidotipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedidotipo)) {
            return false;
        }
        ErpPedidotipo other = (ErpPedidotipo) object;
        if ((this.erpPedidotipoPK == null && other.erpPedidotipoPK != null) || (this.erpPedidotipoPK != null && !this.erpPedidotipoPK.equals(other.erpPedidotipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedidotipo[ erpPedidotipoPK=" + erpPedidotipoPK + " ]";
    }
    
}
