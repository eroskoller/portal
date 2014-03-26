/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.monitor.faturamento;

import br.com.facesbeans.shared.ArrayItems;
import br.com.hibernate.entities.LabUnidade;
import br.com.hibernate.utils.OracleHelper;
import br.com.utils.tipstricks.DateRange;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eros
 */

class UniData{
    private String uniStCodigo;
    private String strDataFormated;

    public UniData(String uniStCodigo, String strDataFormated) {
        this.uniStCodigo = uniStCodigo;
        this.strDataFormated = strDataFormated;
    }

    
    
    public String getStrDataFormated() {
        return strDataFormated;
    }

    public void setStrDataFormated(String strDataFormated) {
        this.strDataFormated = strDataFormated;
    }

    public String getUniStCodigo() {
        return uniStCodigo;
    }

    public void setUniStCodigo(String uniStCodigo) {
        this.uniStCodigo = uniStCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UniData other = (UniData) obj;
        if ((this.uniStCodigo == null) ? (other.uniStCodigo != null) : !this.uniStCodigo.equals(other.uniStCodigo)) {
            return false;
        }
        if ((this.strDataFormated == null) ? (other.strDataFormated != null) : !this.strDataFormated.equals(other.strDataFormated)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.uniStCodigo != null ? this.uniStCodigo.hashCode() : 0);
        hash = 53 * hash + (this.strDataFormated != null ? this.strDataFormated.hashCode() : 0);
        return hash;
    }
    
}












public class MonitorDeFaturamentoByMaxDaysDao implements Serializable{
    
    
    private  static  Date[] dateShift(int intChoice, Date dtBase){
        
        Date[] arrayDate = new Date[2];
        switch(intChoice){
            
                case 0: 
                   arrayDate[0] = DateRange.shiftDayto00hrs(new Date(dtBase.getTime()));
                   arrayDate[1] = DateRange.shiftDayto24hrs(new Date(dtBase.getTime()));
                break;
                
                case 1: 
                    
                    
                    
                    
                    Calendar cal1 = Calendar.getInstance();
                    cal1.setTime(dtBase);
                    cal1.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(dtBase);
                    cal2.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                    arrayDate[0] = DateRange.shiftDayto00hrs(cal1.getTime());
                    arrayDate[1] = DateRange.shiftDayto24hrs(cal2.getTime());
                break;
                    
                case 2: 
                    
                    Calendar cal1Month = Calendar.getInstance();
                    cal1Month.setTime(dtBase);
                    cal1Month.set(Calendar.DAY_OF_MONTH, 1);
                    Calendar cal2Month = Calendar.getInstance();
                    cal2Month.setTime(dtBase);
                    int max = cal2Month.getActualMaximum(Calendar.DAY_OF_MONTH);
                    cal2Month.set(Calendar.DAY_OF_MONTH, max);
                    arrayDate[0] = DateRange.shiftDayto00hrs(cal1Month.getTime());
                    arrayDate[1] = DateRange.shiftDayto24hrs(cal2Month.getTime());
                    
                break;
                    
                case 3: 
                    
                    Calendar cal1Quarter = Calendar.getInstance();
                    cal1Quarter.setTime(dtBase);
                    cal1Quarter.set(Calendar.DAY_OF_MONTH, 1);
                    cal1Quarter.add(Calendar.MONTH, -1);
                    
                    Calendar cal2Quarter = Calendar.getInstance();
                    cal2Quarter.setTime(dtBase);
                    cal2Quarter.add(Calendar.MONTH, 1);
                    int maxQuarter = cal2Quarter.getActualMaximum(Calendar.DAY_OF_MONTH);
                    cal2Quarter.set(Calendar.DAY_OF_MONTH, maxQuarter);
                    
                    arrayDate[0] = DateRange.shiftDayto00hrs(cal1Quarter.getTime());
                    arrayDate[1] = DateRange.shiftDayto24hrs(cal2Quarter.getTime());
                    
                break;
                    
                    case 4: 
                    
                    
                    Calendar cal1Semester = Calendar.getInstance();
                    cal1Semester.setTime(dtBase);
                    cal1Semester.set(Calendar.DAY_OF_MONTH, 1);
                    cal1Semester.add(Calendar.MONTH, -5);
                    
                    Calendar cal2Semester = Calendar.getInstance();
                    cal2Semester.setTime(dtBase);
                    int maxSemester = cal2Semester.getActualMaximum(Calendar.DAY_OF_MONTH);
                    cal2Semester.set(Calendar.DAY_OF_MONTH, maxSemester);
                    
                    arrayDate[0] = DateRange.shiftDayto00hrs(cal1Semester.getTime());
                    arrayDate[1] = DateRange.shiftDayto24hrs(cal2Semester.getTime());
                    
                break;
                        
                        
                case 5: 
                    
                    
                    GregorianCalendar gcYearBase =  new GregorianCalendar();
                    gcYearBase.setTime(dtBase);
                            
                    GregorianCalendar gc1Year = null;
                    GregorianCalendar gc2Year = null;
                  
                        gc1Year = new GregorianCalendar(1900+dtBase.getYear(), 0, 1);
                        gc2Year = new GregorianCalendar(1900+dtBase.getYear(), 11, 30);
                        int maxYear = gc2Year.getActualMaximum(Calendar.DAY_OF_MONTH);
                        gc2Year.set(Calendar.DAY_OF_MONTH, maxYear);
                    arrayDate[0] = DateRange.shiftDayto00hrs(gc1Year.getTime());
                    arrayDate[1] = DateRange.shiftDayto24hrs(gc2Year.getTime());
                    
                break;
                    
                    
               default:
                 arrayDate[0] = DateRange.shiftDayto00hrs(new Date(dtBase.getTime()));
                 arrayDate[1] = DateRange.shiftDayto24hrs(new Date(dtBase.getTime()));
               break;
                        
                
       }
        return arrayDate;
    }
    
    
    private static SimpleDateFormat grabFormatByChoice(int intChoice) {
        SimpleDateFormat retorno = null;
        switch (intChoice) {
            case 0://Search 1d
                retorno =  ArrayItems.formatOnlyHrs;
            break;
            case 1://Search 1w
                retorno =  ArrayItems.format;
                break;
            case 2://Search 1m
                retorno =  ArrayItems.format;
                break;
            case 3://Search 3m
                retorno =  ArrayItems.formatOnlyWeekMonthAndYear;  
//                retorno = new SimpleDateFormat("W/MM/yyyy");
                break;
            case 4://Search 6m
                retorno =  ArrayItems.formatOnlyMonthAndYear;
                break;
            case 5://Search 1a
                retorno =  ArrayItems.formatOnlyMonthAndYear;
                break;
        }
        return retorno;
    }
    
