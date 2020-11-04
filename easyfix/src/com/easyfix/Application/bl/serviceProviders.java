package com.easyfix.Application.bl;

import com.easyfix.Application.bl.managers.ChatManager;
import com.easyfix.Application.bl.managers.CustomerManager;
import com.easyfix.Application.bl.managers.UserManager;
import com.easyfix.Application.bl.managers.WorkerManager;
import com.easyfix.Application.bl.services.ChatService;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.bl.services.UserService;
import com.easyfix.Application.bl.services.WorkerService;

public class serviceProviders{
    public static CustomerService getCustomerService(){
        return new CustomerManager();
    }
    public static ChatService getChatService() {return new ChatManager();}
    public static UserService getUserService() {return new UserManager(); }
    public static WorkerService getWorkerService(){return new WorkerManager();}
}
