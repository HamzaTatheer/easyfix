package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.BookingModel;
import java.time.LocalDateTime;
public class Booking {
    public int id;
    public int wid;
    public int cid;
    public String text;
    public String status;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    //constructors
    Booking(){

    }
    Booking(int _id,int _wid,int _cid,String _text,String _status,LocalDateTime _startTime,LocalDateTime _endTime){
        id=_id;
        wid=_wid;
        cid=_cid;
        text=_text;
        status=_status;
        startTime=_startTime;
        endTime=_endTime;
    }
    Booking(BookingModel obj){
        id=obj.id;
        wid=obj.wid;
        cid=obj.cid;
        text=obj.text;
        status=obj.status;
        startTime=obj.startTime;
        endTime=obj.endTime;

    }
    //setters


    //getters
    public BookingModel getBookingModel(Booking obj){  //return BookingModel
        BookingModel temp=new BookingModel();
        temp.id=obj.id;
        temp.wid=obj.wid;
        temp.cid=obj.cid;
        temp.text=obj.text;
        temp.status=obj.status;
        temp.startTime=obj.startTime;
        temp.endTime=obj.endTime;
        return temp;
    }
}
