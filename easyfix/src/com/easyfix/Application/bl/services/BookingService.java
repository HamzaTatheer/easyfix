package com.easyfix.Application.bl.services;
import com.easyfix.Application.models.BookingModel;
import com.easyfix.Application.models.SparePartModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
public interface BookingService {
    public Boolean addBooking(int _cid, int _wid, String _text, String _status, LocalDateTime _startTime, LocalDateTime _endTime,ArrayList<Integer>_sparePart);
    public ArrayList<BookingModel> showAllBookings(int _id, String _status);
    public Boolean acceptBooking(int _bid);
    public Boolean rejectBooking(int _bid);
    public Boolean addSpartPartInBooking(int _bid,String _name,int _quantity );
    public Boolean changeBookingStatus(int _bid,String _status);
    public Boolean addSparePart(String _name,float _cost,int _quantity);
    public ArrayList<SparePartModel> showAllSpareParts();

}
