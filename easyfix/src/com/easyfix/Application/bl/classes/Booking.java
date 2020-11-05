package com.easyfix.Application.bl.classes;
import java.util.ArrayList;
import com.easyfix.Application.models.BookingModel;
import java.time.LocalDateTime;
public class Booking {
    public int id;
    public Customer customer;
    public Worker worker;
    public String text;
    public String status;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    public ArrayList<SparePart> spareParts;
    //constructors

    Booking(BookingModel obj){
        id=obj.id;
        customer=obj.customer;
        cid=obj.cid;
        text=obj.text;
        status=obj.status;
        startTime=obj.startTime;
        endTime=obj.endTime;
    }
    //setters


    //getters
    public BookingModel getBookingModel(Booking obj){  //convert class to model
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
