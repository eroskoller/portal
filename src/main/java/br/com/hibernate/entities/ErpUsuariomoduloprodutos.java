/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_USUARIOMODULOPRODUTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpUsuariomoduloprodutos.findAll", query = "SELECT e FROM ErpUsuariomoduloprodutos e"),
    @NamedQuery(name = "ErpUsuariomoduloprodutos.findByUsuStCodigo", query = "SELECT e FROM ErpUsuariomoduloprodutos e WHERE e.erpUsuariomoduloprodutosPK.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpUsuariomoduloprodutos.findByMprStCodigo", query = "SELECT e FROM ErpUsuariomoduloprodutos e WHERE e.erpUsuariomoduloprodutosPK.mprStCodigo = :mprStCodigo"),
    @NamedQuery(name = "ErpUsuariomoduloprodutos.findByUmpChOpcao1", query = "SELECT e FROM ErpUsuariomoduloprodutos e WHERE e.umpChOpcao1 = :umpChOpcao1"),
    @NamedQuery(name = "ErpUsuariomoduloprodutos.findByUmpChOpcao2", query = "SELECT e FROM ErpUsuariomoduloprodutos e WHERE e.umpChOpcao2 = :umpChOpcao2")})
public class ErpUsuariomoduloprodutos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpUsuariomoduloprodutosPK erpUsuariomoduloprodutosPK;
    @Size(max = 1)
    @Column(name = "UMP_CH_OPCAO1")
    private String umpChOpcao1;
    @Size(max = 1)
    @Column(name = "UMP_CH_OPCAO2")
    private String umpChOpcao2;

    public ErpUsuariomoduloprodutos() {
    }

    public ErpUsuariomoduloprodutos(ErpUsuariomoduloprodutosPK erpUsuariomoduloprodutosPK) {
        this.erpUsuariomoduloprodutosPK = erpUsuariomoduloprodutosPK;
    }

    public ErpUsuariomoduloprodutos(String usuStCodigo, String mprStCodigo) {
        this.erpUsuariomoduloprodutosPK = new ErpUsuariomoduloprodutosPK(usuStCodigo, mprStCodigo);
    }

    public ErpUsuariomoduloprodutosPK getErpUsuariomoduloprodutosPK() {
        return erpUsuariomoduloprodutosPK;
    }

    public void setErpUsuariomoduloprodutosPK(ErpUsuariomoduloprodutosPK erpUsuariomoduloprodutosPK) {
        this.erpUsuariomoduloprodutosPK = erpUsuariomoduloprodutosPK;
    }

    public String getUmpChOpcao1() {
        return umpChOpcao1;
    }

    public void setUmpChOpcao1(String umpChOpcao1) {
        this.umpChOpcao1 = umpChOpcao1;
    }

    public String getUmpChOpcao2() {
        return umpChOpcao2;
    }

    public void setUmpChOpcao2(String umpChOpcao2) {
        this.umpChOpcao2 = umpChOpcao2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpUsuariomoduloprodutosPK != null ? erpUsuariomoduloprodutosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpUsuariomoduloprodutos)) {
            return false;
        }
        ErpUsuariomoduloprodutos other = (ErpUsuariomoduloprodutos) object;
        if ((this.erpUsuariomoduloprodutosPK == null && other.erpUsuariomoduloprodutosPK != null) || (this.erpUsuariomoduloprodutosPK != null && !this.erpUsuariomoduloprodutosPK.equals(other.erpUsuariomoduloprodutosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpUsuariomoduloprodutos[ erpUsuariomoduloprodutosPK=" + erpUsuariomoduloprodutosPK + " ]";
    }
    
}
