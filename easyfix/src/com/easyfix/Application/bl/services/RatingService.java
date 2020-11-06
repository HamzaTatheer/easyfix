package com.easyfix.Application.bl.services;
import com.easyfix.Application.models.RatingModel;
import java.util.ArrayList;

public interface RatingService {
    public Boolean giveRating(int giverID,int receiverID,int workerRating)throws Exception;
}