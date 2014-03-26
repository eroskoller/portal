/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.monitor.faturamento;

import br.com.hibernate.entities.LabPaciente;
import br.com.hibernate.entities.LabUnidade;
import br.com.hibernate.utils.OracleHelper;
import br.com.utils.tipstricks.DateRange;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eros
 */


public class MonitorDeFaturamentoByDayDao implements Serializable{
    
    
    
    private static double[][] grabDataByDayExames(LabUnidade uni,Date  dtStart,Date  dtEnd,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        Map<Integer,Long> mapHrQtd = null;
        
        String strQueryDay =
                " SELECT"
                + "\n  to_char(req.reqHrCadastro, 'HH24') as REQ_HR_CADASTRO, "
                + "\n count(*) as QTDEEXAMES "
                + "\n FROM LabRequisicao req, LabDetalheRequisicao det "
                + "\n WHERE req.reqStCodigo = det.reqStCodigo"
                + "\n and req.reqDtCadastro  between  :reqDtCadastro1 and :reqDtCadastro2 "
                + "\n  AND req.uniStCodigo = :uniStCodigo "
                + "\n GROUP BY to_char(req.reqHrCadastro, 'HH24') "
                + "\n ORDER BY to_char(req.reqHrCadastro, 'HH24') ";
        double  arrayReturn[][] =  new double[1][];
        
        try{
        Query query = session.createQuery(strQueryDay);
        query.setString("uniStCodigo", uni.getUniStCodigo());
        query.setDate("reqDtCadastro1", dtStart);
        query.setDate("reqDtCadastro2", dtEnd);
        
//            System.out.println("dtStart: "+dtStart+"  dtEnd: "+dtEnd);
        
        List  list = query.list();
        
        tx.commit();
        mapHrQtd = new HashMap<Integer, Long>(24);
        
        
        
        if(list != null && !list.isEmpty()){
            
            for(int i = 0; i < list.size() ; i ++){
                Object[] tupla = (Object[]) list.get(i);
                mapHrQtd.put(new Integer((String)tupla[0]), (Long)tupla[1]);
            }
            
        }    
        
        arrayReturn = buildArrayByMap(24, mapHrQtd);
        
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return arrayReturn;
    }
    
    private static double[][] grabDataByDayExames(List<LabUnidade> listUni ,Date  dtStart,Date  dtEnd,String strDbName){
        
        double[][] arrayReturn = new double[listUni.size()][24];
        
        for(int i =0 ; i < listUni.size(); i ++){
//            System.out.println("listUni: "+listUni.size());
            
            double[][] arrayInner = grabDataByDayExames(listUni.get(i) ,dtStart,dtEnd,strDbName);
            for(int i2 = 0 ; i2 < arrayInner[0].length; i2 ++){
                arrayReturn[i][i2] =   arrayInner[0][i2];
            }
        }
        return arrayReturn;
    }
    
    private static double[][] grabDataByDayPacientes(LabUnidade uni,Date  dtStart,Date  dtEnd,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        Map<Integer,Long> mapHrQtd = null;
        String strQueryDay =
                " SELECT"
                + "\n  to_char(req.reqHrCadastro, 'HH24') as REQ_HR_CADASTRO, "
                + "\n count(distinct pac.pacInCodigo) "
                + "\n FROM LabRequisicao req, LabDetalheRequisicao det ,LabPaciente pac"
                + "\n WHERE req.reqStCodigo = det.reqStCodigo"
                + "\n and req.reqDtCadastro  between  :reqDtCadastro1 and :reqDtCadastro2 "
                	+"\n and req.pacInCodigo = pac.pacInCodigo"
                + "\n  AND req.uniStCodigo = :uniStCodigo "
                + "\n GROUP BY to_char(req.reqHrCadastro, 'HH24') "
                + "\n ORDER BY to_char(req.reqHrCadastro, 'HH24') ";
        double  arrayReturn[][] =  new double[1][];
        
        try{
        Query query = session.createQuery(strQueryDay);
        query.setString("uniStCodigo", uni.getUniStCodigo());
        query.setDate("reqDtCadastro1", dtStart);
        query.setDate("reqDtCadastro2", dtEnd);
        
//            System.out.println("dtStart: "+dtStart+"  dtEnd: "+dtEnd);
        
        List  list = query.list();
        
        tx.commit();
        mapHrQtd = new HashMap<Integer, Long>(24);
        
        
        
        if(list != null && !list.isEmpty()){
//            System.out.println("List Size: "+list.size());
            
            for(int i = 0; i < list.size() ; i ++){
                Object[] tupla = (Object[]) list.get(i);
                mapHrQtd.put(new Integer((String)tupla[0]), (Long)tupla[1]);
            }
            
//            System.out.println("mapHrQtd.size(): "+mapHrQtd.size());
            
            
        }    
        
        arrayReturn = buildArrayByMap(24, mapHrQtd);
        
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return arrayReturn;
    }
    
    private static double[][] grabDataByDayPacientes(List<LabUnidade> listUni ,Date  dtStart,Date  dtEnd,String strDbName){
        
        double[][] arrayReturn = new double[listUni.size()][24];
        
        for(int i =0 ; i < listUni.size(); i ++){
            
            double[][] arrayInner = grabDataByDayPacientes(listUni.get(i) ,dtStart,dtEnd,strDbName);
            for(int i2 = 0 ; i2 < arrayInner[0].length; i2 ++){
                arrayReturn[i][i2] =   arrayInner[0][i2];
            }
        }
        return arrayReturn;
    }
    
    private static double[][] grabDataByDayValor(LabUnidade uni,Date  dtStart,Date  dtEnd,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        Map<Integer,Long> mapHrQtd = null;
        String strQueryDay =
                " SELECT"
                + "\n  to_char(req.reqHrCadastro, 'HH24') as REQ_HR_CADASTRO, "
                + "\n SUM(det.derFlConvenio) "
                + "\n FROM LabRequisicao req, LabDetalheRequisicao det "
                + "\n WHERE req.reqStCodigo = det.reqStCodigo"
                + "\n and req.reqDtCadastro  between  :reqDtCadastro1 and :reqDtCadastro2 "
                + "\n  AND req.uniStCodigo = :uniStCodigo "
                + "\n GROUP BY to_char(req.reqHrCadastro, 'HH24') "
                + "\n ORDER BY to_char(req.reqHrCadastro, 'HH24') ";
        double  arrayReturn[][] =  new double[1][];
        
        try{
        Query query = session.createQuery(strQueryDay);
        query.setString("uniStCodigo", uni.getUniStCodigo());
        query.setDate("reqDtCadastro1", dtStart);
        query.setDate("reqDtCadastro2", dtEnd);
        
//            System.out.println("dtStart: "+dtStart+"  dtEnd: "+dtEnd);
        
        List  list = query.list();
        
        tx.commit();
        mapHrQtd = new HashMap<Integer, Long>(24);
        
        
        
        if(list != null && !list.isEmpty()){
//            System.out.println("List Size: "+list.size());
            
            for(int i = 0; i < list.size() ; i ++){
                Object[] tupla = (Object[]) list.get(i);
                mapHrQtd.put(new Integer((String)tupla[0]), new Double((Double)tupla[1]).longValue());
            }
            
        }    
        
        arrayReturn = buildArrayByMap(24, mapHrQtd);
        
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return arrayReturn;
    }
    
     private static double[][] grabDataByDayValor(List<LabUnidade> listUni ,Date  dtStart,Date  dtEnd,String strDbName){
        
        double[][] arrayReturn = new double[listUni.size()][24];
        
        for(int i =0 ; i < listUni.size(); i ++){
            
            double[][] arrayInner = grabDataByDayValor(listUni.get(i) ,dtStart,dtEnd,strDbName);
            for(int i2 = 0 ; i2 < arrayInner[0].length; i2 ++){
                arrayReturn[i][i2] =   arrayInner[0][i2];
            }
        }
        return arrayReturn;
    }

    public static double[][] grabDataByDayExames(LabUnidade uni,Date  dtBase,String strDbName){
        
        Date[] arrayDate = DateRange.dataRangerStartDayToEndDay(new Date(dtBase.getTime()), new Date(dtBase.getTime()));
        Date dtStart = arrayDate[0];
        Date dtEnd = arrayDate[1];
        
        return grabDataByDayExames(uni, dtStart, dtEnd,strDbName);
    }
    
    public static double[][] grabDataByDayExames(List<LabUnidade> listUni,Date  dtBase,String strDbName){
        
        Date[] arrayDate = DateRange.dataRangerStartDayToEndDay(new Date(dtBase.getTime()), new Date(dtBase.getTime()));
        Date dtStart = arrayDate[0];
        Date dtEnd = arrayDate[1];
        
        return grabDataByDayExames(listUni, dtStart, dtEnd,strDbName);
    }
    
    public static double[][] grabDataByDayPacientes(LabUnidade uni,Date  dtBase,String strDbName){
        
        Date[] arrayDate = DateRange.dataRangerStartDayToEndDay(new Date(dtBase.getTime()), new Date(dtBase.getTime()));
        Date dtStart = arrayDate[0];
        Date dtEnd = arrayDate[1];
        
        return grabDataByDayPacientes(uni, dtStart, dtEnd,strDbName);
    }
    
    public static double[][] grabDataByDayPacientes(List<LabUnidade> listUni,Date  dtBase,String strDbName){
        
        Date[] arrayDate = DateRange.dataRangerStartDayToEndDay(new Date(dtBase.getTime()), new Date(dtBase.getTime()));
        Date dtStart = arrayDate[0];
        Date dtEnd = arrayDate[1];
        
        return grabDataByDayPacientes(listUni, dtStart, dtEnd,strDbName);
    }
    
    public static double[][] grabDataByDayValor(LabUnidade uni,Date  dtBase,String strDbName){
        
        Date[] arrayDate = DateRange.dataRangerStartDayToEndDay(new Date(dtBase.getTime()), new Date(dtBase.getTime()));
        Date dtStart = arrayDate[0];
        Date dtEnd = arrayDate[1];
        
        return grabDataByDayValor(uni, dtStart, dtEnd,strDbName);
    }
    
    public static double[][] grabDataByDayValor(List<LabUnidade> listUni,Date  dtBase,String strDbName){
        
        Date[] arrayDate = DateRange.dataRangerStartDayToEndDay(new Date(dtBase.getTime()), new Date(dtBase.getTime()));
        Date dtStart = arrayDate[0];
        Date dtEnd = arrayDate[1];
        
        return grabDataByDayValor(listUni, dtStart, dtEnd,strDbName);
    }
    
    public static double[][] grabDataByMonth(LabUnidade uni,Date  dtBase){
        return null;
    }
    
    public static double[][] grabDataByQuater(LabUnidade uni,Date  dtBase){
        return null;
    }
    
    public static double[][] grabDataBySemester(LabUnidade uni,Date  dtBase){
        return null;
    }
    
    public static double[][] grabDataByYear(LabUnidade uni,Date  dtBase){
        return null;
    }
    
    public static double[][] grabDataByYearDouble(LabUnidade uni,Date  dtBase){
        return null;
    }
    
    
    
    
    public static double[][] buildArrayByMap(int intNumberOfLables, Map<Integer,Long>  mapLabelValue ){
        double[][] arrayOne = new double[1][intNumberOfLables];
        for(int i = 0 ; i < intNumberOfLables; i ++){
            arrayOne[0][i] = 0;
        }
        for(int i = 0 ; i < intNumberOfLables; i ++){
            if(mapLabelValue.containsKey(new Integer(i))){
                arrayOne[0][i] = mapLabelValue.get(new Integer(i));
            }
        }
        
        return   arrayOne;
    }
    
    
    
}





