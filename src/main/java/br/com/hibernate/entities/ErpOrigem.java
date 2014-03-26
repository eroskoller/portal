/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import com.thoughtworks.xstream.XStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_ORIGEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpOrigem.findAll", query = "SELECT e FROM ErpOrigem e"),
    @NamedQuery(name = "ErpOrigem.findByOriStCodigo", query = "SELECT e FROM ErpOrigem e WHERE e.erpOrigemPK.oriStCodigo = :oriStCodigo"),
    @NamedQuery(name = "ErpOrigem.findByUniStCodigo", query = "SELECT e FROM ErpOrigem e WHERE e.erpOrigemPK.uniStCodigo = :uniStCodigo"),
    @NamedQuery(name = "ErpOrigem.findByOriStDescricao", query = "SELECT e FROM ErpOrigem e WHERE e.oriStDescricao = :oriStDescricao"),
    @NamedQuery(name = "ErpOrigem.findByOriChImprimecoleta", query = "SELECT e FROM ErpOrigem e WHERE e.oriChImprimecoleta = :oriChImprimecoleta"),
    @NamedQuery(name = "ErpOrigem.findByOriChImprimeetiqueta", query = "SELECT e FROM ErpOrigem e WHERE e.oriChImprimeetiqueta = :oriChImprimeetiqueta"),
    @NamedQuery(name = "ErpOrigem.findByOriStEstado", query = "SELECT e FROM ErpOrigem e WHERE e.oriStEstado = :oriStEstado"),
    @NamedQuery(name = "ErpOrigem.findByOriInCidade", query = "SELECT e FROM ErpOrigem e WHERE e.oriInCidade = :oriInCidade"),
    @NamedQuery(name = "ErpOrigem.findByOriInBairro", query = "SELECT e FROM ErpOrigem e WHERE e.oriInBairro = :oriInBairro"),
    @NamedQuery(name = "ErpOrigem.findByOriStCep", query = "SELECT e FROM ErpOrigem e WHERE e.oriStCep = :oriStCep"),
    @NamedQuery(name = "ErpOrigem.findByOriInNumero", query = "SELECT e FROM ErpOrigem e WHERE e.oriInNumero = :oriInNumero"),
    @NamedQuery(name = "ErpOrigem.findByOriStCidade", query = "SELECT e FROM ErpOrigem e WHERE e.oriStCidade = :oriStCidade"),
    @NamedQuery(name = "ErpOrigem.findByOriStBairro", query = "SELECT e FROM ErpOrigem e WHERE e.oriStBairro = :oriStBairro"),
    @NamedQuery(name = "ErpOrigem.findByOriStEndereco", query = "SELECT e FROM ErpOrigem e WHERE e.oriStEndereco = :oriStEndereco"),
    @NamedQuery(name = "ErpOrigem.findByOriChUrgencia", query = "SELECT e FROM ErpOrigem e WHERE e.oriChUrgencia = :oriChUrgencia"),
    @NamedQuery(name = "ErpOrigem.findByOriStComplemento", query = "SELECT e FROM ErpOrigem e WHERE e.oriStComplemento = :oriStComplemento"),
    @NamedQuery(name = "ErpOrigem.findByOriStEmail", query = "SELECT e FROM ErpOrigem e WHERE e.oriStEmail = :oriStEmail"),
    @NamedQuery(name = "ErpOrigem.findByOriStContato", query = "SELECT e FROM ErpOrigem e WHERE e.oriStContato = :oriStContato"),
    @NamedQuery(name = "ErpOrigem.findByOriStTelefone", query = "SELECT e FROM ErpOrigem e WHERE e.oriStTelefone = :oriStTelefone"),
    @NamedQuery(name = "ErpOrigem.findByOriStCelular", query = "SELECT e FROM ErpOrigem e WHERE e.oriStCelular = :oriStCelular"),
    @NamedQuery(name = "ErpOrigem.findByOriStFax", query = "SELECT e FROM ErpOrigem e WHERE e.oriStFax = :oriStFax"),
    @NamedQuery(name = "ErpOrigem.findByOriFlRodapetam", query = "SELECT e FROM ErpOrigem e WHERE e.oriFlRodapetam = :oriFlRodapetam"),
    @NamedQuery(name = "ErpOrigem.findByOriFlCabectam", query = "SELECT e FROM ErpOrigem e WHERE e.oriFlCabectam = :oriFlCabectam"),
    @NamedQuery(name = "ErpOrigem.findByConStCodigo", query = "SELECT e FROM ErpOrigem e WHERE e.conStCodigo = :conStCodigo"),
    @NamedQuery(name = "ErpOrigem.findByRegStCodigo", query = "SELECT e FROM ErpOrigem e WHERE e.regStCodigo = :regStCodigo"),
    @NamedQuery(name = "ErpOrigem.findByLocStCodigo", query = "SELECT e FROM ErpOrigem e WHERE e.locStCodigo = :locStCodigo"),
    @NamedQuery(name = "ErpOrigem.findByOriChLocStCodigo", query = "SELECT e FROM ErpOrigem e WHERE e.oriChLocStCodigo = :oriChLocStCodigo"),
    @NamedQuery(name = "ErpOrigem.findByOriChColStCodigo", query = "SELECT e FROM ErpOrigem e WHERE e.oriChColStCodigo = :oriChColStCodigo"),
    @NamedQuery(name = "ErpOrigem.findByOriChConfereautomatico", query = "SELECT e FROM ErpOrigem e WHERE e.oriChConfereautomatico = :oriChConfereautomatico"),
    @NamedQuery(name = "ErpOrigem.findByOriChConfereautomaticofat", query = "SELECT e FROM ErpOrigem e WHERE e.oriChConfereautomaticofat = :oriChConfereautomaticofat"),
    @NamedQuery(name = "ErpOrigem.findByOriStCaminhologo", query = "SELECT e FROM ErpOrigem e WHERE e.oriStCaminhologo = :oriStCaminhologo"),
    @NamedQuery(name = "ErpOrigem.findByOriStMarcaetiqueta", query = "SELECT e FROM ErpOrigem e WHERE e.oriStMarcaetiqueta = :oriStMarcaetiqueta"),
    @NamedQuery(name = "ErpOrigem.findByOriChCabecpadrao", query = "SELECT e FROM ErpOrigem e WHERE e.oriChCabecpadrao = :oriChCabecpadrao"),
    @NamedQuery(name = "ErpOrigem.findByOriChEtiquetacomprova", query = "SELECT e FROM ErpOrigem e WHERE e.oriChEtiquetacomprova = :oriChEtiquetacomprova"),
    @NamedQuery(name = "ErpOrigem.findByOriStItemEms", query = "SELECT e FROM ErpOrigem e WHERE e.oriStItemEms = :oriStItemEms"),
    @NamedQuery(name = "ErpOrigem.findByOriStEmscodcli", query = "SELECT e FROM ErpOrigem e WHERE e.oriStEmscodcli = :oriStEmscodcli"),
    @NamedQuery(name = "ErpOrigem.findByOriStEmscgc", query = "SELECT e FROM ErpOrigem e WHERE e.oriStEmscgc = :oriStEmscgc"),
    @NamedQuery(name = "ErpOrigem.findByOriStEmsnomeabrev", query = "SELECT e FROM ErpOrigem e WHERE e.oriStEmsnomeabrev = :oriStEmsnomeabrev"),
    @NamedQuery(name = "ErpOrigem.findByOriStEmsitemdatasul", query = "SELECT e FROM ErpOrigem e WHERE e.oriStEmsitemdatasul = :oriStEmsitemdatasul"),
    @NamedQuery(name = "ErpOrigem.findBySupStCodigo", query = "SELECT e FROM ErpOrigem e WHERE e.supStCodigo = :supStCodigo"),
    @NamedQuery(name = "ErpOrigem.findByLegStCodigoinicial", query = "SELECT e FROM ErpOrigem e WHERE e.legStCodigoinicial = :legStCodigoinicial"),
    @NamedQuery(name = "ErpOrigem.findByLegStCodigofinal", query = "SELECT e FROM ErpOrigem e WHERE e.legStCodigofinal = :legStCodigofinal"),
    @NamedQuery(name = "ErpOrigem.findByOriStCnes", query = "SELECT e FROM ErpOrigem e WHERE e.oriStCnes = :oriStCnes"),
    @NamedQuery(name = "ErpOrigem.findByOriChObrigacoletor", query = "SELECT e FROM ErpOrigem e WHERE e.oriChObrigacoletor = :oriChObrigacoletor"),
    @NamedQuery(name = "ErpOrigem.findByOriChObrigadatacoleta", query = "SELECT e FROM ErpOrigem e WHERE e.oriChObrigadatacoleta = :oriChObrigadatacoleta"),
    @NamedQuery(name = "ErpOrigem.findByOriStCmes", query = "SELECT e FROM ErpOrigem e WHERE e.oriStCmes = :oriStCmes"),
    @NamedQuery(name = "ErpOrigem.findByOriStSequencia", query = "SELECT e FROM ErpOrigem e WHERE e.oriStSequencia = :oriStSequencia"),
    @NamedQuery(name = "ErpOrigem.findByOriChPostohosp", query = "SELECT e FROM ErpOrigem e WHERE e.oriChPostohosp = :oriChPostohosp"),
    @NamedQuery(name = "ErpOrigem.findByOriInTipopesquisa", query = "SELECT e FROM ErpOrigem e WHERE e.oriInTipopesquisa = :oriInTipopesquisa"),
    @NamedQuery(name = "ErpOrigem.findByOriChObrigadatanasc", query = "SELECT e FROM ErpOrigem e WHERE e.oriChObrigadatanasc = :oriChObrigadatanasc"),
    @NamedQuery(name = "ErpOrigem.findByAloInCodigo", query = "SELECT e FROM ErpOrigem e WHERE e.aloInCodigo = :aloInCodigo"),
    @NamedQuery(name = "ErpOrigem.findByOriChSenhaobrigatoria", query = "SELECT e FROM ErpOrigem e WHERE e.oriChSenhaobrigatoria = :oriChSenhaobrigatoria"),
    @NamedQuery(name = "ErpOrigem.findByOriChLocalentregaetiqueta", query = "SELECT e FROM ErpOrigem e WHERE e.oriChLocalentregaetiqueta = :oriChLocalentregaetiqueta"),
    @NamedQuery(name = "ErpOrigem.findByOriChObrigasolicitante", query = "SELECT e FROM ErpOrigem e WHERE e.oriChObrigasolicitante = :oriChObrigasolicitante"),
    @NamedQuery(name = "ErpOrigem.findByOriStColetorpadrao", query = "SELECT e FROM ErpOrigem e WHERE e.oriStColetorpadrao = :oriStColetorpadrao"),
    @NamedQuery(name = "ErpOrigem.findByOriHrHoracoletapadrao", query = "SELECT e FROM ErpOrigem e WHERE e.oriHrHoracoletapadrao = :oriHrHoracoletapadrao"),
    @NamedQuery(name = "ErpOrigem.findByOriStFantasia", query = "SELECT e FROM ErpOrigem e WHERE e.oriStFantasia = :oriStFantasia"),
    @NamedQuery(name = "ErpOrigem.findByOriChObrigamedicamento", query = "SELECT e FROM ErpOrigem e WHERE e.oriChObrigamedicamento = :oriChObrigamedicamento"),
    @NamedQuery(name = "ErpOrigem.findByOriChAtivo", query = "SELECT e FROM ErpOrigem e WHERE e.oriChAtivo = :oriChAtivo"),
    @NamedQuery(name = "ErpOrigem.findByOriChSenhanocadastro", query = "SELECT e FROM ErpOrigem e WHERE e.oriChSenhanocadastro = :oriChSenhanocadastro"),
    @NamedQuery(name = "ErpOrigem.findByOriChObrigalocalentrega", query = "SELECT e FROM ErpOrigem e WHERE e.oriChObrigalocalentrega = :oriChObrigalocalentrega"),
    @NamedQuery(name = "ErpOrigem.findByOriChCabecinternet", query = "SELECT e FROM ErpOrigem e WHERE e.oriChCabecinternet = :oriChCabecinternet"),
    @NamedQuery(name = "ErpOrigem.findByOriChRodapeinternet", query = "SELECT e FROM ErpOrigem e WHERE e.oriChRodapeinternet = :oriChRodapeinternet"),
    @NamedQuery(name = "ErpOrigem.findByOriStPaginaweb", query = "SELECT e FROM ErpOrigem e WHERE e.oriStPaginaweb = :oriStPaginaweb")})
