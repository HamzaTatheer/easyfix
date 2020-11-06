package com.easyfix.Application.bl.classes;
import java.util.ArrayList;
import com.easyfix.Application.models.CustomerModel;
public class Customer extends User{
    public Float wallet;
    public String creditno;
    public String paymentMethod;
    public String city;
    private String area;
    public ArrayList<Worker> Favourites;


    //constructors
    public Customer(CustomerModel model){
        id = model.id;
        name = model.name;
        email = model.email;
        password = model.password;
        wallet=model.wallet;
        creditno = model.creditno;
        paymentMethod = model.paymentMethod;
        city = model.city;
        area = model.area;
    }
    //getters

    public CustomerModel getCustomerModel(){
        CustomerModel c = new CustomerModel();
        c.id = id;
        c.name = name;
        c.email = email;
        c.password = "hidden";
        c.wallet=wallet;
        c.creditno = creditno;
        c.paymentMethod =paymentMethod;
        c.city = city;
        c.area = area;
        return c;
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

    public String getArea(){
        return area;
    }

    public boolean changePaymentMethod(String newMethod){
        paymentMethod = newMethod;
        return true;
    }

    public Boolean changeCity(String newCity){
        city = newCity;
        return true;
    }

    public Boolean changeArea(String newArea){
        area = newArea;
        return true;
    }

    public Boolean makeCreditCardPayment(Float amount){
        //external api to charge amount
        return true;
    }
}
