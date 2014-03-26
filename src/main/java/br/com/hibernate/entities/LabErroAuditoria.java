/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_ERROAUDITORIA")
public class LabErroAuditoria implements Serializable{
    
    
    @Id
    @Column(name="ERR_IN_CODIGO")
    private Long errInCodigo;
    
    @Column(name="ERR_ST_DESCRICAO")
    private String errStDescricao;

    public LabErroAuditoria() {
    }

    public LabErroAuditoria(Long errInCodigo, String errStDescricao) {
        this.errInCodigo = errInCodigo;
        this.errStDescricao = errStDescricao;
    }

    public Long getErrInCodigo() {
        return errInCodigo;
    }

    public void setErrInCodigo(Long errInCodigo) {
        this.errInCodigo = errInCodigo;
    }

    public String getErrStDescricao() {
        return errStDescricao;
    }

    public void setErrStDescricao(String errStDescricao) {
        this.errStDescricao = errStDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.errInCodigo);
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
        final LabErroAuditoria other = (LabErroAuditoria) obj;
        if (!Objects.equals(this.errInCodigo, other.errInCodigo)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
