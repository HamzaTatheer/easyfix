package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.WorkerModel;
import java.io.*;
import java.util.*;
public class Worker extends  User{
    public float avgRating;
    public float hourlyRate;
    public String speciality;
    public String city;
    public String area;

    //constructors
    Worker(){

    }
    Worker(int _id,String _name,String _email,String _password,String _city,String _area,float _avgrating, float _HourlyRate,String _speciality,String _location){
        id = _id;
        name = _name;
        email =_email;
        password =_password;
        avgRating = _avgrating;
        hourlyRate = _HourlyRate;
        speciality = _speciality;
        city = _city;
        area = _area;
    }
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
    //getters

    public float getAvgRating() {
        return avgRating;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getSpeciality() {
        return speciality;
    }
    public WorkerModel getWorkerModel(){

        WorkerModel w = new WorkerModel();
        w.id = id;
        w.name = name;
        w.email =email;
        w.password =password;
        w.hourlyRate = hourlyRate;
        w.speciality = speciality;
        w.city = city;
        w.area = area;
        return w;
    }
}
