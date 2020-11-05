package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.WorkerModel;

public class Worker extends  User{
    public float avgRating;
    public float hourlyRate;
    public String speciality;
    public String city;
    public String area;

    //constructors
    public Worker(WorkerModel model){
        id = model.id;
        name = model.name;
        email =model.email;
        password = model.password;
        avgRating = model.avgRating;
        hourlyRate = model.hourlyRate;
        speciality = model.speciality;
        city = model.city;
        area = model.area;
    }
    //getters
    public WorkerModel getWorkerModel(){

        WorkerModel w = new WorkerModel();
        w.id = id;
        w.name = name;
        w.email =email;
        w.password =password;
        w.hourlyRate = hourlyRate;
        w.speciality = speciality;
        w.city = city;
        w.area =area;
        return w;
    }
    // Setters
    public Boolean changeHourlyRate(float new_rate){
        if(new_rate >= 0) {
            hourlyRate = new_rate;
            return true;
        }
        return false;
    }

    public Boolean changeArea(String newArea){
        area = newArea;
        return true;
    }

    public Boolean changeCity(String newCity){
        city = newCity;
        return true;
    }


}
