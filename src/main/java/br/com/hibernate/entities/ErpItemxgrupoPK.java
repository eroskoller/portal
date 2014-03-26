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
public class ErpItemxgrupoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "GRP_ST_CODIGO")
    private String grpStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;

    public ErpItemxgrupoPK() {
    }

    public ErpItemxgrupoPK(String grpStCodigo, String itmStCodigo) {
        this.grpStCodigo = grpStCodigo;
        this.itmStCodigo = itmStCodigo;
    }

    public String getGrpStCodigo() {
        return grpStCodigo;
    }

    public void setGrpStCodigo(String grpStCodigo) {
        this.grpStCodigo = grpStCodigo;
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
        hash += (grpStCodigo != null ? grpStCodigo.hashCode() : 0);
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemxgrupoPK)) {
            return false;
        }
        ErpItemxgrupoPK other = (ErpItemxgrupoPK) object;
        if ((this.grpStCodigo == null && other.grpStCodigo != null) || (this.grpStCodigo != null && !this.grpStCodigo.equals(other.grpStCodigo))) {
            return false;
        }
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemxgrupoPK[ grpStCodigo=" + grpStCodigo + ", itmStCodigo=" + itmStCodigo + " ]";
    }
    
}
