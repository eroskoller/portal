/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_ARMAZENS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpArmazens.findAll", query = "SELECT e FROM ErpArmazens e"),
    @NamedQuery(name = "ErpArmazens.findByAmzStCodigo", query = "SELECT e FROM ErpArmazens e WHERE e.amzStCodigo = :amzStCodigo"),
    @NamedQuery(name = "ErpArmazens.findByAmzStDescricao", query = "SELECT e FROM ErpArmazens e WHERE e.amzStDescricao = :amzStDescricao"),
    @NamedQuery(name = "ErpArmazens.findByAmzChAtivo", query = "SELECT e FROM ErpArmazens e WHERE e.amzChAtivo = :amzChAtivo")})
public class ErpArmazens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "AMZ_ST_CODIGO")
    private String amzStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "AMZ_ST_DESCRICAO")
    private String amzStDescricao;
    @Column(name = "AMZ_CH_ATIVO")
    private Character amzChAtivo;
    @JoinTable(name = "ERP_USUARIOARMAZEM", joinColumns = {
        @JoinColumn(name = "AMZ_ST_CODIGO", referencedColumnName = "AMZ_ST_CODIGO")}, inverseJoinColumns = {
        @JoinColumn(name = "USU_ST_CODIGO", referencedColumnName = "USU_ST_CODIGO")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<LabUsuario> labUsuarioList;

    public ErpArmazens() {
    }

    public ErpArmazens(String amzStCodigo) {
        this.amzStCodigo = amzStCodigo;
    }

    public ErpArmazens(String amzStCodigo, String amzStDescricao) {
        this.amzStCodigo = amzStCodigo;
        this.amzStDescricao = amzStDescricao;
    }

    public String getAmzStCodigo() {
        return amzStCodigo;
    }

    public void setAmzStCodigo(String amzStCodigo) {
        this.amzStCodigo = amzStCodigo;
    }

    public String getAmzStDescricao() {
        return amzStDescricao;
    }

    public void setAmzStDescricao(String amzStDescricao) {
        this.amzStDescricao = amzStDescricao;
    }

    public Character getAmzChAtivo() {
        return amzChAtivo;
    }

    public void setAmzChAtivo(Character amzChAtivo) {
        this.amzChAtivo = amzChAtivo;
    }

    @XmlTransient
    public List<LabUsuario> getLabUsuarioList() {
        return labUsuarioList;
    }

    public void setLabUsuarioList(List<LabUsuario> labUsuarioList) {
        this.labUsuarioList = labUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (amzStCodigo != null ? amzStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpArmazens)) {
            return false;
        }
        ErpArmazens other = (ErpArmazens) object;
        if ((this.amzStCodigo == null && other.amzStCodigo != null) || (this.amzStCodigo != null && !this.amzStCodigo.equals(other.amzStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpArmazens[ amzStCodigo=" + amzStCodigo + " ]";
    }
    
}
