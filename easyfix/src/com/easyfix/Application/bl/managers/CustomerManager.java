package com.easyfix.Application.bl.managers;
import com.easyfix.Application.bl.classes.Booking;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.bl.services.RatingService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;

public class CustomerManager implements CustomerService {

    private DbService dbService;

    //correct
    public CustomerManager(){
        dbService = dbProviders.getDbService();
        RatingService ratingDbService = new RatingManager();
    }


    //correct
    public int login(String email, String password) throws Exception {
        int userid = dbService.does_customer_exist(email,password);

        if(userid <= -1){
            throw new Exception("wrong login");//used to send ui layer in catch block if there is error over normal flow
        }

        return userid;
    }

    //correct
    public int register(String name,String email,String password,String credit,String city,String area) throws Exception{
        int userid = 0;
        if(password.length() <= 5){
            throw new Exception("Password length must be greater than 5");
        }

        if(userid < -1){
            throw new Exception("User can not be registered. Please try again");
        }

        dbService.store_customer(name,email,password,credit,2000,city,area,new ArrayList<Integer> ());
        return 1;
    }

    public boolean addToWallet(int cid,float amount) throws Exception {
        //contact external api to get certain amount from Bank through use of cid or some other way like verification code etc
        //we dont know how credit card works actually..

        if(amount<=0){
            throw new Exception("Invalid amount");
        }

        CustomerModel customer = dbService.get_customer(cid);
        return dbService.update_customerWallet(cid,customer.wallet+amount);
    }

    public CustomerModel getCustomerDetails(int cid) throws Exception {
        if(dbService.does_customer_exist(cid) == true){
            return dbService.get_customer(cid);
        }
        else{
            throw new Exception("Customer Details not found. Make sure Customer exists");
        }
    }

    @Override
    public boolean payMoney(int cid, float amount) {
        CustomerModel customer = dbService.get_customer(cid);



        if(customer.paymentMethod.equals("wallet")){
            if(customer.wallet >= amount){
                dbService.update_customerWallet(cid,customer.wallet-amount);
                return true;
            }
            else{
                return false;
            }
        }
        else{
            //contact api like hbl api to make payment and return true
            return true;
        }
    }

    public ArrayList<WorkerModel> getFavourites(int cid){
        ArrayList<Integer> w = dbService.get_favourites(cid);
        ArrayList<WorkerModel> workers = new ArrayList<WorkerModel>();

        for(int i=0;i<w.size();i++){
            WorkerModel worker = dbService.get_worker(w.get(i));
            workers.add(worker);
        }
        return workers;
    }

    public boolean addToFavourite(int cid,int wid) throws Exception {
        DbService db = dbProviders.getDbService();
        if((db.does_worker_exist(wid)==true)&&(db.does_customer_exist(cid) == true)){
            ArrayList<Integer> customerFavourites = db.get_favourites(cid);
            if(customerFavourites.contains(wid) == true){
                throw new Exception("You have already added this worker to favourites");
            }
            return db.add_favourite(cid,wid);
        }
        else{
            throw new Exception("Invalid Ids entered");
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

        if(c.changePaymentMethod(newPaymentMethod)==true)
        return dbService.update_customerPayment(cid,c.getPaymentMethod());
        else
            return false;
    }

    public boolean changeCity(int cid,String newCity){
        Customer c = new Customer(dbService.get_customer(cid));
        c.changeCity(newCity);
        return dbService.update_customer_city(cid,c.getCity());
    }

    public boolean giveRating(int cid, int wid,int rating) throws Exception {
        ArrayList<BookingModel> bookings = dbService.get_booking_of_customer(cid);
        boolean hiredWorker = false;
        for (BookingModel booking : bookings) {
            if(booking.wid == wid){
                hiredWorker = true;
            }
        }

        if(hiredWorker == true) {
            try {
                dbService.store_rating(cid, wid, rating);
                return true;
            }
            catch (Exception e){
                throw new Exception("Db Error");
            }
        }else{
            throw new Exception("You have to book appointment before giving rating to a worker");
        }
    }

    public boolean changeArea(int cid,String newArea){
        Customer c = new Customer(dbService.get_customer(cid));
        c.changeArea(newArea);
        return dbService.update_customer_area(cid,c.getArea());
    }
}