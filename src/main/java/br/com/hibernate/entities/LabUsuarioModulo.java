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
 * @author ricardo
 */
@Entity
@Table(name="LAB_USUARIOMODULO")
@IdClass(LabUsuarioModuloPK.class)
public class LabUsuarioModulo implements Serializable{
    
    @Id
    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;
    
    
    @Id
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="MOD_ST_CODIGO")
    private LabModulo modStCodigo;
    
    @Column(name="UMO_CH_OPCAO1")
    private Character umoChOpcao1;
    @Column(name="UMO_CH_OPCAO2")
    private Character umoChOpcao2;
    @Column(name="UMO_CH_OPCAO3")
    private Character umoChOpcao3;
    @Column(name="UMO_CH_OPCAO4")
    private Character umoChOpcao4;
    @Column(name="UMO_CH_OPCAO5")
    private Character umoChOpcao5;
    @Column(name="UMO_CH_OPCAO6")
    private Character umoChOpcao6;
    @Column(name="UMO_CH_OPCAO7")
    private Character umoChOpcao7;
    @Column(name="UMO_CH_OPCAO8")
    private Character umoChOpcao8;
    @Column(name="UMO_CH_OPCAO9")
    private Character umoChOpcao9;
    @Column(name="UMO_CH_OPCAO10")
    private Character umoChOpcao10;
    @Column(name="UMO_CH_OPCAO11")
    private Character umoChOpcao11;
    @Column(name="UMO_CH_OPCAO12")
    private Character umoChOpcao12;
    @Column(name="UMO_CH_OPCAO13")
    private Character umoChOpcao13;
    @Column(name="UMO_CH_OPCAO14")
    private Character umoChOpcao14;
    @Column(name="UMO_CH_OPCAO15")
    private Character umoChOpcao15;
    @Column(name="UMO_CH_OPCAO16")
    private Character umoChOpcao16;
    @Column(name="UMO_CH_OPCAO17")
    private Character umoChOpcao17;
    @Column(name="UMO_CH_OPCAO18")
    private Character umoChOpcao18;
    @Column(name="UMO_CH_OPCAO19")
    private Character umoChOpcao19;
    @Column(name="UMO_CH_OPCAO20")
    private Character umoChOpcao20;
    @Column(name="UMO_CH_OPCAO21")
    private Character umoChOpcao21;
    @Column(name="UMO_CH_OPCAO22")
    private Character umoChOpcao22;
    @Column(name="UMO_CH_OPCAO23")
    private Character umoChOpcao23;
    @Column(name="UMO_CH_OPCAO24")
    private Character umoChOpcao24;
    @Column(name="UMO_CH_OPCAO25")
    private Character umoChOpcao25;

    public LabModulo getModStCodigo() {
        return modStCodigo;
    }

    public void setModStCodigo(LabModulo modStCodigo) {
        this.modStCodigo = modStCodigo;
    }

    public Character getUmoChOpcao1() {
        return umoChOpcao1;
    }

    public void setUmoChOpcao1(Character umoChOpcao1) {
        this.umoChOpcao1 = umoChOpcao1;
    }

    public Character getUmoChOpcao10() {
        return umoChOpcao10;
    }

    public void setUmoChOpcao10(Character umoChOpcao10) {
        this.umoChOpcao10 = umoChOpcao10;
    }

    public Character getUmoChOpcao11() {
        return umoChOpcao11;
    }

    public void setUmoChOpcao11(Character umoChOpcao11) {
        this.umoChOpcao11 = umoChOpcao11;
    }

    public Character getUmoChOpcao12() {
        return umoChOpcao12;
    }

    public void setUmoChOpcao12(Character umoChOpcao12) {
        this.umoChOpcao12 = umoChOpcao12;
    }

    public Character getUmoChOpcao13() {
        return umoChOpcao13;
    }

    public void setUmoChOpcao13(Character umoChOpcao13) {
        this.umoChOpcao13 = umoChOpcao13;
    }

    public Character getUmoChOpcao14() {
        return umoChOpcao14;
    }

    public void setUmoChOpcao14(Character umoChOpcao14) {
        this.umoChOpcao14 = umoChOpcao14;
    }

    public Character getUmoChOpcao15() {
        return umoChOpcao15;
    }

    public void setUmoChOpcao15(Character umoChOpcao15) {
        this.umoChOpcao15 = umoChOpcao15;
    }

    public Character getUmoChOpcao16() {
        return umoChOpcao16;
    }

    public void setUmoChOpcao16(Character umoChOpcao16) {
        this.umoChOpcao16 = umoChOpcao16;
    }

    public Character getUmoChOpcao17() {
        return umoChOpcao17;
    }

    public void setUmoChOpcao17(Character umoChOpcao17) {
        this.umoChOpcao17 = umoChOpcao17;
    }

    public Character getUmoChOpcao18() {
        return umoChOpcao18;
    }

    public void setUmoChOpcao18(Character umoChOpcao18) {
        this.umoChOpcao18 = umoChOpcao18;
    }

    public Character getUmoChOpcao19() {
        return umoChOpcao19;
    }

    public void setUmoChOpcao19(Character umoChOpcao19) {
        this.umoChOpcao19 = umoChOpcao19;
    }

    public Character getUmoChOpcao2() {
        return umoChOpcao2;
    }

    public void setUmoChOpcao2(Character umoChOpcao2) {
        this.umoChOpcao2 = umoChOpcao2;
    }

    public Character getUmoChOpcao20() {
        return umoChOpcao20;
    }

    public void setUmoChOpcao20(Character umoChOpcao20) {
        this.umoChOpcao20 = umoChOpcao20;
    }

    public Character getUmoChOpcao21() {
        return umoChOpcao21;
    }

    public void setUmoChOpcao21(Character umoChOpcao21) {
        this.umoChOpcao21 = umoChOpcao21;
    }

    public Character getUmoChOpcao22() {
        return umoChOpcao22;
    }

    public void setUmoChOpcao22(Character umoChOpcao22) {
        this.umoChOpcao22 = umoChOpcao22;
    }

    public Character getUmoChOpcao23() {
        return umoChOpcao23;
    }

    public void setUmoChOpcao23(Character umoChOpcao23) {
        this.umoChOpcao23 = umoChOpcao23;
    }

    public Character getUmoChOpcao24() {
        return umoChOpcao24;
    }

    public void setUmoChOpcao24(Character umoChOpcao24) {
        this.umoChOpcao24 = umoChOpcao24;
    }

    public Character getUmoChOpcao25() {
        return umoChOpcao25;
    }

    public void setUmoChOpcao25(Character umoChOpcao25) {
        this.umoChOpcao25 = umoChOpcao25;
    }

    public Character getUmoChOpcao3() {
        return umoChOpcao3;
    }

    public void setUmoChOpcao3(Character umoChOpcao3) {
        this.umoChOpcao3 = umoChOpcao3;
    }

    public Character getUmoChOpcao4() {
        return umoChOpcao4;
    }

    public void setUmoChOpcao4(Character umoChOpcao4) {
        this.umoChOpcao4 = umoChOpcao4;
    }

    public Character getUmoChOpcao5() {
        return umoChOpcao5;
    }

    public void setUmoChOpcao5(Character umoChOpcao5) {
        this.umoChOpcao5 = umoChOpcao5;
    }

    public Character getUmoChOpcao6() {
        return umoChOpcao6;
    }

    public void setUmoChOpcao6(Character umoChOpcao6) {
        this.umoChOpcao6 = umoChOpcao6;
    }

    public Character getUmoChOpcao7() {
        return umoChOpcao7;
    }

    public void setUmoChOpcao7(Character umoChOpcao7) {
        this.umoChOpcao7 = umoChOpcao7;
    }

    public Character getUmoChOpcao8() {
        return umoChOpcao8;
    }

    public void setUmoChOpcao8(Character umoChOpcao8) {
        this.umoChOpcao8 = umoChOpcao8;
    }

    public Character getUmoChOpcao9() {
        return umoChOpcao9;
    }

    public void setUmoChOpcao9(Character umoChOpcao9) {
        this.umoChOpcao9 = umoChOpcao9;
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
        final LabUsuarioModulo other = (LabUsuarioModulo) obj;
        if ((this.usuStCodigo == null) ? (other.usuStCodigo != null) : !this.usuStCodigo.equals(other.usuStCodigo)) {
            return false;
        }
        if (this.modStCodigo != other.modStCodigo && (this.modStCodigo == null || !this.modStCodigo.equals(other.modStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.usuStCodigo != null ? this.usuStCodigo.hashCode() : 0);
        hash = 43 * hash + (this.modStCodigo != null ? this.modStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "LabUsuarioModulo{" + "usuStCodigo=" + usuStCodigo + ", modStCodigo=" + modStCodigo + ", umoChOpcao1=" + umoChOpcao1 + ", umoChOpcao2=" + umoChOpcao2 + ", umoChOpcao3=" + umoChOpcao3 + ", umoChOpcao4=" + umoChOpcao4 + ", umoChOpcao5=" + umoChOpcao5 + ", umoChOpcao6=" + umoChOpcao6 + ", umoChOpcao7=" + umoChOpcao7 + ", umoChOpcao8=" + umoChOpcao8 + ", umoChOpcao9=" + umoChOpcao9 + ", umoChOpcao10=" + umoChOpcao10 + ", umoChOpcao11=" + umoChOpcao11 + ", umoChOpcao12=" + umoChOpcao12 + ", umoChOpcao13=" + umoChOpcao13 + ", umoChOpcao14=" + umoChOpcao14 + ", umoChOpcao15=" + umoChOpcao15 + ", umoChOpcao16=" + umoChOpcao16 + ", umoChOpcao17=" + umoChOpcao17 + ", umoChOpcao18=" + umoChOpcao18 + ", umoChOpcao19=" + umoChOpcao19 + ", umoChOpcao20=" + umoChOpcao20 + ", umoChOpcao21=" + umoChOpcao21 + ", umoChOpcao22=" + umoChOpcao22 + ", umoChOpcao23=" + umoChOpcao23 + ", umoChOpcao24=" + umoChOpcao24 + ", umoChOpcao25=" + umoChOpcao25 + '}';
    }
    
    
    
    
}
