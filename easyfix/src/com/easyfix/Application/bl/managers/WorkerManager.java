package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Worker;
import com.easyfix.Application.bl.services.WorkerService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;

public class WorkerManager implements WorkerService {


    //return id
    public int login(String email, String password) throws Exception {
        DbService dbservice = dbProviders.getDbService();
        int userid = -1;

        if(userid >=0){
            return userid;
        }
        else{
            throw new Exception("User not Found");
        }
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
        DbService db = dbProviders.getDbService();
        return db.does_worker_exist(id);
    }

    public WorkerModel getWorker(int id) throws Exception{
        DbService db = dbProviders.getDbService();
        WorkerModel w = db.get_worker(id);
        if(w == null)
            throw new Exception("Worker is null");

        return w;
    }


    public ArrayList<WorkerModel> getAllWorkers(){
        DbService db = dbProviders.getDbService();
        ArrayList<WorkerModel> w = db.get_all_worker();
        return w;
    }

    public ArrayList<WorkerModel> getWorkers(String city,String area){
        DbService db = dbProviders.getDbService();
        try {
            return db.get_worker(city, area);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ArrayList<WorkerModel>();
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
        Worker workerObj = new Worker(w); //covert model to class
        updated = workerObj.changeHourlyRate(newRate); //update in class
        //get updated worker model
        w = workerObj.getWorkerModel(); //convert class to model
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
        Worker workerObj = new Worker(w); //convert model to  class
        updated = workerObj.changeCity(newCity); //update in class
        //get updated model and store in db
        w = workerObj.getWorkerModel(); // convert class to model
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
        Worker workerObj = new Worker(w);//convert model to class
        updated = workerObj.changeArea(newArea); //update in class
        //get updated model and store in db
        w = workerObj.getWorkerModel(); //get model
        //store in db

        return updated;

    }


}
