/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_MODULOPRODUTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpModuloprodutos.findAll", query = "SELECT e FROM ErpModuloprodutos e"),
    @NamedQuery(name = "ErpModuloprodutos.findByMprStCodigo", query = "SELECT e FROM ErpModuloprodutos e WHERE e.mprStCodigo = :mprStCodigo"),
    @NamedQuery(name = "ErpModuloprodutos.findByMprStDescricao", query = "SELECT e FROM ErpModuloprodutos e WHERE e.mprStDescricao = :mprStDescricao"),
    @NamedQuery(name = "ErpModuloprodutos.findByMprChVisualiza", query = "SELECT e FROM ErpModuloprodutos e WHERE e.mprChVisualiza = :mprChVisualiza"),
    @NamedQuery(name = "ErpModuloprodutos.findByMprStArquivo", query = "SELECT e FROM ErpModuloprodutos e WHERE e.mprStArquivo = :mprStArquivo"),
    @NamedQuery(name = "ErpModuloprodutos.findByMprStTipo", query = "SELECT e FROM ErpModuloprodutos e WHERE e.mprStTipo = :mprStTipo"),
    @NamedQuery(name = "ErpModuloprodutos.findByMprInSequencia", query = "SELECT e FROM ErpModuloprodutos e WHERE e.mprInSequencia = :mprInSequencia"),
    @NamedQuery(name = "ErpModuloprodutos.findByMprStMenupai", query = "SELECT e FROM ErpModuloprodutos e WHERE e.mprStMenupai = :mprStMenupai")})
public class ErpModuloprodutos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "MPR_ST_CODIGO")
    private String mprStCodigo;
    @Size(max = 500)
    @Column(name = "MPR_ST_DESCRICAO")
    private String mprStDescricao;
    @Size(max = 1)
    @Column(name = "MPR_CH_VISUALIZA")
    private String mprChVisualiza;
    @Size(max = 100)
    @Column(name = "MPR_ST_ARQUIVO")
    private String mprStArquivo;
    @Size(max = 50)
    @Column(name = "MPR_ST_TIPO")
    private String mprStTipo;
    @Column(name = "MPR_IN_SEQUENCIA")
    private BigInteger mprInSequencia;
    @Size(max = 6)
    @Column(name = "MPR_ST_MENUPAI")
    private String mprStMenupai;

    public ErpModuloprodutos() {
    }

    public ErpModuloprodutos(String mprStCodigo) {
        this.mprStCodigo = mprStCodigo;
    }

    public String getMprStCodigo() {
        return mprStCodigo;
    }

    public void setMprStCodigo(String mprStCodigo) {
        this.mprStCodigo = mprStCodigo;
    }

    public String getMprStDescricao() {
        return mprStDescricao;
    }

    public void setMprStDescricao(String mprStDescricao) {
        this.mprStDescricao = mprStDescricao;
    }

    public String getMprChVisualiza() {
        return mprChVisualiza;
    }

    public void setMprChVisualiza(String mprChVisualiza) {
        this.mprChVisualiza = mprChVisualiza;
    }

    public String getMprStArquivo() {
        return mprStArquivo;
    }

    public void setMprStArquivo(String mprStArquivo) {
        this.mprStArquivo = mprStArquivo;
    }

    public String getMprStTipo() {
        return mprStTipo;
    }

    public void setMprStTipo(String mprStTipo) {
        this.mprStTipo = mprStTipo;
    }

    public BigInteger getMprInSequencia() {
        return mprInSequencia;
    }

    public void setMprInSequencia(BigInteger mprInSequencia) {
        this.mprInSequencia = mprInSequencia;
    }

    public String getMprStMenupai() {
        return mprStMenupai;
    }

    public void setMprStMenupai(String mprStMenupai) {
        this.mprStMenupai = mprStMenupai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mprStCodigo != null ? mprStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpModuloprodutos)) {
            return false;
        }
        ErpModuloprodutos other = (ErpModuloprodutos) object;
        if ((this.mprStCodigo == null && other.mprStCodigo != null) || (this.mprStCodigo != null && !this.mprStCodigo.equals(other.mprStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpModuloprodutos[ mprStCodigo=" + mprStCodigo + " ]";
    }
    
}
