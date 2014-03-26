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
@Table(name = "ERP_PEDIDOITEMMSG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpPedidoitemmsg.findAll", query = "SELECT e FROM ErpPedidoitemmsg e"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByPimInCodigo", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.pimInCodigo = :pimInCodigo"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByPedInCodigo", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.pedInCodigo = :pedInCodigo"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByItmStCodigo", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByUsuStCodigo", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByUsuStCodigopara", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.usuStCodigopara = :usuStCodigopara"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByPimStMotivo", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.pimStMotivo = :pimStMotivo"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByPimStOutros", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.pimStOutros = :pimStOutros"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByPimStMensagem", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.pimStMensagem = :pimStMensagem"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByPimDtData", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.pimDtData = :pimDtData"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByPimChTipomsg", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.pimChTipomsg = :pimChTipomsg"),
    @NamedQuery(name = "ErpPedidoitemmsg.findByPimStAssunto", query = "SELECT e FROM ErpPedidoitemmsg e WHERE e.pimStAssunto = :pimStAssunto")})
public class ErpPedidoitemmsg implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PIM_IN_CODIGO")
    private BigDecimal pimInCodigo;
    @Column(name = "PED_IN_CODIGO")
    private BigInteger pedInCodigo;
    @Size(max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGOPARA")
    private String usuStCodigopara;
    @Size(max = 2)
    @Column(name = "PIM_ST_MOTIVO")
    private String pimStMotivo;
    @Size(max = 100)
    @Column(name = "PIM_ST_OUTROS")
    private String pimStOutros;
    @Size(max = 4000)
    @Column(name = "PIM_ST_MENSAGEM")
    private String pimStMensagem;
    @Column(name = "PIM_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date pimDtData;
    @Size(max = 1)
    @Column(name = "PIM_CH_TIPOMSG")
    private String pimChTipomsg;
    @Size(max = 100)
    @Column(name = "PIM_ST_ASSUNTO")
    private String pimStAssunto;

    public ErpPedidoitemmsg() {
    }

    public ErpPedidoitemmsg(BigDecimal pimInCodigo) {
        this.pimInCodigo = pimInCodigo;
    }

    public BigDecimal getPimInCodigo() {
        return pimInCodigo;
    }

    public void setPimInCodigo(BigDecimal pimInCodigo) {
        this.pimInCodigo = pimInCodigo;
    }

    public BigInteger getPedInCodigo() {
        return pedInCodigo;
    }

    public void setPedInCodigo(BigInteger pedInCodigo) {
        this.pedInCodigo = pedInCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getUsuStCodigopara() {
        return usuStCodigopara;
    }

    public void setUsuStCodigopara(String usuStCodigopara) {
        this.usuStCodigopara = usuStCodigopara;
    }

    public String getPimStMotivo() {
        return pimStMotivo;
    }

    public void setPimStMotivo(String pimStMotivo) {
        this.pimStMotivo = pimStMotivo;
    }

    public String getPimStOutros() {
        return pimStOutros;
    }

    public void setPimStOutros(String pimStOutros) {
        this.pimStOutros = pimStOutros;
    }

    public String getPimStMensagem() {
        return pimStMensagem;
    }

    public void setPimStMensagem(String pimStMensagem) {
        this.pimStMensagem = pimStMensagem;
    }

    public Date getPimDtData() {
        return pimDtData;
    }

    public void setPimDtData(Date pimDtData) {
        this.pimDtData = pimDtData;
    }

    public String getPimChTipomsg() {
        return pimChTipomsg;
    }

    public void setPimChTipomsg(String pimChTipomsg) {
        this.pimChTipomsg = pimChTipomsg;
    }

    public String getPimStAssunto() {
        return pimStAssunto;
    }

    public void setPimStAssunto(String pimStAssunto) {
        this.pimStAssunto = pimStAssunto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pimInCodigo != null ? pimInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedidoitemmsg)) {
            return false;
        }
        ErpPedidoitemmsg other = (ErpPedidoitemmsg) object;
        if ((this.pimInCodigo == null && other.pimInCodigo != null) || (this.pimInCodigo != null && !this.pimInCodigo.equals(other.pimInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedidoitemmsg[ pimInCodigo=" + pimInCodigo + " ]";
    }
    
}
