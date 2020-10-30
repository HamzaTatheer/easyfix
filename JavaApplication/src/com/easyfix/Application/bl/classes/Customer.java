package com.easyfix.Application.bl.classes;

public class Customer extends User{
    Float wallet;
    public String homeAddress;
    public String creditNo;
    public String paymentMethod;


    Customer(int _id,String _name,String _email,String _password,String _homeAddress, String _creditNo, String _paymentMethod)
    {
        id = _id;
        name = _name;
        email = _email;
        password = _password;
        homeAddress = _homeAddress;
        creditNo = _creditNo;
        paymentMethod = _paymentMethod;
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
