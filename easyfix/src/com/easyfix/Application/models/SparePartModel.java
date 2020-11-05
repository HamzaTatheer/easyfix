package com.easyfix.Application.models;

public class SparePartModel {
    public int id;
    public String name;
    public float cost;
    public int quantity;
    //getters
    public SparePartModel getSparePartModel()
    {
        SparePartModel temp=new SparePartModel();
        temp.id=id;
        temp.name=name;
        temp.quantity=quantity;
        temp.cost=cost;
        return temp;
    }
}
