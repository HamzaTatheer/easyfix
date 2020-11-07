package com.easyfix.Application.db.sqlDb;

public class RatingSqlManager implements RatingDbService {
    public boolean store_rating(int customer_id,int worker_id,int rating){
        return true;
    }
    public float get_avg_rating(int worker_id){
        return 2.5f;
    }
}
