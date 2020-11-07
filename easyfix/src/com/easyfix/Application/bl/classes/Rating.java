package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.RatingModel;

public class Rating {
    private int cid;
    private int wid;
    private int rating;
    //constructors
    Rating(RatingModel R){
        cid=R.cid;
        wid=R.wid;
        rating=R.rating;
    }
    //member functions
    public RatingModel getRatingModel(){
        RatingModel temp=new RatingModel();
        temp.cid=cid;
        temp.rating=rating;
        temp.wid=wid;
        return temp;
    }
    public Boolean checkRating(int _rating){
        if(_rating>=0 && _rating<=5){
            return true;
        }
        else
            return false;

    }
    //getters
    public int getCid() {
        return cid;
    }

    public int getWid() {
        return wid;
    }

    public int getRating() {
        return rating;
    }
    //setters
    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
