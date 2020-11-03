package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.services.WorkerService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.CustomerDbService;

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

    public int doesWorkerExist(int id) throws Exception {
        //WorkerDbService workerDbService = WorkerDbServiceProvider.getWorkerService();
        int userid = -1;
        //workerDbService.doesWorkerExist();
        if(userid < 0){
            throw new Exception("Worker Does not exist");
        }

        return userid;
    }
    public int getActiveBookings(int id){
        return 0;
    }
    public int getFinishedBookings(int id){ // change return type to appointment
        return 0;
    }
    public Boolean sendLocation(String newLocation){
        //change location using db service
        return true;
    }

}
