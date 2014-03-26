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
public class ErpTvciePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TVC_ST_ARQUIVO")
    private String tvcStArquivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;

    public ErpTvciePK() {
    }

    public ErpTvciePK(String tvcStArquivo, String uniStCodigo) {
        this.tvcStArquivo = tvcStArquivo;
        this.uniStCodigo = uniStCodigo;
    }

    public String getTvcStArquivo() {
        return tvcStArquivo;
    }

    public void setTvcStArquivo(String tvcStArquivo) {
        this.tvcStArquivo = tvcStArquivo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tvcStArquivo != null ? tvcStArquivo.hashCode() : 0);
        hash += (uniStCodigo != null ? uniStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpTvciePK)) {
            return false;
        }
        ErpTvciePK other = (ErpTvciePK) object;
        if ((this.tvcStArquivo == null && other.tvcStArquivo != null) || (this.tvcStArquivo != null && !this.tvcStArquivo.equals(other.tvcStArquivo))) {
            return false;
        }
        if ((this.uniStCodigo == null && other.uniStCodigo != null) || (this.uniStCodigo != null && !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpTvciePK[ tvcStArquivo=" + tvcStArquivo + ", uniStCodigo=" + uniStCodigo + " ]";
    }
    
}
