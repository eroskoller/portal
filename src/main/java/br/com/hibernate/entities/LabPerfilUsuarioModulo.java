/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_PERFILUSUARIOMODULO")
@IdClass(LabPerfilUsuarioModuloPK.class)
public class LabPerfilUsuarioModulo implements Serializable{
    
    @Id
    @Column(name="PUS_ST_CODIGO")
    private String pusStCodigo;
    
    @Id
    @Column(name="PUS_IN_SEQUENCIA")
    private Long pusInSequencia;
    
    
    @Column(name="PUS_IN_SEQUENCIAPAI")
    private Long pusInSequenciaPai;
    
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="MOD_ST_CODIGO")
    private LabModulo modStCodigo;
    
    
    @Column(name="PUS_CH_HABILITADO")
    private Character pusChHabilitado;
    
    @Column(name="PUS_CH_OPCAO1")
    private Character pusChOpcao1;
    
    @Column(name="PUS_CH_OPCAO2")
    private Character pusChOpcao2;
    
    @Column(name="PUS_CH_OPCAO3")
    private Character pusChOpcao3;
    
    @Column(name="PUS_CH_OPCAO4")
    private Character pusChOpcao4;
    
    @Column(name="PUS_CH_OPCAO5")
    private Character pusChOpcao5;
    
    @Column(name="PUS_CH_OPCAO6")
    private Character pusChOpcao6;
    
    @Column(name="PUS_CH_OPCAO7")
    private Character pusChOpcao7;
    
    @Column(name="PUS_CH_OPCAO8")
    private Character pusChOpcao8;
    
    @Column(name="PUS_CH_OPCAO9")
    private Character pusChOpcao9;
    
    @Column(name="PUS_CH_OPCAO10")
    private Character pusChOpcao10;
    
    @Column(name="PUS_CH_OPCAO11")
    private Character pusChOpcao11;
    
    @Column(name="PUS_CH_OPCAO12")
    private Character pusChOpcao12;
    
    @Column(name="PUS_CH_OPCAO13")
    private Character pusChOpcao13;
    
    @Column(name="PUS_CH_OPCAO14")
    private Character pusChOpcao14;
    
    @Column(name="PUS_CH_OPCAO15")
    private Character pusChOpcao15;
    
    @Column(name="PUS_CH_OPCAO16")
    private Character pusChOpcao16;
    
    @Column(name="PUS_CH_OPCAO17")
    private Character pusChOpcao17;
    
    @Column(name="PUS_CH_OPCAO18")
    private Character pusChOpcao18;
    
    @Column(name="PUS_CH_OPCAO19")
    private Character pusChOpcao19;
    
    @Column(name="PUS_CH_OPCAO20")
    private Character pusChOpcao20;
    
    @Column(name="PUS_CH_OPCAO21")
    private Character pusChOpcao21;
    
    @Column(name="PUS_CH_OPCAO22")
    private Character pusChOpcao22;
    
    
    @Column(name="PUS_CH_OPCAO23")
    private Character pusChOpcao23;
    
    @Column(name="PUS_CH_OPCAO24")
    private Character pusChOpcao24;
    
    @Column(name="PUS_CH_OPCAO25")
    private Character pusChOpcao25;
    
    
    
    @Column(name="PUS_IN_VERSAO") 
    private Integer pusInVersao;
    public Integer getPusInVersao() {return pusInVersao;}
    public void setPusInVersao(Integer pusInVersao) {this.pusInVersao = pusInVersao;}
    

    public LabModulo getModStCodigo() {
        return modStCodigo;
    }

    public void setModStCodigo(LabModulo modStCodigo) {
        this.modStCodigo = modStCodigo;
    }

    public Character getPusChHabilitado() {
        return pusChHabilitado;
    }

    public void setPusChHabilitado(Character pusChHabilitado) {
        this.pusChHabilitado = pusChHabilitado;
    }

    public Character getPusChOpcao1() {
        return pusChOpcao1;
    }

    public void setPusChOpcao1(Character pusChOpcao1) {
        this.pusChOpcao1 = pusChOpcao1;
    }

    public Character getPusChOpcao10() {
        return pusChOpcao10;
    }

    public void setPusChOpcao10(Character pusChOpcao10) {
        this.pusChOpcao10 = pusChOpcao10;
    }

    public Character getPusChOpcao11() {
        return pusChOpcao11;
    }

    public void setPusChOpcao11(Character pusChOpcao11) {
        this.pusChOpcao11 = pusChOpcao11;
    }

    public Character getPusChOpcao12() {
        return pusChOpcao12;
    }

    public void setPusChOpcao12(Character pusChOpcao12) {
        this.pusChOpcao12 = pusChOpcao12;
    }

    public Character getPusChOpcao13() {
        return pusChOpcao13;
    }

    public void setPusChOpcao13(Character pusChOpcao13) {
        this.pusChOpcao13 = pusChOpcao13;
    }

    public Character getPusChOpcao14() {
        return pusChOpcao14;
    }

    public void setPusChOpcao14(Character pusChOpcao14) {
        this.pusChOpcao14 = pusChOpcao14;
    }

    public Character getPusChOpcao15() {
        return pusChOpcao15;
    }

    public void setPusChOpcao15(Character pusChOpcao15) {
        this.pusChOpcao15 = pusChOpcao15;
    }

    public Character getPusChOpcao16() {
        return pusChOpcao16;
    }

    public void setPusChOpcao16(Character pusChOpcao16) {
        this.pusChOpcao16 = pusChOpcao16;
    }

    public Character getPusChOpcao17() {
        return pusChOpcao17;
    }

    public void setPusChOpcao17(Character pusChOpcao17) {
        this.pusChOpcao17 = pusChOpcao17;
    }

    public Character getPusChOpcao18() {
        return pusChOpcao18;
    }

    public void setPusChOpcao18(Character pusChOpcao18) {
        this.pusChOpcao18 = pusChOpcao18;
    }

    public Character getPusChOpcao19() {
        return pusChOpcao19;
    }

    public void setPusChOpcao19(Character pusChOpcao19) {
        this.pusChOpcao19 = pusChOpcao19;
    }

    public Character getPusChOpcao2() {
        return pusChOpcao2;
    }

    public void setPusChOpcao2(Character pusChOpcao2) {
        this.pusChOpcao2 = pusChOpcao2;
    }

    public Character getPusChOpcao20() {
        return pusChOpcao20;
    }

    public void setPusChOpcao20(Character pusChOpcao20) {
        this.pusChOpcao20 = pusChOpcao20;
    }

    public Character getPusChOpcao21() {
        return pusChOpcao21;
    }

    public void setPusChOpcao21(Character pusChOpcao21) {
        this.pusChOpcao21 = pusChOpcao21;
    }

    public Character getPusChOpcao22() {
        return pusChOpcao22;
    }

    public void setPusChOpcao22(Character pusChOpcao22) {
        this.pusChOpcao22 = pusChOpcao22;
    }

    public Character getPusChOpcao23() {
        return pusChOpcao23;
    }

    public void setPusChOpcao23(Character pusChOpcao23) {
        this.pusChOpcao23 = pusChOpcao23;
    }

    public Character getPusChOpcao24() {
        return pusChOpcao24;
    }

    public void setPusChOpcao24(Character pusChOpcao24) {
        this.pusChOpcao24 = pusChOpcao24;
    }

    public Character getPusChOpcao25() {
        return pusChOpcao25;
    }

    public void setPusChOpcao25(Character pusChOpcao25) {
        this.pusChOpcao25 = pusChOpcao25;
    }

    public Character getPusChOpcao3() {
        return pusChOpcao3;
    }

    public void setPusChOpcao3(Character pusChOpcao3) {
        this.pusChOpcao3 = pusChOpcao3;
    }

    public Character getPusChOpcao4() {
        return pusChOpcao4;
    }

    public void setPusChOpcao4(Character pusChOpcao4) {
        this.pusChOpcao4 = pusChOpcao4;
    }

    public Character getPusChOpcao5() {
        return pusChOpcao5;
    }

    public void setPusChOpcao5(Character pusChOpcao5) {
        this.pusChOpcao5 = pusChOpcao5;
    }

    public Character getPusChOpcao6() {
        return pusChOpcao6;
    }

    public void setPusChOpcao6(Character pusChOpcao6) {
        this.pusChOpcao6 = pusChOpcao6;
    }

    public Character getPusChOpcao7() {
        return pusChOpcao7;
    }

    public void setPusChOpcao7(Character pusChOpcao7) {
        this.pusChOpcao7 = pusChOpcao7;
    }

    public Character getPusChOpcao8() {
        return pusChOpcao8;
    }

    public void setPusChOpcao8(Character pusChOpcao8) {
        this.pusChOpcao8 = pusChOpcao8;
    }

    public Character getPusChOpcao9() {
        return pusChOpcao9;
    }

    public void setPusChOpcao9(Character pusChOpcao9) {
        this.pusChOpcao9 = pusChOpcao9;
    }

    public Long getPusInSequencia() {
        return pusInSequencia;
    }

    public void setPusInSequencia(Long pusInSequencia) {
        this.pusInSequencia = pusInSequencia;
    }


    public Long getPusInSequenciaPai() {
        return pusInSequenciaPai;
    }

    public void setPusInSequenciaPai(Long pusInSequenciaPai) {
        this.pusInSequenciaPai = pusInSequenciaPai;
    }

    public String getPusStCodigo() {
        return pusStCodigo;
    }

    public void setPusStCodigo(String pusStCodigo) {
        this.pusStCodigo = pusStCodigo;
    }


    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabPerfilUsuarioModulo other = (LabPerfilUsuarioModulo) obj;
        if ((this.pusStCodigo == null) ? (other.pusStCodigo != null) : !this.pusStCodigo.equals(other.pusStCodigo)) {
            return false;
        }
        if (this.pusInSequencia != other.pusInSequencia && (this.pusInSequencia == null || !this.pusInSequencia.equals(other.pusInSequencia))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.pusStCodigo != null ? this.pusStCodigo.hashCode() : 0);
        hash = 89 * hash + (this.pusInSequencia != null ? this.pusInSequencia.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "LabPerfilUsuarioModulo{" + "pusStCodigo=" + pusStCodigo + ", pusInSequencia=" + pusInSequencia + ", pusInSequenciaPai=" + pusInSequenciaPai + ", modStCodigo=" + modStCodigo + ", pusChHabilitado=" + pusChHabilitado + ", pusChOpcao1=" + pusChOpcao1 + ", pusChOpcao2=" + pusChOpcao2 + ", pusChOpcao3=" + pusChOpcao3 + ", pusChOpcao4=" + pusChOpcao4 + ", pusChOpcao5=" + pusChOpcao5 + ", pusChOpcao6=" + pusChOpcao6 + ", pusChOpcao7=" + pusChOpcao7 + ", pusChOpcao8=" + pusChOpcao8 + ", pusChOpcao9=" + pusChOpcao9 + ", pusChOpcao10=" + pusChOpcao10 + ", pusChOpcao11=" + pusChOpcao11 + ", pusChOpcao12=" + pusChOpcao12 + ", pusChOpcao13=" + pusChOpcao13 + ", pusChOpcao14=" + pusChOpcao14 + ", pusChOpcao15=" + pusChOpcao15 + ", pusChOpcao16=" + pusChOpcao16 + ", pusChOpcao17=" + pusChOpcao17 + ", pusChOpcao18=" + pusChOpcao18 + ", pusChOpcao19=" + pusChOpcao19 + ", pusChOpcao20=" + pusChOpcao20 + ", pusChOpcao21=" + pusChOpcao21 + ", pusChOpcao22=" + pusChOpcao22 + ", pusChOpcao23=" + pusChOpcao23 + ", pusChOpcao24=" + pusChOpcao24 + ", pusChOpcao25=" + pusChOpcao25 + '}';
    }

   
            

}
