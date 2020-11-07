package com.easyfix.Application.models;

import com.easyfix.Application.bl.classes.Worker;

import java.util.ArrayList;

public class WorkerModel {
    public int id;
    public String name;
    public String email;
    public String password;
    public float avgRating;
    public float hourlyRate;
    public String city;
    public String area;
    public String speciality;


    WorkerModel(Worker w){
        id = w.id;
        name = w.name;
        email = w.email;
        password = w.password;
        avgRating = w.avgRating;
        hourlyRate = w.hourlyRate;
        city = w.city;
        area = w.area;
        speciality = w.speciality;
    }


}
