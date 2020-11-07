package com.easyfix.Application.bl.classes;
import java.util.ArrayList;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.bl.classes.Customer;
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
    Booking(BookingModel obj){
        id=obj.id;
        //customer=obj.customer;
        //cid=obj.cid;
        text=obj.text;
        status=obj.status;
        startTime=obj.startTime;
        endTime=obj.endTime;
    }
    //member functions
    public BookingModel getBookingModel(){
        BookingModel temp=new BookingModel();
        temp.id=id;

        temp.text=text;
        temp.status=status;
        temp.startTime=startTime;
        temp.endTime=endTime;
        return temp;
    }
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
}
