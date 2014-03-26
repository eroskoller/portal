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
@Table(name = "ERP_ESTOQUECCUSTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpEstoqueccusto.findAll", query = "SELECT e FROM ErpEstoqueccusto e"),
    @NamedQuery(name = "ErpEstoqueccusto.findByEccInCodigo", query = "SELECT e FROM ErpEstoqueccusto e WHERE e.eccInCodigo = :eccInCodigo"),
    @NamedQuery(name = "ErpEstoqueccusto.findByCcuStCodigo", query = "SELECT e FROM ErpEstoqueccusto e WHERE e.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpEstoqueccusto.findByItmStCodigo", query = "SELECT e FROM ErpEstoqueccusto e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpEstoqueccusto.findByEccStLote", query = "SELECT e FROM ErpEstoqueccusto e WHERE e.eccStLote = :eccStLote"),
    @NamedQuery(name = "ErpEstoqueccusto.findByEccDtValidade", query = "SELECT e FROM ErpEstoqueccusto e WHERE e.eccDtValidade = :eccDtValidade"),
    @NamedQuery(name = "ErpEstoqueccusto.findByEccInSaldo", query = "SELECT e FROM ErpEstoqueccusto e WHERE e.eccInSaldo = :eccInSaldo")})
public class ErpEstoqueccusto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ECC_IN_CODIGO")
    private BigDecimal eccInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ECC_ST_LOTE")
    private String eccStLote;
    @Column(name = "ECC_DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date eccDtValidade;
    @Column(name = "ECC_IN_SALDO")
    private BigInteger eccInSaldo;

    public ErpEstoqueccusto() {
    }

    public ErpEstoqueccusto(BigDecimal eccInCodigo) {
        this.eccInCodigo = eccInCodigo;
    }

    public ErpEstoqueccusto(BigDecimal eccInCodigo, String ccuStCodigo, String itmStCodigo, String eccStLote) {
        this.eccInCodigo = eccInCodigo;
        this.ccuStCodigo = ccuStCodigo;
        this.itmStCodigo = itmStCodigo;
        this.eccStLote = eccStLote;
    }

    public BigDecimal getEccInCodigo() {
        return eccInCodigo;
    }

    public void setEccInCodigo(BigDecimal eccInCodigo) {
        this.eccInCodigo = eccInCodigo;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getEccStLote() {
        return eccStLote;
    }

    public void setEccStLote(String eccStLote) {
        this.eccStLote = eccStLote;
    }

    public Date getEccDtValidade() {
        return eccDtValidade;
    }

    public void setEccDtValidade(Date eccDtValidade) {
        this.eccDtValidade = eccDtValidade;
    }

    public BigInteger getEccInSaldo() {
        return eccInSaldo;
    }

    public void setEccInSaldo(BigInteger eccInSaldo) {
        this.eccInSaldo = eccInSaldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eccInCodigo != null ? eccInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpEstoqueccusto)) {
            return false;
        }
        ErpEstoqueccusto other = (ErpEstoqueccusto) object;
        if ((this.eccInCodigo == null && other.eccInCodigo != null) || (this.eccInCodigo != null && !this.eccInCodigo.equals(other.eccInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpEstoqueccusto[ eccInCodigo=" + eccInCodigo + " ]";
    }
    
}
