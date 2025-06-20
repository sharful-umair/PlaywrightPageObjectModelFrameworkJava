package utilities;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

public class MonitoringMail {

    static {
        System.setProperty("https.protocols", "TLSv1.2,TLSv1.3");
        System.setProperty("jdk.tls.client.protocols", "TLSv1.2,TLSv1.3");
    }

    public void sendMail(String mailServer, String from, String[] to, String subject, String messageBody)
            throws MessagingException, AddressException {

        boolean debug = false;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", mailServer);
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
        session.setDebug(debug);

        try {
            Message message = new MimeMessage(session);
            message.addHeader("X-Priority", "1");
            message.setFrom(new InternetAddress(from));

            InternetAddress[] addressTo = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                addressTo[i] = new InternetAddress(to[i]);
            }

            message.setRecipients(Message.RecipientType.TO, addressTo);
            message.setSubject(subject);

            BodyPart body = new MimeBodyPart();
            body.setContent(messageBody, "text/html");

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(body);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Successfully sent mail to all users");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    private class SMTPAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String username = TestConfig.from;
            String password = TestConfig.password;
            return new PasswordAuthentication(username, password);
        }
    }
}
