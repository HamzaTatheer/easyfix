package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.classes.Rating;
import com.easyfix.Application.bl.classes.Worker;
import com.easyfix.Application.bl.services.RatingService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.RatingModel;
import com.easyfix.Application.utils.Arrayfuncs;

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

            boolean hasAlreadyGivenRating = false;

            ArrayList<RatingModel> ratings = dbService.getAllRatings(giverID);
            for (int i=0;i<ratings.size();i++){
                if(ratings.get(i).wid == receiverID)
                    hasAlreadyGivenRating = true;
            }

            if(hasAlreadyGivenRating)
                throw new Exception("You have already given rating to this worker");

            ArrayList<BookingModel> b = dbService.get_booking_of_customer(giverID,"finished");

            if(b ==null || b.size()<=0){
                throw new Exception("Customer needs to have at least one booking with worker before giving rating");
            }

            boolean bookedWith = false;
            for (int i=0;i<b.size();i++){
                if(b.get(i).wid == receiverID)
                    bookedWith = true;
            }

            if(bookedWith==false){
                throw new Exception("You need to book atleast one appointment with this worker");
            }

            if(Worker.isRatingCorrect(workerRating)){
                dbService.store_rating(giverID,receiverID,workerRating);
                float newRating = dbService.get_avg_rating(receiverID);
                dbService.update_average_rating(receiverID,newRating);
            }
            else{
                throw new Exception("Rating is Incorrect. Please give rating between 0-5");
            }
        }


        return true;
    }
}