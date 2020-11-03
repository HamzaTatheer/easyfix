package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.WorkerModel;

public class Worker extends  User{
    public float avgRating;
    public float HourlyRate;
    public String speciality;
    public String city;
    public String area;

    Worker(int _id,String _name,String _email,String _password,String _city,String _area,float avgrating, float _HourlyRate,String _speciality,String _location){
        id = _id;
        name = _name;
        email =_email;
        password =_password;
        avgRating = avgrating;
        HourlyRate = _HourlyRate;
        speciality = _speciality;
        city = _city;
        area = _area;
    }

    Worker(WorkerModel model){
        id = model.id;
        name = model.name;
        email =model.email;
        password = model.password;
        avgRating = model.avgRating;
        HourlyRate = model.hourlyRate;
        speciality = model.speciality;
        city = model.city;
        area = model.area;
    }

    public WorkerModel getWorkerModel(){

        WorkerModel w = new WorkerModel();
        w.id = id;
        w.name = name;
        w.email =email;
        w.password =password;
        w.hourlyRate = HourlyRate;
        w.speciality = speciality;
        w.city = city;
        w.area = area;
        return w;
    }



    public Boolean changeHourlyRate(float new_rate){
        if(new_rate >= 0) {
            HourlyRate = new_rate;
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
