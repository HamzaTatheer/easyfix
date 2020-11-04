package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Worker;
import com.easyfix.Application.bl.services.WorkerService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;

public class WorkerManager implements WorkerService {


    //return id
    public int login(String email, String password) throws Exception {
        CustomerDbService custdbservice = dbProviders.getCustomerDbService();
        int userid = -1;
        //userid = custdbservice.doesUserExist(1); or something else like doesexist(email,password)

        //dummy access of database in 2 lines below
        if((email=="worker@gmail.com")&&(password=="worker")){
            userid=2;
        }

        if(userid == -1){
            throw new Exception("Worker not Found. Please try again");//used to send ui layer in catch block if there is error over normal flow
        }
        return userid;
    }

    //return id
    public int register(String name,String email,String password,String city,String area) throws Exception{
        //WorkerDbService workerDbService = WorkerDbServiceProvider.getWorkerService();
        int userid = 0;

        if(password.length() <= 5){
            throw new Exception("Password length must be greater than 5");
        }
        //userid = workerDbService.storeWorker(...)
        if(userid < -1){
            throw new Exception("Worker can not be registered. Please try again");
        }
        return 1;
    }

    public Boolean doesWorkerExist(int id) throws Exception {
        //WorkerDbService workerDbService = WorkerDbServiceProvider.getWorkerService();
        //workerDbService.doesWorkerExist();
        if(id == 2)//id 1 is cid and 2 is wid for fake db
            return true;

        if(id < 0){
            throw new Exception("Invalid id supplied to service");
        }

        return false;
    }

    public WorkerModel getWorker(int id) throws Exception{
        if(id == 2){
            WorkerModel w = new WorkerModel();
            w.id = 2;
            w.name = "ali";
            w.email = "ali@gmail.com";
            w.password = "1234567";
            w.city = "lahore";
            w.area = "faisaltown";
            w.speciality = "plumber";
            w.hourlyRate = 10f;
            w.avgRating = 2.4f;

            return w;
        }
        else{
            throw new Exception("Worker not found");
        }
    }



    public boolean changeHourlyRate(int id,float newRate){
        WorkerModel w = new WorkerModel();
        w.id = 2;
        w.name = "ali";
        w.email = "ali@gmail.com";
        w.password = "1234567";
        w.city = "lahore";
        w.area = "faisaltown";
        w.speciality = "plumber";
        w.hourlyRate = 10f;
        w.avgRating = 2.4f;

        boolean updated = false;
        Worker workerObj = new Worker(w);
        updated = workerObj.changeHourlyRate(newRate);
        //get updated worker model
        w = workerObj.getWorkerModel();
        //store in db


        return updated;
    }
    public boolean changeCity(int id,String newCity){
        WorkerModel w = new WorkerModel();
        w.id = 2;
        w.name = "ali";
        w.email = "ali@gmail.com";
        w.password = "1234567";
        w.city = "lahore";
        w.area = "faisaltown";
        w.speciality = "plumber";
        w.hourlyRate = 10f;
        w.avgRating = 2.4f;

        //w is model
        boolean updated =false;
        Worker workerObj = new Worker(w);
        updated = workerObj.changeCity(newCity);
        //get updated model and store in db
        w = workerObj.getWorkerModel();
        //store in db

        return updated;
    }
    public boolean changeArea(int id,String newArea){

        WorkerModel w = new WorkerModel();
        w.id = 2;
        w.name = "ali";
        w.email = "ali@gmail.com";
        w.password = "1234567";
        w.city = "lahore";
        w.area = "faisaltown";
        w.speciality = "plumber";
        w.hourlyRate = 10f;
        w.avgRating = 2.4f;

        //w is model
        boolean updated =false;
        Worker workerObj = new Worker(w);
        updated = workerObj.changeArea(newArea);
        //get updated model and store in db
        w = workerObj.getWorkerModel();
        //store in db

        return updated;

    }


}
