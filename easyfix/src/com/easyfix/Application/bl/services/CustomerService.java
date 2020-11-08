package com.easyfix.Application.bl.services;

import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;
public interface CustomerService{
    public int login(String email,String password) throws Exception;
    public CustomerModel getCustomerDetails(int cid) throws Exception;
    public int register(String name,String email,String password,String city,String area) throws Exception;//returns id after registering so you can login directly. -1 on error
    public ArrayList<WorkerModel> getFavourites(int cid);
    public boolean addToFavourite(int cid,int wid) throws Exception;
    public boolean changePaymentMethod(int cid,String newMethod);
    public ArrayList<WorkerModel> getWorkersCloseBy(int cid);
    public boolean changeCity(int cid,String newCity);
    public boolean changeArea(int cid,String newArea);
    public Exception giveRating(int cid, int wid);
}




