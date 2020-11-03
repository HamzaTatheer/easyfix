package com.easyfix.Application.ui.Terminal;

import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.ui.UI;
import java.util.*;

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
            int choice2,arr[];
            String email = "hamza@gmail.com";
            String password = "12356";
            int userid;
            try {

                userid = customerService.login(email, password);
                System.out.println("Login Successful");


            } catch (Exception e) {
                System.out.println("Error!!!!Login Failed");
                userid=-2;
            }
            //getfavourite method

            System.out.println("heeelllee");
            if(userid!=-2) {
                System.out.println("1-Get Favourites");
                choice2 = sc.nextInt();

                if (choice2 == 1) {
                    arr = customerService.getFavourites(userid);
                    for (int element : arr)
                        System.out.println(element);
                }
            }

        }
        else if(choice==2) {

            Scanner sc2 = new Scanner(System.in);
            String name,email,pass,city,area;
            System.out.println("Name :");
            name=sc.next();

            System.out.println("Email :");
            email=sc.next();

            System.out.println("Password :");
            pass=sc.next();

            System.out.println("City :");
            city=sc.next();

            System.out.println("Area :");
            area=sc.next();

            try {
                int id = customerService.register(name, email, pass, city, area);
                System.out.println("Register id ");
                System.out.println(id);
            }
            catch(Exception e){
                System.out.println("Error!!! Registration Failed");
            }
        }

    }
}
