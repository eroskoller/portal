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
public class ErpFornecedorescodigosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FDO_ST_CODIGO")
    private String fdoStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String itmStCodigo;

    public ErpFornecedorescodigosPK() {
    }

    public ErpFornecedorescodigosPK(String fdoStCodigo, String itmStCodigo) {
        this.fdoStCodigo = fdoStCodigo;
        this.itmStCodigo = itmStCodigo;
    }

    public String getFdoStCodigo() {
        return fdoStCodigo;
    }

    public void setFdoStCodigo(String fdoStCodigo) {
        this.fdoStCodigo = fdoStCodigo;
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
        hash += (fdoStCodigo != null ? fdoStCodigo.hashCode() : 0);
        hash += (itmStCodigo != null ? itmStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpFornecedorescodigosPK)) {
            return false;
        }
        ErpFornecedorescodigosPK other = (ErpFornecedorescodigosPK) object;
        if ((this.fdoStCodigo == null && other.fdoStCodigo != null) || (this.fdoStCodigo != null && !this.fdoStCodigo.equals(other.fdoStCodigo))) {
            return false;
        }
        if ((this.itmStCodigo == null && other.itmStCodigo != null) || (this.itmStCodigo != null && !this.itmStCodigo.equals(other.itmStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpFornecedorescodigosPK[ fdoStCodigo=" + fdoStCodigo + ", itmStCodigo=" + itmStCodigo + " ]";
    }
    
}
