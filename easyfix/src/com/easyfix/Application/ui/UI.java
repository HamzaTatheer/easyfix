package com.easyfix.Application.ui;
import com.easyfix.Application.bl.serviceProviders;
import com.easyfix.Application.bl.services.ChatService;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.bl.services.UserService;
import com.easyfix.Application.models.UserModel;

public abstract class UI {
    public CustomerService customerService;
    public ChatService chatService;
    public UserService userService;

    public UI(){
        customerService = serviceProviders.getCustomerService();
        chatService = serviceProviders.getChatService();
        userService = serviceProviders.getUserService();
    }

}

