/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.laudo;

import br.com.hibernate.entities.LabRequisicao;
import br.com.hibernate.utils.OracleHelper;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author eros
 */
public class ConsultaLaudoDao implements Serializable{
    
    
    public static List<LabRequisicao> grabListLabRequisicaoByReqStCodigo(String strReqStCodigo, String strDbName) {

        Session session = null;
        Transaction tx = null;

        List<LabRequisicao> result = null;
        try {
            session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(LabRequisicao.class);
            criteria.add(Restrictions.isNotNull("pacInCodigo"));
            criteria.addOrder(Order.desc("reqInCodigo"));
            criteria.add(Restrictions.eq("reqStCodigo", strReqStCodigo));

            tx.commit();
            result = criteria.list();

        } catch (Exception xcp) {
            xcp.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }
    
    
    public static List<LabRequisicao> grabListLabRequisicaoByPacProntuario(String strPacStProntuario, String strDbName) {

        Session session = null;
        Transaction tx = null;
        
        String sqlQuery = "from LabRequisicao  lr "
                + " where lr.pacInCodigo != null"
                + " and lr.pacInCodigo.pacStProntuario = :pacStProntuario";

        List<LabRequisicao> result = null;
        try {
            session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(sqlQuery);
            query.setString("pacStProntuario", strPacStProntuario.trim().toUpperCase());
            
            tx.commit();
            result = query.list();

        } catch (Exception xcp) {
            xcp.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }
    
    
    
    
    public static List<LabRequisicao> grabListLabRequisicaoByPacName(String strPacStNome, String strDbName) {

        Session session = null;
        Transaction tx = null;
        
        String sqlQuery = "from LabRequisicao  lr "
                + " where lr.pacInCodigo != null"
                + " and lr.pacInCodigo.pacStNome like :pacStNome ";

        List<LabRequisicao> result = null;
        try {
            session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            Query query = session.createQuery(sqlQuery);
            query.setString("pacStNome", strPacStNome.trim().toUpperCase()+"%");
            query.setMaxResults(1000);
            tx.commit();
            result = query.list();

        } catch (Exception xcp) {
            xcp.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }
    
    
    public  static List<LabRequisicao> grabListLabRequisicao(Class myClass,
            Map<String, Object> mapArgsAnds,
            Map<String, List> mapArgsOrs,
            String strDateFieldName, Date dtStart, Date dtEnd,int intMaxResults,String strDbName) {
//        System.out.println("Inside ConsultaLaudoDao.grabListLabRequisicao.............");
        
        Session session = null;
        Transaction tx = null;

        List<LabRequisicao> result = null;
        try {
            session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(myClass);
            criteria.add(Restrictions.isNotNull("pacInCodigo"));
            criteria.addOrder(Order.desc("reqInCodigo"));

            if (dtStart != null && dtEnd != null && strDateFieldName != null ) {
                        criteria.add(Expression.between(strDateFieldName, dtStart, dtEnd));
            }

            if (mapArgsAnds != null && mapArgsAnds.size() > 0) {

                Iterator iter = mapArgsAnds.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
                }
            }


            if (mapArgsOrs != null && mapArgsOrs.size() > 0) {

                Iterator iter = mapArgsOrs.entrySet().iterator();
                Disjunction disj;
                Property property;

                while (iter.hasNext()) {
                    disj = Restrictions.disjunction();
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    property = Property.forName(pair.getKey());
                    List<Object> l = (List<Object>) pair.getValue();
                    for (Object obj : l) {
                        disj.add(property.eq(obj));
                    }

                    criteria.add(disj);
                }
                criteria.setMaxResults(intMaxResults);
                tx.commit();
                result = criteria.list();
            }



            if (result == null) {
                criteria.setMaxResults(intMaxResults);
                tx.commit();
                result = criteria.list();
            }



        } catch(Exception xcp){
            xcp.printStackTrace();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }
    
    
    
    
}
