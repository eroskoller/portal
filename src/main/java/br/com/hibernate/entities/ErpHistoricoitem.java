/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ERP_HISTORICOITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpHistoricoitem.findAll", query = "SELECT e FROM ErpHistoricoitem e"),
    @NamedQuery(name = "ErpHistoricoitem.findByHiiInCodigo", query = "SELECT e FROM ErpHistoricoitem e WHERE e.hiiInCodigo = :hiiInCodigo"),
    @NamedQuery(name = "ErpHistoricoitem.findByItmStCodigo", query = "SELECT e FROM ErpHistoricoitem e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpHistoricoitem.findByItmStDescricaoOld", query = "SELECT e FROM ErpHistoricoitem e WHERE e.itmStDescricaoOld = :itmStDescricaoOld"),
    @NamedQuery(name = "ErpHistoricoitem.findByItmChAtivo", query = "SELECT e FROM ErpHistoricoitem e WHERE e.itmChAtivo = :itmChAtivo"),
    @NamedQuery(name = "ErpHistoricoitem.findByUsuStCodigo", query = "SELECT e FROM ErpHistoricoitem e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpHistoricoitem.findByHiiDtData", query = "SELECT e FROM ErpHistoricoitem e WHERE e.hiiDtData = :hiiDtData"),
    @NamedQuery(name = "ErpHistoricoitem.findByAcsStCodigo", query = "SELECT e FROM ErpHistoricoitem e WHERE e.acsStCodigo = :acsStCodigo"),
    @NamedQuery(name = "ErpHistoricoitem.findByItmChItemmanual", query = "SELECT e FROM ErpHistoricoitem e WHERE e.itmChItemmanual = :itmChItemmanual"),
    @NamedQuery(name = "ErpHistoricoitem.findByHiiStHistorico", query = "SELECT e FROM ErpHistoricoitem e WHERE e.hiiStHistorico = :hiiStHistorico"),
    @NamedQuery(name = "ErpHistoricoitem.findByItmStUnidadeOld", query = "SELECT e FROM ErpHistoricoitem e WHERE e.itmStUnidadeOld = :itmStUnidadeOld")})
public class ErpHistoricoitem implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HII_IN_CODIGO")
    private BigDecimal hiiInCodigo;
    @Size(max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Size(max = 500)
    @Column(name = "ITM_ST_DESCRICAO_OLD")
    private String itmStDescricaoOld;
    @Column(name = "ITM_CH_ATIVO")
    private Character itmChAtivo;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name = "HII_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date hiiDtData;
    @Size(max = 6)
    @Column(name = "ACS_ST_CODIGO")
    private String acsStCodigo;
    @Column(name = "ITM_CH_ITEMMANUAL")
    private Character itmChItemmanual;
    @Size(max = 4000)
    @Column(name = "HII_ST_HISTORICO")
    private String hiiStHistorico;
    @Size(max = 20)
    @Column(name = "ITM_ST_UNIDADE_OLD")
    private String itmStUnidadeOld;

    public ErpHistoricoitem() {
    }

    public ErpHistoricoitem(BigDecimal hiiInCodigo) {
        this.hiiInCodigo = hiiInCodigo;
    }

    public BigDecimal getHiiInCodigo() {
        return hiiInCodigo;
    }

    public void setHiiInCodigo(BigDecimal hiiInCodigo) {
        this.hiiInCodigo = hiiInCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getItmStDescricaoOld() {
        return itmStDescricaoOld;
    }

    public void setItmStDescricaoOld(String itmStDescricaoOld) {
        this.itmStDescricaoOld = itmStDescricaoOld;
    }

    public Character getItmChAtivo() {
        return itmChAtivo;
    }

    public void setItmChAtivo(Character itmChAtivo) {
        this.itmChAtivo = itmChAtivo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public Date getHiiDtData() {
        return hiiDtData;
    }

    public void setHiiDtData(Date hiiDtData) {
        this.hiiDtData = hiiDtData;
    }

    public String getAcsStCodigo() {
        return acsStCodigo;
    }

    public void setAcsStCodigo(String acsStCodigo) {
        this.acsStCodigo = acsStCodigo;
    }

    public Character getItmChItemmanual() {
        return itmChItemmanual;
    }

    public void setItmChItemmanual(Character itmChItemmanual) {
        this.itmChItemmanual = itmChItemmanual;
    }

    public String getHiiStHistorico() {
        return hiiStHistorico;
    }

    public void setHiiStHistorico(String hiiStHistorico) {
        this.hiiStHistorico = hiiStHistorico;
    }

    public String getItmStUnidadeOld() {
        return itmStUnidadeOld;
    }

    public void setItmStUnidadeOld(String itmStUnidadeOld) {
        this.itmStUnidadeOld = itmStUnidadeOld;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hiiInCodigo != null ? hiiInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpHistoricoitem)) {
            return false;
        }
        ErpHistoricoitem other = (ErpHistoricoitem) object;
        if ((this.hiiInCodigo == null && other.hiiInCodigo != null) || (this.hiiInCodigo != null && !this.hiiInCodigo.equals(other.hiiInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpHistoricoitem[ hiiInCodigo=" + hiiInCodigo + " ]";
    }
    
}
