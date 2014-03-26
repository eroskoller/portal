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
@Table(name = "ERP_PEDPREDEFINIDOXITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpPedpredefinidoxitem.findAll", query = "SELECT e FROM ErpPedpredefinidoxitem e"),
    @NamedQuery(name = "ErpPedpredefinidoxitem.findByPpdStCodigo", query = "SELECT e FROM ErpPedpredefinidoxitem e WHERE e.erpPedpredefinidoxitemPK.ppdStCodigo = :ppdStCodigo"),
    @NamedQuery(name = "ErpPedpredefinidoxitem.findByItmStCodigo", query = "SELECT e FROM ErpPedpredefinidoxitem e WHERE e.erpPedpredefinidoxitemPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpPedpredefinidoxitem.findByPpiInQtde", query = "SELECT e FROM ErpPedpredefinidoxitem e WHERE e.ppiInQtde = :ppiInQtde")})
public class ErpPedpredefinidoxitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpPedpredefinidoxitemPK erpPedpredefinidoxitemPK;
    @Column(name = "PPI_IN_QTDE")
    private BigInteger ppiInQtde;

    public ErpPedpredefinidoxitem() {
    }

    public ErpPedpredefinidoxitem(ErpPedpredefinidoxitemPK erpPedpredefinidoxitemPK) {
        this.erpPedpredefinidoxitemPK = erpPedpredefinidoxitemPK;
    }

    public ErpPedpredefinidoxitem(String ppdStCodigo, String itmStCodigo) {
        this.erpPedpredefinidoxitemPK = new ErpPedpredefinidoxitemPK(ppdStCodigo, itmStCodigo);
    }

    public ErpPedpredefinidoxitemPK getErpPedpredefinidoxitemPK() {
        return erpPedpredefinidoxitemPK;
    }

    public void setErpPedpredefinidoxitemPK(ErpPedpredefinidoxitemPK erpPedpredefinidoxitemPK) {
        this.erpPedpredefinidoxitemPK = erpPedpredefinidoxitemPK;
    }

    public BigInteger getPpiInQtde() {
        return ppiInQtde;
    }

    public void setPpiInQtde(BigInteger ppiInQtde) {
        this.ppiInQtde = ppiInQtde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpPedpredefinidoxitemPK != null ? erpPedpredefinidoxitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedpredefinidoxitem)) {
            return false;
        }
        ErpPedpredefinidoxitem other = (ErpPedpredefinidoxitem) object;
        if ((this.erpPedpredefinidoxitemPK == null && other.erpPedpredefinidoxitemPK != null) || (this.erpPedpredefinidoxitemPK != null && !this.erpPedpredefinidoxitemPK.equals(other.erpPedpredefinidoxitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedpredefinidoxitem[ erpPedpredefinidoxitemPK=" + erpPedpredefinidoxitemPK + " ]";
    }
    
}
