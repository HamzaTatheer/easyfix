package com.easyfix.Application.models;

public class BillingModel {
    public int id;
    public int bid;
    public int totalCost;
    //getters
    public BillingModel getBillingModel(){
        BillingModel temp=new BillingModel();
        temp.id=id;
        temp.bid=bid;
        temp.totalCost=totalCost;
        return temp;
    }
}
