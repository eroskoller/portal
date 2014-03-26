/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_PERIODOFECHAMENTO")
public class LabPeriodoFechamento implements Serializable{
    
    
    @Id
    @Column(name="PFE_ST_CODIGO")        
    private String pfeStCodigo;
    @Column(name="PFE_ST_DESCRICAO")
    private String pfeStDescricao;
    @Column(name="PFE_CH_ATIVO")
    private Character pfeChAtivo;
    @Column(name="PFE_ST_ANOMES")
    private String pfeStAnome;

    public Character getPfeChAtivo() {
        return pfeChAtivo;
    }

    public void setPfeChAtivo(Character pfeChAtivo) {
        this.pfeChAtivo = pfeChAtivo;
    }

    public String getPfeStAnome() {
        return pfeStAnome;
    }

    public void setPfeStAnome(String pfeStAnome) {
        this.pfeStAnome = pfeStAnome;
    }

    public String getPfeStCodigo() {
        return pfeStCodigo;
    }

    public void setPfeStCodigo(String pfeStCodigo) {
        this.pfeStCodigo = pfeStCodigo;
    }

    public String getPfeStDescricao() {
        return pfeStDescricao;
    }

    public void setPfeStDescricao(String pfeStDescricao) {
        this.pfeStDescricao = pfeStDescricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabPeriodoFechamento other = (LabPeriodoFechamento) obj;
        if ((this.pfeStCodigo == null) ? (other.pfeStCodigo != null) : !this.pfeStCodigo.equals(other.pfeStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.pfeStCodigo != null ? this.pfeStCodigo.hashCode() : 0);
        return hash;
    }
    
    
    
    
    
}
