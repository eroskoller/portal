/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;


import java.io.Serializable;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_AGENDAPACIENTE")
public class LabAgendaPaciente implements Serializable{



    @Id
    @Column(name="AGP_IN_CODIGO")
    private Long agpInCodigo;
    
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="UNI_ST_CODIGO",nullable=false, updatable=false, insertable=false),
//        @JoinColumn(name="ALO_IN_CODIGO",nullable=false, updatable=false, insertable=false),
//        @JoinColumn(name="AGE_IN_CODIGO",nullable=false, updatable=false, insertable=false)
//
//    })
//    private LabAgenda ageInCodigo; 
//    @Column(name="AGP_IN_CODIGO")
//        private Long ageInCodigo; 
    
    @Column(name="AGE_IN_CODIGO")
    private Long ageInCodigo;
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="AGP_DT_DATA")
    private Date agpDtData;
    @Column(name="AGP_ST_NOME")
    private String agpStNome;
    @Column(name="AGP_CH_SEXO")
    private Character agpChSexo;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="AGP_DT_NASCIMENTO")
    private Date agpDtNascimeto;
    @Column(name="AGP_IN_STATUS")
    private Integer agpInStatus;
//    @ManyToOne
//    @JoinColumn(name="UNI_ST_CODIGO")//mappeded
//    private LabUnidade uniStCodigo;
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="PAC_IN_CODIGO")//mappeded
//    private LabPaciente pacInCodigo;
    
    @Column(name="PAC_IN_CODIGO")
    private Long pacInCodigo;
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="ORI_ST_CODIGO"),
//        @JoinColumn(name="UNI_ST_CODIGO")
//
//    })
//    private LabOrigem oriStCodigo;
    
//    @OneToOne
//    @JoinColumn(name="CON_ST_CODIGO")//mappeded
//    private LabConvenio conStCodigo;
    @Column(name="CON_ST_CODIGO")
    private String conStCodigo;
    
//    @OneToOne
//    @JoinColumn(name="REQ_ST_CODIGO")//mappeded
//    private LabRequisicao reqStCodigo;
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="UNI_ST_CODIGO"),
//        @JoinColumn(name="LOC_ST_CODIGO")
//
//    })
//    private LabLocal locStCodigo;
    @Column(name="REQ_ST_DUM")
    private String reqStDum;
    @Column(name="REQ_CH_GESTANTE")
    private char reqChGestante;
    @Column(name="REQ_CH_RN")
    private char reqChRN;
//    @ManyToOne
//    @JoinColumn(name="PRO_ST_CODIGO")//mappeded
//    private LabProfissao proStCodigo;
//    @Column(name="SOL_ST_ESTADO")
//    private String solStEstado;
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name="SOL_ST_ESTADO"),
//        @JoinColumn(name="PRO_ST_CODIGO"),
//        @JoinColumn(name="SOL_ST_CODIGO")
//
//    })
//    private LabSolicitante solStCodigo;
    @Column(name="SOL_ST_CODIGO")
    private String solStCodigo;
    
//    @ManyToOne
//    @JoinColumn(name="CID_ST_CODIGO")//mappeded
//    private LabCid cidStCodigo;
    
    @Column(name="CID_ST_CODIGO")
    private String cidStCodigo;
    
    @Lob
    @Column(name="REQ_BL_OBSERVACAO")
    private String reqBlObservacao;
    @Column(name="REQ_ST_QUARTO")
    private String reqStQuarto;
    @Column(name="REQ_ST_LEITO")
    private String reqStLeito;
    @Column(name="REQ_ST_MATRICULA")
    private String reqStMatricula;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="REQ_DT_VALIDADECART")
    private Date reqDtValidadecart;
    @Column(name="REQ_ST_GUIA")
    private String reqStGuia;
    @Lob
    @Column(name="REQ_Bl_OBSHD")
    private String reqBlObshd;
    @Lob
    @Column(name="REQ_Bl_OBSMEDICAMENTO")
    private String reqBlObsMedicamento;
    @Column(name="COL_ST_CODIGO")
    private String colStCodigo;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="REQ_DT_COLETA")
    private Date reqDtColeta;
    @Column(name="REQ_ST_PESO")
    private String reqStPeso;
    @Column(name="REQ_ST_ALTURA")
    private String reqStAltura;
    @Column(name="REQ_IN_CODIGO")
    private Long reqInCodigo;
    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;
    @Column(name="OBS_ST_CODIGO")
    private String obsStCodigo;
    @Column(name="AGP_IN_CODIGOREMANEJADO")
    private String agpInCodigoRemanejamento;
    @Column(name="AGP_ST_OBSERVACAO")
    private String agpStObservacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="AGP_DT_DATAREMANEJO")
    private Date agpDtDataRemanejo;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="AGP_DT_INICIOATENDIMENTO")
    private Date agpDtInicioAtendimento;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="AGP_DT_FINALATENDIMENTO")
    private Date agpDtFinalAtendimento;
    @Column(name="AGP_CH_ENCAIXE")
    private Character agpChEncaixe;

    
    
    
    
