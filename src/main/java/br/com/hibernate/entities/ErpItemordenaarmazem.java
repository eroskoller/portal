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
@Table(name = "ERP_ITEMORDENAARMAZEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpItemordenaarmazem.findAll", query = "SELECT e FROM ErpItemordenaarmazem e"),
    @NamedQuery(name = "ErpItemordenaarmazem.findByIoaInCodigo", query = "SELECT e FROM ErpItemordenaarmazem e WHERE e.ioaInCodigo = :ioaInCodigo"),
    @NamedQuery(name = "ErpItemordenaarmazem.findByItmStCodigo", query = "SELECT e FROM ErpItemordenaarmazem e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpItemordenaarmazem.findByIoaStDescricao", query = "SELECT e FROM ErpItemordenaarmazem e WHERE e.ioaStDescricao = :ioaStDescricao"),
    @NamedQuery(name = "ErpItemordenaarmazem.findByIoaStPosicao1", query = "SELECT e FROM ErpItemordenaarmazem e WHERE e.ioaStPosicao1 = :ioaStPosicao1"),
    @NamedQuery(name = "ErpItemordenaarmazem.findByIoaStPosicao2", query = "SELECT e FROM ErpItemordenaarmazem e WHERE e.ioaStPosicao2 = :ioaStPosicao2"),
    @NamedQuery(name = "ErpItemordenaarmazem.findByIoaStPosicao3", query = "SELECT e FROM ErpItemordenaarmazem e WHERE e.ioaStPosicao3 = :ioaStPosicao3")})
public class ErpItemordenaarmazem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "IOA_IN_CODIGO")
    private BigInteger ioaInCodigo;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IOA_ST_DESCRICAO")
    private String ioaStDescricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IOA_ST_POSICAO1")
    private String ioaStPosicao1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IOA_ST_POSICAO2")
    private String ioaStPosicao2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IOA_ST_POSICAO3")
    private String ioaStPosicao3;

    public ErpItemordenaarmazem() {
    }

    public ErpItemordenaarmazem(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public ErpItemordenaarmazem(String itmStCodigo, String ioaStDescricao, String ioaStPosicao1, String ioaStPosicao2, String ioaStPosicao3) {
        this.itmStCodigo = itmStCodigo;
        this.ioaStDescricao = ioaStDescricao;
        this.ioaStPosicao1 = ioaStPosicao1;
        this.ioaStPosicao2 = ioaStPosicao2;
        this.ioaStPosicao3 = ioaStPosicao3;
    }

    public BigInteger getIoaInCodigo() {
        return ioaInCodigo;
    }

    public void setIoaInCodigo(BigInteger ioaInCodigo) {
        this.ioaInCodigo = ioaInCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getIoaStDescricao() {
        return ioaStDescricao;
    }

    public void setIoaStDescricao(String ioaStDescricao) {
        this.ioaStDescricao = ioaStDescricao;
    }

    public String getIoaStPosicao1() {
        return ioaStPosicao1;
    }

    public void setIoaStPosicao1(String ioaStPosicao1) {
        this.ioaStPosicao1 = ioaStPosicao1;
    }

    public String getIoaStPosicao2() {
        return ioaStPosicao2;
    }

    public void setIoaStPosicao2(String ioaStPosicao2) {
        this.ioaStPosicao2 = ioaStPosicao2;
    }

    public String getIoaStPosicao3() {
        return ioaStPosicao3;
    }

    public void setIoaStPosicao3(String ioaStPosicao3) {
        this.ioaStPosicao3 = ioaStPosicao3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemordenaarmazem)) {
            return false;
        }
        ErpItemordenaarmazem other = (ErpItemordenaarmazem) object;
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemordenaarmazem[ itmStCodigo=" + itmStCodigo + " ]";
    }
    
}
