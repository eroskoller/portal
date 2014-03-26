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
@Table(name = "ERP_HISTORICOTRANSFERENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpHistoricotransferencia.findAll", query = "SELECT e FROM ErpHistoricotransferencia e"),
    @NamedQuery(name = "ErpHistoricotransferencia.findByHitInCodigo", query = "SELECT e FROM ErpHistoricotransferencia e WHERE e.hitInCodigo = :hitInCodigo"),
    @NamedQuery(name = "ErpHistoricotransferencia.findByTrfInCodigo", query = "SELECT e FROM ErpHistoricotransferencia e WHERE e.trfInCodigo = :trfInCodigo"),
    @NamedQuery(name = "ErpHistoricotransferencia.findByItmStCodigo", query = "SELECT e FROM ErpHistoricotransferencia e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpHistoricotransferencia.findByTrfStStatus", query = "SELECT e FROM ErpHistoricotransferencia e WHERE e.trfStStatus = :trfStStatus"),
    @NamedQuery(name = "ErpHistoricotransferencia.findByUsuStCodigo", query = "SELECT e FROM ErpHistoricotransferencia e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpHistoricotransferencia.findByHitDtData", query = "SELECT e FROM ErpHistoricotransferencia e WHERE e.hitDtData = :hitDtData"),
    @NamedQuery(name = "ErpHistoricotransferencia.findByAcsStCodigo", query = "SELECT e FROM ErpHistoricotransferencia e WHERE e.acsStCodigo = :acsStCodigo")})
public class ErpHistoricotransferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIT_IN_CODIGO")
    private BigDecimal hitInCodigo;
    @Column(name = "TRF_IN_CODIGO")
    private BigInteger trfInCodigo;
    @Size(max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Size(max = 2)
    @Column(name = "TRF_ST_STATUS")
    private String trfStStatus;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name = "HIT_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date hitDtData;
    @Size(max = 6)
    @Column(name = "ACS_ST_CODIGO")
    private String acsStCodigo;

    public ErpHistoricotransferencia() {
    }

    public ErpHistoricotransferencia(BigDecimal hitInCodigo) {
        this.hitInCodigo = hitInCodigo;
    }

    public BigDecimal getHitInCodigo() {
        return hitInCodigo;
    }

    public void setHitInCodigo(BigDecimal hitInCodigo) {
        this.hitInCodigo = hitInCodigo;
    }

    public BigInteger getTrfInCodigo() {
        return trfInCodigo;
    }

    public void setTrfInCodigo(BigInteger trfInCodigo) {
        this.trfInCodigo = trfInCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getTrfStStatus() {
        return trfStStatus;
    }

    public void setTrfStStatus(String trfStStatus) {
        this.trfStStatus = trfStStatus;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public Date getHitDtData() {
        return hitDtData;
    }

    public void setHitDtData(Date hitDtData) {
        this.hitDtData = hitDtData;
    }

    public String getAcsStCodigo() {
        return acsStCodigo;
    }

    public void setAcsStCodigo(String acsStCodigo) {
        this.acsStCodigo = acsStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hitInCodigo != null ? hitInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpHistoricotransferencia)) {
            return false;
        }
        ErpHistoricotransferencia other = (ErpHistoricotransferencia) object;
        if ((this.hitInCodigo == null && other.hitInCodigo != null) || (this.hitInCodigo != null && !this.hitInCodigo.equals(other.hitInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpHistoricotransferencia[ hitInCodigo=" + hitInCodigo + " ]";
    }
    
}
