package com.easyfix.Application.ui;
import com.easyfix.Application.bl.serviceProviders.CustomerProvider;
import com.easyfix.Application.bl.services.CustomerService;

public abstract class UI {
    public CustomerService customerService;

    public UI(){
        customerService = CustomerProvider.getCustomerService();
    }

}

