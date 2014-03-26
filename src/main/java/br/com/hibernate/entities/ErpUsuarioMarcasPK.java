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
public class ErpUsuarioMarcasPK implements Serializable{
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "MAR_ST_CODIGO")
    private String marStCodigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;

    public ErpUsuarioMarcasPK() {
    }

    public ErpUsuarioMarcasPK(String marStCodigo, String usuStCodigo) {
        this.marStCodigo = marStCodigo;
        this.usuStCodigo = usuStCodigo;
    }

    public String getMarStCodigo() {
        return marStCodigo;
    }

    public void setMarStCodigo(String marStCodigo) {
        this.marStCodigo = marStCodigo;
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
        final ErpUsuarioMarcasPK other = (ErpUsuarioMarcasPK) obj;
        if ((this.marStCodigo == null) ? (other.marStCodigo != null) : !this.marStCodigo.equals(other.marStCodigo)) {
            return false;
        }
        if ((this.usuStCodigo == null) ? (other.usuStCodigo != null) : !this.usuStCodigo.equals(other.usuStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.marStCodigo != null ? this.marStCodigo.hashCode() : 0);
        hash = 59 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ErpUsuarioMarcasPK{" + "marStCodigo=" + marStCodigo + ", usuStCodigo=" + usuStCodigo + '}';
    }
    
    
    
}
