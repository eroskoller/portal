/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils.tipstricks;

import br.com.hibernate.entities.LabUsuario;
import br.com.hibernate.utils.OracleHelper;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ricardo
 */
public class EmailSender {
    
    String d_email = "balbinr@gmail.com",
           d_host = "smtp.gmail.com",
           d_password = "rochapqp",
           d_port = "465",
           m_to = "balbinr@gmail.com",
           m_subject = "Testando mano...",
           m_text = "<b>Holly crap , that thing really works dude...my owe java mail...cool</b>";

    public EmailSender(){
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        SecurityManager security = System.getSecurityManager();

        try{
                Authenticator auth = new SMTPAuthenticator();
                Session session = Session.getInstance(props, auth);
                //session.setDebug(true);

                MimeMessage msg = new MimeMessage(session);
                msg.setText(m_text);
                msg.setSubject(m_subject);
                msg.setFrom(new InternetAddress(d_email));
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
                Transport.send(msg);
        }catch (Exception mex){
            mex.printStackTrace();
        }
    }



    private class SMTPAuthenticator extends javax.mail.Authenticator{
        public PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(d_email, d_password);
        }
    }

}