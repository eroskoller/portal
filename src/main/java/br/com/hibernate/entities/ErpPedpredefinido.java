/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
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
@Table(name = "ERP_PEDPREDEFINIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpPedpredefinido.findAll", query = "SELECT e FROM ErpPedpredefinido e"),
    @NamedQuery(name = "ErpPedpredefinido.findByPpdStCodigo", query = "SELECT e FROM ErpPedpredefinido e WHERE e.erpPedpredefinidoPK.ppdStCodigo = :ppdStCodigo"),
    @NamedQuery(name = "ErpPedpredefinido.findByCcuStCodigo", query = "SELECT e FROM ErpPedpredefinido e WHERE e.erpPedpredefinidoPK.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpPedpredefinido.findByPpdStDescricao", query = "SELECT e FROM ErpPedpredefinido e WHERE e.ppdStDescricao = :ppdStDescricao"),
    @NamedQuery(name = "ErpPedpredefinido.findByUsuStCodigo", query = "SELECT e FROM ErpPedpredefinido e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpPedpredefinido.findByPpdDtDatacriacao", query = "SELECT e FROM ErpPedpredefinido e WHERE e.ppdDtDatacriacao = :ppdDtDatacriacao"),
    @NamedQuery(name = "ErpPedpredefinido.findByPpdDtAlteradoem", query = "SELECT e FROM ErpPedpredefinido e WHERE e.ppdDtAlteradoem = :ppdDtAlteradoem"),
    @NamedQuery(name = "ErpPedpredefinido.findByPpdChAtivo", query = "SELECT e FROM ErpPedpredefinido e WHERE e.ppdChAtivo = :ppdChAtivo"),
    @NamedQuery(name = "ErpPedpredefinido.findByPedStTipopedido", query = "SELECT e FROM ErpPedpredefinido e WHERE e.pedStTipopedido = :pedStTipopedido")})
public class ErpPedpredefinido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpPedpredefinidoPK erpPedpredefinidoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PPD_ST_DESCRICAO")
    private String ppdStDescricao;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name = "PPD_DT_DATACRIACAO")
    @Temporal(TemporalType.DATE)
    private Date ppdDtDatacriacao;
    @Column(name = "PPD_DT_ALTERADOEM")
    @Temporal(TemporalType.DATE)
    private Date ppdDtAlteradoem;
    @Size(max = 1)
    @Column(name = "PPD_CH_ATIVO")
    private String ppdChAtivo;
    @Size(max = 2)
    @Column(name = "PED_ST_TIPOPEDIDO")
    private String pedStTipopedido;

    public ErpPedpredefinido() {
    }

    public ErpPedpredefinido(ErpPedpredefinidoPK erpPedpredefinidoPK) {
        this.erpPedpredefinidoPK = erpPedpredefinidoPK;
    }

    public ErpPedpredefinido(ErpPedpredefinidoPK erpPedpredefinidoPK, String ppdStDescricao) {
        this.erpPedpredefinidoPK = erpPedpredefinidoPK;
        this.ppdStDescricao = ppdStDescricao;
    }

    public ErpPedpredefinido(String ppdStCodigo, String ccuStCodigo) {
        this.erpPedpredefinidoPK = new ErpPedpredefinidoPK(ppdStCodigo, ccuStCodigo);
    }

    public ErpPedpredefinidoPK getErpPedpredefinidoPK() {
        return erpPedpredefinidoPK;
    }

    public void setErpPedpredefinidoPK(ErpPedpredefinidoPK erpPedpredefinidoPK) {
        this.erpPedpredefinidoPK = erpPedpredefinidoPK;
    }

    public String getPpdStDescricao() {
        return ppdStDescricao;
    }

    public void setPpdStDescricao(String ppdStDescricao) {
        this.ppdStDescricao = ppdStDescricao;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public Date getPpdDtDatacriacao() {
        return ppdDtDatacriacao;
    }

    public void setPpdDtDatacriacao(Date ppdDtDatacriacao) {
        this.ppdDtDatacriacao = ppdDtDatacriacao;
    }

    public Date getPpdDtAlteradoem() {
        return ppdDtAlteradoem;
    }

    public void setPpdDtAlteradoem(Date ppdDtAlteradoem) {
        this.ppdDtAlteradoem = ppdDtAlteradoem;
    }

    public String getPpdChAtivo() {
        return ppdChAtivo;
    }

    public void setPpdChAtivo(String ppdChAtivo) {
        this.ppdChAtivo = ppdChAtivo;
    }

    public String getPedStTipopedido() {
        return pedStTipopedido;
    }

    public void setPedStTipopedido(String pedStTipopedido) {
        this.pedStTipopedido = pedStTipopedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpPedpredefinidoPK != null ? erpPedpredefinidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedpredefinido)) {
            return false;
        }
        ErpPedpredefinido other = (ErpPedpredefinido) object;
        if ((this.erpPedpredefinidoPK == null && other.erpPedpredefinidoPK != null) || (this.erpPedpredefinidoPK != null && !this.erpPedpredefinidoPK.equals(other.erpPedpredefinidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedpredefinido[ erpPedpredefinidoPK=" + erpPedpredefinidoPK + " ]";
    }
    
}
