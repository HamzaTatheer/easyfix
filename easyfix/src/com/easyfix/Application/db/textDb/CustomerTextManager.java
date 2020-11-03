package com.easyfix.Application.db.textDb;

import com.easyfix.Application.db.services.CustomerDbService;

public class CustomerTextManager implements CustomerDbService {
    //access from text file
    public int doesUserExist(int id){
        return 1;
    }
}
