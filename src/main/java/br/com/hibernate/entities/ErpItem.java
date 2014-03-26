/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpItem.findAll", query = "SELECT e FROM ErpItem e"),
    @NamedQuery(name = "ErpItem.findByItmStCodigo", query = "SELECT e FROM ErpItem e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpItem.findByItmStDescricao", query = "SELECT e FROM ErpItem e WHERE e.itmStDescricao = :itmStDescricao"),
    @NamedQuery(name = "ErpItem.findByItmStUnidade", query = "SELECT e FROM ErpItem e WHERE e.itmStUnidade = :itmStUnidade"),
    @NamedQuery(name = "ErpItem.findByItmChAtivo", query = "SELECT e FROM ErpItem e WHERE e.itmChAtivo = :itmChAtivo"),
    @NamedQuery(name = "ErpItem.findByItmStFamilia", query = "SELECT e FROM ErpItem e WHERE e.itmStFamilia = :itmStFamilia"),
    @NamedQuery(name = "ErpItem.findByItmStPrograma", query = "SELECT e FROM ErpItem e WHERE e.itmStPrograma = :itmStPrograma"),
    @NamedQuery(name = "ErpItem.findByItmDtCriadoem", query = "SELECT e FROM ErpItem e WHERE e.itmDtCriadoem = :itmDtCriadoem"),
    @NamedQuery(name = "ErpItem.findByItmDtAlteradoem", query = "SELECT e FROM ErpItem e WHERE e.itmDtAlteradoem = :itmDtAlteradoem"),
    @NamedQuery(name = "ErpItem.findByItmStMarca", query = "SELECT e FROM ErpItem e WHERE e.itmStMarca = :itmStMarca"),
    @NamedQuery(name = "ErpItem.findByItmStFabricante", query = "SELECT e FROM ErpItem e WHERE e.itmStFabricante = :itmStFabricante"),
    @NamedQuery(name = "ErpItem.findByItmInValor", query = "SELECT e FROM ErpItem e WHERE e.itmInValor = :itmInValor"),
    @NamedQuery(name = "ErpItem.findByItmStImagem", query = "SELECT e FROM ErpItem e WHERE e.itmStImagem = :itmStImagem"),
    @NamedQuery(name = "ErpItem.findByItmChItemdasa", query = "SELECT e FROM ErpItem e WHERE e.itmChItemdasa = :itmChItemdasa"),
    @NamedQuery(name = "ErpItem.findByItmInQtdeminima", query = "SELECT e FROM ErpItem e WHERE e.itmInQtdeminima = :itmInQtdeminima"),
    @NamedQuery(name = "ErpItem.findByItmInPorcentagem", query = "SELECT e FROM ErpItem e WHERE e.itmInPorcentagem = :itmInPorcentagem"),
    @NamedQuery(name = "ErpItem.findByItmInArredondamento", query = "SELECT e FROM ErpItem e WHERE e.itmInArredondamento = :itmInArredondamento"),
    @NamedQuery(name = "ErpItem.findByItmStFormula", query = "SELECT e FROM ErpItem e WHERE e.itmStFormula = :itmStFormula"),
    @NamedQuery(name = "ErpItem.findByItmInQtdedokit", query = "SELECT e FROM ErpItem e WHERE e.itmInQtdedokit = :itmInQtdedokit"),
    @NamedQuery(name = "ErpItem.findByItmChObrigatorioimportacao", query = "SELECT e FROM ErpItem e WHERE e.itmChObrigatorioimportacao = :itmChObrigatorioimportacao"),
    @NamedQuery(name = "ErpItem.findByItmStRecipientes", query = "SELECT e FROM ErpItem e WHERE e.itmStRecipientes = :itmStRecipientes"),
    @NamedQuery(name = "ErpItem.findByItmChItemmanual", query = "SELECT e FROM ErpItem e WHERE e.itmChItemmanual = :itmChItemmanual"),
    @NamedQuery(name = "ErpItem.findByAmzStCodigo", query = "SELECT e FROM ErpItem e WHERE e.amzStCodigo = :amzStCodigo"),
    @NamedQuery(name = "ErpItem.findByFdoStCodigo", query = "SELECT e FROM ErpItem e WHERE e.fdoStCodigo = :fdoStCodigo"),
    @NamedQuery(name = "ErpItem.findByItmChObrigatoriolote", query = "SELECT e FROM ErpItem e WHERE e.itmChObrigatoriolote = :itmChObrigatoriolote"),
    @NamedQuery(name = "ErpItem.findByItmChObrigatoriovalidade", query = "SELECT e FROM ErpItem e WHERE e.itmChObrigatoriovalidade = :itmChObrigatoriovalidade"),
    @NamedQuery(name = "ErpItem.findByItmStDescricaoOld", query = "SELECT e FROM ErpItem e WHERE e.itmStDescricaoOld = :itmStDescricaoOld"),
    @NamedQuery(name = "ErpItem.findByItmInQtdedigitos", query = "SELECT e FROM ErpItem e WHERE e.itmInQtdedigitos = :itmInQtdedigitos"),
    @NamedQuery(name = "ErpItem.findByTazStCodigo", query = "SELECT e FROM ErpItem e WHERE e.tazStCodigo = :tazStCodigo"),
    @NamedQuery(name = "ErpItem.findByItmChGrupo", query = "SELECT e FROM ErpItem e WHERE e.itmChGrupo = :itmChGrupo")})
