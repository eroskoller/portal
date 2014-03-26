/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author eros
 */
@Embeddable
public class LabUsuarioConvenioPK implements Serializable{
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="CON_ST_CODIGO",referencedColumnName="CON_ST_CODIGO")
    private LabConvenio conStCodigo;
    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;

    public LabConvenio getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(LabConvenio conStCodigo) {
        this.conStCodigo = conStCodigo;
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
        final LabUsuarioConvenioPK other = (LabUsuarioConvenioPK) obj;
        if (this.conStCodigo != other.conStCodigo && (this.conStCodigo == null || !this.conStCodigo.equals(other.conStCodigo))) {
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
        hash = 71 * hash + (this.conStCodigo != null ? this.conStCodigo.hashCode() : 0);
        hash = 71 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        return hash;
    }
    
    
    
}
