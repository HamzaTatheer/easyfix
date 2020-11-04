package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.CustomerModel;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class Customer extends User{
    Float wallet;
    public String area;
    public String city;
    public String creditno;
    public String paymentMethod;
    public String password;
    public ArrayList<Favourite>Favourites;

    //constructors
    Customer(int _id,String _name,String _email,String _password,String _city,String _area, String _creditNo, String _paymentMethod,ArrayList<Favourite>_Favourites)
    {
        id = _id;
        name = _name;
        email = _email;
        password = _password;
        city = _city;
        area = _area;
        creditno = _creditNo;
        paymentMethod = _paymentMethod;
        Favourites=_Favourites;
    }

    Customer(CustomerModel model){
        id = model.id;
        name = model.name;
        email = model.email;
        password = model.password;
        area = model.area;
        city = model.city;
        creditno = model.creditno;
        paymentMethod = model.paymentMethod;
        //Favourites=model.Favourites; //conversion needed from model to entity
    }
    //setters
    public Boolean addToWallet(Float newAmount){
        wallet += newAmount;
        return true;
    }

    public Boolean chargeWallet(Float amount){
        if(wallet - amount < 0){
            return false;
        }
        else {
            wallet -= amount;
            return true;
        }
    }
    public Boolean makeCreditCardPayment(Float amount){
        //external api to charge amount
        return true;
    }
    //getters
    public CustomerModel getCustomerModel(){
        CustomerModel c = new CustomerModel();
        c.id = id;
        c.name = name;
        c.email = email;
        c.password = "hidden";
        c.area = area;
        c.city = city;
        c.creditno = creditno;
        c.paymentMethod =paymentMethod;
        return c;
    }
}
