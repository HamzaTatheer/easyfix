package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.FavouriteModel;

import java.io.*;
import java.util.*;
public class Favourite {
    public Worker obj=new Worker();
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
    public FavouriteModel get_Favourite_Model(FavouriteModel F){
        FavouriteModel f=new FavouriteModel();
        f.obj.name=F.obj.name;
        f.obj.email=F.obj.email;
        f.obj.id=F.obj.id;
        f.obj.area=F.obj.area;
        f.obj.city=F.obj.city;
        f.obj.password=F.obj.password;
        f.obj.hourlyRate=F.obj.hourlyRate;
        f.obj.speciality=F.obj.speciality;
        f.obj.avgRating=F.obj.avgRating;
        f.obj.rating=F.obj.rating;
        return f;
    }

}
