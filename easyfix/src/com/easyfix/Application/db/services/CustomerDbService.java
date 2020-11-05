package com.easyfix.Application.db.services;
import com.easyfix.Application.models.CustomerModel;

import java.util.ArrayList;

public interface CustomerDbService {
    public boolean does_customer_exist(int id);
    public int does_customer_exist(String email,String password); //id returned
    public boolean store_customer(String name, String email, String password, String credit_no, float wallet, String city, String area, ArrayList<Integer> favourite) throws Exception;//id given by default by DB
    public boolean update_customer_city(int id,String city);
    public boolean update_customer_area(int id,String area);
    public boolean update_customerPayment(int id,String payment);
    public CustomerModel get_customer(int id);
}
