package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.BillingModel;
import com.easyfix.Application.models.BookingModel;

public class Billing {
    public int id; //bill id
    public int bid; //booking id
    public int totalCost;

    //constructors
    Billing(){
        // checkkkkkkkkkkkkkkkkkkk
        /////dhwhdfjwhejfhwejhj

    }
    //getters
    public BillingModel getBillingModelEntity(Billing obj){
        BillingModel temp=new BillingModel();
        temp.totalCost=obj.totalCost;
        temp.id=obj.id;
        temp.bid=obj.bid;
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
