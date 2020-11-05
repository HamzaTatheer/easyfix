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
    User(UserModel U){
        id=U.id;
        name=U.name;
        email=U.email;
        password=U.password;
    }
    //getters

    public UserModel getUserModel(){
        UserModel temp=new UserModel();
        temp.id=id;
        temp.name=name;
        temp.email=email;
        temp.password=password;
        return  temp;
    }
    //Setters
    public Boolean changePassword(String newPassword){
        password = newPassword;
        return true;
    }
}
