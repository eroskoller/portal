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
@Table(name = "ERP_TRANSFERENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpTransferencia.findAll", query = "SELECT e FROM ErpTransferencia e"),
    @NamedQuery(name = "ErpTransferencia.findByTrfInCodigo", query = "SELECT e FROM ErpTransferencia e WHERE e.trfInCodigo = :trfInCodigo"),
    @NamedQuery(name = "ErpTransferencia.findByCcuStCodigoorigem", query = "SELECT e FROM ErpTransferencia e WHERE e.ccuStCodigoorigem = :ccuStCodigoorigem"),
    @NamedQuery(name = "ErpTransferencia.findByCcuStCodigodestino", query = "SELECT e FROM ErpTransferencia e WHERE e.ccuStCodigodestino = :ccuStCodigodestino"),
    @NamedQuery(name = "ErpTransferencia.findByTrfDtCadastro", query = "SELECT e FROM ErpTransferencia e WHERE e.trfDtCadastro = :trfDtCadastro"),
    @NamedQuery(name = "ErpTransferencia.findByUsuStCodigo", query = "SELECT e FROM ErpTransferencia e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpTransferencia.findByTrfStStatus", query = "SELECT e FROM ErpTransferencia e WHERE e.trfStStatus = :trfStStatus"),
    @NamedQuery(name = "ErpTransferencia.findByTrfStObs", query = "SELECT e FROM ErpTransferencia e WHERE e.trfStObs = :trfStObs"),
    @NamedQuery(name = "ErpTransferencia.findByTrfDtAceito", query = "SELECT e FROM ErpTransferencia e WHERE e.trfDtAceito = :trfDtAceito"),
    @NamedQuery(name = "ErpTransferencia.findByTrfDtCancelado", query = "SELECT e FROM ErpTransferencia e WHERE e.trfDtCancelado = :trfDtCancelado"),
    @NamedQuery(name = "ErpTransferencia.findByTrfStMotivo", query = "SELECT e FROM ErpTransferencia e WHERE e.trfStMotivo = :trfStMotivo"),
    @NamedQuery(name = "ErpTransferencia.findByTrfStAutorizadopor", query = "SELECT e FROM ErpTransferencia e WHERE e.trfStAutorizadopor = :trfStAutorizadopor"),
    @NamedQuery(name = "ErpTransferencia.findByTrfStRegistroemuso", query = "SELECT e FROM ErpTransferencia e WHERE e.trfStRegistroemuso = :trfStRegistroemuso"),
    @NamedQuery(name = "ErpTransferencia.findByTrfDtRegistroemuso", query = "SELECT e FROM ErpTransferencia e WHERE e.trfDtRegistroemuso = :trfDtRegistroemuso"),
    @NamedQuery(name = "ErpTransferencia.findByUsuStCodigotrf", query = "SELECT e FROM ErpTransferencia e WHERE e.usuStCodigotrf = :usuStCodigotrf"),
    @NamedQuery(name = "ErpTransferencia.findByOriStCodigoorigem", query = "SELECT e FROM ErpTransferencia e WHERE e.oriStCodigoorigem = :oriStCodigoorigem"),
    @NamedQuery(name = "ErpTransferencia.findByOriStCodigodestino", query = "SELECT e FROM ErpTransferencia e WHERE e.oriStCodigodestino = :oriStCodigodestino"),
    @NamedQuery(name = "ErpTransferencia.findByUniStCodigo", query = "SELECT e FROM ErpTransferencia e WHERE e.uniStCodigo = :uniStCodigo"),
    @NamedQuery(name = "ErpTransferencia.findByTrfDtAutorizadopor", query = "SELECT e FROM ErpTransferencia e WHERE e.trfDtAutorizadopor = :trfDtAutorizadopor"),
    @NamedQuery(name = "ErpTransferencia.findByTtrStCodigo", query = "SELECT e FROM ErpTransferencia e WHERE e.ttrStCodigo = :ttrStCodigo")})
