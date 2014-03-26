/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ricardo
 */
@Embeddable
public class LabUsuarioModuloPK implements Serializable{
     
    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;
    
    @ManyToOne
    @JoinColumn(name="MOD_ST_CODIGO")
    private LabModulo modStCodigo;

    public LabModulo getModStCodigo() {
        return modStCodigo;
    }

    public void setModStCodigo(LabModulo modStCodigo) {
        this.modStCodigo = modStCodigo;
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
        final LabUsuarioModuloPK other = (LabUsuarioModuloPK) obj;
        if ((this.usuStCodigo == null) ? (other.usuStCodigo != null) : !this.usuStCodigo.equals(other.usuStCodigo)) {
            return false;
        }
        if (this.modStCodigo != other.modStCodigo && (this.modStCodigo == null || !this.modStCodigo.equals(other.modStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        hash = 97 * hash + (this.modStCodigo != null ? this.modStCodigo.hashCode() : 0);
        return hash;
    }
    
     
}
