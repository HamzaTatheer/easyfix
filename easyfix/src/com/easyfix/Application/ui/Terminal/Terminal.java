package com.easyfix.Application.ui.Terminal;

import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.ui.UI;
import java.util.*;

public class Terminal extends UI {

    public Terminal(){
        super();
    }

    public void start(){
        String email = "hamza@gmail.com";
        String password = "12356";
        int userid;
        try {
            userid = customerService.login(email, password);
            System.out.println("Logined User ID: ");
            System.out.print(userid);
        }
        catch(Exception e) {
            System.out.println("Error!!!!");
        }

    }
}
