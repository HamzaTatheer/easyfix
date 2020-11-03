package com.easyfix.Application.bl.services;

import com.easyfix.Application.models.CustomerModel;
public interface CustomerService{
    public int login(String email,String password);
    //public Boolean register(String name,String email,String password,String city,String area);
    //public Arraylist<int> getFavourites(int cid);
    //public Bool changePaymentMethod(int cid,String newMethod);
    //public Bool changeArea(String newArea);
}