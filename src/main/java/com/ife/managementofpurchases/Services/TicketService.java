/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ife.managementofpurchases.Services;

import Database.DatabaseModel.FlightsEntity;
import Database.DatabaseModel.SeatsInPlaneEntity;
import Database.DatabaseModel.TicketsEntity;
import Database.DatabaseModel.UsersEntity;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TicketService {

    private SeatsInPlaneEntity seat;
    private TicketsEntity ticket = new TicketsEntity();

    public TicketService(SeatsInPlaneEntity seat){
        this.seat = seat;
    }

    public TicketsEntity generateTicketRegisteredUser(UsersEntity user) {
        ticket.setPassengerName(user.getNameUser());
        ticket.setPassengerSurname(user.getSurnameUser());
        ticket.setPrice(1500);
        ticket.setSeatsInPlaneBySeatId(seat);
        return ticket;
    }

    public TicketsEntity generateTicketNonRegisteredUser(String name, String surname){
        ticket.setPassengerName(name);
        ticket.setPassengerSurname(surname);
        ticket.setPrice(1500);
        ticket.setSeatsInPlaneBySeatId(seat);
        return ticket;
    }

}
