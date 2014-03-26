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
public class ErpRegionalPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "RGI_ST_LETRA")
    private String rgiStLetra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "RGI_ST_CODIGO")
    private String rgiStCodigo;

    public ErpRegionalPK() {
    }

    public ErpRegionalPK(String rgiStLetra, String rgiStCodigo) {
        this.rgiStLetra = rgiStLetra;
        this.rgiStCodigo = rgiStCodigo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rgiStLetra != null ? rgiStLetra.hashCode() : 0);
        hash += (rgiStCodigo != null ? rgiStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpRegionalPK)) {
            return false;
        }
        ErpRegionalPK other = (ErpRegionalPK) object;
        if ((this.rgiStLetra == null && other.rgiStLetra != null) || (this.rgiStLetra != null && !this.rgiStLetra.equals(other.rgiStLetra))) {
            return false;
        }
        if ((this.rgiStCodigo == null && other.rgiStCodigo != null) || (this.rgiStCodigo != null && !this.rgiStCodigo.equals(other.rgiStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        XStream xstream = new XStream();
        return  xstream.toXML(this);
//        return "br.com.hibernate.entities.ErpRegionalPK[ rgiStLetra=" + rgiStLetra + ", rgiStCodigo=" + rgiStCodigo + " ]";
    }
    
}
