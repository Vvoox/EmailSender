package sample;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class JavaEmail {
    String  d_email = email,
            d_password = password,
            d_host = "smtp.gmail.com",
            d_port  = "465",
            m_to = to,
            m_subject = subject,
            m_text = text;
    static String email="";
    static String password="";
    static String to = "";
    static String subject="";
    static String text = "";
    static String OUTPUT = "";


    public JavaEmail()
    {
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        SecurityManager security = System.getSecurityManager();

        try
        {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);
            MimeMessage msg = new MimeMessage(session);
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            int n =Controller.EmailList.size();
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            Transport.send(msg);
            OUTPUT+="Sending to "+m_to+"... is DONE\n";



        }
        catch (Exception mex)
        {
            mex.printStackTrace();
        }
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator
    {
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(d_email, d_password);
        }
    }
}