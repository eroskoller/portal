/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_ACOES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpAcoes.findAll", query = "SELECT e FROM ErpAcoes e"),
    @NamedQuery(name = "ErpAcoes.findByAcsStCodigo", query = "SELECT e FROM ErpAcoes e WHERE e.acsStCodigo = :acsStCodigo"),
    @NamedQuery(name = "ErpAcoes.findByAcsStDescricao", query = "SELECT e FROM ErpAcoes e WHERE e.acsStDescricao = :acsStDescricao")})
public class ErpAcoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ACS_ST_CODIGO")
    private String acsStCodigo;
    @Size(max = 2000)
    @Column(name = "ACS_ST_DESCRICAO")
    private String acsStDescricao;

    public ErpAcoes() {
    }

    public ErpAcoes(String acsStCodigo) {
        this.acsStCodigo = acsStCodigo;
    }

    public String getAcsStCodigo() {
        return acsStCodigo;
    }

    public void setAcsStCodigo(String acsStCodigo) {
        this.acsStCodigo = acsStCodigo;
    }

    public String getAcsStDescricao() {
        return acsStDescricao;
    }

    public void setAcsStDescricao(String acsStDescricao) {
        this.acsStDescricao = acsStDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acsStCodigo != null ? acsStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpAcoes)) {
            return false;
        }
        ErpAcoes other = (ErpAcoes) object;
        if ((this.acsStCodigo == null && other.acsStCodigo != null) || (this.acsStCodigo != null && !this.acsStCodigo.equals(other.acsStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpAcoes[ acsStCodigo=" + acsStCodigo + " ]";
    }
    
}
