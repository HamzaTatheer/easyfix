package com.easyfix.Application.bl.services;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.SparePartModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
public interface BookingService {
    public Boolean addBooking(int _cid, int _wid, String _text, String _status, LocalDateTime _startTime, LocalDateTime _endTime,ArrayList<Integer>_sparePart);
    public Boolean acceptBooking(int _bid);
    public Boolean rejectBooking(int _bid);
    public Boolean finishBooking(int _bid);
    public void showActiveBookingOfCustomer(int cid);
    public void showFinishedBookingOfCustomer(int uid);
    public void showActiveBookingOfWorker(int cid);
}
