package com.easyfix.Application.db;

import com.easyfix.Application.Config;
import com.easyfix.Application.db.sqlDb.CustomerSqlManager;
import com.easyfix.Application.db.sqlDb.RatingSqlManager;
import com.easyfix.Application.db.sqlDb.WorkerSqlManager;

public class dbProviders {
    public static CustomerDbService getCustomerDbService(){
        if(Config.db == "sql") {
            return new CustomerTextManager(); //there should be CustomerSqlManager()
        }
        else {
            return new CustomerSqlManager(); //there should be CustomerTextManager()
        }
    }
    public static WorkerDbService getWorkerDbService(){
        if(Config.db == "sql") {
            return new WorkerSqlManager();
        }
        else {
            return new WorkerTextManager();
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
