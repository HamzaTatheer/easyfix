package com.easyfix.Application.db.textDb;

import com.easyfix.Application.db.services.WorkerDbService;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;

public class WorkerTextManager implements WorkerDbService {
    public boolean store_worker(String name,String email,String password,float average_rating,float hourly_rate,String city,String area,String speciality){
        return true;
    }
    public WorkerModel get_worker(int id){
        WorkerModel w = new WorkerModel();
        w.id=2;
        w.name="worker";
        w.email="worker@gmail.com";
        w.password="worker";
        w.area="dha";
        w.city="lahore";
        w.hourlyRate=20;
        w.speciality="plumber";
        w.avgRating=3;
        return w;
    }
    public int does_worker_exist(String email,String password){
        if((email == "worker@gmail.com")&&(password=="worker")){
            return 2;
        }
        else{
            return -1;
        }
    }
    public boolean does_worker_exist(int id){
        if(id == 2)
            return true;
        else
            return false;
    }
    public ArrayList<WorkerModel> get_worker(String city, String area){
        WorkerModel w = new WorkerModel();
        w.id=2;
        w.name="worker";
        w.email="worker@gmail.com";
        w.password="worker";
        w.area="dha";
        w.city="lahore";
        w.hourlyRate=20;
        w.speciality="plumber";
        w.avgRating=3;
        ArrayList<WorkerModel> aa = new ArrayList<WorkerModel>();
        aa.add(w);
        return aa;
    }
    public ArrayList<WorkerModel> get_all_worker(){
        WorkerModel w = new WorkerModel();
        w.id=2;
        w.name="worker";
        w.email="worker@gmail.com";
        w.password="worker";
        w.area="dha";
        w.city="lahore";
        w.hourlyRate=20;
        w.speciality="plumber";
        w.avgRating=3;
        ArrayList<WorkerModel> aa = new ArrayList<WorkerModel>();
        aa.add(w);
        return aa;
    }
    public boolean update_Worker_city(int id,String city){
        return true;
    }
    public boolean update_Worker_area(int id,String area){
        return true;
    }
    public boolean update_hourly_rate(int id,float rate){
        return true;
    }


}
