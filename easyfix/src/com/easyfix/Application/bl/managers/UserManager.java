package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.classes.User;
import com.easyfix.Application.bl.services.UserService;
import com.easyfix.Application.models.UserModel;

public class UserManager implements UserService {
    public UserModel getUser(int id) throws Exception {
        if(id == 1){
            UserModel u = new UserModel();
            u.id=1;
            u.name="Hamza Customer";
            u.email= "hamza@gmail.com";
            return u;
        }
        else if(id == 2){
            UserModel u = new UserModel();
            u.id=2;
            u.name="Ali Worker";
            u.email= "ali@gmail.com";
            return u;
        }
        throw new Exception("no User Found");
    }

    public String getUserSpeciality(int id) throws Exception {
            if(id == 1){
                return "customer";
            }
            else if(id==2){
                return "worker";
            }
            else{
                throw new Exception("User not Found");
            }
    }


}
