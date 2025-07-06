package com.hostel.service;

import com.hostel.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Long roomId, Long studentId);
    List<Booking> getBookingsByStudentId(Long studentId);
}
