package com.easyfix.Application.db;

import com.easyfix.Application.Config;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.db.sqlDb.CustomerSqlManager;
import com.easyfix.Application.db.textDb.CustomerTextManager;

public class dbProviders {
    public static CustomerDbService getCustomerDbService(){
        if(Config.db == "sql") {
            return new CustomerTextManager();
        }
        else {
            return new CustomerSqlManager();
        }
    }
}
