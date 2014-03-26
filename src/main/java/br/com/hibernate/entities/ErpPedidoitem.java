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
@Table(name = "ERP_PEDIDOITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpPedidoitem.findAll", query = "SELECT e FROM ErpPedidoitem e"),
    @NamedQuery(name = "ErpPedidoitem.findByPedInCodigo", query = "SELECT e FROM ErpPedidoitem e WHERE e.erpPedidoitemPK.pedInCodigo = :pedInCodigo"),
    @NamedQuery(name = "ErpPedidoitem.findByItmStCodigo", query = "SELECT e FROM ErpPedidoitem e WHERE e.erpPedidoitemPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInQtde", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInQtde = :peiInQtde"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInQtdeatendida", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInQtdeatendida = :peiInQtdeatendida"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiStLote", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiStLote = :peiStLote"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiChAtivo", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiChAtivo = :peiChAtivo"),
    @NamedQuery(name = "ErpPedidoitem.findByEstStFiscal", query = "SELECT e FROM ErpPedidoitem e WHERE e.estStFiscal = :estStFiscal"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiChExportado", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiChExportado = :peiChExportado"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiChNaoautorizado", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiChNaoautorizado = :peiChNaoautorizado"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInTransferidoDe", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInTransferidoDe = :peiInTransferidoDe"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInTransferidoPara", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInTransferidoPara = :peiInTransferidoPara"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiDtTransferido", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiDtTransferido = :peiDtTransferido"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInQtdeentregue", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInQtdeentregue = :peiInQtdeentregue"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiStMotivoaceite", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiStMotivoaceite = :peiStMotivoaceite"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInSequencia", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInSequencia = :peiInSequencia"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInQtdependente", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInQtdependente = :peiInQtdependente"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiChSeparado", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiChSeparado = :peiChSeparado"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiChConfirmado", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiChConfirmado = :peiChConfirmado"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInEstoqueunidade", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInEstoqueunidade = :peiInEstoqueunidade"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInCodigoreferente", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInCodigoreferente = :peiInCodigoreferente"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiChExportadonaoativo", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiChExportadonaoativo = :peiChExportadonaoativo"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInQtdeautorizada", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInQtdeautorizada = :peiInQtdeautorizada"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiInQtdeatendidaEms", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiInQtdeatendidaEms = :peiInQtdeatendidaEms"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiStLoteEms", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiStLoteEms = :peiStLoteEms"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiDtValidadeEms", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiDtValidadeEms = :peiDtValidadeEms"),
    @NamedQuery(name = "ErpPedidoitem.findByIprDtValidade", query = "SELECT e FROM ErpPedidoitem e WHERE e.iprDtValidade = :iprDtValidade"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiChPendenciadescartada", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiChPendenciadescartada = :peiChPendenciadescartada"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiChItemvalidado", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiChItemvalidado = :peiChItemvalidado"),
    @NamedQuery(name = "ErpPedidoitem.findByPeiDtValidacao", query = "SELECT e FROM ErpPedidoitem e WHERE e.peiDtValidacao = :peiDtValidacao")})