public class ErpTransferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRF_IN_CODIGO")
    private BigDecimal trfInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCU_ST_CODIGOORIGEM")
    private String ccuStCodigoorigem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCU_ST_CODIGODESTINO")
    private String ccuStCodigodestino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRF_DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date trfDtCadastro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Size(max = 2)
    @Column(name = "TRF_ST_STATUS")
    private String trfStStatus;
    @Size(max = 100)
    @Column(name = "TRF_ST_OBS")
    private String trfStObs;
    @Column(name = "TRF_DT_ACEITO")
    @Temporal(TemporalType.DATE)
    private Date trfDtAceito;
    @Column(name = "TRF_DT_CANCELADO")
    @Temporal(TemporalType.DATE)
    private Date trfDtCancelado;
    @Size(max = 3)
    @Column(name = "TRF_ST_MOTIVO")
    private String trfStMotivo;
    @Size(max = 20)
    @Column(name = "TRF_ST_AUTORIZADOPOR")
    private String trfStAutorizadopor;
    @Size(max = 20)
    @Column(name = "TRF_ST_REGISTROEMUSO")
    private String trfStRegistroemuso;
    @Column(name = "TRF_DT_REGISTROEMUSO")
    @Temporal(TemporalType.DATE)
    private Date trfDtRegistroemuso;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGOTRF")
    private String usuStCodigotrf;
    @Size(max = 6)
    @Column(name = "ORI_ST_CODIGOORIGEM")
    private String oriStCodigoorigem;
    @Size(max = 6)
    @Column(name = "ORI_ST_CODIGODESTINO")
    private String oriStCodigodestino;
    @Size(max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Column(name = "TRF_DT_AUTORIZADOPOR")
    @Temporal(TemporalType.DATE)
    private Date trfDtAutorizadopor;
    @Size(max = 6)
    @Column(name = "TTR_ST_CODIGO")
    private String ttrStCodigo;

    public ErpTransferencia() {
    }

    public ErpTransferencia(BigDecimal trfInCodigo) {
        this.trfInCodigo = trfInCodigo;
    }

    public ErpTransferencia(BigDecimal trfInCodigo, String ccuStCodigoorigem, String ccuStCodigodestino, Date trfDtCadastro, String usuStCodigo) {
        this.trfInCodigo = trfInCodigo;
        this.ccuStCodigoorigem = ccuStCodigoorigem;
        this.ccuStCodigodestino = ccuStCodigodestino;
        this.trfDtCadastro = trfDtCadastro;
        this.usuStCodigo = usuStCodigo;
    }

    public BigDecimal getTrfInCodigo() {
        return trfInCodigo;
    }

    public void setTrfInCodigo(BigDecimal trfInCodigo) {
        this.trfInCodigo = trfInCodigo;
    }

    public String getCcuStCodigoorigem() {
        return ccuStCodigoorigem;
    }

    public void setCcuStCodigoorigem(String ccuStCodigoorigem) {
        this.ccuStCodigoorigem = ccuStCodigoorigem;
    }

    public String getCcuStCodigodestino() {
        return ccuStCodigodestino;
    }

    public void setCcuStCodigodestino(String ccuStCodigodestino) {
        this.ccuStCodigodestino = ccuStCodigodestino;
    }

    public Date getTrfDtCadastro() {
        return trfDtCadastro;
    }

    public void setTrfDtCadastro(Date trfDtCadastro) {
        this.trfDtCadastro = trfDtCadastro;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getTrfStStatus() {
        return trfStStatus;
    }

    public void setTrfStStatus(String trfStStatus) {
        this.trfStStatus = trfStStatus;
    }

    public String getTrfStObs() {
        return trfStObs;
    }

    public void setTrfStObs(String trfStObs) {
        this.trfStObs = trfStObs;
    }

    public Date getTrfDtAceito() {
        return trfDtAceito;
    }

    public void setTrfDtAceito(Date trfDtAceito) {
        this.trfDtAceito = trfDtAceito;
    }

    public Date getTrfDtCancelado() {
        return trfDtCancelado;
    }

    public void setTrfDtCancelado(Date trfDtCancelado) {
        this.trfDtCancelado = trfDtCancelado;
    }

    public String getTrfStMotivo() {
        return trfStMotivo;
    }

    public void setTrfStMotivo(String trfStMotivo) {
        this.trfStMotivo = trfStMotivo;
    }

    public String getTrfStAutorizadopor() {
        return trfStAutorizadopor;
    }

    public void setTrfStAutorizadopor(String trfStAutorizadopor) {
        this.trfStAutorizadopor = trfStAutorizadopor;
    }

    public String getTrfStRegistroemuso() {
        return trfStRegistroemuso;
    }

    public void setTrfStRegistroemuso(String trfStRegistroemuso) {
        this.trfStRegistroemuso = trfStRegistroemuso;
    }

    public Date getTrfDtRegistroemuso() {
        return trfDtRegistroemuso;
    }

    public void setTrfDtRegistroemuso(Date trfDtRegistroemuso) {
        this.trfDtRegistroemuso = trfDtRegistroemuso;
    }

    public String getUsuStCodigotrf() {
        return usuStCodigotrf;
    }

    public void setUsuStCodigotrf(String usuStCodigotrf) {
        this.usuStCodigotrf = usuStCodigotrf;
    }

    public String getOriStCodigoorigem() {
        return oriStCodigoorigem;
    }

    public void setOriStCodigoorigem(String oriStCodigoorigem) {
        this.oriStCodigoorigem = oriStCodigoorigem;
    }

    public String getOriStCodigodestino() {
        return oriStCodigodestino;
    }

    public void setOriStCodigodestino(String oriStCodigodestino) {
        this.oriStCodigodestino = oriStCodigodestino;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public Date getTrfDtAutorizadopor() {
        return trfDtAutorizadopor;
    }

    public void setTrfDtAutorizadopor(Date trfDtAutorizadopor) {
        this.trfDtAutorizadopor = trfDtAutorizadopor;
    }

    public String getTtrStCodigo() {
        return ttrStCodigo;
    }

    public void setTtrStCodigo(String ttrStCodigo) {
        this.ttrStCodigo = ttrStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trfInCodigo != null ? trfInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpTransferencia)) {
            return false;
        }
        ErpTransferencia other = (ErpTransferencia) object;
        if ((this.trfInCodigo == null && other.trfInCodigo != null) || (this.trfInCodigo != null && !this.trfInCodigo.equals(other.trfInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpTransferencia[ trfInCodigo=" + trfInCodigo + " ]";
    }
    
}
