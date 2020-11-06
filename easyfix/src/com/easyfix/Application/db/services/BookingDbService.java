package com.easyfix.Application.db.services;

import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.SparePartModel;
import com.easyfix.Application.models.WorkerModel;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface BookingDbService {
    public boolean store_booking(int customer_id, int worker_id, String text, String status, LocalDateTime start_time, LocalDateTime end_time, ArrayList<SparePartModel> spareParts);//bid given by default by DB
    public  ArrayList<BookingModel> get_booking(int customer_id);
    public ArrayList<BookingModel> get_booking(int customer_id, String status);
    public boolean update_booking_status(int booking_id,String status);
}
