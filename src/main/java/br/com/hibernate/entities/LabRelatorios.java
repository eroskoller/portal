/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.entities;

import br.com.hibernate.utils.OracleHelper;
import br.com.utils.tipstricks.DateRange;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author eros
 */
@Entity
@Table(name="LAB_RELATORIOS")
//@SequenceGenerator(name="SEQ_REL_IN_CODIGO",sequenceName="SEQ_REL_IN_CODIGO")
public class LabRelatorios implements Serializable,Comparable{
    
    
    @Id
    @Column(name="REL_IN_CODIGO")
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_REL_IN_CODIGO")
//    @SequenceGenerator(name="SEQ_REL_IN_CODIGO",sequenceName="SEQ_REL_IN_CODIGO")
    private Long relInCodigo;
    
    @Column(name="REL_DT_CONSULTA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date relDtConsulta;
    
    @Column(name="REL_HR_CONSULTA")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date relHrConsulta;
    
    @Column(name="REL_DT_TERMINO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date relDtTermino;
    
    @Column(name="REL_HR_TERMINO")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date relHrTermino;
    
    @Column(name="REL_CH_STATUS")
    private Character relChStatus;
    
    @Column(name="REL_ST_XML")
    private String relStXml;

    @Column(name="USU_ST_CODIGO")
    private String usuStCodigo;
    
    @Column(name="REL_ST_PDFNOME")
    private String relStPdfNome;
    
    @Column(name="REL_CH_NEW")
    private Character relChNew = 'S';
    
    @Column(name="REL_ST_TYPE")
    private String relStType;
    
    @Column(name="REL_ST_TOOLTIP")
    private String relStToolTip;
    
    @Column(name="REL_ST_RESUMO")
    private String relStResumo;
    @Lob
    @Column(name="REL_CL_XML")
    private String relClXml;
    
    @Transient
    private String strDbName;
    
    
    
    @Transient
    private String strDisplayLinkStatus = "none";

    public LabRelatorios() {
    }

    public LabRelatorios(Long relInCodigo, Date relDtConsulta, Date relHrConsulta, Character relChStatus, String relStXml, String usuStCodigo, String relStPdfNome) {
        this.relInCodigo = relInCodigo;
        this.relDtConsulta = relDtConsulta;
        this.relHrConsulta = relHrConsulta;
        this.relChStatus = relChStatus;
        this.relStXml = relStXml;
        this.usuStCodigo = usuStCodigo;
        this.relStPdfNome = relStPdfNome;
    }
    
    public LabRelatorios(Long relInCodigo, Date relDtConsulta, Date relHrConsulta, Character relChStatus, String relStXml, String usuStCodigo, String relStPdfNome,String relStToolTip,String relStResumo) {
        this.relInCodigo = relInCodigo;
        this.relDtConsulta = relDtConsulta;
        this.relHrConsulta = relHrConsulta;
        this.relChStatus = relChStatus;
        this.relStXml = relStXml;
        this.usuStCodigo = usuStCodigo;
        this.relStPdfNome = relStPdfNome;
        this.relStToolTip = relStToolTip;
        this.relStResumo = relStResumo;
    }

    public LabRelatorios(LabRelatorios rOld,String usuStCodigo) {
        
        this.relDtConsulta = rOld.getRelDtConsulta();
        this.relHrConsulta = rOld.getRelHrConsulta();
        this.relChStatus = rOld.getRelChStatus();
        this.relStXml = rOld.getRelStXml();
        this.usuStCodigo = usuStCodigo;
        this.relStPdfNome = rOld.getRelStPdfNome();
    }

    public LabRelatorios(Long relInCodigo, Date relDtConsulta, Date relHrConsulta, Date relDtTermino, Date relHrTermino, Character relChStatus, String relStXml, String usuStCodigo, String relStPdfNome, Character relChNew) {
        this.relInCodigo = relInCodigo;
        this.relDtConsulta = relDtConsulta;
        this.relHrConsulta = relHrConsulta;
        this.relDtTermino = relDtTermino;
        this.relHrTermino = relHrTermino;
        this.relChStatus = relChStatus;
        this.relStXml = relStXml;
        this.usuStCodigo = usuStCodigo;
        this.relStPdfNome = relStPdfNome;
        this.relChNew = relChNew;
    }

    public LabRelatorios(Long relInCodigo, Date relDtConsulta, Date relHrConsulta, Date relDtTermino, Date relHrTermino, Character relChStatus, String relStXml, String usuStCodigo, String relStPdfNome, String relStType, String relStToolTip,String relStResumo) {
        this.relInCodigo = relInCodigo;
        this.relDtConsulta = relDtConsulta;
        this.relHrConsulta = relHrConsulta;
        this.relDtTermino = relDtTermino;
        this.relHrTermino = relHrTermino;
        this.relChStatus = relChStatus;
        this.relStXml = relStXml;
        this.usuStCodigo = usuStCodigo;
        this.relStPdfNome = relStPdfNome;
        this.relStType = relStType;
        this.relStToolTip = relStToolTip;
        this.relStResumo = relStResumo;
    }

    
    @Transient
    public String getStrDbName() {
        return strDbName;
    }

    public void setStrDbName(String strDbName) {
        this.strDbName = strDbName;
    }

    
    public String getRelStResumo() {
        return relStResumo;
    }

    public void setRelStResumo(String relStResumo) {
        this.relStResumo = relStResumo;
    }

    
    
    public String getRelStToolTip() {
        return relStToolTip;
    }

    public void setRelStToolTip(String relStToolTip) {
        this.relStToolTip = relStToolTip;
    }

    public String getRelStType() {
        return relStType;
    }

    public void setRelStType(String relStType) {
        this.relStType = relStType;
    }

    
    
    public Character getRelChNew() {
        return relChNew;
    }

    public void setRelChNew(Character relChNew) {
        this.relChNew = relChNew;
    }
    
    
    

    public String getStrDisplayLinkStatus() {
        if(this.getRelChStatus().toString().equalsIgnoreCase("D")){
            return "";
        }else{
            return "none";
        }
        
    }

    public void setStrDisplayLinkStatus(String strDisplayLinkStatus) {
        this.strDisplayLinkStatus = strDisplayLinkStatus;
    }
    
    
    
    
    

    public String getRelStPdfNome() {
        return relStPdfNome;
    }

    public void setRelStPdfNome(String relStPdfNome) {
        this.relStPdfNome = relStPdfNome;
    }

    public Character getRelChStatus() {
        return relChStatus;
    }

    public void setRelChStatus(Character relChStatus) {
        this.relChStatus = relChStatus;
    }

    public Date getRelDtConsulta() {
        return relDtConsulta;
    }

    public void setRelDtConsulta(Date relDtConsulta) {
        this.relDtConsulta = relDtConsulta;
    }

    public Date getRelDtTermino() {
        return relDtTermino;
    }

    public void setRelDtTermino(Date relDtTermino) {
        this.relDtTermino = relDtTermino;
    }

    public Date getRelHrConsulta() {
        return relHrConsulta;
    }

    public void setRelHrConsulta(Date relHrConsulta) {
        this.relHrConsulta = relHrConsulta;
    }

    public Date getRelHrTermino() {
        return relHrTermino;
    }

    public void setRelHrTermino(Date relHrTermino) {
        this.relHrTermino = relHrTermino;
    }

    public Long getRelInCodigo() {
        return relInCodigo;
    }

    public void setRelInCodigo(Long relInCodigo) {
        this.relInCodigo = relInCodigo;
    }

    public String getRelStXml() {
        return relStXml;
    }

    public void setRelStXml(String relStXml) {
        this.relStXml = relStXml;
    }

    public String getUsuStCodigo() {
        return usuStCodigo;
    }

    public void setUsuStCodigo(String usuStCodigo) {
        this.usuStCodigo = usuStCodigo;
    }

    public String getRelClXml() {
        return relClXml;
    }

    public void setRelClXml(String relClXml) {
        this.relClXml = relClXml;
    }
    
    
    
    @Transient
    public long getElapsedtime(){
        if(relDtConsulta != null && relDtTermino != null){
            return relHrTermino.getTime() -  relHrConsulta.getTime() ;
        }
        
        return 0;
    }
    
    

    @Transient
    public String getTempoGastor(){
        if(this.relHrConsulta != null && this.relHrTermino != null){
            return DateRange.elapsedTimeBtwDatesHours(this.relHrConsulta, this.relHrTermino)+" hrs "+DateRange.elapsedTimeBtwDatesMinutes(this.relHrConsulta, this.relHrTermino)
                    +" ms "+DateRange.elapsedTimeBtwDatesSeconds(this.relHrConsulta, this.relHrTermino)+" ss";
        }
        return "";
    }
            
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LabRelatorios other = (LabRelatorios) obj;
        if (this.relInCodigo != other.relInCodigo && (this.relInCodigo == null || !this.relInCodigo.equals(other.relInCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (this.relInCodigo != null ? this.relInCodigo.hashCode() : 0);
        return hash;
    }
    
    
    @Transient
    public Character getRelStatusFromDB(){
        if(this.relInCodigo != null){
            LabRelatorios r =(LabRelatorios) OracleHelper.getObject(LabRelatorios.class, this.relInCodigo,strDbName);
            if(r != null){
                return r.getRelChStatus();
            }
            
        }
        return 'L';
    }
    
    @Transient
    public String getRightIconByFormat(){
        
        
        if(this.relStPdfNome != null){
            
            String sFormat   = this.relStPdfNome.substring(this.relStPdfNome.length()-1, this.relStPdfNome.length());
            if(this.relChNew.toString().equalsIgnoreCase("s")){
                if(sFormat.equalsIgnoreCase("f")){
                return "pdf_icon.gif";
                }else{
                    return "icon_xls.gif";
                }
            }else{
                if(sFormat.equalsIgnoreCase("f")){
                return "pdf_icon_gray.gif";
                }else{
                    return "icon_xls_gray.gif";
                }
                
            }
            
        }else{
            return "pdf_icon.gif";
        }
        
    }
    
    
    public static final Comparator ID_COMPARATOR9To1 = new Comparator() {
            Long long1;
            Long long2 ;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
                long1 = ((LabRelatorios)relObject).getRelInCodigo();
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                long2 = ((LabRelatorios)anotherRelObjec).getRelInCodigo();
            }

            if(long1 != null && long2 != null){
                return long2.compareTo(long1);
            }else{
                return 0;
            }
        }
     };

   
    
    
    public static final Comparator NEW_COMPARATORATOR_A_Z = new Comparator() {
            Character c1;
            Character c2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
                c1 = ((LabRelatorios)relObject).getRelChNew();
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                c2 = ((LabRelatorios)anotherRelObjec).getRelChNew();
            }

            if(c1 != null && c2 != null){
                return c1.compareTo(c2);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator NEW_COMPARATORATOR_Z_A = new Comparator() {
            Character c1;
            Character c2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
                c1 = ((LabRelatorios)relObject).getRelChNew();
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                c2 = ((LabRelatorios)anotherRelObjec).getRelChNew();
            }

            if(c1 != null && c2 != null){
                return c2.compareTo(c1);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator STATUS_COMPARATORATOR_A_Z = new Comparator() {
            Character c1;
            Character c2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
                c1 = ((LabRelatorios)relObject).getRelChStatus();
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                c2 = ((LabRelatorios)anotherRelObjec).getRelChStatus();
            }

           if(c1 != null && c2 != null){
                return c1.compareTo(c2);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator STATUS_COMPARATORATOR_Z_A = new Comparator() {
            Character c1;
            Character c2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
                c1 = ((LabRelatorios)relObject).getRelChStatus();
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                c2 = ((LabRelatorios)anotherRelObjec).getRelChStatus();
            }

//            if(c1 == null)c1= 'A';
//            if(c2 == null)c2= 'z';
            
            if(c1 != null && c2 != null){
                return c2.compareTo(c1);
            }else{
                return 0;
            }
            
            
        }
     };
    
    public static final Comparator DATAPESQ_COMPARATOR_0_1 = new Comparator() {
            Date d1;
            Date d2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
                d1 = ((LabRelatorios)relObject).getRelHrConsulta();
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                d2 = ((LabRelatorios)anotherRelObjec).getRelHrConsulta();
            }

            if(d1 != null && d2 != null){
                return d1.compareTo(d2);
            }else{
                return 0;
            }
            
        }
     };
    
    public static final Comparator DATAPESQ_COMPARATOR_1_0 = new Comparator() {
            Date d1;
            Date d2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
                d1 = ((LabRelatorios)relObject).getRelHrConsulta();
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                d2 = ((LabRelatorios)anotherRelObjec).getRelHrConsulta();
            }

            
            if(d1 != null && d2 != null){
                return d2.compareTo(d1);
            }else{
                return 0;
            }
        }
     };
    
    
    
    
    
    public static final Comparator DATATERM_COMPARATOR_0_1 = new Comparator() {
            Date d1;
            Date d2;
         public int compare(Object relObject, Object anotherRelObjec) {

           if (relObject instanceof LabRelatorios) {
               if(((LabRelatorios)relObject).getRelHrTermino() != null){
                   d1 = ((LabRelatorios)relObject).getRelHrTermino();
               }else{
                   d1 = new Date();
               }
                
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                if(((LabRelatorios)anotherRelObjec).getRelHrTermino() != null){
                    d2 = ((LabRelatorios)anotherRelObjec).getRelHrTermino();
                }else{
                    d2 = new Date();
                }
                
            }

            if(d1 != null && d2 != null){
                return d1.compareTo(d2);
            }else{
                return 0;
            }
            
        }
     };
    
    public static final Comparator DATATERM_COMPARATOR_1_0 = new Comparator() {
            Date d1;
            Date d2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
               if(((LabRelatorios)relObject).getRelHrTermino() != null){
                   d1 = ((LabRelatorios)relObject).getRelHrTermino();
               }else{
                   d1 = new Date();
               }
                
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                if(((LabRelatorios)anotherRelObjec).getRelHrTermino() != null){
                    d2 = ((LabRelatorios)anotherRelObjec).getRelHrTermino();
                }else{
                    d2 = new Date();
                }
                
            }

            
            if(d1 != null && d2 != null){
                return d2.compareTo(d1);
            }else{
                return 0;
            }
        }
     };
    
    

    public static final Comparator PDFNAME_COMPARATORATOR_A_Z = new Comparator() {
            String s1;
            String s2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
                s1 = ((LabRelatorios)relObject).getRelStPdfNome();
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                s2 = ((LabRelatorios)anotherRelObjec).getRelStPdfNome();
            }

            if(s1 != null && s2 != null){
                return s1.compareTo(s2);
            }else{
                return 0;
            }
        }
     };
    
    public static final Comparator PDFNAME_COMPARATORATOR_Z_A = new Comparator() {
            String s1;
            String s2;
         public int compare(Object relObject, Object anotherRelObjec) {

            if (relObject instanceof LabRelatorios) {
                s1 = ((LabRelatorios)relObject).getRelStPdfNome();
            }

            if (anotherRelObjec instanceof LabRelatorios) {
                s2 = ((LabRelatorios)anotherRelObjec).getRelStPdfNome();
            }

            if(s1 != null && s2 != null){
                return s2.compareTo(s1);
            }else{
                return 0;
            }
        }
     };
    
    
    @Override
    public int compareTo(Object o) {
        Long l1 = 0l;
        Long l2 = 1l;
        
        if(this.relInCodigo != null){
            l1 = this.relInCodigo;
        }
        if (o instanceof LabRelatorios) {
                l2 = ((LabRelatorios)o).getRelInCodigo();
        }
        
            
            if(l1 != null && l2 != null){
                return l1.compareTo(l2);
            }else{
                return 0;
            }
        
    }
    
    
}
