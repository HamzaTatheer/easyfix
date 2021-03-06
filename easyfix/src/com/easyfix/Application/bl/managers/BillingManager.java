package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Booking;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.classes.SparePart;
import com.easyfix.Application.bl.classes.Worker;
import com.easyfix.Application.bl.services.BillingService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.bl.services.DbService;
import com.easyfix.Application.models.*;

import java.util.ArrayList;

public class BillingManager implements BillingService {

    public DbService db;

    public BillingManager(){
        db = dbProviders.getDbService();
    }

    public BillingModel showBill(int bid) throws Exception{
        BillingModel b = db.get_bill(bid);
        if(b ==null){
            try {
                return generate_Bill(bid);
            }
            catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }
        else
        {
            return b;
        }
    }


    private BillingModel generate_Bill(int bid) throws Exception{

        //-------Getting Booking Model------
        BookingModel bookingModel = db.get_booking(bid).get(0);
        CustomerModel customerModel = db.get_customer(bookingModel.cid);
        WorkerModel workerModel = db.get_worker(bookingModel.wid);

        Customer c = new Customer(customerModel);
        Worker w = new Worker(workerModel);
        ArrayList<SparePart> spareParts = new ArrayList<>();
        ArrayList<SparePartModel> sparePartModels = db.get_all_spare_parts_booking(bid);

        if(sparePartModels == null)
            sparePartModels = new ArrayList<SparePartModel>();

        for(int i=0;i<sparePartModels.size();i++){
            spareParts.add(new SparePart(sparePartModels.get(i)));
        }
        //----------------------

        //--Creating Booking entity--
        Booking b = new Booking(bookingModel.id,bookingModel.text,bookingModel.status,bookingModel.startTime,bookingModel.endTime,spareParts,c,w);

        //--Calculate and Store Bill--
        float totalCost;
        try {
            totalCost = b.calculateCost();
            db.store_customer_billing(bid, b.getText(), c.getId(), w.getId(), "unpaid", totalCost);
        }
        catch (Exception e){
            //System.out.println(e.getMessage());
            throw new Exception("Bill not stored in db. db error");
        }


        //returning Bill model which was also stored
        BillingModel mybill = new BillingModel();
        mybill.bookingId = bid;
        mybill.title = b.getText();
        //mybill.cid = c.getId();
        //mybill.wid = w.getId();
        mybill.status = "unpaid";
        mybill.totalCost = totalCost;
        return mybill;
    }



}




