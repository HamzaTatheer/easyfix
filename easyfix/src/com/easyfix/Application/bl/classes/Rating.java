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

    public RatingModel get_RatingModel(){
        RatingModel temp=new RatingModel();
        temp.cid=cid;
        temp.rating=rating;
        temp.wid=wid;
        return temp;
    }
}
