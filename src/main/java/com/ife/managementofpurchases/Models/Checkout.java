/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ife.managementofpurchases.Models;

import Database.DatabaseModel.SeatsInPlaneEntity;
import Database.DatabaseModel.UsersEntity;
import com.ife.managementofpurchases.Interfaces.IPurchase;
import com.ife.managementofpurchases.Services.DatabaseUpdater;

import java.util.List;

/**
 *
 * @author Admin
 */
public class Checkout {
    private List<SeatsInPlaneEntity> itemList;
    private UsersEntity user;
    private int pos;
    private String name;
    private  String surname;
    private String email;
    private IPurchase purchaseMethod;
    private DatabaseUpdater databaseUpdater = new DatabaseUpdater();
    private boolean registered;

    // checking out as a registered user
    public Checkout(List<SeatsInPlaneEntity> itemList, int pos, UsersEntity user) {
        this.itemList = itemList;
        this.pos = pos;
        this.user = user;
        this.registered = true;
    }

    // checkout as a nonregistered user
    public Checkout(List<SeatsInPlaneEntity> itemList, int pos, String name, String surname, String email) {
        this.itemList = itemList;
        this.pos = pos;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.registered = false;
    }

    public void checkoutBasket(boolean creditCard) {
        if (registered) {
            purchaseMethod = new registeredPurchase(creditCard, itemList.get(pos), user);
        } else {
            purchaseMethod = new nonRegisteredPurchase(creditCard, itemList.get(pos),name, surname, email);
        }
        purchaseMethod.purchase();
        databaseUpdater.updateUser(itemList.get(pos), (int)user.getUserId());
        databaseUpdater.updateSeats((itemList.get(pos).getSeatId()));
    }
}
