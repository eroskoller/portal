/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

/**
 *
 * @author eros
 */
@Embeddable
public class LabExameMetodoVersaoPK implements Serializable {


    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @Column(name="MET_ST_CODIGO")
    private String metStCodigo;
    @Column(name="EMV_DT_VALIDADE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date emvDtValidade;

    public LabExameMetodoVersaoPK() {
    }

    public LabExameMetodoVersaoPK(String exaStCodigo, String metStCodigo, Date emvDtValidade) {
        this.exaStCodigo = exaStCodigo;
        this.metStCodigo = metStCodigo;
        this.emvDtValidade = emvDtValidade;
    }

    

    public Date getEmvDtValidade() {
        return emvDtValidade;
    }

    public void setEmvDtValidade(Date emvDtValidade) {
        this.emvDtValidade = emvDtValidade;
    }



    public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public String getMetStCodigo() {
        return metStCodigo;
    }

    public void setMetStCodigo(String metStCodigo) {
        this.metStCodigo = metStCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabExameMetodoVersaoPK other = (LabExameMetodoVersaoPK) obj;
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        if ((this.metStCodigo == null) ? (other.metStCodigo != null) : !this.metStCodigo.equals(other.metStCodigo)) {
            return false;
        }
        if (this.emvDtValidade != other.emvDtValidade && (this.emvDtValidade == null || !this.emvDtValidade.equals(other.emvDtValidade))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 97 * hash + (this.metStCodigo != null ? this.metStCodigo.hashCode() : 0);
        hash = 97 * hash + (this.emvDtValidade != null ? this.emvDtValidade.hashCode() : 0);
        return hash;
    }


}
