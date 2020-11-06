package com.easyfix.Application.db.sqlDb;

import com.easyfix.Application.models.CustomerModel;

import java.util.ArrayList;


public class CustomerSqlManager implements CustomerDbService {
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

    public boolean store_customer(String name,String email,String password,String creditNo,float wallet,String city,String area,ArrayList<Integer> favourite) throws Exception {
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
}
