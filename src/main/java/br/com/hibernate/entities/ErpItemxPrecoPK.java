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
public class ErpItemxPrecoPK implements Serializable{
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ITM_ST_CODIGO")
    private String iTmStCodigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FDO_ST_CODIGO")
    private String fDoStCodigo;

    public ErpItemxPrecoPK() {
    }

    public String getfDoStCodigo() {
        return fDoStCodigo;
    }

    public void setfDoStCodigo(String fDoStCodigo) {
        this.fDoStCodigo = fDoStCodigo;
    }

    public String getiTmStCodigo() {
        return iTmStCodigo;
    }

    public void setiTmStCodigo(String iTmStCodigo) {
        this.iTmStCodigo = iTmStCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErpItemxPrecoPK other = (ErpItemxPrecoPK) obj;
        if ((this.iTmStCodigo == null) ? (other.iTmStCodigo != null) : !this.iTmStCodigo.equals(other.iTmStCodigo)) {
            return false;
        }
        if ((this.fDoStCodigo == null) ? (other.fDoStCodigo != null) : !this.fDoStCodigo.equals(other.fDoStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.iTmStCodigo != null ? this.iTmStCodigo.hashCode() : 0);
        hash = 23 * hash + (this.fDoStCodigo != null ? this.fDoStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "EerpItemxPrecoPK{" + "iTmStCodigo=" + iTmStCodigo + ", fDoStCodigo=" + fDoStCodigo + '}';
    }
    
    
    
    
}
