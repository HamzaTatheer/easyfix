package com.easyfix.Application.bl.managers;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.bl.services.RatingService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.db.services.RatingDbService;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;

public class CustomerManager implements CustomerService {

    private CustomerDbService customerDbService;
    private RatingDbService ratingDbService;

    public CustomerManager(){
        //service provider of CustomerDb
        CustomerDbService customerDbService = dbProviders.getCustomerDbService();
        //user service from someone else
        RatingService ratingDbService = new RatingManager();
    }


    //return id
    public int login(String email, String password) throws Exception {
        int userid = -1;
        //userid = custdbservice.doesUserExist(1); or something else like doesexist(email,password)

        //dummy access of database in 2 lines below
        if((email=="customer@gmail.com")&&(password=="customer")){
            userid=1;
        }

        if(userid <= -1){
            throw new Exception("wrong login");//used to send ui layer in catch block if there is error over normal flow
        }
        return userid;
    }

    //return id
    public int register(String name,String email,String password,String city,String area) throws Exception{
        int userid = 0;

        if(password.length() <= 5){
            throw new Exception("Password length must be greater than 5");
        }
        //userid = custdbservice.storeUser(...)
        if(userid < -1){
            throw new Exception("User can not be registered. Please try again");
        }

        return 1;
    }

    public ArrayList<WorkerModel> getFavourites(int cid){
        return customerDbService.get_customer(cid).Favourite;
    }

    public boolean addToFavourite(int cid,int wid) throws Exception {
        //functionality still not done. needed from arsalan. still asking
        //same goes for removeFromFavourite
        throw new Exception("Functionality still not done");
    }

    public boolean changePaymentMethod(int cid,String newPaymentMethod){
        Customer c = new Customer(customerDbService.get_customer(cid));
        return c.changePaymentMethod(newPaymentMethod);
    }

    public boolean changeCity(int cid,String newCity){
        Customer c = new Customer(customerDbService.get_customer(cid));

        return (c.changeCity(newCity) != true);
    }

    public Exception giveRating(int cid, int wid){
        return new Exception("Rating still to be done by roqiah in ratingManager");
    }

    public boolean changeArea(int cid,String newArea){
        Customer c = new Customer(customerDbService.get_customer(cid));
        c.changeArea(newArea);
        return customerDbService.update_customer_area(cid,c.getArea());
    }
}