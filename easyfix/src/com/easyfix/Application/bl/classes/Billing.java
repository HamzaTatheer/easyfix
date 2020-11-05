package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.BillingModel;
import com.easyfix.Application.models.BookingModel;

public class Billing {
    public int id; //bill id
    public BookingModel bookingModel;
    public int totalCost;

    //constructors
    Billing(BillingModel obj){
        id=obj.id;
        bookingModel=obj.bookingModel;
        totalCost=obj.totalCost;
    }

    public BillingModel getBillingModel(){ //convert class to model
        BillingModel temp=new BillingModel();
        temp.id=id;
        temp.bookingModel=bookingModel;
        temp.totalCost=totalCost;
        return temp;
    }
    
    //setters
}
