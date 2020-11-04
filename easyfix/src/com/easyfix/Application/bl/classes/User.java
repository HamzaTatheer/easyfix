package com.easyfix.Application.bl.classes;
import java.io.*;
import java.util.*;
public class User {
    public int id;
    public String name;
    public String email;
    public String password;

    public Boolean changePassword(String newPassword){
        password = newPassword;
        return true;
    }
    public User(){

    }

    public String getName(){
        return name;
    }



}
