/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.pdfmaker;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



/**
 *
 * @author eros
 */
public class PdfDadosSender {
    
    
    public void  pdfSender(String strDados){
        Context ctx;
        try {
          
            try {
                ctx = new InitialContext();
                ConnectionFactory     connectionFactory = (ConnectionFactory)ctx.lookup("jms/RelConection");
                
//                Destination destination = (Destination) ctx.lookup("jms/RelFila");
                
                Queue     queue = (Queue)ctx.lookup("jms/RelFila");
                javax.jms.Connection  connection;
                
                    connection = connectionFactory.createConnection();
                
                javax.jms.Session        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue);
                messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                messageProducer.setTimeToLive(10000);
                TextMessage message = session.createTextMessage();
                message.setText(strDados);
                
//                System.out.println(
//"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< enviando mensagem p a Fila >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                messageProducer.send(message);
                messageProducer.close();
                ctx.close();

                
                } catch (NamingException ex) {
                    ex.printStackTrace();
                }catch(JMSException  xcp){
                    xcp.printStackTrace();
                }
            
            
        } finally {            
            
        }
    }
    
    
//    public static void main(String... args){
//        LabUsuario lu = OracleHelper.getLabUsuario("EROS", "DAFTPUNK");
//    }
    
    
    
}
