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
@Table(name = "ERP_TIPOTRANSPORTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpTipotransporte.findAll", query = "SELECT e FROM ErpTipotransporte e"),
    @NamedQuery(name = "ErpTipotransporte.findByTtrStCodigo", query = "SELECT e FROM ErpTipotransporte e WHERE e.ttrStCodigo = :ttrStCodigo"),
    @NamedQuery(name = "ErpTipotransporte.findByTtrStDescricao", query = "SELECT e FROM ErpTipotransporte e WHERE e.ttrStDescricao = :ttrStDescricao"),
    @NamedQuery(name = "ErpTipotransporte.findByTtrChAtivo", query = "SELECT e FROM ErpTipotransporte e WHERE e.ttrChAtivo = :ttrChAtivo")})
public class ErpTipotransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "TTR_ST_CODIGO")
    private String ttrStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TTR_ST_DESCRICAO")
    private String ttrStDescricao;
    @Column(name = "TTR_CH_ATIVO")
    private Character ttrChAtivo;

    public ErpTipotransporte() {
    }

    public ErpTipotransporte(String ttrStCodigo) {
        this.ttrStCodigo = ttrStCodigo;
    }

    public ErpTipotransporte(String ttrStCodigo, String ttrStDescricao) {
        this.ttrStCodigo = ttrStCodigo;
        this.ttrStDescricao = ttrStDescricao;
    }

    public String getTtrStCodigo() {
        return ttrStCodigo;
    }

    public void setTtrStCodigo(String ttrStCodigo) {
        this.ttrStCodigo = ttrStCodigo;
    }

    public String getTtrStDescricao() {
        return ttrStDescricao;
    }

    public void setTtrStDescricao(String ttrStDescricao) {
        this.ttrStDescricao = ttrStDescricao;
    }

    public Character getTtrChAtivo() {
        return ttrChAtivo;
    }

    public void setTtrChAtivo(Character ttrChAtivo) {
        this.ttrChAtivo = ttrChAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttrStCodigo != null ? ttrStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpTipotransporte)) {
            return false;
        }
        ErpTipotransporte other = (ErpTipotransporte) object;
        if ((this.ttrStCodigo == null && other.ttrStCodigo != null) || (this.ttrStCodigo != null && !this.ttrStCodigo.equals(other.ttrStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpTipotransporte[ ttrStCodigo=" + ttrStCodigo + " ]";
    }
    
}
