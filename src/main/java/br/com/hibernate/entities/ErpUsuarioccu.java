/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_USUARIOCCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpUsuarioccu.findAll", query = "SELECT e FROM ErpUsuarioccu e"),
    @NamedQuery(name = "ErpUsuarioccu.findByUsuStCodigo", query = "SELECT e FROM ErpUsuarioccu e WHERE e.erpUsuarioccuPK.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpUsuarioccu.findByCcuStCodigo", query = "SELECT e FROM ErpUsuarioccu e WHERE e.erpUsuarioccuPK.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpUsuarioccu.findByUccChPedido", query = "SELECT e FROM ErpUsuarioccu e WHERE e.uccChPedido = :uccChPedido")})
public class ErpUsuarioccu implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpUsuarioccuPK erpUsuarioccuPK;
    @Size(max = 1)
    @Column(name = "UCC_CH_PEDIDO")
    private String uccChPedido;

    public ErpUsuarioccu() {
    }

    public ErpUsuarioccu(ErpUsuarioccuPK erpUsuarioccuPK) {
        this.erpUsuarioccuPK = erpUsuarioccuPK;
    }

    public ErpUsuarioccu(String usuStCodigo, String ccuStCodigo) {
        this.erpUsuarioccuPK = new ErpUsuarioccuPK(usuStCodigo, ccuStCodigo);
    }

    public ErpUsuarioccuPK getErpUsuarioccuPK() {
        return erpUsuarioccuPK;
    }

    public void setErpUsuarioccuPK(ErpUsuarioccuPK erpUsuarioccuPK) {
        this.erpUsuarioccuPK = erpUsuarioccuPK;
    }

    public String getUccChPedido() {
        return uccChPedido;
    }

    public void setUccChPedido(String uccChPedido) {
        this.uccChPedido = uccChPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpUsuarioccuPK != null ? erpUsuarioccuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpUsuarioccu)) {
            return false;
        }
        ErpUsuarioccu other = (ErpUsuarioccu) object;
        if ((this.erpUsuarioccuPK == null && other.erpUsuarioccuPK != null) || (this.erpUsuarioccuPK != null && !this.erpUsuarioccuPK.equals(other.erpUsuarioccuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpUsuarioccu[ erpUsuarioccuPK=" + erpUsuarioccuPK + " ]";
    }
    
}
