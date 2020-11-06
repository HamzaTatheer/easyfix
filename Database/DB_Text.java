package Classes;

import models.*;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files



public class DB_Text implements DB_interface {

    @Override
    public boolean does_customer_exist(int id) {

        File myobj=new File("Customer.txt");



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

    @Override
    public int does_customer_exist(String email, String password) {

        File myobj=new File("Customer.txt");



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

    @Override
    public boolean store_customer(String name, String email, String password,String credit_no, float wallet, String city,String area, ArrayList<Integer> favourite) {
        int id=0;
        File myo=new File("CountCustomer.txt");
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
            FileWriter mywriter=new FileWriter("Customer.txt",true);
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

    @Override
    public boolean update_customer_city(int id, String city) {

        File myobj=new File("Customer.txt");
        ArrayList<CustomerModel> store=new ArrayList<CustomerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                CustomerModel temp=new CustomerModel();
                temp.Favourite=new ArrayList<WorkerModel>();

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
                    favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }


                for (int i=0;i<favourite.size();i++) {
                    WorkerModel tempp= new WorkerModel();
                    tempp=get_worker(favourite.get(i));
                    if (tempp!=null)
                        temp.Favourite.add(tempp);
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
                    mywriter.write(store.get(i).Favourite.get(j).id + "\n");
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

    @Override
    public boolean update_customer_area(int id, String area) {
        File myobj=new File("Customer.txt");
        ArrayList<CustomerModel> store=new ArrayList<CustomerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                CustomerModel temp=new CustomerModel();
                temp.Favourite=new ArrayList<WorkerModel>();

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
                    favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }
                for (int i=0;i<favourite.size();i++) {
                    WorkerModel tempp=get_worker(favourite.get(i));
                    if (tempp!=null)
                        temp.Favourite.add(tempp);
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
                    mywriter.write(store.get(i).Favourite.get(j).id + "\n");
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

    @Override
    public boolean update_customerPayment(int id, String payment) {
        File myobj=new File("Customer.txt");
        ArrayList<CustomerModel> store=new ArrayList<CustomerModel>();
        boolean check=false;



        try {
            Scanner myReader = new Scanner(myobj);
            while(myReader.hasNext()) {
                CustomerModel temp=new CustomerModel();
                temp.Favourite=new ArrayList<WorkerModel>();

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
                    favourite.add(myReader.nextInt());
                    myReader.nextLine();
                }
                for (int i=0;i<favourite.size();i++) {
                    WorkerModel tempp=get_worker(favourite.get(i));
                    if (tempp!=null)
                        temp.Favourite.add(tempp);
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
                    mywriter.write(store.get(i).Favourite.get(j).id + "\n");
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

    @Override
    public CustomerModel get_customer(int id) {
        File myobj=new File("Customer.txt");



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
                        ret.Favourite=new ArrayList<WorkerModel>();
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
                            WorkerModel temp=get_worker(favourite.get(i));
                            if (temp!=null)
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

    @Override
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

    @Override
    public WorkerModel get_worker(int id) {
        File myobj=new File("Worker.txt");



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

    @Override
    public int does_worker_exist(String email, String password) {
        File myobj=new File("Worker.txt");



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

    @Override
    public boolean does_worker_exist(int id) {
        File myobj=new File("Worker.txt");



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

    @Override
    public ArrayList<WorkerModel> get_worker(String city, String area) {
        File myobj=new File("Worker.txt");
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

    @Override
    public ArrayList<WorkerModel> get_all_worker() {
        File myobj=new File("Worker.txt");
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

    @Override
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

    @Override
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


    @Override
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

    @Override
    public boolean store_booking(int customer_id, int worker_id, String text, String status, LocalDateTime start_time, LocalDateTime end_time, ArrayList<Integer> spareParts)
    {

        int bid=0;
        File myo=new File("CountBooking.txt");
        try {
            Scanner myr = new Scanner(myo);
            bid=myr.nextInt();
        } catch (FileNotFoundException e) {
            bid=0;
        }

        bid++;
        try {
            FileWriter myw=new FileWriter("CountBooking.txt",false);
            myw.write(bid+"\n");
            myw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



        try {
            FileWriter mywriter=new FileWriter("Booking.txt",true);


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

    @Override
    public ArrayList<BookingModel> get_booking(int customer_id) {
        File myobj=new File("Booking.txt");

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
                    ret.spareParts=new ArrayList<SparePartModel>();

                    ret.id=bid;
                    ret.cid=get_customer(cid);
                    ret.wid=get_worker(wid);
                    ret.text=text;
                    ret.status=status;
                    ret.startTime=start;
                    ret.endTime=end;
                    ret.spareParts=new ArrayList<SparePartModel>();

                    for (int i=0;i<spare.size();i++) {
                        SparePartModel temp=new SparePartModel();
                        temp=get_spare_part(spare.get(i));
                        if (temp!=null)
                        ret.spareParts.add(temp);
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

    @Override
    public ArrayList<BookingModel> get_booking(int customer_id, String status) {
        File myobj=new File("Booking.txt");

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
                    ret.spareParts=new ArrayList<SparePartModel>();

                    ret.id=bid;
                    ret.cid=get_customer(cid);
                    ret.wid=get_worker(wid);
                    ret.text=text;
                    ret.status=status;
                    ret.startTime=start;
                    ret.endTime=end;

                    for (int i=0;i<spare.size();i++) {
                        SparePartModel temp=new SparePartModel();
                        temp=get_spare_part(spare.get(i));
                        if (temp!=null)
                            ret.spareParts.add(temp);
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

    @Override
    public boolean update_booking_status(int booking_id, String status) {
        File myobj=new File("Booking.txt");

        ArrayList<BookingModel> give=new ArrayList<BookingModel>();
        boolean check=false;


        try {
            Scanner myReader = new Scanner(myobj);
            int gi=0;
            while(myReader.hasNext()) {
                BookingModel ret=new BookingModel();
                ret.spareParts=new ArrayList<SparePartModel>();

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
                    ret.cid=get_customer(cid);
                    ret.wid=get_worker(wid);
                    ret.text=text;
                    ret.status=status_n;
                    ret.startTime=start;
                    ret.endTime=end;

                    for (int i=0;i<spare.size();i++) {
                        SparePartModel temp=new SparePartModel();
                        temp=get_spare_part(spare.get(i));
                        if (temp!=null)
                            ret.spareParts.add(temp);


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
                if (give.get(i).cid!=null)
                mywriter.write(give.get(i).cid.id + "\n");
                else
                    mywriter.write(0 + "\n");
                if (give.get(i).wid!=null)
                mywriter.write(give.get(i).wid.id + "\n");
                else
                    mywriter.write(0 + "\n");
                mywriter.write(give.get(i).text + "\n");
                mywriter.write(give.get(i).status + "\n");
                mywriter.write(give.get(i).startTime + "\n");
                mywriter.write(give.get(i).endTime + "\n");
                mywriter.write(give.get(i).spareParts.size() + "\n");
                for (int j = 0; j < give.get(i).spareParts.size(); j++) {
                    mywriter.write(give.get(i).spareParts.get(j).id + "\n");
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

    @Override
    public boolean store_spare_holder(int booking_id, int spare_id, int quantity) {
        return false;
    }

    @Override
    public ArrayList<SparePartModel> get_all_spare_parts_booking(int booking_id) {
        return null;
    }

    @Override
    public boolean add_favourite(int customer_id, int worker_id) {
        return false;
    }

    @Override
    public boolean remove_favourite(int customer_id, int worker_id) {
        return false;
    }


    @Override
    public ArrayList<Integer> get_favourites(int customer_id) {
        return null;
    }

    @Override
    public boolean store_customer_billing( int booking_id, int worker_id, int cost)//give int billing_id by db
    {
        return false;
    }

    @Override
    public ArrayList<BillingModel> get_customer_billing(int booking_id) {
        return null;
    }

    @Override
    public boolean store_complaint( int customer_id, int worker_id, String complain_text)//give int complain_id by DB
    {
        return false;
    }

    @Override
    public ComplainModel get_complaint(int complaint_id) {
        return null;
    }

    @Override
    public ArrayList<ComplainModel> show_all_complaint(int customer_id) {
        return null;
    }

    @Override
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

    @Override
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

    @Override
    public ArrayList<SparePartModel> get_all_parts() {
        return null;
    }

    @Override
    public boolean deduct_part(int spare_id, int quantity) {
        return false;
    }

    @Override
    public boolean store_rating(int customer_id, int worker_id, int rating) {
        return false;
    }

    @Override
    public float get_avg_rating(int customer_id) {
        return 0;
    }

    @Override
    public ArrayList<RatingModel> getAllRatings(int customer_id) {
        return null;
    }

    @Override
    public boolean store_chat(int customer_id, int worker_id, String text) {
        return false;
    }

    @Override
    public ArrayList<ChatMessageModel> get_chat_history(int customer_id, int worker_id) {
        return null;
    }
}