     private static String sqlHelper_TO_CHAR(int intChoice) {
          String retorno = "";
          
        switch (intChoice) {
            
            case 0:
                retorno = "to_char(req.reqHrCadastro, 'HH24') "; 
            break;
                
            case 1:
                retorno = "TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') ";
            break;
                
            case 2:
                retorno = "TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') ";
            break;
                
            case 3:
                retorno = "TO_CHAR(req.reqDtCadastro,'w/') ||TO_CHAR(req.reqDtCadastro,'MM/YYYY') ";
            break;
                
            case 4:
                retorno = "TO_CHAR(req.reqDtCadastro,'MM/YYYY') ";
            break;
                
             case 5:
                retorno = "TO_CHAR(req.reqDtCadastro,'MM/YYYY') ";
            break;   
                
            default:
                retorno = "TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') ";
            break;
        }
        return retorno;
    }
     
       private static Calendar calendarStepForwardByChoice(Calendar cal, int intChoice) {
        switch (intChoice) {
            
            case 0:
                cal.add(Calendar.HOUR_OF_DAY, 1);
            break;
                
            case 1:
                cal.add(Calendar.DAY_OF_WEEK, 1);
            break;
                
            case 2:
                cal.add(Calendar.DAY_OF_MONTH, 1);
            break;
                
            case 3:
                cal.add(Calendar.WEEK_OF_YEAR, 1);
            break;
                
            case 4:
                cal.add(Calendar.MONTH, 1);
            break;
                
            case 5:
                cal.add(Calendar.MONTH, 1);
            break;
                
            default:
                cal.add(Calendar.DAY_OF_YEAR, 1);
            break;
        }
        return cal;
    }
     
     
    
