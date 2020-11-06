package com.easyfix.Application.db.sqlDb;

import com.easyfix.Application.db.services.BookingDbService;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.SparePartModel;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingSqlManager implements BookingDbService {
    public boolean store_booking(int customer_id, int worker_id, String text, String status, LocalDateTime start_time, LocalDateTime end_time, ArrayList<SparePartModel> spareParts){
        return true;
    }
    public  ArrayList<BookingModel> get_booking(int customer_id){
        return new ArrayList<BookingModel>()
    }
    public ArrayList<BookingModel> get_booking(int customer_id, String status){
        return new ArrayList<BookingModel>()
    }
    public boolean update_booking_status(int booking_id,String status){
        return true;
    }
}
