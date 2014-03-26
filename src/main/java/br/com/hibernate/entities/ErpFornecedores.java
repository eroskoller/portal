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
@Table(name = "ERP_FORNECEDORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpFornecedores.findAll", query = "SELECT e FROM ErpFornecedores e"),
    @NamedQuery(name = "ErpFornecedores.findByFdoStCodigo", query = "SELECT e FROM ErpFornecedores e WHERE e.fdoStCodigo = :fdoStCodigo"),
    @NamedQuery(name = "ErpFornecedores.findByFdoStDescricao", query = "SELECT e FROM ErpFornecedores e WHERE e.fdoStDescricao = :fdoStDescricao"),
    @NamedQuery(name = "ErpFornecedores.findByFdoChAtivo", query = "SELECT e FROM ErpFornecedores e WHERE e.fdoChAtivo = :fdoChAtivo")})
public class ErpFornecedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "FDO_ST_CODIGO")
    private String fdoStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "FDO_ST_DESCRICAO")
    private String fdoStDescricao;
    @Size(max = 1)
    @Column(name = "FDO_CH_ATIVO")
    private String fdoChAtivo;

    public ErpFornecedores() {
    }

    public ErpFornecedores(String fdoStCodigo) {
        this.fdoStCodigo = fdoStCodigo;
    }

    public ErpFornecedores(String fdoStCodigo, String fdoStDescricao) {
        this.fdoStCodigo = fdoStCodigo;
        this.fdoStDescricao = fdoStDescricao;
    }

    public String getFdoStCodigo() {
        return fdoStCodigo;
    }

    public void setFdoStCodigo(String fdoStCodigo) {
        this.fdoStCodigo = fdoStCodigo;
    }

    public String getFdoStDescricao() {
        return fdoStDescricao;
    }

    public void setFdoStDescricao(String fdoStDescricao) {
        this.fdoStDescricao = fdoStDescricao;
    }

    public String getFdoChAtivo() {
        return fdoChAtivo;
    }

    public void setFdoChAtivo(String fdoChAtivo) {
        this.fdoChAtivo = fdoChAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fdoStCodigo != null ? fdoStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpFornecedores)) {
            return false;
        }
        ErpFornecedores other = (ErpFornecedores) object;
        if ((this.fdoStCodigo == null && other.fdoStCodigo != null) || (this.fdoStCodigo != null && !this.fdoStCodigo.equals(other.fdoStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpFornecedores[ fdoStCodigo=" + fdoStCodigo + " ]";
    }
    
}
