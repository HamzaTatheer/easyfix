package com.easyfix.Application.ui.Terminal;

import com.easyfix.Application.ui.UI;

import java.util.ArrayList;

public class Terminal extends UI {

    public Terminal(){
        super();
    }
    public void start(){
/*
    simple login that prints exception if there is error
        try {
            int userid = customerService.login("hamza@gmail.com", "12356");
            System.out.println("Logined User ID: ");
            System.out.print(userid);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
*/


        ArrayList<Integer> favourites = customerService.getFavourites(1);
        String output = favourites.toString();
        System.out.println(output);
    }
}
