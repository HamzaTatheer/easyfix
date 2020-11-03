package com.easyfix.Application.bl.services;

import com.easyfix.Application.models.CustomerModel;
public interface CustomerService{
    public int login(String email,String password) throws Exception;
    public int register(String name,String email,String password,String city,String area) throws Exception;//returns id after registering so you can login directly. -1 on error
    public int[] getFavourites(int cid);
    //public Bool changePaymentMethod(int cid,String newMethod);
    //public Bool changeArea(String newArea);
}