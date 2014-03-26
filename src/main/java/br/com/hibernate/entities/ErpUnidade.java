/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eros
 */
@Entity
@Table(name = "ERP_UNIDADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ErpUnidade.findAll", query = "SELECT e FROM ErpUnidade e"),
    @NamedQuery(name = "ErpUnidade.findByUniStCodigo", query = "SELECT e FROM ErpUnidade e WHERE e.uniStCodigo = :uniStCodigo"),
    @NamedQuery(name = "ErpUnidade.findByUniStDescricao", query = "SELECT e FROM ErpUnidade e WHERE e.uniStDescricao = :uniStDescricao"),
    @NamedQuery(name = "ErpUnidade.findByUniChTelefone", query = "SELECT e FROM ErpUnidade e WHERE e.uniChTelefone = :uniChTelefone"),
    @NamedQuery(name = "ErpUnidade.findByUniStCaminhointerface", query = "SELECT e FROM ErpUnidade e WHERE e.uniStCaminhointerface = :uniStCaminhointerface"),
    @NamedQuery(name = "ErpUnidade.findByUniStSistema", query = "SELECT e FROM ErpUnidade e WHERE e.uniStSistema = :uniStSistema"),
    @NamedQuery(name = "ErpUnidade.findByUniStParametros", query = "SELECT e FROM ErpUnidade e WHERE e.uniStParametros = :uniStParametros"),
    @NamedQuery(name = "ErpUnidade.findByUniChAssinaunidadeex", query = "SELECT e FROM ErpUnidade e WHERE e.uniChAssinaunidadeex = :uniChAssinaunidadeex"),
    @NamedQuery(name = "ErpUnidade.findByUniStFraserodape", query = "SELECT e FROM ErpUnidade e WHERE e.uniStFraserodape = :uniStFraserodape"),
    @NamedQuery(name = "ErpUnidade.findByUniChSelecaofatura", query = "SELECT e FROM ErpUnidade e WHERE e.uniChSelecaofatura = :uniChSelecaofatura"),
    @NamedQuery(name = "ErpUnidade.findByPrjStCodigo", query = "SELECT e FROM ErpUnidade e WHERE e.prjStCodigo = :prjStCodigo"),
    @NamedQuery(name = "ErpUnidade.findByUniStEtiqueta1", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEtiqueta1 = :uniStEtiqueta1"),
    @NamedQuery(name = "ErpUnidade.findByUniStEtiqueta2", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEtiqueta2 = :uniStEtiqueta2"),
    @NamedQuery(name = "ErpUnidade.findByUniStEtiqueta3", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEtiqueta3 = :uniStEtiqueta3"),
    @NamedQuery(name = "ErpUnidade.findByUniStEtiqueta4", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEtiqueta4 = :uniStEtiqueta4"),
    @NamedQuery(name = "ErpUnidade.findByUniStEtiqueta5", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEtiqueta5 = :uniStEtiqueta5"),
    @NamedQuery(name = "ErpUnidade.findByUniStEtiqueta6", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEtiqueta6 = :uniStEtiqueta6"),
    @NamedQuery(name = "ErpUnidade.findByUniStEtiqueta7", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEtiqueta7 = :uniStEtiqueta7"),
    @NamedQuery(name = "ErpUnidade.findByUniStIpframe", query = "SELECT e FROM ErpUnidade e WHERE e.uniStIpframe = :uniStIpframe"),
    @NamedQuery(name = "ErpUnidade.findByUniStIpinternet", query = "SELECT e FROM ErpUnidade e WHERE e.uniStIpinternet = :uniStIpinternet"),
    @NamedQuery(name = "ErpUnidade.findByUniStIpinterface1", query = "SELECT e FROM ErpUnidade e WHERE e.uniStIpinterface1 = :uniStIpinterface1"),
    @NamedQuery(name = "ErpUnidade.findByUniStIpinterface2", query = "SELECT e FROM ErpUnidade e WHERE e.uniStIpinterface2 = :uniStIpinterface2"),
    @NamedQuery(name = "ErpUnidade.findByUniStIpinterface3", query = "SELECT e FROM ErpUnidade e WHERE e.uniStIpinterface3 = :uniStIpinterface3"),
    @NamedQuery(name = "ErpUnidade.findByUniStFoneframe", query = "SELECT e FROM ErpUnidade e WHERE e.uniStFoneframe = :uniStFoneframe"),
    @NamedQuery(name = "ErpUnidade.findByUniStFoneinternet", query = "SELECT e FROM ErpUnidade e WHERE e.uniStFoneinternet = :uniStFoneinternet"),
    @NamedQuery(name = "ErpUnidade.findByUniStLogininternet", query = "SELECT e FROM ErpUnidade e WHERE e.uniStLogininternet = :uniStLogininternet"),
    @NamedQuery(name = "ErpUnidade.findByUniStLoginmaquina", query = "SELECT e FROM ErpUnidade e WHERE e.uniStLoginmaquina = :uniStLoginmaquina"),
    @NamedQuery(name = "ErpUnidade.findByUniStLoginvnc", query = "SELECT e FROM ErpUnidade e WHERE e.uniStLoginvnc = :uniStLoginvnc"),
    @NamedQuery(name = "ErpUnidade.findByUniStSequenciaexterna", query = "SELECT e FROM ErpUnidade e WHERE e.uniStSequenciaexterna = :uniStSequenciaexterna"),
    @NamedQuery(name = "ErpUnidade.findByUniStNomeabreviado", query = "SELECT e FROM ErpUnidade e WHERE e.uniStNomeabreviado = :uniStNomeabreviado"),
    @NamedQuery(name = "ErpUnidade.findByUniStCgc", query = "SELECT e FROM ErpUnidade e WHERE e.uniStCgc = :uniStCgc"),
    @NamedQuery(name = "ErpUnidade.findByUniStEspeciepedido", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEspeciepedido = :uniStEspeciepedido"),
    @NamedQuery(name = "ErpUnidade.findByUniStNatoper", query = "SELECT e FROM ErpUnidade e WHERE e.uniStNatoper = :uniStNatoper"),
    @NamedQuery(name = "ErpUnidade.findByUniChUsasemente", query = "SELECT e FROM ErpUnidade e WHERE e.uniChUsasemente = :uniChUsasemente"),
    @NamedQuery(name = "ErpUnidade.findByUniInTracoetiqueta", query = "SELECT e FROM ErpUnidade e WHERE e.uniInTracoetiqueta = :uniInTracoetiqueta"),
    @NamedQuery(name = "ErpUnidade.findByUniChUsanrexterno", query = "SELECT e FROM ErpUnidade e WHERE e.uniChUsanrexterno = :uniChUsanrexterno"),
    @NamedQuery(name = "ErpUnidade.findByUniStCnes", query = "SELECT e FROM ErpUnidade e WHERE e.uniStCnes = :uniStCnes"),
    @NamedQuery(name = "ErpUnidade.findByUfStSigla", query = "SELECT e FROM ErpUnidade e WHERE e.ufStSigla = :ufStSigla"),
    @NamedQuery(name = "ErpUnidade.findByUniStCodigoass", query = "SELECT e FROM ErpUnidade e WHERE e.uniStCodigoass = :uniStCodigoass"),
    @NamedQuery(name = "ErpUnidade.findByUniStLogo", query = "SELECT e FROM ErpUnidade e WHERE e.uniStLogo = :uniStLogo"),
    @NamedQuery(name = "ErpUnidade.findByUniStEtiqueta8", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEtiqueta8 = :uniStEtiqueta8"),
    @NamedQuery(name = "ErpUnidade.findByUniChTriacontainer", query = "SELECT e FROM ErpUnidade e WHERE e.uniChTriacontainer = :uniChTriacontainer"),
    @NamedQuery(name = "ErpUnidade.findByUniChCodigobarra", query = "SELECT e FROM ErpUnidade e WHERE e.uniChCodigobarra = :uniChCodigobarra"),
    @NamedQuery(name = "ErpUnidade.findByUniChExecucaoexterna", query = "SELECT e FROM ErpUnidade e WHERE e.uniChExecucaoexterna = :uniChExecucaoexterna"),
    @NamedQuery(name = "ErpUnidade.findByUniInTipoestatistica", query = "SELECT e FROM ErpUnidade e WHERE e.uniInTipoestatistica = :uniInTipoestatistica"),
    @NamedQuery(name = "ErpUnidade.findByUniDtDataestatistica", query = "SELECT e FROM ErpUnidade e WHERE e.uniDtDataestatistica = :uniDtDataestatistica"),
    @NamedQuery(name = "ErpUnidade.findByUniInDiasemana", query = "SELECT e FROM ErpUnidade e WHERE e.uniInDiasemana = :uniInDiasemana"),
    @NamedQuery(name = "ErpUnidade.findByUniStCnpj", query = "SELECT e FROM ErpUnidade e WHERE e.uniStCnpj = :uniStCnpj"),
    @NamedQuery(name = "ErpUnidade.findByUniStRazaosocial", query = "SELECT e FROM ErpUnidade e WHERE e.uniStRazaosocial = :uniStRazaosocial"),
    @NamedQuery(name = "ErpUnidade.findByUniStEndereco", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEndereco = :uniStEndereco"),
    @NamedQuery(name = "ErpUnidade.findByUniStMunicipio", query = "SELECT e FROM ErpUnidade e WHERE e.uniStMunicipio = :uniStMunicipio"),
    @NamedQuery(name = "ErpUnidade.findByUniStEstado", query = "SELECT e FROM ErpUnidade e WHERE e.uniStEstado = :uniStEstado"),
    @NamedQuery(name = "ErpUnidade.findByUniStCep", query = "SELECT e FROM ErpUnidade e WHERE e.uniStCep = :uniStCep"),
    @NamedQuery(name = "ErpUnidade.findByUniStCodigonaoperadora", query = "SELECT e FROM ErpUnidade e WHERE e.uniStCodigonaoperadora = :uniStCodigonaoperadora"),
    @NamedQuery(name = "ErpUnidade.findByUniInRecibo", query = "SELECT e FROM ErpUnidade e WHERE e.uniInRecibo = :uniInRecibo"),
    @NamedQuery(name = "ErpUnidade.findByRgiStCodigo", query = "SELECT e FROM ErpUnidade e WHERE e.rgiStCodigo = :rgiStCodigo"),
    @NamedQuery(name = "ErpUnidade.findByUniChAtivo", query = "SELECT e FROM ErpUnidade e WHERE e.uniChAtivo = :uniChAtivo"),
//    @NamedQuery(name = "ErpUnidade.findByUniDtLastupdate", query = "SELECT e FROM ErpUnidade e WHERE e.uniDtLastupdate = :uniDtLastupdate"),
//    @NamedQuery(name = "ErpUnidade.findByUniStTravarhivbandejamento", query = "SELECT e FROM ErpUnidade e WHERE e.uniStTravarhivbandejamento = :uniStTravarhivbandejamento"),
//    @NamedQuery(name = "ErpUnidade.findByUniChRecebedevematerial", query = "SELECT e FROM ErpUnidade e WHERE e.uniChRecebedevematerial = :uniChRecebedevematerial"),
//    @NamedQuery(name = "ErpUnidade.findByUniChBloqueiaingressomanual", query = "SELECT e FROM ErpUnidade e WHERE e.uniChBloqueiaingressomanual = :uniChBloqueiaingressomanual")
})
public class ErpUnidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "UNI_ST_CODIGO")
    private String uniStCodigo;
    @Size(max = 50)
    @Column(name = "UNI_ST_DESCRICAO")
    private String uniStDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UNI_CH_TELEFONE")
    private char uniChTelefone;
    @Size(max = 200)
    @Column(name = "UNI_ST_CAMINHOINTERFACE")
    private String uniStCaminhointerface;
    @Size(max = 10)
    @Column(name = "UNI_ST_SISTEMA")
    private String uniStSistema;
    @Size(max = 1000)
    @Column(name = "UNI_ST_PARAMETROS")
    private String uniStParametros;
    @Column(name = "UNI_CH_ASSINAUNIDADEEX")
    private Character uniChAssinaunidadeex;
    @Size(max = 1000)
    @Column(name = "UNI_ST_FRASERODAPE")
    private String uniStFraserodape;
    @Column(name = "UNI_CH_SELECAOFATURA")
    private Character uniChSelecaofatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRJ_ST_CODIGO")
    private String prjStCodigo;
    @Size(max = 50)
    @Column(name = "UNI_ST_ETIQUETA1")
    private String uniStEtiqueta1;
    @Size(max = 50)
    @Column(name = "UNI_ST_ETIQUETA2")
    private String uniStEtiqueta2;
    @Size(max = 50)
    @Column(name = "UNI_ST_ETIQUETA3")
    private String uniStEtiqueta3;
    @Size(max = 50)
    @Column(name = "UNI_ST_ETIQUETA4")
    private String uniStEtiqueta4;
    @Size(max = 50)
    @Column(name = "UNI_ST_ETIQUETA5")
    private String uniStEtiqueta5;
    @Size(max = 50)
    @Column(name = "UNI_ST_ETIQUETA6")
    private String uniStEtiqueta6;
    @Size(max = 50)
    @Column(name = "UNI_ST_ETIQUETA7")
    private String uniStEtiqueta7;
    @Size(max = 50)
    @Column(name = "UNI_ST_IPFRAME")
    private String uniStIpframe;
    @Size(max = 50)
    @Column(name = "UNI_ST_IPINTERNET")
    private String uniStIpinternet;
    @Size(max = 50)
    @Column(name = "UNI_ST_IPINTERFACE1")
    private String uniStIpinterface1;
    @Size(max = 50)
    @Column(name = "UNI_ST_IPINTERFACE2")
    private String uniStIpinterface2;
    @Size(max = 50)
    @Column(name = "UNI_ST_IPINTERFACE3")
    private String uniStIpinterface3;
    @Size(max = 50)
    @Column(name = "UNI_ST_FONEFRAME")
    private String uniStFoneframe;
    @Size(max = 50)
    @Column(name = "UNI_ST_FONEINTERNET")
    private String uniStFoneinternet;
    @Size(max = 50)
    @Column(name = "UNI_ST_LOGININTERNET")
    private String uniStLogininternet;
    @Size(max = 50)
    @Column(name = "UNI_ST_LOGINMAQUINA")
    private String uniStLoginmaquina;
    @Size(max = 50)
    @Column(name = "UNI_ST_LOGINVNC")
    private String uniStLoginvnc;
    @Lob
    @Column(name = "UNI_CL_OBSINFORMATICA")
    private String uniClObsinformatica;
    @Size(max = 10)
    @Column(name = "UNI_ST_SEQUENCIAEXTERNA")
    private String uniStSequenciaexterna;
    @Size(max = 12)
    @Column(name = "UNI_ST_NOMEABREVIADO")
    private String uniStNomeabreviado;
    @Size(max = 19)
    @Column(name = "UNI_ST_CGC")
    private String uniStCgc;
    @Size(max = 2)
    @Column(name = "UNI_ST_ESPECIEPEDIDO")
    private String uniStEspeciepedido;
    @Size(max = 6)
    @Column(name = "UNI_ST_NATOPER")
    private String uniStNatoper;
    @Column(name = "UNI_CH_USASEMENTE")
    private Character uniChUsasemente;
    @Column(name = "UNI_IN_TRACOETIQUETA")
    private BigInteger uniInTracoetiqueta;
    @Column(name = "UNI_CH_USANREXTERNO")
    private Character uniChUsanrexterno;
    @Size(max = 20)
    @Column(name = "UNI_ST_CNES")
    private String uniStCnes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "UF_ST_SIGLA")
    private String ufStSigla;
    @Size(max = 3)
    @Column(name = "UNI_ST_CODIGOASS")
    private String uniStCodigoass;
    @Size(max = 20)
    @Column(name = "UNI_ST_LOGO")
    private String uniStLogo;
    @Size(max = 50)
    @Column(name = "UNI_ST_ETIQUETA8")
    private String uniStEtiqueta8;
    @Column(name = "UNI_CH_TRIACONTAINER")
    private Character uniChTriacontainer;
    @Column(name = "UNI_CH_CODIGOBARRA")
    private BigInteger uniChCodigobarra;
    @Column(name = "UNI_CH_EXECUCAOEXTERNA")
    private Character uniChExecucaoexterna;
    @Column(name = "UNI_IN_TIPOESTATISTICA")
    private BigInteger uniInTipoestatistica;
    @Column(name = "UNI_DT_DATAESTATISTICA")
    @Temporal(TemporalType.DATE)
    private Date uniDtDataestatistica;
    @Column(name = "UNI_IN_DIASEMANA")
    private BigInteger uniInDiasemana;
    @Size(max = 14)
    @Column(name = "UNI_ST_CNPJ")
    private String uniStCnpj;
    @Size(max = 70)
    @Column(name = "UNI_ST_RAZAOSOCIAL")
    private String uniStRazaosocial;
    @Size(max = 100)
    @Column(name = "UNI_ST_ENDERECO")
    private String uniStEndereco;
    @Size(max = 40)
    @Column(name = "UNI_ST_MUNICIPIO")
    private String uniStMunicipio;
    @Size(max = 2)
    @Column(name = "UNI_ST_ESTADO")
    private String uniStEstado;
    @Size(max = 8)
    @Column(name = "UNI_ST_CEP")
    private String uniStCep;
    @Size(max = 10)
    @Column(name = "UNI_ST_CODIGONAOPERADORA")
    private String uniStCodigonaoperadora;
    @Column(name = "UNI_IN_RECIBO")
    private BigInteger uniInRecibo;
    @Size(max = 5)
    @Column(name = "RGI_ST_CODIGO")
    private String rgiStCodigo;
    @Column(name = "UNI_CH_ATIVO")
    private Character uniChAtivo;
//    @Column(name = "UNI_DT_LASTUPDATE")
//    @Temporal(TemporalType.DATE)
//    private Date uniDtLastupdate;
//    @Column(name = "UNI_ST_TRAVARHIVBANDEJAMENTO")
//    private Character uniStTravarhivbandejamento;
//    @Column(name = "UNI_CH_RECEBEDEVEMATERIAL")
//    private Character uniChRecebedevematerial;
//    @Column(name = "UNI_CH_BLOQUEIAINGRESSOMANUAL")
//    private Character uniChBloqueiaingressomanual;
    @JoinTable(name = "ERP_USUARIOUNIDADE", joinColumns = {
        @JoinColumn(name = "UNI_ST_CODIGO", referencedColumnName = "UNI_ST_CODIGO")}, inverseJoinColumns = {
        @JoinColumn(name = "USU_ST_CODIGO", referencedColumnName = "USU_ST_CODIGO")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<LabUsuario> labUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "erpUnidade", fetch = FetchType.LAZY)
    private List<ErpOrigem> erpOrigemList;

    public ErpUnidade() {
    }

    public ErpUnidade(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public ErpUnidade(String uniStCodigo, String uniStDescricao) {
        this.uniStCodigo = uniStCodigo;
        this.uniStDescricao = uniStDescricao;
    }

    
    public ErpUnidade(String uniStCodigo, char uniChTelefone, String prjStCodigo, String ufStSigla) {
        this.uniStCodigo = uniStCodigo;
        this.uniChTelefone = uniChTelefone;
        this.prjStCodigo = prjStCodigo;
        this.ufStSigla = ufStSigla;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    public String getUniStDescricao() {
        return uniStDescricao;
    }

    public void setUniStDescricao(String uniStDescricao) {
        this.uniStDescricao = uniStDescricao;
    }

    public char getUniChTelefone() {
        return uniChTelefone;
    }

    public void setUniChTelefone(char uniChTelefone) {
        this.uniChTelefone = uniChTelefone;
    }

    public String getUniStCaminhointerface() {
        return uniStCaminhointerface;
    }

    public void setUniStCaminhointerface(String uniStCaminhointerface) {
        this.uniStCaminhointerface = uniStCaminhointerface;
    }

    public String getUniStSistema() {
        return uniStSistema;
    }

    public void setUniStSistema(String uniStSistema) {
        this.uniStSistema = uniStSistema;
    }

    public String getUniStParametros() {
        return uniStParametros;
    }

    public void setUniStParametros(String uniStParametros) {
        this.uniStParametros = uniStParametros;
    }

    public Character getUniChAssinaunidadeex() {
        return uniChAssinaunidadeex;
    }

    public void setUniChAssinaunidadeex(Character uniChAssinaunidadeex) {
        this.uniChAssinaunidadeex = uniChAssinaunidadeex;
    }

    public String getUniStFraserodape() {
        return uniStFraserodape;
    }

    public void setUniStFraserodape(String uniStFraserodape) {
        this.uniStFraserodape = uniStFraserodape;
    }

    public Character getUniChSelecaofatura() {
        return uniChSelecaofatura;
    }

    public void setUniChSelecaofatura(Character uniChSelecaofatura) {
        this.uniChSelecaofatura = uniChSelecaofatura;
    }

    public String getPrjStCodigo() {
        return prjStCodigo;
    }

    public void setPrjStCodigo(String prjStCodigo) {
        this.prjStCodigo = prjStCodigo;
    }

    public String getUniStEtiqueta1() {
        return uniStEtiqueta1;
    }

    public void setUniStEtiqueta1(String uniStEtiqueta1) {
        this.uniStEtiqueta1 = uniStEtiqueta1;
    }

    public String getUniStEtiqueta2() {
        return uniStEtiqueta2;
    }

    public void setUniStEtiqueta2(String uniStEtiqueta2) {
        this.uniStEtiqueta2 = uniStEtiqueta2;
    }

    public String getUniStEtiqueta3() {
        return uniStEtiqueta3;
    }

    public void setUniStEtiqueta3(String uniStEtiqueta3) {
        this.uniStEtiqueta3 = uniStEtiqueta3;
    }

    public String getUniStEtiqueta4() {
        return uniStEtiqueta4;
    }

    public void setUniStEtiqueta4(String uniStEtiqueta4) {
        this.uniStEtiqueta4 = uniStEtiqueta4;
    }

    public String getUniStEtiqueta5() {
        return uniStEtiqueta5;
    }

    public void setUniStEtiqueta5(String uniStEtiqueta5) {
        this.uniStEtiqueta5 = uniStEtiqueta5;
    }

    public String getUniStEtiqueta6() {
        return uniStEtiqueta6;
    }

    public void setUniStEtiqueta6(String uniStEtiqueta6) {
        this.uniStEtiqueta6 = uniStEtiqueta6;
    }

    public String getUniStEtiqueta7() {
        return uniStEtiqueta7;
    }

    public void setUniStEtiqueta7(String uniStEtiqueta7) {
        this.uniStEtiqueta7 = uniStEtiqueta7;
    }

    public String getUniStIpframe() {
        return uniStIpframe;
    }

    public void setUniStIpframe(String uniStIpframe) {
        this.uniStIpframe = uniStIpframe;
    }

    public String getUniStIpinternet() {
        return uniStIpinternet;
    }

    public void setUniStIpinternet(String uniStIpinternet) {
        this.uniStIpinternet = uniStIpinternet;
    }

    public String getUniStIpinterface1() {
        return uniStIpinterface1;
    }

    public void setUniStIpinterface1(String uniStIpinterface1) {
        this.uniStIpinterface1 = uniStIpinterface1;
    }

    public String getUniStIpinterface2() {
        return uniStIpinterface2;
    }

    public void setUniStIpinterface2(String uniStIpinterface2) {
        this.uniStIpinterface2 = uniStIpinterface2;
    }

    public String getUniStIpinterface3() {
        return uniStIpinterface3;
    }

    public void setUniStIpinterface3(String uniStIpinterface3) {
        this.uniStIpinterface3 = uniStIpinterface3;
    }

    public String getUniStFoneframe() {
        return uniStFoneframe;
    }

    public void setUniStFoneframe(String uniStFoneframe) {
        this.uniStFoneframe = uniStFoneframe;
    }

    public String getUniStFoneinternet() {
        return uniStFoneinternet;
    }

    public void setUniStFoneinternet(String uniStFoneinternet) {
        this.uniStFoneinternet = uniStFoneinternet;
    }

    public String getUniStLogininternet() {
        return uniStLogininternet;
    }

    public void setUniStLogininternet(String uniStLogininternet) {
        this.uniStLogininternet = uniStLogininternet;
    }

    public String getUniStLoginmaquina() {
        return uniStLoginmaquina;
    }

    public void setUniStLoginmaquina(String uniStLoginmaquina) {
        this.uniStLoginmaquina = uniStLoginmaquina;
    }

    public String getUniStLoginvnc() {
        return uniStLoginvnc;
    }

    public void setUniStLoginvnc(String uniStLoginvnc) {
        this.uniStLoginvnc = uniStLoginvnc;
    }

    public String getUniClObsinformatica() {
        return uniClObsinformatica;
    }

    public void setUniClObsinformatica(String uniClObsinformatica) {
        this.uniClObsinformatica = uniClObsinformatica;
    }

    public String getUniStSequenciaexterna() {
        return uniStSequenciaexterna;
    }

    public void setUniStSequenciaexterna(String uniStSequenciaexterna) {
        this.uniStSequenciaexterna = uniStSequenciaexterna;
    }

    public String getUniStNomeabreviado() {
        return uniStNomeabreviado;
    }

    public void setUniStNomeabreviado(String uniStNomeabreviado) {
        this.uniStNomeabreviado = uniStNomeabreviado;
    }

    public String getUniStCgc() {
        return uniStCgc;
    }

    public void setUniStCgc(String uniStCgc) {
        this.uniStCgc = uniStCgc;
    }

    public String getUniStEspeciepedido() {
        return uniStEspeciepedido;
    }

    public void setUniStEspeciepedido(String uniStEspeciepedido) {
        this.uniStEspeciepedido = uniStEspeciepedido;
    }

    public String getUniStNatoper() {
        return uniStNatoper;
    }

    public void setUniStNatoper(String uniStNatoper) {
        this.uniStNatoper = uniStNatoper;
    }

    public Character getUniChUsasemente() {
        return uniChUsasemente;
    }

    public void setUniChUsasemente(Character uniChUsasemente) {
        this.uniChUsasemente = uniChUsasemente;
    }

    public BigInteger getUniInTracoetiqueta() {
        return uniInTracoetiqueta;
    }

    public void setUniInTracoetiqueta(BigInteger uniInTracoetiqueta) {
        this.uniInTracoetiqueta = uniInTracoetiqueta;
    }

    public Character getUniChUsanrexterno() {
        return uniChUsanrexterno;
    }

    public void setUniChUsanrexterno(Character uniChUsanrexterno) {
        this.uniChUsanrexterno = uniChUsanrexterno;
    }

    public String getUniStCnes() {
        return uniStCnes;
    }

    public void setUniStCnes(String uniStCnes) {
        this.uniStCnes = uniStCnes;
    }

    public String getUfStSigla() {
        return ufStSigla;
    }

    public void setUfStSigla(String ufStSigla) {
        this.ufStSigla = ufStSigla;
    }

    public String getUniStCodigoass() {
        return uniStCodigoass;
    }

    public void setUniStCodigoass(String uniStCodigoass) {
        this.uniStCodigoass = uniStCodigoass;
    }

    public String getUniStLogo() {
        return uniStLogo;
    }

    public void setUniStLogo(String uniStLogo) {
        this.uniStLogo = uniStLogo;
    }

    public String getUniStEtiqueta8() {
        return uniStEtiqueta8;
    }

    public void setUniStEtiqueta8(String uniStEtiqueta8) {
        this.uniStEtiqueta8 = uniStEtiqueta8;
    }

    public Character getUniChTriacontainer() {
        return uniChTriacontainer;
    }

    public void setUniChTriacontainer(Character uniChTriacontainer) {
        this.uniChTriacontainer = uniChTriacontainer;
    }

    public BigInteger getUniChCodigobarra() {
        return uniChCodigobarra;
    }

    public void setUniChCodigobarra(BigInteger uniChCodigobarra) {
        this.uniChCodigobarra = uniChCodigobarra;
    }

    public Character getUniChExecucaoexterna() {
        return uniChExecucaoexterna;
    }

    public void setUniChExecucaoexterna(Character uniChExecucaoexterna) {
        this.uniChExecucaoexterna = uniChExecucaoexterna;
    }

    public BigInteger getUniInTipoestatistica() {
        return uniInTipoestatistica;
    }

    public void setUniInTipoestatistica(BigInteger uniInTipoestatistica) {
        this.uniInTipoestatistica = uniInTipoestatistica;
    }

    public Date getUniDtDataestatistica() {
        return uniDtDataestatistica;
    }

    public void setUniDtDataestatistica(Date uniDtDataestatistica) {
        this.uniDtDataestatistica = uniDtDataestatistica;
    }

    public BigInteger getUniInDiasemana() {
        return uniInDiasemana;
    }

    public void setUniInDiasemana(BigInteger uniInDiasemana) {
        this.uniInDiasemana = uniInDiasemana;
    }

    public String getUniStCnpj() {
        return uniStCnpj;
    }

    public void setUniStCnpj(String uniStCnpj) {
        this.uniStCnpj = uniStCnpj;
    }

    public String getUniStRazaosocial() {
        return uniStRazaosocial;
    }

    public void setUniStRazaosocial(String uniStRazaosocial) {
        this.uniStRazaosocial = uniStRazaosocial;
    }

    public String getUniStEndereco() {
        return uniStEndereco;
    }

    public void setUniStEndereco(String uniStEndereco) {
        this.uniStEndereco = uniStEndereco;
    }

    public String getUniStMunicipio() {
        return uniStMunicipio;
    }

    public void setUniStMunicipio(String uniStMunicipio) {
        this.uniStMunicipio = uniStMunicipio;
    }

    public String getUniStEstado() {
        return uniStEstado;
    }

    public void setUniStEstado(String uniStEstado) {
        this.uniStEstado = uniStEstado;
    }

    public String getUniStCep() {
        return uniStCep;
    }

    public void setUniStCep(String uniStCep) {
        this.uniStCep = uniStCep;
    }

    public String getUniStCodigonaoperadora() {
        return uniStCodigonaoperadora;
    }

    public void setUniStCodigonaoperadora(String uniStCodigonaoperadora) {
        this.uniStCodigonaoperadora = uniStCodigonaoperadora;
    }

    public BigInteger getUniInRecibo() {
        return uniInRecibo;
    }

    public void setUniInRecibo(BigInteger uniInRecibo) {
        this.uniInRecibo = uniInRecibo;
    }

    public String getRgiStCodigo() {
        return rgiStCodigo;
    }

    public void setRgiStCodigo(String rgiStCodigo) {
        this.rgiStCodigo = rgiStCodigo;
    }

    public Character getUniChAtivo() {
        return uniChAtivo;
    }

    public void setUniChAtivo(Character uniChAtivo) {
        this.uniChAtivo = uniChAtivo;
    }
    
//    public Character getUniChRecebedevematerial() {
//        return uniChRecebedevematerial;
//    }
//
//    public void setUniChRecebedevematerial(Character uniChRecebedevematerial) {
//        this.uniChRecebedevematerial = uniChRecebedevematerial;
//    }

//    public Character getUniChBloqueiaingressomanual() {
//        return uniChBloqueiaingressomanual;
//    }
//
//    public void setUniChBloqueiaingressomanual(Character uniChBloqueiaingressomanual) {
//        this.uniChBloqueiaingressomanual = uniChBloqueiaingressomanual;
//    }

    @XmlTransient
    public List<LabUsuario> getLabUsuarioList() {
        return labUsuarioList;
    }

    public void setLabUsuarioList(List<LabUsuario> labUsuarioList) {
        this.labUsuarioList = labUsuarioList;
    }

    @XmlTransient
    public List<ErpOrigem> getErpOrigemList() {
        return erpOrigemList;
    }

    public void setErpOrigemList(List<ErpOrigem> erpOrigemList) {
        this.erpOrigemList = erpOrigemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uniStCodigo != null ? uniStCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpUnidade)) {
            return false;
        }
        ErpUnidade other = (ErpUnidade) object;
        if ((this.uniStCodigo == null && other.uniStCodigo != null) || (this.uniStCodigo != null && !this.uniStCodigo.equals(other.uniStCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.hibernate.entities.ErpUnidade[ uniStCodigo=" + uniStCodigo + " ]";
    }
    
}
