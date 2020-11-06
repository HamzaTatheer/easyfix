package com.easyfix.Application.bl.managers;

import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.db.services.WorkerDbService;
import com.easyfix.Application.models.RatingModel;

import java.util.ArrayList;

public class RatingManager {
    //public ArrayList<RatingModel> showAllRatings(int id){ //pending}
    public void giveRating(int giverID,int receiverID,int workerRating) throws Exception{

        CustomerDbService custdbservice = dbProviders.getCustomerDbService();
        WorkerDbService workDbService=dbProviders.getWorkerDbService();
        if((custdbservice.does_customer_exist(giverID)&& (workDbService.does_Worker_Exist(receiverID)))){

        }
        else {
            throw new Exception("One of the user doesn't exist. Please try again");
        }
    }
}
