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
@Table(name = "ERP_INVENTARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpInventario.findAll", query = "SELECT e FROM ErpInventario e"),
    @NamedQuery(name = "ErpInventario.findByInvInCodigo", query = "SELECT e FROM ErpInventario e WHERE e.invInCodigo = :invInCodigo"),
    @NamedQuery(name = "ErpInventario.findByUniStCodigo", query = "SELECT e FROM ErpInventario e WHERE e.uniStCodigo = :uniStCodigo"),
    @NamedQuery(name = "ErpInventario.findByInvDtDatareferente", query = "SELECT e FROM ErpInventario e WHERE e.invDtDatareferente = :invDtDatareferente"),
    @NamedQuery(name = "ErpInventario.findByUsuStCodigo1", query = "SELECT e FROM ErpInventario e WHERE e.usuStCodigo1 = :usuStCodigo1"),
    @NamedQuery(name = "ErpInventario.findByInvInContagens", query = "SELECT e FROM ErpInventario e WHERE e.invInContagens = :invInContagens"),
    @NamedQuery(name = "ErpInventario.findByInvDtContagemdata1", query = "SELECT e FROM ErpInventario e WHERE e.invDtContagemdata1 = :invDtContagemdata1"),
    @NamedQuery(name = "ErpInventario.findByUsuStCodigo2", query = "SELECT e FROM ErpInventario e WHERE e.usuStCodigo2 = :usuStCodigo2"),
    @NamedQuery(name = "ErpInventario.findByInvDtContagemdata2", query = "SELECT e FROM ErpInventario e WHERE e.invDtContagemdata2 = :invDtContagemdata2"),
    @NamedQuery(name = "ErpInventario.findByInvStDescricao", query = "SELECT e FROM ErpInventario e WHERE e.invStDescricao = :invStDescricao"),
    @NamedQuery(name = "ErpInventario.findByCcuStCodigo", query = "SELECT e FROM ErpInventario e WHERE e.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpInventario.findByInvStStatus", query = "SELECT e FROM ErpInventario e WHERE e.invStStatus = :invStStatus"),
    @NamedQuery(name = "ErpInventario.findByInvDtCadastro", query = "SELECT e FROM ErpInventario e WHERE e.invDtCadastro = :invDtCadastro"),
    @NamedQuery(name = "ErpInventario.findByUsuChCodenviado1", query = "SELECT e FROM ErpInventario e WHERE e.usuChCodenviado1 = :usuChCodenviado1"),
    @NamedQuery(name = "ErpInventario.findByUsuChCodenviado2", query = "SELECT e FROM ErpInventario e WHERE e.usuChCodenviado2 = :usuChCodenviado2"),
    @NamedQuery(name = "ErpInventario.findByInvDtContagemdata3", query = "SELECT e FROM ErpInventario e WHERE e.invDtContagemdata3 = :invDtContagemdata3"),
    @NamedQuery(name = "ErpInventario.findByUsuStCodigo3", query = "SELECT e FROM ErpInventario e WHERE e.usuStCodigo3 = :usuStCodigo3"),
    @NamedQuery(name = "ErpInventario.findByUsuChCodenviado3", query = "SELECT e FROM ErpInventario e WHERE e.usuChCodenviado3 = :usuChCodenviado3")})
