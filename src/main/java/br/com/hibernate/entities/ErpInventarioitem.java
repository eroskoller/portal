/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_INVENTARIOITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpInventarioitem.findAll", query = "SELECT e FROM ErpInventarioitem e"),
    @NamedQuery(name = "ErpInventarioitem.findByInvInCodigo", query = "SELECT e FROM ErpInventarioitem e WHERE e.erpInventarioitemPK.invInCodigo = :invInCodigo"),
    @NamedQuery(name = "ErpInventarioitem.findByItmStCodigo", query = "SELECT e FROM ErpInventarioitem e WHERE e.erpInventarioitemPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpInventarioitem.findByInvInQtdetotal", query = "SELECT e FROM ErpInventarioitem e WHERE e.invInQtdetotal = :invInQtdetotal"),
    @NamedQuery(name = "ErpInventarioitem.findByItmStLote", query = "SELECT e FROM ErpInventarioitem e WHERE e.erpInventarioitemPK.itmStLote = :itmStLote"),
    @NamedQuery(name = "ErpInventarioitem.findByInvDtValidade", query = "SELECT e FROM ErpInventarioitem e WHERE e.invDtValidade = :invDtValidade"),
    @NamedQuery(name = "ErpInventarioitem.findByInvInEstoque1", query = "SELECT e FROM ErpInventarioitem e WHERE e.invInEstoque1 = :invInEstoque1"),
    @NamedQuery(name = "ErpInventarioitem.findByInvInEstoque2", query = "SELECT e FROM ErpInventarioitem e WHERE e.invInEstoque2 = :invInEstoque2"),
    @NamedQuery(name = "ErpInventarioitem.findByInvInSequencia", query = "SELECT e FROM ErpInventarioitem e WHERE e.invInSequencia = :invInSequencia"),
    @NamedQuery(name = "ErpInventarioitem.findByInvInEstoque3", query = "SELECT e FROM ErpInventarioitem e WHERE e.invInEstoque3 = :invInEstoque3"),
    @NamedQuery(name = "ErpInventarioitem.findByIprDtValidade", query = "SELECT e FROM ErpInventarioitem e WHERE e.iprDtValidade = :iprDtValidade"),
    @NamedQuery(name = "ErpInventarioitem.findByInvChIngressado", query = "SELECT e FROM ErpInventarioitem e WHERE e.invChIngressado = :invChIngressado")})
public class ErpInventarioitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpInventarioitemPK erpInventarioitemPK;
    @Column(name = "INV_IN_QTDETOTAL")
    private BigInteger invInQtdetotal;
    @Column(name = "INV_DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date invDtValidade;
    @Column(name = "INV_IN_ESTOQUE1")
    private BigInteger invInEstoque1;
    @Column(name = "INV_IN_ESTOQUE2")
    private BigInteger invInEstoque2;
    @Column(name = "INV_IN_SEQUENCIA")
    private BigInteger invInSequencia;
    @Column(name = "INV_IN_ESTOQUE3")
    private BigInteger invInEstoque3;
    @Column(name = "IPR_DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date iprDtValidade;
    @Size(max = 1)
    @Column(name = "INV_CH_INGRESSADO")
    private String invChIngressado;

    public ErpInventarioitem() {
    }

    public ErpInventarioitem(ErpInventarioitemPK erpInventarioitemPK) {
        this.erpInventarioitemPK = erpInventarioitemPK;
    }

    public ErpInventarioitem(BigInteger invInCodigo, String itmStCodigo, String itmStLote) {
        this.erpInventarioitemPK = new ErpInventarioitemPK(invInCodigo, itmStCodigo, itmStLote);
    }

    public ErpInventarioitemPK getErpInventarioitemPK() {
        return erpInventarioitemPK;
    }

    public void setErpInventarioitemPK(ErpInventarioitemPK erpInventarioitemPK) {
        this.erpInventarioitemPK = erpInventarioitemPK;
    }

    public BigInteger getInvInQtdetotal() {
        return invInQtdetotal;
    }

    public void setInvInQtdetotal(BigInteger invInQtdetotal) {
        this.invInQtdetotal = invInQtdetotal;
    }

    public Date getInvDtValidade() {
        return invDtValidade;
    }

    public void setInvDtValidade(Date invDtValidade) {
        this.invDtValidade = invDtValidade;
    }

    public BigInteger getInvInEstoque1() {
        return invInEstoque1;
    }

    public void setInvInEstoque1(BigInteger invInEstoque1) {
        this.invInEstoque1 = invInEstoque1;
    }

    public BigInteger getInvInEstoque2() {
        return invInEstoque2;
    }

    public void setInvInEstoque2(BigInteger invInEstoque2) {
        this.invInEstoque2 = invInEstoque2;
    }

    public BigInteger getInvInSequencia() {
        return invInSequencia;
    }

    public void setInvInSequencia(BigInteger invInSequencia) {
        this.invInSequencia = invInSequencia;
    }

    public BigInteger getInvInEstoque3() {
        return invInEstoque3;
    }

    public void setInvInEstoque3(BigInteger invInEstoque3) {
        this.invInEstoque3 = invInEstoque3;
    }

    public Date getIprDtValidade() {
        return iprDtValidade;
    }

    public void setIprDtValidade(Date iprDtValidade) {
        this.iprDtValidade = iprDtValidade;
    }

    public String getInvChIngressado() {
        return invChIngressado;
    }

    public void setInvChIngressado(String invChIngressado) {
        this.invChIngressado = invChIngressado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpInventarioitemPK != null ? erpInventarioitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpInventarioitem)) {
            return false;
        }
        ErpInventarioitem other = (ErpInventarioitem) object;
        if ((this.erpInventarioitemPK == null && other.erpInventarioitemPK != null) || (this.erpInventarioitemPK != null && !this.erpInventarioitemPK.equals(other.erpInventarioitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpInventarioitem[ erpInventarioitemPK=" + erpInventarioitemPK + " ]";
    }
    
}
