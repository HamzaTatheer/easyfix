package com.easyfix.Application.db.textDb;

import com.easyfix.Application.db.services.CustomerDbService;

public class CustomerTextManager implements CustomerDbService {
    public boolean does_customer_exist(int id){
        if((id==1) || (id ==2)){
            return true;
        }
        else
            return false;
    }

    //access from sql server
    public int does_customer_exist(String email,String password){
        if((email == "admin@gmail.com")&&(password == "admin"))
            return 1;
        else{
            return -1;
        }
    }
}
