package com.easyfix.Application.bl.serviceProviders;

import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.bl.managers.CustomerManager;

public class CustomerProvider {
    public static CustomerService getCustomerService(){
        return new CustomerManager();
    }
}