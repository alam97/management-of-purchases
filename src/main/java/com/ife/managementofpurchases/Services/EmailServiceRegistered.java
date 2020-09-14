/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ife.managementofpurchases.Services;

import Database.DatabaseModel.TicketsEntity;
import Database.DatabaseModel.UsersEntity;
import com.ife.managementofpurchases.Interfaces.IEmailService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class EmailServiceRegistered implements IEmailService {

    String sender = "airportcompany@domain.com";
    String host = "localhost";
    TicketsEntity ticket;
    UsersEntity user;

    public EmailServiceRegistered(TicketsEntity ticket, UsersEntity user) {
        this.ticket = ticket;
        this.user = user;
    }

    public void sendMail() {
        String recipient = user.getEmail();
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
