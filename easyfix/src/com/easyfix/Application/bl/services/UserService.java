package com.easyfix.Application.bl.services;

import com.easyfix.Application.models.UserModel;

public interface UserService {
    public UserModel getUser(int id) throws Exception;
    public String getUserSpeciality(int id) throws Exception;
    public String getUserName(int id) throws Exception;
}
