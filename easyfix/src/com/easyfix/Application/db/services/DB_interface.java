package com.easyfix.Application.db.services;
//import org.json.simple.JSONObject;
import com.easyfix.Application.models.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public interface DB_interface {
/*  //updated db
public boolean does_customer_exist(int id);
public int does_customer_exist(String email,String password); //id returned
public boolean store_customer(String name,String email,String password,String credit_no,float wallet,String city,String area,ArrayList<Integer> favourite);//id given by default by DB
public boolean update_customer_city(int id,String city);
public boolean update_customer_area(int id,String area);
public boolean update_customerPayment(int id,String payment);
public CustomerModel get_customer(int id);

public boolean store_worker(String name,String email,String password,float average_rating,float hourly_rate,String city,String area,String speciality);//id given by default by DB
public WorkerModel get_worker(int id);
public int does_worker_exist(String email,String password);
public boolean does_worker_exist(int id);
public ArrayList<WorkerModel> get_worker(String city,String area);
public ArrayList<WorkerModel> get_all_worker();
public boolean update_Worker_city(int id,String city);
public boolean update_Worker_area(int id,String area);
public boolean update_hourly_rate(int id,float rate);

public boolean store_booking( int customer_id, int worker_id, String text, String status, LocalDateTime start_time,LocalDateTime end_time,ArrayList<Integer> spareParts);//bid given by default by DB
public  ArrayList<BookingModel> get_booking(int customer_id);
public ArrayList<BookingModel> get_booking(int customer_id,String status);
public boolean update_booking_status(int booking_id,String status);


//these not needed maybe see them
public boolean store_spare_holder(int booking_id,int spare_id,int quantity);
public ArrayList<SparePartModel> get_all_spare_parts_booking(int booking_id);//part id,quantity returned



public boolean add_favourite(int customer_id,int worker_id);
public boolean remove_favourite(int customer_id,int worker_id);
//this not needed
public ArrayList<Integer> get_favourites(int customer_id);



public boolean store_customer_billing(int booking_id,int worker_id,int cost);//int billing_id, given by DB
public ArrayList<BillingModel> get_customer_billing(int booking_id);

public boolean store_complaint(int customer_id,int worker_id,String complain_text);//int complain_id, given by DB
public  ComplainModel get_complaint(int complaint_id);
public ArrayList<ComplainModel> show_all_complaint(int customer_id);

public boolean store_spar_parts(String name,float cost,int quantity);//int spare_id, given by DB
public  SparePartModel get_spare_part(int part_id);
public ArrayList<SparePartModel> get_all_parts();//for quantity>0
public boolean deduct_part(int spare_id,int quantity);

public boolean store_rating(int customer_id,int worker_id,int rating);
public float get_avg_rating(int worker_id);
public ArrayList<RatingModel> getAllRatings(int customer_id);

public  boolean store_chat(int customer_id,int worker_id,String text);
public ArrayList<ChatMessageModel> get_chat_history(int customer_id,int worker_id);


 */
}
