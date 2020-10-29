package com.easyfix.Application.ui.Terminal;

import com.easyfix.Application.bl.CustomerProvider;
import com.easyfix.Application.bl.CustomerService;
import com.easyfix.Application.ui.UI;

public class Terminal extends UI {

    public Terminal(){
        super();
    }
    public void start(){
        int userid = customerService.login("hamza@gmail.com","12356");
        System.out.println("Logined User ID: ");
        System.out.print(userid);
    }
}
