package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.BillingModel;
import com.easyfix.Application.models.BookingModel;

public class Billing {
    private int bookingId;
    private String title;
    private String customerName;
    private String workerName;
    private String status;
    private Float totalCost;
    //constructors
    Billing(int _bookingId,String _title,String _customerName,String _workerName,String _status,Float _TotalCost){
        bookingId = _bookingId;
        title = _title;
        customerName = _customerName;
        workerName = _workerName;
        status = _status;
        totalCost = _TotalCost;
    }
    //member functions
    BillingModel getBillingModel(){
        BillingModel b = new BillingModel();
        b.bookingId = bookingId;
        b.workerName = workerName;
        b.customerName = customerName;
        b.title = title;
        b.status = status;
        return b;
    }

    public boolean changeStatusToPaid(){
        status = "paid";
        return true;
    }
    public boolean changeStatusToUnPaid(){
        status = "unpaid";
        return true;
    }

    public boolean isStatusPaid(){
        if(status == "paid")
            return true;
        else
            return false;
    }
    //getters

    public int getBookingId() {
        return bookingId;
    }

    public String getTitle() {
        return title;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public String getStatus() {
        return status;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    //setters

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }
}
