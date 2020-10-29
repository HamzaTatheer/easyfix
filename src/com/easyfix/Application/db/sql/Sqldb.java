package com.easyfix.Application.db.sql;

import com.easyfix.Application.db.DBFactory;
import com.easyfix.Application.db.DBService;

public class Sqldb implements DBService {
    public Sqldb(){

    }

    public int doesUserExist(String email,String password){
        DBFactory.getDatabase();
        return 3;
    }

}
