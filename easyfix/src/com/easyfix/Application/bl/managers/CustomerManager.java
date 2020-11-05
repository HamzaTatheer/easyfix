package com.easyfix.Application.bl.managers;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.utils.HandledException;

import java.sql.SQLDataException;
import java.util.ArrayList;

public class CustomerManager implements CustomerService {

    //return id
    public int login(String email, String password) throws Exception {
        CustomerDbService custdbservice = dbProviders.getCustomerDbService();
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
        CustomerDbService custdbservice = dbProviders.getCustomerDbService();
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

    public ArrayList<Integer> getFavourites(int cid){
        CustomerDbService custdbservice = dbProviders.getCustomerDbService();


        //dummy db processing of getting favourite array
        ArrayList<Integer> favourites = new ArrayList();
        favourites.add(2);

        return favourites;
    }

    public boolean addToFavourite(int wid){

        return true;
    }

    public boolean changePaymentMethod(int cid,String newMethod){
        //simple db service call to change method
        return true;
    }

    public boolean changeCity(String newCity){
        //db call to change City
        return true;
    }

    public boolean giveRating(int cid,int wid){

        return true;
    }

    public boolean changeArea(String newArea){
        //db call to change newArea
        return true;
    }
}