/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hibernate.utils;

//import br.com.facesbeans.AccessDetails;
//import br.com.facesbeans.ExameBean;
//import br.com.facesbeans.LabPacienteBean;
//import br.com.facesbeans.MaterialBean;
import br.com.hibernate.entities.*;
//import br.com.oracleconnector.OracleConnector;
//import br.com.oracleconnector.StaticQuerys;
import br.com.utils.tipstricks.*;
//import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

/**
 *
 * @author eros
 */
public class OracleHelper {

    static protected Logger log = Logger.getLogger("logs4.tmlab");
//  static public    List<MaterialBean>  listMaterialBeans = new ArrayList<MaterialBean>();
//    static Session session = null;
//    static  Transaction tx = null;

    /**
     *
     *
     * @return a new Session if session is null or a session if session is not null
     */
    public static Session getSessionDude(String strDbName) {
        Session session = null;
        Transaction tx = null;

        if (session == null || !session.isOpen()) {
//            return session = SessionFactoryOracle.getCurrentSession4Faces();
                        return session = SessionFactoriByDBName.getCurrentSession4FacesByDbName(strDbName);
        } else {
            return session;
        }
    }

    /**
     *
     * @param clazz
     * @param id
     * @return Object
     */
    public static Object getObject(Class clazz, long id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;

    }

    /**
     *
     * @param clazz
     * @param id
     * @return Object
     */
    public static Object getObject(Class clazz, String id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return obj;
    }

