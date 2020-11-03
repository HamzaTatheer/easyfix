package com.easyfix.Application.bl.managers;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.utils.HandledException;

import java.sql.SQLDataException;

public class CustomerManager implements CustomerService {

    //return id
    public int login(String email, String password) throws Exception {
        CustomerDbService custdbservice = dbProviders.getCustomerDbService();
        int userid = -1;
        //userid = custdbservice.doesUserExist(1); or something else like doesexist(email,password)

        //dummy access of database in 2 lines below
        if((email=="admin@gmail.com")&&(password=="admin")){
            userid=1;
        }

        if(userid < -1){
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

    public int[] getFavourites(int cid){
        CustomerDbService custdbservice = dbProviders.getCustomerDbService();
        return null;
    }



}