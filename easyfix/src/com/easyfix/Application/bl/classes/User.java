package com.easyfix.Application.bl.classes;
import com.easyfix.Application.models.UserModel;

import java.io.*;
import java.util.*;
public class User {

    protected int id;
    protected String name;
    protected String email;
    protected String password;
    //constructors
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
    //member functions
    public UserModel getUserModel(){
        UserModel temp=new UserModel();
        temp.id=id;
        temp.name=name;
        temp.email=email;
        temp.password=password;
        return  temp;
    }
    public Boolean changePassword(String newPassword){ //use setPassword
        password = newPassword;
        return true;
    }
    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
