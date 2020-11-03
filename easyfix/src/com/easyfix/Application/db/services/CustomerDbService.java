package com.easyfix.Application.db.services;

public interface CustomerDbService {
    public int doesUserExist(String email,String password);
}
