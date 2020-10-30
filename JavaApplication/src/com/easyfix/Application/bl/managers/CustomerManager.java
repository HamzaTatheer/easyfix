package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.db.DBFactory;
import com.easyfix.Application.db.DBService;
import com.easyfix.Application.models.Customer;

public class CustomerManager implements CustomerService {
    DBService database = DBFactory.getDatabase();
    public int login(String email,String password){
        return database.doesUserExist(email,password);
    }


}
