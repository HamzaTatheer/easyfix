package com.easyfix.Application.bl.classes;
import java.util.ArrayList;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.WorkerModel;

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

    Booking(int _id,String _text,String _status,LocalDateTime _startTime,LocalDateTime _endTime,ArrayList<SparePart> _spareparts,Customer _customer,Worker _worker){
        id = _id;
        text = _text;
        status = _status;
        startTime = _startTime;
        endTime = _endTime;
        spareParts = _spareparts;
        customer = _customer;
        worker = _worker;
    }


    public BookingModel getBookingModel(){
        BookingModel temp=new BookingModel();
        temp.id=id;
        temp.text=text;
        temp.status=status;
        temp.startTime=startTime;
        temp.endTime=endTime;
        temp.customerModel = new CustomerModel(customer);
        temp.workerModel = new WorkerModel(worker);
        return temp;
    }
}
