package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.Booking;
import com.easyfix.Application.bl.classes.Customer;
import com.easyfix.Application.bl.classes.SparePart;
import com.easyfix.Application.bl.classes.Worker;
import com.easyfix.Application.bl.services.BookingService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.BookingModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class BookingManager implements BookingService {
    public Boolean makeBooking(int _cid, int _wid, String _text, LocalDateTime _startTime,ArrayList<Integer>_sparePart) throws Exception {
        DbService db = dbProviders.getDbService();
        //get all bookings of the required worker (a)
        ArrayList<BookingModel> workerBookingsModel = db.get_booking_of_worker(_wid);
        //Convert bookingModel to booking
        ArrayList<Booking> workerBookings = new ArrayList<Booking>();
        for (BookingModel workerBookingModel : workerBookingsModel) {
            BookingModel temp = workerBookingModel;
            Customer c = new Customer(db.get_customer(temp.cid));
            Worker w = new Worker(db.get_worker(temp.wid));
            workerBookings.add(new Booking(temp.id,temp.text,temp.status,temp.startTime,temp.endTime,new ArrayList<SparePart>(),c,w));
        }
        //create booking of current user
        Customer c = new Customer(db.get_customer(_cid));
        Worker w = new Worker(db.get_worker(_wid));
        Booking mybooking = new Booking(-1,_text,"pending",_startTime,_startTime,new ArrayList<SparePart>(),c,w);

        System.out.println(mybooking.toString());
        workerBookings.forEach((ww)->System.out.println(ww.toString()));
        //check if Booking Time of our user matched any booking time other user
        boolean sameTime = false;
        for(int i =0;i<workerBookings.size();i++){
            if(workerBookings.get(i).hasSameStartTime(mybooking))
                sameTime = true;
        }

        if(sameTime == true){
            throw new Exception("Worker is already booked in the same Time");
        }
        else{
            throw new Exception("Booking can booked but for now. Not storing in db. test without it");
        }
        //if it does return false
        //if it does not create booking
    }

    public Boolean acceptBooking(int _bid){
        return false;
    }
    public Boolean rejectBooking(int _bid){
        return false;
    }

    public Boolean activateBookingTime(int bid){
        return false;
    }
    public Boolean finishBookingTime(int bid){
        return false;
    }
    public ArrayList<BookingModel> showPendingBookingsOfCustomer(int cid){
        return new ArrayList<>();
    }
    public ArrayList<BookingModel> showFinishedBookingOfCustomer(int uid){
        return new ArrayList<>();
    }
    public ArrayList<BookingModel> showActiveBookingOfWorker(int cid){
        return new ArrayList<>();
    }
}