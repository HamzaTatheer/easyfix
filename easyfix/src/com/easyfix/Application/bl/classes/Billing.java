package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.BillingModel;
import com.easyfix.Application.models.BookingModel;

public class Billing {
    int bookingId;
    String title;
    String customerName;
    String workerName;
    String status;
    Float totalCost;

    Billing(int _bookingId,String _title,String _customerName,String _workerName,String _status,Float _TotalCost){
        bookingId = _bookingId;
        title = _title;
        customerName = _customerName;
        workerName = _workerName;
        status = _status;
        totalCost = _TotalCost;
    }

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


}
