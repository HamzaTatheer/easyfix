package com.easyfix.Application.ui;

import com.easyfix.Application.Application;
import com.easyfix.Application.bl.CustomerProvider;
import com.easyfix.Application.bl.CustomerService;
import com.easyfix.Application.ui.Gui.Gui;
import com.easyfix.Application.ui.Terminal.Terminal;

public abstract class UI {
    public CustomerService customerService;

    public UI(){
        customerService = CustomerProvider.getCustomerService();
    }

}
