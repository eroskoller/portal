/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_ITEMXGRUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpItemxgrupo.findAll", query = "SELECT e FROM ErpItemxgrupo e"),
    @NamedQuery(name = "ErpItemxgrupo.findByGrpStCodigo", query = "SELECT e FROM ErpItemxgrupo e WHERE e.erpItemxgrupoPK.grpStCodigo = :grpStCodigo"),
    @NamedQuery(name = "ErpItemxgrupo.findByItmStCodigo", query = "SELECT e FROM ErpItemxgrupo e WHERE e.erpItemxgrupoPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpItemxgrupo.findByGrpInQtdepadrao", query = "SELECT e FROM ErpItemxgrupo e WHERE e.grpInQtdepadrao = :grpInQtdepadrao")})
public class ErpItemxgrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpItemxgrupoPK erpItemxgrupoPK;
    @Column(name = "GRP_IN_QTDEPADRAO")
    private BigInteger grpInQtdepadrao;

    public ErpItemxgrupo() {
    }

    public ErpItemxgrupo(ErpItemxgrupoPK erpItemxgrupoPK) {
        this.erpItemxgrupoPK = erpItemxgrupoPK;
    }

    public ErpItemxgrupo(String grpStCodigo, String itmStCodigo) {
        this.erpItemxgrupoPK = new ErpItemxgrupoPK(grpStCodigo, itmStCodigo);
    }

    public ErpItemxgrupoPK getErpItemxgrupoPK() {
        return erpItemxgrupoPK;
    }

    public void setErpItemxgrupoPK(ErpItemxgrupoPK erpItemxgrupoPK) {
        this.erpItemxgrupoPK = erpItemxgrupoPK;
    }

    public BigInteger getGrpInQtdepadrao() {
        return grpInQtdepadrao;
    }

    public void setGrpInQtdepadrao(BigInteger grpInQtdepadrao) {
        this.grpInQtdepadrao = grpInQtdepadrao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpItemxgrupoPK != null ? erpItemxgrupoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemxgrupo)) {
            return false;
        }
        ErpItemxgrupo other = (ErpItemxgrupo) object;
        if ((this.erpItemxgrupoPK == null && other.erpItemxgrupoPK != null) || (this.erpItemxgrupoPK != null && !this.erpItemxgrupoPK.equals(other.erpItemxgrupoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemxgrupo[ erpItemxgrupoPK=" + erpItemxgrupoPK + " ]";
    }
    
}