public class ErpPedidoitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpPedidoitemPK erpPedidoitemPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEI_IN_QTDE")
    private BigInteger peiInQtde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEI_IN_QTDEATENDIDA")
    private BigInteger peiInQtdeatendida;
    @Size(max = 20)
    @Column(name = "PEI_ST_LOTE")
    private String peiStLote;
    @Size(max = 1)
    @Column(name = "PEI_CH_ATIVO")
    private String peiChAtivo;
    @Size(max = 3)
    @Column(name = "EST_ST_FISCAL")
    private String estStFiscal;
    @Size(max = 1)
    @Column(name = "PEI_CH_EXPORTADO")
    private String peiChExportado;
    @Size(max = 1)
    @Column(name = "PEI_CH_NAOAUTORIZADO")
    private String peiChNaoautorizado;
    @Column(name = "PEI_IN_TRANSFERIDO_DE")
    private BigInteger peiInTransferidoDe;
    @Column(name = "PEI_IN_TRANSFERIDO_PARA")
    private BigInteger peiInTransferidoPara;
    @Column(name = "PEI_DT_TRANSFERIDO")
    @Temporal(TemporalType.DATE)
    private Date peiDtTransferido;
    @Column(name = "PEI_IN_QTDEENTREGUE")
    private BigInteger peiInQtdeentregue;
    @Size(max = 3)
    @Column(name = "PEI_ST_MOTIVOACEITE")
    private String peiStMotivoaceite;
    @Column(name = "PEI_IN_SEQUENCIA")
    private BigInteger peiInSequencia;
    @Column(name = "PEI_IN_QTDEPENDENTE")
    private BigInteger peiInQtdependente;
    @Size(max = 1)
    @Column(name = "PEI_CH_SEPARADO")
    private String peiChSeparado;
    @Size(max = 1)
    @Column(name = "PEI_CH_CONFIRMADO")
    private String peiChConfirmado;
    @Column(name = "PEI_IN_ESTOQUEUNIDADE")
    private BigInteger peiInEstoqueunidade;
    @Column(name = "PEI_IN_CODIGOREFERENTE")
    private BigInteger peiInCodigoreferente;
    @Size(max = 1)
    @Column(name = "PEI_CH_EXPORTADONAOATIVO")
    private String peiChExportadonaoativo;
    @Column(name = "PEI_IN_QTDEAUTORIZADA")
    private BigInteger peiInQtdeautorizada;
    @Column(name = "PEI_IN_QTDEATENDIDA_EMS")
    private BigInteger peiInQtdeatendidaEms;
    @Size(max = 20)
    @Column(name = "PEI_ST_LOTE_EMS")
    private String peiStLoteEms;
    @Column(name = "PEI_DT_VALIDADE_EMS")
    @Temporal(TemporalType.DATE)
    private Date peiDtValidadeEms;
    @Column(name = "IPR_DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date iprDtValidade;
    @Size(max = 1)
    @Column(name = "PEI_CH_PENDENCIADESCARTADA")
    private String peiChPendenciadescartada;
    @Size(max = 1)
    @Column(name = "PEI_CH_ITEMVALIDADO")
    private String peiChItemvalidado;
    @Column(name = "PEI_DT_VALIDACAO")
    @Temporal(TemporalType.DATE)
    private Date peiDtValidacao;

    public ErpPedidoitem() {
    }

    public ErpPedidoitem(ErpPedidoitemPK erpPedidoitemPK) {
        this.erpPedidoitemPK = erpPedidoitemPK;
    }

    public ErpPedidoitem(ErpPedidoitemPK erpPedidoitemPK, BigInteger peiInQtde, BigInteger peiInQtdeatendida) {
        this.erpPedidoitemPK = erpPedidoitemPK;
        this.peiInQtde = peiInQtde;
        this.peiInQtdeatendida = peiInQtdeatendida;
    }

    public ErpPedidoitem(BigInteger pedInCodigo, String itmStCodigo) {
        this.erpPedidoitemPK = new ErpPedidoitemPK(pedInCodigo, itmStCodigo);
    }

    public ErpPedidoitemPK getErpPedidoitemPK() {
        return erpPedidoitemPK;
    }

    public void setErpPedidoitemPK(ErpPedidoitemPK erpPedidoitemPK) {
        this.erpPedidoitemPK = erpPedidoitemPK;
    }

    public BigInteger getPeiInQtde() {
        return peiInQtde;
    }

    public void setPeiInQtde(BigInteger peiInQtde) {
        this.peiInQtde = peiInQtde;
    }

    public BigInteger getPeiInQtdeatendida() {
        return peiInQtdeatendida;
    }

    public void setPeiInQtdeatendida(BigInteger peiInQtdeatendida) {
        this.peiInQtdeatendida = peiInQtdeatendida;
    }

    public String getPeiStLote() {
        return peiStLote;
    }

    public void setPeiStLote(String peiStLote) {
        this.peiStLote = peiStLote;
    }

    public String getPeiChAtivo() {
        return peiChAtivo;
    }

    public void setPeiChAtivo(String peiChAtivo) {
        this.peiChAtivo = peiChAtivo;
    }

    public String getEstStFiscal() {
        return estStFiscal;
    }

    public void setEstStFiscal(String estStFiscal) {
        this.estStFiscal = estStFiscal;
    }

    public String getPeiChExportado() {
        return peiChExportado;
    }

    public void setPeiChExportado(String peiChExportado) {
        this.peiChExportado = peiChExportado;
    }

    public String getPeiChNaoautorizado() {
        return peiChNaoautorizado;
    }

    public void setPeiChNaoautorizado(String peiChNaoautorizado) {
        this.peiChNaoautorizado = peiChNaoautorizado;
    }

    public BigInteger getPeiInTransferidoDe() {
        return peiInTransferidoDe;
    }

    public void setPeiInTransferidoDe(BigInteger peiInTransferidoDe) {
        this.peiInTransferidoDe = peiInTransferidoDe;
    }

    public BigInteger getPeiInTransferidoPara() {
        return peiInTransferidoPara;
    }

    public void setPeiInTransferidoPara(BigInteger peiInTransferidoPara) {
        this.peiInTransferidoPara = peiInTransferidoPara;
    }

    public Date getPeiDtTransferido() {
        return peiDtTransferido;
    }

    public void setPeiDtTransferido(Date peiDtTransferido) {
        this.peiDtTransferido = peiDtTransferido;
    }

    public BigInteger getPeiInQtdeentregue() {
        return peiInQtdeentregue;
    }

    public void setPeiInQtdeentregue(BigInteger peiInQtdeentregue) {
        this.peiInQtdeentregue = peiInQtdeentregue;
    }

    public String getPeiStMotivoaceite() {
        return peiStMotivoaceite;
    }

    public void setPeiStMotivoaceite(String peiStMotivoaceite) {
        this.peiStMotivoaceite = peiStMotivoaceite;
    }

    public BigInteger getPeiInSequencia() {
        return peiInSequencia;
    }

    public void setPeiInSequencia(BigInteger peiInSequencia) {
        this.peiInSequencia = peiInSequencia;
    }

    public BigInteger getPeiInQtdependente() {
        return peiInQtdependente;
    }

    public void setPeiInQtdependente(BigInteger peiInQtdependente) {
        this.peiInQtdependente = peiInQtdependente;
    }

    public String getPeiChSeparado() {
        return peiChSeparado;
    }

    public void setPeiChSeparado(String peiChSeparado) {
        this.peiChSeparado = peiChSeparado;
    }

    public String getPeiChConfirmado() {
        return peiChConfirmado;
    }

    public void setPeiChConfirmado(String peiChConfirmado) {
        this.peiChConfirmado = peiChConfirmado;
    }

    public BigInteger getPeiInEstoqueunidade() {
        return peiInEstoqueunidade;
    }

    public void setPeiInEstoqueunidade(BigInteger peiInEstoqueunidade) {
        this.peiInEstoqueunidade = peiInEstoqueunidade;
    }

    public BigInteger getPeiInCodigoreferente() {
        return peiInCodigoreferente;
    }

    public void setPeiInCodigoreferente(BigInteger peiInCodigoreferente) {
        this.peiInCodigoreferente = peiInCodigoreferente;
    }

    public String getPeiChExportadonaoativo() {
        return peiChExportadonaoativo;
    }

    public void setPeiChExportadonaoativo(String peiChExportadonaoativo) {
        this.peiChExportadonaoativo = peiChExportadonaoativo;
    }

    public BigInteger getPeiInQtdeautorizada() {
        return peiInQtdeautorizada;
    }

    public void setPeiInQtdeautorizada(BigInteger peiInQtdeautorizada) {
        this.peiInQtdeautorizada = peiInQtdeautorizada;
    }

    public BigInteger getPeiInQtdeatendidaEms() {
        return peiInQtdeatendidaEms;
    }

    public void setPeiInQtdeatendidaEms(BigInteger peiInQtdeatendidaEms) {
        this.peiInQtdeatendidaEms = peiInQtdeatendidaEms;
    }

    public String getPeiStLoteEms() {
        return peiStLoteEms;
    }

    public void setPeiStLoteEms(String peiStLoteEms) {
        this.peiStLoteEms = peiStLoteEms;
    }

    public Date getPeiDtValidadeEms() {
        return peiDtValidadeEms;
    }

    public void setPeiDtValidadeEms(Date peiDtValidadeEms) {
        this.peiDtValidadeEms = peiDtValidadeEms;
    }

    public Date getIprDtValidade() {
        return iprDtValidade;
    }

    public void setIprDtValidade(Date iprDtValidade) {
        this.iprDtValidade = iprDtValidade;
    }

    public String getPeiChPendenciadescartada() {
        return peiChPendenciadescartada;
    }

    public void setPeiChPendenciadescartada(String peiChPendenciadescartada) {
        this.peiChPendenciadescartada = peiChPendenciadescartada;
    }

    public String getPeiChItemvalidado() {
        return peiChItemvalidado;
    }

    public void setPeiChItemvalidado(String peiChItemvalidado) {
        this.peiChItemvalidado = peiChItemvalidado;
    }

    public Date getPeiDtValidacao() {
        return peiDtValidacao;
    }

    public void setPeiDtValidacao(Date peiDtValidacao) {
        this.peiDtValidacao = peiDtValidacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpPedidoitemPK != null ? erpPedidoitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedidoitem)) {
            return false;
        }
        ErpPedidoitem other = (ErpPedidoitem) object;
        if ((this.erpPedidoitemPK == null && other.erpPedidoitemPK != null) || (this.erpPedidoitemPK != null && !this.erpPedidoitemPK.equals(other.erpPedidoitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedidoitem[ erpPedidoitemPK=" + erpPedidoitemPK + " ]";
    }
    
}
