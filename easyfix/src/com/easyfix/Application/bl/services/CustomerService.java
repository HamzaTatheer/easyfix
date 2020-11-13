package com.easyfix.Application.bl.services;

import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;
public interface CustomerService{
    public int login(String email,String password) throws Exception;
    public CustomerModel getCustomerDetails(int cid) throws Exception;
    public int register(String name,String email,String password,String credit,String city,String area) throws Exception;
    public ArrayList<WorkerModel> getFavourites(int cid);
    public boolean addToFavourite(int cid,int wid) throws Exception;
    public boolean changePaymentMethod(int cid,String newMethod);
    public boolean payMoney(int cid,float amount);
    public ArrayList<WorkerModel> getWorkersCloseBy(int cid);
    public boolean changeCity(int cid,String newCity);
    public boolean changeArea(int cid,String newArea);
    public boolean giveRating(int cid, int wid,int rating) throws Exception;
}