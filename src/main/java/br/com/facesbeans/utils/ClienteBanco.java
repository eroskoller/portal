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
public class ClienteBanco implements Serializable{
    
    private String codigo;
    private String label;
    
    private String descricao;
    
    private String dbname;
    private String dbuser;
    private String dbpass;

    public ClienteBanco(String codigo, String label) {
        this.codigo = codigo;
        this.label = label;
    }

    public ClienteBanco(String codigo, String label, String descricao, String dbname, String dbuser, String dbpass) {
        this.codigo = codigo;
        this.label = label;
        this.descricao = descricao;
        this.dbname = dbname;
        this.dbuser = dbuser;
        this.dbpass = dbpass;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDbuser() {
        return dbuser;
    }

    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }

    public String getDbpass() {
        return dbpass;
    }

    public void setDbpass(String dbpass) {
        this.dbpass = dbpass;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
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
        final ClienteBanco other = (ClienteBanco) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteBanco{" + "codigo=" + codigo + ", label=" + label + ", descricao=" + descricao + ", dbname=" + dbname + ", dbuser=" + dbuser + ", dbpass=" + dbpass + '}';
    }
    
    
    
}
