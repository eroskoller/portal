/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_FORNECEDORESCODIGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpFornecedorescodigos.findAll", query = "SELECT e FROM ErpFornecedorescodigos e"),
    @NamedQuery(name = "ErpFornecedorescodigos.findByFdoStCodigo", query = "SELECT e FROM ErpFornecedorescodigos e WHERE e.erpFornecedorescodigosPK.fdoStCodigo = :fdoStCodigo"),
    @NamedQuery(name = "ErpFornecedorescodigos.findByItmStCodigo", query = "SELECT e FROM ErpFornecedorescodigos e WHERE e.erpFornecedorescodigosPK.itmStCodigo = :itmStCodigo"),
    @NamedQuery(name = "ErpFornecedorescodigos.findByFcoStCodigo", query = "SELECT e FROM ErpFornecedorescodigos e WHERE e.fcoStCodigo = :fcoStCodigo")})
public class ErpFornecedorescodigos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpFornecedorescodigosPK erpFornecedorescodigosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FCO_ST_CODIGO")
    private String fcoStCodigo;

    public ErpFornecedorescodigos() {
    }

    public ErpFornecedorescodigos(ErpFornecedorescodigosPK erpFornecedorescodigosPK) {
        this.erpFornecedorescodigosPK = erpFornecedorescodigosPK;
    }

    public ErpFornecedorescodigos(ErpFornecedorescodigosPK erpFornecedorescodigosPK, String fcoStCodigo) {
        this.erpFornecedorescodigosPK = erpFornecedorescodigosPK;
        this.fcoStCodigo = fcoStCodigo;
    }

    public ErpFornecedorescodigos(String fdoStCodigo, String itmStCodigo) {
        this.erpFornecedorescodigosPK = new ErpFornecedorescodigosPK(fdoStCodigo, itmStCodigo);
    }

    public ErpFornecedorescodigosPK getErpFornecedorescodigosPK() {
        return erpFornecedorescodigosPK;
    }

    public void setErpFornecedorescodigosPK(ErpFornecedorescodigosPK erpFornecedorescodigosPK) {
        this.erpFornecedorescodigosPK = erpFornecedorescodigosPK;
    }

    public String getFcoStCodigo() {
        return fcoStCodigo;
    }

    public void setFcoStCodigo(String fcoStCodigo) {
        this.fcoStCodigo = fcoStCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpFornecedorescodigosPK != null ? erpFornecedorescodigosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpFornecedorescodigos)) {
            return false;
        }
        ErpFornecedorescodigos other = (ErpFornecedorescodigos) object;
        if ((this.erpFornecedorescodigosPK == null && other.erpFornecedorescodigosPK != null) || (this.erpFornecedorescodigosPK != null && !this.erpFornecedorescodigosPK.equals(other.erpFornecedorescodigosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpFornecedorescodigos[ erpFornecedorescodigosPK=" + erpFornecedorescodigosPK + " ]";
    }
    
}
