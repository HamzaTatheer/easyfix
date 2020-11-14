package com.easyfix.Application.bl.services;
import com.easyfix.Application.bl.managers.BillingManager;
import com.easyfix.Application.bl.managers.BookingManager;
import com.easyfix.Application.bl.managers.CustomerManager;
import com.easyfix.Application.models.BillingModel;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.SparePartModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
public interface BookingService {
    public Boolean acceptBooking(int _bid);
    public Boolean rejectBooking(int _bid);
    public Boolean makeBooking(int _cid, int _wid, String _text, LocalDateTime _startTime,ArrayList<Integer>_sparePart) throws Exception;
    public Boolean finishBooking(int bid);
    public boolean payForBooking(int cid,int bid) throws Exception;
    public ArrayList<BookingModel> showPendingBookingsOfCustomer(int cid);
    public ArrayList<BookingModel> showFinishedBookingOfCustomer(int uid);
    public ArrayList<BookingModel> showActiveBookingOfWorker(int cid);
}












