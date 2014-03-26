/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_ITEMXSALDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpItemxsaldo.findAll", query = "SELECT e FROM ErpItemxsaldo e"),
    @NamedQuery(name = "ErpItemxsaldo.findByItmStCodigo", query = "SELECT e FROM ErpItemxsaldo e WHERE e.erpItemxsaldoPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpItemxsaldo.findByAmzStCodigo", query = "SELECT e FROM ErpItemxsaldo e WHERE e.erpItemxsaldoPK.amzStCodigo = :amzStCodigo"),
    @NamedQuery(name = "ErpItemxsaldo.findByIsdDtData", query = "SELECT e FROM ErpItemxsaldo e WHERE e.erpItemxsaldoPK.isdDtData = :isdDtData"),
    @NamedQuery(name = "ErpItemxsaldo.findByIsdInSaldo", query = "SELECT e FROM ErpItemxsaldo e WHERE e.isdInSaldo = :isdInSaldo"),
    @NamedQuery(name = "ErpItemxsaldo.findByUsuStCodigo", query = "SELECT e FROM ErpItemxsaldo e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpItemxsaldo.findByIsdChAtivo", query = "SELECT e FROM ErpItemxsaldo e WHERE e.isdChAtivo = :isdChAtivo")})
public class ErpItemxsaldo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpItemxsaldoPK erpItemxsaldoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISD_IN_SALDO")
    private BigInteger isdInSaldo;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Size(max = 1)
    @Column(name = "ISD_CH_ATIVO")
    private String isdChAtivo;

    public ErpItemxsaldo() {
    }

    public ErpItemxsaldo(ErpItemxsaldoPK erpItemxsaldoPK) {
        this.erpItemxsaldoPK = erpItemxsaldoPK;
    }

    public ErpItemxsaldo(ErpItemxsaldoPK erpItemxsaldoPK, BigInteger isdInSaldo) {
        this.erpItemxsaldoPK = erpItemxsaldoPK;
        this.isdInSaldo = isdInSaldo;
    }

    public ErpItemxsaldo(String itmStCodigo, String amzStCodigo, Date isdDtData) {
        this.erpItemxsaldoPK = new ErpItemxsaldoPK(itmStCodigo, amzStCodigo, isdDtData);
    }

    public ErpItemxsaldoPK getErpItemxsaldoPK() {
        return erpItemxsaldoPK;
    }

    public void setErpItemxsaldoPK(ErpItemxsaldoPK erpItemxsaldoPK) {
        this.erpItemxsaldoPK = erpItemxsaldoPK;
    }

    public BigInteger getIsdInSaldo() {
        return isdInSaldo;
    }

    public void setIsdInSaldo(BigInteger isdInSaldo) {
        this.isdInSaldo = isdInSaldo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getIsdChAtivo() {
        return isdChAtivo;
    }

    public void setIsdChAtivo(String isdChAtivo) {
        this.isdChAtivo = isdChAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpItemxsaldoPK != null ? erpItemxsaldoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemxsaldo)) {
            return false;
        }
        ErpItemxsaldo other = (ErpItemxsaldo) object;
        if ((this.erpItemxsaldoPK == null && other.erpItemxsaldoPK != null) || (this.erpItemxsaldoPK != null && !this.erpItemxsaldoPK.equals(other.erpItemxsaldoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemxsaldo[ erpItemxsaldoPK=" + erpItemxsaldoPK + " ]";
    }
    
}
