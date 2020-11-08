package com.easyfix.Application.bl.managers;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.bl.services.RatingService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;

public class CustomerManager implements CustomerService {

    private DbService dbService;

    public CustomerManager(){
        dbService = dbProviders.getDbService();
        RatingService ratingDbService = new RatingManager();
    }


    //return id
    public int login(String email, String password) throws Exception {
        int userid = dbService.does_customer_exist(email,password);

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

    public CustomerModel getCustomerDetails(int cid) throws Exception {
        if(dbService.does_customer_exist(cid) == true){
            return dbService.get_customer(cid);
        }
        else{
            throw new Exception("Customer Details not found. Make sure Customer exists");
        }
    }

    public ArrayList<WorkerModel> getFavourites(int cid){
        ArrayList<WorkerModel> w = dbService.get_favourites_workers(cid);
        return w;
    }

    public boolean addToFavourite(int cid,int wid) throws Exception {
        DbService db = dbProviders.getDbService();
        try{
        if((db.does_worker_exist(wid)==true)&&(db.does_customer_exist(cid) == true)){
            return db.add_favourite(1,1);
        }
        else{
            return false;
        }
        }
        catch (Exception e){
            return false;
        }
    }


    public ArrayList<WorkerModel> getWorkersCloseBy(int cid){
        WorkerManager wm = new WorkerManager();
        CustomerModel customerModel = dbService.get_customer(cid);
        Customer c = new Customer(customerModel);
        return wm.getWorkers(c.getCity(),c.getArea());
    }

    public boolean changePaymentMethod(int cid,String newPaymentMethod){
        Customer c = new Customer(dbService.get_customer(cid));
        return c.changePaymentMethod(newPaymentMethod);
    }

    public boolean changeCity(int cid,String newCity){
        Customer c = new Customer(dbService.get_customer(cid));

        return (c.changeCity(newCity) != true);
    }

    public Exception giveRating(int cid, int wid){
        return new Exception("Rating still to be done by roqiah in ratingManager");
    }

    public boolean changeArea(int cid,String newArea){
        Customer c = new Customer(dbService.get_customer(cid));
        c.changeArea(newArea);
        return dbService.update_customer_area(cid,c.getArea());
    }
}