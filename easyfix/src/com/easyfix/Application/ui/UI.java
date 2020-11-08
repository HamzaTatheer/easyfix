package com.easyfix.Application.ui;
import com.easyfix.Application.bl.serviceProviders;
import com.easyfix.Application.bl.services.BookingService;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.bl.services.WorkerService;

public abstract class UI {
    public CustomerService customerService;
    public WorkerService workerService;
    public BookingService bookingService;
    public UI(){
        customerService = serviceProviders.getCustomerService();
        workerService = serviceProviders.getWorkerService();
        bookingService = serviceProviders.getBookingService();
    }

}

