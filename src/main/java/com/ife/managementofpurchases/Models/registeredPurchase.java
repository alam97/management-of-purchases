package com.ife.managementofpurchases.Models;

import Database.DatabaseModel.SeatsInPlaneEntity;
import Database.DatabaseModel.UsersEntity;
import com.ife.managementofpurchases.Interfaces.IPurchase;
import com.ife.managementofpurchases.Interfaces.IPayment;
import com.ife.managementofpurchases.Services.EmailServiceRegistered;
import com.ife.managementofpurchases.Interfaces.IEmailService;
import com.ife.managementofpurchases.Services.TicketService;

public class registeredPurchase implements IPurchase {

    private boolean creditCard;
    private SeatsInPlaneEntity seat;
    private UsersEntity user;

    public registeredPurchase(boolean creditCard, SeatsInPlaneEntity seat, UsersEntity user) {
        this.creditCard = creditCard;
        this.seat = seat;
        this.user = user;
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
            IEmailService email = new EmailServiceRegistered(ticketService.generateTicketRegisteredUser(user), user);
            email.sendMail();
    }
}
