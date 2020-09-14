package com.ife.managementofpurchases;
import Database.DatabaseModel.SeatsInPlaneEntity;
import Database.DatabaseModel.TicketsEntity;
import com.ife.managementofpurchases.Models.*;

import com.ife.managementofpurchases.Services.TicketService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class moduleTest {


    @Test
    public void adddeleteTest() {
        List<SeatsInPlaneEntity> itemList = new ArrayList<>();
        ShoppingBasket basket = new ShoppingBasket(itemList);
        // filling the basket
        SeatsInPlaneEntity seat1 = new SeatsInPlaneEntity();
        SeatsInPlaneEntity seat2 = new SeatsInPlaneEntity();
        basket.add(seat1);
        Assert.assertEquals(1, basket.getSeats().size());
        // cannot add the same - both are nulls
        Assert.assertFalse(basket.add(seat2));
        // removing the seat
        Assert.assertTrue(basket.delete(seat1));
        // cannot remove the nonexistent seat
        Assert.assertFalse(basket.delete(seat1));
    }

    @Test
    public void ticketTest(){
        SeatsInPlaneEntity seat1 = new SeatsInPlaneEntity();
        TicketService ticketService = new TicketService(seat1);
        TicketsEntity testticket = ticketService.generateTicketNonRegisteredUser("John","Smith");
        TicketsEntity ticket = new TicketsEntity();
        ticket.setPassengerName("John");
        ticket.setPassengerSurname("Smith");
        ticket.setSeatsInPlaneBySeatId(seat1);
        // are the tickets same
        Assert.assertEquals(ticket.getPassengerName(), testticket.getPassengerName());
        Assert.assertEquals(ticket.getPassengerSurname(), testticket.getPassengerSurname());
        Assert.assertEquals(ticket.getSeatsInPlaneBySeatId(), testticket.getSeatsInPlaneBySeatId());
    }


}