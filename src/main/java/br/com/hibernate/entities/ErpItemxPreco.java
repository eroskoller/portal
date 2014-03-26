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
@Table(name = "ERP_ITEMXPRECO")
public class ErpItemxPreco implements Serializable{
    
    @EmbeddedId
    protected ErpItemxPrecoPK erpItemxPrecoPK;
    
    @Column(name = "IPR_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date iprDtData;
    
    @Column(name = "IPR_CH_ATIVO")
    private Character iprChAtivo;
    
    @Size(max = 20)
    @Column(name = "IPR_ST_PRECO")
    private String iprStPreco;
    
    @Column(name = "IPR_FL_PRECO")
    private Float  iprFlPreco;
    
    
    @Column(name = "IPR_DT_VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date iprDtValidade;

    public ErpItemxPreco() {
    }

    public ErpItemxPrecoPK getErpItemxPrecoPK() {
        return erpItemxPrecoPK;
    }

    public void setErpItemxPrecoPK(ErpItemxPrecoPK erpItemxPrecoPK) {
        this.erpItemxPrecoPK = erpItemxPrecoPK;
    }

    public Character getIprChAtivo() {
        return iprChAtivo;
    }

    public void setIprChAtivo(Character iprChAtivo) {
        this.iprChAtivo = iprChAtivo;
    }

    public Date getIprDtData() {
        return iprDtData;
    }

    public void setIprDtData(Date iprDtData) {
        this.iprDtData = iprDtData;
    }

    public Date getIprDtValidade() {
        return iprDtValidade;
    }

    public void setIprDtValidade(Date iprDtValidade) {
        this.iprDtValidade = iprDtValidade;
    }

    public Float getIprFlPreco() {
        return iprFlPreco;
    }

    public void setIprFlPreco(Float iprFlPreco) {
        this.iprFlPreco = iprFlPreco;
    }

    public String getIprStPreco() {
        return iprStPreco;
    }

    public void setIprStPreco(String iprStPreco) {
        this.iprStPreco = iprStPreco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErpItemxPreco other = (ErpItemxPreco) obj;
        if (this.erpItemxPrecoPK != other.erpItemxPrecoPK && (this.erpItemxPrecoPK == null || !this.erpItemxPrecoPK.equals(other.erpItemxPrecoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.erpItemxPrecoPK != null ? this.erpItemxPrecoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ErpItemxPreco{" + "erpItemxPrecoPK=" + erpItemxPrecoPK + ", iprDtData=" + iprDtData + ", iprChAtivo=" + iprChAtivo + ", iprStPreco=" + iprStPreco + ", iprFlPreco=" + iprFlPreco + ", iprDtValidade=" + iprDtValidade + '}';
    }
    
    
    
    
    
    
    
}
