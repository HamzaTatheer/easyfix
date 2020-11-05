package com.easyfix.Application.models;

import java.time.LocalDateTime;

public class BookingModel {
    public int id;
    public int wid;
    public int cid;
    public String text;
    public String status;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    //getters
    public BookingModel get_BookingModel(){
        BookingModel temp=new BookingModel();
        temp.id=id;
        temp.wid=wid;
        temp.cid=cid;
        temp.text=text;
        temp.status=status;
        temp.startTime=startTime;
        temp.endTime=endTime;
        return temp;
    }
}
