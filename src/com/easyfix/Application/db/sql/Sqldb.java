package com.easyfix.Application.db.sql;

import com.easyfix.Application.db.DBFactory;
import com.easyfix.Application.db.DBService;
import com.easyfix.Application.models.Customer;

public class Sqldb implements DBService {
    public Sqldb(){

    }

    public int doesUserExist(String email,String password){
        return 3;
    }


    public Customer getCustomer(){
        String name = "hamza";
        Customer c = new Customer();
        c.email="hamza@gmail.com";
        c.name="hamza";
        c.password="12345";

        return c;
    }

}
