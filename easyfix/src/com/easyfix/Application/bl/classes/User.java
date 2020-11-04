package com.easyfix.Application.bl.classes;
import com.easyfix.Application.models.UserModel;

import java.io.*;
import java.util.*;
public class User {
    public int id;
    public String name;
    public String email;
    public String password;

    //constructors
    User(){

    }
    User(int _id,String _name,String _email,String _password){
        id=_id;
        name=_name;
        email=_email;
        password=_password;
    }
    User(UserModel U){
        id=U.id;
        name=U.name;
        email=U.email;
        password=U.password;
    }
    //Setters
    public Boolean changePassword(String newPassword){
        password = newPassword;
        return true;
    }
    //getters
    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public UserModel get_User_Model(UserModel U){
        UserModel temp=new UserModel();
        temp.name=U.name;
        temp.email=U.email;
        temp.password=U.password;
        return  temp;
    }
}
