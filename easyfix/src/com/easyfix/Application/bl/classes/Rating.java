package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.RatingModel;

public class Rating {
    public int cid;
    public int wid;
    public int rating;
    //constructors
    Rating(){

    }
    Rating(int _cid,int _wid,int _rating){
        cid=_cid;
        wid=_wid;
        rating=_rating;
    }
    Rating(RatingModel R){
        cid=R.cid;
        wid=R.wid;
        rating=R.rating;
    }
    //setters


    //getters


    public int getCid() {
        return cid;
    }

    public int getRating() {
        return rating;
    }

    public int getWid() {
        return wid;
    }

    public Rating getRating(RatingModel R){ //convert model to class
        Rating temp=new Rating();
        temp.cid=R.cid;
        temp.rating=R.rating;
        temp.wid=R.wid;
        return temp;
    }
    public RatingModel getRatingModel(Rating R){ //convert class to model
        RatingModel temp=new RatingModel();
        temp.cid=R.cid;
        temp.rating=R.rating;
        temp.wid=R.wid;
        return temp;
    }
}
