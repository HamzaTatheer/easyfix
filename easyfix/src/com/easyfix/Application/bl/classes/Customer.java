package com.easyfix.Application.bl.classes;
import java.util.ArrayList;
import com.easyfix.Application.models.CustomerModel;
public class Customer extends User{
    public Float wallet;
    public String creditno;
    public String paymentMethod;
    public String city;
    public String area;
    public ArrayList<Worker> Favourites;


    //constructors
    Customer(CustomerModel model){
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

    public CustomerModel getCustomerModel(Customer temp){ //convert class to model
        CustomerModel c = new CustomerModel();
        c.id = temp.id;
        c.name = temp.name;
        c.email = temp.email;
        c.password = "hidden";
        c.wallet=temp.wallet;
        c.creditno = temp.creditno;
        c.paymentMethod =temp.paymentMethod;
        c.city = temp.city;
        c.area = temp.area;
        for (int i=0;i<temp.Favourites.size();i++){
            
        }
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
    public Boolean makeCreditCardPayment(Float amount){
        //external api to charge amount
        return true;
    }
}
