package com.easyfix.Application.ui.Terminal;
import com.easyfix.Application.bl.services.BookingService;
import com.easyfix.Application.bl.services.WorkerService;
import com.easyfix.Application.models.*;
import com.easyfix.Application.bl.services.CustomerService;
import com.easyfix.Application.ui.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.*;

import java.util.ArrayList;

public class Terminal extends UI {

    public int cid;//customer login
    public int wid;//worker login

    public Terminal() {
        super();
    }


    public int getChoice(int start,int end) throws Exception{
        Scanner sc = new Scanner(System.in);
        int choice =-1;
        try {
            choice = sc.nextInt();
        }
        catch (Exception e){
            throw new Exception("Invalid Choice");
        }

        if(choice < start || choice > end)
        throw new Exception("Please Enter from the choices given in Menu");

        return choice;
    }

    public void start() {
        while (true) {
            System.out.println("1-Login as Customer");
            System.out.println("2-Login as Worker");
            System.out.println("3-Register Customer\n");
            int choice = 0;
            try {
                choice = getChoice(1, 3);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

            if (choice == 1) {
                loginCustomer();
            }
            else if (choice == 2) {
                loginWorker();
            } else if (choice == 3) {
                registerCustomer();
            }
        }
    }


    public void loginCustomer(){
                int choice2 = -1;
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Choice : ");
                System.out.println("Enter Email :");
                String email = sc.nextLine();
                System.out.println("Enter Password :");
                String password = sc.nextLine();
                try {

                    cid = customerService.login(email, password);
                    System.out.println("Login Successful");
                    CustomerModel c = customerService.getCustomerDetails(cid);
                    System.out.println("ID             : " + c.id);
                    System.out.println("Name           : " + c.name);
                    System.out.println("City           : " + c.city);
                    System.out.println("Area           : " + c.area);
                    System.out.println("Payment method : " + c.paymentMethod);


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    cid = -2;
                }


                if (cid != -2)
                    customerMenu();
    }



    public void loginWorker(){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Email :");
                    String wemail = sc.nextLine();
                    System.out.println("Enter Password :");
                    String wpassword = sc.nextLine();

                    try {
                        wid = workerService.login(wemail, wpassword);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (wid != -1) {
                        workerMenu(wid);

                    }
    }


    public void registerCustomer(){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Name :");
                    String name = sc.nextLine();
                    System.out.println("Enter Email :");
                    String remail = sc.nextLine();
                    System.out.println("Enter Password :");
                    String rpassword = sc.nextLine();
                    System.out.println("Enter City :");
                    String city = sc.nextLine();
                    System.out.println("Enter Area :");
                    String area = sc.nextLine();
                    try {
                        int id = customerService.register(name, remail, rpassword, city, area);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
    }

    public void customerMenu(){
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("1-Get Favourites");
            System.out.println("2-Add to favourite");
            System.out.println("3-Change Area");
            System.out.println("4-Change city");
            System.out.println("5-Change Payment method");
            System.out.println("6-Give Rating");
            System.out.println("7-Show Workers By Area");
            System.out.println("8-Show Active Bookings");
            System.out.println("9-Show Finished Bookings");
            System.out.println("10-Logout\n");


            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Choice : ");
            int choice2 = sc.nextInt();

            if (choice2 == 1) {
                ArrayList<WorkerModel> favourites = customerService.getFavourites(cid);
                System.out.println("Your Favourites: ");
                for (int i = 0; i < favourites.size(); i++) {
                    System.out.println("id: " + favourites.get(i).id + " " + favourites.get(i).name + " speciality: " + favourites.get(i).speciality);
                }
            } else if (choice2 == 2) {

                ArrayList<WorkerModel> workers = new ArrayList<WorkerModel>();
                workers = workerService.getAllWorkers();

                workers.forEach(w->System.out.println("id:"+w.id+ "  Worker Name: "+w.name+" Speciality:"+ w.speciality+" Rating: "+ w.avgRating+ "  hourly Rate:" + w.hourlyRate));

                System.out.println();

                System.out.println("Enter worker id :");
                int wid = sc.nextInt();
                boolean fav = false;
                try {
                    fav = customerService.addToFavourite(cid, wid);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                if (fav == true)
                    System.out.println("Worker added to favourites");
                else
                    System.out.println("Error!!!!");
            } else if (choice2 == 3) {
                System.out.println("Enter area :");
                String area = sc.nextLine();
                boolean changearea = customerService.changeArea(cid, area);
                if (changearea == true)
                    System.out.println("Area changed successfully");
                else
                    System.out.println("Error!!!!");
            } else if (choice2 == 4) {
                System.out.println("Enter city :");
                String city = sc.nextLine();
                boolean changecity = customerService.changeCity(cid, city);
                if (changecity == true)
                    System.out.println("City changed successfully");
                else
                    System.out.println("Error!!!!");
            } else if (choice2 == 5) {
                System.out.println("Enter payment method :");
                String paymethod = sc.nextLine();
                boolean method = customerService.changePaymentMethod(cid, paymethod);
                if (method == true)
                    System.out.println("Payment method updated successfully");
                else
                    System.out.println("Error!!!!");
            } else if (choice2 == 6) {
                System.out.println("Enter worker id : ");
                int workerid = sc.nextInt();
                try {
                    customerService.giveRating(cid, workerid);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice2 == 7) {
                System.out.println("Showing Workers at your current location");
                ArrayList<WorkerModel> workersCloseBy = customerService.getWorkersCloseBy(cid);
                for (WorkerModel workerModel : workersCloseBy) {
                    System.out.print(workerModel.id + ".");
                    System.out.print(workerModel.name);
                    System.out.print("-");
                    System.out.println(" " + workerModel.speciality);
                }
                System.out.println("Select a worker to Book (enter number): ");
                int selected_worker = sc.nextInt();
                BookingModel b = new BookingModel();
                System.out.println("Select day");
                int bDay = sc.nextInt();
                System.out.println("Select month");
                int bMonth = sc.nextInt();
                //leaving year
                System.out.println("Select Hour (24 hour clock) ");
                int bHour = sc.nextInt();
                System.out.println("Select Minute");
                int bMinute = sc.nextInt();
                b.startTime = LocalDateTime.of(LocalDate.of(2020, bMonth, bDay), LocalTime.of(bHour, bMinute));
                System.out.println("Select Title");
                Scanner scc = new Scanner(System.in);//sc was skipping text
                b.text = scc.nextLine();
                b.cid = cid;
                b.wid = selected_worker;
                b.spareParts = new ArrayList<Integer>();
                try {
                    bookingService.makeBooking(b.cid, b.wid, b.text, b.startTime, b.spareParts);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (choice2 == 10) {
                 break;
            }
       }

    }
    public void workerMenu(int wid){
        while(true) {
            System.out.println("1-Get Worker");
            System.out.println("2-Change Area");
            System.out.println("3-Change City");
            System.out.println("4-Change Hourly rate");
            System.out.println("5-Logout");
            int wchoice;
            Scanner sc = new Scanner(System.in);
            wchoice = sc.nextInt();
            if (wchoice == 1) {
                try {
                    WorkerModel w = workerService.getWorker(wid);
                    System.out.println(w);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (wchoice == 2) {
                System.out.println("Enter area :");
                String area = sc.nextLine();
                boolean b = workerService.changeArea(wid, area);
                if (b == true)
                    System.out.println("Area updated successfully");
            } else if (wchoice == 3) {
                System.out.println("Enter city :");
                String city = sc.nextLine();
                boolean b = workerService.changeArea(wid, city);
                if (b == true)
                    System.out.println("City updated successfully");
            } else if (wchoice == 4) {
                System.out.println("Enter hourly rate :");
                float rate = sc.nextFloat();
                boolean b = workerService.changeHourlyRate(wid, rate);
                if (b == true)
                    System.out.println("Hourly rate updated successfully");
            } else if (wchoice == 5) {
                break;
            }

        }
    }
}