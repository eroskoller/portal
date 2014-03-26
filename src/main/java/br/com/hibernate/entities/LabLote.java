/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ricardo
 */
@Entity
@Table(name="LAB_LOTE")
public class LabLote implements Serializable, Comparable{//, Comparator {
    
    @Id
    @Column(name="LOT_ST_CODIGO")
    private String lotStCodigo;
    
    @Column(name="LOT_DT_DATA")
    @Temporal(TemporalType.DATE)
    private Date lotDtData;
    @Column(name="LOT_HR_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lotHrHora;
    @Column(name="USU_ST_CODIGOINCLUSAO")
    private String usuStCodigoInclusao;
    @Column(name="USU_ST_CODIGOEXCLUSAO")
    private String usuStCodigoExclusao;
    @Column(name="LOT_DT_DATAINICIAL")
    @Temporal(TemporalType.DATE)
    private Date lotDtDataInicial;
    @Column(name="LOT_DT_DATAFINAL")
    @Temporal(TemporalType.DATE)
    private Date lotDtDataFinal;
    @Column(name="LOT_ST_ARQUIVOGERADO")
    private String lotStArquivoGerado;
    @Column(name="LOT_CH_GERADOEMS")
    private Character lotChGeradoEMS;
    @Column(name="USU_ST_CODIGOFECHAMENTO")
    private String usuStCodigoFechamento;
    @Column(name="USU_FL_VALORLOTE")
    private Float usuFlValorLote;
    @Column(name="USU_IN_QTDEXAMES")
    private Integer usuInQtdExames;
    @Column(name="PFE_ST_CODIGO")
    private String pfeStCodigo;
    @Column(name="PAC_IN_CODIGO")
    private Integer pacInCodigo;
    @Column(name="PAC_ST_NOME")
    private String pacStNome;
    @Column(name="EXU_ST_UNIDADEEX")
    private String exuStUnidadeEx;
    @Column(name="REQ_ST_GUIA")
    private String reqStGuia;
    @Column(name="ORI_ST_CODIGOS")
    private String oriStCodigos;
    @Column(name="REQ_ST_CODIGOS")
    private String reqStCodigos;
    @Column(name="EXA_ST_CODIGOS")
    private String exaStCodigos;
    @Column(name="CON_ST_CODIGOS")
    private String conStCodigos;

    public LabLote() {
    }
        
    public LabLote(String lotStCodigo) {
        this.lotStCodigo = lotStCodigo;
    }
    

    public String getConStCodigos() {
        return conStCodigos;
    }

    public void setConStCodigos(String conStCodigos) {
        this.conStCodigos = conStCodigos;
    }

    public String getExaStCodigos() {
        return exaStCodigos;
    }

    public void setExaStCodigos(String exaStCodigos) {
        this.exaStCodigos = exaStCodigos;
    }

    public String getExuStUnidadeEx() {
        return exuStUnidadeEx;
    }

    public void setExuStUnidadeEx(String exuStUnidadeEx) {
        this.exuStUnidadeEx = exuStUnidadeEx;
    }

    public Character getLotChGeradoEMS() {
        return lotChGeradoEMS;
    }

    public void setLotChGeradoEMS(Character lotChGeradoEMS) {
        this.lotChGeradoEMS = lotChGeradoEMS;
    }

    public Date getLotDtData() {
        return lotDtData;
    }

    public void setLotDtData(Date lotDtData) {
        this.lotDtData = lotDtData;
    }

    public Date getLotDtDataFinal() {
        return lotDtDataFinal;
    }

    public void setLotDtDataFinal(Date lotDtDataFinal) {
        this.lotDtDataFinal = lotDtDataFinal;
    }

    public Date getLotDtDataInicial() {
        return lotDtDataInicial;
    }

    public void setLotDtDataInicial(Date lotDtDataInicial) {
        this.lotDtDataInicial = lotDtDataInicial;
    }

    public Date getLotHrHora() {
        return lotHrHora;
    }

    public void setLotHrHora(Date lotHrHora) {
        this.lotHrHora = lotHrHora;
    }

    public String getLotStArquivoGerado() {
        return lotStArquivoGerado;
    }

    public void setLotStArquivoGerado(String lotStArquivoGerado) {
        this.lotStArquivoGerado = lotStArquivoGerado;
    }

    public String getLotStCodigo() {
        return lotStCodigo;
    }

    public void setLotStCodigo(String lotStCodigo) {
        this.lotStCodigo = lotStCodigo;
    }

    public String getOriStCodigos() {
        return oriStCodigos;
    }

    public void setOriStCodigos(String oriStCodigos) {
        this.oriStCodigos = oriStCodigos;
    }

    public Integer getPacInCodigo() {
        return pacInCodigo;
    }

    public void setPacInCodigo(Integer pacInCodigo) {
        this.pacInCodigo = pacInCodigo;
    }

    public String getPacStNome() {
        return pacStNome;
    }

    public void setPacStNome(String pacStNome) {
        this.pacStNome = pacStNome;
    }

    public String getPfeStCodigo() {
        return pfeStCodigo;
    }

    public void setPfeStCodigo(String pfeStCodigo) {
        this.pfeStCodigo = pfeStCodigo;
    }

    public String getReqStCodigos() {
        return reqStCodigos;
    }

    public void setReqStCodigos(String reqStCodigos) {
        this.reqStCodigos = reqStCodigos;
    }

    public String getReqStGuia() {
        return reqStGuia;
    }

    public void setReqStGuia(String reqStGuia) {
        this.reqStGuia = reqStGuia;
    }

    public Float getUsuFlValorLote() {
        return usuFlValorLote;
    }

    public void setUsuFlValorLote(Float usuFlValorLote) {
        this.usuFlValorLote = usuFlValorLote;
    }

    public Integer getUsuInQtdExames() {
        return usuInQtdExames;
    }

    public void setUsuInQtdExames(Integer usuInQtdExames) {
        this.usuInQtdExames = usuInQtdExames;
    }

    public String getUsuStCodigoExclusao() {
        return usuStCodigoExclusao;
    }

    public void setUsuStCodigoExclusao(String usuStCodigoExclusao) {
        this.usuStCodigoExclusao = usuStCodigoExclusao;
    }

    public String getUsuStCodigoFechamento() {
        return usuStCodigoFechamento;
    }

    public void setUsuStCodigoFechamento(String usuStCodigoFechamento) {
        this.usuStCodigoFechamento = usuStCodigoFechamento;
    }

    public String getUsuStCodigoInclusao() {
        return usuStCodigoInclusao;
    }

    public void setUsuStCodigoInclusao(String usuStCodigoInclusao) {
        this.usuStCodigoInclusao = usuStCodigoInclusao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabLote other = (LabLote) obj;
        if ((this.lotStCodigo == null) ? (other.lotStCodigo != null) : !this.lotStCodigo.equals(other.lotStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.lotStCodigo != null ? this.lotStCodigo.hashCode() : 0);
        return hash;
    }
    
//    @Override
//    public int compare(Object t, Object t1) {
//        LabLote l = (LabLote) t;
//        LabLote l1 = (LabLote) t1;
//        
//        return compareLotStCodigo_0_1(l, l1);
//    }
//    
//    private int compareLotStCodigo_0_1(LabLote l1 , LabLote l2){
//        
//        if (l1.getLotStCodigo() == null && l2.getLotStCodigo() == null) {
//            return 0;
//        } else if (l1.getLotStCodigo() == null) {
//            return -1;
//        } else if (l2.getLotStCodigo() == null) {
//            return +1;
//        } else {
//            return l1.getLotStCodigo().compareTo(l2.getLotStCodigo());
//        }
//    }

    @Override
    public int compareTo(Object o) {
        String s1 = "0";
        String s2 = "1";
        
        if(this.lotStCodigo != null){
            s1 = this.lotStCodigo;
        }
        if (o instanceof LabLote) {
                s2 = ((LabLote)o).getLotStCodigo();
        }
        
        if(s1 != null && s2 != null){
//            return new Integer(s1) - new Integer(s2);
            return s1.compareTo(s2);
        }else{
            return 0;
        }
    }
}
