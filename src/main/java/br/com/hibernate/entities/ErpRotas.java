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
@Table(name = "ERP_ROTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpRotas.findAll", query = "SELECT e FROM ErpRotas e"),
    @NamedQuery(name = "ErpRotas.findByRtaStCodigo", query = "SELECT e FROM ErpRotas e WHERE e.rtaStCodigo = :rtaStCodigo"),
    @NamedQuery(name = "ErpRotas.findByRtaStDescricao", query = "SELECT e FROM ErpRotas e WHERE e.rtaStDescricao = :rtaStDescricao"),
    @NamedQuery(name = "ErpRotas.findByRtaChAtivo", query = "SELECT e FROM ErpRotas e WHERE e.rtaChAtivo = :rtaChAtivo")})
public class ErpRotas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "RTA_ST_CODIGO")
    private String rtaStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "RTA_ST_DESCRICAO")
    private String rtaStDescricao;
    @Column(name = "RTA_CH_ATIVO")
    private Character rtaChAtivo;

    public ErpRotas() {
    }

    public ErpRotas(String rtaStCodigo) {
        this.rtaStCodigo = rtaStCodigo;
    }

    public ErpRotas(String rtaStCodigo, String rtaStDescricao) {
        this.rtaStCodigo = rtaStCodigo;
        this.rtaStDescricao = rtaStDescricao;
    }

    public String getRtaStCodigo() {
        return rtaStCodigo;
    }

    public void setRtaStCodigo(String rtaStCodigo) {
        this.rtaStCodigo = rtaStCodigo;
    }

    public String getRtaStDescricao() {
        return rtaStDescricao;
    }

    public void setRtaStDescricao(String rtaStDescricao) {
        this.rtaStDescricao = rtaStDescricao;
    }

    public Character getRtaChAtivo() {
        return rtaChAtivo;
    }

    public void setRtaChAtivo(Character rtaChAtivo) {
        this.rtaChAtivo = rtaChAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rtaStCodigo != null ? rtaStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpRotas)) {
            return false;
        }
        ErpRotas other = (ErpRotas) object;
        if ((this.rtaStCodigo == null && other.rtaStCodigo != null) || (this.rtaStCodigo != null && !this.rtaStCodigo.equals(other.rtaStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpRotas[ rtaStCodigo=" + rtaStCodigo + " ]";
    }
    
}
