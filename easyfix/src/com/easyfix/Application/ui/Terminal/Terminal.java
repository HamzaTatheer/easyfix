package com.easyfix.Application.ui.Terminal;

<<<<<<< HEAD
import com.easyfix.Application.models.ChatMessageModel;
import com.easyfix.Application.models.UserModel;
=======
import com.easyfix.Application.bl.services.CustomerService;
>>>>>>> 7ce0c2e1de265838461de897b21cd1052b705e61
import com.easyfix.Application.ui.UI;
import java.util.ArrayList;
import java.util.*;

import java.util.ArrayList;

public class Terminal extends UI {

    public Terminal(){
        super();
    }

    public void start(){
        int choice;
        System.out.println("1-Login\n");
        System.out.println("2-Register\n");
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Choice : ");
        choice=sc1.nextInt();
        Scanner sc=new Scanner(System.in);
        if(choice==1) {
            int choice2;
            ArrayList<Integer> arr=new ArrayList<Integer>() ;
            int userid;
            System.out.println("Enter Email :");
            String email = sc.nextLine();
            System.out.println("Enter Password :");
            String password = sc.nextLine();
            try {

                userid = customerService.login(email, password);
                System.out.println("Login Successful");


            } catch (Exception e) {
                System.out.println(e.getMessage());
                userid=-2;
            }
            ///getfavourite method

            if(userid!=-2) {
                System.out.println("1-Get Favourites");
                choice2 = sc.nextInt();

                if (choice2 == 1) {
                    arr = customerService.getFavourites(userid);
                        System.out.println(arr);
                }
            }
        }
        else if(choice==2) {
            System.out.println("Enter Name :");
                String name = sc.nextLine();
            System.out.println("Enter Email :");
                String email = sc.nextLine();
            System.out.println("Enter Password :");
                String password = sc.nextLine();
            System.out.println("Enter City :");
                String city = sc.nextLine();
            System.out.println("Enter Area :");
                String area = sc.nextLine();
            try {
                int id = customerService.register(name, email, password, city, area);
                System.out.println(id);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
<<<<<<< HEAD
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


=======
>>>>>>> 7ce0c2e1de265838461de897b21cd1052b705e61

    }
}
