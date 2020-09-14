package com.ife.managementofpurchases.Services;

import Database.DatabaseModel.TicketsEntity;
import com.ife.managementofpurchases.Interfaces.IEmailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceNonRegistered implements IEmailService {

    String sender = "airportcompany@domain.com";
    String host = "localhost";
    String email;
    TicketsEntity ticket;

    public EmailServiceNonRegistered(String email, TicketsEntity ticket) {
        this.email = email;
        this.ticket = ticket;
    }

    @Override
    public void sendMail() {
        String recipient = email;
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Ticket");
            message.setText(ticket.toString());

            Transport.send(message);

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
