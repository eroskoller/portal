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
@Table(name = "ERP_MARCAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpMarcas.findAll", query = "SELECT e FROM ErpMarcas e"),
    @NamedQuery(name = "ErpMarcas.findByMarStCodigo", query = "SELECT e FROM ErpMarcas e WHERE e.marStCodigo = :marStCodigo"),
    @NamedQuery(name = "ErpMarcas.findByMarStDescricao", query = "SELECT e FROM ErpMarcas e WHERE e.marStDescricao = :marStDescricao"),
    @NamedQuery(name = "ErpMarcas.findByMarChAtivo", query = "SELECT e FROM ErpMarcas e WHERE e.marChAtivo = :marChAtivo"),
    @NamedQuery(name = "ErpMarcas.findByMarChCotapormes", query = "SELECT e FROM ErpMarcas e WHERE e.marChCotapormes = :marChCotapormes"),
    @NamedQuery(name = "ErpMarcas.findByMarStEntregaprevista", query = "SELECT e FROM ErpMarcas e WHERE e.marStEntregaprevista = :marStEntregaprevista"),
    @NamedQuery(name = "ErpMarcas.findByMarStLimiteconf", query = "SELECT e FROM ErpMarcas e WHERE e.marStLimiteconf = :marStLimiteconf"),
    @NamedQuery(name = "ErpMarcas.findByMarChGerapendencia", query = "SELECT e FROM ErpMarcas e WHERE e.marChGerapendencia = :marChGerapendencia"),
    @NamedQuery(name = "ErpMarcas.findByMarChMarcamanutencao", query = "SELECT e FROM ErpMarcas e WHERE e.marChMarcamanutencao = :marChMarcamanutencao"),
    @NamedQuery(name = "ErpMarcas.findByMarChGeracsv", query = "SELECT e FROM ErpMarcas e WHERE e.marChGeracsv = :marChGeracsv")
//    @NamedQuery(name = "ErpMarcas.findByMarChForcaurgente", query = "SELECT e FROM ErpMarcas e WHERE e.marChForcaurgente = :marChForcaurgente")
})
public class ErpMarcas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "MAR_ST_CODIGO")
    private String marStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "MAR_ST_DESCRICAO")
    private String marStDescricao;
    @Column(name = "MAR_CH_ATIVO")
    private Character marChAtivo;
    @Column(name = "MAR_CH_COTAPORMES")
    private Character marChCotapormes;
    @Size(max = 3)
    @Column(name = "MAR_ST_ENTREGAPREVISTA")
    private String marStEntregaprevista;
    @Size(max = 3)
    @Column(name = "MAR_ST_LIMITECONF")
    private String marStLimiteconf;
    @Column(name = "MAR_CH_GERAPENDENCIA")
    private Character marChGerapendencia;
    @Column(name = "MAR_CH_MARCAMANUTENCAO")
    private Character marChMarcamanutencao;
    @Column(name = "MAR_CH_GERACSV")
    private Character marChGeracsv;
//    @Column(name = "MAR_CH_FORCAURGENTE")
//    private Character marChForcaurgente;
    @JoinTable(name = "ERP_USUARIOMARCAS", joinColumns = {
        @JoinColumn(name = "MAR_ST_CODIGO", referencedColumnName = "MAR_ST_CODIGO")}, inverseJoinColumns = {
        @JoinColumn(name = "USU_ST_CODIGO", referencedColumnName = "USU_ST_CODIGO")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<LabUsuario> labUsuarioList;

    public ErpMarcas() {
    }

    public ErpMarcas(String marStCodigo) {
        this.marStCodigo = marStCodigo;
    }

    public ErpMarcas(String marStCodigo, String marStDescricao) {
        this.marStCodigo = marStCodigo;
        this.marStDescricao = marStDescricao;
    }

    public String getMarStCodigo() {
        return marStCodigo;
    }

    public void setMarStCodigo(String marStCodigo) {
        this.marStCodigo = marStCodigo;
    }

    public String getMarStDescricao() {
        return marStDescricao;
    }

    public void setMarStDescricao(String marStDescricao) {
        this.marStDescricao = marStDescricao;
    }

    public Character getMarChAtivo() {
        return marChAtivo;
    }

    public void setMarChAtivo(Character marChAtivo) {
        this.marChAtivo = marChAtivo;
    }

    public Character getMarChCotapormes() {
        return marChCotapormes;
    }

    public void setMarChCotapormes(Character marChCotapormes) {
        this.marChCotapormes = marChCotapormes;
    }

    public String getMarStEntregaprevista() {
        return marStEntregaprevista;
    }

    public void setMarStEntregaprevista(String marStEntregaprevista) {
        this.marStEntregaprevista = marStEntregaprevista;
    }

    public String getMarStLimiteconf() {
        return marStLimiteconf;
    }

    public void setMarStLimiteconf(String marStLimiteconf) {
        this.marStLimiteconf = marStLimiteconf;
    }

    public Character getMarChGerapendencia() {
        return marChGerapendencia;
    }

    public void setMarChGerapendencia(Character marChGerapendencia) {
        this.marChGerapendencia = marChGerapendencia;
    }

    public Character getMarChMarcamanutencao() {
        return marChMarcamanutencao;
    }

    public void setMarChMarcamanutencao(Character marChMarcamanutencao) {
        this.marChMarcamanutencao = marChMarcamanutencao;
    }

    public Character getMarChGeracsv() {
        return marChGeracsv;
    }

    public void setMarChGeracsv(Character marChGeracsv) {
        this.marChGeracsv = marChGeracsv;
    }

//    public Character getMarChForcaurgente() {
//        return marChForcaurgente;
//    }
//
//    public void setMarChForcaurgente(Character marChForcaurgente) {
//        this.marChForcaurgente = marChForcaurgente;
//    }

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
        hash += (marStCodigo != null ? marStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpMarcas)) {
            return false;
        }
        ErpMarcas other = (ErpMarcas) object;
        if ((this.marStCodigo == null && other.marStCodigo != null) || (this.marStCodigo != null && !this.marStCodigo.equals(other.marStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpMarcas[ marStCodigo=" + marStCodigo + " ]";
    }
    
}
