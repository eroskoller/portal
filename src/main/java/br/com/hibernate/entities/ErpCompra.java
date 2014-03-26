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
@Table(name = "ERP_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpCompra.findAll", query = "SELECT e FROM ErpCompra e"),
    @NamedQuery(name = "ErpCompra.findByCprInCodigo", query = "SELECT e FROM ErpCompra e WHERE e.cprInCodigo = :cprInCodigo"),
    @NamedQuery(name = "ErpCompra.findByCprStStatus", query = "SELECT e FROM ErpCompra e WHERE e.cprStStatus = :cprStStatus"),
    @NamedQuery(name = "ErpCompra.findByUsuStCodigo", query = "SELECT e FROM ErpCompra e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpCompra.findByMarStCodigo", query = "SELECT e FROM ErpCompra e WHERE e.marStCodigo = :marStCodigo"),
    @NamedQuery(name = "ErpCompra.findByMarStCodigodes", query = "SELECT e FROM ErpCompra e WHERE e.marStCodigodes = :marStCodigodes"),
    @NamedQuery(name = "ErpCompra.findByUniStCodigo", query = "SELECT e FROM ErpCompra e WHERE e.uniStCodigo = :uniStCodigo"),
    @NamedQuery(name = "ErpCompra.findByUniStCodigodes", query = "SELECT e FROM ErpCompra e WHERE e.uniStCodigodes = :uniStCodigodes"),
    @NamedQuery(name = "ErpCompra.findByCcuStCodigo", query = "SELECT e FROM ErpCompra e WHERE e.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpCompra.findByCcuStCodigodes", query = "SELECT e FROM ErpCompra e WHERE e.ccuStCodigodes = :ccuStCodigodes"),
    @NamedQuery(name = "ErpCompra.findByOriStCodigo", query = "SELECT e FROM ErpCompra e WHERE e.oriStCodigo = :oriStCodigo"),
    @NamedQuery(name = "ErpCompra.findByOriStCodigodes", query = "SELECT e FROM ErpCompra e WHERE e.oriStCodigodes = :oriStCodigodes"),
    @NamedQuery(name = "ErpCompra.findByCprDtCadastro", query = "SELECT e FROM ErpCompra e WHERE e.cprDtCadastro = :cprDtCadastro"),
    @NamedQuery(name = "ErpCompra.findByCprDtEntrega", query = "SELECT e FROM ErpCompra e WHERE e.cprDtEntrega = :cprDtEntrega"),
    @NamedQuery(name = "ErpCompra.findByCtiStCodigo", query = "SELECT e FROM ErpCompra e WHERE e.ctiStCodigo = :ctiStCodigo"),
    @NamedQuery(name = "ErpCompra.findByCprStObs", query = "SELECT e FROM ErpCompra e WHERE e.cprStObs = :cprStObs"),
    @NamedQuery(name = "ErpCompra.findByCprStEntregapara", query = "SELECT e FROM ErpCompra e WHERE e.cprStEntregapara = :cprStEntregapara"),
    @NamedQuery(name = "ErpCompra.findByCprChFinalizado", query = "SELECT e FROM ErpCompra e WHERE e.cprChFinalizado = :cprChFinalizado"),
    @NamedQuery(name = "ErpCompra.findByCprInAutorizacao", query = "SELECT e FROM ErpCompra e WHERE e.cprInAutorizacao = :cprInAutorizacao"),
    @NamedQuery(name = "ErpCompra.findByCprStRegistroemuso", query = "SELECT e FROM ErpCompra e WHERE e.cprStRegistroemuso = :cprStRegistroemuso"),
    @NamedQuery(name = "ErpCompra.findByCprDtRegistroemuso", query = "SELECT e FROM ErpCompra e WHERE e.cprDtRegistroemuso = :cprDtRegistroemuso"),
    @NamedQuery(name = "ErpCompra.findByCprChNaoaceito", query = "SELECT e FROM ErpCompra e WHERE e.cprChNaoaceito = :cprChNaoaceito"),
    @NamedQuery(name = "ErpCompra.findByCprStUltimaautorizacao", query = "SELECT e FROM ErpCompra e WHERE e.cprStUltimaautorizacao = :cprStUltimaautorizacao")})
