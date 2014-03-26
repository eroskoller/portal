/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.utils;

import java.io.Serializable;

/**
 *
 * @author eros
 */
public class CentroDeCusto implements  Serializable{
    
    private String codigo;
    private String label;

    public CentroDeCusto() {
    }

    public CentroDeCusto(String codigo, String label) {
        this.codigo = codigo;
        this.label = label;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CentroDeCusto other = (CentroDeCusto) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
    
    
}
