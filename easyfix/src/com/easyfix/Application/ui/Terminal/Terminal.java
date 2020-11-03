package com.easyfix.Application.ui.Terminal;

import com.easyfix.Application.bl.services.CustomerService;
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
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Choice : ");
        choice=sc.nextInt();
        if(choice==1) {
            int choice2;
            ArrayList<Integer> arr=new ArrayList<Integer>() ;
            int userid;
            try {

                userid = customerService.login("hamza@gmail.com", "12356");
                System.out.println("Login Successful");


            } catch (Exception e) {
                System.out.println("Error!!!!Login Failed");
                userid=-2;
            }
            //getfavourite method

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

            try {
                int id = customerService.register("Talha", "talha@gmail.com", "123123", "lahore", "DHA");
                System.out.println(id);
            }
            catch(Exception e){
                System.out.println("Error!!! Registration Failed");
            }
        }

    }
}