public class ErpItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Size(max = 500)
    @Column(name = "ITM_ST_DESCRICAO")
    private String itmStDescricao;
    @Size(max = 20)
    @Column(name = "ITM_ST_UNIDADE")
    private String itmStUnidade;
    @Column(name = "ITM_CH_ATIVO")
    private Character itmChAtivo;
    @Size(max = 20)
    @Column(name = "ITM_ST_FAMILIA")
    private String itmStFamilia;
    @Size(max = 3)
    @Column(name = "ITM_ST_PROGRAMA")
    private String itmStPrograma;
    @Column(name = "ITM_DT_CRIADOEM")
    @Temporal(TemporalType.DATE)
    private Date itmDtCriadoem;
    @Column(name = "ITM_DT_ALTERADOEM")
    @Temporal(TemporalType.DATE)
    private Date itmDtAlteradoem;
    @Size(max = 500)
    @Column(name = "ITM_ST_MARCA")
    private String itmStMarca;
    @Size(max = 500)
    @Column(name = "ITM_ST_FABRICANTE")
    private String itmStFabricante;
    @Column(name = "ITM_IN_VALOR")
    private BigInteger itmInValor;
    @Size(max = 100)
    @Column(name = "ITM_ST_IMAGEM")
    private String itmStImagem;
    @Size(max = 1)
    @Column(name = "ITM_CH_ITEMDASA")
    private String itmChItemdasa;
    @Column(name = "ITM_IN_QTDEMINIMA")
    private BigInteger itmInQtdeminima;
    @Column(name = "ITM_IN_PORCENTAGEM")
    private BigInteger itmInPorcentagem;
    @Column(name = "ITM_IN_ARREDONDAMENTO")
    private BigInteger itmInArredondamento;
    @Size(max = 3000)
    @Column(name = "ITM_ST_FORMULA")
    private String itmStFormula;
    @Column(name = "ITM_IN_QTDEDOKIT")
    private BigInteger itmInQtdedokit;
    @Size(max = 1)
    @Column(name = "ITM_CH_OBRIGATORIOIMPORTACAO")
    private String itmChObrigatorioimportacao;
    @Size(max = 2000)
    @Column(name = "ITM_ST_RECIPIENTES")
    private String itmStRecipientes;
    @Size(max = 1)
    @Column(name = "ITM_CH_ITEMMANUAL")
    private String itmChItemmanual;
    @Size(max = 5)
    @Column(name = "AMZ_ST_CODIGO")
    private String amzStCodigo;
    @Size(max = 6)
    @Column(name = "FDO_ST_CODIGO")
    private String fdoStCodigo;
    @Size(max = 1)
    @Column(name = "ITM_CH_OBRIGATORIOLOTE")
    private String itmChObrigatoriolote;
    @Size(max = 1)
    @Column(name = "ITM_CH_OBRIGATORIOVALIDADE")
    private String itmChObrigatoriovalidade;
    @Size(max = 500)
    @Column(name = "ITM_ST_DESCRICAO_OLD")
    private String itmStDescricaoOld;
    @Column(name = "ITM_IN_QTDEDIGITOS")
    private BigInteger itmInQtdedigitos;
    @Size(max = 5)
    @Column(name = "TAZ_ST_CODIGO")
    private String tazStCodigo;
    @Size(max = 1)
    @Column(name = "ITM_CH_GRUPO")
    private String itmChGrupo;

    public ErpItem() {
    }

    public ErpItem(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public ErpItem(String itmStCodigo, String itmStDescricao) {
        this.itmStCodigo = itmStCodigo;
        this.itmStDescricao = itmStDescricao;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
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

    public Character getItmChAtivo() {
        return itmChAtivo;
    }

    public void setItmChAtivo(Character itmChAtivo) {
        this.itmChAtivo = itmChAtivo;
    }

    public String getItmStFamilia() {
        return itmStFamilia;
    }

    public void setItmStFamilia(String itmStFamilia) {
        this.itmStFamilia = itmStFamilia;
    }

    public String getItmStPrograma() {
        return itmStPrograma;
    }

    public void setItmStPrograma(String itmStPrograma) {
        this.itmStPrograma = itmStPrograma;
    }

    public Date getItmDtCriadoem() {
        return itmDtCriadoem;
    }

    public void setItmDtCriadoem(Date itmDtCriadoem) {
        this.itmDtCriadoem = itmDtCriadoem;
    }

    public Date getItmDtAlteradoem() {
        return itmDtAlteradoem;
    }

    public void setItmDtAlteradoem(Date itmDtAlteradoem) {
        this.itmDtAlteradoem = itmDtAlteradoem;
    }

    public String getItmStMarca() {
        return itmStMarca;
    }

    public void setItmStMarca(String itmStMarca) {
        this.itmStMarca = itmStMarca;
    }

    public String getItmStFabricante() {
        return itmStFabricante;
    }

    public void setItmStFabricante(String itmStFabricante) {
        this.itmStFabricante = itmStFabricante;
    }

    public BigInteger getItmInValor() {
        return itmInValor;
    }

    public void setItmInValor(BigInteger itmInValor) {
        this.itmInValor = itmInValor;
    }

    public String getItmStImagem() {
        return itmStImagem;
    }

    public void setItmStImagem(String itmStImagem) {
        this.itmStImagem = itmStImagem;
    }

    public String getItmChItemdasa() {
        return itmChItemdasa;
    }

    public void setItmChItemdasa(String itmChItemdasa) {
        this.itmChItemdasa = itmChItemdasa;
    }

    public BigInteger getItmInQtdeminima() {
        return itmInQtdeminima;
    }

    public void setItmInQtdeminima(BigInteger itmInQtdeminima) {
        this.itmInQtdeminima = itmInQtdeminima;
    }

    public BigInteger getItmInPorcentagem() {
        return itmInPorcentagem;
    }

    public void setItmInPorcentagem(BigInteger itmInPorcentagem) {
        this.itmInPorcentagem = itmInPorcentagem;
    }

    public BigInteger getItmInArredondamento() {
        return itmInArredondamento;
    }

    public void setItmInArredondamento(BigInteger itmInArredondamento) {
        this.itmInArredondamento = itmInArredondamento;
    }

    public String getItmStFormula() {
        return itmStFormula;
    }

    public void setItmStFormula(String itmStFormula) {
        this.itmStFormula = itmStFormula;
    }

    public BigInteger getItmInQtdedokit() {
        return itmInQtdedokit;
    }

    public void setItmInQtdedokit(BigInteger itmInQtdedokit) {
        this.itmInQtdedokit = itmInQtdedokit;
    }

    public String getItmChObrigatorioimportacao() {
        return itmChObrigatorioimportacao;
    }

    public void setItmChObrigatorioimportacao(String itmChObrigatorioimportacao) {
        this.itmChObrigatorioimportacao = itmChObrigatorioimportacao;
    }

    public String getItmStRecipientes() {
        return itmStRecipientes;
    }

    public void setItmStRecipientes(String itmStRecipientes) {
        this.itmStRecipientes = itmStRecipientes;
    }

    public String getItmChItemmanual() {
        return itmChItemmanual;
    }

    public void setItmChItemmanual(String itmChItemmanual) {
        this.itmChItemmanual = itmChItemmanual;
    }

    public String getAmzStCodigo() {
        return amzStCodigo;
    }

    public void setAmzStCodigo(String amzStCodigo) {
        this.amzStCodigo = amzStCodigo;
    }

    public String getFdoStCodigo() {
        return fdoStCodigo;
    }

    public void setFdoStCodigo(String fdoStCodigo) {
        this.fdoStCodigo = fdoStCodigo;
    }

    public String getItmChObrigatoriolote() {
        return itmChObrigatoriolote;
    }

    public void setItmChObrigatoriolote(String itmChObrigatoriolote) {
        this.itmChObrigatoriolote = itmChObrigatoriolote;
    }

    public String getItmChObrigatoriovalidade() {
        return itmChObrigatoriovalidade;
    }

    public void setItmChObrigatoriovalidade(String itmChObrigatoriovalidade) {
        this.itmChObrigatoriovalidade = itmChObrigatoriovalidade;
    }

    public String getItmStDescricaoOld() {
        return itmStDescricaoOld;
    }

    public void setItmStDescricaoOld(String itmStDescricaoOld) {
        this.itmStDescricaoOld = itmStDescricaoOld;
    }

    public BigInteger getItmInQtdedigitos() {
        return itmInQtdedigitos;
    }

    public void setItmInQtdedigitos(BigInteger itmInQtdedigitos) {
        this.itmInQtdedigitos = itmInQtdedigitos;
    }

    public String getTazStCodigo() {
        return tazStCodigo;
    }

    public void setTazStCodigo(String tazStCodigo) {
        this.tazStCodigo = tazStCodigo;
    }

    public String getItmChGrupo() {
        return itmChGrupo;
    }

    public void setItmChGrupo(String itmChGrupo) {
        this.itmChGrupo = itmChGrupo;
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
        if (!(object instanceof ErpItem)) {
            return false;
        }
        ErpItem other = (ErpItem) object;
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItem[ itmStCodigo=" + itmStCodigo + " ]";
    }
    
}
