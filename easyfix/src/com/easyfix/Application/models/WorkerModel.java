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


    public WorkerModel(){
        id=-1;
        name="none";
        email="none";
        password="none";
        avgRating=0f;
        hourlyRate=0f;
        city="none";
        area="none";
        speciality="none";
    }


    WorkerModel(Worker w){
        id = w.getId();
        name = w.getName();
        email = w.getEmail();
        password = w.getPassword();
        avgRating = w.getAvgRate();
        hourlyRate = w.getHourlyRate();
        city = w.getCity();
        area = w.getArea();
        speciality = w.getSpeciality();
    }


}