    /**
     *
     * @param clazz
     * @param id
     * @return Object
     */
    public static Object getObject(Class clazz, Object idPk,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, (Serializable) idPk);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }

    /**
     *
     * @param clazz
     * @param id
     * @return List<Object>
     */
    public static List getListObject(Class clazz,String strDbName) {

        Session session = getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        List result;


        try {
            Criteria criteria = session.createCriteria(clazz);
            result = criteria.list();
            tx.commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;
    }

    /**
     *
     * @param classBean
     * @param strKey
     * @param value
     * @return a first Object from a List of obejcts
     */
    static public Object getObjectByKey(Class classBean, String strKey, Object value,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List result = null;
        Object obj = null;
        try {


            Criteria criteria = session.createCriteria(classBean);

            if (strKey != null) {
                criteria.add(Restrictions.eq(strKey, value));
            }
            result = criteria.list();
            tx.commit();


            if (result != null && result.size() > 0) {
                obj = result.get(0);
            }



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }

    /**
     *
     * @param classBean
     * @param strKey
     * @param value
     * @return a List of obejcts
     */
    static public java.util.List getListOfObjectByKey(Class classBean, String strKey, Object value,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List result = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(classBean);

            if (strKey != null) {
                criteria.add(Restrictions.eq(strKey, value));
            }
            result = criteria.list();

            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    static public java.util.List getListOfObjectByKeyEq(Class classBean, String strKey, Object value, String orderByField, boolean orderBy,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List result = null;
        try {

            if (strKey != null) {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                Criteria criteria = session.createCriteria(classBean);

                criteria.add(Restrictions.eq(strKey, value));
//                criteria.add(Restrictions.isNotNull(strKey));
                if (orderBy) {
                    criteria.addOrder(Order.asc(orderByField));
                } else {
                    criteria.addOrder(Order.desc(orderByField));
                }
                tx.commit();

                result = criteria.list();
            }



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }

    /**
     *
     * @param obj save a obj
     *
     */
    public static void saveObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    public static Object saveObjectReturn(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return obj;

    }

    /**
     *
     * @param save a list of objects
     */
    public static void saveObjectList(List list,String strDbName) {
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            for (Object obj : list) {
                session.save(obj);
            }
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    /**
     *
     * @param obj save or update a obj
     *
     */
    public static void saveOrUpdateObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    /**
     *
     * @param save or update a list of objects
     */
    public static void saveOrUpdateObjectList(List list,String strDbName) {

        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            for (Object obj : list) {
                session.saveOrUpdate(obj);
            }
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    /**
     *
     * @param update a obj 
     *
     */
    public static void updateObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    /**
     *
     * @param update a obj and return the same
     *
     */
    public static Object updateObjectReturnObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            session.update(obj);
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return obj;
    }

    /**
     *
     * @param save a list of objects
     */
    public static void updateObjectList(List list,String strDbName) {

        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            for (Object obj : list) {
                session.update(obj);
            }
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    /**
     *
     * @param update a list of LabDetalheRequisicao using hql
     */
    public static void updateListLabDetalheRequisicao(List<LabDetalheRequisicao> list,String strDbName) {
        Session session = null;
        Transaction tx = null;

        try {
            if (list != null && list.size() > 0) {
                session = getSessionDude(strDbName);
                tx = session.beginTransaction();
                String hql = "update"
                        + " LabDetalheRequisicao "
                        + " set "
                        + "legStCodigo = :legStCodigo ,"
                        + "legStCodigoFat = :legStCodigoFat"
                        + " where "
                        + "derInCodigo=:derInCodigo";

                for (LabDetalheRequisicao ldr : list) {
                    Query query = session.createQuery(hql);
                    query.setString("legStCodigo", ldr.getLegStCodigo());
                    query.setString("legStCodigoFat", ldr.getLegStCodigoFat());
                    query.setLong("derInCodigo", ldr.getDerInCodigo());
                    query.executeUpdate();
                }
                tx.commit();
            }

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    /**
     *
     * @param obj delete object
     */
    public static void deleteObject(Object obj,String strDbName) {
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    /**
     *
     * @param delete a list of objects
     */
    public static void deleteObjectList(List list,String strDbName) {

        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            for (Object obj : list) {
                session.delete(obj);
            }
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< tmlab specific >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    /**
     *
     * @return a List of only two itens [0,1], 0 position 0
     * being a LabRequisicao obj an position 1 being a LabPaciente
     * based on ra and sus number
     */
    static public List getFirstMatchPacAndRequisicao(Long ra, Long sus,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List finalResult = null;
        LabRequisicao lr = null;
        LabPaciente lp = null;
        List result = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            lr = (LabRequisicao) OracleHelper.getObject(LabRequisicao.class, ra,strDbName);

            if (ra != null) {
                Long susFromLR = lr.getPacInCodigo().getPacInCodSUS();
                lp = lr.getPacInCodigo();
                // System.out.println(lp.getPacStNome()+" : "+lp.getPacStEstado());
                if (susFromLR == sus) {

                    //System.out.println("Everything matchs dude");
                    if (lp != null) {
                        finalResult = new ArrayList();
                        finalResult.add(lr);
                        finalResult.add(lp);

                    }

                }

            }

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return finalResult;

    }

    /**
     *
     * @return a List of only two itens [0,1], 0 position 0
     * being a LabRequisicao obj an position 1 being a LabPaciente
     * based on ra and pac number
     */
    static public List getFirstMatchPac(Long ra, Long pac,String strDbName) {


        Session session = null;
        Transaction tx = null;
        List finalResult = null;
        LabRequisicao lr = null;
        LabPaciente lp = null;


        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            lr = (LabRequisicao) OracleHelper.getObject(LabRequisicao.class, ra,strDbName);

            if (ra != null) {
                Long pacCodigoFromLR = lr.getPacInCodigo().getPacInCodigo();
                //System.out.println(lr.getPacInCodigo().getPacInCodigo());
                //System.out.println(pac);
                if (pacCodigoFromLR.equals(pac)) {
                    lp = lr.getPacInCodigo();
                    //System.out.println(lp.getPacStNome()+" : "+lp.getPacInCodigo());
                    // System.out.println("Everything matchs dude");
                    if (lp != null) {
                        finalResult = new ArrayList();
                        finalResult.add(lr);
                        finalResult.add(lp);

                    }


                }

            }

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return finalResult;
    }

    /**
     *@return a LabAgenda based on Object class and LabAgendaPK object.
     */
    public static LabAgenda getLabAgendaByLabAgendaPK(Class clazz, LabAgendaPK id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
            return (LabAgenda) obj;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    /**
     *@return a LabAgendaPaceinte based on Object class and LabAgendaPacientePK object.
     */
    public static LabAgendaPacienteExame getLabAgendaPacienteExameByLabAgendaPacienteExamePK(Class clazz, LabAgendaPacienteExamePK id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (LabAgendaPacienteExame) obj;

    }

    /**
     *@return a LabColetor based on Object class and LabColetorPK object.
     */
    public static LabColetor getLabColetorByLabColetorPK(Class clazz, LabColetorPK id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (LabColetor) obj;
    }

    /**
     *@return a LabLocal based on Object class and LabLocalPK object.
     */
    public static LabLocal getLabLocalByLabLocalPK(LabLocalPK id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(LabLocal.class, id);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (LabLocal) obj;
    }

    /**
     *@return a LabOrigem based on Object class and LabOrigemPK object.
     */
    public static LabOrigem getLabOrigemByLabOrigemPK(Class clazz, LabOrigemPK id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (LabOrigem) obj;
    }

    /**
     *@return a LabRegras based on Object class and LabRegrasPK object.
     */
    public static LabRegras getLabRegrasByLabRegrasPK(Class clazz, LabRegrasPK id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (LabRegras) obj;
    }

    /**
     *@return a LabRequisicao based pacInCodigo
     */
    public static LabRequisicao getLastLabRequisicao(String pacInCodigo,String strDbName) {

        Session session = null;///getSessionDude();//sessionFactory.getCurrentSession();
        Transaction tx = null;///session.beginTransaction();
        LabRequisicao lr = null;
        Long l = null;
        if (pacInCodigo.replaceAll("\\D", "").length() > 4) {
            l = new Long(pacInCodigo.replaceAll("\\D", ""));
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabRequisicao l where l.pacInCodigo = :pacInCodigo");
                q.setLong("pacInCodigo", l);
                tx.commit();
                if (q.list().size() > 0) {
                    lr =  (LabRequisicao) q.list().get(0);
                }

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return lr;
    }

    /**
     *@return a LabResultados based derInCodigo
     */
    public static List<LabResultados> getListLabResultados(Long derInCodigo,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List<LabResultados> result = null;

        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            org.hibernate.Query q = session.createQuery("from LabResultados l where l.derInCodigo = :derInCodigo and res_st_ingresso is not NULL  order by derInValidadeRes asc ");
            q.setLong("derInCodigo", derInCodigo);
            //q.setMaxResults(1);
            tx.commit();
            result = q.list();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }

    public static List<LabResultados> getListLabResultadosCriteria(Long derInCodigo,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List<LabResultados> result = null;

        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(LabResultados.class);
            criteria.add(Restrictions.eq("derInCodigo", derInCodigo));


            org.hibernate.Query q = session.createQuery("from LabResultados l where l.derInCodigo = :derInCodigo ");
            q.setLong("derInCodigo", derInCodigo);
            tx.commit();
            result = q.list();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;
    }

    /**
     *@return a LabSistema based on Object class and LabSistemaPK object.
     */
    public static LabSistema getLabSistemaByLabSistemaPK(Class clazz, LabSistemaPK id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
            
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (LabSistema) obj;
    }

    /**
     *@return a LabAgendaLocal based on Object class and LabAgendaLocalPK object.
     */
    public static LabAgendaLocal getLabAgendaLocalByLabAgendaLocalPK(Class clazz, LabAgendaLocalPK id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (LabAgendaLocal) obj;
    }

    /**
     *@return a LabSolicitante based on Object class and LabSolicitantePK object.
     */
    public static LabSolicitante getLabSolicitanteByLabSolicitantePK(Class clazz, LabSolicitantePK id,String strDbName) {

        Session session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Object obj = null;
        try {
            obj = session.get(clazz, id);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return (LabSolicitante) obj;
    }

    /**
     *@return a first position of list LabPaciente based on RG and CPF .
     * no index for CPF create don't use it.
     */
    public static LabPaciente getLabPacienteByCPF_RG(String cpf, String rg,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List list = new ArrayList();
        List result = null;
        LabPaciente lp = null;
        if (cpf.trim() != null && rg.trim() != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();
                org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStRG = :rg and  l.pacStCPF = :cpf ");
                q.setString("cpf", cpf.trim().replaceAll("\\D", ""));
                q.setString("rg", rg.trim().toUpperCase());

                result = q.list();
                tx.commit();

                if (result != null && result.size() > 0) {
                    lp =  (LabPaciente) result.get(0);
                }

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return lp;
        }



        return null;

    }

    public static LabUsuario getLabUsuario(String login, String senha,String strDbName) {

        String l;
        String s;
        Session session = null;
        Transaction tx = null;
        LabUsuario lu = null;

        List result = null;

        if (login.trim() != null && senha.trim() != null) {

            l = login.trim().toUpperCase();
            s = senha.trim().toUpperCase();


            try {

                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(LabUsuario.class);
                criteria.add(Restrictions.eq("usuStCodigo", login));
                criteria.add(Restrictions.eq("usuStSenha", senha));
                criteria.add(Restrictions.eq("usuChAtivo", "S"));

                result = criteria.list();
                tx.commit();

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            lu =  (LabUsuario) result.get(0);
        }
        return lu;

    }

    /**
     *@return a first position of list LabPaciente based on RG  .
     */
    public static LabPaciente getLabPacienteByRG(String rg,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List result = null;

        if (rg.trim() != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();
                org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStRG = :rg");
                q.setString("rg", rg.trim().toUpperCase());

                result = q.list();
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            return (LabPaciente) result.get(0);
        }

        return null;

    }

    /**
     *@return a first position of list LabPaciente based on pacInCodSus .
     */
    public static LabPaciente getLabPacienteBySUS(String sus,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List result = null;
        sus = sus.replaceAll("\\D", "").trim();




        if (sus != null && sus.length() > 0) {
            Long codigoSus = new Long(sus);

            if (codigoSus != null) {
                try {
                    session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                    tx = session.beginTransaction();
                    org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacInCodSUS = :sus");

                    q.setLong("sus", codigoSus);

                    result = q.list();
                    tx.commit();



                } finally {
                    if (session != null && session.isOpen()) {
                        session.close();
                    }
                }
            }

        }

        if (result != null && result.size() > 0) {
            return (LabPaciente) result.get(0);
        }

        return null;

    }

    /**
     *@return a first position of list LabPaciente based on CPF .
     * no index create don't use it.
     */
    public static LabPaciente getLabPacienteByCPF(String cpf,String strDbName) {

        List result = null;
        List result2 = null;
        Session session = null;
        Transaction tx = null;
        LabPaciente labPaciente = null;

        if (cpf != null && cpf.trim() != null && cpf.replaceAll("\\D", "").length() > 5) {
            String cpf2 = cpf.replaceAll("\\D", "");
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();
                org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStCPF = :cpf");
                q.setString("cpf", cpf2);
                // q.setString("cpf", cpf.trim());

                result = q.list();


                if (result != null && result.size() > 0) {
                    labPaciente =  (LabPaciente) result.get(0);
                } else {
                    org.hibernate.Query q2 = session.createQuery("from LabPaciente l where l.pacStCPF = :cpf" ) ;
                    q2.setString("cpf", Cpf.formatingCpf(cpf2));
                    result2 = q2.list();

                }

                if (result2 != null && result2.size() > 0) {
                    labPaciente =  (LabPaciente) result2.get(0);
                }
                
                tx.commit();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        return labPaciente;

    }

    /**
     *@return a first position of list LabRequisicao based on req .
     * no index create don't use it.
     */
    public static LabRequisicao getLabRequisicaoByReq(String req,String strDbName) {

        List result = null;
        Session session = null;
        Transaction tx = null;

        if (req.trim() != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();
                org.hibernate.Query q = session.createQuery("from LabRequisicao l where l.reqStCodigo =  :reqStCodigo ");
                q.setString("reqStCodigo", req);
                result = q.list();
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            return (LabRequisicao) result.get(0);
        }

        return null;

    }

    /**
     *@return a first position of list LabRequisicao based on req .
     * no index create don't use it.
     */
    public static LabRequisicao getLabRequisicaoByReq(String req, int minDate, LabUnidade lu,String strDbName) {

        List result = null;
        Session session = null;
        Transaction tx = null;

        if (req.trim() != null) {
            try {
                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();
                cal1.add(Calendar.DAY_OF_YEAR, minDate);
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();
                Criteria criteria = session.createCriteria(LabRequisicao.class);
                criteria.add(Restrictions.eq("reqStCodigo", req.toUpperCase()));
                criteria.add(Restrictions.eq("uniStCodigo", lu));
                criteria.add(Expression.between("reqDtCadastro", cal1.getTime(), cal2.getTime()));
                System.out.println(cal1.getTime() + "       " + cal2.getTime());
                result = criteria.list();
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }


        if (result != null && result.size() > 0) {
            return (LabRequisicao) result.get(0);
        }
        return null;

    }

    /**
     *@return a first position of list LabRequisicao based on req .
     * no index create don't use it.
     */
    public static LabPaciente getLabPacienteByPront(String pront,String strDbName) {

        List result = null;
        pront = pront.trim();
        Session session = null;
        Transaction tx = null;

        if (pront != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();
                org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStProntuario = :pacStProntuario");
                q.setString("pacStProntuario", pront);
                result = q.list();
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }


        if (result != null && result.size() > 0) {
            return (LabPaciente) result.get(0);
        }
        return null;

    }

    /**
     *@return a first position of list LabRequisicao based on req .
     * no index create don't use it.
     */
    public static LabRequisicao getLabRequisicaoByReq(String req, String ano,String strDbName) {

        List result = null;
        Session session = null;
        Transaction tx = null;


        if (req.length() == 10) {
        } else {
            if (req.length() == 8) {
                req = ano.substring(2, 4) + req;
            }
        }

        if (req.trim() != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();
                org.hibernate.Query q = session.createQuery("from LabRequisicao l where l.reqStCodigo = :reqStCodigo ");
                q.setString("reqStCodigo", req.toUpperCase() );
                result = q.list();
                tx.commit();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            return (LabRequisicao) result.get(0);
        }

        return null;

    }

    /**
     *@return a list of LabRequisicao based on pacInCodigo .
     * no index create don't use it.
     */
    public static List<LabRequisicao> getListLabRequisicaoByPacInCodigo(LabPaciente pacInCodigo,String strDbName) {

        List<LabRequisicao> result = null;
        Session session = null;
        Transaction tx = null;



        if (pacInCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabRequisicao l where l.pacInCodigo = :pacInCodigo  order by reqDtCadastro ");
                q.setLong("pacInCodigo", pacInCodigo.getPacInCodigo());

                result = q.list();
                tx.commit();

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            return result;
        }

        return null;

    }

    /**
     *@return a list of LabRequisicao based on pacInCodigo .
     * no index create don't use it.
     */
    public static List<LabDetalheRequisicao> getListLabDetalheRequisicaoByReqStCodigo(String reqStCodigo,String strDbName) {

        List<LabDetalheRequisicao> result = null;
        Session session = null;
        Transaction tx = null;

        if (reqStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabDetalheRequisicao l where l.reqStCodigo = :reqStCodigo order by derInCodigo");
                q.setString("reqStCodigo", reqStCodigo.trim());
                result = q.list();
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {

            for (LabDetalheRequisicao ldr : result) {
                ldr.setSalvoNoDb(true);
            }


            return result;
        }

        return null;

    }

    /**
     *@return a list of LabRequisicao based on  uniStCodigo, oriStCodigo, locStCodigo between dates.
     * no index create don't use it.
     */
    public static List<LabRequisicao> getListLabRequisicaoByDinoQuery(LabUnidade uniStCodigo, LabOrigem oriStCodigo, String locStCodigo, Date dtInicio, Date dtFinal, LabPaciente pacInCodigo, String legStCodigo,String strDbName) {

        List<LabRequisicao> result = null;
        Session session = null;
        Transaction tx = null;

        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();


                Criteria criteria = session.createCriteria(LabRequisicao.class);


                if (pacInCodigo != null) {
                    criteria.add(Restrictions.eq("pacInCodigo", pacInCodigo));
                }
                if (uniStCodigo != null) {
                    criteria.add(Restrictions.eq("uniStCodigo", uniStCodigo));
                }
                if (oriStCodigo != null) {
                    criteria.add(Restrictions.eq("oriStCodigo", oriStCodigo));
                }

                if (legStCodigo != null) {
                    if (legStCodigo.equalsIgnoreCase("A")) {
                        LabLegenda ll = new LabLegenda();
                        ll.setLegStCodigo("L");
                        LabLegenda ll2 = new LabLegenda();
                        ll2.setLegStCodigo("011");
                        criteria.add(Restrictions.or(Property.forName("legStCodigo").eq(ll), Property.forName("legStCodigo").eq(ll2)));
                    } else if (legStCodigo.equalsIgnoreCase("L")) {
                        LabLegenda ll = new LabLegenda();
                        ll.setLegStCodigo("L");
                        criteria.add(Restrictions.eq("legStCodigo", ll));
                    } else if (legStCodigo.equalsIgnoreCase("I")) {
                        LabLegenda ll = new LabLegenda();
                        ll.setLegStCodigo("011");
                        criteria.add(Restrictions.eq("legStCodigo", ll));
                    }

                }





                if (dtInicio != null && dtFinal != null) {


                    //  Calendar cal2 = Calendar.getInstance();
                    //cal2.setTime(dtFinal);

                    //cal2.add(Calendar.DAY_OF_YEAR, 1);
                    //System.out.println("dtInicio: "+dtInicio+"  cal2.getTime(): "+cal2.getTime());
                    criteria.add(Expression.between("reqDtCadastro", dtInicio, dtFinal));//cal2.getTime()));
                }
                if (locStCodigo != null) {
                    criteria.add(Restrictions.like("locStCodigo", locStCodigo));
                }
                criteria.setMaxResults(100);
                criteria.addOrder(Property.forName("reqDtCadastro").desc());
                result = criteria.list();
                tx.commit();




            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result == null) {
            return new ArrayList<LabRequisicao>(10);
        }
        return result;



    }

    /**
     *@return a list of LabRequisicao based on  uniStCodigo, oriStCodigo, locStCodigo between dates.
     * no index create don't use it.
     */
    public static List<LabRequisicao> getListLabRequisicaoByDinoQuery(LabUnidade uniStCodigo, LabOrigem oriStCodigo, String locStCodigo, Date dtInicio, Date dtFinal, LabPaciente pacInCodigo, List<String> listLegStCodigo,String strDbName) {

        List<LabRequisicao> result = null;
        Session session = null;
        Transaction tx = null;

        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();


                Criteria criteria = session.createCriteria(LabRequisicao.class);


                if (pacInCodigo != null) {
                    criteria.add(Restrictions.eq("pacInCodigo", pacInCodigo));
                } else {
                    criteria.add(Restrictions.isNotNull("pacInCodigo"));
                }
                if (uniStCodigo != null) {
                    criteria.add(Restrictions.eq("uniStCodigo", uniStCodigo));
                }
                if (oriStCodigo != null) {
                    criteria.add(Restrictions.eq("oriStCodigo", oriStCodigo));
                }


                if (listLegStCodigo != null && listLegStCodigo.size() > 0) {
                    Disjunction dis = Restrictions.disjunction();
                    for (String str : listLegStCodigo) {
                        LabLegenda ll = new LabLegenda();
                        ll.setLegStCodigo(str);
                        dis.add(Restrictions.eq("legStCodigo", ll));
                    }
                    criteria.add(dis);
                }


                if (dtInicio != null && dtFinal != null) {



                    criteria.add(Expression.between("reqDtCadastro", dtInicio, dtFinal));//cal2.getTime()));
                }
                if (locStCodigo != null) {
                    criteria.add(Restrictions.like("locStCodigo", locStCodigo));
                }
                criteria.setMaxResults(1000);
                criteria.addOrder(Property.forName("reqDtCadastro").desc());
                result = criteria.list();
                tx.commit();




            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result == null) {
            return new ArrayList<LabRequisicao>(10);
        }
        return result;


    }

    public static LabUnidadeMedida getLabUnidadeMedida(String exaStCodigo, String cinStCodigo, String metStCodigo,String strDbName) {

        LabUnidadeMedida lum = null;
        Session session = null;
        Transaction tx = null;
        try {

            if (exaStCodigo != null && cinStCodigo != null && metStCodigo != null) {

                session = getSessionDude(strDbName);
                tx = session.beginTransaction();

                Criteria criteria = session.createCriteria(LabConfigIngresso.class);
                criteria.add(Restrictions.eq("exaStCodigo", exaStCodigo));
                criteria.add(Restrictions.eq("cinStCodigo", cinStCodigo));
                criteria.add(Restrictions.eq("metStCodigo", metStCodigo));
                List<LabConfigIngresso> lLci = criteria.list();
                if (lLci != null && lLci.size() > 0) {
                    LabConfigIngresso lci = lLci.get(0);
                    if (lci != null && lci.getUnmStCodigo() != null) {
                        lum = (LabUnidadeMedida) session.get(LabUnidadeMedida.class, lci.getUnmStCodigo());//( LabUnidadeMedida) OracleHelper.getObject(LabUnidadeMedida.class, lci.getUnmStCodigo()); //

                    }

                }
                tx.commit();

            }


        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return lum;

    }

    /**
     *@return a list of LabRequisicao based on  uniStCodigo, oriStCodigo, locStCodigo between dates.
     * no index create don't use it.
     */
    public static List<LabRequisicao> getListLabRequisicaoByDinoQuerySQL(LabUnidade uniStCodigo, LabOrigem oriStCodigo, String locStCodigo, Date dtInicio, Date dtFinal, LabPaciente pacInCodigo,String strDbName) {

        List<LabRequisicao> result = null;
        Session session = null;
        Transaction tx = null;
        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();
                String query = " from LabRequisicao l where "; //l.uniStCodigo = 'ACL' and reqStCodigo = '0915151515' ";

                if (oriStCodigo != null) {
                    query = query + " l.oriStCodigo = '" + oriStCodigo.getOriStCodigo() + "'  ";
                }

                if (pacInCodigo != null) {
                    query = query + " and l.pacInCodigo = '" + pacInCodigo.getPacInCodigo().toString() + "'";
                }
                if (uniStCodigo != null) {
                    query = query + " and l.uniStCodigo = '" + uniStCodigo.getUniStCodigo() + "'";
                }


                if (locStCodigo != null) {
                    query = query + " and l.locStCodigo = '" + locStCodigo + "'";
                }
                if (dtInicio != null && dtFinal != null) {

                    String DATE_FORMAT = "dd-MMM-yy";
                    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

                    query = query + " and l.reqDtCadastro >= ('" + sdf.format(dtInicio) + "', 'dd-MMM-yy')"
                            + "  and  l.reqDtCadastro <=('" + sdf.format(dtFinal) + "', 'dd-MMM-yy')";
                }

                org.hibernate.Query q = session.createQuery(query);
                q.setMaxResults(1000);
                result = q.list();
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        return result;

    }

    /**
     *@return a Map<LabDetalheRequisicao,LabDetalheRequisicao> of LabRequisicao based on pacInCodigo .
     * no index create don't use it.
     */
    public static Map<LabDetalheRequisicao, LabDetalheRequisicao> getMapLabDetalheRequisicaoByReqStCodigo(String reqStCodigo,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List<LabDetalheRequisicao> result = null;
        Map<LabDetalheRequisicao, LabDetalheRequisicao> map = new HashMap<LabDetalheRequisicao, LabDetalheRequisicao>();




        if (reqStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabDetalheRequisicao l where l.reqStCodigo = '" + reqStCodigo + "' order by derInCodigo");

                // q.setString("cpf", cpf.trim());

                result = q.list();
                tx.commit();

                if (result != null && result.size() > 0) {

                    for (LabDetalheRequisicao ldr : result) {
                        ldr.setSalvoNoDb(true);
                        map.put(ldr, ldr);
                    }
                }

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return map;

    }

    /**
     *@return a list of LabExame based on pacInCodigo .
     * no index create don't use it.
     */
    public static List<LabExame> getListLabExameByPacInCodigo(LabPaciente pacInCodigo,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List<LabRequisicao> listLabRequisicao = null;
        List<LabDetalheRequisicao> listLabDetalheRequisicao = null;
        List<LabExame> listLabExame = null;



        if (pacInCodigo != null) {
            try {
                session = getSessionDude(strDbName);
                tx = session.beginTransaction();

                org.hibernate.Query q =
                        session.createQuery("from LabRequisicao l where l.pacInCodigo = '" + pacInCodigo.getPacInCodigo() + "' ");
                listLabRequisicao = q.list();


                if (listLabRequisicao != null && listLabRequisicao.size() > 0) {
                    //System.out.println(listLabRequisicao.size());
                    for (LabRequisicao lr : listLabRequisicao) {
                        listLabDetalheRequisicao = lr.getListLabDetalheRequisicao();

                        //System.out.println(listLabDetalheRequisicao.size());
                        if (listLabDetalheRequisicao != null && listLabDetalheRequisicao.size() > 0) {
                            listLabExame = new ArrayList<LabExame>();
                            for (LabDetalheRequisicao ldr : listLabDetalheRequisicao) {
                                listLabExame.add(new LabExame(ldr.getExaStCodigo()));
                            }
                        }
                    }
                }
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        return listLabExame;

    }


    public static LabUnidade getLabUnidadeByUniStCodigo(String uniStCodigo,String strDbName) {
        uniStCodigo = uniStCodigo.toUpperCase().trim();
        LabUnidade lu = null;
        Session session = null;
        Transaction tx = null;

        if (uniStCodigo != null && uniStCodigo.length() > 1) {
            try {
                session = getSessionDude(strDbName);
                tx = session.beginTransaction();
                org.hibernate.Query q = session.createQuery("from LabUnidade where uniStCodigo = :uniStCodigo ");
                q.setString("uniStCodigo", uniStCodigo);
                tx.commit();

                List<LabUnidade> list = q.list();
                if (list != null && list.size() > 0) {
                    lu = list.get(0);
                }

            } finally {

                if (session != null && session.isOpen()) {
                    session.close();
                }
            }

        }

        return lu;
    }

    public static List<LabUnidade> getListLabUnidadeOrderByUniStCodigo(String strDbName) {

        Session session = null;
        Transaction tx = null;
        List<LabUnidade> result = null;
        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            org.hibernate.Query q = session.createQuery("from LabUnidade where uniStCodigo != null order by uniStCodigo ");

            tx.commit();

            result = q.list();


        } finally {

            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;
    }

    /**
     *@return a list of LabPaciente based on pacStProntuario .
     * 
     */
    public static List<LabPaciente> getListLabPacienteByProntuario(String prontuario,String strDbName) {


        List<LabPaciente> result = null;
        prontuario = prontuario.trim();
        Session session = null;
        Transaction tx = null;


        if (prontuario != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStProntuario like '" + prontuario + "' ");
                q.setMaxResults(100);


                result = q.list();
                tx.commit();


            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return result;

    }

    /**
     *@return a list of LabPaciente based on pacStProntuario and uniStCodigo.
     *
     */
    public static List<LabPaciente> getListLabPacienteByProntuario_UniStCodigo(LabUnidade uniStCodigo, String prontuario,String strDbName) {


        List<LabPaciente> result = null;
        prontuario = prontuario.trim();
        Session session = null;
        Transaction tx = null;


        if (prontuario != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                if (uniStCodigo != null && prontuario != null) {
                    Criteria criteria = session.createCriteria(LabPaciente.class);
                    if (prontuario != null) {
                        criteria.add(Restrictions.like("pacStProntuario", prontuario));
                    }
                    if (uniStCodigo != null) {
                        criteria.add(Restrictions.like("uniStCodigo", uniStCodigo));
                    }

                    criteria.setMaxResults(100);
                    result = criteria.list();
                    tx.commit();
                }





            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return result;

    }

    /**
     *@return a list of LabPaciente based on pacStNome .
     *
     */
    public static List<LabPaciente> getListLabPacienteByPacStNome(String nome,String strDbName) {


        List<LabPaciente> result = null;
        nome = nome.toUpperCase().trim().replaceAll("[^a-zA-Z&&[\\S]]", "");
        Session session = null;
        Transaction tx = null;


        if (nome != null && nome.length() > 8) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStNome like '" + nome + "%' ");
                q.setMaxResults(100);


                result = q.list();
                tx.commit();


            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }


        return result;

    }

    /**
     *@return a list of LabPaciente based on pacStNome .
     *
     */
    public static List<LabPaciente> getListLabPacienteByPacStNomeUniStCodigo(String nome, String uniStCodigo,String strDbName) {


        List<LabPaciente> result = null;
        nome = nome.toUpperCase().trim().replaceAll("[^a-zA-Z&&[\\S]]", "");
        Session session = null;
        Transaction tx = null;


        if (nome != null && nome.length() > 8) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStNome like '" + nome + "%'  and uniStCodigo = '" + uniStCodigo + "' ");
                q.setMaxResults(50);


                result = q.list();
                tx.commit();

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        return result;

    }

    

    /**
     *@return a list of LabPaciente based on pacStRG .
     *
     */
    public static List<LabPaciente> getListLabPacienteByPacStRG(String rg,String strDbName) {


        List<LabPaciente> result = null;
        rg = rg.toUpperCase().trim();
        Session session = null;
        Transaction tx = null;


        if (rg != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStRG like '" + rg + "' ");
                q.setMaxResults(100);


                result = q.list();
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }



        return result;

    }

    /**
     *@return a list of LabPaciente based on pacStRG and uniStCodigo.
     *
     */
    public static List<LabPaciente> getListLabPacienteByPacStRG_UniStCodigo(LabUnidade uniStCodigo, String pacStRG,String strDbName) {


        List<LabPaciente> result = null;
        Session session = null;
        Transaction tx = null;

        if (pacStRG != null && uniStCodigo != null) {
            try {
                pacStRG = pacStRG.trim();
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                if (uniStCodigo != null && pacStRG != null) {
                    Criteria criteria = session.createCriteria(LabPaciente.class);
                    if (pacStRG != null) {
                        criteria.add(Restrictions.like("pacStRG", pacStRG));
                    }
                    if (uniStCodigo != null) {
                        criteria.add(Restrictions.like("uniStCodigo", uniStCodigo));
                    }
                    criteria.setMaxResults(100);
                    result = criteria.list();
                    tx.commit();
                }



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return result;

    }

    /**
     *@return a list of LabPaciente based on pacStCPF .
     *
     */
    public static List<LabPaciente> getListLabPacienteByPacStCPF(String cpf,String strDbName) {


        List<LabPaciente> result = null;
        cpf = cpf.toUpperCase().trim();
        Session session = null;
        Transaction tx = null;



        if (cpf != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabPaciente l where l.pacStCPF like '" + cpf + "%' ");
                q.setMaxResults(100);


                result = q.list();
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }



        return result;

    }

    /**
     *@return a list of LabPaciente based on pacStCPF and uniStCodigo.
     *
     */
    public static List<LabPaciente> getListLabPacienteByPacStCPF_UniStCodigo(LabUnidade uniStCodigo, String pacStCPF,String strDbName) {


        List<LabPaciente> result = null;
        Session session = null;
        Transaction tx = null;

        if (pacStCPF != null && uniStCodigo != null) {
            try {
                pacStCPF = pacStCPF.trim();
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                if (uniStCodigo != null && pacStCPF != null) {
                    Criteria criteria = session.createCriteria(LabPaciente.class);
                    if (pacStCPF != null) {
                        criteria.add(Restrictions.like("pacStCPF", pacStCPF));
                    }
                    if (uniStCodigo != null) {
                        criteria.add(Restrictions.like("uniStCodigo", uniStCodigo));
                    }
                    result = criteria.list();
                    tx.commit();
                }



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return result;

    }

    /**
     *@return a list of LabPaciente based on pacStCPF .
     *
     */
    public static LabLocal getLabLocalBylocStCodigo_uniStCodigo(String locStCodigo, String uniStCodigo,String strDbName) {


        List<LabLocal> result = null;
        Session session = null;
        Transaction tx = null;


        if (locStCodigo != null && uniStCodigo != null) {

            locStCodigo = locStCodigo.trim().toUpperCase();
            uniStCodigo = uniStCodigo.trim().toUpperCase();

            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabLocal l where l.locStCodigo = :locStCodigo and l.uniStCodigo = :uniStCodigo ");
                q.setString("uniStCodigo", uniStCodigo);
                q.setString("locStCodigo", locStCodigo);
                result = q.list();

                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            return result.get(0);
        }

        return null;

    }

    /**
     *@return a list of LabLocal based on uniStCodigo .
     *
     */
    public static List<LabLocal> getListLabLocalByUniStCodigo(String uniStCodigo,String strDbName) {


        List<LabLocal> result = null;
        uniStCodigo = uniStCodigo.toUpperCase().trim();
        Session session = null;
        Transaction tx = null;


        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabLocal l where l.uniStCodigo like '" + uniStCodigo + "' ");


                result = q.list();
                tx.commit();



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        return result;

    }

    /**
     *@return a list of LabConvenio based on uniStCodigo .
     *
     */
    public static List<LabConvenio> getListLabConvenioByUniStCodigo(String uniStCodigo,String strDbName) {


        List<LabConvenio> result = null;
        List<LabConvenioUnidade> cumList;
        uniStCodigo = uniStCodigo.toUpperCase().trim();
        Session session = null;
        Transaction tx = null;



        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabConvenioUnidade l where l.uniStCodigo = '" + uniStCodigo + "'and l.cunChAtivo = 'S'");


                cumList = q.list();
                tx.commit();

                if (cumList != null && cumList.size() > 0) {
                    result = new ArrayList<LabConvenio>();
                    for (LabConvenioUnidade lcu : cumList) {
                        LabConvenio l = lcu.getConStCodigo();
                        if (l.getConChAtivo() != null && l.getConChAtivo().toString().equalsIgnoreCase("S")) {
                            result.add(l);
                        }

                    }

                }



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
        return result;

    }

    /**
     *@return a list of LabConvenio based on uniStCodigo .
     *
     */
    public static LabConvenio getLabConvenioByUniStCodigoAndConStCodigo(String uniStCodigo, String conStCodigo,String strDbName) {


        List<LabConvenio> result = null;
        List<LabConvenioUnidade> cumList;
        uniStCodigo = uniStCodigo.toUpperCase().trim();
        Session session = null;
        Transaction tx = null;


        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabConvenioUnidade l where l.uniStCodigo = '" + uniStCodigo + "'and l.cunChAtivo = 'S'  and l.conStCodigo = '" + conStCodigo + "'");


                cumList = q.list();
                tx.commit();

                if (cumList != null && cumList.size() > 0) {
                    result = new ArrayList<LabConvenio>();
                    for (LabConvenioUnidade lcu : cumList) {
                        LabConvenio l = lcu.getConStCodigo();
                        if (l.getConChAtivo() != null && l.getConChAtivo().toString().equalsIgnoreCase("S")) {
                            result.add(l);
                        }

                    }

                }



            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            return result.get(0);
        }

        return null;

    }

    /**
     *@return a list of LabRegras based on uniStCodigo and conStCodigo .
     *
     */
    public static List<LabRegras> getListLabRegrasByUniStCodigoAndConStCodigo(String uniStCodigo, String conStCodigo,String strDbName) {


        List<LabRegras> result = null;
        Session session = null;
        Transaction tx = null;



        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabRegras l where l.uniStCodigo = '" + uniStCodigo + "'and l.conStCodigo = '" + conStCodigo + "'");


                result = q.list();
                tx.commit();


            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        return result;

    }

    /**
     *@return a list of LabRegras based on uniStCodigo and conStCodigo .
     *
     */
    public static LabRegras getLabRegrasByUniStCodigoAndConStCodigoAndRegStCodigo(String uniStCodigo, String conStCodigo, String regStCodigo,String strDbName) {


        List<LabRegras> result = null;
        Session session = null;
        Transaction tx = null;

        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabRegras l where l.uniStCodigo = '" + uniStCodigo + "'and l.conStCodigo = '" + conStCodigo + "' and l.regStCodigo = '" + regStCodigo + "' ");


                result = q.list();
                tx.commit();


            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }


        if (result != null && result.size() > 0) {
            return result.get(0);
        }

        return null;

    }

    /**
     *@return a list of LabOrigem based on uniStCodigo.
     *
     */
    public static List<LabOrigem> getListLabOrigemByUniStCodigo(String uniStCodigo,String strDbName) {


        List<LabOrigem> result = null;
        Session session = null;
        Transaction tx = null;



        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabOrigem l where l.uniStCodigo = '" + uniStCodigo + "'");


                result = q.list();
                tx.commit();

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            return result;
        }
        return null;

    }

    /**
     *@return a  LabOrigem based on uniStCodigo and oriStCodigo.
     *
     */
    public static LabOrigem getLabOrigemByUniStCodigo(String uniStCodigo, String oriStCodigo,String strDbName) {


        List<LabOrigem> result = null;
        Session session = null;
        Transaction tx = null;

        if (uniStCodigo != null) {
            try {
                session = getSessionDude(strDbName);
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabOrigem l where l.uniStCodigo = '" + uniStCodigo + "' and l.oriStCodigo = '" + oriStCodigo + "' ");


                result = q.list();
                tx.commit();


            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            return result.get(0);
        }

        return null;

    }

    /**
     *@return a  LabSolicitante based on solStEstado and proStCodigo and solStCodigo.
     *
     */
    public static LabSolicitante getLabSolicitanteBySolStEstado_ProStCodigo_SolStCodigo(String solStEstado, String proStCodigo, String solStCodigo,String strDbName) {


        List<LabSolicitante> result = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            org.hibernate.Query q = session.createQuery("from LabSolicitante l where l.solStEstado = '" + solStEstado + "' and l.proStCodigo = '" + proStCodigo + "'  and l.solStCodigo = '" + solStCodigo + "' ");


            result = q.list();
            tx.commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;

    }

    /**
     *@return a  List LabSolicitante based on solStEstado and proStCodigo and solStCodigo.
     *
     */
    public static List<LabSolicitante> getListLabSolicitanteBySolStEstado_ProStCodigo(String solStEstado, String proStCodigo,String strDbName) {


        List<LabSolicitante> result = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            org.hibernate.Query q = session.createQuery("from LabSolicitante l where l.solStEstado = '" + solStEstado + "'  and l.proStCodigo = '" + proStCodigo + "'  and l.solStCodigo <> '0' ");
            q.setMaxResults(50);


            result = q.list();
            tx.commit();


        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


        if (result != null && result.size() > 0) {
            return result;
        }

        return null;

    }

    /**
     *@return a  List LabSolicitante based on solStEstado.
     *
     */
    public static List<LabSolicitante> getListLabSolicitanteBySolStEstado(String solStEstado,String strDbName) {


        List<LabSolicitante> result = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            org.hibernate.Query q = session.createQuery("from LabSolicitante l where l.solStEstado = '" + solStEstado + "'  ");


            result = q.list();
            tx.commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (result != null && result.size() > 0) {
            return result;
        }
        return null;

    }

    /**
     *@return a  LabColetor based on colStCodigo and uniStCodigo.
     *
     */
    public static LabColetor getLabColetorByColStCodigo_UniStCodigo(String colStCodigo, String uniStCodigo,String strDbName) {


        List<LabColetor> result = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            org.hibernate.Query q = session.createQuery("from LabColetor l where l.colStCodigo = '" + colStCodigo + "' and l.uniStCodigo = '" + uniStCodigo + "'  ");


            result = q.list();
            tx.commit();


        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;

    }

    /**
     *@return a List LabColetor based on  uniStCodigo.
     *
     */
    public static List<LabColetor> getListLabColetorByUniStCodigo(String uniStCodigo,String strDbName) {


        List<LabColetor> result = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            org.hibernate.Query q = session.createQuery("from LabColetor l where l.uniStCodigo = '" + uniStCodigo + "'  ");


            result = q.list();
            tx.commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (result != null && result.size() > 0) {
            return result;
        }
        return null;

    }


    /**
     *@return a List LabExameGrupo based on  exaStCodigo grpStCodigo uniStCodigo.
     *
     */
    public static List<LabExameGrupo> getListLabExameGrupoByExaStCodigo_GrpStCodigo_UniStCodigo(String exaStCodigo, String grpStCodigo, String uniStCodigo,String strDbName) {


        List<LabExameGrupo> result = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            org.hibernate.Query q = session.createQuery("from LabExameGrupo l where l.uniStCodigo = '" + uniStCodigo + "'"
                    + " and l.exaStCodigo = '" + exaStCodigo + "' "
                    + "   and l.grpStCodigo = '" + grpStCodigo + "' ");


            result = q.list();
            tx.commit();


        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (result != null && result.size() > 0) {
            return result;
        }
        return null;

    }

    /**
     *@return a List LabExameGrupo based on  exaStCodigo grpStCodigo uniStCodigo.
     *
     */
    public static List<LabExameGrupo> getListLabExameGrupoByGrpStCodigo_UniStCodigo(String grpStCodigo, String uniStCodigo,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List<LabExameGrupo> result = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            org.hibernate.Query q = session.createQuery("from LabExameGrupo l where l.uniStCodigo = '" + uniStCodigo + "'"
                    + "   and l.grpStCodigo = '" + grpStCodigo + "' ");


            result = q.list();
            tx.commit();


        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (result != null && result.size() > 0) {
            return result;
        }
        return null;

    }

    public static List<LabExameDependente> getListLabExameDependente(String exaStCodigo, String uniStCodigo,String strDbName) {

        List<LabExameDependente> result = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();

            org.hibernate.Query q = session.createQuery("from LabExameDependente l where l.uniStCodigo = '" + uniStCodigo + "'"
                    + "   and l.exaStCodigo = '" + exaStCodigo + "' ");


            result = q.list();
            tx.commit();


        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (result != null && result.size() > 0) {
            return result;
        }
        return null;

    }

  
    /**
     *
     * @param clazz
     * @param uf
     * @return LabEstado
     */
    public static LabEstado getLabEstado(String uf,String strDbName) {

        Session session = null;
        Transaction tx = null;

        List<LabEstado> result = null;

        if (uf != null && uf.trim().length() > 1) {
            try {
                session = getSessionDude(strDbName);
                tx = session.beginTransaction();

                org.hibernate.Query q = session.createQuery("from LabEstado l where l.estStUF ='" + uf.toUpperCase() + "'");

                result = q.list();
                tx.commit();


            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }

        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    public static List<LabConfigIngresso> getListLabConfiruraConfigIngressos(String exaStCodigo, String metStCodigo, Date emvDtValidade,String strDbName) {

        Session session = getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        List result = null;

        try {

            Criteria criteria = session.createCriteria(LabConfigIngresso.class);
            criteria.add(Restrictions.eq("exaStCodigo", exaStCodigo));
            criteria.add(Restrictions.eq("metStCodigo", metStCodigo));
            criteria.add(Restrictions.eq("emvDtValidade", emvDtValidade));

            result = criteria.list();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;

    }

    /**
     *
     * @param clazz
     * @param id
     * @return String
     */
    public static String getPacienteNextValue(String strDbName) {


        Session session = getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        List result;


        try {
            org.hibernate.Query query = session.createSQLQuery("SELECT NEXT VALUE FOR PPACIENTE FROM RDB$DATABASE");//createQuery("EXECUTE PROCEDURE STATUSAMOSTRAPERFIL_NEW 2010102748588602,001,null");
            result = query.list();
            tx.commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (result != null) {
            return result.get(0).toString();
        }

        return null;

    }

    static public LabConfigIngresso getLabConfigIngresso(String cinStCodigo, Date emvDtValidade, String exaStCodigo, String metStCodigo,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List<LabConfigIngresso> result = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();


            Criteria criteria = session.createCriteria(LabConfigIngresso.class);

            if (cinStCodigo != null) {
                criteria.add(Restrictions.eq("cinStCodigo", cinStCodigo));
            }
            if (emvDtValidade != null) {
                criteria.add(Restrictions.eq("emvDtValidade", emvDtValidade));
            }
            if (exaStCodigo != null) {
                criteria.add(Restrictions.eq("exaStCodigo", exaStCodigo));
            }
            if (metStCodigo != null) {
                criteria.add(Restrictions.eq("metStCodigo", metStCodigo));
            }
            tx.commit();

            result = criteria.list();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        if (result != null && !result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }


    }

    static public List<Object> getListObjectsByOrs(Class myClass, String strFieldName, List listArgs,String strDbName) {

        Session session = null;
        Transaction tx = null;

        List result = null;
        if (listArgs != null && listArgs.size() > 0) {


            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();


                Criteria criteria = session.createCriteria(myClass);

                Disjunction disj;
                Property property = Property.forName(strFieldName);


                if (listArgs != null && listArgs.size() > 0) {
                    disj = Restrictions.disjunction();
                    for (Object strArgs : listArgs) {
                        disj.add(property.eq(strArgs));
                    }
                    tx.commit();
                    result = criteria.add(disj).list();

                }

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }


        }
        return result;
    }

    
    
    static public List getListObjectsByAnds(Class myClass, Map<String, Object> mapArgs, int intMaxresult ,String strKeyOrderBy, boolean blOrderBy,String strDbName) {
        List result = null;
        Session session = null;
        Transaction tx = null;

        if (mapArgs != null && mapArgs.size() > 0) {

            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();


                Criteria criteria = session.createCriteria(myClass);
                Iterator iter = mapArgs.entrySet().iterator();

                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
                }
                
                if(blOrderBy){
                    criteria.addOrder(Order.asc(strKeyOrderBy));
                }else{
                    criteria.addOrder(Order.desc(strKeyOrderBy));
                }
                
                criteria.setMaxResults(intMaxresult);
                
                tx.commit();
                result = criteria.list();

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }

        }
        return result;

    }
    
    
    
    static public List getListObjectsByAnds(Class myClass, Map<String, Object> mapArgs,String strDbName) {
        List result = null;
        Session session = null;
        Transaction tx = null;

        if (mapArgs != null && mapArgs.size() > 0) {

            try {
                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();


                Criteria criteria = session.createCriteria(myClass);
                Iterator iter = mapArgs.entrySet().iterator();

                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
                }

                tx.commit();
                result = criteria.list();

            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }

        }
        return result;

    }

    static public List getListObjectsByAnds_Ors(Class myClass, Map<String, Object> mapArgsAnds, String strFieldName, List listArgsOrs,String strDbName) {

        List resutl = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(myClass);

            if (mapArgsAnds != null && mapArgsAnds.size() > 0) {

                Iterator iter = mapArgsAnds.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
                }
            }

            if (listArgsOrs != null && listArgsOrs.size() > 0) {
                Disjunction disj;
                Property property = Property.forName(strFieldName);


                if (listArgsOrs != null && listArgsOrs.size() > 0) {
                    disj = Restrictions.disjunction();
                    for (Object strArgs : listArgsOrs) {
                        disj.add(property.eq(strArgs));
                    }
                    resutl = criteria.add(disj).list();
                }
                tx.commit();
                if (resutl == null) {
                    resutl = criteria.list();
                }

            }

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return resutl;
    }

    static public List getListObjectsByAnds_Ors_Dates(Class myClass, Map<String, Object> mapArgsAnds, String strFieldNameOrs, List listArgsOrs, String strDateFieldName, Date dtStart, Date dtEnd,String strDbName) {

        Session session = null;
        Transaction tx = null;
        List<LabConfigIngresso> result = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(myClass);


            if (dtStart != null && dtEnd != null) {

                if (strDateFieldName != null) {
                    if (dtEnd.after(dtStart)) {
//                         System.out.println("Restrictions.between");
                        criteria.add(Expression.between(strDateFieldName, dtStart, dtEnd));
                    } else if (dtEnd.equals(dtStart)) {
                        criteria.add(Restrictions.eq(strDateFieldName, dtStart));
                    } else if (dtEnd.before(dtStart)) {
                        criteria.add(Restrictions.eq(strDateFieldName, dtStart));
                    }
                    criteria.addOrder(Order.asc(strDateFieldName));

                }

            }

            if (mapArgsAnds != null && mapArgsAnds.size() > 0) {

                Iterator iter = mapArgsAnds.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Object> pair = (Map.Entry<String, Object>) iter.next();
                    criteria.add(Restrictions.eq(pair.getKey(), pair.getValue()));
                }
            }



            if (listArgsOrs != null && listArgsOrs.size() > 0 && strFieldNameOrs != null) {
                Disjunction disj;
                Property property = Property.forName(strFieldNameOrs);

                if (listArgsOrs != null && listArgsOrs.size() > 0) {
                    disj = Restrictions.disjunction();
                    for (Object strArgs : listArgsOrs) {
                        disj.add(property.eq(strArgs));
                    }
                    criteria.setMaxResults(100000);
                    return criteria.add(disj).list();
                }

            }

            criteria.setMaxResults(100000);

            tx.commit();
            result = criteria.list();



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;
    }

    static public List getListObjectsByAnds_Ors_Dates(Class myClass,
            Map<String, Object> mapArgsAnds,
            Map<String, List> mapArgsOrs,
            String strDateFieldName, Date dtStart, Date dtEnd,String strDbName) {
        Session session = null;
        Transaction tx = null;

        List<LabConfigIngresso> result = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(myClass);


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
                tx.commit();
                result = criteria.list();
            }



            if (result == null) {
                tx.commit();
                result = criteria.list();
            }



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }
    
    static public List getListObjectsByAnds_Ors_Dates(Class myClass,
            Map<String, Object> mapArgsAnds,
            Map<String, List> mapArgsOrs,
            String strDateFieldName, Date dtStart, Date dtEnd,int intMaxResults,String strDbName) {
        Session session = null;
        Transaction tx = null;

        List result = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(myClass);


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



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }
    
    

    public static List<LabUnidade> getListLabUnidadeByLabUsuario(LabUsuario labUsuario,String strDbName) {
        List<LabUnidade> listLabUnidades = null;
        if (labUsuario != null) {
            List<LabUsuarioUnidade> listLabUsuarioUnidades = (List<LabUsuarioUnidade>) OracleHelper.getListOfObjectByKeyEq(LabUsuarioUnidade.class, "usuStCodigo", labUsuario, "uniStCodigo", true,strDbName);
            if (listLabUsuarioUnidades != null && listLabUsuarioUnidades.size() > 0) {
                listLabUnidades = new ArrayList<LabUnidade>(listLabUsuarioUnidades.size());

                for (LabUsuarioUnidade luu : listLabUsuarioUnidades) {
                    LabUnidade lu = (LabUnidade) OracleHelper.getObject(LabUnidade.class, luu.getUniStCodigo(),strDbName);
                    if (lu != null) {
                        listLabUnidades.add(lu);
                    }
                }

            }
        }
        return listLabUnidades;
    }

    public static Map<LabRequisicao, LabRequisicao> getListLabRequisicaoTest(String strDbName) {
        Map<LabRequisicao, LabRequisicao> map = new HashMap<LabRequisicao, LabRequisicao>();
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            System.out.println("Before  Iterator");
            Iterator results = session.createQuery(
                    "select  ldr.LabRequisicao  from LabDetalheRequisicao as ldr " //, LabDetalheRequisicao as ldr"
                    + "where ldr.reqStCodigo = '1139480543' ") //                                    + "and ldr.reqStCodigo = '1139480543' " )
                    .list().iterator();
            System.out.println("After  Iterator");
//                                    while ( results.hasNext() ) {
//                                        Object[] row = (Object[]) results.next();
//                                        LabRequisicao lr = (LabRequisicao) row[0];
//                                        LabDetalheRequisicao ldr = (LabDetalheRequisicao) row[1];
//                                        
//                                        if(map.containsKey(lr)){
//                                            map.get(lr).getListLabDetalheRequisicaoFiltrado().add(ldr);
//                                        }else{
//                                            lr.setListLabDetalheRequisicaoFiltrado(new ArrayList<LabDetalheRequisicao>());
//                                            map.put(lr, lr);
//                                        }
//
//                                    }
            tx.commit();
            return map;

        } catch (HibernateException exp) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return map;
    }

    public static List getListTest(String strDbName) {

        List result = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(LabDetalheRequisicao.class);

            criteria.add(Restrictions.eq("reqStCodigo", "fodase")).createCriteria("reqInCodigo").add(Restrictions.eq("locStCodigo", "seilamesml"));


            tx.commit();
            result = criteria.list();




        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;
    }

    static public java.util.List getListOfObjectByDate(Class classBean, String strKey, Object value, String strKeyDt, Date dt, boolean blBiggerOrLess,String strDbName) {


        List result = null;
        Session session = null;
        Transaction tx = null;

        try {

            if (strKey != null) {

                session = getSessionDude(strDbName);//sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                Criteria criteria = session.createCriteria(classBean);
                criteria.add(Restrictions.eq(strKey, value));
                criteria.add(Expression.ge(strKeyDt, dt));
                criteria.addOrder(Order.desc(strKey));
                tx.commit();

                result = criteria.list();
            }



        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return result;

    }

    public static String getIdByNextValueStringSQL(String strSql,String strDbName) {

        Session session = getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();
        String strResult = null;
        List result;

        try {
            org.hibernate.Query query = session.createSQLQuery(strSql);
            result = query.list();
            tx.commit();
            if (result != null) {
                strResult = result.get(0).toString();
            }


        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return strResult;

    }

    public static Long getLabRelatorioNextId(String strDbName) {
        return new Long(getIdByNextValueStringSQL("select SEQ_REL_IN_CODIGO.nextval from dual",strDbName));
    }
    
    
    public static Date getDateFromDB(String strDbName){
        
        Session session = null;
        Transaction tx = null;
        Date rightNow = null;
        try{
            
            session = getSessionDude(strDbName);
            tx = session.beginTransaction();
            
            Query query = session.createSQLQuery("SELECT SYSDATE FROM Dual");
            List listQuery = query.list();
            
           if(listQuery != null && !listQuery.isEmpty()){
               for (int i = 0; i < listQuery.size(); i++) {
                   java.sql.Timestamp rightNowTimeStamp =  (java.sql.Timestamp) listQuery.get(i);
                   rightNow = new Date(rightNowTimeStamp.getTime());
                   if(rightNow != null){
                       break;
                   }
               }
           }
            
            
        }catch(Exception xcp){
            xcp.printStackTrace();
        }finally{
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        
        return rightNow;
    }
    
}//end of the class
