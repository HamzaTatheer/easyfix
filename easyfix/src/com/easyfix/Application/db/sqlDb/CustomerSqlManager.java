package com.easyfix.Application.db.sqlDb;

import com.easyfix.Application.db.services.CustomerDbService;

public class CustomerSqlManager implements CustomerDbService {
    //access from sql server
    public int doesUserExist(String email,String password){

        if((email == "admin@gmail.com")&&(password == "admin"))
        return 1;
        else{
            return -1;
        }
    }
}