    private static  String[] buildStringArrayXLabels(Date dtStart,Date dtEnd, int intChoice){
        
//        System.out.println("Inside  buildStringArrayXLabels: dtStart"+dtStart+"  dtEnd"+dtEnd);
        List<String> listLabels = new ArrayList<String>(30);
        Calendar cBase = Calendar.getInstance();
        cBase.setTime(dtStart);
        
        do{
//            if(intChoice == 0){
////                System.out.println(ArrayItems.formatOnlyHrs.format(cBase.getTime()));
//                listLabels.add(ArrayItems.formatOnlyHrs.format(cBase.getTime()));
//            }else if(intChoice == 3){
//                listLabels.add(ArrayItems.formatOnlyWeekMonthAndYear.format(cBase.getTime()));
//            }else{
//                listLabels.add(ArrayItems.format.format(cBase.getTime()));
//            }
            listLabels.add(MonitorDeFaturamentoByMaxDaysDao.grabFormatByChoice(intChoice).format(cBase.getTime()));
            
//            listLabels.add(ArrayItems.format.format(cBase.getTime()));
            cBase = calendarStepForwardByChoice(cBase, intChoice);
            
        }while(!MonitorDeFaturamentoByMaxDaysDao
                .grabFormatByChoice(intChoice).format(cBase.getTime()).equalsIgnoreCase(MonitorDeFaturamentoByMaxDaysDao
                .grabFormatByChoice(intChoice).format(dtEnd)));
        
        listLabels.add(MonitorDeFaturamentoByMaxDaysDao.grabFormatByChoice(intChoice).format(cBase.getTime()));
        
        String[] arrayRetorno = new String[listLabels.size()];
        
        for (int i = 0; i < listLabels.size(); i++) {
            arrayRetorno[i] = listLabels.get(i);
        }
        
       return arrayRetorno;
    }
    
  
    
   
    
    
    @Deprecated
    public static double[][] grabDataByWeekExames(List<LabUnidade> listUni,Date  dtBase,String strDbName){
         Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dtBase);
        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dtBase);
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        
          return grabDataByExamesMaxDays(listUni, DateRange.shiftDayto00hrs(cal1.getTime()), DateRange.shiftDayto24hrs(cal2.getTime()),7,Calendar.DAY_OF_WEEK,strDbName);
    }
    @Deprecated
    public static double[][] grabDataByWeekExames(LabUnidade uni,Date  dtBase,String strDbName){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dtBase);
        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dtBase);
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return grabDataByExamesMaxDays(uni, DateRange.shiftDayto00hrs(cal1.getTime()), DateRange.shiftDayto24hrs(cal2.getTime()),7,Calendar.DAY_OF_WEEK,strDbName);
    }
    @Deprecated
    public static double[][] grabDataByExamesMaxDays(LabUnidade uni,Date  dtStart,Date  dtEnd,int maxDays,int  intCALENDAR_DAY_OF,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        Map<String,Long> mapDtQtd = null;
        String strQueryDay =
                " SELECT"
                + "\n  TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') , "
                + "\n count(*) as QTDEEXAMES "
                + "\n FROM LabRequisicao req, LabDetalheRequisicao det "
                + "\n WHERE req.reqStCodigo = det.reqStCodigo"
                + "\n and req.reqDtCadastro  between  :reqDtCadastro1 and :reqDtCadastro2 "
                + "\n  AND req.uniStCodigo = :uniStCodigo "
                + "\n GROUP BY TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') "
                + "\n ORDER BY TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') ";
        double  arrayReturn[][] =  new double[1][];
        
        try{
        Query query = session.createQuery(strQueryDay);
        query.setString("uniStCodigo", uni.getUniStCodigo());
        query.setDate("reqDtCadastro1", dtStart);
        query.setDate("reqDtCadastro2", dtEnd);
        
        
        List  list = query.list();
        
        tx.commit();
        mapDtQtd = new HashMap<String, Long>(maxDays);
        
        
        
        if(list != null && !list.isEmpty()){
//            System.out.println("List Size: "+list.size());
            for(int i = 0; i < list.size() ; i ++){
                Object[] tupla = (Object[]) list.get(i);
                mapDtQtd.put(((String)tupla[0]).toString(), (Long)tupla[1]);
            }
            
            
        }    
        Calendar cal = Calendar.getInstance();
        cal.setTime(dtStart);
        arrayReturn = buildArrayByMapDate(maxDays, mapDtQtd,cal,intCALENDAR_DAY_OF);
        
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return arrayReturn;
    }
    @Deprecated
    public static double[][] grabDataByExamesMaxDays(List<LabUnidade> listUni,Date  dtStart,Date  dtEnd,int maxDays,int  intCALENDAR_DAY_OF,String strDbName){
        double[][] arrayReturn = new double[listUni.size()][maxDays];
        
        for(int i =0 ; i < listUni.size(); i ++){
            
            double[][] arrayInner = grabDataByExamesMaxDays(listUni.get(i) ,dtStart,dtEnd,maxDays,intCALENDAR_DAY_OF,strDbName);
            for(int i2 = 0 ; i2 < arrayInner[0].length; i2 ++){
                arrayReturn[i][i2] =   arrayInner[0][i2];
            }
        }
        return arrayReturn;
    }
    @Deprecated
    public static double[][] grabDataByWeekPacientes(LabUnidade uni,Date  dtBase,String strDbName){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dtBase);
        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dtBase);
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        
          return grabDataByPacientesMaxDays(uni, DateRange.shiftDayto00hrs(cal1.getTime()), DateRange.shiftDayto24hrs(cal2.getTime()),7,Calendar.DAY_OF_WEEK,strDbName);
    }
    @Deprecated
    public static double[][] grabDataByWeekPacientes(List<LabUnidade> listUni,Date  dtBase,String strDbName){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dtBase);
        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dtBase);
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        
          return grabDataByPacientesMaxDays(listUni, DateRange.shiftDayto00hrs(cal1.getTime()), DateRange.shiftDayto24hrs(cal2.getTime()),7,Calendar.DAY_OF_WEEK,strDbName);
    }
    @Deprecated
    public static double[][] grabDataByPacientesMaxDays(LabUnidade uni,Date  dtStart,Date  dtEnd,int  maxDays, int intCALENDAR_DAY_OF,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        Map<String,Long> mapDtQtd = null;
        String strQueryDay =
                " SELECT"
                + "\n  TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') , "
                + "\n count(distinct pac.pacInCodigo) "
                + "\n FROM LabRequisicao req, LabDetalheRequisicao det ,LabPaciente pac"
                + "\n WHERE req.reqStCodigo = det.reqStCodigo"
                +"\n and req.pacInCodigo = pac.pacInCodigo"
                + "\n and req.reqDtCadastro  between  :reqDtCadastro1 and :reqDtCadastro2 "
                + "\n  AND req.uniStCodigo = :uniStCodigo "
                + "\n GROUP BY TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') "
                + "\n ORDER BY TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') ";
        double  arrayReturn[][] =  new double[1][];
        
        try{
        Query query = session.createQuery(strQueryDay);
        query.setString("uniStCodigo", uni.getUniStCodigo());
        query.setDate("reqDtCadastro1", dtStart);
        query.setDate("reqDtCadastro2", dtEnd);
        
        
        List  list = query.list();
        
        tx.commit();
        mapDtQtd = new HashMap<String, Long>(maxDays);
        
        
        
        if(list != null && !list.isEmpty()){
//            System.out.println("List Size: "+list.size());
            for(int i = 0; i < list.size() ; i ++){
                Object[] tupla = (Object[]) list.get(i);
                mapDtQtd.put(((String)tupla[0]).toString(), (Long)tupla[1]);
            }
            
            
        }    
        Calendar cal = Calendar.getInstance();
        cal.setTime(dtStart);
        arrayReturn = buildArrayByMapDate(maxDays, mapDtQtd,cal,intCALENDAR_DAY_OF);
        
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
//        System.out.println(arrayReturn[0][0]);
//        System.out.println("arrayReturn[0][0]: "+arrayReturn[0][2]);
        return arrayReturn;
    }
    @Deprecated
    public static double[][] grabDataByPacientesMaxDays(List<LabUnidade> listUni,Date  dtStart,Date  dtEnd,int  maxDays, int intCALENDAR_DAY_OF,String strDbName){
        
        double[][] arrayReturn = new double[listUni.size()][maxDays];
        
        for(int i =0 ; i < listUni.size(); i ++){
            
            double[][] arrayInner = grabDataByPacientesMaxDays(listUni.get(i) ,dtStart,dtEnd,maxDays,intCALENDAR_DAY_OF,strDbName);
            for(int i2 = 0 ; i2 < arrayInner[0].length; i2 ++){
                arrayReturn[i][i2] =   arrayInner[0][i2];
            }
        }
        return arrayReturn;
    
    }
     @Deprecated
    public static double[][] grabDataByWeekValor(LabUnidade uni,Date  dtBase,String strDbName){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dtBase);
        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dtBase);
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
          return grabDataByValorMaxDays(uni, DateRange.shiftDayto00hrs(cal1.getTime()), DateRange.shiftDayto24hrs(cal2.getTime()),7,Calendar.DAY_OF_WEEK,strDbName);
    }
     @Deprecated
    public static double[][] grabDataByWeekValor(List<LabUnidade> listUni,Date  dtBase,String strDbName){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dtBase);
        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(dtBase);
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        
          return grabDataByValorMaxDays(listUni, DateRange.shiftDayto00hrs(cal1.getTime()), DateRange.shiftDayto24hrs(cal2.getTime()),7,Calendar.DAY_OF_WEEK,strDbName);
    }
     @Deprecated
    public static double[][] grabDataByValorMaxDays(List<LabUnidade> listUni,Date  dtStart,Date  dtEnd,int  maxDays,int  intCALENDAR_DAY_OF,String strDbName){
        double[][] arrayReturn = new double[listUni.size()][maxDays];
        
        for(int i =0 ; i < listUni.size(); i ++){
            
            double[][] arrayInner = grabDataByValorMaxDays(listUni.get(i) ,dtStart,dtEnd,maxDays,intCALENDAR_DAY_OF,strDbName);
            for(int i2 = 0 ; i2 < arrayInner[0].length; i2 ++){
                arrayReturn[i][i2] =   arrayInner[0][i2];
            }
        }
        return arrayReturn;
    }
     @Deprecated
    public static double[][] grabDataByValorMaxDays(LabUnidade uni,Date  dtStart,Date  dtEnd,int  maxDays,int  intCALENDAR_DAY_OF,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        Map<String,Long> mapDtQtd = null;
        String strQueryDay =
                " SELECT"
                + "\n  TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') , "
                + "\n SUM(det.derFlConvenio) "
                + "\n FROM LabRequisicao req, LabDetalheRequisicao det "
                + "\n WHERE req.reqStCodigo = det.reqStCodigo"
                + "\n and req.reqDtCadastro  between  :reqDtCadastro1 and :reqDtCadastro2 "
                + "\n  AND req.uniStCodigo = :uniStCodigo "
                + "\n GROUP BY TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') "
                + "\n ORDER BY TO_CHAR(req.reqDtCadastro,'DD/MM/YYYY') ";
        double  arrayReturn[][] =  new double[1][];
        
        try{
        Query query = session.createQuery(strQueryDay);
        query.setString("uniStCodigo", uni.getUniStCodigo());
        query.setDate("reqDtCadastro1", dtStart);
        query.setDate("reqDtCadastro2", dtEnd);
        
        
        List  list = query.list();
        
        tx.commit();
        mapDtQtd = new HashMap<String, Long>(7);
        
        
        
        if(list != null && !list.isEmpty()){
//            System.out.println("List Size: "+list.size());
            for(int i = 0; i < list.size() ; i ++){
                Object[] tupla = (Object[]) list.get(i);
                mapDtQtd.put(((String)tupla[0]).toString(), new Double((Double)tupla[1]).longValue());
            }
            
            
        }    
        Calendar cal = Calendar.getInstance();
        cal.setTime(dtStart);
        arrayReturn = buildArrayByMapDate(maxDays, mapDtQtd,cal,intCALENDAR_DAY_OF);
        
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
//        System.out.println(arrayReturn[0][0]);
//        System.out.println("arrayReturn[0][0]: "+arrayReturn[0][2]);
        return arrayReturn;
    }
    @Deprecated
    public static double[][] grabDataByMonthExames(List<LabUnidade> listUni,Date  dtStart,Date  dtEnd,int maxDays,String strDbName){
        double[][] arrayReturn = new double[listUni.size()][maxDays];
        
        for(int i =0 ; i < listUni.size(); i ++){
            
            double[][] arrayInner = grabDataByMonthExames(listUni.get(i) ,dtStart,dtEnd,maxDays,strDbName);
            for(int i2 = 0 ; i2 < arrayInner[0].length; i2 ++){
                arrayReturn[i][i2] =   arrayInner[0][i2];
            }
        }
        return arrayReturn;
    }
    @Deprecated
    public static double[][] grabDataByMonthExames(LabUnidade uni,Date  dtStart,Date  dtEnd,int maxDays,String strDbName){
        
        return grabDataByExamesMaxDays(uni, DateRange.shiftDayto00hrs(dtStart), DateRange.shiftDayto24hrs(dtEnd),maxDays,Calendar.DAY_OF_MONTH,strDbName);
    }
    @Deprecated
    public static double[][] grabDataByMonthPacientes(List<LabUnidade> listUni,Date  dtStart,Date  dtEnd,int maxDays,String strDbName){
        double[][] arrayReturn = new double[listUni.size()][maxDays];
        
        for(int i =0 ; i < listUni.size(); i ++){
            
            double[][] arrayInner = grabDataByMonthPacientes(listUni.get(i) ,dtStart,dtEnd,maxDays,strDbName);
            for(int i2 = 0 ; i2 < arrayInner[0].length; i2 ++){
                arrayReturn[i][i2] =   arrayInner[0][i2];
            }
        }
        return arrayReturn;
    }
    @Deprecated
    public static double[][] grabDataByMonthPacientes(LabUnidade uni,Date  dtStart,Date  dtEnd,int maxDays,String strDbName){
        
          return grabDataByPacientesMaxDays(uni, DateRange.shiftDayto00hrs(dtStart), DateRange.shiftDayto24hrs(dtEnd),maxDays,Calendar.DAY_OF_MONTH,strDbName);
    }
    @Deprecated
    public static double[][] grabDataByMonthValor(List<LabUnidade> listUni,Date  dtStart,Date  dtEnd,int maxDays,String strDbName){
        double[][] arrayReturn = new double[listUni.size()][maxDays];
        
        for(int i =0 ; i < listUni.size(); i ++){
            
            double[][] arrayInner = grabDataByMonthValor(listUni.get(i) ,dtStart,dtEnd,maxDays,strDbName);
            for(int i2 = 0 ; i2 < arrayInner[0].length; i2 ++){
                arrayReturn[i][i2] =   arrayInner[0][i2];
            }
        }
        return arrayReturn;
    }
    @Deprecated
    public static double[][] grabDataByMonthValor(LabUnidade uni,Date  dtStart,Date  dtEnd,int maxDays,String strDbName){
        
          return grabDataByValorMaxDays(uni, DateRange.shiftDayto00hrs(dtStart), DateRange.shiftDayto24hrs(dtEnd), maxDays,Calendar.DAY_OF_MONTH,strDbName);
    }
    @Deprecated
    public static double[][] buildArrayByMapDate(int intNumberOfLables, Map<String,Long>  mapLabelValue, Calendar cal ,int intCALENDAR_DAY_OF){
        double[][] arrayOne = new double[1][intNumberOfLables];
        for(int i = 0 ; i < intNumberOfLables; i ++){
            arrayOne[0][i] = 0;
        }
        for(int i = 0 ; i < intNumberOfLables; i ++){
//            cal.set(Calendar.DAY_OF_WEEK, i+1);
            cal.set(intCALENDAR_DAY_OF, i+1);
//            System.out.println(format.format(cal.getTime()));
            if(mapLabelValue.containsKey(ArrayItems.format.format(cal.getTime()))){
//                System.out.println("Inserting into the array position : "+i);
//                System.out.println("Value into position : "+mapLabelValue.get(format.format(cal.getTime())));
                arrayOne[0][i] = mapLabelValue.get(ArrayItems.format.format(cal.getTime()));
            }
        }
        
        return   arrayOne;
    }
    
    
    
    
    
    
    public static MonitorDados grabDataBuildMonitorDados(List<LabUnidade> listUni,Date  dtBase,int intChoice,String strDbName) {
    
        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        Map<UniData,Long> mapUniDatePacientes = new LinkedHashMap<UniData, Long>();
        Map<UniData,Long> mapUniDateExames = new LinkedHashMap<UniData, Long>();
        Map<UniData,Double> mapUniDateValor = new LinkedHashMap<UniData, Double>();
        
        
        
        Date[] arrayDate = MonitorDeFaturamentoByMaxDaysDao.dateShift(intChoice, dtBase);
        
        String[] arrayXLabels = buildStringArrayXLabels(arrayDate[0], arrayDate[1],intChoice);
        
        double[][] dataPacientes = new double[listUni.size()][arrayXLabels.length];
        double[][] dataExames = new double[listUni.size()][arrayXLabels.length];
        double[][] dataValor = new double[listUni.size()][arrayXLabels.length];
        
        
        List<String> listUniCodigo = new ArrayList<String>(listUni.size());
        
        for(LabUnidade uni : listUni){
            
            listUniCodigo.add(uni.getUniStCodigo());}
        
        StringBuffer sbUni = new StringBuffer();
        String strUni = null;
        if(listUni != null){
            
            for(String uni : listUniCodigo){
                sbUni.append("'").append(uni).append("',");
            }
            
            if(sbUni != null && sbUni.length()>1){
                strUni = sbUni.toString().substring(0, sbUni.length()-1);
            }
            
        }
        
        
        String strQueryExames =
                " SELECT "
                + "\n  "+MonitorDeFaturamentoByMaxDaysDao.sqlHelper_TO_CHAR(intChoice) +"   , "
                + "\n count(*) as QTDEEXAMES , "
                + "\n req.uniStCodigo  "
                + "\n FROM LabRequisicao req, LabDetalheRequisicao det "
                + "\n WHERE req.reqStCodigo = det.reqStCodigo"
                + "\n and req.reqDtCadastro  between  :reqDtCadastro1 and :reqDtCadastro2 ";
                if(strUni != null && strUni.length()>=1){
                  strQueryExames+= "\n and req.uniStCodigo in (" + strUni + ") ";
                }
                strQueryExames += "\n GROUP BY  req.uniStCodigo,  "+MonitorDeFaturamentoByMaxDaysDao.sqlHelper_TO_CHAR(intChoice) +" "
                + "\n ORDER BY req.uniStCodigo,  "+MonitorDeFaturamentoByMaxDaysDao.sqlHelper_TO_CHAR(intChoice) +" ";
        
                String strQueryPaciente =
                " SELECT"
                + "\n  "+MonitorDeFaturamentoByMaxDaysDao.sqlHelper_TO_CHAR(intChoice) +" , "
                + "\n count(distinct pac.pacInCodigo) ,"
                + "\n req.uniStCodigo  "
                + "\n FROM LabRequisicao req, LabDetalheRequisicao det ,LabPaciente pac"
                + "\n WHERE req.reqStCodigo = det.reqStCodigo"
                +"\n and req.pacInCodigo = pac.pacInCodigo"
                + "\n and req.reqDtCadastro  between  :reqDtCadastro1 and :reqDtCadastro2 ";
                if(strUni != null && strUni.length()>=1){
                  strQueryPaciente += "\n and req.uniStCodigo in (" + strUni + ") ";
                }
                strQueryPaciente += "\n GROUP BY  req.uniStCodigo,  "+MonitorDeFaturamentoByMaxDaysDao.sqlHelper_TO_CHAR(intChoice) +" "
                + "\n ORDER BY  req.uniStCodigo,  "+MonitorDeFaturamentoByMaxDaysDao.sqlHelper_TO_CHAR(intChoice) +" ";
                
                
                String strQueryValor =
                " SELECT"
                + "\n  "+MonitorDeFaturamentoByMaxDaysDao.sqlHelper_TO_CHAR(intChoice) +" , "
                + "\n SUM(det.derFlConvenio) ,"
                + "\n req.uniStCodigo  "
                + "\n FROM LabRequisicao req, LabDetalheRequisicao det "
                + "\n WHERE req.reqStCodigo = det.reqStCodigo"
                + "\n and req.reqDtCadastro  between  :reqDtCadastro1 and :reqDtCadastro2 ";
                if(strUni != null && strUni.length()>=1){
                  strQueryValor += "\n and req.uniStCodigo in (" + strUni + ") ";
                }
                strQueryValor+= "\n GROUP BY  req.uniStCodigo , "+MonitorDeFaturamentoByMaxDaysDao.sqlHelper_TO_CHAR(intChoice) +" "
                + "\n ORDER BY req.uniStCodigo , "+MonitorDeFaturamentoByMaxDaysDao.sqlHelper_TO_CHAR(intChoice) +" ";
                
                
                
        try{
                
        Query queryPacentes = session.createQuery(strQueryPaciente);
        queryPacentes.setDate("reqDtCadastro1", arrayDate[0]);
        queryPacentes.setDate("reqDtCadastro2", arrayDate[1]);
        List  listqueryPacentes = queryPacentes.list();
        
        Query queryExames = session.createQuery(strQueryExames);
        queryExames.setDate("reqDtCadastro1", arrayDate[0]);
        queryExames.setDate("reqDtCadastro2", arrayDate[1]);
        List  listqueryExames = queryExames.list();
        
        Query queryValor = session.createQuery(strQueryValor);
        queryValor.setDate("reqDtCadastro1", arrayDate[0]);
        queryValor.setDate("reqDtCadastro2", arrayDate[1]);
        List  listqueryValor = queryValor.list();
        
        tx.commit();
        
        if(listqueryPacentes != null && !listqueryPacentes.isEmpty()){
            for(int i = 0; i < listqueryPacentes.size() ; i ++){
                Object[] tupla = (Object[]) listqueryPacentes.get(i);
                mapUniDatePacientes.put(new UniData(((String)tupla[2]).toString(), ((String)tupla[0]).toString()), (Long)tupla[1]);
            }
        }    
        if(listqueryExames != null && !listqueryExames.isEmpty()){
            for(int i = 0; i < listqueryExames.size() ; i ++){
                Object[] tupla = (Object[]) listqueryExames.get(i);
                mapUniDateExames.put(new UniData(((String)tupla[2]).toString(), ((String)tupla[0]).toString()), (Long)tupla[1]);
            }
        }    
        if(listqueryValor != null && !listqueryValor.isEmpty()){
            for(int i = 0; i < listqueryValor.size() ; i ++){
                Object[] tupla = (Object[]) listqueryValor.get(i);
                mapUniDateValor.put(new UniData(((String)tupla[2]).toString(), ((String)tupla[0]).toString()), (Double)tupla[1]);
            }
        }    
        
        
        for(int i = 0 ; i < arrayXLabels.length; i ++){
            for(int y = 0 ; y < listUni.size(); y ++ ){
                
//                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<"+listUni.get(y).getUniStCodigo() +" Data: "+arrayXLabels[i]+">>>>>>>>>>>>>>>>>>>>>>>>");
                
                if(mapUniDatePacientes.containsKey(new UniData(listUni.get(y).getUniStCodigo(), arrayXLabels[i]))){
                    
                    dataPacientes[y][i] = mapUniDatePacientes.get(new UniData(listUni.get(y).getUniStCodigo(), arrayXLabels[i]));
                    dataExames[y][i] = mapUniDateExames.get(new UniData(listUni.get(y).getUniStCodigo(), arrayXLabels[i]));
                    dataValor[y][i] = new Double(mapUniDateValor.get(new UniData(listUni.get(y).getUniStCodigo(), arrayXLabels[i]))).longValue();
                    
//                    System.out.println("Pacs: "+ mapUniDatePacientes.get(new UniData(listUni.get(y).getUniStCodigo(), arrayXLabels[i])));
//                    System.out.println("Exes: "+ mapUniDateExames.get(new UniData(listUni.get(y).getUniStCodigo(), arrayXLabels[i])));
//                    System.out.println("Exes: "+ mapUniDateValor.get(new UniData(listUni.get(y).getUniStCodigo(), arrayXLabels[i])));
                }else{
//                    System.out.println("0");
                }
//                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<< End >>>>>>>>>>>>>>>>>>>>>>>>\n\n");
            }
        }
        
        
        
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return new MonitorDados(intChoice, arrayXLabels, dataPacientes, dataExames, dataValor);
    }
    
    
    
    
    
    public static void main(String... args){
//        MonitorDeFaturamentoByMaxDaysDao.grabDataByWeekExames(new LabUnidade("SPS"), new Date());
//        MonitorDeFaturamentoByMaxDaysDao.grabDataByWeekPacientes(new LabUnidade("SAR"), new Date());
//        MonitorDeFaturamentoByMaxDaysDao.grabDataByWeekValor(new LabUnidade("SAR"), new Date());
        
        Date dtBase = new Date();
//        Calendar cal1 = Calendar.getInstance();
//        cal1.setTime(dtBase);
//        cal1.set(Calendar.DAY_OF_MONTH, 1);
//        Calendar cal2 = Calendar.getInstance();
//        cal2.setTime(dtBase);
//        int max = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);
//        cal2.set(Calendar.DAY_OF_MONTH, max);
//        System.out.println("max: "+max);
//        MonitorDeFaturamentoByMaxDaysDao.grabDataByMonthExames(new LabUnidade("SAR"), cal1.getTime(), cal2.getTime(), max);
        
//        Date[] arrayDate = MonitorDeFaturamentoByMaxDaysDao.dateShift(1, dtBase);
        
//        System.out.println(arrayDate[0]);
//        System.out.println(arrayDate[1]);
        
//        String[] arrayXLabels = buildStringArrayXLabels(arrayDate[0], arrayDate[1],1);
//        
//        for(int i = 0 ; i < arrayXLabels.length; i ++){
//            System.out.println(arrayXLabels[i]);
//        }
//        
        List<LabUnidade> listUni = new ArrayList<LabUnidade>();
        listUni.add(new LabUnidade("SAR"));
//        listUni.add(new LabUnidade("FAR"));
//        listUni.add(new LabUnidade("SPN"));
        MonitorDados m  =   MonitorDeFaturamentoByMaxDaysDao.grabDataBuildMonitorDados(listUni, dtBase, 5,"DEFAULT");
        
//        System.out.println(ArrayItems.formatOnlyWeekMonthAndYear.format(new Date()));
        
        
//        OracleHelper.getLabUsuario("EROS", "DAFTPUNK");
        
        
//        double[][] arrayReturn = new double[3][6];
//        
//        for(int i = 0 ; i < arrayReturn.length ; i ++){
//            System.out.println(arrayReturn[i][0]);
//        }
        
        
    }
    
    
    
}


