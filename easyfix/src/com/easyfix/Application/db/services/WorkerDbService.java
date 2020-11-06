package com.easyfix.Application.db.services;

import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;

public interface WorkerDbService {
    public boolean store_worker(String name,String email,String password,float average_rating,float hourly_rate,String city,String area,String speciality);//id given by default by DB
    public WorkerModel get_worker(int id);
    public int does_worker_exist(String email,String password);
    public boolean does_worker_exist(int id);
    public ArrayList<WorkerModel> get_worker(String city, String area);
    public ArrayList<WorkerModel> get_all_worker();
    public boolean update_Worker_city(int id,String city);
    public boolean update_Worker_area(int id,String area);
    public boolean update_hourly_rate(int id,float rate);
}
