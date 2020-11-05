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
    public SparePart getSparePart(SparePartModel S) //convert model to class
    {
        SparePart temp=new SparePart();
        temp.id=S.id;
        temp.name=S.name;
        temp.quantity=S.quantity;
        temp.cost=S.cost;
        return temp;
    }
    public SparePartModel getSparePartModel(SparePart S) //convert class to model
    {
        SparePartModel temp=new SparePartModel();
        temp.id=S.id;
        temp.name=S.name;
        temp.quantity=S.quantity;
        temp.cost=S.cost;
        return temp;
    }
}
