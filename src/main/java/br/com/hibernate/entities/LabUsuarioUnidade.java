/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "LAB_USUARIOUNIDADE")
@IdClass(LabUsuarioUnidadePK.class)
public class LabUsuarioUnidade implements Serializable {

    @Id
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Id
    @Column(name = "USU_ST_CODIGO")
    private String usuStCodigo;

    public LabUsuarioUnidade() {
    }

    public LabUsuarioUnidade(String uniStCodigo, String usuStCodigo) {
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
        final LabUsuarioUnidade other = (LabUsuarioUnidade) obj;
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
        int hash = 3;
        hash = 47 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 47 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        return hash;
    }
}
