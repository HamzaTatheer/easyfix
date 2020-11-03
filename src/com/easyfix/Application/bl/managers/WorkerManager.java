package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.services.WorkerService;

public class WorkerManager implements WorkerService {
    public int doesWorkerExist(int id){
        return 0; // 0 for not found or else id is returned
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
