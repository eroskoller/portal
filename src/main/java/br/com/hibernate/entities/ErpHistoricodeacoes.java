/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ERP_HISTORICODEACOES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpHistoricodeacoes.findAll", query = "SELECT e FROM ErpHistoricodeacoes e"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByHacInCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.hacInCodigo = :hacInCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByMprStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.mprStCodigo = :mprStCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByUniStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.uniStCodigo = :uniStCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByCcuStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByRgiStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.rgiStCodigo = :rgiStCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByMarStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.marStCodigo = :marStCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByEstStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.estStCodigo = :estStCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByOriStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.oriStCodigo = :oriStCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByUsuStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByHacDtData", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.hacDtData = :hacDtData"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByAcsStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.acsStCodigo = :acsStCodigo"),
    @NamedQuery(name = "ErpHistoricodeacoes.findByItmStCodigo", query = "SELECT e FROM ErpHistoricodeacoes e WHERE e.itmStCodigo = :itmStCodigo")})
public class ErpHistoricodeacoes implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HAC_IN_CODIGO")
    private BigDecimal hacInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "MPR_ST_CODIGO")
    private String mprStCodigo;
    @Size(max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Size(max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;
    @Size(max = 3)
    @Column(name = "RGI_ST_CODIGO")
    private String rgiStCodigo;
    @Size(max = 3)
    @Column(name = "MAR_ST_CODIGO")
    private String marStCodigo;
    @Size(max = 3)
    @Column(name = "EST_ST_CODIGO")
    private String estStCodigo;
    @Size(max = 6)
    @Column(name = "ORI_ST_CODIGO")
    private String oriStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HAC_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date hacDtData;
    @Size(max = 6)
    @Column(name = "ACS_ST_CODIGO")
    private String acsStCodigo;
    @Size(max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;

    public ErpHistoricodeacoes() {
    }

    public ErpHistoricodeacoes(BigDecimal hacInCodigo) {
        this.hacInCodigo = hacInCodigo;
    }

    public ErpHistoricodeacoes(BigDecimal hacInCodigo, String mprStCodigo, String usuStCodigo, Date hacDtData) {
        this.hacInCodigo = hacInCodigo;
        this.mprStCodigo = mprStCodigo;
        this.usuStCodigo = usuStCodigo;
        this.hacDtData = hacDtData;
    }

    public BigDecimal getHacInCodigo() {
        return hacInCodigo;
    }

    public void setHacInCodigo(BigDecimal hacInCodigo) {
        this.hacInCodigo = hacInCodigo;
    }

    public String getMprStCodigo() {
        return mprStCodigo;
    }

    public void setMprStCodigo(String mprStCodigo) {
        this.mprStCodigo = mprStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    public String getRgiStCodigo() {
        return rgiStCodigo;
    }

    public void setRgiStCodigo(String rgiStCodigo) {
        this.rgiStCodigo = rgiStCodigo;
    }

    public String getMarStCodigo() {
        return marStCodigo;
    }

    public void setMarStCodigo(String marStCodigo) {
        this.marStCodigo = marStCodigo;
    }

    public String getEstStCodigo() {
        return estStCodigo;
    }

    public void setEstStCodigo(String estStCodigo) {
        this.estStCodigo = estStCodigo;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public Date getHacDtData() {
        return hacDtData;
    }

    public void setHacDtData(Date hacDtData) {
        this.hacDtData = hacDtData;
    }

    public String getAcsStCodigo() {
        return acsStCodigo;
    }

    public void setAcsStCodigo(String acsStCodigo) {
        this.acsStCodigo = acsStCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hacInCodigo != null ? hacInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpHistoricodeacoes)) {
            return false;
        }
        ErpHistoricodeacoes other = (ErpHistoricodeacoes) object;
        if ((this.hacInCodigo == null && other.hacInCodigo != null) || (this.hacInCodigo != null && !this.hacInCodigo.equals(other.hacInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpHistoricodeacoes[ hacInCodigo=" + hacInCodigo + " ]";
    }
    
}
