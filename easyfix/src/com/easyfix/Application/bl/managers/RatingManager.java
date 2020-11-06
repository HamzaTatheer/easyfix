package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Rating;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.CustomerDbService;
import com.easyfix.Application.db.services.DB_interface;
import com.easyfix.Application.db.services.WorkerDbService;
import com.easyfix.Application.models.RatingModel;

import java.util.ArrayList;

public class RatingManager {
    //public ArrayList<RatingModel> showAllRatings(int id){ //pending}

    // UI should send us model, then we will extract giverID,  receiverID, workerRating,, What do you say?
    public Boolean giveRating(int giverID,int receiverID,int workerRating) throws Exception{

        CustomerDbService custdbservice = dbProviders.getCustomerDbService();
        WorkerDbService workDbService=dbProviders.getWorkerDbService();

        if((custdbservice.does_customer_exist(giverID)&& (workDbService.does_Worker_Exist(receiverID)))){
            //RatingDbService rateDbService=dbProviders.getRatingDbService();
            //r is model
            RatingModel r = new RatingModel();
            r.cid = giverID;
            r.wid=receiverID;
            r.rating=workerRating;
            boolean updated =false;
            Rating ratingObj = new Rating(r);//convert model to class
            updated = ratingObj.checkRating(workerRating); //update in class

            if(updated){
                //get updated model and store in db
                r = ratingObj.getRatingModel(); //get model
                //store in db

               // if(rateDbService.store_rating(giverID,receiverID,workerRating))
                //{
                    return true;
                //}
                //else
                    //throw new Exception("You already have given rating\n");
            }
            else
                throw new Exception("Invalid Rating");

        }
        else
            throw new Exception("One of the user doesn't exist. Please try again\n");
    }
}
