package com.easyfix.Application.bl.classes;

public class User {
    public int id;
    public String name;
    public String email;
    public String password;

    public Boolean changePassword(String newPassword){
        password = newPassword;
        return true;
    }

    User(){

    }

}
