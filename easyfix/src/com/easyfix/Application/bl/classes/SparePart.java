package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.SparePartModel;

public class SparePart {
    int id;
    String name;
    int quantity;
    float cost;

    //constructors
    SparePart(){

    }
    SparePart(int _id,String _name,int _quantity,float _cost){
        id=_id;
        name=_name;
        quantity=_quantity;
        cost=_cost;
    }
    SparePart(SparePartModel S){
        id=S.id;
        name=S.name;
        quantity=S.quantity;
        cost=S.cost;
    }
    //setters

    //getters
    public int getId() {
        return id;
    }

    public float getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
    public SparePartModel get_SparePartModel()
    {
        SparePartModel temp=new SparePartModel();
        temp.cost=cost;
        temp.id=id;
        temp.name=name;
        temp.quantity=quantity;
        return temp;
    }
}
