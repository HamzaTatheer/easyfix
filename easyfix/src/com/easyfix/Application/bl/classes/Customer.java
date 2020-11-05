package com.easyfix.Application.bl.classes;
import java.util.ArrayList;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.FavouriteModel;
import com.easyfix.Application.bl.classes.Favourite;
import java.io.*;
import java.util.*;
public class Customer extends User{
    public Float wallet;
    public String creditno;
    public String paymentMethod;
    public String city;
    public String area;
    public ArrayList<Favourite>Favourites;


    //constructors
    Customer(){

    }
    Customer(int _id,String _name,String _email,String _password,float _wallet, String _creditNo, String _paymentMethod,String _city,String _area,ArrayList<Favourite>_Favourites)
    {
        id = _id;
        name = _name;
        email = _email;
        password = _password;
        wallet=_wallet;
        creditno = _creditNo;
        paymentMethod = _paymentMethod;
        city = _city;
        area = _area;
        Favourites=_Favourites;
    }

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
        for (int i=0;i<model.Favourites.size();i++){
            Favourite obj=new Favourite(model.Favourites.get(i));//conversion here for favourites
            Favourites.add(i,obj);
        }
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
    public Customer getCustomer(CustomerModel temp){ //convert model to class
        Customer c = new Customer();
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
            Favourite obj=new Favourite(temp.Favourites.get(i));//conversion here for favourites
            Favourites.add(i,obj);
        }
        return c;
    }
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

            Favourite entity=new Favourite();
            FavouriteModel store=entity.getFavouriteModel(temp.Favourites.get(i));//conversion here
            c.Favourites.add(i,store);
        }
        return c;
    }
}
