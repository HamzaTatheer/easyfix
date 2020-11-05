package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.BillingModel;
import com.easyfix.Application.models.BookingModel;

public class Billing {
    public int id; //bill id
    public int bid; //booking id
    public int totalCost;

    //constructors
    Billing(BillingModel obj){
        id=obj.id;
        bid=obj.bid;
        totalCost=obj.totalCost;
    }

    public BillingModel getBillingModel(){ //convert class to model
        BillingModel temp=new BillingModel();
        temp.id=id;
        temp.bid=bid;
        temp.totalCost=totalCost;
        return temp;
    }

    public int getId() {
        return id;
    }

    public int getBid() {
        return bid;
    }

    public int getTotalCost() {
        return totalCost;
    }
    //setters
}
