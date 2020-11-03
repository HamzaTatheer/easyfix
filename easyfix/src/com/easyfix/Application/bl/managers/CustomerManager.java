package com.easyfix.Application.bl.managers;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.models.CustomerModel;

public class CustomerManager implements CustomerService {
    public int login(String email, String password){
        CustomerDbService custdbservice = dbProviders.getCustomerDbService();
        return custdbservice.doesUserExist(1);
    }
    private int getCustomer(int id){
            return 0;//0 for null
    }
    public Boolean changePaymentMethod(int id,String newMethod){
        //Get Customer from db and convert Model to Customer Object
        //Customer c = getCustomer(id);
        //c.paymentMethod = newMethod
        //database.store(c);
        return true;
    }
    public Boolean addToWallet(int id,int money){
        //Get Customer from db
        //Convert to Customer object
        //Make Credit Card payment
        //if it returns successful payment
        //add money to wallet
        //Convert Customer object to model
        //save in db
        return true;
    }
    public Boolean changeHomeAddress(int id,String newAddress){
        //simply change HomeAddress and store in db
        return true;
    }
    public Boolean addToFavourite(int id,int wid){
        //Get model from db
        //Convert to Customer object
        //Contact WorkerManager to check if id exists
        return true;
    }
}
