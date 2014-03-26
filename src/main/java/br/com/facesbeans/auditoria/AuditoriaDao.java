/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.auditoria;

import br.com.facesbeans.shared.ArrayItems;
import br.com.hibernate.entities.LabAuditoria;
import br.com.hibernate.entities.LabErroAuditoria;
import br.com.hibernate.entities.LabSistema;
import br.com.hibernate.entities.LabUnidade;
import br.com.hibernate.entities.LabUsuario;
import br.com.hibernate.utils.OracleHelper;
import br.com.utils.tipstricks.DateRange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author eros
 */
public class AuditoriaDao implements Serializable{
    
    
    
    public static List<LabErroAuditoria>  grabAllLabErros(String strDbName){
        Session session = null;
        Transaction tx = null;
        List<LabErroAuditoria>  list = null;
        try{
            session = OracleHelper.getSessionDude(strDbName);
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(LabErroAuditoria.class);
            criteria.addOrder(Property.forName("errInCodigo").asc());
            
            list =  criteria.list();
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        
        return list;
    }
    
    public static List<LabSistema> grabAllLabSistemaByUser(LabUsuario labUsuario , String strDbName){
        
        Session session = null;
        Transaction tx = null;
        List<LabSistema> listLabSistema = null;
        try{
            session = OracleHelper.getSessionDude(strDbName);
            tx = session.beginTransaction();
            String strQuery = "\n select sis.sisStCodigo   ,sis.sisStSistema, sis.sisStEmpresa,sis.uniStCodigo.uniStCodigo"
                    + "\n  from LabUsuarioSistema  siu, LabSistema sis"
                    + "\n  where sis.sisStCodigo = siu.labUsuarioSistemaPK.sisStCodigo "
                    + "\n  and siu.labUsuarioSistemaPK.usuStCodigo = :usuStCodigo"
//                    + "\n  and sis.sisStCodigo is not null "
//                    + "\n  and sis.sisStSistema is not null "
//                    + "\n  and sis.sisStEmpresa is not null "
                    + "\n  group by sis.sisStCodigo ,sis.sisStSistema, sis.sisStEmpresa,sis.uniStCodigo.uniStCodigo "
                    + "\n  order by sis.sisStCodigo asc";
            
                    Query query = session.createQuery(strQuery);
                    query.setString("usuStCodigo", labUsuario.getUsuStCodigo());
                    
                    List list  = query.list();
                    tx.commit();

            if (list != null && !list.isEmpty()) {
                listLabSistema = new ArrayList<>(list.size());
//            System.out.println("List Size: "+list.size());

                for (int i = 0; i < list.size(); i++) {
                    Object[] tupla = (Object[]) list.get(i);
                    listLabSistema.add(new LabSistema((String) tupla[0], null, (String) tupla[1], (String) tupla[2]));
                }

            }else{
                System.out.println("List Sistemas is NULL.....................");
            }
                    
            
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listLabSistema;
    }
    
    
    public  static List<LabAuditoria>  grabListLabAuditoriaByDt(String strDbName, Date dtStart, Date dtEnd,String strSisStCodigo,Long errInCodigo,String strMsg,String strStatusExame){
        Session session = null;
        Transaction tx = null;
        List<LabAuditoria> listLabAuditoria = null;
        try{
                session = OracleHelper.getSessionDude(strDbName);
                tx = session.beginTransaction();
                
                Criteria criteria = session.createCriteria(LabAuditoria.class);
                criteria.add(Restrictions.eq("sisStCodigo", strSisStCodigo));
//                System.out.println("Sistema: "+strSisStCodigo);
                criteria.add(Restrictions.between("audDtData", dtStart, dtEnd));
                
                if(errInCodigo != null && errInCodigo > 0L){
                    criteria.add(Restrictions.eq("errInCodigo", errInCodigo));
                }
                if(strMsg != null && strMsg.trim().length() > 3){
                    criteria.add(Restrictions.like("audStDescricao", "%"+strMsg+"%"));
                }    
                if (strStatusExame != null) {
                switch (strStatusExame) {
                    case "pendentes":
                        criteria.add(Restrictions.eq("audChVerificado", '0'));
                        break;
                        case "verificados":
                        criteria.add(Restrictions.eq("audChVerificado", '1'));
                        break;
                    default:
                }
            }
//                criteria.setMaxResults(ArrayItems.intMaximumAuditoriaResults);
                
                
                    listLabAuditoria = criteria.list();
                    if (listLabAuditoria.isEmpty()) {
//                        System.out.println("listLabAuditoria.size: " + listLabAuditoria.size());
                    }
            
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        
        return listLabAuditoria;
    }
            
    
    
    
}
