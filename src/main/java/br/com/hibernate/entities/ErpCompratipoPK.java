/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
public class ErpCompratipoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTI_IN_CODIGO")
    private BigInteger ctiInCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CTI_ST_CODIGO")
    private String ctiStCodigo;

    public ErpCompratipoPK() {
    }

    public ErpCompratipoPK(BigInteger ctiInCodigo, String ctiStCodigo) {
        this.ctiInCodigo = ctiInCodigo;
        this.ctiStCodigo = ctiStCodigo;
    }

    public BigInteger getCtiInCodigo() {
        return ctiInCodigo;
    }

    public void setCtiInCodigo(BigInteger ctiInCodigo) {
        this.ctiInCodigo = ctiInCodigo;
    }

    public String getCtiStCodigo() {
        return ctiStCodigo;
    }

    public void setCtiStCodigo(String ctiStCodigo) {
        this.ctiStCodigo = ctiStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctiInCodigo != null ? ctiInCodigo.hashCode() : 0);
        hash += (ctiStCodigo != null ? ctiStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpCompratipoPK)) {
            return false;
        }
        ErpCompratipoPK other = (ErpCompratipoPK) object;
        if ((this.ctiInCodigo == null && other.ctiInCodigo != null) || (this.ctiInCodigo != null && !this.ctiInCodigo.equals(other.ctiInCodigo))) {
            return false;
        }
        if ((this.ctiStCodigo == null && other.ctiStCodigo != null) || (this.ctiStCodigo != null && !this.ctiStCodigo.equals(other.ctiStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpCompratipoPK[ ctiInCodigo=" + ctiInCodigo + ", ctiStCodigo=" + ctiStCodigo + " ]";
    }
    
}
