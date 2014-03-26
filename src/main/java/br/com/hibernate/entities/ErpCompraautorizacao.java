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
@Table(name = "ERP_COMPRAAUTORIZACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpCompraautorizacao.findAll", query = "SELECT e FROM ErpCompraautorizacao e"),
    @NamedQuery(name = "ErpCompraautorizacao.findByCprInCodigo", query = "SELECT e FROM ErpCompraautorizacao e WHERE e.erpCompraautorizacaoPK.cprInCodigo = :cprInCodigo"),
    @NamedQuery(name = "ErpCompraautorizacao.findByUsuStCodigo", query = "SELECT e FROM ErpCompraautorizacao e WHERE e.erpCompraautorizacaoPK.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpCompraautorizacao.findByCpaDtData", query = "SELECT e FROM ErpCompraautorizacao e WHERE e.cpaDtData = :cpaDtData"),
    @NamedQuery(name = "ErpCompraautorizacao.findByCpaChAutoriza", query = "SELECT e FROM ErpCompraautorizacao e WHERE e.cpaChAutoriza = :cpaChAutoriza")})
public class ErpCompraautorizacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpCompraautorizacaoPK erpCompraautorizacaoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPA_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date cpaDtData;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CPA_CH_AUTORIZA")
    private String cpaChAutoriza;

    public ErpCompraautorizacao() {
    }

    public ErpCompraautorizacao(ErpCompraautorizacaoPK erpCompraautorizacaoPK) {
        this.erpCompraautorizacaoPK = erpCompraautorizacaoPK;
    }

    public ErpCompraautorizacao(ErpCompraautorizacaoPK erpCompraautorizacaoPK, Date cpaDtData, String cpaChAutoriza) {
        this.erpCompraautorizacaoPK = erpCompraautorizacaoPK;
        this.cpaDtData = cpaDtData;
        this.cpaChAutoriza = cpaChAutoriza;
    }

    public ErpCompraautorizacao(BigInteger cprInCodigo, String usuStCodigo) {
        this.erpCompraautorizacaoPK = new ErpCompraautorizacaoPK(cprInCodigo, usuStCodigo);
    }

    public ErpCompraautorizacaoPK getErpCompraautorizacaoPK() {
        return erpCompraautorizacaoPK;
    }

    public void setErpCompraautorizacaoPK(ErpCompraautorizacaoPK erpCompraautorizacaoPK) {
        this.erpCompraautorizacaoPK = erpCompraautorizacaoPK;
    }

    public Date getCpaDtData() {
        return cpaDtData;
    }

    public void setCpaDtData(Date cpaDtData) {
        this.cpaDtData = cpaDtData;
    }

    public String getCpaChAutoriza() {
        return cpaChAutoriza;
    }

    public void setCpaChAutoriza(String cpaChAutoriza) {
        this.cpaChAutoriza = cpaChAutoriza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpCompraautorizacaoPK != null ? erpCompraautorizacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCompraautorizacao)) {
            return false;
        }
        ErpCompraautorizacao other = (ErpCompraautorizacao) object;
        if ((this.erpCompraautorizacaoPK == null && other.erpCompraautorizacaoPK != null) || (this.erpCompraautorizacaoPK != null && !this.erpCompraautorizacaoPK.equals(other.erpCompraautorizacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCompraautorizacao[ erpCompraautorizacaoPK=" + erpCompraautorizacaoPK + " ]";
    }
    
}
