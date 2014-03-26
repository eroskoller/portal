/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_USUAUTORIZACOMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpUsuautorizacompra.findAll", query = "SELECT e FROM ErpUsuautorizacompra e"),
    @NamedQuery(name = "ErpUsuautorizacompra.findByUsuStCodigo", query = "SELECT e FROM ErpUsuautorizacompra e WHERE e.erpUsuautorizacompraPK.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpUsuautorizacompra.findByCcuStCodigo", query = "SELECT e FROM ErpUsuautorizacompra e WHERE e.erpUsuautorizacompraPK.ccuStCodigo = :ccuStCodigo")})
public class ErpUsuautorizacompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpUsuautorizacompraPK erpUsuautorizacompraPK;

    public ErpUsuautorizacompra() {
    }

    public ErpUsuautorizacompra(ErpUsuautorizacompraPK erpUsuautorizacompraPK) {
        this.erpUsuautorizacompraPK = erpUsuautorizacompraPK;
    }

    public ErpUsuautorizacompra(String usuStCodigo, String ccuStCodigo) {
        this.erpUsuautorizacompraPK = new ErpUsuautorizacompraPK(usuStCodigo, ccuStCodigo);
    }

    public ErpUsuautorizacompraPK getErpUsuautorizacompraPK() {
        return erpUsuautorizacompraPK;
    }

    public void setErpUsuautorizacompraPK(ErpUsuautorizacompraPK erpUsuautorizacompraPK) {
        this.erpUsuautorizacompraPK = erpUsuautorizacompraPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpUsuautorizacompraPK != null ? erpUsuautorizacompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpUsuautorizacompra)) {
            return false;
        }
        ErpUsuautorizacompra other = (ErpUsuautorizacompra) object;
        if ((this.erpUsuautorizacompraPK == null && other.erpUsuautorizacompraPK != null) || (this.erpUsuautorizacompraPK != null && !this.erpUsuautorizacompraPK.equals(other.erpUsuautorizacompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpUsuautorizacompra[ erpUsuautorizacompraPK=" + erpUsuautorizacompraPK + " ]";
    }
    
}