//    @OneToMany(mappedBy="agpInCodigo")
//    private List<LabAgendaPacienteExame> listLabAgendaPacienteExame;

//    @OneToMany(mappedBy="agpInCodigo")
//    private List<LabRequisicao> listLabRequisicao;
//
//    public List<LabRequisicao> getListLabRequisicao() {
//        return listLabRequisicao;
//    }
//
//    public void setListLabRequisicao(List<LabRequisicao> listLabRequisicao) {
//        this.listLabRequisicao = listLabRequisicao;
//    }
 //TODO LabAgendaPaciente is the fucking mapping problem

    public Long getAgeInCodigo() {
        return ageInCodigo;
    }

    public void setAgeInCodigo(Long ageInCodigo) {
        this.ageInCodigo = ageInCodigo;
    }

    

    public Character getAgpChSexo() {
        return agpChSexo;
    }

    public void setAgpChSexo(Character agpChSexo) {
        this.agpChSexo = agpChSexo;
    }

    
    public Date getAgpDtData() {
        return agpDtData;
    }

    public void setAgpDtData(Date agpDtData) {
        this.agpDtData = agpDtData;
    }


    public Date getAgpDtNascimeto() {
        return agpDtNascimeto;
    }

    public void setAgpDtNascimeto(Date agpDtNascimeto) {
        this.agpDtNascimeto = agpDtNascimeto;
    }

    public Long getAgpInCodigo() {
        return agpInCodigo;
    }

    public void setAgpInCodigo(Long agpInCodigo) {
        this.agpInCodigo = agpInCodigo;
    }

    public Integer getAgpInStatus() {
        return agpInStatus;
    }

    public void setAgpInStatus(Integer agpInStatus) {
        this.agpInStatus = agpInStatus;
    }

    public String getAgpStNome() {
        return agpStNome;
    }

    public void setAgpStNome(String agpStNome) {
        this.agpStNome = agpStNome;
    }

    public String getCidStCodigo() {
        return cidStCodigo;
    }

    public void setCidStCodigo(String cidStCodigo) {
        this.cidStCodigo = cidStCodigo;
    }

    public String getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(String conStCodigo) {
        this.conStCodigo = conStCodigo;
    }


    public Long getPacInCodigo() {
        return pacInCodigo;
    }

    public void setPacInCodigo(Long pacInCodigo) {
        this.pacInCodigo = pacInCodigo;
    }

    public String getSolStCodigo() {
        return solStCodigo;
    }

    public void setSolStCodigo(String solStCodigo) {
        this.solStCodigo = solStCodigo;
    }

    public char getReqChGestante() {
        return reqChGestante;
    }

    public void setReqChGestante(char reqChGestante) {
        this.reqChGestante = reqChGestante;
    }

    public char getReqChRN() {
        return reqChRN;
    }

    public void setReqChRN(char reqChRN) {
        this.reqChRN = reqChRN;
    }
    public String getReqStDum() {
        return reqStDum;
    }

    public void setReqStDum(String reqStDum) {
        this.reqStDum = reqStDum;
    }

    public Character getAgpChEncaixe() {
        return agpChEncaixe;
    }

    public void setAgpChEncaixe(Character agpChEncaixe) {
        this.agpChEncaixe = agpChEncaixe;
    }

    public Date getAgpDtDataRemanejo() {
        return agpDtDataRemanejo;
    }

    public void setAgpDtDataRemanejo(Date agpDtDataRemanejo) {
        this.agpDtDataRemanejo = agpDtDataRemanejo;
    }

    public Date getAgpDtFinalAtendimento() {
        return agpDtFinalAtendimento;
    }

    public void setAgpDtFinalAtendimento(Date agpDtFinalAtendimento) {
        this.agpDtFinalAtendimento = agpDtFinalAtendimento;
    }

    public Date getAgpDtInicioAtendimento() {
        return agpDtInicioAtendimento;
    }

    public void setAgpDtInicioAtendimento(Date agpDtInicioAtendimento) {
        this.agpDtInicioAtendimento = agpDtInicioAtendimento;
    }

    public String getAgpInCodigoRemanejamento() {
        return agpInCodigoRemanejamento;
    }

    public void setAgpInCodigoRemanejamento(String agpInCodigoRemanejamento) {
        this.agpInCodigoRemanejamento = agpInCodigoRemanejamento;
    }

    public String getAgpStObservacao() {
        return agpStObservacao;
    }

    public void setAgpStObservacao(String agpStObservacao) {
        this.agpStObservacao = agpStObservacao;
    }

    public String getColStCodigo() {
        return colStCodigo;
    }

    public void setColStCodigo(String colStCodigo) {
        this.colStCodigo = colStCodigo;
    }

    public String getObsStCodigo() {
        return obsStCodigo;
    }

    public void setObsStCodigo(String obsStCodigo) {
        this.obsStCodigo = obsStCodigo;
    }

    public String getReqBlObsMedicamento() {
        return reqBlObsMedicamento;
    }

    public void setReqBlObsMedicamento(String reqBlObsMedicamento) {
        this.reqBlObsMedicamento = reqBlObsMedicamento;
    }

    public String getReqBlObservacao() {
        return reqBlObservacao;
    }

    public void setReqBlObservacao(String reqBlObservacao) {
        this.reqBlObservacao = reqBlObservacao;
    }

    public String getReqBlObshd() {
        return reqBlObshd;
    }

    public void setReqBlObshd(String reqBlObshd) {
        this.reqBlObshd = reqBlObshd;
    }

    public Date getReqDtColeta() {
        return reqDtColeta;
    }

    public void setReqDtColeta(Date reqDtColeta) {
        this.reqDtColeta = reqDtColeta;
    }

    public Date getReqDtValidadecart() {
        return reqDtValidadecart;
    }

    public void setReqDtValidadecart(Date reqDtValidadecart) {
        this.reqDtValidadecart = reqDtValidadecart;
    }

    public Long getReqInCodigo() {
        return reqInCodigo;
    }

    public void setReqInCodigo(Long reqInCodigo) {
        this.reqInCodigo = reqInCodigo;
    }

    public String getReqStAltura() {
        return reqStAltura;
    }

    public void setReqStAltura(String reqStAltura) {
        this.reqStAltura = reqStAltura;
    }

    public String getReqStGuia() {
        return reqStGuia;
    }

    public void setReqStGuia(String reqStGuia) {
        this.reqStGuia = reqStGuia;
    }

    public String getReqStLeito() {
        return reqStLeito;
    }

    public void setReqStLeito(String reqStLeito) {
        this.reqStLeito = reqStLeito;
    }

    public String getReqStMatricula() {
        return reqStMatricula;
    }

    public void setReqStMatricula(String reqStMatricula) {
        this.reqStMatricula = reqStMatricula;
    }

    public String getReqStPeso() {
        return reqStPeso;
    }

    public void setReqStPeso(String reqStPeso) {
        this.reqStPeso = reqStPeso;
    }

    public String getReqStQuarto() {
        return reqStQuarto;
    }

    public void setReqStQuarto(String reqStQuarto) {
        this.reqStQuarto = reqStQuarto;
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
        final LabAgendaPaciente other = (LabAgendaPaciente) obj;
        if (this.agpInCodigo != other.agpInCodigo && (this.agpInCodigo == null || !this.agpInCodigo.equals(other.agpInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.agpInCodigo != null ? this.agpInCodigo.hashCode() : 0);
        return hash;
    }

   

}
