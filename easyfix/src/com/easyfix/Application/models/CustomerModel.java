package com.easyfix.Application.models;

import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.classes.Worker;

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

    public CustomerModel(){
        id=-1;
        name="none";
        email="none@gmail.com";
        password="none";
        wallet=0f;
        paymentMethod="none";
        creditno="none";
        city="none";
        area="none";
        Favourite = new ArrayList<WorkerModel>();
    }


    public CustomerModel(Customer c){
        id = c.getId();
        name = c.getName();
        email = c.getEmail();
        password = c.getPassword();
        wallet = c.getWallet();
        paymentMethod = c.getPaymentMethod();
        creditno = c.getCreditno();
        city = c.getCity();
        area = c.getArea();

        ArrayList<Worker> fav = c.getFavourites();
        //for each loop and convert to favourite model
        for (int i = 0; i < fav.size(); i++) {
            Favourite.add(new WorkerModel(fav.get(i)));
        }
    }
}
