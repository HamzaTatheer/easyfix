package com.easyfix.Application.models;

public class ComplainModel {
    public int id;
    public int wid;
    public int cid;
    public String text;
    //getters
    ComplainModel getComplainModel(){
        ComplainModel temp=new ComplainModel();
        temp.cid=cid;
        temp.id=id;
        temp.text=text;
        temp.wid=wid;
        return temp;
    }
}
