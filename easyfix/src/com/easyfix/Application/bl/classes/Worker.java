package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.WorkerModel;

public class Worker extends  User{
    public float avgRating;
    public float hourlyRate;
    public String speciality;
    public String city;
    public String area;
    public int[] rating;

    //constructors
    Worker(){

    }
    Worker(int _id,String _name,String _email,String _password,float _avgRating, float _HourlyRate,String _speciality,String _city,String _area,int []_rating){
        id = _id;
        name = _name;
        email =_email;
        password =_password;
        avgRating = _avgRating;
        hourlyRate = _HourlyRate;
        speciality = _speciality;
        city = _city;
        area = _area;
        rating=_rating;
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
        rating=model.rating;
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
    public Worker getWorker(WorkerModel model){ // convert model to class

        Worker w = new Worker();
        w.id = model.id;
        w.name = model.name;
        w.email =model.email;
        w.password =model.password;
        w.hourlyRate = model.hourlyRate;
        w.speciality = model.speciality;
        w.city = model.city;
        w.area = model.area;
        w.rating=model.rating;
        return w;
    }
    public WorkerModel getWorkerModel(Worker temp){ // convert class to model

        WorkerModel w = new WorkerModel();
        w.id = temp.id;
        w.name = temp.name;
        w.email =temp.email;
        w.password =temp.password;
        w.hourlyRate = temp.hourlyRate;
        w.speciality = temp.speciality;
        w.city = temp.city;
        w.area = temp.area;
        w.rating=temp.rating;
        return w;
    }

}
