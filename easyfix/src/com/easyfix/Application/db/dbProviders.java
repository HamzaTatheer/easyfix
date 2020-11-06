package com.easyfix.Application.db;

import com.easyfix.Application.Config;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.db.services.RatingDbService;
import com.easyfix.Application.db.sqlDb.CustomerSqlManager;
import com.easyfix.Application.db.sqlDb.RatingSqlManager;
import com.easyfix.Application.db.textDb.CustomerTextManager;
import com.easyfix.Application.db.textDb.RatingTextManager;

public class dbProviders {
    public static CustomerDbService getCustomerDbService(){
        if(Config.db == "sql") {
            return new CustomerTextManager();
        }
        else {
            return new CustomerSqlManager();
        }
    }

    public static RatingDbService getRatingDbService(){
        if(Config.db=="sql"){
            return new RatingSqlManager();
        }
        else{
            return new RatingTextManager();
        }
    }
}
