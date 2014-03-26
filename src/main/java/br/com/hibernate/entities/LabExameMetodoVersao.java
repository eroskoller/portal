/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_EXAMEMETODOVERSAO")
@IdClass(LabExameMetodoVersaoPK.class)
public class LabExameMetodoVersao implements Serializable {

    @Id
    @Column(name="EXA_ST_CODIGO")
    private String exaStCodigo;
    @Id
    @Column(name="MET_ST_CODIGO")
    private String metStCodigo;
    @Id
    @Column(name="EMV_DT_VALIDADE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date emvDtValidade;


//    @Column(name="EMV_BL_LAUDO")
//    private String emvBlLaudo;
//    @Column(name="EMV_FL_TAMANHOLAUDO")
//    private Float emvFlTamanhoLaudo;
//    @Column(name="EMV_CH_IMPRIMESOZINHO")
//    private Character emvChImprimesozinho;
    @Column(name="EMV_CH_ATIVO")
    private Character emvChAtivo;
//    @Column(name="EMV_IN_FOLHASEQ")
//    private Integer emvInFolhaSeq;
//    @Column(name="EMV_IN_FOLHA")
//    private Integer emvInFolha;
//    @Column(name="TEMP")
//    private Integer temp;
//    @Column(name="TEMPSEQ")
//    private Integer tempSeq;
//    @Column(name="EMV_BL_CHECKFORMULA")
//    private String emvBlCheckFormula;
//    @Column(name="EMV_BL_LAUDO1")
//    private String emvBlLaudo1;
    @Lob
    @Column(name="EMV_CL_LAUDO")
    private String emvClLaudo;
//    @Column(name="EMV_CL_CHECKFORMULA")
//    private String emvClCheckFormula;

    public LabExameMetodoVersao() {
    }

    public LabExameMetodoVersao(String exaStCodigo, String metStCodigo, Date emvDtValidade) {
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

    public Character getEmvChAtivo() {
        return emvChAtivo;
    }

    public void setEmvChAtivo(Character emvChAtivo) {
        this.emvChAtivo = emvChAtivo;
    }

    public String getEmvClLaudo() {
        return emvClLaudo;
    }

    public void setEmvClLaudo(String emvClLaudo) {
        this.emvClLaudo = emvClLaudo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabExameMetodoVersao other = (LabExameMetodoVersao) obj;
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
        int hash = 7;
        hash = 43 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        hash = 43 * hash + (this.metStCodigo != null ? this.metStCodigo.hashCode() : 0);
        hash = 43 * hash + (this.emvDtValidade != null ? this.emvDtValidade.hashCode() : 0);
        return hash;
    }

    

}
