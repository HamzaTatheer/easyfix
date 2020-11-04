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
        _text=text;
        _status=status;
    }
    Booking(BookingModel B){
        id=B.id;
        wid=B.wid;
        cid=B.cid;
        text=B.text;
        status=B.status;

    }
    //setters


    //getters
    public BookingModel get_BookingModel(){
        BookingModel temp=new BookingModel();
        temp.id=id;
        temp.wid=wid;
        temp.cid=cid;
        temp.text=text;
        temp.status=status;
        return temp;
    }
}
