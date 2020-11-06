package com.easyfix.Application.ui.Terminal;
import com.easyfix.Application.models.WorkerModel;
import com.easyfix.Application.models.ChatMessageModel;
import com.easyfix.Application.models.UserModel;
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
                userid = -2;
            }

            if(userid!=-2) {
                System.out.println("1-Get Favourites");
                System.out.println("2-Add to favourite");
                System.out.println("3-Change Area");
                System.out.println("4-Change city");
                System.out.println("5-Change Payment method");
                choice2 = sc.nextInt();

                if (choice2 == 1) {
                    ArrayList<WorkerModel> favourites = customerService.getFavourites(userid);
                    System.out.println(favourites.toString());
                }
                else if (choice2 == 2){
                    System.out.println("Enter worker id :");
                    int wid = sc.nextInt();
                    boolean fav = false;
                    try {
                        fav = customerService.addToFavourite(userid, wid);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    if(fav == true)
                        System.out.println("Worker added to favourites");
                    else
                        System.out.println("Error!!!!");
                }
                else if(choice2  == 3){
                    System.out.println("Enter area :");
                    String area = sc.nextLine();
                    boolean changearea=customerService.changeArea(userid,area);
                    if(changearea == true)
                        System.out.println("Area changed successfully");
                    else
                        System.out.println("Error!!!!");
                }
                else if(choice2 == 4){
                    System.out.println("Enter city :");
                    String city = sc.nextLine();
                    boolean changecity=customerService.changeCity(userid,city);
                    if(changecity == true)
                        System.out.println("City changed successfully");
                    else
                        System.out.println("Error!!!!");
                }
                else if(choice2 == 5){
                    System.out.println("Enter payment method :");
                    String paymethod = sc.nextLine();
                    boolean method=customerService.changePaymentMethod(userid,paymethod);
                    if(method == true)
                        System.out.println("Payment method updated successfully");
                    else
                        System.out.println("Error!!!!");
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

        try {
            WorkerModel w = workerService.getWorker(1);
            System.out.println(w.name);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


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
