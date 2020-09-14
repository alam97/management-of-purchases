package com.ife.managementofpurchases.Models;

import Database.DatabaseModel.SeatsInPlaneEntity;
import com.ife.managementofpurchases.Interfaces.IPurchase;
import com.ife.managementofpurchases.Interfaces.IPayment;
import com.ife.managementofpurchases.Services.EmailServiceNonRegistered;
import com.ife.managementofpurchases.Interfaces.IEmailService;
import com.ife.managementofpurchases.Services.TicketService;

public class nonRegisteredPurchase implements IPurchase {

    private boolean creditCard;
    private SeatsInPlaneEntity seat;
    private String name;
    private String surname;
    private String emailAddress;

    public nonRegisteredPurchase(boolean creditCard, SeatsInPlaneEntity seat, String name, String surname, String email) {
        this.creditCard = creditCard;
        this.seat = seat;
        this.name = name;
        this.surname = surname;
        this.emailAddress = email;
    }

    public void purchase() {
        if (creditCard) {
            IPayment IPayment = new CreditCard();
            IPayment.pay();
        } else {
            IPayment IPayment = new Transfer();
            IPayment.pay();
        }
        TicketService ticketService = new TicketService(seat);
        IEmailService email = new EmailServiceNonRegistered(emailAddress, ticketService.generateTicketNonRegisteredUser(name, surname));
        email.sendMail();
    }
    }
