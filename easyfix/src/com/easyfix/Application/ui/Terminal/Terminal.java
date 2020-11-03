package com.easyfix.Application.ui.Terminal;

import com.easyfix.Application.models.ChatMessageModel;
import com.easyfix.Application.models.UserModel;
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
        /*
        showing favourites
        ArrayList<Integer> favourites = customerService.getFavourites(1);
        String output = favourites.toString();
        System.out.println(output);
        */

/*

        load message between two users through their ids
        ArrayList<ChatMessageModel> messages =  chatService.loadMessageHistory(1,2);
        for(ChatMessageModel part: messages) {
            System.out.println(part.senderName + ": " + part.message);
        }
*/


/*
get user name
        try {
            UserModel u = userService.getUser(2);
            System.out.println(u.name);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
*/


        /*
        get user speciality
        try {
            String u = userService.getUserSpeciality(1);
            System.out.println(u);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }*/



    }
}
