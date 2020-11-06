package com.easyfix.Application.db.services;

import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.SparePartModel;

import java.util.ArrayList;

public interface SparePartDbService {
    public boolean store_spare_holder(int booking_id,int spare_id,int quantity);
    public ArrayList<SparePartModel> get_all_spare_parts_booking(int booking_id);//part id,quantity returned
    public boolean store_spar_parts(String name,float cost,int quantity);//int spare_id, given by DB
    public  SparePartModel get_spare_part(int part_id);
    public ArrayList<SparePartModel> get_all_parts();//for quantity>0
    public boolean deduct_part(int spare_id,int quantity);
}
