package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.classes.Rating;
import com.easyfix.Application.bl.classes.Worker;
import com.easyfix.Application.bl.services.RatingService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.RatingModel;

import java.util.ArrayList;

public class RatingManager implements RatingService {
    public Boolean giveRating(int giverID, int receiverID, int workerRating) throws Exception {

        DbService dbService = dbProviders.getDbService();
        boolean exists = true;

        if(dbService.does_customer_exist(giverID)){
            if(dbService.does_worker_exist(receiverID)){
                exists = true;
            }
        }

        if(exists = true){
            ArrayList<BookingModel> b = dbService.get_booking_of_customer(giverID,"finished");

            if(b ==null || b.size()<=0){
                throw new Exception("Customer needs to have at least one booking with worker before giving rating");
            }

            if(Worker.isRatingCorrect(workerRating)){
                dbService.store_rating(giverID,receiverID,workerRating);
            }
            else{
                throw new Exception("Rating is Incorrect. Please give rating between 0-5");
            }
        }


        return true;
    }
}