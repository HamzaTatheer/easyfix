package com.easyfix.Application.bl;

import com.easyfix.Application.bl.managers.*;
import com.easyfix.Application.bl.services.*;

public class serviceProviders{
    public static CustomerService getCustomerService(){
        return new CustomerManager();
    }
    public static ChatService getChatService() {return new ChatManager();}
    public static UserService getUserService() {return new UserManager(); }
    public static WorkerService getWorkerService(){return new WorkerManager();}
    public static BookingService getBookingService(){return new BookingManager();}
}
