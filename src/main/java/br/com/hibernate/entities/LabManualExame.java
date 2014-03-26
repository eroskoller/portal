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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_MANUALEXAME")
public class LabManualExame implements Serializable{
    
    @Id
    @NotNull
    @Column(name="MEX_IN_SEQUENCIA")
    private Long mexInSequencia;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="EXA_ST_CODIGO")
    private LabExame exaStCodigo;
    
    @Column(name="MEX_DT_DATA")
    @NotNull
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date  mexDtData;
    
    @Column(name="USU_ST_CODIGO")
    @Size(min=0,max=20)
    private String usuStCodigo;
    
    @Column(name="MEX_ST_CONSREFRIGERADO")
    @Size(min=0,max=100)
    private String mexSTConsRefrigerado;
    
    @Column(name="MEX_ST_CONSCONGELADO")
    @Size(min=0,max=100)
    private String mexSTConsCongelado;
    
    @Column(name="MEX_ST_CONSTEMPAMBIENTE")
    @Size(min=0,max=100)
    private String mexStConsTempAmbiente;
    
    @Column(name="MEX_CH_EXECUTANTELC")
    private Character mexChExecutanteLC;
    
    @Column(name="MEX_CH_EXECUTANTELH")
    private Character mexChExecutanteLH;
    
    @Column(name="MEX_CH_EXECUTANTEAPOIO")
    private Character mexChExecutanteApoio;
    
    @Column(name="SET_ST_CODIGO")
    @Size(min=0,max=3)
    private String setStCodigo;
    
    @Lob
    @Column(name="MEX_CL_INDICACAO")
    private String mexClIndicado;
    
    @Lob
    @Column(name="MEX_CL_INTERPRETACAO")
    private String mexClInterpretacao;
    
    @Lob
    @Column(name="MEX_CL_INTERFERENTE")
    private String mexClInteferente;
    
    @Lob
    @Column(name="MEX_CL_PREPARO")
    private String mexClPreparo;
    
    @Lob
    @Column(name="MEX_CL_COLETA")
    private String mexClColeta;
    
    @Lob
    @Column(name="MEX_CL_OBSRECIPIENTE")
    private String mexClObsRecipiente;
    
    @Lob
    @Column(name="MEX_CL_MATERIALCOLETA")
    private String mexClMaterialColeta;
    
    @Lob
    @Column(name="MEX_CL_MATERIALEXECUCAO")
    private String mexClMaterialExecucao;
    
    @Lob
    @Column(name="MEX_CL_TRANSPORTE")
    private String mexClTransporte;
    
    @Lob
    @Column(name="MEX_CL_EXAMECORRELATO")
    private String mexClExameCorrelato;
    
    @Column(name="MEX_IN_TRANSPORTE")
    @Size(min=0,max=100)
    private String mexInTransporte;
    
    @Column(name="MEX_ST_TRANSPORTE")
    @Size(min=0,max=100)
    private String mexStTransporte;
    
    @Column(name="MEX_ST_INDICACAO")
    @Size(min=0,max=100)
    private String mexStIndicacao;
    
    @Column(name="MEX_ST_INTERPRETACAO")
    @Size(min=0,max=100)
    private String mexStInterpretacao;
    
    @Column(name="MEX_ST_INTERFERENTE")
    @Size(min=0,max=100)
    private String mexStInterferente;
    
    @Column(name="MEX_ST_PREPARO")
    @Size(min=0,max=100)
    private String mexStPreparo;
    
    @Column(name="MEX_ST_COLETA")
    @Size(min=0,max=100)
    private String mexStColeta;
    
    @Column(name="MEX_ST_MATERIALCOLETA")
    @Size(min=0,max=100)
    private String mexStMaterialColeta;
    
    @Column(name="MEX_ST_MATERIALEXECUCAO")
    @Size(min=0,max=100)
    private String mexStMaterialExecucao;
    
    @Column(name="MEX_ST_OBSRECIPIENTE")
    @Size(min=0,max=100)
    private String mexStObsRecipiente;
    
    @Column(name="MEX_ST_EXAMECORRELATO")
    @Size(min=0,max=100)
    private String mexStExameCorrelato;
    
    @Column(name="MEX_ST_TRANSTEMPAMBIENTE")
    @Size(min=0,max=100)
    private String mexStTransTempAmbiente;
    
    @Column(name="MEX_ST_TRANSCONGELADO")
    @Size(min=0,max=100)
    private String mexStTransCongelado;
    
    @Column(name="MEX_ST_TRANSREFRIGERADO")
    @Size(min=0,max=100)
    private String mexStTransRefrigerado;
    
    @Lob
    @Column(name="MEX_CL_VOLUMECOLETA")
    private String mexClVolumeColeta;
    
    @Lob
    @Column(name="MEX_CL_VOLUMEEXECUCAO")
    private String mexClVolumeExecucao;
    
    @Column(name="TCO_ST_CODIGO")
    @Size(min=0,max=3)
    private String tcoStCodigo;
    
    @Column(name="MEX_IN_ATIVO")
    private Integer mexInAtivo;

    public LabManualExame() {
    }

    public Long getMexInSequencia() {
        return mexInSequencia;
    }

    public void setMexInSequencia(Long mexInSequencia) {
        this.mexInSequencia = mexInSequencia;
    }

    public LabExame getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(LabExame exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public Date getMexDtData() {
        return mexDtData;
    }

    public void setMexDtData(Date mexDtData) {
        this.mexDtData = mexDtData;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getMexSTConsRefrigerado() {
        return mexSTConsRefrigerado;
    }

    public void setMexSTConsRefrigerado(String mexSTConsRefrigerado) {
        this.mexSTConsRefrigerado = mexSTConsRefrigerado;
    }

    public String getMexSTConsCongelado() {
        return mexSTConsCongelado;
    }

    public void setMexSTConsCongelado(String mexSTConsCongelado) {
        this.mexSTConsCongelado = mexSTConsCongelado;
    }

    public String getMexStConsTempAmbiente() {
        return mexStConsTempAmbiente;
    }

    public void setMexStConsTempAmbiente(String mexStConsTempAmbiente) {
        this.mexStConsTempAmbiente = mexStConsTempAmbiente;
    }

    public Character getMexChExecutanteLC() {
        return mexChExecutanteLC;
    }

    public void setMexChExecutanteLC(Character mexChExecutanteLC) {
        this.mexChExecutanteLC = mexChExecutanteLC;
    }

    public Character getMexChExecutanteLH() {
        return mexChExecutanteLH;
    }

    public void setMexChExecutanteLH(Character mexChExecutanteLH) {
        this.mexChExecutanteLH = mexChExecutanteLH;
    }

    public Character getMexChExecutanteApoio() {
        return mexChExecutanteApoio;
    }

    public void setMexChExecutanteApoio(Character mexChExecutanteApoio) {
        this.mexChExecutanteApoio = mexChExecutanteApoio;
    }

    public String getSetStCodigo() {
        return setStCodigo;
    }

    public void setSetStCodigo(String setStCodigo) {
        this.setStCodigo = setStCodigo;
    }

    public String getMexClIndicado() {
        return mexClIndicado;
    }

    public void setMexClIndicado(String mexClIndicado) {
        this.mexClIndicado = mexClIndicado;
    }

    public String getMexClInterpretacao() {
        return mexClInterpretacao;
    }

    public void setMexClInterpretacao(String mexClInterpretacao) {
        this.mexClInterpretacao = mexClInterpretacao;
    }

    public String getMexClInteferente() {
        return mexClInteferente;
    }

    public void setMexClInteferente(String mexClInteferente) {
        this.mexClInteferente = mexClInteferente;
    }

    public String getMexClPreparo() {
        return mexClPreparo;
    }

    public void setMexClPreparo(String mexClPreparo) {
        this.mexClPreparo = mexClPreparo;
    }

    public String getMexClColeta() {
        return mexClColeta;
    }

    public void setMexClColeta(String mexClColeta) {
        this.mexClColeta = mexClColeta;
    }

    public String getMexClObsRecipiente() {
        return mexClObsRecipiente;
    }

    public void setMexClObsRecipiente(String mexClObsRecipiente) {
        this.mexClObsRecipiente = mexClObsRecipiente;
    }

    public String getMexClMaterialColeta() {
        return mexClMaterialColeta;
    }

    public void setMexClMaterialColeta(String mexClMaterialColeta) {
        this.mexClMaterialColeta = mexClMaterialColeta;
    }

    public String getMexClMaterialExecucao() {
        return mexClMaterialExecucao;
    }

    public void setMexClMaterialExecucao(String mexClMaterialExecucao) {
        this.mexClMaterialExecucao = mexClMaterialExecucao;
    }

    public String getMexClTransporte() {
        return mexClTransporte;
    }

    public void setMexClTransporte(String mexClTransporte) {
        this.mexClTransporte = mexClTransporte;
    }

    public String getMexClExameCorrelato() {
        return mexClExameCorrelato;
    }

    public void setMexClExameCorrelato(String mexClExameCorrelato) {
        this.mexClExameCorrelato = mexClExameCorrelato;
    }

    public String getMexInTransporte() {
        return mexInTransporte;
    }

    public void setMexInTransporte(String mexInTransporte) {
        this.mexInTransporte = mexInTransporte;
    }

    public String getMexStTransporte() {
        return mexStTransporte;
    }

    public void setMexStTransporte(String mexStTransporte) {
        this.mexStTransporte = mexStTransporte;
    }

    public String getMexStIndicacao() {
        return mexStIndicacao;
    }

    public void setMexStIndicacao(String mexStIndicacao) {
        this.mexStIndicacao = mexStIndicacao;
    }

    public String getMexStInterpretacao() {
        return mexStInterpretacao;
    }

    public void setMexStInterpretacao(String mexStInterpretacao) {
        this.mexStInterpretacao = mexStInterpretacao;
    }

    public String getMexStInterferente() {
        return mexStInterferente;
    }

    public void setMexStInterferente(String mexStInterferente) {
        this.mexStInterferente = mexStInterferente;
    }

    public String getMexStPreparo() {
        return mexStPreparo;
    }

    public void setMexStPreparo(String mexStPreparo) {
        this.mexStPreparo = mexStPreparo;
    }

    public String getMexStColeta() {
        return mexStColeta;
    }

    public void setMexStColeta(String mexStColeta) {
        this.mexStColeta = mexStColeta;
    }

    public String getMexStMaterialColeta() {
        return mexStMaterialColeta;
    }

    public void setMexStMaterialColeta(String mexStMaterialColeta) {
        this.mexStMaterialColeta = mexStMaterialColeta;
    }

    public String getMexStMaterialExecucao() {
        return mexStMaterialExecucao;
    }

    public void setMexStMaterialExecucao(String mexStMaterialExecucao) {
        this.mexStMaterialExecucao = mexStMaterialExecucao;
    }

    public String getMexStObsRecipiente() {
        return mexStObsRecipiente;
    }

    public void setMexStObsRecipiente(String mexStObsRecipiente) {
        this.mexStObsRecipiente = mexStObsRecipiente;
    }

    public String getMexStExameCorrelato() {
        return mexStExameCorrelato;
    }

    public void setMexStExameCorrelato(String mexStExameCorrelato) {
        this.mexStExameCorrelato = mexStExameCorrelato;
    }

    public String getMexStTransTempAmbiente() {
        return mexStTransTempAmbiente;
    }

    public void setMexStTransTempAmbiente(String mexStTransTempAmbiente) {
        this.mexStTransTempAmbiente = mexStTransTempAmbiente;
    }

    public String getMexStTransCongelado() {
        return mexStTransCongelado;
    }

    public void setMexStTransCongelado(String mexStTransCongelado) {
        this.mexStTransCongelado = mexStTransCongelado;
    }

    public String getMexStTransRefrigerado() {
        return mexStTransRefrigerado;
    }

    public void setMexStTransRefrigerado(String mexStTransRefrigerado) {
        this.mexStTransRefrigerado = mexStTransRefrigerado;
    }

    public String getMexClVolumeColeta() {
        return mexClVolumeColeta;
    }

    public void setMexClVolumeColeta(String mexClVolumeColeta) {
        this.mexClVolumeColeta = mexClVolumeColeta;
    }

    public String getMexClVolumeExecucao() {
        return mexClVolumeExecucao;
    }

    public void setMexClVolumeExecucao(String mexClVolumeExecucao) {
        this.mexClVolumeExecucao = mexClVolumeExecucao;
    }

    public String getTcoStCodigo() {
        return tcoStCodigo;
    }

    public void setTcoStCodigo(String tcoStCodigo) {
        this.tcoStCodigo = tcoStCodigo;
    }

    public Integer getMexInAtivo() {
        return mexInAtivo;
    }

    public void setMexInAtivo(Integer mexInAtivo) {
        this.mexInAtivo = mexInAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.mexInSequencia);
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
        final LabManualExame other = (LabManualExame) obj;
        if (!Objects.equals(this.mexInSequencia, other.mexInSequencia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LabManualExame{" + "mexInSequencia=" + mexInSequencia + ", exaStCodigo=" + exaStCodigo + ", mexDtData=" + mexDtData + ", usuStCodigo=" + usuStCodigo + ", mexSTConsRefrigerado=" + mexSTConsRefrigerado + ", mexSTConsCongelado=" + mexSTConsCongelado + ", mexStConsTempAmbiente=" + mexStConsTempAmbiente + ", mexChExecutanteLC=" + mexChExecutanteLC + ", mexChExecutanteLH=" + mexChExecutanteLH + ", mexChExecutanteApoio=" + mexChExecutanteApoio + ", setStCodigo=" + setStCodigo + ", mexClIndicado=" + mexClIndicado + ", mexClInterpretacao=" + mexClInterpretacao + ", mexClInteferente=" + mexClInteferente + ", mexClPreparo=" + mexClPreparo + ", mexClColeta=" + mexClColeta + ", mexClObsRecipiente=" + mexClObsRecipiente + ", mexClMaterialColeta=" + mexClMaterialColeta + ", mexClMaterialExecucao=" + mexClMaterialExecucao + ", mexClTransporte=" + mexClTransporte + ", mexClExameCorrelato=" + mexClExameCorrelato + ", mexInTransporte=" + mexInTransporte + ", mexStTransporte=" + mexStTransporte + ", mexStIndicacao=" + mexStIndicacao + ", mexStInterpretacao=" + mexStInterpretacao + ", mexStInterferente=" + mexStInterferente + ", mexStPreparo=" + mexStPreparo + ", mexStColeta=" + mexStColeta + ", mexStMaterialColeta=" + mexStMaterialColeta + ", mexStMaterialExecucao=" + mexStMaterialExecucao + ", mexStObsRecipiente=" + mexStObsRecipiente + ", mexStExameCorrelato=" + mexStExameCorrelato + ", mexStTransTempAmbiente=" + mexStTransTempAmbiente + ", mexStTransCongelado=" + mexStTransCongelado + ", mexStTransRefrigerado=" + mexStTransRefrigerado + ", mexClVolumeColeta=" + mexClVolumeColeta + ", mexClVolumeExecucao=" + mexClVolumeExecucao + ", tcoStCodigo=" + tcoStCodigo + ", mexInAtivo=" + mexInAtivo + '}';
    }
    
    
    
    
            
    
}
