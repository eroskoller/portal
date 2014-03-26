/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_AUDITORIA")
public class LabAuditoria implements Serializable{
    
    
    @Id
    @NotNull
    @Column(name="AUD_IN_CODIGO")
    private Long audInCodigo;
    
    @Column(name="AUD_DT_DATA")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date audDtData;
    
    @Column(name="MOD_ST_CODIGO")
    private String modStCodigo;
    
    @Column(name="ERR_IN_CODIGO")
    private Long errInCodigo;
    
    @Column(name="UNI_ST_CODIGO")
    private String uniStCodigo;
    
    @Column(name="SIS_ST_CODIGO")
    private String sisStCodigo;
    
    @Column(name="AUD_ST_DESCRICAO")
    private String audStDescricao;
    
    @Column(name="AUD_ST_SQL")
    private String audStSql;
    
    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;
    
    @Column(name="REQ_ST_CODIGO")
    private String reqStCodigo;
    
    @Column(name="REQ_ST_CODIGOALT")
    private String reqStCodigoAlt;
    
    @Column(name="AUD_CH_VERIFICADO")
    private Character audChVerificado;
    
    
    @Column(name="AUD_ST_USUARIO")
    private String audStUsuario;
    
    
    @Column(name="AUD_DT_DATAVERIFICADO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date audDtDataVerificado;
    
    @Column(name="DER_IN_CODIGO")
    private Long derInCodigo;

    public LabAuditoria() {
    }

    public LabAuditoria(Long audInCodigo, Date audDtData, String modStCodigo, Long errInCodigo, String uniStCodigo, String sisStCodigo, String audStDescricao, String audStSql, String usuStCodigo, String reqStCodigo, String reqStCodigoAlt, Character audChVerificado, String audStUsuario, Date audDtDataVerificado, Long derInCodigo) {
        this.audInCodigo = audInCodigo;
        this.audDtData = audDtData;
        this.modStCodigo = modStCodigo;
        this.errInCodigo = errInCodigo;
        this.uniStCodigo = uniStCodigo;
        this.sisStCodigo = sisStCodigo;
        this.audStDescricao = audStDescricao;
        this.audStSql = audStSql;
        this.usuStCodigo = usuStCodigo;
        this.reqStCodigo = reqStCodigo;
        this.reqStCodigoAlt = reqStCodigoAlt;
        this.audChVerificado = audChVerificado;
        this.audStUsuario = audStUsuario;
        this.audDtDataVerificado = audDtDataVerificado;
        this.derInCodigo = derInCodigo;
    }

    public Long getAudInCodigo() {
        return audInCodigo;
    }

    public void setAudInCodigo(Long audInCodigo) {
        this.audInCodigo = audInCodigo;
    }

    public Date getAudDtData() {
        return audDtData;
    }

    public void setAudDtData(Date audDtData) {
        this.audDtData = audDtData;
    }

    public String getModStCodigo() {
        return modStCodigo;
    }

    public void setModStCodigo(String modStCodigo) {
        this.modStCodigo = modStCodigo;
    }

    public Long getErrInCodigo() {
        return errInCodigo;
    }

    public void setErrInCodigo(Long errInCodigo) {
        this.errInCodigo = errInCodigo;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getSisStCodigo() {
        return sisStCodigo;
    }

    public void setSisStCodigo(String sisStCodigo) {
        this.sisStCodigo = sisStCodigo;
    }

    public String getAudStDescricao() {
        return audStDescricao;
    }

    public void setAudStDescricao(String audStDescricao) {
        this.audStDescricao = audStDescricao;
    }

    public String getAudStSql() {
        return audStSql;
    }

    public void setAudStSql(String audStSql) {
        this.audStSql = audStSql;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getReqStCodigo() {
        return reqStCodigo;
    }

    public void setReqStCodigo(String reqStCodigo) {
        this.reqStCodigo = reqStCodigo;
    }

    public String getReqStCodigoAlt() {
        return reqStCodigoAlt;
    }

    public void setReqStCodigoAlt(String reqStCodigoAlt) {
        this.reqStCodigoAlt = reqStCodigoAlt;
    }

    public Character getAudChVerificado() {
        return audChVerificado;
    }

    public void setAudChVerificado(Character audChVerificado) {
        this.audChVerificado = audChVerificado;
    }

    public String getAudStUsuario() {
        return audStUsuario;
    }

    public void setAudStUsuario(String audStUsuario) {
        this.audStUsuario = audStUsuario;
    }

    public Date getAudDtDataVerificado() {
        return audDtDataVerificado;
    }

    public void setAudDtDataVerificado(Date audDtDataVerificado) {
        this.audDtDataVerificado = audDtDataVerificado;
    }

    public Long getDerInCodigo() {
        return derInCodigo;
    }

    public void setDerInCodigo(Long derInCodigo) {
        this.derInCodigo = derInCodigo;
    }
    
    @Transient
    public String getCheckIcon(){
        if(this.audChVerificado != null && this.audChVerificado.toString().equalsIgnoreCase("1")){
            return "design/check_15x15.png";
        }else{
            return "design/bug_15x15.png";
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.audInCodigo);
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
        final LabAuditoria other = (LabAuditoria) obj;
        if (!Objects.equals(this.audInCodigo, other.audInCodigo)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