public class ErpCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CPR_IN_CODIGO")
    private BigDecimal cprInCodigo;
    @Size(max = 2)
    @Column(name = "CPR_ST_STATUS")
    private String cprStStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Size(max = 3)
    @Column(name = "MAR_ST_CODIGO")
    private String marStCodigo;
    @Size(max = 3)
    @Column(name = "MAR_ST_CODIGODES")
    private String marStCodigodes;
    @Size(max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Size(max = 3)
    @Column(name = "UNI_ST_CODIGODES")
    private String uniStCodigodes;
    @Size(max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;
    @Size(max = 20)
    @Column(name = "CCU_ST_CODIGODES")
    private String ccuStCodigodes;
    @Size(max = 6)
    @Column(name = "ORI_ST_CODIGO")
    private String oriStCodigo;
    @Size(max = 6)
    @Column(name = "ORI_ST_CODIGODES")
    private String oriStCodigodes;
    @Column(name = "CPR_DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date cprDtCadastro;
    @Column(name = "CPR_DT_ENTREGA")
    @Temporal(TemporalType.DATE)
    private Date cprDtEntrega;
    @Size(max = 3)
    @Column(name = "CTI_ST_CODIGO")
    private String ctiStCodigo;
    @Size(max = 200)
    @Column(name = "CPR_ST_OBS")
    private String cprStObs;
    @Size(max = 200)
    @Column(name = "CPR_ST_ENTREGAPARA")
    private String cprStEntregapara;
    @Size(max = 1)
    @Column(name = "CPR_CH_FINALIZADO")
    private String cprChFinalizado;
    @Column(name = "CPR_IN_AUTORIZACAO")
    private BigInteger cprInAutorizacao;
    @Size(max = 20)
    @Column(name = "CPR_ST_REGISTROEMUSO")
    private String cprStRegistroemuso;
    @Column(name = "CPR_DT_REGISTROEMUSO")
    @Temporal(TemporalType.DATE)
    private Date cprDtRegistroemuso;
    @Size(max = 1)
    @Column(name = "CPR_CH_NAOACEITO")
    private String cprChNaoaceito;
    @Size(max = 20)
    @Column(name = "CPR_ST_ULTIMAAUTORIZACAO")
    private String cprStUltimaautorizacao;

    public ErpCompra() {
    }

    public ErpCompra(BigDecimal cprInCodigo) {
        this.cprInCodigo = cprInCodigo;
    }

    public ErpCompra(BigDecimal cprInCodigo, String usuStCodigo) {
        this.cprInCodigo = cprInCodigo;
        this.usuStCodigo = usuStCodigo;
    }

    public BigDecimal getCprInCodigo() {
        return cprInCodigo;
    }

    public void setCprInCodigo(BigDecimal cprInCodigo) {
        this.cprInCodigo = cprInCodigo;
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

    public String getMarStCodigo() {
        return marStCodigo;
    }

    public void setMarStCodigo(String marStCodigo) {
        this.marStCodigo = marStCodigo;
    }

    public String getMarStCodigodes() {
        return marStCodigodes;
    }

    public void setMarStCodigodes(String marStCodigodes) {
        this.marStCodigodes = marStCodigodes;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getUniStCodigodes() {
        return uniStCodigodes;
    }

    public void setUniStCodigodes(String uniStCodigodes) {
        this.uniStCodigodes = uniStCodigodes;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    public String getCcuStCodigodes() {
        return ccuStCodigodes;
    }

    public void setCcuStCodigodes(String ccuStCodigodes) {
        this.ccuStCodigodes = ccuStCodigodes;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public String getOriStCodigodes() {
        return oriStCodigodes;
    }

    public void setOriStCodigodes(String oriStCodigodes) {
        this.oriStCodigodes = oriStCodigodes;
    }

    public Date getCprDtCadastro() {
        return cprDtCadastro;
    }

    public void setCprDtCadastro(Date cprDtCadastro) {
        this.cprDtCadastro = cprDtCadastro;
    }

    public Date getCprDtEntrega() {
        return cprDtEntrega;
    }

    public void setCprDtEntrega(Date cprDtEntrega) {
        this.cprDtEntrega = cprDtEntrega;
    }

    public String getCtiStCodigo() {
        return ctiStCodigo;
    }

    public void setCtiStCodigo(String ctiStCodigo) {
        this.ctiStCodigo = ctiStCodigo;
    }

    public String getCprStObs() {
        return cprStObs;
    }

    public void setCprStObs(String cprStObs) {
        this.cprStObs = cprStObs;
    }

    public String getCprStEntregapara() {
        return cprStEntregapara;
    }

    public void setCprStEntregapara(String cprStEntregapara) {
        this.cprStEntregapara = cprStEntregapara;
    }

    public String getCprChFinalizado() {
        return cprChFinalizado;
    }

    public void setCprChFinalizado(String cprChFinalizado) {
        this.cprChFinalizado = cprChFinalizado;
    }

    public BigInteger getCprInAutorizacao() {
        return cprInAutorizacao;
    }

    public void setCprInAutorizacao(BigInteger cprInAutorizacao) {
        this.cprInAutorizacao = cprInAutorizacao;
    }

    public String getCprStRegistroemuso() {
        return cprStRegistroemuso;
    }

    public void setCprStRegistroemuso(String cprStRegistroemuso) {
        this.cprStRegistroemuso = cprStRegistroemuso;
    }

    public Date getCprDtRegistroemuso() {
        return cprDtRegistroemuso;
    }

    public void setCprDtRegistroemuso(Date cprDtRegistroemuso) {
        this.cprDtRegistroemuso = cprDtRegistroemuso;
    }

    public String getCprChNaoaceito() {
        return cprChNaoaceito;
    }

    public void setCprChNaoaceito(String cprChNaoaceito) {
        this.cprChNaoaceito = cprChNaoaceito;
    }

    public String getCprStUltimaautorizacao() {
        return cprStUltimaautorizacao;
    }

    public void setCprStUltimaautorizacao(String cprStUltimaautorizacao) {
        this.cprStUltimaautorizacao = cprStUltimaautorizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cprInCodigo != null ? cprInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCompra)) {
            return false;
        }
        ErpCompra other = (ErpCompra) object;
        if ((this.cprInCodigo == null && other.cprInCodigo != null) || (this.cprInCodigo != null && !this.cprInCodigo.equals(other.cprInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCompra[ cprInCodigo=" + cprInCodigo + " ]";
    }
    
}
