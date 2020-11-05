package com.easyfix.Application.models;

import com.easyfix.Application.bl.classes.Worker;

public class FavouriteModel {
    public WorkerModel obj;
    //Constructors
    public FavouriteModel(){

    }
    //getters
    public FavouriteModel getFavouriteModel(){
        FavouriteModel f=new FavouriteModel();
        obj=new WorkerModel();
        f.obj.name=obj.name;
        f.obj.email=obj.email;
        f.obj.id=obj.id;
        f.obj.area=obj.area;
        f.obj.city=obj.city;
        f.obj.password=obj.password;
        f.obj.hourlyRate=obj.hourlyRate;
        f.obj.speciality=obj.speciality;
        f.obj.avgRating=obj.avgRating;
        return f;
    }
}
