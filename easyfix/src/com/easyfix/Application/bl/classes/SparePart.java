package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.SparePartModel;

public class SparePart {
    int id;
    String name;
    int quantity;
    float cost;

    //constructors
    SparePart(SparePartModel S){
        id=S.id;
        name=S.name;
        quantity=S.quantity;
        cost=S.cost;
    }
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
    //setters

}
