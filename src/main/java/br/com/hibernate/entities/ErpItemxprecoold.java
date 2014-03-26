/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_ITEMXPRECOOLD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpItemxprecoold.findAll", query = "SELECT e FROM ErpItemxprecoold e"),
    @NamedQuery(name = "ErpItemxprecoold.findByItmStCodigo", query = "SELECT e FROM ErpItemxprecoold e WHERE e.erpItemxprecooldPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpItemxprecoold.findByFdoStCodigo", query = "SELECT e FROM ErpItemxprecoold e WHERE e.erpItemxprecooldPK.fdoStCodigo = :fdoStCodigo"),
    @NamedQuery(name = "ErpItemxprecoold.findByIprDtData", query = "SELECT e FROM ErpItemxprecoold e WHERE e.erpItemxprecooldPK.iprDtData = :iprDtData"),
    @NamedQuery(name = "ErpItemxprecoold.findByIprChAtivo", query = "SELECT e FROM ErpItemxprecoold e WHERE e.iprChAtivo = :iprChAtivo"),
    @NamedQuery(name = "ErpItemxprecoold.findByIprStPreco", query = "SELECT e FROM ErpItemxprecoold e WHERE e.iprStPreco = :iprStPreco"),
    @NamedQuery(name = "ErpItemxprecoold.findByIprFlPreco", query = "SELECT e FROM ErpItemxprecoold e WHERE e.iprFlPreco = :iprFlPreco"),
    @NamedQuery(name = "ErpItemxprecoold.findByIprDtValidade", query = "SELECT e FROM ErpItemxprecoold e WHERE e.iprDtValidade = :iprDtValidade")})
public class ErpItemxprecoold implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpItemxprecooldPK erpItemxprecooldPK;
    @Size(max = 1)
    @Column(name = "IPR_CH_ATIVO")
    private String iprChAtivo;
    @Size(max = 20)
    @Column(name = "IPR_ST_PRECO")
    private String iprStPreco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IPR_FL_PRECO")
    private BigDecimal iprFlPreco;
    @Column(name = "IPR_DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date iprDtValidade;

    public ErpItemxprecoold() {
    }

    public ErpItemxprecoold(ErpItemxprecooldPK erpItemxprecooldPK) {
        this.erpItemxprecooldPK = erpItemxprecooldPK;
    }

    public ErpItemxprecoold(String itmStCodigo, String fdoStCodigo, Date iprDtData) {
        this.erpItemxprecooldPK = new ErpItemxprecooldPK(itmStCodigo, fdoStCodigo, iprDtData);
    }

    public ErpItemxprecooldPK getErpItemxprecooldPK() {
        return erpItemxprecooldPK;
    }

    public void setErpItemxprecooldPK(ErpItemxprecooldPK erpItemxprecooldPK) {
        this.erpItemxprecooldPK = erpItemxprecooldPK;
    }

    public String getIprChAtivo() {
        return iprChAtivo;
    }

    public void setIprChAtivo(String iprChAtivo) {
        this.iprChAtivo = iprChAtivo;
    }

    public String getIprStPreco() {
        return iprStPreco;
    }

    public void setIprStPreco(String iprStPreco) {
        this.iprStPreco = iprStPreco;
    }

    public BigDecimal getIprFlPreco() {
        return iprFlPreco;
    }

    public void setIprFlPreco(BigDecimal iprFlPreco) {
        this.iprFlPreco = iprFlPreco;
    }

    public Date getIprDtValidade() {
        return iprDtValidade;
    }

    public void setIprDtValidade(Date iprDtValidade) {
        this.iprDtValidade = iprDtValidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpItemxprecooldPK != null ? erpItemxprecooldPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemxprecoold)) {
            return false;
        }
        ErpItemxprecoold other = (ErpItemxprecoold) object;
        if ((this.erpItemxprecooldPK == null && other.erpItemxprecooldPK != null) || (this.erpItemxprecooldPK != null && !this.erpItemxprecooldPK.equals(other.erpItemxprecooldPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemxprecoold[ erpItemxprecooldPK=" + erpItemxprecooldPK + " ]";
    }
    
}
