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
@Table(name = "ERP_CCUSTOXPRECO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpCcustoxpreco.findAll", query = "SELECT e FROM ErpCcustoxpreco e"),
    @NamedQuery(name = "ErpCcustoxpreco.findByCcuStCodigo", query = "SELECT e FROM ErpCcustoxpreco e WHERE e.erpCcustoxprecoPK.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpCcustoxpreco.findByCprDtData", query = "SELECT e FROM ErpCcustoxpreco e WHERE e.erpCcustoxprecoPK.cprDtData = :cprDtData"),
    @NamedQuery(name = "ErpCcustoxpreco.findByCprChAtivo", query = "SELECT e FROM ErpCcustoxpreco e WHERE e.cprChAtivo = :cprChAtivo"),
    @NamedQuery(name = "ErpCcustoxpreco.findByCprFlValor", query = "SELECT e FROM ErpCcustoxpreco e WHERE e.cprFlValor = :cprFlValor")})
public class ErpCcustoxpreco implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpCcustoxprecoPK erpCcustoxprecoPK;
    @Size(max = 1)
    @Column(name = "CPR_CH_ATIVO")
    private String cprChAtivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CPR_FL_VALOR")
    private BigDecimal cprFlValor;

    public ErpCcustoxpreco() {
    }

    public ErpCcustoxpreco(ErpCcustoxprecoPK erpCcustoxprecoPK) {
        this.erpCcustoxprecoPK = erpCcustoxprecoPK;
    }

    public ErpCcustoxpreco(String ccuStCodigo, Date cprDtData) {
        this.erpCcustoxprecoPK = new ErpCcustoxprecoPK(ccuStCodigo, cprDtData);
    }

    public ErpCcustoxprecoPK getErpCcustoxprecoPK() {
        return erpCcustoxprecoPK;
    }

    public void setErpCcustoxprecoPK(ErpCcustoxprecoPK erpCcustoxprecoPK) {
        this.erpCcustoxprecoPK = erpCcustoxprecoPK;
    }

    public String getCprChAtivo() {
        return cprChAtivo;
    }

    public void setCprChAtivo(String cprChAtivo) {
        this.cprChAtivo = cprChAtivo;
    }

    public BigDecimal getCprFlValor() {
        return cprFlValor;
    }

    public void setCprFlValor(BigDecimal cprFlValor) {
        this.cprFlValor = cprFlValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpCcustoxprecoPK != null ? erpCcustoxprecoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCcustoxpreco)) {
            return false;
        }
        ErpCcustoxpreco other = (ErpCcustoxpreco) object;
        if ((this.erpCcustoxprecoPK == null && other.erpCcustoxprecoPK != null) || (this.erpCcustoxprecoPK != null && !this.erpCcustoxprecoPK.equals(other.erpCcustoxprecoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCcustoxpreco[ erpCcustoxprecoPK=" + erpCcustoxprecoPK + " ]";
    }
    
}
