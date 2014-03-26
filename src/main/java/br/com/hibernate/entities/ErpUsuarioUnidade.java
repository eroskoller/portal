/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import com.thoughtworks.xstream.XStream;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author eros
 */
@Entity
@Table(name="ERP_USUARIOUNIDADE")   
public class ErpUsuarioUnidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpUsuarioUnidadePK erpUsuarioUnidadePK;

    public ErpUsuarioUnidade() {
    }

    public ErpUsuarioUnidade(ErpUsuarioUnidadePK erpUsuarioUnidadePK) {
        this.erpUsuarioUnidadePK = erpUsuarioUnidadePK;
    }

    public ErpUsuarioUnidadePK getErpUsuarioUnidadePK() {
        return erpUsuarioUnidadePK;
    }

    public void setErpUsuarioUnidadePK(ErpUsuarioUnidadePK erpUsuarioUnidadePK) {
        this.erpUsuarioUnidadePK = erpUsuarioUnidadePK;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErpUsuarioUnidade other = (ErpUsuarioUnidade) obj;
        if (this.erpUsuarioUnidadePK != other.erpUsuarioUnidadePK && (this.erpUsuarioUnidadePK == null || !this.erpUsuarioUnidadePK.equals(other.erpUsuarioUnidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.erpUsuarioUnidadePK != null ? this.erpUsuarioUnidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        XStream xstream = new XStream();
        return  xstream.toXML(this);
    }
    
    
    
}
