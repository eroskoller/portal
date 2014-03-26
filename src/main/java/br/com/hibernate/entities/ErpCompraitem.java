/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_COMPRAITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpCompraitem.findAll", query = "SELECT e FROM ErpCompraitem e"),
    @NamedQuery(name = "ErpCompraitem.findByCprInCodigo", query = "SELECT e FROM ErpCompraitem e WHERE e.erpCompraitemPK.cprInCodigo = :cprInCodigo"),
    @NamedQuery(name = "ErpCompraitem.findByItmStCodigo", query = "SELECT e FROM ErpCompraitem e WHERE e.erpCompraitemPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpCompraitem.findByItmStDescricao", query = "SELECT e FROM ErpCompraitem e WHERE e.itmStDescricao = :itmStDescricao"),
    @NamedQuery(name = "ErpCompraitem.findByItmStUnidade", query = "SELECT e FROM ErpCompraitem e WHERE e.itmStUnidade = :itmStUnidade"),
    @NamedQuery(name = "ErpCompraitem.findByCpiInSequencia", query = "SELECT e FROM ErpCompraitem e WHERE e.cpiInSequencia = :cpiInSequencia"),
    @NamedQuery(name = "ErpCompraitem.findByCpiInQtde", query = "SELECT e FROM ErpCompraitem e WHERE e.cpiInQtde = :cpiInQtde"),
    @NamedQuery(name = "ErpCompraitem.findByCpiInQtdeatendida", query = "SELECT e FROM ErpCompraitem e WHERE e.cpiInQtdeatendida = :cpiInQtdeatendida"),
    @NamedQuery(name = "ErpCompraitem.findByCpiFlPreco", query = "SELECT e FROM ErpCompraitem e WHERE e.cpiFlPreco = :cpiFlPreco"),
    @NamedQuery(name = "ErpCompraitem.findByCpiChPrioridade", query = "SELECT e FROM ErpCompraitem e WHERE e.cpiChPrioridade = :cpiChPrioridade"),
    @NamedQuery(name = "ErpCompraitem.findByCpiChAtivo", query = "SELECT e FROM ErpCompraitem e WHERE e.cpiChAtivo = :cpiChAtivo"),
    @NamedQuery(name = "ErpCompraitem.findByCpiInQtdeautorizada", query = "SELECT e FROM ErpCompraitem e WHERE e.cpiInQtdeautorizada = :cpiInQtdeautorizada")})
public class ErpCompraitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpCompraitemPK erpCompraitemPK;
    @Size(max = 2000)
    @Column(name = "ITM_ST_DESCRICAO")
    private String itmStDescricao;
    @Size(max = 20)
    @Column(name = "ITM_ST_UNIDADE")
    private String itmStUnidade;
    @Column(name = "CPI_IN_SEQUENCIA")
    private BigInteger cpiInSequencia;
    @Column(name = "CPI_IN_QTDE")
    private BigInteger cpiInQtde;
    @Column(name = "CPI_IN_QTDEATENDIDA")
    private BigInteger cpiInQtdeatendida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CPI_FL_PRECO")
    private BigDecimal cpiFlPreco;
    @Size(max = 1)
    @Column(name = "CPI_CH_PRIORIDADE")
    private String cpiChPrioridade;
    @Size(max = 1)
    @Column(name = "CPI_CH_ATIVO")
    private String cpiChAtivo;
    @Column(name = "CPI_IN_QTDEAUTORIZADA")
    private BigInteger cpiInQtdeautorizada;

    public ErpCompraitem() {
    }

    public ErpCompraitem(ErpCompraitemPK erpCompraitemPK) {
        this.erpCompraitemPK = erpCompraitemPK;
    }

    public ErpCompraitem(BigInteger cprInCodigo, String itmStCodigo) {
        this.erpCompraitemPK = new ErpCompraitemPK(cprInCodigo, itmStCodigo);
    }

    public ErpCompraitemPK getErpCompraitemPK() {
        return erpCompraitemPK;
    }

    public void setErpCompraitemPK(ErpCompraitemPK erpCompraitemPK) {
        this.erpCompraitemPK = erpCompraitemPK;
    }

    public String getItmStDescricao() {
        return itmStDescricao;
    }

    public void setItmStDescricao(String itmStDescricao) {
        this.itmStDescricao = itmStDescricao;
    }

    public String getItmStUnidade() {
        return itmStUnidade;
    }

    public void setItmStUnidade(String itmStUnidade) {
        this.itmStUnidade = itmStUnidade;
    }

    public BigInteger getCpiInSequencia() {
        return cpiInSequencia;
    }

    public void setCpiInSequencia(BigInteger cpiInSequencia) {
        this.cpiInSequencia = cpiInSequencia;
    }

    public BigInteger getCpiInQtde() {
        return cpiInQtde;
    }

    public void setCpiInQtde(BigInteger cpiInQtde) {
        this.cpiInQtde = cpiInQtde;
    }

    public BigInteger getCpiInQtdeatendida() {
        return cpiInQtdeatendida;
    }

    public void setCpiInQtdeatendida(BigInteger cpiInQtdeatendida) {
        this.cpiInQtdeatendida = cpiInQtdeatendida;
    }

    public BigDecimal getCpiFlPreco() {
        return cpiFlPreco;
    }

    public void setCpiFlPreco(BigDecimal cpiFlPreco) {
        this.cpiFlPreco = cpiFlPreco;
    }

    public String getCpiChPrioridade() {
        return cpiChPrioridade;
    }

    public void setCpiChPrioridade(String cpiChPrioridade) {
        this.cpiChPrioridade = cpiChPrioridade;
    }

    public String getCpiChAtivo() {
        return cpiChAtivo;
    }

    public void setCpiChAtivo(String cpiChAtivo) {
        this.cpiChAtivo = cpiChAtivo;
    }

    public BigInteger getCpiInQtdeautorizada() {
        return cpiInQtdeautorizada;
    }

    public void setCpiInQtdeautorizada(BigInteger cpiInQtdeautorizada) {
        this.cpiInQtdeautorizada = cpiInQtdeautorizada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpCompraitemPK != null ? erpCompraitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCompraitem)) {
            return false;
        }
        ErpCompraitem other = (ErpCompraitem) object;
        if ((this.erpCompraitemPK == null && other.erpCompraitemPK != null) || (this.erpCompraitemPK != null && !this.erpCompraitemPK.equals(other.erpCompraitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCompraitem[ erpCompraitemPK=" + erpCompraitemPK + " ]";
    }
    
}
