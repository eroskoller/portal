/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_COMPRATIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpCompratipo.findAll", query = "SELECT e FROM ErpCompratipo e"),
    @NamedQuery(name = "ErpCompratipo.findByCtiInCodigo", query = "SELECT e FROM ErpCompratipo e WHERE e.erpCompratipoPK.ctiInCodigo = :ctiInCodigo"),
    @NamedQuery(name = "ErpCompratipo.findByCtiStCodigo", query = "SELECT e FROM ErpCompratipo e WHERE e.erpCompratipoPK.ctiStCodigo = :ctiStCodigo"),
    @NamedQuery(name = "ErpCompratipo.findByCtiStDescricao", query = "SELECT e FROM ErpCompratipo e WHERE e.ctiStDescricao = :ctiStDescricao"),
    @NamedQuery(name = "ErpCompratipo.findByCtiChAtivo", query = "SELECT e FROM ErpCompratipo e WHERE e.ctiChAtivo = :ctiChAtivo"),
    @NamedQuery(name = "ErpCompratipo.findByCtiStDestaque", query = "SELECT e FROM ErpCompratipo e WHERE e.ctiStDestaque = :ctiStDestaque"),
    @NamedQuery(name = "ErpCompratipo.findByCtiStAbreviados", query = "SELECT e FROM ErpCompratipo e WHERE e.ctiStAbreviados = :ctiStAbreviados")})
public class ErpCompratipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpCompratipoPK erpCompratipoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "CTI_ST_DESCRICAO")
    private String ctiStDescricao;
    @Size(max = 1)
    @Column(name = "CTI_CH_ATIVO")
    private String ctiChAtivo;
    @Size(max = 10)
    @Column(name = "CTI_ST_DESTAQUE")
    private String ctiStDestaque;
    @Size(max = 60)
    @Column(name = "CTI_ST_ABREVIADOS")
    private String ctiStAbreviados;

    public ErpCompratipo() {
    }

    public ErpCompratipo(ErpCompratipoPK erpCompratipoPK) {
        this.erpCompratipoPK = erpCompratipoPK;
    }

    public ErpCompratipo(ErpCompratipoPK erpCompratipoPK, String ctiStDescricao) {
        this.erpCompratipoPK = erpCompratipoPK;
        this.ctiStDescricao = ctiStDescricao;
    }

    public ErpCompratipo(BigInteger ctiInCodigo, String ctiStCodigo) {
        this.erpCompratipoPK = new ErpCompratipoPK(ctiInCodigo, ctiStCodigo);
    }

    public ErpCompratipoPK getErpCompratipoPK() {
        return erpCompratipoPK;
    }

    public void setErpCompratipoPK(ErpCompratipoPK erpCompratipoPK) {
        this.erpCompratipoPK = erpCompratipoPK;
    }

    public String getCtiStDescricao() {
        return ctiStDescricao;
    }

    public void setCtiStDescricao(String ctiStDescricao) {
        this.ctiStDescricao = ctiStDescricao;
    }

    public String getCtiChAtivo() {
        return ctiChAtivo;
    }

    public void setCtiChAtivo(String ctiChAtivo) {
        this.ctiChAtivo = ctiChAtivo;
    }

    public String getCtiStDestaque() {
        return ctiStDestaque;
    }

    public void setCtiStDestaque(String ctiStDestaque) {
        this.ctiStDestaque = ctiStDestaque;
    }

    public String getCtiStAbreviados() {
        return ctiStAbreviados;
    }

    public void setCtiStAbreviados(String ctiStAbreviados) {
        this.ctiStAbreviados = ctiStAbreviados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpCompratipoPK != null ? erpCompratipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCompratipo)) {
            return false;
        }
        ErpCompratipo other = (ErpCompratipo) object;
        if ((this.erpCompratipoPK == null && other.erpCompratipoPK != null) || (this.erpCompratipoPK != null && !this.erpCompratipoPK.equals(other.erpCompratipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCompratipo[ erpCompratipoPK=" + erpCompratipoPK + " ]";
    }
    
}
