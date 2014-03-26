/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "LAB_USUARIOCONVENIO")
@IdClass(LabUsuarioConvenioPK.class)
public class LabUsuarioConvenio implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "CON_ST_CODIGO", referencedColumnName = "CON_ST_CODIGO")
    private LabConvenio conStCodigo;
    @Id
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;
    
    
    @Column(name = "UCO_DT_LASTUPDADE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ucoDtLastUpdate;

    public Date getUcoDtLastUpdate() {
        return ucoDtLastUpdate;
    }

    public void setUcoDtLastUpdate(Date ucoDtLastUpdate) {
        this.ucoDtLastUpdate = ucoDtLastUpdate;
    }

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
        final LabUsuarioConvenio other = (LabUsuarioConvenio) obj;
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
        int hash = 3;
        hash = 97 * hash + (this.conStCodigo != null ? this.conStCodigo.hashCode() : 0);
        hash = 97 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        return hash;
    }
    
    
    
    
    
}
