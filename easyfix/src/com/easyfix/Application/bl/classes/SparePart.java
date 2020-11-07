package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.SparePartModel;

public class SparePart {
    private int id;
    private String name;
    private int quantity;
    private float cost;

    //constructors
    SparePart(SparePartModel S){
        id=S.id;
        name=S.name;
        quantity=S.quantity;
        cost=S.cost;
    }
    //member functions
    public SparePartModel getSparePartModel()
    {
        SparePartModel temp=new SparePartModel();
        temp.id=id;
        temp.name=name;
        temp.quantity=quantity;
        temp.cost=cost;
        return temp;
    }
    //getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getCost() {
        return cost;
    }
    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
