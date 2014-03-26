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
public class ErpItemdeparaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "MAR_ST_CODIGO")
    private String marStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IDP_ST_CODIGO")
    private String idpStCodigo;

    public ErpItemdeparaPK() {
    }

    public ErpItemdeparaPK(String marStCodigo, String itmStCodigo, String idpStCodigo) {
        this.marStCodigo = marStCodigo;
        this.itmStCodigo = itmStCodigo;
        this.idpStCodigo = idpStCodigo;
    }

    public String getMarStCodigo() {
        return marStCodigo;
    }

    public void setMarStCodigo(String marStCodigo) {
        this.marStCodigo = marStCodigo;
    }

    public String getItmStCodigo() {
        return itmStCodigo;
    }

    public void setItmStCodigo(String itmStCodigo) {
        this.itmStCodigo = itmStCodigo;
    }

    public String getIdpStCodigo() {
        return idpStCodigo;
    }

    public void setIdpStCodigo(String idpStCodigo) {
        this.idpStCodigo = idpStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marStCodigo != null ? marStCodigo.hashCode() : 0);
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        hash += (idpStCodigo != null ? idpStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpItemdeparaPK)) {
            return false;
        }
        ErpItemdeparaPK other = (ErpItemdeparaPK) object;
        if ((this.marStCodigo == null && other.marStCodigo != null) || (this.marStCodigo != null && !this.marStCodigo.equals(other.marStCodigo))) {
            return false;
        }
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        if ((this.idpStCodigo == null && other.idpStCodigo != null) || (this.idpStCodigo != null && !this.idpStCodigo.equals(other.idpStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpItemdeparaPK[ marStCodigo=" + marStCodigo + ", itmStCodigo=" + itmStCodigo + ", idpStCodigo=" + idpStCodigo + " ]";
    }
    
}
