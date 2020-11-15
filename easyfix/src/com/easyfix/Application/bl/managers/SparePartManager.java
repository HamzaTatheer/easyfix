package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.services.SparePartService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.SparePartModel;

import java.util.ArrayList;

public class SparePartManager implements SparePartService {

    DbService db;
    public SparePartManager(){
        db = dbProviders.getDbService();
    }
    public Boolean addSparePart(String _name,float _cost,int _quantity){
        return db.store_spar_parts(_name,_cost,_quantity);
    }
    public ArrayList<SparePartModel> showAllSpareParts(){
        return db.get_all_parts();
    }

    public boolean addSparePartsToBooking(int bid,int pid,int quantity)throws Exception{
        SparePartModel sp = db.get_spare_part(pid);
        if(sp.quantity >= quantity){
            db.deduct_part(pid,quantity);//from warehouse
            return db.store_spare_holder(bid,pid,quantity);
        }
        else
        {
            throw new Exception("Quantity of SpartPart exceeded");
        }

    }
}
