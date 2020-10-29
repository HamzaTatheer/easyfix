package com.easyfix.Application.bl;

import com.easyfix.Application.db.DBFactory;
import com.easyfix.Application.db.DBService;

public class CustomerManager implements CustomerService{

    DBService database = DBFactory.getDatabase();



    public int login(String email,String password){
        return database.doesUserExist(email,password);
    }
}
