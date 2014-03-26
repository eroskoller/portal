/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import com.thoughtworks.xstream.XStream;
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
public class ErpEstabelecimentoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "RGI_ST_LETRA")
    private String rgiStLetra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "RGI_ST_CODIGO")
    private String rgiStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "EST_ST_CODIGO")
    private String estStCodigo;

    public ErpEstabelecimentoPK() {
    }

    public ErpEstabelecimentoPK(String rgiStLetra, String rgiStCodigo, String estStCodigo) {
        this.rgiStLetra = rgiStLetra;
        this.rgiStCodigo = rgiStCodigo;
        this.estStCodigo = estStCodigo;
    }

    public String getRgiStLetra() {
        return rgiStLetra;
    }

    public void setRgiStLetra(String rgiStLetra) {
        this.rgiStLetra = rgiStLetra;
    }

    public String getRgiStCodigo() {
        return rgiStCodigo;
    }

    public void setRgiStCodigo(String rgiStCodigo) {
        this.rgiStCodigo = rgiStCodigo;
    }

    public String getEstStCodigo() {
        return estStCodigo;
    }

    public void setEstStCodigo(String estStCodigo) {
        this.estStCodigo = estStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rgiStLetra != null ? rgiStLetra.hashCode() : 0);
        hash += (rgiStCodigo != null ? rgiStCodigo.hashCode() : 0);
        hash += (estStCodigo != null ? estStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpEstabelecimentoPK)) {
            return false;
        }
        ErpEstabelecimentoPK other = (ErpEstabelecimentoPK) object;
        if ((this.rgiStLetra == null && other.rgiStLetra != null) || (this.rgiStLetra != null && !this.rgiStLetra.equals(other.rgiStLetra))) {
            return false;
        }
        if ((this.rgiStCodigo == null && other.rgiStCodigo != null) || (this.rgiStCodigo != null && !this.rgiStCodigo.equals(other.rgiStCodigo))) {
            return false;
        }
        if ((this.estStCodigo == null && other.estStCodigo != null) || (this.estStCodigo != null && !this.estStCodigo.equals(other.estStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        XStream xstream = new XStream();
        return  xstream.toXML(this);
//        return "br.com.hibernate.entities.ErpEstabelecimentoPK[ rgiStLetra=" + rgiStLetra + ", rgiStCodigo=" + rgiStCodigo + ", estStCodigo=" + estStCodigo + " ]";
    }
    
}
