package Classes;

import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.Date;


public interface DB_interface {

public boolean does_customer_exist(int id);
public boolean store_customer(int id,String name,String email,String password,float wallet,String address,ArrayList favourite);
public boolean update_customerPayment(int id,String payment);
public JSONObject get_customer(int id);

public boolean store_worker(int id,int average_rating,int hourly_rate,String city,String area,String speciality,ArrayList rating);
public JSONObject get_worker(int id);
public boolean update_Worker_location(int id,String location);
public boolean update_hourly_rate(int id,int rate);

public boolean store_booking(int bid, String name, int customer_id, int worker_id, Date start_time, Date end_time);
public  ArrayList<JSONObject> get_booking(int customer_id);

public boolean store_favourite(int customer_id,ArrayList worker_id);
public ArrayList get_favourites(int customer_id);

public boolean store_customer_billing(int billing_id,int customer_id,int worker_id,int cost);
public ArrayList<JSONObject> get_customer_billing(int customer_id);

public boolean store_complaint(int complain_id,int customer_id,int worker_id,String complain_text);
public  JSONObject get_complaint(int complaint_id);
public ArrayList<JSONObject> show_all_complaint(int customer_id);

public boolean store_spar_parts(int spare_id,String name,int cost,int quantity);
public  JSONObject get_spare_parts(int part_id);
public ArrayList<JSONObject> get_all_parts();//for quantity>0

public boolean store_rating(int customer_id,int worker_id,int rating);
public float get_avg_rating(int customer_id);

public  boolean store_chat(int customer_id,int worker_id,String text);
public ArrayList<JSONObject> get_chat_history(int customer_id,int worker_id);

}
