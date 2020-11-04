package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.FavouriteModel;

import java.io.*;
import java.util.*;
public class Favourite {
    public Worker obj=new Worker();
    //constructors
    Favourite(Worker W){
        obj=W;
    }
    Favourite(FavouriteModel F){
        obj.name=F.obj.name;
        obj.email=F.obj.email;
        obj.id=F.obj.id;
        obj.area=F.obj.area;
        obj.city=F.obj.city;
        obj.hourlyRate=F.obj.hourlyRate;
        obj.speciality=F.obj.speciality;
        obj.avgRating=F.obj.avgRating;
    }
    //setters

    //getters
    public Worker getObj() {
        return obj;
    }
    public FavouriteModel get_Favourite_Model(){
        FavouriteModel f=new FavouriteModel();
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
