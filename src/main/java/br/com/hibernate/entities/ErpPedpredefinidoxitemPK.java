/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eros
 */
@Embeddable
public class ErpPedpredefinidoxitemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PPD_ST_CODIGO")
    private String ppdStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;

    public ErpPedpredefinidoxitemPK() {
    }

    public ErpPedpredefinidoxitemPK(String ppdStCodigo, String itmStCodigo) {
        this.ppdStCodigo = ppdStCodigo;
        this.itmStCodigo = itmStCodigo;
    }

    public String getPpdStCodigo() {
        return ppdStCodigo;
    }

    public void setPpdStCodigo(String ppdStCodigo) {
        this.ppdStCodigo = ppdStCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ppdStCodigo != null ? ppdStCodigo.hashCode() : 0);
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedpredefinidoxitemPK)) {
            return false;
        }
        ErpPedpredefinidoxitemPK other = (ErpPedpredefinidoxitemPK) object;
        if ((this.ppdStCodigo == null && other.ppdStCodigo != null) || (this.ppdStCodigo != null && !this.ppdStCodigo.equals(other.ppdStCodigo))) {
            return false;
        }
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedpredefinidoxitemPK[ ppdStCodigo=" + ppdStCodigo + ", itmStCodigo=" + itmStCodigo + " ]";
    }
    
}
