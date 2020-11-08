package com.easyfix.Application.bl.classes;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.WorkerModel;

import java.time.LocalDateTime;
public class Booking {
    private int id;
    private Customer customer;
    private Worker worker;
    private String text;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ArrayList<SparePart> spareParts;
    //constructors

    public Booking(int _id, String _text, String _status, LocalDateTime _startTime, LocalDateTime _endTime, ArrayList<SparePart> _spareparts, Customer _customer, Worker _worker){
        id = _id;
        text = _text;
        status = _status;
        startTime = _startTime;
        endTime = _endTime;
        spareParts = _spareparts;
        customer = _customer;
        worker = _worker;
    }

/*
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
    }*/
    //getters
    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Worker getWorker() {
        return worker;
    }

    public String getText() {
        return text;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ArrayList<SparePart> getSpareParts() {
        return spareParts;
    }

    //setters


    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setSpareParts(ArrayList<SparePart> spareParts) {
        this.spareParts = spareParts;
    }

    public String toString(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String res =  ("id: " + id + " title: " + text + "Worker Name: "+worker.getName()+ " Customer Name: "+customer.getName() + " StartTime: " +startTime.format(format));
        if((endTime != null)&&(startTime != endTime)){
            res+= " End Time: "+ endTime.format(format);
        }
        return res;
    }

    public boolean hasSameStartTime(Booking b){
        return (startTime.getDayOfMonth() == b.startTime.getDayOfMonth())&&(startTime.getMonthValue()==b.startTime.getMonthValue())&&(startTime.getYear() == b.startTime.getYear())&&(startTime.getHour() == b.startTime.getHour())&&(startTime.getMinute() == b.startTime.getMinute());
    }
}
