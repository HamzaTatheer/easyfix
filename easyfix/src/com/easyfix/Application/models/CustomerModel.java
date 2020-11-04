package com.easyfix.Application.models;

import com.easyfix.Application.bl.classes.User;

import java.util.ArrayList;

public class CustomerModel extends UserModel{
    public Float wallet;
    public String creditno;
    public String paymentMethod;
    public String city;
    public String area;
    public ArrayList<FavouriteModel>Favourites;
}
