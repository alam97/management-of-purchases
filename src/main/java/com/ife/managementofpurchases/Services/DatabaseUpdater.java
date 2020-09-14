/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ife.managementofpurchases.Services;

import Database.Consts.TableNames;
import Database.DatabaseModel.*;
import Database.Helpers.IEntity;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DatabaseUpdater {

    IDatabaseContext databaseContext = new DatabaseContext();
    
    public void updateSeats(long id) {
        int i = (int) id;
        SeatsInPlaneEntity seat = (SeatsInPlaneEntity)databaseContext.getEntity(TableNames.SeatsInPlane, i);
        seat.setIsFree(0L);
    }
    
    public void updateUser(SeatsInPlaneEntity seat, int id) {
       UsersEntity user = (UsersEntity)databaseContext.getEntity(TableNames.Users, id);
       Collection<TicketsEntity> ticketsEntities = new ArrayList<>();
       TicketService ticketService = new TicketService(seat);
       ticketsEntities.add(ticketService.generateTicketRegisteredUser(user));
       user.setTicketsByUserId(ticketsEntities);
    }
    
}
