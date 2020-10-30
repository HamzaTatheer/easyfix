package com.easyfix.Application.db.text;

import com.easyfix.Application.db.DBService;
import com.easyfix.Application.models.Customer;

public class Textdb implements DBService {
    public Textdb(){

    }

    public Customer getCustomer(){
        return new Customer();
    }

    public int doesUserExist(String email,String password){
        //check in text file
        return 3;
    }
}
