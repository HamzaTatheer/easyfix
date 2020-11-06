package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.services.RatingService;
import com.easyfix.Application.models.RatingModel;

import java.util.ArrayList;

public class RatingManager implements RatingService {
    public ArrayList<RatingModel> showAllRatings(int id){
        return new ArrayList<RatingModel>();
    }
    public void giveRating(int giverID,int receiverID,int workerRating){
        System.out.println("giveRating to be completed");
    }

}
