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
@Table(name = "ERP_REGIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpRegional.findAll", query = "SELECT e FROM ErpRegional e"),
    @NamedQuery(name = "ErpRegional.findByRgiStLetra", query = "SELECT e FROM ErpRegional e WHERE e.erpRegionalPK.rgiStLetra = :rgiStLetra"),
    @NamedQuery(name = "ErpRegional.findByRgiStCodigo", query = "SELECT e FROM ErpRegional e WHERE e.erpRegionalPK.rgiStCodigo = :rgiStCodigo"),
    @NamedQuery(name = "ErpRegional.findByRgiStDescricao", query = "SELECT e FROM ErpRegional e WHERE e.rgiStDescricao = :rgiStDescricao"),
    @NamedQuery(name = "ErpRegional.findByRgiStUf", query = "SELECT e FROM ErpRegional e WHERE e.rgiStUf = :rgiStUf"),
    @NamedQuery(name = "ErpRegional.findByRgiChAtivo", query = "SELECT e FROM ErpRegional e WHERE e.rgiChAtivo = :rgiChAtivo")})
public class ErpRegional implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpRegionalPK erpRegionalPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RGI_ST_DESCRICAO")
    private String rgiStDescricao;
    @Size(max = 2)
    @Column(name = "RGI_ST_UF")
    private String rgiStUf;
    @Size(max = 1)
    @Column(name = "RGI_CH_ATIVO")
    private String rgiChAtivo;

    public ErpRegional() {
    }

    public ErpRegional(ErpRegionalPK erpRegionalPK) {
        this.erpRegionalPK = erpRegionalPK;
    }

    public ErpRegional(ErpRegionalPK erpRegionalPK, String rgiStDescricao) {
        this.erpRegionalPK = erpRegionalPK;
        this.rgiStDescricao = rgiStDescricao;
    }

    public ErpRegional(ErpRegionalPK erpRegionalPK, String rgiStDescricao, String rgiStUf) {
        this.erpRegionalPK = erpRegionalPK;
        this.rgiStDescricao = rgiStDescricao;
        this.rgiStUf = rgiStUf;
    }
    

    public ErpRegional(String rgiStLetra, String rgiStCodigo) {
        this.erpRegionalPK = new ErpRegionalPK(rgiStLetra, rgiStCodigo);
    }

    public ErpRegionalPK getErpRegionalPK() {
        return erpRegionalPK;
    }

    public void setErpRegionalPK(ErpRegionalPK erpRegionalPK) {
        this.erpRegionalPK = erpRegionalPK;
    }

    public String getRgiStDescricao() {
        return rgiStDescricao;
    }

    public void setRgiStDescricao(String rgiStDescricao) {
        this.rgiStDescricao = rgiStDescricao;
    }

    public String getRgiStUf() {
        return rgiStUf;
    }

    public void setRgiStUf(String rgiStUf) {
        this.rgiStUf = rgiStUf;
    }

    public String getRgiChAtivo() {
        return rgiChAtivo;
    }

    public void setRgiChAtivo(String rgiChAtivo) {
        this.rgiChAtivo = rgiChAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpRegionalPK != null ? erpRegionalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpRegional)) {
            return false;
        }
        ErpRegional other = (ErpRegional) object;
        if ((this.erpRegionalPK == null && other.erpRegionalPK != null) || (this.erpRegionalPK != null && !this.erpRegionalPK.equals(other.erpRegionalPK))) {
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
