package com.easyfix.Application.db;

import com.easyfix.Application.Application;
import com.easyfix.Application.db.sql.Sqldb;
import com.easyfix.Application.db.text.Textdb;

public class DBFactory {

    public static DBService dbInstance = null;

    public static DBService getDatabase(){

        if(dbInstance != null)
            return dbInstance;

        //Application is main class which knows all config
        if(Application.db == "sql")
        {
            dbInstance = new Sqldb();
        }
        else if(Application.db == "text")
        {
            dbInstance = new Textdb();
        }

        return dbInstance;
    }
}
