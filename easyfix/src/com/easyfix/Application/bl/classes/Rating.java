package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.RatingModel;

public class Rating {
    public int cid;
    public int wid;
    public int rating;
    //constructors
    Rating(RatingModel R){
        cid=R.cid;
        wid=R.wid;
        rating=R.rating;
    }
    //getters
    public RatingModel getRatingModel(){
        RatingModel temp=new RatingModel();
        temp.cid=cid;
        temp.rating=rating;
        temp.wid=wid;
        return temp;
    }
    //setters


}
