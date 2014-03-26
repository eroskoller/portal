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
@Table(name = "ERP_TVCIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpTvcie.findAll", query = "SELECT e FROM ErpTvcie e"),
    @NamedQuery(name = "ErpTvcie.findByTvcStArquivo", query = "SELECT e FROM ErpTvcie e WHERE e.erpTvciePK.tvcStArquivo = :tvcStArquivo"),
    @NamedQuery(name = "ErpTvcie.findByUniStCodigo", query = "SELECT e FROM ErpTvcie e WHERE e.erpTvciePK.uniStCodigo = :uniStCodigo"),
    @NamedQuery(name = "ErpTvcie.findByUsuStCodigo", query = "SELECT e FROM ErpTvcie e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpTvcie.findByTvcDtData", query = "SELECT e FROM ErpTvcie e WHERE e.tvcDtData = :tvcDtData"),
    @NamedQuery(name = "ErpTvcie.findByTvcDtShow", query = "SELECT e FROM ErpTvcie e WHERE e.tvcDtShow = :tvcDtShow"),
    @NamedQuery(name = "ErpTvcie.findByTvcChAtivo", query = "SELECT e FROM ErpTvcie e WHERE e.tvcChAtivo = :tvcChAtivo"),
    @NamedQuery(name = "ErpTvcie.findByTvcInRepetir", query = "SELECT e FROM ErpTvcie e WHERE e.tvcInRepetir = :tvcInRepetir"),
    @NamedQuery(name = "ErpTvcie.findByTvcStArquivonome", query = "SELECT e FROM ErpTvcie e WHERE e.tvcStArquivonome = :tvcStArquivonome")})
public class ErpTvcie implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpTvciePK erpTvciePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TVC_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date tvcDtData;
    @Column(name = "TVC_DT_SHOW")
    @Temporal(TemporalType.DATE)
    private Date tvcDtShow;
    @Size(max = 1)
    @Column(name = "TVC_CH_ATIVO")
    private String tvcChAtivo;
    @Column(name = "TVC_IN_REPETIR")
    private BigInteger tvcInRepetir;
    @Size(max = 100)
    @Column(name = "TVC_ST_ARQUIVONOME")
    private String tvcStArquivonome;

    public ErpTvcie() {
    }

    public ErpTvcie(ErpTvciePK erpTvciePK) {
        this.erpTvciePK = erpTvciePK;
    }

    public ErpTvcie(ErpTvciePK erpTvciePK, String usuStCodigo, Date tvcDtData) {
        this.erpTvciePK = erpTvciePK;
        this.usuStCodigo = usuStCodigo;
        this.tvcDtData = tvcDtData;
    }

    public ErpTvcie(String tvcStArquivo, String uniStCodigo) {
        this.erpTvciePK = new ErpTvciePK(tvcStArquivo, uniStCodigo);
    }

    public ErpTvciePK getErpTvciePK() {
        return erpTvciePK;
    }

    public void setErpTvciePK(ErpTvciePK erpTvciePK) {
        this.erpTvciePK = erpTvciePK;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public Date getTvcDtData() {
        return tvcDtData;
    }

    public void setTvcDtData(Date tvcDtData) {
        this.tvcDtData = tvcDtData;
    }

    public Date getTvcDtShow() {
        return tvcDtShow;
    }

    public void setTvcDtShow(Date tvcDtShow) {
        this.tvcDtShow = tvcDtShow;
    }

    public String getTvcChAtivo() {
        return tvcChAtivo;
    }

    public void setTvcChAtivo(String tvcChAtivo) {
        this.tvcChAtivo = tvcChAtivo;
    }

    public BigInteger getTvcInRepetir() {
        return tvcInRepetir;
    }

    public void setTvcInRepetir(BigInteger tvcInRepetir) {
        this.tvcInRepetir = tvcInRepetir;
    }

    public String getTvcStArquivonome() {
        return tvcStArquivonome;
    }

    public void setTvcStArquivonome(String tvcStArquivonome) {
        this.tvcStArquivonome = tvcStArquivonome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpTvciePK != null ? erpTvciePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpTvcie)) {
            return false;
        }
        ErpTvcie other = (ErpTvcie) object;
        if ((this.erpTvciePK == null && other.erpTvciePK != null) || (this.erpTvciePK != null && !this.erpTvciePK.equals(other.erpTvciePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpTvcie[ erpTvciePK=" + erpTvciePK + " ]";
    }
    
}
