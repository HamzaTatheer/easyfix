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

    public Terminal() {
        super();
    }

    public void start() {
        int choice;
        while (true) {
            System.out.println("1-Login as Customer");
            System.out.println("2-Login as Worker");
            System.out.println("3-Register Customer\n");
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter Choice : ");
            choice = sc1.nextInt();
            Scanner sc = new Scanner(System.in);
            if (choice == 1) {
                int choice2 = -1;
                ArrayList<Integer> arr = new ArrayList<Integer>();
                int cid;
                System.out.println("Enter Email :");
                String email = sc.nextLine();
                System.out.println("Enter Password :");
                String password = sc.nextLine();
                try {

                    cid = customerService.login(email, password);
                    System.out.println("Login Successful");
                    CustomerModel c=customerService.getCustomerDetails(cid);
                    System.out.println("ID             : "+c.id);
                    System.out.println("Name           : "+c.name);
                    System.out.println("City           : "+c.city);
                    System.out.println("Area           : "+c.area);
                    System.out.println("Payment method : "+c.paymentMethod);



                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    cid = -2;
                }


                if (cid != -2) {
                    while (true) {
                        System.out.println("------------------------------------------------");
                        System.out.println("1-Get Favourites");
                        System.out.println("2-Add to favourite");
                        System.out.println("3-Change Area");
                        System.out.println("4-Change city");
                        System.out.println("5-Change Payment method");
                        System.out.println("6-Give Rating");
                        System.out.println("7-Show Workers In your area to Book");
                        System.out.println("8-Show Pending Bookings");
                        System.out.println("9-Show Active Bookings");
                        System.out.println("10-Show Finished Bookings");
                        System.out.println("11-Logout\n");


                        System.out.println("Enter Choice : ");
                        choice2 = sc.nextInt();

                        if (choice2 == 1) {
                            ArrayList<WorkerModel> favourites = customerService.getFavourites(cid);
                            System.out.println("Your Favourites: ");
                            for (int i = 0; i < favourites.size(); i++) {
                                System.out.println("id: " + favourites.get(i).id + " " + favourites.get(i).name + " speciality: " + favourites.get(i).speciality);
                            }
                        } else if (choice2 == 2) {

                            ArrayList<WorkerModel> w = workerService.getAllWorkers();
                            for(int i=0;i<w.size();i++){
                                System.out.println(w.get(i).id + ". "+w.get(i).name+" "+w.get(i).avgRating+" "+w.get(i).speciality);
                            }

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
                        }
                        else if(choice2 == 8){
                            System.out.println("Your Pending Bookings: ");
                            ArrayList<BookingModel> pendingBookings = bookingService.showPendingBookingsOfCustomer(cid);
                            for(int i=0;i<pendingBookings.size();i++){
                                try {
                                    WorkerModel myworker = workerService.getWorker(pendingBookings.get(i).wid);
                                    String name = myworker.name;
                                    System.out.println("Title:"+ pendingBookings.get(i).text + "     Start Time:" + pendingBookings.get(i).startTime + "  Booking with - "+ name);
                                }
                                catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                } else if (choice2 == 10) {
                    break;
                }
            }
            else if (choice == 2) {

                System.out.println("Enter Email :");
                String wemail = sc.nextLine();
                System.out.println("Enter Password :");
                String wpassword = sc.nextLine();

                int wid = 0;
                try {
                    wid = workerService.login(wemail, wpassword);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                if (wid != -1) {

                    System.out.println("1-Get Worker");
                    System.out.println("2-Change Area");
                    System.out.println("3-Change City");
                    System.out.println("4-Change Hourly rate");
                    int wchoice;
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
                    }

                }

            } else if (choice == 3) {
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
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}