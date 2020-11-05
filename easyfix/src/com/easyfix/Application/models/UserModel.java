package com.easyfix.Application.models;

public class UserModel {
    public int id;
    public String name;
    public String email;
    public String password;
    //getters
    public UserModel getUserModel(){
        UserModel temp=new UserModel();
        temp.id=id;
        temp.name=name;
        temp.email=email;
        temp.password=password;
        return  temp;
    }
}
