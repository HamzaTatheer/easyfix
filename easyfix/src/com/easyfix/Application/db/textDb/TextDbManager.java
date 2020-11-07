package com.easyfix.Application.db.textDb;

import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.WorkerModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextDbManager implements DbService {
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

    public boolean store_customer(String name, String email, String password, String creditNo, float wallet, String city, String area, ArrayList<Integer> favourite) throws Exception {
        throw new Exception("Functionality still in progress. try customer@gmail.com or worker@gmail.com");
    }

    public boolean update_customer_city(int id,String city){
        if(id == 1){
            return true;
        }
        else
            return false;
    }
    public boolean update_customer_area(int id,String area){
        if(id == 1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean update_customerPayment(int id,String payment){
        if(id == 1){
            return true;
        }
        else{
            return false;
        }
    }


    public boolean update_customerWallet(int cid,Float money){
            return true;
    }


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


    public boolean store_worker(String name,String email,String password,float average_rating,float hourly_rate,String city,String area,String speciality){
        return true;
    }
    public WorkerModel get_worker(int id){
        WorkerModel w = new WorkerModel();
        w.id=2;
        w.name="worker";
        w.email="worker@gmail.com";
        w.password="worker";
        w.area="dha";
        w.city="lahore";
        w.hourlyRate=20;
        w.speciality="plumber";
        w.avgRating=3;
        return w;
    }
    public int does_worker_exist(String email,String password){
        if((email == "worker@gmail.com")&&(password=="worker")){
            return 2;
        }
        else{
            return -1;
        }
    }
    public boolean does_worker_exist(int id){
        if(id == 2)
            return true;
        else
            return false;
    }
    public ArrayList<WorkerModel> get_worker(String city, String area){
        WorkerModel w = new WorkerModel();
        w.id=2;
        w.name="worker";
        w.email="worker@gmail.com";
        w.password="worker";
        w.area="dha";
        w.city="lahore";
        w.hourlyRate=20;
        w.speciality="plumber";
        w.avgRating=3;
        ArrayList<WorkerModel> aa = new ArrayList<WorkerModel>();
        aa.add(w);
        return aa;
    }
    public ArrayList<WorkerModel> get_all_worker(){
        WorkerModel w = new WorkerModel();
        w.id=2;
        w.name="worker";
        w.email="worker@gmail.com";
        w.password="worker";
        w.area="dha";
        w.city="lahore";
        w.hourlyRate=20;
        w.speciality="plumber";
        w.avgRating=3;
        ArrayList<WorkerModel> aa = new ArrayList<WorkerModel>();
        aa.add(w);
        return aa;
    }
    public boolean update_Worker_city(int id,String city){
        return true;
    }
    public boolean update_Worker_area(int id,String area){
        return true;
    }
    public boolean update_hourly_rate(int id,float rate){
        return true;
    }

    public boolean store_rating(int customer_id,int worker_id,int rating){
        return true;
    }
    public float get_avg_rating(int worker_id){
        return 2.5f;
    }
}
