package com.easyfix.Application.models;

public class WorkerModel extends UserModel{
    public float avgRating;
    public float hourlyRate;
    public String speciality;
    public String city;
    public String area;
    public int[] rating;

    //getters
    public WorkerModel getWorkerModel(){
        WorkerModel temp=new WorkerModel();
        temp.id=id;
        temp.name=name;
        temp.email=email;
        temp.password=password;
        temp.avgRating=avgRating;
        temp.hourlyRate=hourlyRate;
        temp.speciality=speciality;
        temp.city=city;
        temp.area=area;
        temp.rating=rating;
        return temp;
    }
}