package com.easyfix.Application.db.textDb;

import com.easyfix.Application.bl.classes.Worker;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TextDbManager implements DbService {

    private static String currentPath = "./src/com/easyfix/Application/db/textDb/";

    public boolean updateFinishTime(int booking_id,LocalDateTime finishTime){
        return false;
    }


    public boolean does_customer_exist(int id) {

        File myobj=new File(currentPath+"Customer.txt");



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int id_n = myReader.nextInt();
                myReader.nextLine();
                String name = myReader.nextLine();
                String email = myReader.nextLine();
                String password = myReader.nextLine();
                String payment=myReader.nextLine();
                String credit_no=myReader.nextLine();
                float wallet = myReader.nextFloat();
                myReader.nextLine();
                String city = myReader.nextLine();
                String area = myReader.nextLine();
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> favourite = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }

                if (id == id_n) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");
        return false;

    }


    public int does_customer_exist(String email, String password) {

        File myobj=new File(currentPath+"Customer.txt");
        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int id_n = myReader.nextInt();
                myReader.nextLine();
                String name = myReader.nextLine();
                String email_n = myReader.nextLine();
                String password_n = myReader.nextLine();
                String payment=myReader.nextLine();
                String credit_no=myReader.nextLine();
                float wallet = myReader.nextFloat();
                myReader.nextLine();
                String city = myReader.nextLine();
                String area = myReader.nextLine();
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> favourite = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }

                if (email_n.equals(email)&&password_n.equals(password)) {
                    return id_n;
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }

        return -1;

    }


    public boolean store_customer(String name, String email, String password,String credit_no, float wallet, String city,String area, ArrayList<Integer> favourite) {
        int id=0;
        File myo=new File(currentPath+"CountCustomer.txt");
        try {
            Scanner myr = new Scanner(myo);
            id=myr.nextInt();
        } catch (FileNotFoundException e) {
            id=0;
        }

        id++;
        try {
            FileWriter myw=new FileWriter("CountCustomer.txt",false);
            myw.write(id+"\n");
            myw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileWriter mywriter=new FileWriter(currentPath+"Customer.txt",true);
            mywriter.write(id+"\n");
            mywriter.write(name+"\n");
            mywriter.write(email+"\n");
            mywriter.write(password+"\n");
            //default payment of customer
            String payment="cash";
            mywriter.write(payment+"\n");
            mywriter.write(credit_no+"\n");
            mywriter.write(wallet+"\n");
            mywriter.write(city+"\n");
            mywriter.write(area+"\n");
            mywriter.write(favourite.size()+"\n");
            for (int i=0;i<favourite.size();i++)
            {
                mywriter.write(favourite.get(i)+"\n");
            }
            mywriter.close();

            //System.out.print("Filling done\n");
            return true;
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }

    }


    public boolean update_customer_city(int id, String city) {

        File myobj=new File("Customer.txt");
        ArrayList<CustomerModel> store=new ArrayList<CustomerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                CustomerModel temp=new CustomerModel();
                temp.Favourite=new ArrayList<Integer>();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.paymentMethod=myReader.nextLine();
                temp.creditno=myReader.nextLine();
                temp.wallet = myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                int size = myReader.nextInt();
                myReader.nextLine();

                for (int i = 0; i < size; i++) {
                    temp.Favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }


                if (id == temp.id) {
                    temp.city=city;
                    check=true;
                }
                store.add(temp);
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }




        try {
            FileWriter mywriter=new FileWriter("Customer.txt",false);

            for (int i=0;i<store.size();i++) {
                mywriter.write(store.get(i).id + "\n");
                mywriter.write(store.get(i).name + "\n");
                mywriter.write(store.get(i).email + "\n");
                mywriter.write(store.get(i).password + "\n");
                mywriter.write(store.get(i).paymentMethod + "\n");
                mywriter.write(store.get(i).creditno + "\n");
                mywriter.write(store.get(i).wallet + "\n");
                mywriter.write(store.get(i).city + "\n");
                mywriter.write(store.get(i).area + "\n");
                mywriter.write(store.get(i).Favourite.size() + "\n");
                for (int j = 0; j < store.get(i).Favourite.size(); j++) {
                    mywriter.write(store.get(i).Favourite + "\n");
                }



            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }

    }


    public boolean update_customer_area(int id, String area) {
        File myobj=new File("Customer.txt");
        ArrayList<CustomerModel> store=new ArrayList<CustomerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                CustomerModel temp=new CustomerModel();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.paymentMethod=myReader.nextLine();
                temp.creditno=myReader.nextLine();
                temp.wallet = myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> favourite = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    temp.Favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }

                if (id == temp.id) {
                    temp.area=area;
                    check=true;
                }
                store.add(temp);


            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }




        try {
            FileWriter mywriter=new FileWriter("Customer.txt",false);

            for (int i=0;i<store.size();i++) {
                mywriter.write(store.get(i).id + "\n");
                mywriter.write(store.get(i).name + "\n");
                mywriter.write(store.get(i).email + "\n");
                mywriter.write(store.get(i).password + "\n");
                mywriter.write(store.get(i).paymentMethod + "\n");
                mywriter.write(store.get(i).creditno + "\n");
                mywriter.write(store.get(i).wallet + "\n");
                mywriter.write(store.get(i).city + "\n");
                mywriter.write(store.get(i).area + "\n");
                mywriter.write(store.get(i).Favourite.size() + "\n");
                for (int j = 0; j < store.get(i).Favourite.size(); j++) {
                    mywriter.write(store.get(i).Favourite + "\n");
                }



            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }
    }


    public boolean update_customerPayment(int id, String payment) {
        File myobj=new File("Customer.txt");
        ArrayList<CustomerModel> store=new ArrayList<CustomerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                CustomerModel temp=new CustomerModel();
                temp.Favourite=new ArrayList<Integer>();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.paymentMethod=myReader.nextLine();
                temp.creditno=myReader.nextLine();
                temp.wallet = myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> favourite = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    temp.Favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }
                if (id == temp.id) {
                    temp.paymentMethod=payment;
                    check=true;
                }
                store.add(temp);


            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }




        try {
            FileWriter mywriter=new FileWriter("Customer.txt",false);

            for (int i=0;i<store.size();i++) {
                mywriter.write(store.get(i).id + "\n");
                mywriter.write(store.get(i).name + "\n");
                mywriter.write(store.get(i).email + "\n");
                mywriter.write(store.get(i).password + "\n");
                mywriter.write(store.get(i).paymentMethod + "\n");
                mywriter.write(store.get(i).creditno + "\n");
                mywriter.write(store.get(i).wallet + "\n");
                mywriter.write(store.get(i).city + "\n");
                mywriter.write(store.get(i).area + "\n");
                mywriter.write(store.get(i).Favourite.size() + "\n");
                for (int j = 0; j < store.get(i).Favourite.size(); j++) {
                    mywriter.write(store.get(i).Favourite.get(j) + "\n");
                }



            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }
    }


    public boolean update_customerWallet(int id, Float money) {
        File myobj=new File("Customer.txt");
        ArrayList<CustomerModel> store=new ArrayList<CustomerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                CustomerModel temp=new CustomerModel();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.paymentMethod=myReader.nextLine();
                temp.creditno=myReader.nextLine();
                temp.wallet = myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> favourite = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    temp.Favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }

                if (id == temp.id) {
                    temp.wallet=money;
                    check=true;
                }
                store.add(temp);


            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }




        try {
            FileWriter mywriter=new FileWriter("Customer.txt",false);

            for (int i=0;i<store.size();i++) {
                mywriter.write(store.get(i).id + "\n");
                mywriter.write(store.get(i).name + "\n");
                mywriter.write(store.get(i).email + "\n");
                mywriter.write(store.get(i).password + "\n");
                mywriter.write(store.get(i).paymentMethod + "\n");
                mywriter.write(store.get(i).creditno + "\n");
                mywriter.write(store.get(i).wallet + "\n");
                mywriter.write(store.get(i).city + "\n");
                mywriter.write(store.get(i).area + "\n");
                mywriter.write(store.get(i).Favourite.size() + "\n");
                for (int j = 0; j < store.get(i).Favourite.size(); j++) {
                    mywriter.write(store.get(i).Favourite.get(j) + "\n");
                }



            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }
    }


    public CustomerModel get_customer(int id) {
        File myobj=new File(currentPath+"Customer.txt");



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int id_n = myReader.nextInt();
                myReader.nextLine();
                String name = myReader.nextLine();
                String email = myReader.nextLine();
                String password = myReader.nextLine();
                String payment=myReader.nextLine();
                String credit_no=myReader.nextLine();
                float wallet = myReader.nextFloat();
                myReader.nextLine();
                String city = myReader.nextLine();
                String area = myReader.nextLine();
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> favourite = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }

                if (id == id_n) {
                    CustomerModel ret=new CustomerModel();
                    ret.Favourite=new ArrayList<Integer>();
                    ret.id=id_n;
                    ret.name=name;
                    ret.email=email;
                    ret.password=password;
                    ret.paymentMethod=payment;
                    ret.creditno=credit_no;
                    ret.wallet=wallet;
                    ret.city=city;
                    ret.area=area;
                    for (int i=0;i<favourite.size();i++) {
                        int temp=favourite.get(i);
                        //if (temp!=null)
                        ret.Favourite.add(temp);
                    }
                        /*
                        System.out.print(id_n+"\n");
                        System.out.print(name+"\n");
                        System.out.print(email+"\n");
                        System.out.print(password+"\n");
                        System.out.print(payment+"\n");
                        System.out.print(wallet+"\n");
                        System.out.print(city+"\n");
                        System.out.print(area+"\n");
                        System.out.print(size+"\n");
                        System.out.print(favourite+"\n");
                        */

                    return ret;
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return null;
    }


    public boolean store_worker( String name, String email, String password, float average_rating, float hourly_rate, String city, String area, String speciality) {
        int id=0;
        File myo=new File("CountWorker.txt");
        try {
            Scanner myr = new Scanner(myo);
            id=myr.nextInt();
        } catch (FileNotFoundException e) {
            id=0;
        }

        id++;
        try {
            FileWriter myw=new FileWriter("CountWorker.txt",false);
            myw.write(id+"\n");
            myw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }




        try {
            FileWriter mywriter=new FileWriter("Worker.txt",true);
            mywriter.write(id+"\n");
            mywriter.write(name+"\n");
            mywriter.write(email+"\n");
            mywriter.write(password+"\n");
            mywriter.write(average_rating+"\n");
            mywriter.write(hourly_rate+"\n");
            mywriter.write(city+"\n");
            mywriter.write(area+"\n");
            mywriter.write(speciality+"\n");
            /*
            mywriter.write(rating.size()+"\n");
            for (int i=0;i<rating.size();i++)
            {
                mywriter.write(rating.get(i)+"\n");
            }
            */

            mywriter.close();

            //System.out.print("Filling done\n");
            return true;
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }
    }


    public WorkerModel get_worker(int id) {
        File myobj=new File(currentPath+"Worker.txt");



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int id_n = myReader.nextInt();
                myReader.nextLine();
                String name = myReader.nextLine();
                String email = myReader.nextLine();
                String password = myReader.nextLine();
                float average_rating=myReader.nextFloat();
                myReader.nextLine();
                float hourly_rate=myReader.nextFloat();
                myReader.nextLine();
                String city = myReader.nextLine();
                String area = myReader.nextLine();
                String speciality=myReader.nextLine();
                /*
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> rating = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    rating.add(myReader.nextInt());
                    myReader.nextLine();
                }
*/
                if (id == id_n) {
                    WorkerModel ret=new WorkerModel();
                    ret.id=id_n;
                    ret.name=name;
                    ret.email=email;
                    ret.password=password;
                    ret.avgRating=average_rating;
                    ret.hourlyRate=hourly_rate;
                    ret.city=city;
                    ret.area=area;
                    ret.speciality=speciality;
                    // ret.rating=rating;
                    return ret;
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return null;
    }


    public int does_worker_exist(String email, String password) {
        File myobj=new File(currentPath+"Worker.txt");



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int id_n = myReader.nextInt();
                myReader.nextLine();
                String name = myReader.nextLine();
                String email_n = myReader.nextLine();
                String password_n = myReader.nextLine();
                float average_rating=myReader.nextFloat();
                myReader.nextLine();
                float hourly_rate=myReader.nextFloat();
                myReader.nextLine();
                String city = myReader.nextLine();
                String area = myReader.nextLine();
                String speciality=myReader.nextLine();
                /*
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> rating = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    rating.add(myReader.nextInt());
                    myReader.nextLine();
                }
                */


                if (email_n.equals(email)&&password_n.equals(password)) {

                    return id_n;
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return -1;
    }


    public boolean does_worker_exist(int id) {
        File myobj=new File(currentPath+"Worker.txt");



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int id_n = myReader.nextInt();
                myReader.nextLine();
                String name = myReader.nextLine();
                String email_n = myReader.nextLine();
                String password_n = myReader.nextLine();
                float average_rating=myReader.nextFloat();
                myReader.nextLine();
                float hourly_rate=myReader.nextFloat();
                myReader.nextLine();
                String city = myReader.nextLine();
                String area = myReader.nextLine();
                String speciality=myReader.nextLine();
                /*
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> rating = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    rating.add(myReader.nextInt());
                    myReader.nextLine();
                }
                */


                if (id_n==id) {

                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return false;
    }


    public ArrayList<WorkerModel> get_worker(String city, String area) {
        File myobj=new File(currentPath+"Worker.txt");
        ArrayList<WorkerModel> ret=new ArrayList<WorkerModel>();

        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                WorkerModel temp=new WorkerModel();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.avgRating=myReader.nextFloat();
                myReader.nextLine();
                temp.hourlyRate=myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                temp.speciality=myReader.nextLine();
                /*
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> rating = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    rating.add(myReader.nextInt());
                    myReader.nextLine();
                }
                temp.rating=rating;

                 */

                if (temp.city.equals(city)&&temp.area.equals(area)) {

                    ret.add(temp);
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return ret;
    }


    public ArrayList<WorkerModel> get_all_worker() {
        File myobj=new File(currentPath+"Worker.txt");
        ArrayList<WorkerModel> ret=new ArrayList<WorkerModel>();


        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                WorkerModel temp=new WorkerModel();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.avgRating=myReader.nextFloat();
                myReader.nextLine();
                temp.hourlyRate=myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                temp.speciality=myReader.nextLine();
                /*
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> rating = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    rating.add(myReader.nextInt());
                    myReader.nextLine();
                }
                temp.rating=rating;

                 */
                ret.add(temp);



            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return ret;
    }


    public boolean update_Worker_city(int id, String city) {

        File myobj=new File("Worker.txt");
        ArrayList<WorkerModel> store=new ArrayList<WorkerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                WorkerModel temp=new WorkerModel();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.avgRating=myReader.nextFloat();
                myReader.nextLine();
                temp.hourlyRate=myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                temp.speciality=myReader.nextLine();
                /*
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> rating = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    rating.add(myReader.nextInt());
                    myReader.nextLine();
                }
                temp.rating=rating;

                 */

                if (temp.id==id) {
                    temp.city=city;
                    check=true;
                }
                store.add(temp);
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        try {
            FileWriter mywriter=new FileWriter("Worker.txt",false);

            for (int i=0;i<store.size();i++) {
                mywriter.write(store.get(i).id + "\n");
                mywriter.write(store.get(i).name + "\n");
                mywriter.write(store.get(i).email + "\n");
                mywriter.write(store.get(i).password + "\n");
                mywriter.write(store.get(i).avgRating + "\n");
                mywriter.write(store.get(i).hourlyRate + "\n");
                mywriter.write(store.get(i).city + "\n");
                mywriter.write(store.get(i).area + "\n");
                mywriter.write(store.get(i).speciality + "\n");
                /*
                mywriter.write(store.get(i).rating.size() + "\n");
                for (int j = 0; j < store.get(i).rating.size(); j++) {
                    mywriter.write(store.get(i).rating.get(j) + "\n");
                }

                 */
            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;

            //System.out.print("Filling done\n");
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }
    }


    public boolean update_Worker_area(int id, String area) {
        File myobj=new File("Worker.txt");
        ArrayList<WorkerModel> store=new ArrayList<WorkerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                WorkerModel temp=new WorkerModel();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.avgRating=myReader.nextFloat();
                myReader.nextLine();
                temp.hourlyRate=myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                temp.speciality=myReader.nextLine();
                /*
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> rating = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    rating.add(myReader.nextInt());
                    myReader.nextLine();
                }
                temp.rating=rating;

                 */

                if (temp.id==id) {
                    temp.area=area;
                    check=true;
                }
                store.add(temp);
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        try {
            FileWriter mywriter=new FileWriter("Worker.txt",false);

            for (int i=0;i<store.size();i++) {
                mywriter.write(store.get(i).id + "\n");
                mywriter.write(store.get(i).name + "\n");
                mywriter.write(store.get(i).email + "\n");
                mywriter.write(store.get(i).password + "\n");
                mywriter.write(store.get(i).avgRating + "\n");
                mywriter.write(store.get(i).hourlyRate + "\n");
                mywriter.write(store.get(i).city + "\n");
                mywriter.write(store.get(i).area + "\n");
                mywriter.write(store.get(i).speciality + "\n");
                /*
                mywriter.write(store.get(i).rating.size() + "\n");
                for (int j = 0; j < store.get(i).rating.size(); j++) {
                    mywriter.write(store.get(i).rating.get(j) + "\n");
                }

                 */
            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;

            //System.out.print("Filling done\n");
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }
    }



    public boolean update_hourly_rate(int id, float rate) {
        File myobj=new File("Worker.txt");
        ArrayList<WorkerModel> store=new ArrayList<WorkerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                WorkerModel temp=new WorkerModel();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.avgRating=myReader.nextFloat();
                myReader.nextLine();
                temp.hourlyRate=myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                temp.speciality=myReader.nextLine();
                /*
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> rating = new ArrayList<Integer>();

                for (int i = 0; i < size; i++) {
                    rating.add(myReader.nextInt());
                    myReader.nextLine();
                }
                temp.rating=rating;

                 */

                if (temp.id==id) {
                    temp.hourlyRate=rate;
                    check=true;
                }
                store.add(temp);
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        try {
            FileWriter mywriter=new FileWriter("Worker.txt",false);

            for (int i=0;i<store.size();i++) {
                mywriter.write(store.get(i).id + "\n");
                mywriter.write(store.get(i).name + "\n");
                mywriter.write(store.get(i).email + "\n");
                mywriter.write(store.get(i).password + "\n");
                mywriter.write(store.get(i).avgRating + "\n");
                mywriter.write(store.get(i).hourlyRate + "\n");
                mywriter.write(store.get(i).city + "\n");
                mywriter.write(store.get(i).area + "\n");
                mywriter.write(store.get(i).speciality + "\n");
                /*
                mywriter.write(store.get(i).rating.size() + "\n");
                for (int j = 0; j < store.get(i).rating.size(); j++) {
                    mywriter.write(store.get(i).rating.get(j) + "\n");
                }

                 */
            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;

            //System.out.print("Filling done\n");
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }
    }


    public boolean store_booking(int customer_id, int worker_id, String text, String status, LocalDateTime start_time, LocalDateTime end_time, ArrayList<Integer> spareParts)
    {

        int bid=0;
        File myo=new File(currentPath+"CountBooking.txt");
        try {
            Scanner myr = new Scanner(myo);
            bid=myr.nextInt();
        } catch (FileNotFoundException e) {
            bid=0;
        }

        bid++;
        try {
            FileWriter myw=new FileWriter(currentPath+"CountBooking.txt",false);
            myw.write(bid+"\n");
            myw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            FileWriter mywriter=new FileWriter(currentPath+"Booking.txt",true);


            mywriter.write(bid + "\n");
            mywriter.write(customer_id + "\n");
            mywriter.write(worker_id + "\n");
            mywriter.write(text + "\n");
            mywriter.write(status + "\n");
            mywriter.write(start_time + "\n");
            mywriter.write(end_time + "\n");
            mywriter.write(spareParts.size()+"\n");
            for (int i=0;i<spareParts.size();i++)
            {
                mywriter.write(spareParts.get(i)+"\n");
            }


            mywriter.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false;
        }

        return true;
    }

    public ArrayList<BookingModel> get_booking_of_worker(int worker_id, String status) {
        File myobj=new File(currentPath+"Booking.txt");

        ArrayList<BookingModel> give=new ArrayList<BookingModel>();


        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int bid = myReader.nextInt();
                myReader.nextLine();
                int cid = myReader.nextInt();
                myReader.nextLine();
                int wid = myReader.nextInt();
                myReader.nextLine();
                String text = myReader.nextLine();
                String status_n = myReader.nextLine();
                LocalDateTime start = LocalDateTime.parse(myReader.next());
                LocalDateTime end= LocalDateTime.parse(myReader.next());
                int size=myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> spare=new ArrayList<Integer>();

                for (int i=0;i<size;i++)
                {
                    spare.add(myReader.nextInt());
                    myReader.nextLine();

                }
                if (wid == worker_id&& status_n.equals(status)) {
                    BookingModel ret=new BookingModel();
                    ret.spareParts=new ArrayList<Integer>();

                    ret.id=bid;
                    ret.cid=(cid);
                    ret.wid=(wid);
                    ret.text=text;
                    ret.status=status;
                    ret.startTime=start;
                    ret.endTime=end;

                    for (int i=0;i<spare.size();i++) {
                        //if (temp!=null)
                        ret.spareParts.add(spare.get(i));
                    }
                    /*
                        System.out.print(bid+"\n");
                    System.out.print(cid+"\n");
                    System.out.print(wid+"\n");
                    System.out.print(text+"\n");
                    System.out.print(status+"\n");
                    System.out.print(start+"\n");
                    System.out.print(end+"\n");
*/
                    give.add(ret);
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return give;
    }



    public ArrayList<BookingModel> get_booking_of_customer(int customer_id, String status) {
        File myobj=new File(currentPath+"Booking.txt");

        ArrayList<BookingModel> give=new ArrayList<BookingModel>();


        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int bid = myReader.nextInt();
                myReader.nextLine();
                int cid = myReader.nextInt();
                myReader.nextLine();
                int wid = myReader.nextInt();
                myReader.nextLine();
                String text = myReader.nextLine();
                String status_n = myReader.nextLine();
                LocalDateTime start = LocalDateTime.parse(myReader.next());
                LocalDateTime end= LocalDateTime.parse(myReader.next());
                int size=myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> spare=new ArrayList<Integer>();

                for (int i=0;i<size;i++)
                {
                    spare.add(myReader.nextInt());
                    myReader.nextLine();

                }
                if (cid == customer_id&& status_n.equals(status)) {
                    BookingModel ret=new BookingModel();
                    ret.spareParts=new ArrayList<Integer>();

                    ret.id=bid;
                    ret.cid=(cid);
                    ret.wid=(wid);
                    ret.text=text;
                    ret.status=status;
                    ret.startTime=start;
                    ret.endTime=end;

                    for (int i=0;i<spare.size();i++) {
                        //if (temp!=null)
                        ret.spareParts.add(spare.get(i));
                    }
                    /*
                        System.out.print(bid+"\n");
                    System.out.print(cid+"\n");
                    System.out.print(wid+"\n");
                    System.out.print(text+"\n");
                    System.out.print(status+"\n");
                    System.out.print(start+"\n");
                    System.out.print(end+"\n");
*/
                    give.add(ret);
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return give;
    }



    public  ArrayList<BookingModel> get_booking_of_worker(int worker_id){
        File myobj=new File(currentPath+"Booking.txt");

        ArrayList<BookingModel> give=new ArrayList<BookingModel>();


        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int bid = myReader.nextInt();
                myReader.nextLine();
                int cid = myReader.nextInt();
                myReader.nextLine();
                int wid = myReader.nextInt();
                myReader.nextLine();
                String text = myReader.nextLine();
                String status = myReader.nextLine();
                LocalDateTime start = LocalDateTime.parse(myReader.next());
                LocalDateTime end= LocalDateTime.parse(myReader.next());
                int size=myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> spare=new ArrayList<Integer>();

                for (int i=0;i<size;i++)
                {
                    spare.add(myReader.nextInt());
                    myReader.nextLine();

                }
                if (wid == worker_id) {
                    BookingModel ret=new BookingModel();
                    ret.spareParts=new ArrayList<Integer>();

                    ret.id=bid;
                    ret.cid=cid;
                    ret.wid=wid;
                    ret.text=text;
                    ret.status=status;
                    ret.startTime=start;
                    ret.endTime=end;
                    ret.spareParts= new ArrayList<Integer>();

                    for (int i=0;i<spare.size();i++) {
                        //if (temp!=null)
                        ret.spareParts.add(spare.get(i));
                    }
                    /*
                        System.out.print(bid+"\n");
                    System.out.print(cid+"\n");
                    System.out.print(wid+"\n");
                    System.out.print(text+"\n");
                    System.out.print(status+"\n");
                    System.out.print(start+"\n");
                    System.out.print(end+"\n");
*/
                    give.add(ret);
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return give;
    }



    public ArrayList<BookingModel> get_booking_of_customer(int customer_id) {
        File myobj=new File(currentPath+"Booking.txt");

        ArrayList<BookingModel> give=new ArrayList<BookingModel>();


        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {

                int bid = myReader.nextInt();
                myReader.nextLine();
                int cid = myReader.nextInt();
                myReader.nextLine();
                int wid = myReader.nextInt();
                myReader.nextLine();
                String text = myReader.nextLine();
                String status = myReader.nextLine();
                LocalDateTime start = LocalDateTime.parse(myReader.next());
                LocalDateTime end= LocalDateTime.parse(myReader.next());
                int size=myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> spare=new ArrayList<Integer>();

                for (int i=0;i<size;i++)
                {
                    spare.add(myReader.nextInt());
                    myReader.nextLine();

                }
                if (cid == customer_id) {
                    BookingModel ret=new BookingModel();
                    ret.spareParts=new ArrayList<Integer>();

                    ret.id=bid;
                    ret.cid=cid;
                    ret.wid=wid;
                    ret.text=text;
                    ret.status=status;
                    ret.startTime=start;
                    ret.endTime=end;
                    ret.spareParts= new ArrayList<Integer>();

                    for (int i=0;i<spare.size();i++) {
                        //if (temp!=null)
                        ret.spareParts.add(spare.get(i));
                    }
                    /*
                        System.out.print(bid+"\n");
                    System.out.print(cid+"\n");
                    System.out.print(wid+"\n");
                    System.out.print(text+"\n");
                    System.out.print(status+"\n");
                    System.out.print(start+"\n");
                    System.out.print(end+"\n");
*/
                    give.add(ret);
                }
            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }
        // System.out.print("ID not found\n");


        return give;
    }


    public boolean update_booking_status(int booking_id, String status) {
        File myobj=new File("Booking.txt");

        ArrayList<BookingModel> give=new ArrayList<BookingModel>();
        boolean check=false;


        try {
            Scanner myReader = new Scanner(myobj);
            int gi=0;
            while(myReader.hasNext()) {
                BookingModel ret=new BookingModel();
                ret.spareParts=new ArrayList<Integer>();

                int bid = myReader.nextInt();
                myReader.nextLine();
                int cid = myReader.nextInt();
                myReader.nextLine();
                int wid = myReader.nextInt();
                myReader.nextLine();
                String text = myReader.nextLine();
                String status_n = myReader.nextLine();
                LocalDateTime start = LocalDateTime.parse(myReader.next());
                LocalDateTime end= LocalDateTime.parse(myReader.next());
                int size=myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> spare=new ArrayList<Integer>();

                for (int i=0;i<size;i++)
                {
                    spare.add(myReader.nextInt());
                    myReader.nextLine();

                }



                ret.id=bid;
                ret.cid=(cid);
                ret.wid=(wid);
                ret.text=text;
                ret.status=status_n;
                ret.startTime=start;
                ret.endTime=end;

                for (int i=0;i<spare.size();i++) {
                    //SparePartModel temp=new SparePartModel();
                    //temp=get_spare_part();
                    //if (temp!=null)
                    ret.spareParts.add(spare.get(i));


                }
                if (bid==booking_id) {
                    ret.status=status;
                    check=true;
                }
                give.add(ret);
                //give.get(gi).spareParts=new ArrayList<SparePartModel>();
                gi++;


            }
        }
        catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
            return false;
        }
        // System.out.print("ID not found\n");


        try {
            FileWriter mywriter = new FileWriter("Booking.txt", false);


            for (int i = 0; i < give.size(); i++) {
                mywriter.write(give.get(i).id + "\n");
                if (give.get(i) !=null)
                    mywriter.write(give.get(i).cid + "\n");
                else
                    mywriter.write(0 + "\n");
                if (give.get(i) !=null)
                    mywriter.write(give.get(i).wid + "\n");
                else
                    mywriter.write(0 + "\n");
                mywriter.write(give.get(i).text + "\n");
                mywriter.write(give.get(i).status + "\n");
                mywriter.write(give.get(i).startTime + "\n");
                mywriter.write(give.get(i).endTime + "\n");
                mywriter.write(give.get(i).spareParts.size() + "\n");
                for (int j = 0; j < give.get(i).spareParts.size(); j++) {
                    mywriter.write(give.get(i).spareParts.get(j) + "\n");
                }




            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


    }


    public boolean store_spare_holder(int booking_id, int spare_id, int quantity) {
        return false;
    }


    public ArrayList<SparePartModel> get_all_spare_parts_booking(int booking_id) {
        return null;
    }


    public ArrayList<WorkerModel> get_favourites_workers(int customer_id){
            File myobj=new File(currentPath+"Customer.txt");
            ArrayList<CustomerModel> store=new ArrayList<CustomerModel>();
            boolean check=false;


            try {
                Scanner myReader = new Scanner(myobj);
                while(myReader.hasNext()) {
                    CustomerModel temp=new CustomerModel();
                    temp.Favourite=new ArrayList<Integer>();

                    temp.id = myReader.nextInt();
                    myReader.nextLine();
                    temp.name = myReader.nextLine();
                    temp.email = myReader.nextLine();
                    temp.password = myReader.nextLine();
                    temp.paymentMethod=myReader.nextLine();
                    temp.creditno=myReader.nextLine();
                    temp.wallet = myReader.nextFloat();
                    myReader.nextLine();
                    temp.city = myReader.nextLine();
                    temp.area = myReader.nextLine();
                    int size = myReader.nextInt();
                    myReader.nextLine();

                    boolean present=false;
                    for (int i = 0; i < size; i++) {
                        temp.Favourite.add(myReader.nextInt());
                        myReader.nextLine();

                    }
                    store.add(temp);
                }

                int index = -1;
                for(int i = 0;i<store.size();i++){
                    if(store.get(i).id == customer_id){
                            index = i;
                            i=store.size()+1;
                    }
                }

                if(index != -1) {
                    ArrayList<Integer> myfav = store.get(index).Favourite;
                    ArrayList<WorkerModel> tt = new ArrayList<WorkerModel>();
                    for (int i = 0; i < myfav.size(); i++) {
                        tt.add(get_worker(myfav.get(i)));
                    }
                    return tt;
                }
                else
                    return new ArrayList<WorkerModel>();

            } catch (FileNotFoundException e) {
                System.out.print("Error in reading a file\n");
                e.printStackTrace();
                System.out.println(e.getMessage());
                return new ArrayList<WorkerModel>();
            }

    }




    public boolean add_favourite(int customer_id, int worker_id) {

        File myobj=new File(currentPath+"Customer.txt");
        ArrayList<CustomerModel> store=new ArrayList<CustomerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                CustomerModel temp=new CustomerModel();
                temp.Favourite=new ArrayList<Integer>();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.paymentMethod=myReader.nextLine();
                temp.creditno=myReader.nextLine();
                temp.wallet = myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> favourite = new ArrayList<Integer>();

                boolean present=false;
                for (int i = 0; i < size; i++) {
                    favourite.add(myReader.nextInt());
                    myReader.nextLine();

                    if (favourite.get(i)==worker_id)
                        present=true;
                }
                if (customer_id == temp.id&&!present) {
                    favourite.add(worker_id);
                    check=true;
                }


                for (int i=0;i<favourite.size();i++) {
                    int tempp=favourite.get(i);
                    //if (tempp != null)
                    temp.Favourite.add(tempp);
                }


                store.add(temp);


            }
        } catch (FileNotFoundException e) {
            System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }




        try {
            FileWriter mywriter=new FileWriter(currentPath+ "Customer.txt",false);

            for (int i=0;i<store.size();i++) {
                mywriter.write(store.get(i).id + "\n");
                mywriter.write(store.get(i).name + "\n");
                mywriter.write(store.get(i).email + "\n");
                mywriter.write(store.get(i).password + "\n");
                mywriter.write(store.get(i).paymentMethod + "\n");
                mywriter.write(store.get(i).creditno + "\n");
                mywriter.write(store.get(i).wallet + "\n");
                mywriter.write(store.get(i).city + "\n");
                mywriter.write(store.get(i).area + "\n");
                mywriter.write(store.get(i).Favourite.size() + "\n");
                for (int j = 0; j < store.get(i).Favourite.size(); j++) {
                    mywriter.write(store.get(i).Favourite.get(j) + "\n");
                }



            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }
    }


    public boolean remove_favourite(int customer_id, int worker_id) {


        File myobj = new File("Customer.txt");
        ArrayList<CustomerModel> store = new ArrayList<CustomerModel>();
        boolean check = false;


        try {
            Scanner myReader = new Scanner(myobj);
            while (myReader.hasNext()) {
                CustomerModel temp = new CustomerModel();
                temp.Favourite = new ArrayList<Integer>();

                temp.id = myReader.nextInt();
                myReader.nextLine();
                temp.name = myReader.nextLine();
                temp.email = myReader.nextLine();
                temp.password = myReader.nextLine();
                temp.paymentMethod = myReader.nextLine();
                temp.creditno = myReader.nextLine();
                temp.wallet = myReader.nextFloat();
                myReader.nextLine();
                temp.city = myReader.nextLine();
                temp.area = myReader.nextLine();
                int size = myReader.nextInt();
                myReader.nextLine();
                ArrayList<Integer> favourite = new ArrayList<Integer>();

                boolean present = false;
                for (int i = 0; i < size; i++) {
                    favourite.add(myReader.nextInt());
                    myReader.nextLine();

                    if (favourite.get(i) == worker_id)
                        present = true;
                }
                if (customer_id == temp.id && present) {
                    favourite.remove(new Integer(worker_id));
                    check = true;
                }


                for (int i = 0; i < favourite.size(); i++) {
                    int tempp = favourite.get(i);
                    //if (tempp != null)
                    temp.Favourite.add(tempp);
                }


                store.add(temp);


            }
        } catch (FileNotFoundException e) {
            //  System.out.print("Error in reading a file\n");
            e.printStackTrace();
        }


        try {
            FileWriter mywriter = new FileWriter("Customer.txt", false);

            for (int i = 0; i < store.size(); i++) {
                mywriter.write(store.get(i).id + "\n");
                mywriter.write(store.get(i).name + "\n");
                mywriter.write(store.get(i).email + "\n");
                mywriter.write(store.get(i).password + "\n");
                mywriter.write(store.get(i).paymentMethod + "\n");
                mywriter.write(store.get(i).creditno + "\n");
                mywriter.write(store.get(i).wallet + "\n");
                mywriter.write(store.get(i).city + "\n");
                mywriter.write(store.get(i).area + "\n");
                mywriter.write(store.get(i).Favourite.size() + "\n");
                for (int j = 0; j < store.get(i).Favourite.size(); j++) {
                    mywriter.write(store.get(i).Favourite.get(j) + "\n");
                }


            }
            mywriter.close();
            if (check)
                return true;
            else
                return false;
        } catch (IOException e) {
            // System.out.print("Error in storing customer in filling\n");
            e.printStackTrace();
            return false;
        }
    }

    //not needed

    public ArrayList<Integer> get_favourites(int customer_id) {
        return null;
    }
    //------------


    public boolean store_customer_billing( int booking_id,String title,String customerName,String workerName,String status,Float totalCost)//give int billing_id by db
    {
        try {
            FileWriter myWriter=new FileWriter("Billing.txt",true);
            myWriter.write(booking_id+"\n");
            myWriter.write(title+"\n");
            myWriter.write(customerName+"\n");
            myWriter.write(workerName+"\n");
            myWriter.write(status+"\n");
            myWriter.write(totalCost+"\n");
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }





        return true;
    }


    public BillingModel get_bill(int booking_id) {
        File obj=new File("Billing.txt");

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                BillingModel ret=new BillingModel();
                ret.bookingId=myReader.nextInt();
                myReader.nextLine();
                ret.title=myReader.nextLine();
                ret.customerName=myReader.nextLine();
                ret.workerName=myReader.nextLine();
                ret.status=myReader.nextLine();
                ret.totalCost=myReader.nextFloat();
                myReader.nextLine();
                if (ret.bookingId==booking_id)
                    return ret;


            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }


    public boolean change_billing_status(int booking_id, String status) {
        File obj=new File("Billing.txt");
        ArrayList<BillingModel> store=new ArrayList<BillingModel>();

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                BillingModel ret=new BillingModel();
                ret.bookingId=myReader.nextInt();
                myReader.nextLine();
                ret.title=myReader.nextLine();
                ret.customerName=myReader.nextLine();
                ret.workerName=myReader.nextLine();
                ret.status=myReader.nextLine();
                ret.totalCost=myReader.nextFloat();
                myReader.nextLine();
                if (ret.bookingId==booking_id) {
                    ret.status = status;

                }
                store.add(ret);
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        try {
            FileWriter myWriter=new FileWriter("Billing.txt",false);
            for (int i=0;i<store.size();i++) {
                myWriter.write(store.get(i).bookingId + "\n");
                myWriter.write(store.get(i).title + "\n");
                myWriter.write(store.get(i).customerName + "\n");
                myWriter.write(store.get(i).workerName + "\n");
                myWriter.write(store.get(i).status + "\n");
                myWriter.write(store.get(i).totalCost + "\n");
            }
            myWriter.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean store_complaint( int customer_id, int worker_id, String complain_text)//give int complain_id by DB
    {
        int id=0;
        File myo=new File("CountComplaint.txt");
        try {
            Scanner myr = new Scanner(myo);
            id=myr.nextInt();
        } catch (FileNotFoundException e) {
            id=0;
        }

        id++;
        try {
            FileWriter myw=new FileWriter("CountComplaint.txt",false);
            myw.write(id+"\n");
            myw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileWriter myWriter=new FileWriter("Complaint.txt",true);
            myWriter.write(id+"\n");
            myWriter.write(customer_id+"\n");
            myWriter.write(worker_id+"\n");
            myWriter.write(complain_text+"\n");
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;


    }


    public ComplainModel get_complaint(int complaint_id) {
        File obj=new File("Complaint.txt");

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                ComplainModel ret=new ComplainModel();
                ret.id=myReader.nextInt();
                myReader.nextLine();
                ret.cid=myReader.nextInt();
                myReader.nextLine();
                ret.wid=myReader.nextInt();
                myReader.nextLine();
                ret.text=myReader.nextLine();
                if (ret.id==complaint_id)
                    return ret;


            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }


    public ArrayList<ComplainModel> show_all_complaint(int customer_id) {
        File obj=new File("Complaint.txt");
        ArrayList<ComplainModel> store=new ArrayList<ComplainModel>();

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                ComplainModel ret=new ComplainModel();
                ret.id=myReader.nextInt();
                myReader.nextLine();
                ret.cid=myReader.nextInt();
                myReader.nextLine();
                ret.wid=myReader.nextInt();
                myReader.nextLine();
                ret.text=myReader.nextLine();
                if (ret.cid==customer_id)
                {
                    store.add(ret);
                }


            }


            return store;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }


    public boolean store_spar_parts( String name, float cost, int quantity) // give int spare_id
    {
        int id=0;
        File myo=new File("CountSpare.txt");
        try {
            Scanner myr = new Scanner(myo);
            id=myr.nextInt();
        } catch (FileNotFoundException e) {
            id=0;
        }

        id++;
        try {
            FileWriter myw=new FileWriter("CountSpare.txt",false);
            myw.write(id+"\n");
            myw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileWriter myWriter=new FileWriter("spareParts.txt",true);
            myWriter.write(id+"\n");
            myWriter.write(name+"\n");
            myWriter.write(cost+"\n");
            myWriter.write(quantity+"\n");
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }





        return true;
    }


    public SparePartModel get_spare_part(int part_id) {

        File obj=new File("spareParts.txt");

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                SparePartModel ret=new SparePartModel();
                ret.id=myReader.nextInt();
                myReader.nextLine();
                ret.name=myReader.nextLine();
                ret.cost=myReader.nextFloat();
                myReader.nextLine();
                ret.quantity=myReader.nextInt();
                myReader.nextLine();
                if (ret.id==part_id)
                    return ret;


            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


    public ArrayList<SparePartModel> get_all_parts() {

        File obj=new File("spareParts.txt");
        ArrayList<SparePartModel> give=new ArrayList<SparePartModel>();

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                SparePartModel ret=new SparePartModel();
                ret.id=myReader.nextInt();
                myReader.nextLine();
                ret.name=myReader.nextLine();
                ret.cost=myReader.nextFloat();
                myReader.nextLine();
                ret.quantity=myReader.nextInt();
                myReader.nextLine();

                give.add(ret);


            }
            return give;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean deduct_part(int spare_id, int quantity) {
        File obj=new File("spareParts.txt");
        ArrayList<SparePartModel> give=new ArrayList<SparePartModel>();
        boolean check=false;

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                SparePartModel ret=new SparePartModel();
                ret.id=myReader.nextInt();
                myReader.nextLine();
                ret.name=myReader.nextLine();
                ret.cost=myReader.nextFloat();
                myReader.nextLine();
                ret.quantity=myReader.nextInt();
                myReader.nextLine();
                if (ret.id==spare_id)
                {
                    if ((ret.quantity-quantity)>=0)
                    {
                        ret.quantity= ret.quantity-quantity;
                        check=true;

                    }
                    else
                        return false;
                }


                give.add(ret);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            FileWriter myWriter=new FileWriter("spareParts.txt",false);

            for (int i=0;i<give.size();i++) {
                myWriter.write(give.get(i).id + "\n");
                myWriter.write(give.get(i).name + "\n");
                myWriter.write(give.get(i).cost + "\n");
                myWriter.write(give.get(i).quantity + "\n");
            }
            myWriter.close();

            if (check)
                return true;
            else
                return false;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }


    public boolean store_rating(int customer_id, int worker_id, int rating) {
        try {
            FileWriter myWriter=new FileWriter("Rating.txt",true);


            myWriter.write(customer_id + "\n");
            myWriter.write(worker_id + "\n");
            myWriter.write(rating + "\n");


            myWriter.close();

            return true;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    public float get_avg_rating(int worker_id) {
        File obj=new File("Rating.txt");
        ArrayList<RatingModel> store =new ArrayList<RatingModel>();

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                RatingModel ret=new RatingModel();
                ret.cid=myReader.nextInt();
                myReader.nextLine();
                ret.wid=myReader.nextInt();
                myReader.nextLine();
                ret.rating=myReader.nextInt();
                myReader.nextLine();
                if (ret.wid==worker_id)
                {
                    store.add(ret);
                }



            }

            float rat=0f;
            int sum=0;
            for (int i=0;i<store.size();i++)
            {
                sum=sum+store.get(i).rating;

            }
            rat=sum/store.size();

            return rat;



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return 0f;
    }


    public ArrayList<RatingModel> getAllRatings(int customer_id) {
        File obj=new File("Rating.txt");
        ArrayList<RatingModel> store =new ArrayList<RatingModel>();

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                RatingModel ret=new RatingModel();
                ret.cid=myReader.nextInt();
                myReader.nextLine();
                ret.wid=myReader.nextInt();
                myReader.nextLine();
                ret.rating=myReader.nextInt();
                myReader.nextLine();
                if (ret.cid==customer_id)
                {
                    store.add(ret);
                }



            }



            return store;



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


    public boolean store_chat(int sender_id,int reciever_id,String sender_name,String receiver_name,String text) {
        try {
            FileWriter myWriter=new FileWriter("Rating.txt",true);


            myWriter.write(sender_id + "\n");
            myWriter.write(reciever_id + "\n");
            myWriter.write(sender_name + "\n");
            myWriter.write(receiver_name + "\n");
            myWriter.write(text + "\n");


            myWriter.close();

            return true;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    public ArrayList<ChatMessageModel> get_chat_history(int customer_id, int worker_id) {
        File obj=new File("Rating.txt");
        ArrayList<ChatMessageModel> store =new ArrayList<ChatMessageModel>();

        try {
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNext())
            {
                ChatMessageModel ret=new ChatMessageModel();
                ret.senderId=myReader.nextInt();
                myReader.nextLine();
                ret.receiverId=myReader.nextInt();
                myReader.nextLine();
                ret.senderName=myReader.nextLine();
                ret.receiverName=myReader.nextLine();
                ret.message=myReader.nextLine();
                if (ret.senderId==customer_id&&ret.receiverId==worker_id)
                {
                    store.add(ret);
                }



            }



            return store;



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
