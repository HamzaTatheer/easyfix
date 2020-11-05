package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.FavouriteModel;

import java.io.*;
import java.util.*;
public class Favourite {
    public Worker obj;
    //constructors
    Favourite(){

    }
    Favourite(Worker F){
        obj=new Worker();
        obj.name=F.name;
        obj.email=F.email;
        obj.id=F.id;
        obj.area=F.area;
        obj.city=F.city;
        obj.hourlyRate=F.hourlyRate;
        obj.speciality=F.speciality;
        obj.avgRating=F.avgRating;
        obj.rating=F.rating;
    }
    Favourite(FavouriteModel F){
        obj=new Worker();
        obj.name=F.obj.name;
        obj.email=F.obj.email;
        obj.id=F.obj.id;
        obj.area=F.obj.area;
        obj.city=F.obj.city;
        obj.hourlyRate=F.obj.hourlyRate;
        obj.speciality=F.obj.speciality;
        obj.avgRating=F.obj.avgRating;
        obj.rating=F.obj.rating;
    }
    //setters

    //getters
    public Worker getObj() {
        return obj;
    }
    public Favourite getFavourite(FavouriteModel temp){ //convert model to class
        Favourite f=new Favourite();
        f.obj.name=temp.obj.name;
        f.obj.email=temp.obj.email;
        f.obj.id=temp.obj.id;
        f.obj.area=temp.obj.area;
        f.obj.city=temp.obj.city;
        f.obj.password=temp.obj.password;
        f.obj.hourlyRate=temp.obj.hourlyRate;
        f.obj.speciality=temp.obj.speciality;
        f.obj.avgRating=temp.obj.avgRating;
        f.obj.rating=temp.obj.rating;
        return f;
    }
    public FavouriteModel getFavouriteModel(Favourite temp){ //convert class to model
        FavouriteModel f=new FavouriteModel();
        f.obj.name=temp.obj.name;
        f.obj.email=temp.obj.email;
        f.obj.id=temp.obj.id;
        f.obj.area=temp.obj.area;
        f.obj.city=temp.obj.city;
        f.obj.password=temp.obj.password;
        f.obj.hourlyRate=temp.obj.hourlyRate;
        f.obj.speciality=temp.obj.speciality;
        f.obj.avgRating=temp.obj.avgRating;
        f.obj.rating=temp.obj.rating;
        return f;
    }

}
