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
@Table(name = "ERP_TIPOARMAZEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpTipoarmazem.findAll", query = "SELECT e FROM ErpTipoarmazem e"),
    @NamedQuery(name = "ErpTipoarmazem.findByTazStCodigo", query = "SELECT e FROM ErpTipoarmazem e WHERE e.tazStCodigo = :tazStCodigo"),
    @NamedQuery(name = "ErpTipoarmazem.findByTazStDescricao", query = "SELECT e FROM ErpTipoarmazem e WHERE e.tazStDescricao = :tazStDescricao"),
    @NamedQuery(name = "ErpTipoarmazem.findByTazChAtivo", query = "SELECT e FROM ErpTipoarmazem e WHERE e.tazChAtivo = :tazChAtivo")})
public class ErpTipoarmazem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "TAZ_ST_CODIGO")
    private String tazStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "TAZ_ST_DESCRICAO")
    private String tazStDescricao;
    @Column(name = "TAZ_CH_ATIVO")
    private Character tazChAtivo;

    public ErpTipoarmazem() {
    }

    public ErpTipoarmazem(String tazStCodigo) {
        this.tazStCodigo = tazStCodigo;
    }

    public ErpTipoarmazem(String tazStCodigo, String tazStDescricao) {
        this.tazStCodigo = tazStCodigo;
        this.tazStDescricao = tazStDescricao;
    }

    public String getTazStCodigo() {
        return tazStCodigo;
    }

    public void setTazStCodigo(String tazStCodigo) {
        this.tazStCodigo = tazStCodigo;
    }

    public String getTazStDescricao() {
        return tazStDescricao;
    }

    public void setTazStDescricao(String tazStDescricao) {
        this.tazStDescricao = tazStDescricao;
    }

    public Character getTazChAtivo() {
        return tazChAtivo;
    }

    public void setTazChAtivo(Character tazChAtivo) {
        this.tazChAtivo = tazChAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tazStCodigo != null ? tazStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpTipoarmazem)) {
            return false;
        }
        ErpTipoarmazem other = (ErpTipoarmazem) object;
        if ((this.tazStCodigo == null && other.tazStCodigo != null) || (this.tazStCodigo != null && !this.tazStCodigo.equals(other.tazStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpTipoarmazem[ tazStCodigo=" + tazStCodigo + " ]";
    }
    
}
