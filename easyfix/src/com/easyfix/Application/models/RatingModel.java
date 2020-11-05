package com.easyfix.Application.models;

public class RatingModel {
    public int cid;
    public int wid;
    public int rating;
    //getters
    public RatingModel get_RatingModel(){
        RatingModel temp=new RatingModel();
        temp.cid=cid;
        temp.rating=rating;
        temp.wid=wid;
        return temp;
    }

}
