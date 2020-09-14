/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ife.managementofpurchases.Models;

import Database.DatabaseModel.SeatsInPlaneEntity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ShoppingBasket {
    private List<SeatsInPlaneEntity> itemList = new ArrayList<>();

    public ShoppingBasket(List<SeatsInPlaneEntity> itemList) {
        this.itemList = itemList;
    }

    public boolean add(SeatsInPlaneEntity seat) {
        if ( itemList.contains(seat)){
            return false;
        }
        else itemList.add(seat);
        return true;
    }
    
    public boolean delete(SeatsInPlaneEntity seat) {
      if ( itemList.contains(seat)) {
            itemList.remove(seat);
            return true;
        }
        else return false;
    }

    
    public List<SeatsInPlaneEntity> getSeats() {
        return itemList;
    }
    
}
