package com.easyfix.Application.db;

import com.easyfix.Application.Config;
import com.easyfix.Application.bl.services.DbService;
import com.easyfix.Application.db.sqlDb.SqlDbManager;
import com.easyfix.Application.db.textDb.TextDbManager;

public class dbProviders {
    public static DbService getDbService(){
        if(Config.db == "sql") {
            return new SqlDbManager();
        }
        else{
            return new TextDbManager();
        }
    }
}