public class ErpInventario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INV_IN_CODIGO")
    private BigDecimal invInCodigo;
    @Size(max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Column(name = "INV_DT_DATAREFERENTE")
    @Temporal(TemporalType.DATE)
    private Date invDtDatareferente;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO1")
    private String usuStCodigo1;
    @Column(name = "INV_IN_CONTAGENS")
    private BigInteger invInContagens;
    @Column(name = "INV_DT_CONTAGEMDATA1")
    @Temporal(TemporalType.DATE)
    private Date invDtContagemdata1;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO2")
    private String usuStCodigo2;
    @Column(name = "INV_DT_CONTAGEMDATA2")
    @Temporal(TemporalType.DATE)
    private Date invDtContagemdata2;
    @Size(max = 200)
    @Column(name = "INV_ST_DESCRICAO")
    private String invStDescricao;
    @Size(max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;
    @Size(max = 2)
    @Column(name = "INV_ST_STATUS")
    private String invStStatus;
    @Column(name = "INV_DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date invDtCadastro;
    @Size(max = 1)
    @Column(name = "USU_CH_CODENVIADO1")
    private String usuChCodenviado1;
    @Size(max = 1)
    @Column(name = "USU_CH_CODENVIADO2")
    private String usuChCodenviado2;
    @Column(name = "INV_DT_CONTAGEMDATA3")
    @Temporal(TemporalType.DATE)
    private Date invDtContagemdata3;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO3")
    private String usuStCodigo3;
    @Size(max = 1)
    @Column(name = "USU_CH_CODENVIADO3")
    private String usuChCodenviado3;

    public ErpInventario() {
    }

    public ErpInventario(BigDecimal invInCodigo) {
        this.invInCodigo = invInCodigo;
    }

    public BigDecimal getInvInCodigo() {
        return invInCodigo;
    }

    public void setInvInCodigo(BigDecimal invInCodigo) {
        this.invInCodigo = invInCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public Date getInvDtDatareferente() {
        return invDtDatareferente;
    }

    public void setInvDtDatareferente(Date invDtDatareferente) {
        this.invDtDatareferente = invDtDatareferente;
    }

    public String getUsuStCodigo1() {
        return usuStCodigo1;
    }

    public void setUsuStCodigo1(String usuStCodigo1) {
        this.usuStCodigo1 = usuStCodigo1;
    }

    public BigInteger getInvInContagens() {
        return invInContagens;
    }

    public void setInvInContagens(BigInteger invInContagens) {
        this.invInContagens = invInContagens;
    }

    public Date getInvDtContagemdata1() {
        return invDtContagemdata1;
    }

    public void setInvDtContagemdata1(Date invDtContagemdata1) {
        this.invDtContagemdata1 = invDtContagemdata1;
    }

    public String getUsuStCodigo2() {
        return usuStCodigo2;
    }

    public void setUsuStCodigo2(String usuStCodigo2) {
        this.usuStCodigo2 = usuStCodigo2;
    }

    public Date getInvDtContagemdata2() {
        return invDtContagemdata2;
    }

    public void setInvDtContagemdata2(Date invDtContagemdata2) {
        this.invDtContagemdata2 = invDtContagemdata2;
    }

    public String getInvStDescricao() {
        return invStDescricao;
    }

    public void setInvStDescricao(String invStDescricao) {
        this.invStDescricao = invStDescricao;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    public String getInvStStatus() {
        return invStStatus;
    }

    public void setInvStStatus(String invStStatus) {
        this.invStStatus = invStStatus;
    }

    public Date getInvDtCadastro() {
        return invDtCadastro;
    }

    public void setInvDtCadastro(Date invDtCadastro) {
        this.invDtCadastro = invDtCadastro;
    }

    public String getUsuChCodenviado1() {
        return usuChCodenviado1;
    }

    public void setUsuChCodenviado1(String usuChCodenviado1) {
        this.usuChCodenviado1 = usuChCodenviado1;
    }

    public String getUsuChCodenviado2() {
        return usuChCodenviado2;
    }

    public void setUsuChCodenviado2(String usuChCodenviado2) {
        this.usuChCodenviado2 = usuChCodenviado2;
    }

    public Date getInvDtContagemdata3() {
        return invDtContagemdata3;
    }

    public void setInvDtContagemdata3(Date invDtContagemdata3) {
        this.invDtContagemdata3 = invDtContagemdata3;
    }

    public String getUsuStCodigo3() {
        return usuStCodigo3;
    }

    public void setUsuStCodigo3(String usuStCodigo3) {
        this.usuStCodigo3 = usuStCodigo3;
    }

    public String getUsuChCodenviado3() {
        return usuChCodenviado3;
    }

    public void setUsuChCodenviado3(String usuChCodenviado3) {
        this.usuChCodenviado3 = usuChCodenviado3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invInCodigo != null ? invInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpInventario)) {
            return false;
        }
        ErpInventario other = (ErpInventario) object;
        if ((this.invInCodigo == null && other.invInCodigo != null) || (this.invInCodigo != null && !this.invInCodigo.equals(other.invInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpInventario[ invInCodigo=" + invInCodigo + " ]";
    }
    
}
