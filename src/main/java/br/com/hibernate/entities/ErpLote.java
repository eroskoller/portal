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
@Table(name = "ERP_LOTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpLote.findAll", query = "SELECT e FROM ErpLote e"),
    @NamedQuery(name = "ErpLote.findByLotInCodigo", query = "SELECT e FROM ErpLote e WHERE e.lotInCodigo = :lotInCodigo"),
    @NamedQuery(name = "ErpLote.findByLotDtData", query = "SELECT e FROM ErpLote e WHERE e.lotDtData = :lotDtData"),
    @NamedQuery(name = "ErpLote.findByUsuStCodigo", query = "SELECT e FROM ErpLote e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpLote.findByLotStNomearquivocsv", query = "SELECT e FROM ErpLote e WHERE e.lotStNomearquivocsv = :lotStNomearquivocsv"),
    @NamedQuery(name = "ErpLote.findByLotInQtdepedidos", query = "SELECT e FROM ErpLote e WHERE e.lotInQtdepedidos = :lotInQtdepedidos"),
    @NamedQuery(name = "ErpLote.findByLotInReimpressao", query = "SELECT e FROM ErpLote e WHERE e.lotInReimpressao = :lotInReimpressao"),
    @NamedQuery(name = "ErpLote.findByPedStCodigos", query = "SELECT e FROM ErpLote e WHERE e.pedStCodigos = :pedStCodigos")})
public class ErpLote implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOT_IN_CODIGO")
    private BigDecimal lotInCodigo;
    @Column(name = "LOT_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date lotDtData;
    @Size(max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Size(max = 1000)
    @Column(name = "LOT_ST_NOMEARQUIVOCSV")
    private String lotStNomearquivocsv;
    @Lob
    @Column(name = "LOT_CL_ARQUIVOCSV")
    private String lotClArquivocsv;
    @Column(name = "LOT_IN_QTDEPEDIDOS")
    private BigInteger lotInQtdepedidos;
    @Column(name = "LOT_IN_REIMPRESSAO")
    private BigInteger lotInReimpressao;
    @Size(max = 4000)
    @Column(name = "PED_ST_CODIGOS")
    private String pedStCodigos;

    public ErpLote() {
    }

    public ErpLote(BigDecimal lotInCodigo) {
        this.lotInCodigo = lotInCodigo;
    }

    public BigDecimal getLotInCodigo() {
        return lotInCodigo;
    }

    public void setLotInCodigo(BigDecimal lotInCodigo) {
        this.lotInCodigo = lotInCodigo;
    }

    public Date getLotDtData() {
        return lotDtData;
    }

    public void setLotDtData(Date lotDtData) {
        this.lotDtData = lotDtData;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getLotStNomearquivocsv() {
        return lotStNomearquivocsv;
    }

    public void setLotStNomearquivocsv(String lotStNomearquivocsv) {
        this.lotStNomearquivocsv = lotStNomearquivocsv;
    }

    public String getLotClArquivocsv() {
        return lotClArquivocsv;
    }

    public void setLotClArquivocsv(String lotClArquivocsv) {
        this.lotClArquivocsv = lotClArquivocsv;
    }

    public BigInteger getLotInQtdepedidos() {
        return lotInQtdepedidos;
    }

    public void setLotInQtdepedidos(BigInteger lotInQtdepedidos) {
        this.lotInQtdepedidos = lotInQtdepedidos;
    }

    public BigInteger getLotInReimpressao() {
        return lotInReimpressao;
    }

    public void setLotInReimpressao(BigInteger lotInReimpressao) {
        this.lotInReimpressao = lotInReimpressao;
    }

    public String getPedStCodigos() {
        return pedStCodigos;
    }

    public void setPedStCodigos(String pedStCodigos) {
        this.pedStCodigos = pedStCodigos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lotInCodigo != null ? lotInCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpLote)) {
            return false;
        }
        ErpLote other = (ErpLote) object;
        if ((this.lotInCodigo == null && other.lotInCodigo != null) || (this.lotInCodigo != null && !this.lotInCodigo.equals(other.lotInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpLote[ lotInCodigo=" + lotInCodigo + " ]";
    }
    
}
