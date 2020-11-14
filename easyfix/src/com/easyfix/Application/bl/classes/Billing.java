package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.BillingModel;
import com.easyfix.Application.models.BookingModel;

public class Billing {
    private int bookingId;
    private String title;
    private int cid;
    private int wid;
    private String status;
    private Float totalCost;
    //constructors
    public Billing(int _bookingId, String _title, int _cid, int _wid, String _status, Float _TotalCost){
        bookingId = _bookingId;
        title = _title;
        cid = _cid;
        wid = _wid;
        status = _status;
        totalCost = _TotalCost;
    }
    //member functions
    BillingModel getBillingModel(){
        BillingModel b = new BillingModel();
        b.bookingId = bookingId;
        b.wid =wid;
        b.cid = cid;
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

    public int getCustomerId() {
        return cid;
    }

    public int getWorkerId() {
        return wid;
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

    public void setCustomerId(int _id) {
        this.cid = _id;
    }

    public void setWorkerName(int _wid) {
        this.wid = _wid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }
}
