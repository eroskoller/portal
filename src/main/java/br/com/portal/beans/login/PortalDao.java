/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.portal.beans.login;

import br.com.facesbeans.utils.JSFHelper;
import br.com.hibernate.entities.LabUnidade;
import br.com.hibernate.entities.LabUsuario;
import br.com.hibernate.utils.OracleHelper;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.component.menubar.Menubar;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import javax.faces.event.ActionListener;

/**
 *
 * @author eros
 */
public class PortalDao implements Serializable {

    public static LabUsuario grabUser(String strLogin, String strPass, String strDbName) {
        LabUsuario labUsuario = null;

        if (labUsuario == null) {
            labUsuario = OracleHelper.getLabUsuario(strLogin.toUpperCase(), strPass.toUpperCase(), strDbName.toUpperCase());
        }
        if (labUsuario == null) {
            labUsuario = OracleHelper.getLabUsuario(strLogin.toLowerCase(), strPass.toLowerCase(), strDbName.toUpperCase());
        }
        if (labUsuario == null) {
            labUsuario = OracleHelper.getLabUsuario(strLogin.toLowerCase(), strPass.toUpperCase(), strDbName.toUpperCase());
        }
        if (labUsuario == null) {
            labUsuario = OracleHelper.getLabUsuario(strLogin.toUpperCase(), strPass.toLowerCase(), strDbName.toUpperCase());
        }
        if (labUsuario == null) {
            labUsuario = OracleHelper.getLabUsuario(strLogin , strPass, strDbName.toUpperCase());
        }
        

        return labUsuario;
    }

    public static Map<String, String> grantMeModulos(LabUsuario user, String strDbName) {
        Map<String, String> mapModulos = null;
        String sqlQuery = " select"
                + "\n  mdl.modStCodigo, mdl.modStDescricao"
                + "\n from "
                + "\n LabPerfilUsuarioModulo pum, "
                + "\n LabModulo mdl, "
                + "\n LabUsuario usu,"
                + "\n LabUsuarioModulo umo "
                + "\n where pum.modStCodigo = mdl.modStCodigo"
                + "\n and umo.usuStCodigo = usu.usuStCodigo"
                + "\n and umo.modStCodigo = mdl.modStCodigo"
                + "\n and usu.usuStCodigo = :usuStCodigo "
                + "\n and pum.pusChHabilitado  = 'S' ";

        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();

        try {
            mapModulos = new HashMap<String, String>();

            Query query = session.createQuery(sqlQuery);
            query.setString("usuStCodigo", user.getUsuStCodigo());

            List list = query.list();
            tx.commit();



            if (list != null && !list.isEmpty()) {

                for (int i = 0; i < list.size(); i++) {
                    Object[] tupla = (Object[]) list.get(i);
                    mapModulos.put((String) tupla[0], (String) tupla[1]);
                }

            }


        } catch (Exception xcp) {
            xcp.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return mapModulos;
    }

    public static LinkedHashMap<String, LabUnidade> grabLabUnidadesByUser(LabUsuario user, String strDbName) {
        LinkedHashMap<String, LabUnidade> mapLabUnidades = null;
        String sqlQuery =
                "\n  select uni.uniStCodigo, uni.uniStDescricao "
                + "\n from LabUnidade uni, LabUsuarioUnidade usuuni "
                + "\n where usuuni.uniStCodigo = uni.uniStCodigo "
                + "\n and usuuni.usuStCodigo = :usuStCodigo "
                + "\n group by uni.uniStCodigo, uni.uniStDescricao "
                + "\n order by uni.uniStCodigo";

        Session session = OracleHelper.getSessionDude(strDbName);
        Transaction tx = session.beginTransaction();

        try {
            mapLabUnidades = new LinkedHashMap<String, LabUnidade>();

            Query query = session.createQuery(sqlQuery);
            query.setString("usuStCodigo", user.getUsuStCodigo());

            List list = query.list();
            tx.commit();



            if (list != null && !list.isEmpty()) {

                for (int i = 0; i < list.size(); i++) {
                    Object[] tupla = (Object[]) list.get(i);
                    mapLabUnidades.put((String) tupla[0], new LabUnidade((String) tupla[0], (String) tupla[1]));
                }

            }


        } catch (Exception xcp) {
            xcp.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
//        System.out.println("mapLabUnidades.size(): "+mapLabUnidades.size());
        return mapLabUnidades;
    }

    public static void main(String... args) {
        LabUsuario labUsuario = OracleHelper.getLabUsuario("EROS", "DAFTPUNK", "DEFAULT");
        PortalDao.grabLabUnidadesByUser(labUsuario, "DEFAULT");

    }
}
