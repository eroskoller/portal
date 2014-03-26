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
@Table(name = "ERP_HISTORICOPEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpHistoricopedido.findAll", query = "SELECT e FROM ErpHistoricopedido e"),
    @NamedQuery(name = "ErpHistoricopedido.findByHipInCodigo", query = "SELECT e FROM ErpHistoricopedido e WHERE e.hipInCodigo = :hipInCodigo"),
    @NamedQuery(name = "ErpHistoricopedido.findByPedInCodigo", query = "SELECT e FROM ErpHistoricopedido e WHERE e.pedInCodigo = :pedInCodigo"),
    @NamedQuery(name = "ErpHistoricopedido.findByItmStCodigo", query = "SELECT e FROM ErpHistoricopedido e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpHistoricopedido.findByPedStStatus", query = "SELECT e FROM ErpHistoricopedido e WHERE e.pedStStatus = :pedStStatus"),
    @NamedQuery(name = "ErpHistoricopedido.findByUsuStCodigo", query = "SELECT e FROM ErpHistoricopedido e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpHistoricopedido.findByHipDtData", query = "SELECT e FROM ErpHistoricopedido e WHERE e.hipDtData = :hipDtData"),
    @NamedQuery(name = "ErpHistoricopedido.findByHipClAcao", query = "SELECT e FROM ErpHistoricopedido e WHERE e.hipClAcao = :hipClAcao"),
    @NamedQuery(name = "ErpHistoricopedido.findByAcsStCodigo", query = "SELECT e FROM ErpHistoricopedido e WHERE e.acsStCodigo = :acsStCodigo"),
    @NamedQuery(name = "ErpHistoricopedido.findByHipInQtde", query = "SELECT e FROM ErpHistoricopedido e WHERE e.hipInQtde = :hipInQtde")})
public class ErpHistoricopedido implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIP_IN_CODIGO")
    private BigDecimal hipInCodigo;
    @Column(name = "PED_IN_CODIGO")
    private BigInteger pedInCodigo;
    @Size(max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Size(max = 2)
    @Column(name = "PED_ST_STATUS")
    private String pedStStatus;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name = "HIP_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date hipDtData;
    @Size(max = 4000)
    @Column(name = "HIP_CL_ACAO")
    private String hipClAcao;
    @Size(max = 6)
    @Column(name = "ACS_ST_CODIGO")
    private String acsStCodigo;
    @Column(name = "HIP_IN_QTDE")
    private BigInteger hipInQtde;

    public ErpHistoricopedido() {
    }

    public ErpHistoricopedido(BigDecimal hipInCodigo) {
        this.hipInCodigo = hipInCodigo;
    }

    public BigDecimal getHipInCodigo() {
        return hipInCodigo;
    }

    public void setHipInCodigo(BigDecimal hipInCodigo) {
        this.hipInCodigo = hipInCodigo;
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

    public String getPedStStatus() {
        return pedStStatus;
    }

    public void setPedStStatus(String pedStStatus) {
        this.pedStStatus = pedStStatus;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public Date getHipDtData() {
        return hipDtData;
    }

    public void setHipDtData(Date hipDtData) {
        this.hipDtData = hipDtData;
    }

    public String getHipClAcao() {
        return hipClAcao;
    }

    public void setHipClAcao(String hipClAcao) {
        this.hipClAcao = hipClAcao;
    }

    public String getAcsStCodigo() {
        return acsStCodigo;
    }

    public void setAcsStCodigo(String acsStCodigo) {
        this.acsStCodigo = acsStCodigo;
    }

    public BigInteger getHipInQtde() {
        return hipInQtde;
    }

    public void setHipInQtde(BigInteger hipInQtde) {
        this.hipInQtde = hipInQtde;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hipInCodigo != null ? hipInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpHistoricopedido)) {
            return false;
        }
        ErpHistoricopedido other = (ErpHistoricopedido) object;
        if ((this.hipInCodigo == null && other.hipInCodigo != null) || (this.hipInCodigo != null && !this.hipInCodigo.equals(other.hipInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpHistoricopedido[ hipInCodigo=" + hipInCodigo + " ]";
    }
    
}
