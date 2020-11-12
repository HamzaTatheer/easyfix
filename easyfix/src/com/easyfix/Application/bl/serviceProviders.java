package com.easyfix.Application.bl;

import com.easyfix.Application.bl.managers.*;
import com.easyfix.Application.bl.services.*;
import com.easyfix.Application.models.ComplainModel;

public class serviceProviders{
    public static CustomerService getCustomerService(){
        return new CustomerManager();
    }
    public static ChatService getChatService() {return new ChatManager();}
    public static UserService getUserService() {return new UserManager(); }
    public static WorkerService getWorkerService(){return new WorkerManager();}
    public static BookingService getBookingService(){return new BookingManager();}
    public static SparePartService getSparePartService(){return new SparePartManager();}
    public static ComplainService getComplainService(){return new ComplainManager();}
    public static RatingService getRatingService(){return new RatingManager();}
    public static  BillingService getBillingService(){return new BillingManager();}

}
