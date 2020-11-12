package com.easyfix.Application.bl.services;

import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;

public interface WorkerService {
    public int login(String email,String password) throws Exception; //done
    public WorkerModel getWorker(int id) throws Exception;
    public ArrayList<WorkerModel> getAllWorkers();
    public ArrayList<WorkerModel> getWorkers(String city,String area);
    public boolean changeHourlyRate(int id,float newRate);
    public boolean changeCity(int id,String newCity);//send location
    public boolean changeArea(int id,String newArea);//send location
    public Boolean doesWorkerExist(int id) throws Exception;
}