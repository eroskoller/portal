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
public class ErpOrigemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ORI_ST_CODIGO")
    private String oriStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;

    public ErpOrigemPK() {
    }

    public ErpOrigemPK(String oriStCodigo, String uniStCodigo) {
        this.oriStCodigo = oriStCodigo;
        this.uniStCodigo = uniStCodigo;
    }

    public String getOriStCodigo() {
        return oriStCodigo;
    }

    public void setOriStCodigo(String oriStCodigo) {
        this.oriStCodigo = oriStCodigo;
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
        hash += (oriStCodigo != null ? oriStCodigo.hashCode() : 0);
        hash += (uniStCodigo != null ? uniStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpOrigemPK)) {
            return false;
        }
        ErpOrigemPK other = (ErpOrigemPK) object;
        if ((this.oriStCodigo == null && other.oriStCodigo != null) || (this.oriStCodigo != null && !this.oriStCodigo.equals(other.oriStCodigo))) {
            return false;
        }
        if ((this.uniStCodigo == null && other.uniStCodigo != null) || (this.uniStCodigo != null && !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        XStream xstream = new XStream();
        return  xstream.toXML(this);
    }
    
}
