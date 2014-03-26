/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_USUARIOSISTEMA")
public class LabUsuarioSistema implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected LabUsuarioSistemaPK labUsuarioSistemaPK;

    public LabUsuarioSistema() {
    }

    public LabUsuarioSistema(LabUsuarioSistemaPK labUsuarioSistemaPK) {
        this.labUsuarioSistemaPK = labUsuarioSistemaPK;
    }

    public LabUsuarioSistemaPK getLabUsuarioSistemaPK() {
        return labUsuarioSistemaPK;
    }

    public void setLabUsuarioSistemaPK(LabUsuarioSistemaPK labUsuarioSistemaPK) {
        this.labUsuarioSistemaPK = labUsuarioSistemaPK;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.labUsuarioSistemaPK);
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
        final LabUsuarioSistema other = (LabUsuarioSistema) obj;
        if (!Objects.equals(this.labUsuarioSistemaPK, other.labUsuarioSistemaPK)) {
            return false;
        }
        return true;
    }
    
    
    
}
