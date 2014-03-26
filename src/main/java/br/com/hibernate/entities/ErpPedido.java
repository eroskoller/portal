/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ERP_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpPedido.findAll", query = "SELECT e FROM ErpPedido e"),
    @NamedQuery(name = "ErpPedido.findByPedInCodigo", query = "SELECT e FROM ErpPedido e WHERE e.pedInCodigo = :pedInCodigo"),
    @NamedQuery(name = "ErpPedido.findByCcuStCodigo", query = "SELECT e FROM ErpPedido e WHERE e.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpPedido.findByPedDtCadastro", query = "SELECT e FROM ErpPedido e WHERE e.pedDtCadastro = :pedDtCadastro"),
    @NamedQuery(name = "ErpPedido.findByPedDtEntregaprev", query = "SELECT e FROM ErpPedido e WHERE e.pedDtEntregaprev = :pedDtEntregaprev"),
    @NamedQuery(name = "ErpPedido.findByUsuStCodigo", query = "SELECT e FROM ErpPedido e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpPedido.findByPedStStatus", query = "SELECT e FROM ErpPedido e WHERE e.pedStStatus = :pedStStatus"),
    @NamedQuery(name = "ErpPedido.findByUniStCodigo", query = "SELECT e FROM ErpPedido e WHERE e.uniStCodigo = :uniStCodigo"),
    @NamedQuery(name = "ErpPedido.findByPedStTipopedido", query = "SELECT e FROM ErpPedido e WHERE e.pedStTipopedido = :pedStTipopedido"),
    @NamedQuery(name = "ErpPedido.findByPedStNome", query = "SELECT e FROM ErpPedido e WHERE e.pedStNome = :pedStNome"),
    @NamedQuery(name = "ErpPedido.findByOriStCodigo", query = "SELECT e FROM ErpPedido e WHERE e.oriStCodigo = :oriStCodigo"),
    @NamedQuery(name = "ErpPedido.findByPedStObs", query = "SELECT e FROM ErpPedido e WHERE e.pedStObs = :pedStObs"),
    @NamedQuery(name = "ErpPedido.findByPedDtExporta", query = "SELECT e FROM ErpPedido e WHERE e.pedDtExporta = :pedDtExporta"),
    @NamedQuery(name = "ErpPedido.findByPedDtSeparacao", query = "SELECT e FROM ErpPedido e WHERE e.pedDtSeparacao = :pedDtSeparacao"),
    @NamedQuery(name = "ErpPedido.findByPedDtTransporte", query = "SELECT e FROM ErpPedido e WHERE e.pedDtTransporte = :pedDtTransporte"),
    @NamedQuery(name = "ErpPedido.findByPedDtEntregue", query = "SELECT e FROM ErpPedido e WHERE e.pedDtEntregue = :pedDtEntregue"),
    @NamedQuery(name = "ErpPedido.findByPedDtAceite", query = "SELECT e FROM ErpPedido e WHERE e.pedDtAceite = :pedDtAceite"),
    @NamedQuery(name = "ErpPedido.findByPedDtCancelado", query = "SELECT e FROM ErpPedido e WHERE e.pedDtCancelado = :pedDtCancelado"),
    @NamedQuery(name = "ErpPedido.findByPedDtAtivado", query = "SELECT e FROM ErpPedido e WHERE e.pedDtAtivado = :pedDtAtivado"),
    @NamedQuery(name = "ErpPedido.findByPedStMotivo", query = "SELECT e FROM ErpPedido e WHERE e.pedStMotivo = :pedStMotivo"),
    @NamedQuery(name = "ErpPedido.findByPedDtMovimentos", query = "SELECT e FROM ErpPedido e WHERE e.pedDtMovimentos = :pedDtMovimentos"),
    @NamedQuery(name = "ErpPedido.findByPedChFinalizado", query = "SELECT e FROM ErpPedido e WHERE e.pedChFinalizado = :pedChFinalizado"),
    @NamedQuery(name = "ErpPedido.findByPedChAutomatico", query = "SELECT e FROM ErpPedido e WHERE e.pedChAutomatico = :pedChAutomatico"),
    @NamedQuery(name = "ErpPedido.findByPedChAutorizado", query = "SELECT e FROM ErpPedido e WHERE e.pedChAutorizado = :pedChAutorizado"),
    @NamedQuery(name = "ErpPedido.findByPedStAutorizadopor", query = "SELECT e FROM ErpPedido e WHERE e.pedStAutorizadopor = :pedStAutorizadopor"),
    @NamedQuery(name = "ErpPedido.findByPedDtAutorizado", query = "SELECT e FROM ErpPedido e WHERE e.pedDtAutorizado = :pedDtAutorizado"),
    @NamedQuery(name = "ErpPedido.findByPedStPedidotipo", query = "SELECT e FROM ErpPedido e WHERE e.pedStPedidotipo = :pedStPedidotipo"),
    @NamedQuery(name = "ErpPedido.findByPedChAceiteautomatico", query = "SELECT e FROM ErpPedido e WHERE e.pedChAceiteautomatico = :pedChAceiteautomatico"),
    @NamedQuery(name = "ErpPedido.findByPedChPedidodemanda", query = "SELECT e FROM ErpPedido e WHERE e.pedChPedidodemanda = :pedChPedidodemanda"),
    @NamedQuery(name = "ErpPedido.findByPedChGerapendencia", query = "SELECT e FROM ErpPedido e WHERE e.pedChGerapendencia = :pedChGerapendencia"),
    @NamedQuery(name = "ErpPedido.findByPedInEmscodigo", query = "SELECT e FROM ErpPedido e WHERE e.pedInEmscodigo = :pedInEmscodigo"),
    @NamedQuery(name = "ErpPedido.findByPedStRegistroemuso", query = "SELECT e FROM ErpPedido e WHERE e.pedStRegistroemuso = :pedStRegistroemuso"),
    @NamedQuery(name = "ErpPedido.findByPedDtRegistroemuso", query = "SELECT e FROM ErpPedido e WHERE e.pedDtRegistroemuso = :pedDtRegistroemuso"),
    @NamedQuery(name = "ErpPedido.findByPedDtConferido", query = "SELECT e FROM ErpPedido e WHERE e.pedDtConferido = :pedDtConferido"),
    @NamedQuery(name = "ErpPedido.findByPedDtCompetencia", query = "SELECT e FROM ErpPedido e WHERE e.pedDtCompetencia = :pedDtCompetencia"),
    @NamedQuery(name = "ErpPedido.findByMarStCodigo", query = "SELECT e FROM ErpPedido e WHERE e.marStCodigo = :marStCodigo"),
    @NamedQuery(name = "ErpPedido.findByPedChExportadototal", query = "SELECT e FROM ErpPedido e WHERE e.pedChExportadototal = :pedChExportadototal"),
    @NamedQuery(name = "ErpPedido.findByPedChSeparadototal", query = "SELECT e FROM ErpPedido e WHERE e.pedChSeparadototal = :pedChSeparadototal"),
    @NamedQuery(name = "ErpPedido.findByPedChNaoalterado", query = "SELECT e FROM ErpPedido e WHERE e.pedChNaoalterado = :pedChNaoalterado"),
    @NamedQuery(name = "ErpPedido.findByPedChPendenciadescartada", query = "SELECT e FROM ErpPedido e WHERE e.pedChPendenciadescartada = :pedChPendenciadescartada"),
    @NamedQuery(name = "ErpPedido.findByPedStInfoimportacao", query = "SELECT e FROM ErpPedido e WHERE e.pedStInfoimportacao = :pedStInfoimportacao"),
    @NamedQuery(name = "ErpPedido.findByPedStDataimportacao", query = "SELECT e FROM ErpPedido e WHERE e.pedStDataimportacao = :pedStDataimportacao"),
    @NamedQuery(name = "ErpPedido.findByPedDtExcluido", query = "SELECT e FROM ErpPedido e WHERE e.pedDtExcluido = :pedDtExcluido"),
    @NamedQuery(name = "ErpPedido.findByPedStRota", query = "SELECT e FROM ErpPedido e WHERE e.pedStRota = :pedStRota"),
    @NamedQuery(name = "ErpPedido.findByPedChAcobrar", query = "SELECT e FROM ErpPedido e WHERE e.pedChAcobrar = :pedChAcobrar"),
    @NamedQuery(name = "ErpPedido.findByPedChBloqueado", query = "SELECT e FROM ErpPedido e WHERE e.pedChBloqueado = :pedChBloqueado"),
    @NamedQuery(name = "ErpPedido.findByPedChObrigavalidacao", query = "SELECT e FROM ErpPedido e WHERE e.pedChObrigavalidacao = :pedChObrigavalidacao"),
    @NamedQuery(name = "ErpPedido.findByPedInAutorizacao", query = "SELECT e FROM ErpPedido e WHERE e.pedInAutorizacao = :pedInAutorizacao")})
