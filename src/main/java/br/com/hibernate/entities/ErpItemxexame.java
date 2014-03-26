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
@Table(name = "ERP_ITEMXEXAME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpItemxexame.findAll", query = "SELECT e FROM ErpItemxexame e"),
    @NamedQuery(name = "ErpItemxexame.findByItmStCodigo", query = "SELECT e FROM ErpItemxexame e WHERE e.erpItemxexamePK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpItemxexame.findByExaStCodigo", query = "SELECT e FROM ErpItemxexame e WHERE e.erpItemxexamePK.exaStCodigo = :exaStCodigo"),
    @NamedQuery(name = "ErpItemxexame.findByIexInQtdetestes", query = "SELECT e FROM ErpItemxexame e WHERE e.iexInQtdetestes = :iexInQtdetestes")})
public class ErpItemxexame implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpItemxexamePK erpItemxexamePK;
    @Column(name = "IEX_IN_QTDETESTES")
    private BigInteger iexInQtdetestes;

    public ErpItemxexame() {
    }

    public ErpItemxexame(ErpItemxexamePK erpItemxexamePK) {
        this.erpItemxexamePK = erpItemxexamePK;
    }

    public ErpItemxexame(String itmStCodigo, String exaStCodigo) {
        this.erpItemxexamePK = new ErpItemxexamePK(itmStCodigo, exaStCodigo);
    }

    public ErpItemxexamePK getErpItemxexamePK() {
        return erpItemxexamePK;
    }

    public void setErpItemxexamePK(ErpItemxexamePK erpItemxexamePK) {
        this.erpItemxexamePK = erpItemxexamePK;
    }

    public BigInteger getIexInQtdetestes() {
        return iexInQtdetestes;
    }

    public void setIexInQtdetestes(BigInteger iexInQtdetestes) {
        this.iexInQtdetestes = iexInQtdetestes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpItemxexamePK != null ? erpItemxexamePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemxexame)) {
            return false;
        }
        ErpItemxexame other = (ErpItemxexame) object;
        if ((this.erpItemxexamePK == null && other.erpItemxexamePK != null) || (this.erpItemxexamePK != null && !this.erpItemxexamePK.equals(other.erpItemxexamePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemxexame[ erpItemxexamePK=" + erpItemxexamePK + " ]";
    }
    
}
