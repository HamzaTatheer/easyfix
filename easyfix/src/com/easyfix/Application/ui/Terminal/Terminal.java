package com.easyfix.Application.ui.Terminal;
import com.easyfix.Application.models.*;
import com.easyfix.Application.ui.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Terminal extends UI {

    public int cid;//customer login
    public int wid;//worker login

    public Terminal() {
        super();
    }

    public void showWorkers(){
        ArrayList<WorkerModel> workers = new ArrayList<WorkerModel>();
        workers = workerService.getAllWorkers();
        workers.forEach(w->System.out.println("id:"+w.id+ "  Worker Name: "+w.name+" Speciality:"+ w.speciality+" Rating: "+ w.avgRating+ "  hourly Rate:" + w.hourlyRate));
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
            System.out.println("Wallet         : "+c.wallet);
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
            wid = -1;
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
        System.out.println("Enter credit no to use with account");
        String creditno = sc.nextLine();
        System.out.println("Enter City :");
        String city = sc.nextLine();
        System.out.println("Enter Area :");
        String area = sc.nextLine();
        try {
            int id = customerService.register(name, remail, rpassword,creditno, city, area);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void chatScreenWorker(int cid){
        CustomerModel customerDetails;
        try {
            customerDetails = customerService.getCustomerDetails(cid);
        }
        catch (Exception e){
            return;
        }

        Scanner sc = new Scanner(System.in);

        String customerName = customerDetails.name;
        System.out.println("Chatting with "+ customerName);
        System.out.println("=============================================");
        String action = "nothing";
        while(action != "exit") {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            try {
                ArrayList<ChatMessageModel> c = chatService.loadMessageHistory(cid, wid);
                for(int i=0;i<c.size();i++){
                    System.out.println(c.get(i).senderName +": " + c.get(i).message);
                }

                System.out.println("Enter Message (type exit to exit chat and refresh to refresh chat): ");
                String message = sc.nextLine();
                if(message.equals("exit")){
                    return;
                }
                else if(!message.equals("refresh")){
                    chatService.sendMessage(cid,wid,"worker",message);
                }

            }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("New Chat");
                break;
            }
        }
    }
    public void chatScreenCustomer(int wid){

        WorkerModel workerDetails;
        try {
            workerDetails = workerService.getWorker(wid);
        }
        catch (Exception e){
            return;
        }

        Scanner sc = new Scanner(System.in);

        String workerName = workerDetails.name;
        System.out.println("Chatting with "+ workerName);
        System.out.println("=============================================");
        String action = "nothing";
        while(action != "exit") {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            try {
                ArrayList<ChatMessageModel> c = chatService.loadMessageHistory(cid, wid);
                for(int i=0;i<c.size();i++){
                    System.out.println(c.get(i).senderName +": " + c.get(i).message);
                }

                System.out.println("Enter Message (type exit to exit chat and refresh to refresh chat): ");
                String message = sc.nextLine();
                if(message.equals("exit")){
                    return;
                }
                else if(!message.equals("refresh")){
                    chatService.sendMessage(cid,wid,"customer",message);
                }

            }
            catch (Exception e){
                System.out.println("New Chat");
            }
        }
    }


    public void billScreen(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Booking id to show its bill");
        int bill_id = sc.nextInt();

        try {
            BillingModel b = billingService.showBill(bill_id);
            System.out.println("id: "+ b.bookingId +" title: "+ b.title + " Cost: "+ b.totalCost + " status: "+b.status);
            if(!b.status.equals("paid")) {
                if(bookingService.payForBooking(cid,b.bookingId)==true)
                    System.out.println("Payment Successful!");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void complainScreen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id worker you want to complain");
        int id = sc.nextInt();
        System.out.println("What do you want to complain about");
        String complain = sc.nextLine();

        try {
            complainService.giveComplain(cid,id,complain);
            System.out.println("Complain Made!");
        }
        catch (Exception e){
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
            System.out.println("8-Show Pending Bookings");
            System.out.println("9-Show Active Bookings");
            System.out.println("10-Show Finished Bookings");
            System.out.println("11-Logout\n");


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
                Scanner sss = new Scanner(System.in);
                String area = sss.nextLine();
                boolean changearea = customerService.changeArea(cid, area);
                if (changearea == true)
                    System.out.println("Area changed successfully");
                else
                    System.out.println("Error!!!!");
            } else if (choice2 == 4) {

                System.out.println("Enter city :");
                Scanner sss = new Scanner(System.in);
                String city = sss.nextLine();
                boolean changecity = customerService.changeCity(cid, city);
                if (changecity == true)
                    System.out.println("City changed successfully");
                else
                    System.out.println("Error!!!!");
            } else if (choice2 == 5) {
                System.out.println("Enter payment method (credit or wallet) :");
                Scanner input = new Scanner(System.in);
                String paymethod = input.nextLine();
                boolean method = customerService.changePaymentMethod(cid, paymethod);
                if (method == true)
                    System.out.println("Payment method updated successfully");
                else
                    System.out.println("Error!!!!");
            } else if (choice2 == 6) {
                showWorkers();
                System.out.println("Enter worker id : ");
                int workerid = sc.nextInt();
                System.out.println("How much do you want to rate him ? ");
                int rating = sc.nextInt();
                try {
                    customerService.giveRating(cid, workerid,rating);
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
                System.out.println("Select a worker to Book (enter number. enter -1 to go back): ");
                int selected_worker = sc.nextInt();
                if(selected_worker != -1) {
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
                        bookingService.makeBooking(b.cid, b.wid, b.text, b.startTime, new ArrayList<SparePartModel>());
                        ArrayList<SparePartModel> sp = sparePartService.showAllSpareParts();
                        for (int i = 0; i < sp.size(); i++) {
                            System.out.println("id: " + sp.get(i).id + "  name: " + sp.get(i).name + "  " + (sp.get(i).quantity > 0 ? "Available" : "Not Available"));
                        }
                        System.out.println("Do you want to add spareparts");
                        sc.nextLine();
                        String done = sc.nextLine();
                        ArrayList<SparePartModel> myspareparts = new ArrayList<>();
                        while (done.equals("yes")) {
                            SparePartModel temp = new SparePartModel();
                            System.out.println("Enter Part ID: ");
                            temp.id = sc.nextInt();
                            System.out.println("Enter Quantity to Add:");
                            temp.quantity = sc.nextInt();
                            myspareparts.add(temp);
                            System.out.println("Do you want to add any more items");
                            done = sc.nextLine();
                        }

                        for (int i = 0; i < myspareparts.size(); i++) {
                            sparePartService.addSparePartsToBooking(b.id, myspareparts.get(i).id, myspareparts.get(i).quantity);
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
            else if(choice2 == 8){
                ArrayList<BookingModel> b =  bookingService.showPendingBookingsOfCustomer(cid);
                for (BookingModel bookingModel : b) {
                    System.out.println("id: "+ bookingModel.id + " Title: " + bookingModel.text+"    "+bookingModel.status + " Start Time: "+bookingModel.startTime);
                    try {
                        WorkerModel workerDetails = workerService.getWorker(bookingModel.wid);
                        System.out.println("By Worker: "+ workerDetails.name + " id: "+workerDetails.id);
                    }
                    catch (Exception e){
                        System.out.println("By Worker: ...");
                    }
                }

                System.out.println("Enter a Booking to cancel (-1 to go back)");
                int mychoice = sc.nextInt();
                if(mychoice != -1){
                    System.out.println("Cancelling Booking...");
                    bookingService.rejectBooking(mychoice);
                }

            }
            else if(choice2 == 9){
                ArrayList<BookingModel> b = bookingService.showActiveBookingOfCustomer(cid);
                for (BookingModel bookingModel : b) {
                    System.out.println("id: "+ bookingModel.id + " Title: " + bookingModel.text+"    "+bookingModel.status + " Start Time: "+bookingModel.startTime);
                    try {
                        WorkerModel workerDetails = workerService.getWorker(bookingModel.wid);
                        System.out.println("By Worker: "+ workerDetails.name + " id: "+workerDetails.id);
                    }
                    catch (Exception e){
                        System.out.println("By Worker: ...");
                    }
                }

                System.out.println("Want to Chat with a worker ? yes or no");
                sc.nextLine();
                String answer = sc.nextLine();
                if(answer.equals("yes")){
                    Scanner scc =new Scanner(System.in);
                    int chatWith = scc.nextInt();
                    chatScreenCustomer(chatWith);
                }

            }
            else if(choice2 == 10){
                ArrayList<BookingModel> b = bookingService.showFinishedBookingOfCustomer(cid);
                for (BookingModel bookingModel : b) {
                    System.out.println("id: "+ bookingModel.id + " Title: " + bookingModel.text+"    "+bookingModel.status + " Start Time: "+bookingModel.startTime);
                    try {
                        WorkerModel workerDetails = workerService.getWorker(bookingModel.wid);
                        System.out.println("By Worker: "+ workerDetails.name + " id: "+workerDetails.id);
                    }
                    catch (Exception e){
                        System.out.println("By Worker: ...");
                    }
                }

                System.out.println("Type bill to show bill, complain to complain worker and backto go back");
                Scanner myscanner = new Scanner(System.in);
                String answer = myscanner.nextLine();
                if(answer.equals("bill")){
                    billScreen();
                }
                if(answer.equals("complain")){
                    complainScreen();
                }


            }
            else if (choice2 == 11) {
                break;
            }
        }

    }
    public void workerMenu(int wid){
        while(true) {
            System.out.println("1-Show Pending Bookings");
            System.out.println("2-Show Active Bookings");
            System.out.println("3-Logout");
            int wchoice;
            Scanner sc = new Scanner(System.in);
            wchoice = sc.nextInt();
            if (wchoice == 1) {
                try {
                    ArrayList<BookingModel> b = bookingService.showPendingBookingsOfWorker(wid);
                    for (BookingModel bookingModel : b) {
                        System.out.println("id: "+ bookingModel.id + " Title: " + bookingModel.text+"    "+bookingModel.status + " Start Time: "+bookingModel.startTime);
                        try {
                            CustomerModel customerDetails = customerService.getCustomerDetails(bookingModel.cid);
                            System.out.println("Of Customer: "+ customerDetails.name + " id: "+customerDetails.id);
                        }
                        catch (Exception e){
                            System.out.println("Of Customer: ...");
                        }
                    }

                    System.out.println("Enter Booking id to accept. -1 to go back");
                    int accepted = sc.nextInt();
                    if(accepted != -1)
                        bookingService.acceptBooking(accepted);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (wchoice == 2) {
                try {
                    ArrayList<BookingModel> b = bookingService.showActiveOfWorker(wid);
                    for (BookingModel bookingModel : b) {
                        System.out.println("id: "+ bookingModel.id + " Title: " + bookingModel.text+"    "+bookingModel.status + " Start Time: "+bookingModel.startTime);
                        try {
                            CustomerModel customerDetails = customerService.getCustomerDetails(bookingModel.cid);
                            System.out.println("Of Customer: "+ customerDetails.name + " id: "+customerDetails.id);
                        }
                        catch (Exception e){
                            System.out.println("Of Customer: ...");
                        }
                    }



                    System.out.println("Enter Customer to chat with. -1 to go finish booking. -2 to go back");
                    int chatWith = sc.nextInt();
                    if(chatWith >= 0)
                        chatScreenWorker(chatWith);

                    if(chatWith == -1){

                        int bookingFinish = sc.nextInt();
                        bookingService.finishBooking(bookingFinish);
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(wchoice == 3){
                return;
            }
        }
    }
}