package com.easyfix.Application.models;

public class BookingModel {
    public int id;
    public int wid;
    public int cid;
    public String text;
    public String status;
    int hours;
    //getters
    public BookingModel get_BookingModel(){
        BookingModel temp=new BookingModel();
        temp.id=id;
        temp.wid=wid;
        temp.cid=cid;
        temp.text=text;
        temp.status=status;
        temp.hours=hours;
        return temp;
    }
}
