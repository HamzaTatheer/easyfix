package com.easyfix.Application.bl.services;

public interface BookingService {
    public Boolean createBooking();

    public Boolean showBookings(int id, String status);

    public Boolean acceptBooking(int bid);
    public Boolean rejectBooking(int bid);

}
