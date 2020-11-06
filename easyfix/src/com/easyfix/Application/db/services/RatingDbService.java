package com.easyfix.Application.db.services;

import com.easyfix.Application.bl.services.RatingService;

public interface RatingDbService{
        public boolean store_rating(int customer_id,int worker_id,int rating);
        public float get_avg_rating(int worker_id);
}
