/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.entities;



import br.com.hibernate.utils.OracleHelper;
import br.com.utils.tipstricks.DescricaoResumida;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_EXAME")
public class LabExame implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @Column(name = "EXA_ST_CODIGO")
    private String exaStCodigo;


    @Column(name = "MAT_ST_TRIAGEM")
    private String matStTriagem;
    @Column(name = "MAT_ST_COLETA")
    private String matStColeta;
    @Column(name = "EXA_ST_DESCRICAO")
    private String exaStDescricao;
    @Column(name = "EXA_ST_FANTASIA")
    private String exaStFantasia;
    @Lob
    @Column(name = "EXA_BL_OBSERVACAO")
    private String exaBlObservacao;
    @Column(name = "EXA_CH_IMAGEM")
    private Character exaChImagem;
    @Column(name = "EXA_CH_GRUPO")
    private Character exaChGrupo;
    @Column(name = "EXA_CH_FATURAGRUPO")
    private Character exaChFaturaGrupo;
    @Column(name = "EXA_CH_LAUDOGRUPO")
    private Character exaChLaudoGrupo;
    @Column(name = "EXA_CH_OBRIGATORIOPESO")
    private Character exaChObrigatorioPeso;
    @Column(name = "EXA_CH_OBRIGATORIOALTURA")
    private Character exaChObrigatorioAltura;
    @Column(name = "EXA_CH_INATIVO")
    private Character exaChInativo;
    @Column(name = "EXA_ST_SINONIMIAS")
    private String exaStSinonimias;
    @Column(name = "EXA_ST_PREREQUISITO")
    private String exaStPreRequisito;
    @Lob
    @Column(name = "EXA_CL_PREREQUISITO")
    private String  exaClPreRequisito;
    @Column(name = "EXA_CH_OBRIGAGESTANTE")
    private Character exaChObrigaGestante;
    @Column(name = "EXA_CH_SEXO")
    private Character exaChSexo;
    @Column(name = "EXA_CH_CONGELADO")
    private Character exaChCongelado;

    
    @OneToMany(mappedBy = "exaStCodigo")
    private List<LabDetalheRequisicao> listLabDetalheRequisicao;

    @OneToMany(mappedBy = "exaStCodigo")
    private List<LabExameMaterial> listLabExameMaterials;
    

    @Transient
    private List<LabMaterial> listLabMaterial;
    @Transient
    private List<LabExameMaterial> listLabExameMaterialEager;


    
    
    
    
    
    

    public LabExame() {
    }

    public LabExame(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

    public LabExame(String exaStCodigo, String exaStDescricao, String exaStSinonimias) {
        this.exaStCodigo = exaStCodigo;
        this.exaStDescricao = exaStDescricao;
        this.exaStSinonimias = exaStSinonimias;
    }

    
    
    
    

        public List<LabExameMaterial> getListLabExameMaterials() {
      
//                  if(exaStCodigo != null && exaStCodigo.length()>1){
//                        this.listLabExameMaterials   = OracleHelper.getListOfObjectByKey(LabExameMaterial.class, "exaStCodigo", exaStCodigo);
//
//                  }
        
          
        return listLabExameMaterials;
    }

    public void setListLabExameMaterials(List<LabExameMaterial> listLabExameMaterials) {
        this.listLabExameMaterials = listLabExameMaterials;
    }

        public List<LabDetalheRequisicao> getListLabDetalheRequisicao() {
        return listLabDetalheRequisicao;
    }

    public void setListLabDetalheRequisicao(List<LabDetalheRequisicao> listLabDetalheRequisicao) {
        this.listLabDetalheRequisicao = listLabDetalheRequisicao;
    }

        public Character getExaChCongelado() {
        return exaChCongelado;
    }

    public void setExaChCongelado(Character exaChCongelado) {
        this.exaChCongelado = exaChCongelado;
    }

        public Character getExaChFaturaGrupo() {
        return exaChFaturaGrupo;
    }

    public void setExaChFaturaGrupo(Character exaChFaturaGrupo) {
        this.exaChFaturaGrupo = exaChFaturaGrupo;
    }

        public Character getExaChGrupo() {
        return exaChGrupo;
    }

    public void setExaChGrupo(Character exaChGrupo) {
        this.exaChGrupo = exaChGrupo;
    }

        public Character getExaChImagem() {
        return exaChImagem;
    }

    public void setExaChImagem(Character exaChImagem) {
        this.exaChImagem = exaChImagem;
    }

        public Character getExaChInativo() {
        return exaChInativo;
    }

    public void setExaChInativo(Character exaChInativo) {
        this.exaChInativo = exaChInativo;
    }

        public Character getExaChLaudoGrupo() {
        return exaChLaudoGrupo;
    }

    public void setExaChLaudoGrupo(Character exaChLaudoGrupo) {
        this.exaChLaudoGrupo = exaChLaudoGrupo;
    }

        public Character getExaChObrigaGestante() {
        return exaChObrigaGestante;
    }

    public void setExaChObrigaGestante(Character exaChObrigaGestante) {
        this.exaChObrigaGestante = exaChObrigaGestante;
    }

        public Character getExaChObrigatorioAltura() {
        return exaChObrigatorioAltura;
    }

    public void setExaChObrigatorioAltura(Character exaChObrigatorioAltura) {
        this.exaChObrigatorioAltura = exaChObrigatorioAltura;
    }

        public Character getExaChObrigatorioPeso() {
        return exaChObrigatorioPeso;
    }

    public void setExaChObrigatorioPeso(Character exaChObrigatorioPeso) {
        this.exaChObrigatorioPeso = exaChObrigatorioPeso;
    }

        public Character getExaChSexo() {
        return exaChSexo;
    }

    public void setExaChSexo(Character exaChSexo) {
        this.exaChSexo = exaChSexo;
    }






//    @OneToMany(mappedBy="exaStCodigo")
//    private List<LabAgendaPaciente> listLabAgendaPacientes;





    

   
    public String getExaBlObservacao() {
        return exaBlObservacao;
    }

    public void setExaBlObservacao(String exaBlObservacao) {
        this.exaBlObservacao = exaBlObservacao;
    }

   

        public String getExaClPreRequisito() {
        return exaClPreRequisito;
    }

    public void setExaClPreRequisito(String exaClPreRequisito) {
        this.exaClPreRequisito = exaClPreRequisito;
    }

        public String getExaStCodigo() {
        return exaStCodigo;
    }

    public void setExaStCodigo(String exaStCodigo) {
        this.exaStCodigo = exaStCodigo;
    }

        public String getExaStDescricao() {
        return exaStDescricao;
    }
    
    @Transient
    public String getExaStDescricaoResumida() {
        return DescricaoResumida.descResuminda(exaStDescricao, 10);
    }
    

    public void setExaStDescricao(String exaStDescricao) {
        this.exaStDescricao = exaStDescricao;
    }

        public String getExaStFantasia() {
        return exaStFantasia;
    }

    public void setExaStFantasia(String exaStFantasia) {
        this.exaStFantasia = exaStFantasia;
    }

        public String getExaStPreRequisito() {
        return exaStPreRequisito;
    }

    public void setExaStPreRequisito(String exaStPreRequisito) {
        this.exaStPreRequisito = exaStPreRequisito;
    }

        public String getExaStSinonimias() {
        return exaStSinonimias;
    }

    public void setExaStSinonimias(String exaStSinonimias) {
        this.exaStSinonimias = exaStSinonimias;
    }

        public String getMatStColeta() {
        return matStColeta;
    }

    public void setMatStColeta(String matStColeta) {
        this.matStColeta = matStColeta;
    }

        public String getMatStTriagem() {
        return matStTriagem;
    }

    public void setMatStTriagem(String matStTriagem) {
        this.matStTriagem = matStTriagem;
    }



    @Transient
        public List<LabMaterial> getListLabMaterial(String strDbName){
        if(listLabMaterial == null){
             if(exaStCodigo != null && exaStCodigo.length()>1){
                List<LabExameMaterial>  l = getListLabExameMaterialEager(strDbName);//OracleHelper.getListOfObjectByKey(LabExameMaterial.class, "exaStCodigo", exaStCodigo);
                List<LabMaterial>  l2 = null;
                if(l != null && l.size()>0){
                    l2 = new ArrayList<LabMaterial>();
                    for(LabExameMaterial lem : l ){
                        l2.add(lem.getMatStCodigo());
                    }

                    listLabMaterial = l2;
                    return listLabMaterial;
                }
            }
        }
       
        return listLabMaterial;
    }


        @Transient
         public List<LabExameMaterial> getListLabExameMaterialEager(String strDbName){
        if(listLabExameMaterialEager == null){
             if(exaStCodigo != null && exaStCodigo.length()>1){
                List<LabExameMaterial>  l = OracleHelper.getListOfObjectByKey(LabExameMaterial.class, "exaStCodigo", exaStCodigo,strDbName);
                if(l != null && l.size()>0){
                    listLabExameMaterialEager = l;
                    setListLabExameMaterials(listLabExameMaterials);
                    return listLabExameMaterialEager;
                }
            }
        }

        return listLabExameMaterialEager;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabExame other = (LabExame) obj;
        if ((this.exaStCodigo == null) ? (other.exaStCodigo != null) : !this.exaStCodigo.equals(other.exaStCodigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.exaStCodigo != null ? this.exaStCodigo.hashCode() : 0);
        return hash;
    }




    
    
    

}
