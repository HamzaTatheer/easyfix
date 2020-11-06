package com.easyfix.Application.bl.managers;

import com.easyfix.Application.models.BookingModel;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingManager {
    public Boolean addBooking(int _cid, int _wid, String _text, String _status, LocalDateTime _startTime, LocalDateTime _endTime, ArrayList<Integer> _sparePart){
        return true;
    }

    public ArrayList<BookingModel> showAllBookings(int _id, String _status){
        return new ArrayList<BookingModel>();
    }
    public Boolean changeBookingStatus(int _bid,String _status){

        return true;
    }




    public boolean createBooking(BookingModel b){
        return true;
    }

    public boolean showActiveBookingOfCustomer(int cid){
        return true;
    }

    public boolean showFinishedBookingOfCustomer(int uid){
        return true;
    }
    
    public boolean showActiveBookingOfWorker(int cid){
        return true;
    }
}
