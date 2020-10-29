package com.easyfix.Application.bl;

public class CustomerProvider {
    public static CustomerService getCustomerService(){
        return new CustomerManager();
    }
}