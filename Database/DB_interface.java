package Classes;

//import org.json.simple.JSONObject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import models.*;

public interface DB_interface {

public boolean does_customer_exist(int id);
public int does_customer_exist(String email,String password); //id returned
public boolean store_customer(int id,String name,String email,String password,String credit_no,float wallet,String city,String area,ArrayList<Integer> favourite);
public boolean update_customer_city(int id,String city);
public boolean update_customer_area(int id,String area);
public boolean update_customerPayment(int id,String payment);
public CustomerModel get_customer(int id);

public boolean store_worker(int id,String name,String email,String password,float average_rating,float hourly_rate,String city,String area,String speciality,ArrayList<Integer> rating);
public WorkerModel get_worker(int id);
public int does_worker_exist(String email,String password); //id returned
public ArrayList<WorkerModel> get_worker(String city,String area);
public ArrayList<WorkerModel> get_all_worker();
public boolean update_Worker_city(int id,String city);
public boolean update_Worker_area(int id,String area);
public boolean update_hourly_rate(int id,int rate);

public boolean store_booking(int bid, String name, int customer_id, int worker_id, int hours);
public  ArrayList<BookingModel> get_booking(int customer_id);

public boolean store_spare_holder(int booking_id,int spare_id,int quantity);
public ArrayList<SparePartModel> get_all_spare_parts_booking(int booking_id);//part id,quantity



public boolean store_favourite(int customer_id,ArrayList<Integer> worker_id);
public ArrayList<Integer> get_favourites(int customer_id);


public boolean store_customer_billing(int billing_id,int booking_id,int worker_id,int cost);
public ArrayList<BillingModel> get_customer_billing(int customer_id);

public boolean store_complaint(int complain_id,int customer_id,int worker_id,String complain_text);
public  ComplainModel get_complaint(int complaint_id);
public ArrayList<ComplainModel> show_all_complaint(int customer_id);

public boolean store_spar_parts(int spare_id,String name,int cost,int quantity);
public  SparePartModel get_spare_part(int part_id);
public ArrayList<SparePartModel> get_all_parts();//for quantity>0
public boolean deduct_part(int spare_id,int quantity);

public boolean store_rating(int customer_id,int worker_id,int rating);
public float get_avg_rating(int customer_id);

public  boolean store_chat(int customer_id,int worker_id,String text);
public ArrayList<ChatMessageModel> get_chat_history(int customer_id,int worker_id);

}
