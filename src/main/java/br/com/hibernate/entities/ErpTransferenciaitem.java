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
@Table(name = "ERP_TRANSFERENCIAITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpTransferenciaitem.findAll", query = "SELECT e FROM ErpTransferenciaitem e"),
    @NamedQuery(name = "ErpTransferenciaitem.findByTrfInCodigo", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.erpTransferenciaitemPK.trfInCodigo = :trfInCodigo"),
    @NamedQuery(name = "ErpTransferenciaitem.findByItmStCodigo", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.erpTransferenciaitemPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpTransferenciaitem.findByTfiInQtde", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.tfiInQtde = :tfiInQtde"),
    @NamedQuery(name = "ErpTransferenciaitem.findByTfiStLote", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.tfiStLote = :tfiStLote"),
    @NamedQuery(name = "ErpTransferenciaitem.findByTfiDtValidade", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.tfiDtValidade = :tfiDtValidade"),
    @NamedQuery(name = "ErpTransferenciaitem.findByTfiChAtivo", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.tfiChAtivo = :tfiChAtivo"),
    @NamedQuery(name = "ErpTransferenciaitem.findByTfiStObs", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.tfiStObs = :tfiStObs"),
    @NamedQuery(name = "ErpTransferenciaitem.findByTfiInQtdeentregue", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.tfiInQtdeentregue = :tfiInQtdeentregue"),
    @NamedQuery(name = "ErpTransferenciaitem.findByTfiInSequencia", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.tfiInSequencia = :tfiInSequencia"),
    @NamedQuery(name = "ErpTransferenciaitem.findByIprDtValidade", query = "SELECT e FROM ErpTransferenciaitem e WHERE e.iprDtValidade = :iprDtValidade")})
public class ErpTransferenciaitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpTransferenciaitemPK erpTransferenciaitemPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TFI_IN_QTDE")
    private BigInteger tfiInQtde;
    @Size(max = 20)
    @Column(name = "TFI_ST_LOTE")
    private String tfiStLote;
    @Column(name = "TFI_DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date tfiDtValidade;
    @Size(max = 1)
    @Column(name = "TFI_CH_ATIVO")
    private String tfiChAtivo;
    @Size(max = 1000)
    @Column(name = "TFI_ST_OBS")
    private String tfiStObs;
    @Column(name = "TFI_IN_QTDEENTREGUE")
    private BigInteger tfiInQtdeentregue;
    @Column(name = "TFI_IN_SEQUENCIA")
    private BigInteger tfiInSequencia;
    @Column(name = "IPR_DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date iprDtValidade;

    public ErpTransferenciaitem() {
    }

    public ErpTransferenciaitem(ErpTransferenciaitemPK erpTransferenciaitemPK) {
        this.erpTransferenciaitemPK = erpTransferenciaitemPK;
    }

    public ErpTransferenciaitem(ErpTransferenciaitemPK erpTransferenciaitemPK, BigInteger tfiInQtde) {
        this.erpTransferenciaitemPK = erpTransferenciaitemPK;
        this.tfiInQtde = tfiInQtde;
    }

    public ErpTransferenciaitem(BigInteger trfInCodigo, String itmStCodigo) {
        this.erpTransferenciaitemPK = new ErpTransferenciaitemPK(trfInCodigo, itmStCodigo);
    }

    public ErpTransferenciaitemPK getErpTransferenciaitemPK() {
        return erpTransferenciaitemPK;
    }

    public void setErpTransferenciaitemPK(ErpTransferenciaitemPK erpTransferenciaitemPK) {
        this.erpTransferenciaitemPK = erpTransferenciaitemPK;
    }

    public BigInteger getTfiInQtde() {
        return tfiInQtde;
    }

    public void setTfiInQtde(BigInteger tfiInQtde) {
        this.tfiInQtde = tfiInQtde;
    }

    public String getTfiStLote() {
        return tfiStLote;
    }

    public void setTfiStLote(String tfiStLote) {
        this.tfiStLote = tfiStLote;
    }

    public Date getTfiDtValidade() {
        return tfiDtValidade;
    }

    public void setTfiDtValidade(Date tfiDtValidade) {
        this.tfiDtValidade = tfiDtValidade;
    }

    public String getTfiChAtivo() {
        return tfiChAtivo;
    }

    public void setTfiChAtivo(String tfiChAtivo) {
        this.tfiChAtivo = tfiChAtivo;
    }

    public String getTfiStObs() {
        return tfiStObs;
    }

    public void setTfiStObs(String tfiStObs) {
        this.tfiStObs = tfiStObs;
    }

    public BigInteger getTfiInQtdeentregue() {
        return tfiInQtdeentregue;
    }

    public void setTfiInQtdeentregue(BigInteger tfiInQtdeentregue) {
        this.tfiInQtdeentregue = tfiInQtdeentregue;
    }

    public BigInteger getTfiInSequencia() {
        return tfiInSequencia;
    }

    public void setTfiInSequencia(BigInteger tfiInSequencia) {
        this.tfiInSequencia = tfiInSequencia;
    }

    public Date getIprDtValidade() {
        return iprDtValidade;
    }

    public void setIprDtValidade(Date iprDtValidade) {
        this.iprDtValidade = iprDtValidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpTransferenciaitemPK != null ? erpTransferenciaitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpTransferenciaitem)) {
            return false;
        }
        ErpTransferenciaitem other = (ErpTransferenciaitem) object;
        if ((this.erpTransferenciaitemPK == null && other.erpTransferenciaitemPK != null) || (this.erpTransferenciaitemPK != null && !this.erpTransferenciaitemPK.equals(other.erpTransferenciaitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpTransferenciaitem[ erpTransferenciaitemPK=" + erpTransferenciaitemPK + " ]";
    }
    
}
