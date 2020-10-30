package com.easyfix.Application.bl.classes;

public class Worker extends  User{
    float HourlyRate;
    String speciality;
    String location;

    Worker(int _id,String _name,String _email,String _password, float _HourlyRate,String _speciality,String _location){
        id = _id;
        name = _name;
        email =_email;
        password =_password;
        HourlyRate = _HourlyRate;
        speciality = _speciality;
        location = _location;
    }

    public Boolean changeHourlyRate(float new_rate){
        if(new_rate >= 0) {
            HourlyRate = new_rate;
            return true;
        }
        return false;
    }

    public Boolean changeLocation(String new_location){
        location = new_location;
        return true;
    }

}
