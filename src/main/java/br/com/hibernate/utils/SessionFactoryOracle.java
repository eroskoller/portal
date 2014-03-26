/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.hibernate.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.apache.log4j.Logger;

/**
 *
 * @author eros
 */
public class SessionFactoryOracle implements ServletContextListener{

     private static SessionFactory sessionFactory;
     static protected Logger log = Logger.getLogger(SessionFactoryOracle.class.getName());
     private static Calendar cal1;


     static {
            try {
                // Create the SessionFactory from standard (hibernate.cfg.xml)
                // config file.
                sessionFactory = new AnnotationConfiguration().configure("hibernateOracle.cfg.xml").buildSessionFactory();
                System.out.println("Session is loaded...........................");
               // SessionFactory s = new AnnotationConfiguration().configure("kgk.xml").buildSessionFactory();
//                cal1 = Calendar.getInstance();
//                cal1.add(Calendar.HOUR, 168);

            } catch (Throwable ex) {
                // Log the exception.
                System.err.println("Initial SessionFactory creation failed." + ex);
                
                ex.printStackTrace();
                log.error(ex);
                
                throw new ExceptionInInitializerError(ex);
            }
    }


    
    public static Session getCurrentSession4Faces(){
        
        if(sessionFactory == null ){
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            return  sessionFactory.openSession();
        }else{
            return sessionFactory.openSession();
        }
            
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        getCurrentSession4Faces();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if(sessionFactory != null && ! sessionFactory.isClosed()){
            sessionFactory.close();
        }
    }
    
    

}
