/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ricardo
 */
@Embeddable
public class LabPerfilUsuarioModuloPK implements Serializable{
    
    
    @Column(name="PUS_ST_CODIGO")
    private String pusStCodigo;
    @Column(name="PUS_IN_SEQUENCIA")
    private Long pusInSequencia;

    public Long getPusInSequencia() {
        return pusInSequencia;
    }

    public void setPusInSequencia(Long pusInSequencia) {
        this.pusInSequencia = pusInSequencia;
    }


    public String getPusStCodigo() {
        return pusStCodigo;
    }

    public void setPusStCodigo(String pusStCodigo) {
        this.pusStCodigo = pusStCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabPerfilUsuarioModuloPK other = (LabPerfilUsuarioModuloPK) obj;
        if ((this.pusStCodigo == null) ? (other.pusStCodigo != null) : !this.pusStCodigo.equals(other.pusStCodigo)) {
            return false;
        }
        if (this.pusInSequencia != other.pusInSequencia && (this.pusInSequencia == null || !this.pusInSequencia.equals(other.pusInSequencia))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.pusStCodigo != null ? this.pusStCodigo.hashCode() : 0);
        hash = 83 * hash + (this.pusInSequencia != null ? this.pusInSequencia.hashCode() : 0);
        return hash;
    }

    
    
    
    
    
    
}
