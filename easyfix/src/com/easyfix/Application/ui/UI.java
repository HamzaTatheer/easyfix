package com.easyfix.Application.ui;
import com.easyfix.Application.bl.serviceProviders;
import com.easyfix.Application.bl.services.*;

public abstract class UI {
    public UserService userService;
    public CustomerService customerService;
    public WorkerService workerService;
    public BookingService bookingService;
    public ComplainService complainService;
    public RatingService ratingService;
    public BillingService billingService;
    public ChatService chatService;
    public SparePartService sparePartService;

    public UI(){
        customerService = serviceProviders.getCustomerService();
        workerService = serviceProviders.getWorkerService();
        bookingService = serviceProviders.getBookingService();
        userService = serviceProviders.getUserService();
        complainService = serviceProviders.getComplainService();
        ratingService = serviceProviders.getRatingService();
        billingService = serviceProviders.getBillingService();
        chatService = serviceProviders.getChatService();
        sparePartService = serviceProviders.getSparePartService();
    }

}

