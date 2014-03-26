/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import com.thoughtworks.xstream.XStream;
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
@Table(name = "ERP_ESTABELECIMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpEstabelecimento.findAll", query = "SELECT e FROM ErpEstabelecimento e"),
    @NamedQuery(name = "ErpEstabelecimento.findByRgiStLetra", query = "SELECT e FROM ErpEstabelecimento e WHERE e.erpEstabelecimentoPK.rgiStLetra = :rgiStLetra"),
    @NamedQuery(name = "ErpEstabelecimento.findByRgiStCodigo", query = "SELECT e FROM ErpEstabelecimento e WHERE e.erpEstabelecimentoPK.rgiStCodigo = :rgiStCodigo"),
    @NamedQuery(name = "ErpEstabelecimento.findByEstStCodigo", query = "SELECT e FROM ErpEstabelecimento e WHERE e.erpEstabelecimentoPK.estStCodigo = :estStCodigo"),
    @NamedQuery(name = "ErpEstabelecimento.findByEstStDescricao", query = "SELECT e FROM ErpEstabelecimento e WHERE e.estStDescricao = :estStDescricao"),
    @NamedQuery(name = "ErpEstabelecimento.findByEstStFiscal", query = "SELECT e FROM ErpEstabelecimento e WHERE e.estStFiscal = :estStFiscal")})
public class ErpEstabelecimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpEstabelecimentoPK erpEstabelecimentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "EST_ST_DESCRICAO")
    private String estStDescricao;
    @Size(max = 5)
    @Column(name = "EST_ST_FISCAL")
    private String estStFiscal;

    public ErpEstabelecimento() {
    }
    
    

    public ErpEstabelecimento(ErpEstabelecimentoPK erpEstabelecimentoPK) {
        this.erpEstabelecimentoPK = erpEstabelecimentoPK;
    }

    public ErpEstabelecimento(ErpEstabelecimentoPK erpEstabelecimentoPK, String estStDescricao) {
        this.erpEstabelecimentoPK = erpEstabelecimentoPK;
        this.estStDescricao = estStDescricao;
    }

    public ErpEstabelecimento(String rgiStLetra, String rgiStCodigo, String estStCodigo) {
        this.erpEstabelecimentoPK = new ErpEstabelecimentoPK(rgiStLetra, rgiStCodigo, estStCodigo);
    }

    public ErpEstabelecimentoPK getErpEstabelecimentoPK() {
        return erpEstabelecimentoPK;
    }

    public void setErpEstabelecimentoPK(ErpEstabelecimentoPK erpEstabelecimentoPK) {
        this.erpEstabelecimentoPK = erpEstabelecimentoPK;
    }

    public String getEstStDescricao() {
        return estStDescricao;
    }

    public void setEstStDescricao(String estStDescricao) {
        this.estStDescricao = estStDescricao;
    }

    public String getEstStFiscal() {
        return estStFiscal;
    }

    public void setEstStFiscal(String estStFiscal) {
        this.estStFiscal = estStFiscal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpEstabelecimentoPK != null ? erpEstabelecimentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpEstabelecimento)) {
            return false;
        }
        ErpEstabelecimento other = (ErpEstabelecimento) object;
        if ((this.erpEstabelecimentoPK == null && other.erpEstabelecimentoPK != null) || (this.erpEstabelecimentoPK != null && !this.erpEstabelecimentoPK.equals(other.erpEstabelecimentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        XStream xstream = new XStream();
        return  xstream.toXML(this);
    }
    
}
