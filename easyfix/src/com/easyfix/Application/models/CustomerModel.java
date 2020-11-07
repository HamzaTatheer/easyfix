package com.easyfix.Application.models;

import com.easyfix.Application.bl.classes.Customer;

import java.util.ArrayList;

public class CustomerModel {
    public int id;
    public String name;
    public String email;
    public String password;
    public Float wallet;
    public String paymentMethod;
    public String creditno;
    public String city;
    public String area;
    public ArrayList<WorkerModel> Favourite;

    CustomerModel(Customer c){
        id = c.id;
        name = c.name;
        email = c.email;
        password = c.password;
        wallet = c.wallet;
        paymentMethod = c.paymentMethod;
        creditno = c.creditno;
        city = c.city;
        area = c.getArea();

        //for each loop and convert to favourite model


        Favourite = new WorkerModel(c.Favourites);
    }
}
