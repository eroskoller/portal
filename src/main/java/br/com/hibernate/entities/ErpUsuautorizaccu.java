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
@Table(name = "ERP_USUAUTORIZACCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpUsuautorizaccu.findAll", query = "SELECT e FROM ErpUsuautorizaccu e"),
    @NamedQuery(name = "ErpUsuautorizaccu.findByUsuStCodigo", query = "SELECT e FROM ErpUsuautorizaccu e WHERE e.erpUsuautorizaccuPK.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpUsuautorizaccu.findByCcuStCodigo", query = "SELECT e FROM ErpUsuautorizaccu e WHERE e.erpUsuautorizaccuPK.ccuStCodigo = :ccuStCodigo")})
public class ErpUsuautorizaccu implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpUsuautorizaccuPK erpUsuautorizaccuPK;

    public ErpUsuautorizaccu() {
    }

    public ErpUsuautorizaccu(ErpUsuautorizaccuPK erpUsuautorizaccuPK) {
        this.erpUsuautorizaccuPK = erpUsuautorizaccuPK;
    }

    public ErpUsuautorizaccu(String usuStCodigo, String ccuStCodigo) {
        this.erpUsuautorizaccuPK = new ErpUsuautorizaccuPK(usuStCodigo, ccuStCodigo);
    }

    public ErpUsuautorizaccuPK getErpUsuautorizaccuPK() {
        return erpUsuautorizaccuPK;
    }

    public void setErpUsuautorizaccuPK(ErpUsuautorizaccuPK erpUsuautorizaccuPK) {
        this.erpUsuautorizaccuPK = erpUsuautorizaccuPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpUsuautorizaccuPK != null ? erpUsuautorizaccuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpUsuautorizaccu)) {
            return false;
        }
        ErpUsuautorizaccu other = (ErpUsuautorizaccu) object;
        if ((this.erpUsuautorizaccuPK == null && other.erpUsuautorizaccuPK != null) || (this.erpUsuautorizaccuPK != null && !this.erpUsuautorizaccuPK.equals(other.erpUsuautorizaccuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpUsuautorizaccu[ erpUsuautorizaccuPK=" + erpUsuautorizaccuPK + " ]";
    }
    
}
