/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_USUARIOMARCAS")
public class ErpUsuarioMarcas implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpUsuarioMarcasPK erpUsuarioMarcasPK;

    public ErpUsuarioMarcas() {
    }

    public ErpUsuarioMarcas(ErpUsuarioMarcasPK erpUsuarioMarcasPK) {
        this.erpUsuarioMarcasPK = erpUsuarioMarcasPK;
    }

    public ErpUsuarioMarcasPK getErpUsuarioMarcasPK() {
        return erpUsuarioMarcasPK;
    }

    public void setErpUsuarioMarcasPK(ErpUsuarioMarcasPK erpUsuarioMarcasPK) {
        this.erpUsuarioMarcasPK = erpUsuarioMarcasPK;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErpUsuarioMarcas other = (ErpUsuarioMarcas) obj;
        if (this.erpUsuarioMarcasPK != other.erpUsuarioMarcasPK && (this.erpUsuarioMarcasPK == null || !this.erpUsuarioMarcasPK.equals(other.erpUsuarioMarcasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.erpUsuarioMarcasPK != null ? this.erpUsuarioMarcasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ErpUsuarioMarcas{" + "erpUsuarioMarcasPK=" + erpUsuarioMarcasPK + '}';
    }
    
    
    
}
