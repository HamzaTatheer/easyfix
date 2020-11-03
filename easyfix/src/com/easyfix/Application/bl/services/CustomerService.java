package com.easyfix.Application.bl.services;

import com.easyfix.Application.models.CustomerModel;

public interface CustomerService{
    public int login(String email,String password);
    public Boolean changePaymentMethod(int id,String newMethod);
    public Boolean addToWallet(int id,int money);
    public Boolean changeHomeAddress(int id,String newAddress);
    public Boolean addToFavourite(int id,int wid);
}