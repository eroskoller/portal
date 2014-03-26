/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_ITEMXCC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpItemxcc.findAll", query = "SELECT e FROM ErpItemxcc e"),
    @NamedQuery(name = "ErpItemxcc.findByCcuStCodigo", query = "SELECT e FROM ErpItemxcc e WHERE e.erpItemxccPK.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpItemxcc.findByItmStCodigo", query = "SELECT e FROM ErpItemxcc e WHERE e.erpItemxccPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpItemxcc.findByItcChAtivo", query = "SELECT e FROM ErpItemxcc e WHERE e.itcChAtivo = :itcChAtivo"),
    @NamedQuery(name = "ErpItemxcc.findByItcInQtde", query = "SELECT e FROM ErpItemxcc e WHERE e.itcInQtde = :itcInQtde"),
    @NamedQuery(name = "ErpItemxcc.findByItcInPrazo", query = "SELECT e FROM ErpItemxcc e WHERE e.itcInPrazo = :itcInPrazo"),
    @NamedQuery(name = "ErpItemxcc.findByEstStFiscal", query = "SELECT e FROM ErpItemxcc e WHERE e.estStFiscal = :estStFiscal"),
    @NamedQuery(name = "ErpItemxcc.findByItcInPorcentagem", query = "SELECT e FROM ErpItemxcc e WHERE e.itcInPorcentagem = :itcInPorcentagem"),
    @NamedQuery(name = "ErpItemxcc.findByItcInArredondamento", query = "SELECT e FROM ErpItemxcc e WHERE e.itcInArredondamento = :itcInArredondamento"),
    @NamedQuery(name = "ErpItemxcc.findByItcStFormula", query = "SELECT e FROM ErpItemxcc e WHERE e.itcStFormula = :itcStFormula"),
    @NamedQuery(name = "ErpItemxcc.findByItcChObrigatorioimportacao", query = "SELECT e FROM ErpItemxcc e WHERE e.itcChObrigatorioimportacao = :itcChObrigatorioimportacao"),
    @NamedQuery(name = "ErpItemxcc.findByItcChItemmanual", query = "SELECT e FROM ErpItemxcc e WHERE e.itcChItemmanual = :itcChItemmanual"),
    @NamedQuery(name = "ErpItemxcc.findByItcChNaousaqtdeminima", query = "SELECT e FROM ErpItemxcc e WHERE e.itcChNaousaqtdeminima = :itcChNaousaqtdeminima"),
    @NamedQuery(name = "ErpItemxcc.findByItcStRecipientes", query = "SELECT e FROM ErpItemxcc e WHERE e.itcStRecipientes = :itcStRecipientes")})
public class ErpItemxcc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpItemxccPK erpItemxccPK;
    @Column(name = "ITC_CH_ATIVO")
    private Character itcChAtivo;
    @Column(name = "ITC_IN_QTDE")
    private BigInteger itcInQtde;
    @Column(name = "ITC_IN_PRAZO")
    private BigInteger itcInPrazo;
    @Size(max = 3)
    @Column(name = "EST_ST_FISCAL")
    private String estStFiscal;
    @Column(name = "ITC_IN_PORCENTAGEM")
    private BigInteger itcInPorcentagem;
    @Column(name = "ITC_IN_ARREDONDAMENTO")
    private BigInteger itcInArredondamento;
    @Size(max = 3000)
    @Column(name = "ITC_ST_FORMULA")
    private String itcStFormula;
    @Size(max = 1)
    @Column(name = "ITC_CH_OBRIGATORIOIMPORTACAO")
    private String itcChObrigatorioimportacao;
    @Size(max = 1)
    @Column(name = "ITC_CH_ITEMMANUAL")
    private String itcChItemmanual;
    @Size(max = 1)
    @Column(name = "ITC_CH_NAOUSAQTDEMINIMA")
    private String itcChNaousaqtdeminima;
    @Size(max = 2000)
    @Column(name = "ITC_ST_RECIPIENTES")
    private String itcStRecipientes;

    public ErpItemxcc() {
    }

    public ErpItemxcc(ErpItemxccPK erpItemxccPK) {
        this.erpItemxccPK = erpItemxccPK;
    }

    public ErpItemxcc(String ccuStCodigo, String itmStCodigo) {
        this.erpItemxccPK = new ErpItemxccPK(ccuStCodigo, itmStCodigo);
    }

    public ErpItemxccPK getErpItemxccPK() {
        return erpItemxccPK;
    }

    public void setErpItemxccPK(ErpItemxccPK erpItemxccPK) {
        this.erpItemxccPK = erpItemxccPK;
    }

    public Character getItcChAtivo() {
        return itcChAtivo;
    }

    public void setItcChAtivo(Character itcChAtivo) {
        this.itcChAtivo = itcChAtivo;
    }

    public BigInteger getItcInQtde() {
        return itcInQtde;
    }

    public void setItcInQtde(BigInteger itcInQtde) {
        this.itcInQtde = itcInQtde;
    }

    public BigInteger getItcInPrazo() {
        return itcInPrazo;
    }

    public void setItcInPrazo(BigInteger itcInPrazo) {
        this.itcInPrazo = itcInPrazo;
    }

    public String getEstStFiscal() {
        return estStFiscal;
    }

    public void setEstStFiscal(String estStFiscal) {
        this.estStFiscal = estStFiscal;
    }

    public BigInteger getItcInPorcentagem() {
        return itcInPorcentagem;
    }

    public void setItcInPorcentagem(BigInteger itcInPorcentagem) {
        this.itcInPorcentagem = itcInPorcentagem;
    }

    public BigInteger getItcInArredondamento() {
        return itcInArredondamento;
    }

    public void setItcInArredondamento(BigInteger itcInArredondamento) {
        this.itcInArredondamento = itcInArredondamento;
    }

    public String getItcStFormula() {
        return itcStFormula;
    }

    public void setItcStFormula(String itcStFormula) {
        this.itcStFormula = itcStFormula;
    }

    public String getItcChObrigatorioimportacao() {
        return itcChObrigatorioimportacao;
    }

    public void setItcChObrigatorioimportacao(String itcChObrigatorioimportacao) {
        this.itcChObrigatorioimportacao = itcChObrigatorioimportacao;
    }

    public String getItcChItemmanual() {
        return itcChItemmanual;
    }

    public void setItcChItemmanual(String itcChItemmanual) {
        this.itcChItemmanual = itcChItemmanual;
    }

    public String getItcChNaousaqtdeminima() {
        return itcChNaousaqtdeminima;
    }

    public void setItcChNaousaqtdeminima(String itcChNaousaqtdeminima) {
        this.itcChNaousaqtdeminima = itcChNaousaqtdeminima;
    }

    public String getItcStRecipientes() {
        return itcStRecipientes;
    }

    public void setItcStRecipientes(String itcStRecipientes) {
        this.itcStRecipientes = itcStRecipientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpItemxccPK != null ? erpItemxccPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemxcc)) {
            return false;
        }
        ErpItemxcc other = (ErpItemxcc) object;
        if ((this.erpItemxccPK == null && other.erpItemxccPK != null) || (this.erpItemxccPK != null && !this.erpItemxccPK.equals(other.erpItemxccPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemxcc[ erpItemxccPK=" + erpItemxccPK + " ]";
    }
    
}
