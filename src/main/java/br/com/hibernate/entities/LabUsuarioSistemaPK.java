/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author eros
 */
@Embeddable
public class LabUsuarioSistemaPK implements Serializable{
    
    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;
    
    @Column(name="SIS_ST_CODIGO")
    private String sisStCodigo;

    public LabUsuarioSistemaPK() {
    }

    public LabUsuarioSistemaPK(String usuStCodigo, String sisStCodigo) {
        this.usuStCodigo = usuStCodigo;
        this.sisStCodigo = sisStCodigo;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getSisStCodigo() {
        return sisStCodigo;
    }

    public void setSisStCodigo(String sisStCodigo) {
        this.sisStCodigo = sisStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.usuStCodigo);
        hash = 53 * hash + Objects.hashCode(this.sisStCodigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabUsuarioSistemaPK other = (LabUsuarioSistemaPK) obj;
        if (!Objects.equals(this.usuStCodigo, other.usuStCodigo)) {
            return false;
        }
        if (!Objects.equals(this.sisStCodigo, other.sisStCodigo)) {
            return false;
        }
        return true;
    }
    
    
    
}
