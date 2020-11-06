package com.easyfix.Application.bl.classes;
import java.util.ArrayList;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.bl.classes.Customer;
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
        //customer=obj.customer;
        //cid=obj.cid;
        text=obj.text;
        status=obj.status;
        startTime=obj.startTime;
        endTime=obj.endTime;
    }
    //setters


    //getters
    public BookingModel getBookingModel(){
        BookingModel temp=new BookingModel();
        temp.id=id;

        temp.text=text;
        temp.status=status;
        temp.startTime=startTime;
        temp.endTime=endTime;
        return temp;
    }


}
