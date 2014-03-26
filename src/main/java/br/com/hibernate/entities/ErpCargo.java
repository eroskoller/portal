/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_CARGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpCargo.findAll", query = "SELECT e FROM ErpCargo e"),
    @NamedQuery(name = "ErpCargo.findByCgoInCodigo", query = "SELECT e FROM ErpCargo e WHERE e.cgoInCodigo = :cgoInCodigo"),
    @NamedQuery(name = "ErpCargo.findByCgoStDescricao", query = "SELECT e FROM ErpCargo e WHERE e.cgoStDescricao = :cgoStDescricao"),
    @NamedQuery(name = "ErpCargo.findByCgoFlValorteto", query = "SELECT e FROM ErpCargo e WHERE e.cgoFlValorteto = :cgoFlValorteto")})
public class ErpCargo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CGO_IN_CODIGO")
    private BigDecimal cgoInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CGO_ST_DESCRICAO")
    private String cgoStDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CGO_FL_VALORTETO")
    private BigDecimal cgoFlValorteto;

    public ErpCargo() {
    }

    public ErpCargo(BigDecimal cgoInCodigo) {
        this.cgoInCodigo = cgoInCodigo;
    }

    public ErpCargo(BigDecimal cgoInCodigo, String cgoStDescricao, BigDecimal cgoFlValorteto) {
        this.cgoInCodigo = cgoInCodigo;
        this.cgoStDescricao = cgoStDescricao;
        this.cgoFlValorteto = cgoFlValorteto;
    }

    public BigDecimal getCgoInCodigo() {
        return cgoInCodigo;
    }

    public void setCgoInCodigo(BigDecimal cgoInCodigo) {
        this.cgoInCodigo = cgoInCodigo;
    }

    public String getCgoStDescricao() {
        return cgoStDescricao;
    }

    public void setCgoStDescricao(String cgoStDescricao) {
        this.cgoStDescricao = cgoStDescricao;
    }

    public BigDecimal getCgoFlValorteto() {
        return cgoFlValorteto;
    }

    public void setCgoFlValorteto(BigDecimal cgoFlValorteto) {
        this.cgoFlValorteto = cgoFlValorteto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cgoInCodigo != null ? cgoInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCargo)) {
            return false;
        }
        ErpCargo other = (ErpCargo) object;
        if ((this.cgoInCodigo == null && other.cgoInCodigo != null) || (this.cgoInCodigo != null && !this.cgoInCodigo.equals(other.cgoInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCargo[ cgoInCodigo=" + cgoInCodigo + " ]";
    }
    
}
