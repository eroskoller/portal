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
@Table(name = "ERP_ITEMDEPARA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpItemdepara.findAll", query = "SELECT e FROM ErpItemdepara e"),
    @NamedQuery(name = "ErpItemdepara.findByMarStCodigo", query = "SELECT e FROM ErpItemdepara e WHERE e.erpItemdeparaPK.marStCodigo = :marStCodigo"),
    @NamedQuery(name = "ErpItemdepara.findByItmStCodigo", query = "SELECT e FROM ErpItemdepara e WHERE e.erpItemdeparaPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpItemdepara.findByIdpStCodigo", query = "SELECT e FROM ErpItemdepara e WHERE e.erpItemdeparaPK.idpStCodigo = :idpStCodigo")})
public class ErpItemdepara implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpItemdeparaPK erpItemdeparaPK;

    public ErpItemdepara() {
    }

    public ErpItemdepara(ErpItemdeparaPK erpItemdeparaPK) {
        this.erpItemdeparaPK = erpItemdeparaPK;
    }

    public ErpItemdepara(String marStCodigo, String itmStCodigo, String idpStCodigo) {
        this.erpItemdeparaPK = new ErpItemdeparaPK(marStCodigo, itmStCodigo, idpStCodigo);
    }

    public ErpItemdeparaPK getErpItemdeparaPK() {
        return erpItemdeparaPK;
    }

    public void setErpItemdeparaPK(ErpItemdeparaPK erpItemdeparaPK) {
        this.erpItemdeparaPK = erpItemdeparaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpItemdeparaPK != null ? erpItemdeparaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemdepara)) {
            return false;
        }
        ErpItemdepara other = (ErpItemdepara) object;
        if ((this.erpItemdeparaPK == null && other.erpItemdeparaPK != null) || (this.erpItemdeparaPK != null && !this.erpItemdeparaPK.equals(other.erpItemdeparaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemdepara[ erpItemdeparaPK=" + erpItemdeparaPK + " ]";
    }
    
}
