package com.easyfix.Application.db.textDb;

import com.easyfix.Application.db.services.RatingDbService;

public class RatingTextManager implements RatingDbService {
    public boolean store_rating(int customer_id,int worker_id,int rating){
        return true;
    }
    public float get_avg_rating(int worker_id){
        return 2.5f;
    }
}
