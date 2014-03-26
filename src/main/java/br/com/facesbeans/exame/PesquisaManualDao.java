/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.exame;

import br.com.hibernate.entities.LabExame;
import br.com.hibernate.entities.LabManualExame;
import br.com.hibernate.utils.OracleHelper;
import java.io.Serializable;
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
public class PesquisaManualDao implements  Serializable{
    
    
    public static List<LabManualExame> grabListLabManualExameByMnemonic(String strMnemonicCodigo,String strDbName){
        Session session = null;
        Transaction tx = null;
        List<LabManualExame>  list = null;
        try{
            session = OracleHelper.getSessionDude(strDbName);
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(LabManualExame.class);
            criteria.add(Restrictions.like("exaStCodigo", new LabExame(strMnemonicCodigo.toUpperCase()+"%")));
            criteria.add(Restrictions.eq("mexInAtivo", 1));
            criteria.addOrder(Property.forName("exaStCodigo").asc());
            
            list = criteria.list();
            tx.commit();
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        
        return list;
    }
    
    public static List<LabManualExame> grabListLabManualExameByExameDesc(String strExameDesc,String strDbName){
        Session session = null;
        Transaction tx = null;
        List<LabManualExame>  list = null;
        try{
            session = OracleHelper.getSessionDude(strDbName);
            tx = session.beginTransaction();
            String sqlQuery = "\n   from LabManualExame mex"
                    + "\n where mex.exaStCodigo.exaStDescricao like :exaStDescricao  "
                    + "\n and mex.mexInAtivo = 1 ";
            Query query = session.createQuery(sqlQuery);
            query.setString("exaStDescricao", strExameDesc.toUpperCase()+"%");
            list = query.list();
            tx.commit();
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        
        return list;
    }
    
    public static List<LabManualExame> grabListLabManualExameBySynonymies(String strSynonymies,String strDbName){
        Session session = null;
        Transaction tx = null;
        List<LabManualExame>  list = null;
        try{
            session = OracleHelper.getSessionDude(strDbName);
            tx = session.beginTransaction();
            String sqlQuery = "\n   from LabManualExame mex"
                    + "\n where mex.exaStCodigo.exaStSinonimias like :exaStSinonimias  "
                    + "\n and mex.mexInAtivo = 1 ";
            Query query = session.createQuery(sqlQuery);
            query.setString("exaStSinonimias", "%"+strSynonymies.trim()+"%");
            list = query.list();
            tx.commit();
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        
        return list;
    }
    
    
    
}
