package com.easyfix.Application.db.services;

public interface CustomerDbService {
    public boolean does_customer_exist(int id);
    public int does_customer_exist(String email,String password); //id returned
}
