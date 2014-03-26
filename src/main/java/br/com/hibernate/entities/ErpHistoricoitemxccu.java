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
@Table(name = "ERP_HISTORICOITEMXCCU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpHistoricoitemxccu.findAll", query = "SELECT e FROM ErpHistoricoitemxccu e"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByHicInCodigo", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.hicInCodigo = :hicInCodigo"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByCcuStCodigo", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.ccuStCodigo = :ccuStCodigo"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByItmStCodigo", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByUsuStCodigo", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByItcInQtde", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.itcInQtde = :itcInQtde"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByItcInQtdeold", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.itcInQtdeold = :itcInQtdeold"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByItcInPrazo", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.itcInPrazo = :itcInPrazo"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByItcInPrazoold", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.itcInPrazoold = :itcInPrazoold"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByHicDtData", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.hicDtData = :hicDtData"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByHicClAcao", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.hicClAcao = :hicClAcao"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByItcChAtivo", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.itcChAtivo = :itcChAtivo"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByEstStFiscal", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.estStFiscal = :estStFiscal"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByEstStFiscalold", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.estStFiscalold = :estStFiscalold"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByAcsStCodigo", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.acsStCodigo = :acsStCodigo"),
    @NamedQuery(name = "ErpHistoricoitemxccu.findByItcChItemmanual", query = "SELECT e FROM ErpHistoricoitemxccu e WHERE e.itcChItemmanual = :itcChItemmanual")})
public class ErpHistoricoitemxccu implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIC_IN_CODIGO")
    private BigDecimal hicInCodigo;
    @Size(max = 20)
    @Column(name = "CCU_ST_CODIGO")
    private String ccuStCodigo;
    @Size(max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name = "ITC_IN_QTDE")
    private BigInteger itcInQtde;
    @Column(name = "ITC_IN_QTDEOLD")
    private BigInteger itcInQtdeold;
    @Column(name = "ITC_IN_PRAZO")
    private BigInteger itcInPrazo;
    @Column(name = "ITC_IN_PRAZOOLD")
    private BigInteger itcInPrazoold;
    @Column(name = "HIC_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date hicDtData;
    @Size(max = 4000)
    @Column(name = "HIC_CL_ACAO")
    private String hicClAcao;
    @Column(name = "ITC_CH_ATIVO")
    private Character itcChAtivo;
    @Size(max = 3)
    @Column(name = "EST_ST_FISCAL")
    private String estStFiscal;
    @Size(max = 3)
    @Column(name = "EST_ST_FISCALOLD")
    private String estStFiscalold;
    @Size(max = 6)
    @Column(name = "ACS_ST_CODIGO")
    private String acsStCodigo;
    @Column(name = "ITC_CH_ITEMMANUAL")
    private Character itcChItemmanual;

    public ErpHistoricoitemxccu() {
    }

    public ErpHistoricoitemxccu(BigDecimal hicInCodigo) {
        this.hicInCodigo = hicInCodigo;
    }

    public BigDecimal getHicInCodigo() {
        return hicInCodigo;
    }

    public void setHicInCodigo(BigDecimal hicInCodigo) {
        this.hicInCodigo = hicInCodigo;
    }

    public String getCcuStCodigo() {
        return ccuStCodigo;
    }

    public void setCcuStCodigo(String ccuStCodigo) {
        this.ccuStCodigo = ccuStCodigo;
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

    public BigInteger getItcInQtde() {
        return itcInQtde;
    }

    public void setItcInQtde(BigInteger itcInQtde) {
        this.itcInQtde = itcInQtde;
    }

    public BigInteger getItcInQtdeold() {
        return itcInQtdeold;
    }

    public void setItcInQtdeold(BigInteger itcInQtdeold) {
        this.itcInQtdeold = itcInQtdeold;
    }

    public BigInteger getItcInPrazo() {
        return itcInPrazo;
    }

    public void setItcInPrazo(BigInteger itcInPrazo) {
        this.itcInPrazo = itcInPrazo;
    }

    public BigInteger getItcInPrazoold() {
        return itcInPrazoold;
    }

    public void setItcInPrazoold(BigInteger itcInPrazoold) {
        this.itcInPrazoold = itcInPrazoold;
    }

    public Date getHicDtData() {
        return hicDtData;
    }

    public void setHicDtData(Date hicDtData) {
        this.hicDtData = hicDtData;
    }

    public String getHicClAcao() {
        return hicClAcao;
    }

    public void setHicClAcao(String hicClAcao) {
        this.hicClAcao = hicClAcao;
    }

    public Character getItcChAtivo() {
        return itcChAtivo;
    }

    public void setItcChAtivo(Character itcChAtivo) {
        this.itcChAtivo = itcChAtivo;
    }

    public String getEstStFiscal() {
        return estStFiscal;
    }

    public void setEstStFiscal(String estStFiscal) {
        this.estStFiscal = estStFiscal;
    }

    public String getEstStFiscalold() {
        return estStFiscalold;
    }

    public void setEstStFiscalold(String estStFiscalold) {
        this.estStFiscalold = estStFiscalold;
    }

    public String getAcsStCodigo() {
        return acsStCodigo;
    }

    public void setAcsStCodigo(String acsStCodigo) {
        this.acsStCodigo = acsStCodigo;
    }

    public Character getItcChItemmanual() {
        return itcChItemmanual;
    }

    public void setItcChItemmanual(Character itcChItemmanual) {
        this.itcChItemmanual = itcChItemmanual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hicInCodigo != null ? hicInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpHistoricoitemxccu)) {
            return false;
        }
        ErpHistoricoitemxccu other = (ErpHistoricoitemxccu) object;
        if ((this.hicInCodigo == null && other.hicInCodigo != null) || (this.hicInCodigo != null && !this.hicInCodigo.equals(other.hicInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpHistoricoitemxccu[ hicInCodigo=" + hicInCodigo + " ]";
    }
    
}
