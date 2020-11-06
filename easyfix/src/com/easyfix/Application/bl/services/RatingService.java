package com.easyfix.Application.bl.services;
import com.easyfix.Application.models.RatingModel;
import java.util.ArrayList;

public interface RatingService {
    public ArrayList<RatingModel> showAllRatings(int id);
    public Boolean giveRating(int giverID,int receiverID,int workerRating);
}