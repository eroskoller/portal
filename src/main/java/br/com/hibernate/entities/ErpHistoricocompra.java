/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ERP_HISTORICOCOMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpHistoricocompra.findAll", query = "SELECT e FROM ErpHistoricocompra e"),
    @NamedQuery(name = "ErpHistoricocompra.findByHcpInCodigo", query = "SELECT e FROM ErpHistoricocompra e WHERE e.hcpInCodigo = :hcpInCodigo"),
    @NamedQuery(name = "ErpHistoricocompra.findByCprInCodigo", query = "SELECT e FROM ErpHistoricocompra e WHERE e.cprInCodigo = :cprInCodigo"),
    @NamedQuery(name = "ErpHistoricocompra.findByItmStCodigo", query = "SELECT e FROM ErpHistoricocompra e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpHistoricocompra.findByCprStStatus", query = "SELECT e FROM ErpHistoricocompra e WHERE e.cprStStatus = :cprStStatus"),
    @NamedQuery(name = "ErpHistoricocompra.findByUsuStCodigo", query = "SELECT e FROM ErpHistoricocompra e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpHistoricocompra.findByHcpDtData", query = "SELECT e FROM ErpHistoricocompra e WHERE e.hcpDtData = :hcpDtData"),
    @NamedQuery(name = "ErpHistoricocompra.findByAcsStCodigo", query = "SELECT e FROM ErpHistoricocompra e WHERE e.acsStCodigo = :acsStCodigo"),
    @NamedQuery(name = "ErpHistoricocompra.findByHcpInQtde", query = "SELECT e FROM ErpHistoricocompra e WHERE e.hcpInQtde = :hcpInQtde")})
public class ErpHistoricocompra implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HCP_IN_CODIGO")
    private BigDecimal hcpInCodigo;
    @Column(name = "CPR_IN_CODIGO")
    private BigInteger cprInCodigo;
    @Size(max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Size(max = 2)
    @Column(name = "CPR_ST_STATUS")
    private String cprStStatus;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name = "HCP_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date hcpDtData;
    @Size(max = 6)
    @Column(name = "ACS_ST_CODIGO")
    private String acsStCodigo;
    @Column(name = "HCP_IN_QTDE")
    private BigInteger hcpInQtde;

    public ErpHistoricocompra() {
    }

    public ErpHistoricocompra(BigDecimal hcpInCodigo) {
        this.hcpInCodigo = hcpInCodigo;
    }

    public BigDecimal getHcpInCodigo() {
        return hcpInCodigo;
    }

    public void setHcpInCodigo(BigDecimal hcpInCodigo) {
        this.hcpInCodigo = hcpInCodigo;
    }

    public BigInteger getCprInCodigo() {
        return cprInCodigo;
    }

    public void setCprInCodigo(BigInteger cprInCodigo) {
        this.cprInCodigo = cprInCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getCprStStatus() {
        return cprStStatus;
    }

    public void setCprStStatus(String cprStStatus) {
        this.cprStStatus = cprStStatus;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public Date getHcpDtData() {
        return hcpDtData;
    }

    public void setHcpDtData(Date hcpDtData) {
        this.hcpDtData = hcpDtData;
    }

    public String getAcsStCodigo() {
        return acsStCodigo;
    }

    public void setAcsStCodigo(String acsStCodigo) {
        this.acsStCodigo = acsStCodigo;
    }

    public BigInteger getHcpInQtde() {
        return hcpInQtde;
    }

    public void setHcpInQtde(BigInteger hcpInQtde) {
        this.hcpInQtde = hcpInQtde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hcpInCodigo != null ? hcpInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpHistoricocompra)) {
            return false;
        }
        ErpHistoricocompra other = (ErpHistoricocompra) object;
        if ((this.hcpInCodigo == null && other.hcpInCodigo != null) || (this.hcpInCodigo != null && !this.hcpInCodigo.equals(other.hcpInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpHistoricocompra[ hcpInCodigo=" + hcpInCodigo + " ]";
    }
    
}
