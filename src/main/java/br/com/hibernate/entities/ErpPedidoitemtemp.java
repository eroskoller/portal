/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_PEDIDOITEMTEMP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpPedidoitemtemp.findAll", query = "SELECT e FROM ErpPedidoitemtemp e"),
    @NamedQuery(name = "ErpPedidoitemtemp.findByPedInCodigoTemp", query = "SELECT e FROM ErpPedidoitemtemp e WHERE e.erpPedidoitemtempPK.pedInCodigoTemp = :pedInCodigoTemp"),
    @NamedQuery(name = "ErpPedidoitemtemp.findByItmStCodigoTemp", query = "SELECT e FROM ErpPedidoitemtemp e WHERE e.erpPedidoitemtempPK.itmStCodigoTemp = :itmStCodigoTemp"),
    @NamedQuery(name = "ErpPedidoitemtemp.findByPeiInQtdeTemp", query = "SELECT e FROM ErpPedidoitemtemp e WHERE e.peiInQtdeTemp = :peiInQtdeTemp"),
    @NamedQuery(name = "ErpPedidoitemtemp.findByPeiStLoteTemp", query = "SELECT e FROM ErpPedidoitemtemp e WHERE e.peiStLoteTemp = :peiStLoteTemp"),
    @NamedQuery(name = "ErpPedidoitemtemp.findByPeiInEstoqueunidadeTemp", query = "SELECT e FROM ErpPedidoitemtemp e WHERE e.peiInEstoqueunidadeTemp = :peiInEstoqueunidadeTemp")})
public class ErpPedidoitemtemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpPedidoitemtempPK erpPedidoitemtempPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PEI_IN_QTDE_TEMP")
    private BigInteger peiInQtdeTemp;
    @Size(max = 20)
    @Column(name = "PEI_ST_LOTE_TEMP")
    private String peiStLoteTemp;
    @Column(name = "PEI_IN_ESTOQUEUNIDADE_TEMP")
    private BigInteger peiInEstoqueunidadeTemp;

    public ErpPedidoitemtemp() {
    }

    public ErpPedidoitemtemp(ErpPedidoitemtempPK erpPedidoitemtempPK) {
        this.erpPedidoitemtempPK = erpPedidoitemtempPK;
    }

    public ErpPedidoitemtemp(ErpPedidoitemtempPK erpPedidoitemtempPK, BigInteger peiInQtdeTemp) {
        this.erpPedidoitemtempPK = erpPedidoitemtempPK;
        this.peiInQtdeTemp = peiInQtdeTemp;
    }

    public ErpPedidoitemtemp(BigInteger pedInCodigoTemp, String itmStCodigoTemp) {
        this.erpPedidoitemtempPK = new ErpPedidoitemtempPK(pedInCodigoTemp, itmStCodigoTemp);
    }

    public ErpPedidoitemtempPK getErpPedidoitemtempPK() {
        return erpPedidoitemtempPK;
    }

    public void setErpPedidoitemtempPK(ErpPedidoitemtempPK erpPedidoitemtempPK) {
        this.erpPedidoitemtempPK = erpPedidoitemtempPK;
    }

    public BigInteger getPeiInQtdeTemp() {
        return peiInQtdeTemp;
    }

    public void setPeiInQtdeTemp(BigInteger peiInQtdeTemp) {
        this.peiInQtdeTemp = peiInQtdeTemp;
    }

    public String getPeiStLoteTemp() {
        return peiStLoteTemp;
    }

    public void setPeiStLoteTemp(String peiStLoteTemp) {
        this.peiStLoteTemp = peiStLoteTemp;
    }

    public BigInteger getPeiInEstoqueunidadeTemp() {
        return peiInEstoqueunidadeTemp;
    }

    public void setPeiInEstoqueunidadeTemp(BigInteger peiInEstoqueunidadeTemp) {
        this.peiInEstoqueunidadeTemp = peiInEstoqueunidadeTemp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpPedidoitemtempPK != null ? erpPedidoitemtempPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpPedidoitemtemp)) {
            return false;
        }
        ErpPedidoitemtemp other = (ErpPedidoitemtemp) object;
        if ((this.erpPedidoitemtempPK == null && other.erpPedidoitemtempPK != null) || (this.erpPedidoitemtempPK != null && !this.erpPedidoitemtempPK.equals(other.erpPedidoitemtempPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpPedidoitemtemp[ erpPedidoitemtempPK=" + erpPedidoitemtempPK + " ]";
    }
    
}
