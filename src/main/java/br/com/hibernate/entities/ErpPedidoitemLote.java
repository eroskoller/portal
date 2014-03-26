/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 *
 * @author eros
 */

@Entity
@Table(name = "ERP_PEDIDOITEMLOTE")
public class ErpPedidoitemLote implements Serializable{
    
    @EmbeddedId
    protected ErpPedidoitemLotePK erpPedidoitemLotePK;
    
    @Size(max = 20)
    @Column(name = "PIL_ST_LOTE")
    private String pilStLote;
    
    
    @Column(name = "PIL_DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date pilDtValidade;
    
    @Column(name="PIL_IN_QTDE")
    private Integer pilInQtde;
    
    @Column(name="PIL_IN_CODIGOEMS")
    private Integer pilInCodiGoems;

    public ErpPedidoitemLote() {
    }

    public ErpPedidoitemLotePK getErpPedidoitemLotePK() {
        return erpPedidoitemLotePK;
    }

    public void setErpPedidoitemLotePK(ErpPedidoitemLotePK erpPedidoitemLotePK) {
        this.erpPedidoitemLotePK = erpPedidoitemLotePK;
    }

    public Date getPilDtValidade() {
        return pilDtValidade;
    }

    public void setPilDtValidade(Date pilDtValidade) {
        this.pilDtValidade = pilDtValidade;
    }

    public Integer getPilInCodiGoems() {
        return pilInCodiGoems;
    }

    public void setPilInCodiGoems(Integer pilInCodiGoems) {
        this.pilInCodiGoems = pilInCodiGoems;
    }

    public Integer getPilInQtde() {
        return pilInQtde;
    }

    public void setPilInQtde(Integer pilInQtde) {
        this.pilInQtde = pilInQtde;
    }

    public String getPilStLote() {
        return pilStLote;
    }

    public void setPilStLote(String pilStLote) {
        this.pilStLote = pilStLote;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErpPedidoitemLote other = (ErpPedidoitemLote) obj;
        if (this.erpPedidoitemLotePK != other.erpPedidoitemLotePK && (this.erpPedidoitemLotePK == null || !this.erpPedidoitemLotePK.equals(other.erpPedidoitemLotePK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.erpPedidoitemLotePK != null ? this.erpPedidoitemLotePK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ErpPedidoitemLote{" + "erpPedidoitemLotePK=" + erpPedidoitemLotePK + ", pilStLote=" + pilStLote + ", pilDtValidade=" + pilDtValidade + ", pilInQtde=" + pilInQtde + ", pilInCodiGoems=" + pilInCodiGoems + '}';
    }
    
    
    
}
