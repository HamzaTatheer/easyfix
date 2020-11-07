package com.easyfix.Application.db.textDb;

import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.CustomerModel;
import com.easyfix.Application.models.WorkerModel;

import java.util.ArrayList;

public class TextDbManager implements DbService {
    public boolean does_customer_exist(int id){
    if((id==1) || (id ==2)){
        return true;
    }
    else
        return false;
}

    //access from sql server
    public int does_customer_exist(String email,String password){
        if((email == "admin@gmail.com")&&(password == "admin"))
            return 1;
        else{
            return -1;
        }
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


    public CustomerModel get_customer(int id){
        CustomerModel c = new CustomerModel();
        c.id=1;
        c.name="customer";
        c.email="customer";
        c.password="customer";
        c.city="lahore";
        c.area="dha";
        c.creditno="1234678";
        c.Favourite = new ArrayList<>();
        c.paymentMethod="cash";
        c.wallet = 200.0f;
        return c;
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
