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
@Table(name = "ERP_USUONLINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpUsuonline.findAll", query = "SELECT e FROM ErpUsuonline e"),
    @NamedQuery(name = "ErpUsuonline.findByUonInTempo", query = "SELECT e FROM ErpUsuonline e WHERE e.uonInTempo = :uonInTempo"),
    @NamedQuery(name = "ErpUsuonline.findByUonStIp", query = "SELECT e FROM ErpUsuonline e WHERE e.uonStIp = :uonStIp"),
    @NamedQuery(name = "ErpUsuonline.findByUsuStCodigo", query = "SELECT e FROM ErpUsuonline e WHERE e.usuStCodigo = :usuStCodigo"),
    @NamedQuery(name = "ErpUsuonline.findByUonDtDatahora", query = "SELECT e FROM ErpUsuonline e WHERE e.uonDtDatahora = :uonDtDatahora")})
public class ErpUsuonline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UON_IN_TEMPO")
    private BigInteger uonInTempo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "UON_ST_IP")
    private String uonStIp;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UON_DT_DATAHORA")
    @Temporal(TemporalType.DATE)
    private Date uonDtDatahora;

    public ErpUsuonline() {
    }

    public ErpUsuonline(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public ErpUsuonline(String usuStCodigo, BigInteger uonInTempo, String uonStIp, Date uonDtDatahora) {
        this.usuStCodigo = usuStCodigo;
        this.uonInTempo = uonInTempo;
        this.uonStIp = uonStIp;
        this.uonDtDatahora = uonDtDatahora;
    }

    public BigInteger getUonInTempo() {
        return uonInTempo;
    }

    public void setUonInTempo(BigInteger uonInTempo) {
        this.uonInTempo = uonInTempo;
    }

    public String getUonStIp() {
        return uonStIp;
    }

    public void setUonStIp(String uonStIp) {
        this.uonStIp = uonStIp;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public Date getUonDtDatahora() {
        return uonDtDatahora;
    }

    public void setUonDtDatahora(Date uonDtDatahora) {
        this.uonDtDatahora = uonDtDatahora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuStCodigo != null ? usuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpUsuonline)) {
            return false;
        }
        ErpUsuonline other = (ErpUsuonline) object;
        if ((this.usuStCodigo == null && other.usuStCodigo != null) || (this.usuStCodigo != null && !this.usuStCodigo.equals(other.usuStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpUsuonline[ usuStCodigo=" + usuStCodigo + " ]";
    }
    
}
