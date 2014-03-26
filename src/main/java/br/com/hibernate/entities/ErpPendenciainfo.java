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
@Table(name = "ERP_PENDENCIAINFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpPendenciainfo.findAll", query = "SELECT e FROM ErpPendenciainfo e"),
    @NamedQuery(name = "ErpPendenciainfo.findByPfoInCodigo", query = "SELECT e FROM ErpPendenciainfo e WHERE e.pfoInCodigo = :pfoInCodigo"),
    @NamedQuery(name = "ErpPendenciainfo.findByPedInCodigo", query = "SELECT e FROM ErpPendenciainfo e WHERE e.pedInCodigo = :pedInCodigo"),
    @NamedQuery(name = "ErpPendenciainfo.findByItmStCodigo", query = "SELECT e FROM ErpPendenciainfo e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpPendenciainfo.findByUsuStCodigo", query = "SELECT e FROM ErpPendenciainfo e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpPendenciainfo.findByPfoDtData", query = "SELECT e FROM ErpPendenciainfo e WHERE e.pfoDtData = :pfoDtData"),
    @NamedQuery(name = "ErpPendenciainfo.findByPfoDtArmazemprev", query = "SELECT e FROM ErpPendenciainfo e WHERE e.pfoDtArmazemprev = :pfoDtArmazemprev"),
    @NamedQuery(name = "ErpPendenciainfo.findByPfoDtClienteprev", query = "SELECT e FROM ErpPendenciainfo e WHERE e.pfoDtClienteprev = :pfoDtClienteprev"),
    @NamedQuery(name = "ErpPendenciainfo.findByPfoStMensagem", query = "SELECT e FROM ErpPendenciainfo e WHERE e.pfoStMensagem = :pfoStMensagem")})
public class ErpPendenciainfo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PFO_IN_CODIGO")
    private BigDecimal pfoInCodigo;
    @Column(name = "PED_IN_CODIGO")
    private BigInteger pedInCodigo;
    @Size(max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name = "PFO_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date pfoDtData;
    @Column(name = "PFO_DT_ARMAZEMPREV")
    @Temporal(TemporalType.DATE)
    private Date pfoDtArmazemprev;
    @Column(name = "PFO_DT_CLIENTEPREV")
    @Temporal(TemporalType.DATE)
    private Date pfoDtClienteprev;
    @Size(max = 4000)
    @Column(name = "PFO_ST_MENSAGEM")
    private String pfoStMensagem;

    public ErpPendenciainfo() {
    }

    public ErpPendenciainfo(BigDecimal pfoInCodigo) {
        this.pfoInCodigo = pfoInCodigo;
    }

    public BigDecimal getPfoInCodigo() {
        return pfoInCodigo;
    }

    public void setPfoInCodigo(BigDecimal pfoInCodigo) {
        this.pfoInCodigo = pfoInCodigo;
    }

    public BigInteger getPedInCodigo() {
        return pedInCodigo;
    }

    public void setPedInCodigo(BigInteger pedInCodigo) {
        this.pedInCodigo = pedInCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public Date getPfoDtData() {
        return pfoDtData;
    }

    public void setPfoDtData(Date pfoDtData) {
        this.pfoDtData = pfoDtData;
    }

    public Date getPfoDtArmazemprev() {
        return pfoDtArmazemprev;
    }

    public void setPfoDtArmazemprev(Date pfoDtArmazemprev) {
        this.pfoDtArmazemprev = pfoDtArmazemprev;
    }

    public Date getPfoDtClienteprev() {
        return pfoDtClienteprev;
    }

    public void setPfoDtClienteprev(Date pfoDtClienteprev) {
        this.pfoDtClienteprev = pfoDtClienteprev;
    }

    public String getPfoStMensagem() {
        return pfoStMensagem;
    }

    public void setPfoStMensagem(String pfoStMensagem) {
        this.pfoStMensagem = pfoStMensagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pfoInCodigo != null ? pfoInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPendenciainfo)) {
            return false;
        }
        ErpPendenciainfo other = (ErpPendenciainfo) object;
        if ((this.pfoInCodigo == null && other.pfoInCodigo != null) || (this.pfoInCodigo != null && !this.pfoInCodigo.equals(other.pfoInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPendenciainfo[ pfoInCodigo=" + pfoInCodigo + " ]";
    }
    
}
