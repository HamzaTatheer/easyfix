package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.BookingModel;

public class Booking {
    public int id;
    public int wid;
    public int cid;
    public String text;
    public String status;
    //constructors
    Booking(){

    }
    Booking(int _id,int _wid,int _cid,String _text,String _status){
        id=_id;
        wid=_wid;
        cid=_cid;
        text=_text;
        status=_status;
    }
    Booking(BookingModel obj){
        id=obj.id;
        wid=obj.wid;
        cid=obj.cid;
        text=obj.text;
        status=obj.status;

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
        return temp;
    }
}
