package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.CustomerModel;

public class Customer extends User{
    Float wallet;
    public String area;
    public String city;
    public String creditNo;
    public String paymentMethod;
    public String password;

    Customer(int _id,String _name,String _email,String _password,String _city,String _area, String _creditNo, String _paymentMethod)
    {
        id = _id;
        name = _name;
        email = _email;
        password = _password;
        city = _city;
        area = _area;
        creditNo = _creditNo;
        paymentMethod = _paymentMethod;
    }


    Customer(CustomerModel model){
        id = model.id;
        name = model.name;
        email = model.email;
        password = model.password;
        area = model.area;
        city = model.city;
        creditNo = model.creditno;
        paymentMethod = model.paymentMethod;
    }

    public CustomerModel getCustomerModel(CustomerModel model){
        CustomerModel c = new CustomerModel();
        c.id = model.id;
        c.name = model.name;
        c.email = model.email;
        c.password = "hidden";
        c.area = model.area;
        c.city = model.city;
        c.creditno = model.creditno;
        c.paymentMethod = model.paymentMethod;
        return c;
    }


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
}