public class ErpPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PED_IN_CODIGO")
    private BigDecimal pedInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PED_DT_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date pedDtCadastro;
    @Column(name = "PED_DT_ENTREGAPREV")
    @Temporal(TemporalType.DATE)
    private Date pedDtEntregaprev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Size(max = 2)
    @Column(name = "PED_ST_STATUS")
    private String pedStStatus;
    @Size(max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Size(max = 2)
    @Column(name = "PED_ST_TIPOPEDIDO")
    private String pedStTipopedido;
    @Size(max = 20)
    @Column(name = "PED_ST_NOME")
    private String pedStNome;
    @Size(max = 6)
    @Column(name = "ORI_ST_CODIGO")
    private String oriStCodigo;
    @Size(max = 100)
    @Column(name = "PED_ST_OBS")
    private String pedStObs;
    @Column(name = "PED_DT_EXPORTA")
    @Temporal(TemporalType.DATE)
    private Date pedDtExporta;
    @Column(name = "PED_DT_SEPARACAO")
    @Temporal(TemporalType.DATE)
    private Date pedDtSeparacao;
    @Column(name = "PED_DT_TRANSPORTE")
    @Temporal(TemporalType.DATE)
    private Date pedDtTransporte;
    @Column(name = "PED_DT_ENTREGUE")
    @Temporal(TemporalType.DATE)
    private Date pedDtEntregue;
    @Column(name = "PED_DT_ACEITE")
    @Temporal(TemporalType.DATE)
    private Date pedDtAceite;
    @Column(name = "PED_DT_CANCELADO")
    @Temporal(TemporalType.DATE)
    private Date pedDtCancelado;
    @Column(name = "PED_DT_ATIVADO")
    @Temporal(TemporalType.DATE)
    private Date pedDtAtivado;
    @Size(max = 3)
    @Column(name = "PED_ST_MOTIVO")
    private String pedStMotivo;
    @Column(name = "PED_DT_MOVIMENTOS")
    @Temporal(TemporalType.DATE)
    private Date pedDtMovimentos;
    @Size(max = 1)
    @Column(name = "PED_CH_FINALIZADO")
    private String pedChFinalizado;
    @Size(max = 1)
    @Column(name = "PED_CH_AUTOMATICO")
    private String pedChAutomatico;
    @Size(max = 1)
    @Column(name = "PED_CH_AUTORIZADO")
    private String pedChAutorizado;
    @Size(max = 20)
    @Column(name = "PED_ST_AUTORIZADOPOR")
    private String pedStAutorizadopor;
    @Column(name = "PED_DT_AUTORIZADO")
    @Temporal(TemporalType.DATE)
    private Date pedDtAutorizado;
    @Size(max = 2)
    @Column(name = "PED_ST_PEDIDOTIPO")
    private String pedStPedidotipo;
    @Size(max = 1)
    @Column(name = "PED_CH_ACEITEAUTOMATICO")
    private String pedChAceiteautomatico;
    @Size(max = 1)
    @Column(name = "PED_CH_PEDIDODEMANDA")
    private String pedChPedidodemanda;
    @Size(max = 1)
    @Column(name = "PED_CH_GERAPENDENCIA")
    private String pedChGerapendencia;
    @Column(name = "PED_IN_EMSCODIGO")
    private BigInteger pedInEmscodigo;
    @Size(max = 20)
    @Column(name = "PED_ST_REGISTROEMUSO")
    private String pedStRegistroemuso;
    @Column(name = "PED_DT_REGISTROEMUSO")
    @Temporal(TemporalType.DATE)
    private Date pedDtRegistroemuso;
    @Column(name = "PED_DT_CONFERIDO")
    @Temporal(TemporalType.DATE)
    private Date pedDtConferido;
    @Column(name = "PED_DT_COMPETENCIA")
    @Temporal(TemporalType.DATE)
    private Date pedDtCompetencia;
    @Size(max = 3)
    @Column(name = "MAR_ST_CODIGO")
    private String marStCodigo;
    @Size(max = 1)
    @Column(name = "PED_CH_EXPORTADOTOTAL")
    private String pedChExportadototal;
    @Size(max = 1)
    @Column(name = "PED_CH_SEPARADOTOTAL")
    private String pedChSeparadototal;
    @Size(max = 1)
    @Column(name = "PED_CH_NAOALTERADO")
    private String pedChNaoalterado;
    @Size(max = 1)
    @Column(name = "PED_CH_PENDENCIADESCARTADA")
    private String pedChPendenciadescartada;
    @Size(max = 4000)
    @Column(name = "PED_ST_INFOIMPORTACAO")
    private String pedStInfoimportacao;
    @Size(max = 25)
    @Column(name = "PED_ST_DATAIMPORTACAO")
    private String pedStDataimportacao;
    @Column(name = "PED_DT_EXCLUIDO")
    @Temporal(TemporalType.DATE)
    private Date pedDtExcluido;
    @Size(max = 3)
    @Column(name = "PED_ST_ROTA")
    private String pedStRota;
    @Size(max = 1)
    @Column(name = "PED_CH_ACOBRAR")
    private String pedChAcobrar;
    @Size(max = 1)
    @Column(name = "PED_CH_BLOQUEADO")
    private String pedChBloqueado;
    @Size(max = 1)
    @Column(name = "PED_CH_OBRIGAVALIDACAO")
    private String pedChObrigavalidacao;
    @Column(name = "PED_IN_AUTORIZACAO")
    private BigInteger pedInAutorizacao;

    public ErpPedido() {
    }

    public ErpPedido(BigDecimal pedInCodigo) {
        this.pedInCodigo = pedInCodigo;
    }

    public ErpPedido(BigDecimal pedInCodigo, String ccuStCodigo, Date pedDtCadastro, String usuStCodigo) {
        this.pedInCodigo = pedInCodigo;
        this.ccuStCodigo = ccuStCodigo;
        this.pedDtCadastro = pedDtCadastro;
        this.usuStCodigo = usuStCodigo;
    }

    public BigDecimal getPedInCodigo() {
        return pedInCodigo;
    }

    public void setPedInCodigo(BigDecimal pedInCodigo) {
        this.pedInCodigo = pedInCodigo;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    public Date getPedDtCadastro() {
        return pedDtCadastro;
    }

    public void setPedDtCadastro(Date pedDtCadastro) {
        this.pedDtCadastro = pedDtCadastro;
    }

    public Date getPedDtEntregaprev() {
        return pedDtEntregaprev;
    }

    public void setPedDtEntregaprev(Date pedDtEntregaprev) {
        this.pedDtEntregaprev = pedDtEntregaprev;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getPedStStatus() {
        return pedStStatus;
    }

    public void setPedStStatus(String pedStStatus) {
        this.pedStStatus = pedStStatus;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getPedStTipopedido() {
        return pedStTipopedido;
    }

    public void setPedStTipopedido(String pedStTipopedido) {
        this.pedStTipopedido = pedStTipopedido;
    }

    public String getPedStNome() {
        return pedStNome;
    }

    public void setPedStNome(String pedStNome) {
        this.pedStNome = pedStNome;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
    }

    public String getPedStObs() {
        return pedStObs;
    }

    public void setPedStObs(String pedStObs) {
        this.pedStObs = pedStObs;
    }

    public Date getPedDtExporta() {
        return pedDtExporta;
    }

    public void setPedDtExporta(Date pedDtExporta) {
        this.pedDtExporta = pedDtExporta;
    }

    public Date getPedDtSeparacao() {
        return pedDtSeparacao;
    }

    public void setPedDtSeparacao(Date pedDtSeparacao) {
        this.pedDtSeparacao = pedDtSeparacao;
    }

    public Date getPedDtTransporte() {
        return pedDtTransporte;
    }

    public void setPedDtTransporte(Date pedDtTransporte) {
        this.pedDtTransporte = pedDtTransporte;
    }

    public Date getPedDtEntregue() {
        return pedDtEntregue;
    }

    public void setPedDtEntregue(Date pedDtEntregue) {
        this.pedDtEntregue = pedDtEntregue;
    }

    public Date getPedDtAceite() {
        return pedDtAceite;
    }

    public void setPedDtAceite(Date pedDtAceite) {
        this.pedDtAceite = pedDtAceite;
    }

    public Date getPedDtCancelado() {
        return pedDtCancelado;
    }

    public void setPedDtCancelado(Date pedDtCancelado) {
        this.pedDtCancelado = pedDtCancelado;
    }

    public Date getPedDtAtivado() {
        return pedDtAtivado;
    }

    public void setPedDtAtivado(Date pedDtAtivado) {
        this.pedDtAtivado = pedDtAtivado;
    }

    public String getPedStMotivo() {
        return pedStMotivo;
    }

    public void setPedStMotivo(String pedStMotivo) {
        this.pedStMotivo = pedStMotivo;
    }

    public Date getPedDtMovimentos() {
        return pedDtMovimentos;
    }

    public void setPedDtMovimentos(Date pedDtMovimentos) {
        this.pedDtMovimentos = pedDtMovimentos;
    }

    public String getPedChFinalizado() {
        return pedChFinalizado;
    }

    public void setPedChFinalizado(String pedChFinalizado) {
        this.pedChFinalizado = pedChFinalizado;
    }

    public String getPedChAutomatico() {
        return pedChAutomatico;
    }

    public void setPedChAutomatico(String pedChAutomatico) {
        this.pedChAutomatico = pedChAutomatico;
    }

    public String getPedChAutorizado() {
        return pedChAutorizado;
    }

    public void setPedChAutorizado(String pedChAutorizado) {
        this.pedChAutorizado = pedChAutorizado;
    }

    public String getPedStAutorizadopor() {
        return pedStAutorizadopor;
    }

    public void setPedStAutorizadopor(String pedStAutorizadopor) {
        this.pedStAutorizadopor = pedStAutorizadopor;
    }

    public Date getPedDtAutorizado() {
        return pedDtAutorizado;
    }

    public void setPedDtAutorizado(Date pedDtAutorizado) {
        this.pedDtAutorizado = pedDtAutorizado;
    }

    public String getPedStPedidotipo() {
        return pedStPedidotipo;
    }

    public void setPedStPedidotipo(String pedStPedidotipo) {
        this.pedStPedidotipo = pedStPedidotipo;
    }

    public String getPedChAceiteautomatico() {
        return pedChAceiteautomatico;
    }

    public void setPedChAceiteautomatico(String pedChAceiteautomatico) {
        this.pedChAceiteautomatico = pedChAceiteautomatico;
    }

    public String getPedChPedidodemanda() {
        return pedChPedidodemanda;
    }

    public void setPedChPedidodemanda(String pedChPedidodemanda) {
        this.pedChPedidodemanda = pedChPedidodemanda;
    }

    public String getPedChGerapendencia() {
        return pedChGerapendencia;
    }

    public void setPedChGerapendencia(String pedChGerapendencia) {
        this.pedChGerapendencia = pedChGerapendencia;
    }

    public BigInteger getPedInEmscodigo() {
        return pedInEmscodigo;
    }

    public void setPedInEmscodigo(BigInteger pedInEmscodigo) {
        this.pedInEmscodigo = pedInEmscodigo;
    }

    public String getPedStRegistroemuso() {
        return pedStRegistroemuso;
    }

    public void setPedStRegistroemuso(String pedStRegistroemuso) {
        this.pedStRegistroemuso = pedStRegistroemuso;
    }

    public Date getPedDtRegistroemuso() {
        return pedDtRegistroemuso;
    }

    public void setPedDtRegistroemuso(Date pedDtRegistroemuso) {
        this.pedDtRegistroemuso = pedDtRegistroemuso;
    }

    public Date getPedDtConferido() {
        return pedDtConferido;
    }

    public void setPedDtConferido(Date pedDtConferido) {
        this.pedDtConferido = pedDtConferido;
    }

    public Date getPedDtCompetencia() {
        return pedDtCompetencia;
    }

    public void setPedDtCompetencia(Date pedDtCompetencia) {
        this.pedDtCompetencia = pedDtCompetencia;
    }

    public String getMarStCodigo() {
        return marStCodigo;
    }

    public void setMarStCodigo(String marStCodigo) {
        this.marStCodigo = marStCodigo;
    }

    public String getPedChExportadototal() {
        return pedChExportadototal;
    }

    public void setPedChExportadototal(String pedChExportadototal) {
        this.pedChExportadototal = pedChExportadototal;
    }

    public String getPedChSeparadototal() {
        return pedChSeparadototal;
    }

    public void setPedChSeparadototal(String pedChSeparadototal) {
        this.pedChSeparadototal = pedChSeparadototal;
    }

    public String getPedChNaoalterado() {
        return pedChNaoalterado;
    }

    public void setPedChNaoalterado(String pedChNaoalterado) {
        this.pedChNaoalterado = pedChNaoalterado;
    }

    public String getPedChPendenciadescartada() {
        return pedChPendenciadescartada;
    }

    public void setPedChPendenciadescartada(String pedChPendenciadescartada) {
        this.pedChPendenciadescartada = pedChPendenciadescartada;
    }

    public String getPedStInfoimportacao() {
        return pedStInfoimportacao;
    }

    public void setPedStInfoimportacao(String pedStInfoimportacao) {
        this.pedStInfoimportacao = pedStInfoimportacao;
    }

    public String getPedStDataimportacao() {
        return pedStDataimportacao;
    }

    public void setPedStDataimportacao(String pedStDataimportacao) {
        this.pedStDataimportacao = pedStDataimportacao;
    }

    public Date getPedDtExcluido() {
        return pedDtExcluido;
    }

    public void setPedDtExcluido(Date pedDtExcluido) {
        this.pedDtExcluido = pedDtExcluido;
    }

    public String getPedStRota() {
        return pedStRota;
    }

    public void setPedStRota(String pedStRota) {
        this.pedStRota = pedStRota;
    }

    public String getPedChAcobrar() {
        return pedChAcobrar;
    }

    public void setPedChAcobrar(String pedChAcobrar) {
        this.pedChAcobrar = pedChAcobrar;
    }

    public String getPedChBloqueado() {
        return pedChBloqueado;
    }

    public void setPedChBloqueado(String pedChBloqueado) {
        this.pedChBloqueado = pedChBloqueado;
    }

    public String getPedChObrigavalidacao() {
        return pedChObrigavalidacao;
    }

    public void setPedChObrigavalidacao(String pedChObrigavalidacao) {
        this.pedChObrigavalidacao = pedChObrigavalidacao;
    }

    public BigInteger getPedInAutorizacao() {
        return pedInAutorizacao;
    }

    public void setPedInAutorizacao(BigInteger pedInAutorizacao) {
        this.pedInAutorizacao = pedInAutorizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedInCodigo != null ? pedInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedido)) {
            return false;
        }
        ErpPedido other = (ErpPedido) object;
        if ((this.pedInCodigo == null && other.pedInCodigo != null) || (this.pedInCodigo != null && !this.pedInCodigo.equals(other.pedInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedido[ pedInCodigo=" + pedInCodigo + " ]";
    }
    
}
