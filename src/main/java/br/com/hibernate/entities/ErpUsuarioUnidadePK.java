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
public class ErpUsuarioUnidadePK implements Serializable{
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;

    public ErpUsuarioUnidadePK() {
    }

    public ErpUsuarioUnidadePK(String uniStCodigo, String usuStCodigo) {
        this.uniStCodigo = uniStCodigo;
        this.usuStCodigo = usuStCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErpUsuarioUnidadePK other = (ErpUsuarioUnidadePK) obj;
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        if ((this.usuStCodigo == null) ? (other.usuStCodigo != null) : !this.usuStCodigo.equals(other.usuStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ErpUsuarioUnidadePK{" + "uniStCodigo=" + uniStCodigo + ", usuStCodigo=" + usuStCodigo + '}';
    }
    
    
    
}