public class ErpOrigem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ErpOrigemPK erpOrigemPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ORI_ST_DESCRICAO")
    private String oriStDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORI_CH_IMPRIMECOLETA")
    private char oriChImprimecoleta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORI_CH_IMPRIMEETIQUETA")
    private char oriChImprimeetiqueta;
    @Size(max = 2)
    @Column(name = "ORI_ST_ESTADO")
    private String oriStEstado;
    @Column(name = "ORI_IN_CIDADE")
    private BigInteger oriInCidade;
    @Column(name = "ORI_IN_BAIRRO")
    private BigInteger oriInBairro;
    @Size(max = 8)
    @Column(name = "ORI_ST_CEP")
    private String oriStCep;
    @Column(name = "ORI_IN_NUMERO")
    private BigInteger oriInNumero;
    @Size(max = 50)
    @Column(name = "ORI_ST_CIDADE")
    private String oriStCidade;
    @Size(max = 50)
    @Column(name = "ORI_ST_BAIRRO")
    private String oriStBairro;
    @Size(max = 70)
    @Column(name = "ORI_ST_ENDERECO")
    private String oriStEndereco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORI_CH_URGENCIA")
    private char oriChUrgencia;
    @Size(max = 20)
    @Column(name = "ORI_ST_COMPLEMENTO")
    private String oriStComplemento;
    @Size(max = 90)
    @Column(name = "ORI_ST_EMAIL")
    private String oriStEmail;
    @Size(max = 50)
    @Column(name = "ORI_ST_CONTATO")
    private String oriStContato;
    @Size(max = 20)
    @Column(name = "ORI_ST_TELEFONE")
    private String oriStTelefone;
    @Size(max = 20)
    @Column(name = "ORI_ST_CELULAR")
    private String oriStCelular;
    @Size(max = 20)
    @Column(name = "ORI_ST_FAX")
    private String oriStFax;
    @Column(name = "ORI_FL_RODAPETAM")
    private BigInteger oriFlRodapetam;
    @Column(name = "ORI_FL_CABECTAM")
    private BigInteger oriFlCabectam;
    @Size(max = 5)
    @Column(name = "CON_ST_CODIGO")
    private String conStCodigo;
    @Size(max = 10)
    @Column(name = "REG_ST_CODIGO")
    private String regStCodigo;
    @Size(max = 10)
    @Column(name = "LOC_ST_CODIGO")
    private String locStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORI_CH_LOC_ST_CODIGO")
    private char oriChLocStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORI_CH_COL_ST_CODIGO")
    private char oriChColStCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORI_CH_CONFEREAUTOMATICO")
    private char oriChConfereautomatico;
    @Column(name = "ORI_CH_CONFEREAUTOMATICOFAT")
    private Character oriChConfereautomaticofat;
    @Size(max = 200)
    @Column(name = "ORI_ST_CAMINHOLOGO")
    private String oriStCaminhologo;
    @Size(max = 20)
    @Column(name = "ORI_ST_MARCAETIQUETA")
    private String oriStMarcaetiqueta;
    @Lob
    @Column(name = "ORI_BL_RODAPEOLD")
    private Serializable oriBlRodapeold;
    @Column(name = "ORI_CH_CABECPADRAO")
    private Character oriChCabecpadrao;
    @Lob
    @Column(name = "ORI_BL_CABEC_OLD")
    private Serializable oriBlCabecOld;
    @Lob
    @Column(name = "ORI_BL_LOGOTIPO_OLD")
    private Serializable oriBlLogotipoOld;
    @Lob
    @Column(name = "ORI_BL_OBS_OLD")
    private Serializable oriBlObsOld;
    @Lob
    @Column(name = "ORI_BL_RODAPE_OLD")
    private Serializable oriBlRodapeOld;
    @Lob
    @Column(name = "ORI_BL_CABEC")
    private String oriBlCabec;
    @Lob
    @Column(name = "ORI_BL_OBS")
    private String oriBlObs;
    @Lob
    @Column(name = "ORI_BL_RODAPE")
    private String oriBlRodape;
    @Lob
    @Column(name = "ORI_BL_LOGOTIPO")
    private Serializable oriBlLogotipo;
    @Lob
    @Column(name = "ORI_LR_LOGOTIPO")
    private byte[] oriLrLogotipo;
    @Column(name = "ORI_CH_ETIQUETACOMPROVA")
    private Character oriChEtiquetacomprova;
    @Size(max = 16)
    @Column(name = "ORI_ST_ITEM_EMS")
    private String oriStItemEms;
    @Size(max = 5)
    @Column(name = "ORI_ST_EMSCODCLI")
    private String oriStEmscodcli;
    @Size(max = 20)
    @Column(name = "ORI_ST_EMSCGC")
    private String oriStEmscgc;
    @Size(max = 20)
    @Column(name = "ORI_ST_EMSNOMEABREV")
    private String oriStEmsnomeabrev;
    @Size(max = 5)
    @Column(name = "ORI_ST_EMSITEMDATASUL")
    private String oriStEmsitemdatasul;
    @Size(max = 20)
    @Column(name = "SUP_ST_CODIGO")
    private String supStCodigo;
    @Size(max = 3)
    @Column(name = "LEG_ST_CODIGOINICIAL")
    private String legStCodigoinicial;
    @Size(max = 3)
    @Column(name = "LEG_ST_CODIGOFINAL")
    private String legStCodigofinal;
    @Size(max = 20)
    @Column(name = "ORI_ST_CNES")
    private String oriStCnes;
    @Column(name = "ORI_CH_OBRIGACOLETOR")
    private Character oriChObrigacoletor;
    @Column(name = "ORI_CH_OBRIGADATACOLETA")
    private Character oriChObrigadatacoleta;
    @Size(max = 20)
    @Column(name = "ORI_ST_CMES")
    private String oriStCmes;
    @Size(max = 3)
    @Column(name = "ORI_ST_SEQUENCIA")
    private String oriStSequencia;
    @Column(name = "ORI_CH_POSTOHOSP")
    private Character oriChPostohosp;
    @Column(name = "ORI_IN_TIPOPESQUISA")
    private BigInteger oriInTipopesquisa;
    @Column(name = "ORI_CH_OBRIGADATANASC")
    private Character oriChObrigadatanasc;
    @Column(name = "ALO_IN_CODIGO")
    private BigInteger aloInCodigo;
    @Column(name = "ORI_CH_SENHAOBRIGATORIA")
    private Character oriChSenhaobrigatoria;
    @Column(name = "ORI_CH_LOCALENTREGAETIQUETA")
    private Character oriChLocalentregaetiqueta;
    @Column(name = "ORI_CH_OBRIGASOLICITANTE")
    private Character oriChObrigasolicitante;
    @Size(max = 10)
    @Column(name = "ORI_ST_COLETORPADRAO")
    private String oriStColetorpadrao;
    @Column(name = "ORI_HR_HORACOLETAPADRAO")
    @Temporal(TemporalType.DATE)
    private Date oriHrHoracoletapadrao;
    @Size(max = 50)
    @Column(name = "ORI_ST_FANTASIA")
    private String oriStFantasia;
    @Column(name = "ORI_CH_OBRIGAMEDICAMENTO")
    private Character oriChObrigamedicamento;
    @Column(name = "ORI_CH_ATIVO")
    private Character oriChAtivo;
    @Column(name = "ORI_CH_SENHANOCADASTRO")
    private Character oriChSenhanocadastro;
    @Column(name = "ORI_CH_OBRIGALOCALENTREGA")
    private Character oriChObrigalocalentrega;
    @Column(name = "ORI_CH_CABECINTERNET")
    private Character oriChCabecinternet;
    @Column(name = "ORI_CH_RODAPEINTERNET")
    private Character oriChRodapeinternet;
    @Size(max = 200)
    @Column(name = "ORI_ST_PAGINAWEB")
    private String oriStPaginaweb;
    @JoinColumn(name = "UNI_ST_CODIGO", referencedColumnName = "UNI_ST_CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ErpUnidade erpUnidade;

    public ErpOrigem() {
    }

    public ErpOrigem(ErpOrigemPK erpOrigemPK) {
        this.erpOrigemPK = erpOrigemPK;
    }

    public ErpOrigem(ErpOrigemPK erpOrigemPK, String oriStDescricao) {
        this.erpOrigemPK = erpOrigemPK;
        this.oriStDescricao = oriStDescricao;
    }
    

    public ErpOrigem(ErpOrigemPK erpOrigemPK, String oriStDescricao, char oriChImprimecoleta, char oriChImprimeetiqueta, char oriChUrgencia, char oriChLocStCodigo, char oriChColStCodigo, char oriChConfereautomatico) {
        this.erpOrigemPK = erpOrigemPK;
        this.oriStDescricao = oriStDescricao;
        this.oriChImprimecoleta = oriChImprimecoleta;
        this.oriChImprimeetiqueta = oriChImprimeetiqueta;
        this.oriChUrgencia = oriChUrgencia;
        this.oriChLocStCodigo = oriChLocStCodigo;
        this.oriChColStCodigo = oriChColStCodigo;
        this.oriChConfereautomatico = oriChConfereautomatico;
    }

    public ErpOrigem(String oriStCodigo, String uniStCodigo) {
        this.erpOrigemPK = new ErpOrigemPK(oriStCodigo, uniStCodigo);
    }

    public ErpOrigemPK getErpOrigemPK() {
        return erpOrigemPK;
    }

    public void setErpOrigemPK(ErpOrigemPK erpOrigemPK) {
        this.erpOrigemPK = erpOrigemPK;
    }

    public String getOriStDescricao() {
        return oriStDescricao;
    }

    public void setOriStDescricao(String oriStDescricao) {
        this.oriStDescricao = oriStDescricao;
    }

    public char getOriChImprimecoleta() {
        return oriChImprimecoleta;
    }

    public void setOriChImprimecoleta(char oriChImprimecoleta) {
        this.oriChImprimecoleta = oriChImprimecoleta;
    }

    public char getOriChImprimeetiqueta() {
        return oriChImprimeetiqueta;
    }

    public void setOriChImprimeetiqueta(char oriChImprimeetiqueta) {
        this.oriChImprimeetiqueta = oriChImprimeetiqueta;
    }

    public String getOriStEstado() {
        return oriStEstado;
    }

    public void setOriStEstado(String oriStEstado) {
        this.oriStEstado = oriStEstado;
    }

    public BigInteger getOriInCidade() {
        return oriInCidade;
    }

    public void setOriInCidade(BigInteger oriInCidade) {
        this.oriInCidade = oriInCidade;
    }

    public BigInteger getOriInBairro() {
        return oriInBairro;
    }

    public void setOriInBairro(BigInteger oriInBairro) {
        this.oriInBairro = oriInBairro;
    }

    public String getOriStCep() {
        return oriStCep;
    }

    public void setOriStCep(String oriStCep) {
        this.oriStCep = oriStCep;
    }

    public BigInteger getOriInNumero() {
        return oriInNumero;
    }

    public void setOriInNumero(BigInteger oriInNumero) {
        this.oriInNumero = oriInNumero;
    }

    public String getOriStCidade() {
        return oriStCidade;
    }

    public void setOriStCidade(String oriStCidade) {
        this.oriStCidade = oriStCidade;
    }

    public String getOriStBairro() {
        return oriStBairro;
    }

    public void setOriStBairro(String oriStBairro) {
        this.oriStBairro = oriStBairro;
    }

    public String getOriStEndereco() {
        return oriStEndereco;
    }

    public void setOriStEndereco(String oriStEndereco) {
        this.oriStEndereco = oriStEndereco;
    }

    public char getOriChUrgencia() {
        return oriChUrgencia;
    }

    public void setOriChUrgencia(char oriChUrgencia) {
        this.oriChUrgencia = oriChUrgencia;
    }

    public String getOriStComplemento() {
        return oriStComplemento;
    }

    public void setOriStComplemento(String oriStComplemento) {
        this.oriStComplemento = oriStComplemento;
    }

    public String getOriStEmail() {
        return oriStEmail;
    }

    public void setOriStEmail(String oriStEmail) {
        this.oriStEmail = oriStEmail;
    }

    public String getOriStContato() {
        return oriStContato;
    }

    public void setOriStContato(String oriStContato) {
        this.oriStContato = oriStContato;
    }

    public String getOriStTelefone() {
        return oriStTelefone;
    }

    public void setOriStTelefone(String oriStTelefone) {
        this.oriStTelefone = oriStTelefone;
    }

    public String getOriStCelular() {
        return oriStCelular;
    }

    public void setOriStCelular(String oriStCelular) {
        this.oriStCelular = oriStCelular;
    }

    public String getOriStFax() {
        return oriStFax;
    }

    public void setOriStFax(String oriStFax) {
        this.oriStFax = oriStFax;
    }

    public BigInteger getOriFlRodapetam() {
        return oriFlRodapetam;
    }

    public void setOriFlRodapetam(BigInteger oriFlRodapetam) {
        this.oriFlRodapetam = oriFlRodapetam;
    }

    public BigInteger getOriFlCabectam() {
        return oriFlCabectam;
    }

    public void setOriFlCabectam(BigInteger oriFlCabectam) {
        this.oriFlCabectam = oriFlCabectam;
    }

    public String getConStCodigo() {
        return conStCodigo;
    }

    public void setConStCodigo(String conStCodigo) {
        this.conStCodigo = conStCodigo;
    }

    public String getRegStCodigo() {
        return regStCodigo;
    }

    public void setRegStCodigo(String regStCodigo) {
        this.regStCodigo = regStCodigo;
    }

    public String getLocStCodigo() {
        return locStCodigo;
    }

    public void setLocStCodigo(String locStCodigo) {
        this.locStCodigo = locStCodigo;
    }

    public char getOriChLocStCodigo() {
        return oriChLocStCodigo;
    }

    public void setOriChLocStCodigo(char oriChLocStCodigo) {
        this.oriChLocStCodigo = oriChLocStCodigo;
    }

    public char getOriChColStCodigo() {
        return oriChColStCodigo;
    }

    public void setOriChColStCodigo(char oriChColStCodigo) {
        this.oriChColStCodigo = oriChColStCodigo;
    }

    public char getOriChConfereautomatico() {
        return oriChConfereautomatico;
    }

    public void setOriChConfereautomatico(char oriChConfereautomatico) {
        this.oriChConfereautomatico = oriChConfereautomatico;
    }

    public Character getOriChConfereautomaticofat() {
        return oriChConfereautomaticofat;
    }

    public void setOriChConfereautomaticofat(Character oriChConfereautomaticofat) {
        this.oriChConfereautomaticofat = oriChConfereautomaticofat;
    }

    public String getOriStCaminhologo() {
        return oriStCaminhologo;
    }

    public void setOriStCaminhologo(String oriStCaminhologo) {
        this.oriStCaminhologo = oriStCaminhologo;
    }

    public String getOriStMarcaetiqueta() {
        return oriStMarcaetiqueta;
    }

    public void setOriStMarcaetiqueta(String oriStMarcaetiqueta) {
        this.oriStMarcaetiqueta = oriStMarcaetiqueta;
    }

    public Serializable getOriBlRodapeold() {
        return oriBlRodapeold;
    }

    public void setOriBlRodapeold(Serializable oriBlRodapeold) {
        this.oriBlRodapeold = oriBlRodapeold;
    }

    public Character getOriChCabecpadrao() {
        return oriChCabecpadrao;
    }

    public void setOriChCabecpadrao(Character oriChCabecpadrao) {
        this.oriChCabecpadrao = oriChCabecpadrao;
    }

    public Serializable getOriBlCabecOld() {
        return oriBlCabecOld;
    }

    public void setOriBlCabecOld(Serializable oriBlCabecOld) {
        this.oriBlCabecOld = oriBlCabecOld;
    }

    public Serializable getOriBlLogotipoOld() {
        return oriBlLogotipoOld;
    }

    public void setOriBlLogotipoOld(Serializable oriBlLogotipoOld) {
        this.oriBlLogotipoOld = oriBlLogotipoOld;
    }

    public Serializable getOriBlObsOld() {
        return oriBlObsOld;
    }

    public void setOriBlObsOld(Serializable oriBlObsOld) {
        this.oriBlObsOld = oriBlObsOld;
    }

    public Serializable getOriBlRodapeOld() {
        return oriBlRodapeOld;
    }

    public void setOriBlRodapeOld(Serializable oriBlRodapeOld) {
        this.oriBlRodapeOld = oriBlRodapeOld;
    }

    public String getOriBlCabec() {
        return oriBlCabec;
    }

    public void setOriBlCabec(String oriBlCabec) {
        this.oriBlCabec = oriBlCabec;
    }

    public String getOriBlObs() {
        return oriBlObs;
    }

    public void setOriBlObs(String oriBlObs) {
        this.oriBlObs = oriBlObs;
    }

    public String getOriBlRodape() {
        return oriBlRodape;
    }

    public void setOriBlRodape(String oriBlRodape) {
        this.oriBlRodape = oriBlRodape;
    }

    public Serializable getOriBlLogotipo() {
        return oriBlLogotipo;
    }

    public void setOriBlLogotipo(Serializable oriBlLogotipo) {
        this.oriBlLogotipo = oriBlLogotipo;
    }

    public byte[] getOriLrLogotipo() {
        return oriLrLogotipo;
    }

    public void setOriLrLogotipo(byte[] oriLrLogotipo) {
        this.oriLrLogotipo = oriLrLogotipo;
    }

    public Character getOriChEtiquetacomprova() {
        return oriChEtiquetacomprova;
    }

    public void setOriChEtiquetacomprova(Character oriChEtiquetacomprova) {
        this.oriChEtiquetacomprova = oriChEtiquetacomprova;
    }

    public String getOriStItemEms() {
        return oriStItemEms;
    }

    public void setOriStItemEms(String oriStItemEms) {
        this.oriStItemEms = oriStItemEms;
    }

    public String getOriStEmscodcli() {
        return oriStEmscodcli;
    }

    public void setOriStEmscodcli(String oriStEmscodcli) {
        this.oriStEmscodcli = oriStEmscodcli;
    }

    public String getOriStEmscgc() {
        return oriStEmscgc;
    }

    public void setOriStEmscgc(String oriStEmscgc) {
        this.oriStEmscgc = oriStEmscgc;
    }

    public String getOriStEmsnomeabrev() {
        return oriStEmsnomeabrev;
    }

    public void setOriStEmsnomeabrev(String oriStEmsnomeabrev) {
        this.oriStEmsnomeabrev = oriStEmsnomeabrev;
    }

    public String getOriStEmsitemdatasul() {
        return oriStEmsitemdatasul;
    }

    public void setOriStEmsitemdatasul(String oriStEmsitemdatasul) {
        this.oriStEmsitemdatasul = oriStEmsitemdatasul;
    }

    public String getSupStCodigo() {
        return supStCodigo;
    }

    public void setSupStCodigo(String supStCodigo) {
        this.supStCodigo = supStCodigo;
    }

    public String getLegStCodigoinicial() {
        return legStCodigoinicial;
    }

    public void setLegStCodigoinicial(String legStCodigoinicial) {
        this.legStCodigoinicial = legStCodigoinicial;
    }

    public String getLegStCodigofinal() {
        return legStCodigofinal;
    }

    public void setLegStCodigofinal(String legStCodigofinal) {
        this.legStCodigofinal = legStCodigofinal;
    }

    public String getOriStCnes() {
        return oriStCnes;
    }

    public void setOriStCnes(String oriStCnes) {
        this.oriStCnes = oriStCnes;
    }

    public Character getOriChObrigacoletor() {
        return oriChObrigacoletor;
    }

    public void setOriChObrigacoletor(Character oriChObrigacoletor) {
        this.oriChObrigacoletor = oriChObrigacoletor;
    }

    public Character getOriChObrigadatacoleta() {
        return oriChObrigadatacoleta;
    }

    public void setOriChObrigadatacoleta(Character oriChObrigadatacoleta) {
        this.oriChObrigadatacoleta = oriChObrigadatacoleta;
    }

    public String getOriStCmes() {
        return oriStCmes;
    }

    public void setOriStCmes(String oriStCmes) {
        this.oriStCmes = oriStCmes;
    }

    public String getOriStSequencia() {
        return oriStSequencia;
    }

    public void setOriStSequencia(String oriStSequencia) {
        this.oriStSequencia = oriStSequencia;
    }

    public Character getOriChPostohosp() {
        return oriChPostohosp;
    }

    public void setOriChPostohosp(Character oriChPostohosp) {
        this.oriChPostohosp = oriChPostohosp;
    }

    public BigInteger getOriInTipopesquisa() {
        return oriInTipopesquisa;
    }

    public void setOriInTipopesquisa(BigInteger oriInTipopesquisa) {
        this.oriInTipopesquisa = oriInTipopesquisa;
    }

    public Character getOriChObrigadatanasc() {
        return oriChObrigadatanasc;
    }

    public void setOriChObrigadatanasc(Character oriChObrigadatanasc) {
        this.oriChObrigadatanasc = oriChObrigadatanasc;
    }

    public BigInteger getAloInCodigo() {
        return aloInCodigo;
    }

    public void setAloInCodigo(BigInteger aloInCodigo) {
        this.aloInCodigo = aloInCodigo;
    }

    public Character getOriChSenhaobrigatoria() {
        return oriChSenhaobrigatoria;
    }

    public void setOriChSenhaobrigatoria(Character oriChSenhaobrigatoria) {
        this.oriChSenhaobrigatoria = oriChSenhaobrigatoria;
    }

    public Character getOriChLocalentregaetiqueta() {
        return oriChLocalentregaetiqueta;
    }

    public void setOriChLocalentregaetiqueta(Character oriChLocalentregaetiqueta) {
        this.oriChLocalentregaetiqueta = oriChLocalentregaetiqueta;
    }

    public Character getOriChObrigasolicitante() {
        return oriChObrigasolicitante;
    }

    public void setOriChObrigasolicitante(Character oriChObrigasolicitante) {
        this.oriChObrigasolicitante = oriChObrigasolicitante;
    }

    public String getOriStColetorpadrao() {
        return oriStColetorpadrao;
    }

    public void setOriStColetorpadrao(String oriStColetorpadrao) {
        this.oriStColetorpadrao = oriStColetorpadrao;
    }

    public Date getOriHrHoracoletapadrao() {
        return oriHrHoracoletapadrao;
    }

    public void setOriHrHoracoletapadrao(Date oriHrHoracoletapadrao) {
        this.oriHrHoracoletapadrao = oriHrHoracoletapadrao;
    }

    public String getOriStFantasia() {
        return oriStFantasia;
    }

    public void setOriStFantasia(String oriStFantasia) {
        this.oriStFantasia = oriStFantasia;
    }

    public Character getOriChObrigamedicamento() {
        return oriChObrigamedicamento;
    }

    public void setOriChObrigamedicamento(Character oriChObrigamedicamento) {
        this.oriChObrigamedicamento = oriChObrigamedicamento;
    }

    public Character getOriChAtivo() {
        return oriChAtivo;
    }

    public void setOriChAtivo(Character oriChAtivo) {
        this.oriChAtivo = oriChAtivo;
    }

    public Character getOriChSenhanocadastro() {
        return oriChSenhanocadastro;
    }

    public void setOriChSenhanocadastro(Character oriChSenhanocadastro) {
        this.oriChSenhanocadastro = oriChSenhanocadastro;
    }

    public Character getOriChObrigalocalentrega() {
        return oriChObrigalocalentrega;
    }

    public void setOriChObrigalocalentrega(Character oriChObrigalocalentrega) {
        this.oriChObrigalocalentrega = oriChObrigalocalentrega;
    }

    public Character getOriChCabecinternet() {
        return oriChCabecinternet;
    }

    public void setOriChCabecinternet(Character oriChCabecinternet) {
        this.oriChCabecinternet = oriChCabecinternet;
    }

    public Character getOriChRodapeinternet() {
        return oriChRodapeinternet;
    }

    public void setOriChRodapeinternet(Character oriChRodapeinternet) {
        this.oriChRodapeinternet = oriChRodapeinternet;
    }

    public String getOriStPaginaweb() {
        return oriStPaginaweb;
    }

    public void setOriStPaginaweb(String oriStPaginaweb) {
        this.oriStPaginaweb = oriStPaginaweb;
    }

    public ErpUnidade getErpUnidade() {
        return erpUnidade;
    }

    public void setErpUnidade(ErpUnidade erpUnidade) {
        this.erpUnidade = erpUnidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (erpOrigemPK != null ? erpOrigemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpOrigem)) {
            return false;
        }
        ErpOrigem other = (ErpOrigem) object;
        if ((this.erpOrigemPK == null && other.erpOrigemPK != null) || (this.erpOrigemPK != null && !this.erpOrigemPK.equals(other.erpOrigemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        XStream xstream = new XStream();
        return  xstream.toXML(this);
    }
    
}
