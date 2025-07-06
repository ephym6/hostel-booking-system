package com.hostel.service;

import com.hostel.model.Booking;

import java.util.List;

public interface AdminService {
    List<Booking> getAllBookings();
    void approveBooking(Long bookingId);
    void rejectBooking(Long bookingId);
}
