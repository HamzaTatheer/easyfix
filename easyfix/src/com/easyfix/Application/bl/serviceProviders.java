package com.easyfix.Application.bl;

import com.easyfix.Application.bl.managers.CustomerManager;
import com.easyfix.Application.bl.services.CustomerService;

public class serviceProviders{
    public static CustomerService getCustomerService(){
        return new CustomerManager();
    }
}
