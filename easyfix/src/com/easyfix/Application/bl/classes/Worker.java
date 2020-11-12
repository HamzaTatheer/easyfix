package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.WorkerModel;
public class Worker extends  User{
    private float avgRating;
    private float hourlyRate;
    private String speciality;
    private String city;
    private String area;

    //constructors
    public Worker(WorkerModel model){
        super(model.id,model.name,model.email,model.password);
        avgRating = model.avgRating;
        hourlyRate = model.hourlyRate;
        speciality = model.speciality;
        city = model.city;
        area = model.area;
    }
    //getters
    public WorkerModel getWorkerModel(){

        WorkerModel w = new WorkerModel();
        w.id = id;
        w.name = name;
        w.email =email;
        w.password =password;
        w.hourlyRate = hourlyRate;
        w.speciality = speciality;
        w.city = city;
        w.area =area;
        return w;
    }

    public static boolean isRatingCorrect(float value){
        if((value >=0)&&(value <=5))
            return true;
        else
            return false;
    }

    public Float getAvgRate(){
        return avgRating;
    }

    public Float getHourlyRate(){
        return hourlyRate;
    }

    public String getSpeciality(){
        return speciality;
    }

    public String getCity(){
        return city;
    }

    public String getArea(){
        return area;
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


}
