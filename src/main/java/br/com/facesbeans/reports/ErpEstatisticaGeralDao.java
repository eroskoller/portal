/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facesbeans.reports;

import br.com.hibernate.entities.*;
import br.com.hibernate.utils.OracleHelper;
import br.com.hibernate.utils.SessionFactoriByDBName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eros
 */
public class ErpEstatisticaGeralDao implements Serializable{
    
    static protected Logger log = Logger.getLogger(ErpEstatisticaGeralDao.class.getName());
    
    public  static  List<ErpUnidade>   grabErpUnidadeByExpression(String usuStCodigo,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ErpUnidade> listErpUnidade = new ArrayList<ErpUnidade>();
        
        String sqlQuery =
         " select uni.uniStCodigo,uni.uniStDescricao "+
    " \n from   ErpUnidade uni, ErpUsuarioUnidade usuuni "+
    " \n  where usuuni.erpUsuarioUnidadePK.usuStCodigo = :usuStCodigo "+
    "  \n  group by uni.uniStCodigo,uni.uniStDescricao "
    + "\n order by uni.uniStCodigo ";
        
         try {
             
             Query query = session.createQuery(sqlQuery);
             query.setString("usuStCodigo", usuStCodigo);
             List list = query.list();
            tx.commit();
            
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                        Object[] tupla = (Object[]) list.get(i);
                        listErpUnidade.add(new ErpUnidade((String) tupla[0], (String) tupla[1]));
                }
            }

             
        }catch(Exception xcp){
            log.error(xcp);
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return listErpUnidade;
    }
    
    public  static  List<ErpMarcas>   grabErpMarcasByExpression(String strQuery,String usuStCodigo,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ErpMarcas> listRetorno = new ArrayList<ErpMarcas>();
        
        String sqlQuery =
         " select mar.marStCodigo,mar.marStDescricao "+
    " \n from 	ErpMarcas mar, ErpUsuarioMarcas usumar "+
    " \n  where usumar.erpUsuarioMarcasPK.usuStCodigo = :usuStCodigo "+
    " \n  and usumar.erpUsuarioMarcasPK.marStCodigo = mar.marStCodigo "+
//    " \n  and mar.marStDescricao like '" + strQuery + "%' "+
     " \n  and mar.marStDescricao like :strQuery "+
//    " \n  or  mar.marStCodigo like '" + strQuery + "%'  "+
    " \n  or  mar.marStCodigo like :strQuery "+
    "  \n  group by mar.marStCodigo,mar.marStDescricao "+
    " \n  order by  mar.marStCodigo,mar.marStDescricao";
        
         try {
             
             Query query = session.createQuery(sqlQuery);
             query.setString("strQuery", strQuery+"%");
             query.setString("usuStCodigo", usuStCodigo);
             List list = query.list();
            tx.commit();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                        Object[] tupla = (Object[]) list.get(i);
                        listRetorno.add(new ErpMarcas((String) tupla[0], (String) tupla[1]));
                }
            }

             
        }catch(Exception xcp){
            log.error(xcp);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return listRetorno;
    }
    
    public  static  List<ErpRegional>   grabErpRegionalByExpression(String strQuery,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ErpRegional> listErpRegional = new ArrayList<ErpRegional>();
        
        
        String sqlQuery =
         "select reg.erpRegionalPK.rgiStLetra  , reg.erpRegionalPK.rgiStCodigo , reg.rgiStDescricao ,reg.rgiStUf "
        +"\n  from ErpRegional reg "
        +"\n  WHERE reg.erpRegionalPK.rgiStCodigo like  :strQuery   " 
        +"\n  or reg.rgiStDescricao like  :strQuery " 
        +"\n  group by reg.erpRegionalPK.rgiStLetra  , reg.erpRegionalPK.rgiStCodigo , reg.rgiStDescricao ,reg.rgiStUf  ";
        
        
        
         try {
             
             Query query = session.createQuery(sqlQuery);
             query.setString("strQuery", strQuery+"%");
             
             
             List list = query.list();
            tx.commit();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                        Object[] tupla = (Object[]) list.get(i);
                        listErpRegional.add(new ErpRegional(new ErpRegionalPK((String) tupla[0], (String) tupla[1]), (String) tupla[2],(String) tupla[3]));
                }
            }
             
             
        }catch(Exception xcp){
            log.error(xcp);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return listErpRegional;
    }
    
    public  static  List<ErpEstabelecimento>   grabErpEstabelecimentoByExpression(String strLike,ErpRegional erpRegional,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ErpEstabelecimento> listErpEstabelecimento = new ArrayList<ErpEstabelecimento>();
        
         String sqlQuery =
         "select est.erpEstabelecimentoPK.estStCodigo  ,est.estStDescricao"
        +"\n  from ErpEstabelecimento est "
        +"\n  WHERE est.erpEstabelecimentoPK.rgiStLetra = :rgiStLetra "
        +"\n and est.erpEstabelecimentoPK.rgiStCodigo = :rgiStCodigo "
//        +"\n or est.estStDescricao like '%" + strLike + "%' "
//        +"\n or est.erpEstabelecimentoPK.estStCodigo like '%" + strLike + "%' "
        +"\n or est.estStDescricao like :strLike  "
        +"\n or est.erpEstabelecimentoPK.estStCodigo like :strLike "
        +"\n  group by est.erpEstabelecimentoPK.estStCodigo  ,est.estStDescricao ";
        
        
        
         try {
             
             Query query = session.createQuery(sqlQuery);
             query.setString("rgiStLetra", erpRegional.getErpRegionalPK().getRgiStLetra());
             query.setString("rgiStCodigo", erpRegional.getErpRegionalPK().getRgiStCodigo());
             query.setString("strLike", "%"+strLike+"%");
             
             List list = query.list();
            tx.commit();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                        Object[] tupla = (Object[]) list.get(i);
                        listErpEstabelecimento
                                .add(
                                new ErpEstabelecimento(
                                new ErpEstabelecimentoPK(erpRegional.getErpRegionalPK().getRgiStLetra(),erpRegional.getErpRegionalPK().getRgiStCodigo() ,(String)tupla[0]),(String)tupla[1] ));
                }
            }
             
             
        }catch(Exception xcp){
            log.error(xcp);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return listErpEstabelecimento;
    }
    
    public  static  List<ErpCcusto>   grabErpCcustoByExpression(String strQuery,String usuStCodigo,String estStCodigo,String uniStCodigo,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ErpCcusto> listRetorno = new ArrayList<ErpCcusto>();
        
        String sqlQuery =
         " select cc.ccuStCodigo,cc.ccuStDescricao "+
    " \n from 	ErpCcusto cc, ErpUsuarioccu ucc "+
    " \n  where ucc.erpUsuarioccuPK.usuStCodigo = :usuStCodigo "+
    " \n  and ucc.erpUsuarioccuPK.ccuStCodigo = cc.ccuStCodigo "+
    " \n  and cc.ccuStAtivo = 'S' "+
    " \n  and cc.estStCodigo = :estStCodigo "+
    " \n  and cc.uniStCodigo = :uniStCodigo "+
//    " \n  or  cc.ccuStCodigo like '" + strQuery + "%'  "+
//    " \n  or cc.ccuStDescricao like '" + strQuery + "%' "+
      " \n  or  cc.ccuStCodigo like :strQuery "+
    " \n  or cc.ccuStDescricao like :strQuery "+
                
                
    "  \n  group by cc.ccuStCodigo,cc.ccuStDescricao ";
//    " \n  order by  cc.ccuStCodigo,cc.ccuStDescricao";
        
         try {
             
             Query query = session.createQuery(sqlQuery);
             query.setString("usuStCodigo", usuStCodigo);
             query.setString("estStCodigo", estStCodigo);
             query.setString("uniStCodigo", uniStCodigo);
             query.setString("strQuery", strQuery+"%");
             
//             query.setMaxResults(15);
             List list = query.list();
            tx.commit();
            
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                        Object[] tupla = (Object[]) list.get(i);
                        listRetorno.add(new ErpCcusto((String) tupla[0], (String) tupla[1]));
                }
            }

             
        }catch(Exception xcp){
            log.error(xcp);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return listRetorno;
    }
     
    public  static  List<ErpItem>   grabErpItemByExpression(String strQuery,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ErpItem> listErpItem = new ArrayList<ErpItem>();
        
        
        String sqlQuery =
         "select item.itmStCodigo  , item.itmStDescricao "
        +"\n  from ErpItem item "
//        +"\n  WHERE item.itmStCodigo like '" + strQuery + "%' "
//        +"\n  or item.itmStDescricao like '%" + strQuery + "%' "
        +"\n  WHERE item.itmStCodigo like :strQuery "
        +"\n  or item.itmStDescricao like :strQueryDesc "        
        +"\n  group by item.itmStCodigo  , item.itmStDescricao";
        
        
        
        
         try {
             
             Query query = session.createQuery(sqlQuery);
             query.setString("strQuery", strQuery+"%");
             query.setString("strQueryDesc", "%"+strQuery+"%");
             
             List list = query.list();
            tx.commit();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                        Object[] tupla = (Object[]) list.get(i);
                        listErpItem.add(new ErpItem((String) tupla[0], (String) tupla[1]));
                }
            }
             
             
        }catch(Exception xcp){
            log.error(xcp);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return listErpItem;
    }
    
    public  static  List<ErpOrigem>   grabErpOrigemByExpression(String strQuery,String uniStCodigo,String strDbName){
        Session session = OracleHelper.getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ErpOrigem> listErpOrigem = new ArrayList<ErpOrigem>();
        
        
        String sqlQuery =
         "select ori.erpOrigemPK.oriStCodigo , ori.erpOrigemPK.uniStCodigo  , ori.oriStDescricao "
        +"\n  from ErpOrigem ori "
//        +"\n  WHERE ori.erpOrigemPK.oriStCodigo like '" + strQuery + "%' "
         +"\n  WHERE ori.erpOrigemPK.oriStCodigo like :strQuery "
        +"\n  and ori.erpOrigemPK.uniStCodigo = :uniStCodigo"
//        +"\n  or ori.oriStDescricao like '" + strQuery + "%' "
        +"\n  or ori.oriStDescricao like :strQuery  "        
        +"\n  group by ori.erpOrigemPK.oriStCodigo , ori.erpOrigemPK.uniStCodigo  , ori.oriStDescricao";
        
         try {
             
             Query query = session.createQuery(sqlQuery);
             query.setString("uniStCodigo", uniStCodigo);
             query.setString("strQuery", strQuery+"%");
             
             List list = query.list();
             
            tx.commit();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                        Object[] tupla = (Object[]) list.get(i);
                        listErpOrigem.add(new ErpOrigem(new ErpOrigemPK((String) tupla[0], (String) tupla[1]), (String) tupla[2]));
                }
            }
             
             
        }catch(Exception xcp){
            log.error(xcp);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return listErpOrigem;
    }
    
    
}
