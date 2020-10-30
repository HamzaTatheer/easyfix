package com.easyfix.Application.db;

import com.easyfix.Application.models.Customer;

public interface DBService {
    public int doesUserExist(String email,String password);
    public Customer getCustomer();
}



//CustomerService
//ChatService
//WorkerService
//AppointmentService


//Customer