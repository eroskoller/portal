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
@Table(name = "ERP_CCUSTO")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ErpCcusto.findAll", query = "SELECT e FROM ErpCcusto e"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStCodigo", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStCodigo = :ccuStCodigo"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStCodigo505", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStCodigo505 = :ccuStCodigo505"),
//    @NamedQuery(name = "ErpCcusto.findByEstStCodigo", query = "SELECT e FROM ErpCcusto e WHERE e.estStCodigo = :estStCodigo"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStUna", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStUna = :ccuStUna"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStDvdp", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStDvdp = :ccuStDvdp"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStServ", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStServ = :ccuStServ"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStDescricao", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStDescricao = :ccuStDescricao"),
//    @NamedQuery(name = "ErpCcusto.findByUniStCodigo", query = "SELECT e FROM ErpCcusto e WHERE e.uniStCodigo = :uniStCodigo"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStAtivo", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStAtivo = :ccuStAtivo"),
//    @NamedQuery(name = "ErpCcusto.findByEstStDescricao", query = "SELECT e FROM ErpCcusto e WHERE e.estStDescricao = :estStDescricao"),
//    @NamedQuery(name = "ErpCcusto.findByEstStFiscal", query = "SELECT e FROM ErpCcusto e WHERE e.estStFiscal = :estStFiscal"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChTipo", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChTipo = :ccuChTipo"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChObrigatorioposto", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChObrigatorioposto = :ccuChObrigatorioposto"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChPai", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChPai = :ccuChPai"),
//    @NamedQuery(name = "ErpCcusto.findByCcuDtCriadoem", query = "SELECT e FROM ErpCcusto e WHERE e.ccuDtCriadoem = :ccuDtCriadoem"),
//    @NamedQuery(name = "ErpCcusto.findByCcuDtAlteradoem", query = "SELECT e FROM ErpCcusto e WHERE e.ccuDtAlteradoem = :ccuDtAlteradoem"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChAutorizar", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChAutorizar = :ccuChAutorizar"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStCodigocobranca", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStCodigocobranca = :ccuStCodigocobranca"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChUsaitemxccu", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChUsaitemxccu = :ccuChUsaitemxccu"),
//    @NamedQuery(name = "ErpCcusto.findByMarStCodigo", query = "SELECT e FROM ErpCcusto e WHERE e.marStCodigo = :marStCodigo"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChObrigatorioestoque", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChObrigatorioestoque = :ccuChObrigatorioestoque"),
//    @NamedQuery(name = "ErpCcusto.findByRgiStCodigo", query = "SELECT e FROM ErpCcusto e WHERE e.rgiStCodigo = :rgiStCodigo"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChObrigatoriolote", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChObrigatoriolote = :ccuChObrigatoriolote"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChAutorizarurgente", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChAutorizarurgente = :ccuChAutorizarurgente"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStHorariolimite", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStHorariolimite = :ccuStHorariolimite"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChOrdenaporarmazem", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChOrdenaporarmazem = :ccuChOrdenaporarmazem"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStUf", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStUf = :ccuStUf"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStInventariocontagem", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStInventariocontagem = :ccuStInventariocontagem"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChObrigalimite", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChObrigalimite = :ccuChObrigalimite"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChPreexportacao", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChPreexportacao = :ccuChPreexportacao"),
//    @NamedQuery(name = "ErpCcusto.findByAmzStCodigo", query = "SELECT e FROM ErpCcusto e WHERE e.amzStCodigo = :amzStCodigo"),
//    @NamedQuery(name = "ErpCcusto.findByCcuStRota", query = "SELECT e FROM ErpCcusto e WHERE e.ccuStRota = :ccuStRota"),
//    @NamedQuery(name = "ErpCcusto.findByCcuChObrigavalidacao", query = "SELECT e FROM ErpCcusto e WHERE e.ccuChObrigavalidacao = :ccuChObrigavalidacao"),
//    @NamedQuery(name = "ErpCcusto.findByCcuInNumautorizaped", query = "SELECT e FROM ErpCcusto e WHERE e.ccuInNumautorizaped = :ccuInNumautorizaped"),
//    @NamedQuery(name = "ErpCcusto.findByCcuInNumautorizacom", query = "SELECT e FROM ErpCcusto e WHERE e.ccuInNumautorizacom = :ccuInNumautorizacom")})
public class ErpCcusto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;
    @Size(max = 20)
    @Column(name = "CCU_ST_CODIGO505")
    private String ccuStCodigo505;
    @Size(max = 20)
    @Column(name = "EST_ST_CODIGO")
    private String estStCodigo;
    @Size(max = 20)
    @Column(name = "CCU_ST_UNA")
    private String ccuStUna;
    @Size(max = 20)
    @Column(name = "CCU_ST_DVDP")
    private String ccuStDvdp;
    @Size(max = 20)
    @Column(name = "CCU_ST_SERV")
    private String ccuStServ;
    @Size(max = 500)
    @Column(name = "CCU_ST_DESCRICAO")
    private String ccuStDescricao;
    @Size(max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Size(max = 1)
    @Column(name = "CCU_ST_ATIVO")
    private String ccuStAtivo;
    @Size(max = 500)
    @Column(name = "EST_ST_DESCRICAO")
    private String estStDescricao;
    @Size(max = 3)
    @Column(name = "EST_ST_FISCAL")
    private String estStFiscal;
    @Size(max = 2)
    @Column(name = "CCU_CH_TIPO")
    private String ccuChTipo;
    @Size(max = 1)
    @Column(name = "CCU_CH_OBRIGATORIOPOSTO")
    private String ccuChObrigatorioposto;
    @Size(max = 1)
    @Column(name = "CCU_CH_PAI")
    private String ccuChPai;
    @Column(name = "CCU_DT_CRIADOEM")
    @Temporal(TemporalType.DATE)
    private Date ccuDtCriadoem;
    @Column(name = "CCU_DT_ALTERADOEM")
    @Temporal(TemporalType.DATE)
    private Date ccuDtAlteradoem;
    @Size(max = 1)
    @Column(name = "CCU_CH_AUTORIZAR")
    private String ccuChAutorizar;
    @Size(max = 20)
    @Column(name = "CCU_ST_CODIGOCOBRANCA")
    private String ccuStCodigocobranca;
    @Size(max = 1)
    @Column(name = "CCU_CH_USAITEMXCCU")
    private String ccuChUsaitemxccu;
    @Size(max = 3)
    @Column(name = "MAR_ST_CODIGO")
    private String marStCodigo;
    @Size(max = 1)
    @Column(name = "CCU_CH_OBRIGATORIOESTOQUE")
    private String ccuChObrigatorioestoque;
    @Size(max = 3)
    @Column(name = "RGI_ST_CODIGO")
    private String rgiStCodigo;
    @Size(max = 1)
    @Column(name = "CCU_CH_OBRIGATORIOLOTE")
    private String ccuChObrigatoriolote;
    @Size(max = 1)
    @Column(name = "CCU_CH_AUTORIZARURGENTE")
    private String ccuChAutorizarurgente;
    @Size(max = 5)
    @Column(name = "CCU_ST_HORARIOLIMITE")
    private String ccuStHorariolimite;
    @Size(max = 1)
    @Column(name = "CCU_CH_ORDENAPORARMAZEM")
    private String ccuChOrdenaporarmazem;
    @Size(max = 2)
    @Column(name = "CCU_ST_UF")
    private String ccuStUf;
    @Size(max = 2)
    @Column(name = "CCU_ST_INVENTARIOCONTAGEM")
    private String ccuStInventariocontagem;
    @Size(max = 1)
    @Column(name = "CCU_CH_OBRIGALIMITE")
    private String ccuChObrigalimite;
    @Size(max = 1)
    @Column(name = "CCU_CH_PREEXPORTACAO")
    private String ccuChPreexportacao;
    @Size(max = 6)
    @Column(name = "AMZ_ST_CODIGO")
    private String amzStCodigo;
    @Size(max = 3)
    @Column(name = "CCU_ST_ROTA")
    private String ccuStRota;
    @Size(max = 1)
    @Column(name = "CCU_CH_OBRIGAVALIDACAO")
    private String ccuChObrigavalidacao;
    @Column(name = "CCU_IN_NUMAUTORIZAPED")
    private BigInteger ccuInNumautorizaped;
    @Column(name = "CCU_IN_NUMAUTORIZACOM")
    private BigInteger ccuInNumautorizacom;

    public ErpCcusto() {
    }

    public ErpCcusto(String ccuStCodigo, String ccuStDescricao) {
        this.ccuStCodigo = ccuStCodigo;
        this.ccuStDescricao = ccuStDescricao;
    }

    
    
    public ErpCcusto(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
    }

    public String getCcuStCodigo505() {
        return ccuStCodigo505;
    }

    public void setCcuStCodigo505(String ccuStCodigo505) {
        this.ccuStCodigo505 = ccuStCodigo505;
    }

    public String getEstStCodigo() {
        return estStCodigo;
    }

    public void setEstStCodigo(String estStCodigo) {
        this.estStCodigo = estStCodigo;
    }

    public String getCcuStUna() {
        return ccuStUna;
    }

    public void setCcuStUna(String ccuStUna) {
        this.ccuStUna = ccuStUna;
    }

    public String getCcuStDvdp() {
        return ccuStDvdp;
    }

    public void setCcuStDvdp(String ccuStDvdp) {
        this.ccuStDvdp = ccuStDvdp;
    }

    public String getCcuStServ() {
        return ccuStServ;
    }

    public void setCcuStServ(String ccuStServ) {
        this.ccuStServ = ccuStServ;
    }

    public String getCcuStDescricao() {
        return ccuStDescricao;
    }

    public void setCcuStDescricao(String ccuStDescricao) {
        this.ccuStDescricao = ccuStDescricao;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getCcuStAtivo() {
        return ccuStAtivo;
    }

    public void setCcuStAtivo(String ccuStAtivo) {
        this.ccuStAtivo = ccuStAtivo;
    }

    public String getEstStDescricao() {
        return estStDescricao;
    }

    public void setEstStDescricao(String estStDescricao) {
        this.estStDescricao = estStDescricao;
    }

    public String getEstStFiscal() {
        return estStFiscal;
    }

    public void setEstStFiscal(String estStFiscal) {
        this.estStFiscal = estStFiscal;
    }

    public String getCcuChTipo() {
        return ccuChTipo;
    }

    public void setCcuChTipo(String ccuChTipo) {
        this.ccuChTipo = ccuChTipo;
    }

    public String getCcuChObrigatorioposto() {
        return ccuChObrigatorioposto;
    }

    public void setCcuChObrigatorioposto(String ccuChObrigatorioposto) {
        this.ccuChObrigatorioposto = ccuChObrigatorioposto;
    }

    public String getCcuChPai() {
        return ccuChPai;
    }

    public void setCcuChPai(String ccuChPai) {
        this.ccuChPai = ccuChPai;
    }

    public Date getCcuDtCriadoem() {
        return ccuDtCriadoem;
    }

    public void setCcuDtCriadoem(Date ccuDtCriadoem) {
        this.ccuDtCriadoem = ccuDtCriadoem;
    }

    public Date getCcuDtAlteradoem() {
        return ccuDtAlteradoem;
    }

    public void setCcuDtAlteradoem(Date ccuDtAlteradoem) {
        this.ccuDtAlteradoem = ccuDtAlteradoem;
    }

    public String getCcuChAutorizar() {
        return ccuChAutorizar;
    }

    public void setCcuChAutorizar(String ccuChAutorizar) {
        this.ccuChAutorizar = ccuChAutorizar;
    }

    public String getCcuStCodigocobranca() {
        return ccuStCodigocobranca;
    }

    public void setCcuStCodigocobranca(String ccuStCodigocobranca) {
        this.ccuStCodigocobranca = ccuStCodigocobranca;
    }

    public String getCcuChUsaitemxccu() {
        return ccuChUsaitemxccu;
    }

    public void setCcuChUsaitemxccu(String ccuChUsaitemxccu) {
        this.ccuChUsaitemxccu = ccuChUsaitemxccu;
    }

    public String getMarStCodigo() {
        return marStCodigo;
    }

    public void setMarStCodigo(String marStCodigo) {
        this.marStCodigo = marStCodigo;
    }

    public String getCcuChObrigatorioestoque() {
        return ccuChObrigatorioestoque;
    }

    public void setCcuChObrigatorioestoque(String ccuChObrigatorioestoque) {
        this.ccuChObrigatorioestoque = ccuChObrigatorioestoque;
    }

    public String getRgiStCodigo() {
        return rgiStCodigo;
    }

    public void setRgiStCodigo(String rgiStCodigo) {
        this.rgiStCodigo = rgiStCodigo;
    }

    public String getCcuChObrigatoriolote() {
        return ccuChObrigatoriolote;
    }

    public void setCcuChObrigatoriolote(String ccuChObrigatoriolote) {
        this.ccuChObrigatoriolote = ccuChObrigatoriolote;
    }

    public String getCcuChAutorizarurgente() {
        return ccuChAutorizarurgente;
    }

    public void setCcuChAutorizarurgente(String ccuChAutorizarurgente) {
        this.ccuChAutorizarurgente = ccuChAutorizarurgente;
    }

    public String getCcuStHorariolimite() {
        return ccuStHorariolimite;
    }

    public void setCcuStHorariolimite(String ccuStHorariolimite) {
        this.ccuStHorariolimite = ccuStHorariolimite;
    }

    public String getCcuChOrdenaporarmazem() {
        return ccuChOrdenaporarmazem;
    }

    public void setCcuChOrdenaporarmazem(String ccuChOrdenaporarmazem) {
        this.ccuChOrdenaporarmazem = ccuChOrdenaporarmazem;
    }

    public String getCcuStUf() {
        return ccuStUf;
    }

    public void setCcuStUf(String ccuStUf) {
        this.ccuStUf = ccuStUf;
    }

    public String getCcuStInventariocontagem() {
        return ccuStInventariocontagem;
    }

    public void setCcuStInventariocontagem(String ccuStInventariocontagem) {
        this.ccuStInventariocontagem = ccuStInventariocontagem;
    }

    public String getCcuChObrigalimite() {
        return ccuChObrigalimite;
    }

    public void setCcuChObrigalimite(String ccuChObrigalimite) {
        this.ccuChObrigalimite = ccuChObrigalimite;
    }

    public String getCcuChPreexportacao() {
        return ccuChPreexportacao;
    }

    public void setCcuChPreexportacao(String ccuChPreexportacao) {
        this.ccuChPreexportacao = ccuChPreexportacao;
    }

    public String getAmzStCodigo() {
        return amzStCodigo;
    }

    public void setAmzStCodigo(String amzStCodigo) {
        this.amzStCodigo = amzStCodigo;
    }

    public String getCcuStRota() {
        return ccuStRota;
    }

    public void setCcuStRota(String ccuStRota) {
        this.ccuStRota = ccuStRota;
    }

    public String getCcuChObrigavalidacao() {
        return ccuChObrigavalidacao;
    }

    public void setCcuChObrigavalidacao(String ccuChObrigavalidacao) {
        this.ccuChObrigavalidacao = ccuChObrigavalidacao;
    }

    public BigInteger getCcuInNumautorizaped() {
        return ccuInNumautorizaped;
    }

    public void setCcuInNumautorizaped(BigInteger ccuInNumautorizaped) {
        this.ccuInNumautorizaped = ccuInNumautorizaped;
    }

    public BigInteger getCcuInNumautorizacom() {
        return ccuInNumautorizacom;
    }

    public void setCcuInNumautorizacom(BigInteger ccuInNumautorizacom) {
        this.ccuInNumautorizacom = ccuInNumautorizacom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccuStCodigo != null ? ccuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCcusto)) {
            return false;
        }
        ErpCcusto other = (ErpCcusto) object;
        if ((this.ccuStCodigo == null && other.ccuStCodigo != null) || (this.ccuStCodigo != null && !this.ccuStCodigo.equals(other.ccuStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCcusto[ ccuStCodigo=" + ccuStCodigo + " ]";
    }
    
}
