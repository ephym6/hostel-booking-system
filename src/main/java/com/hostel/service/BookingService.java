package com.hostel.service;

import com.hostel.model.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Long studentId, Long roomId);
    List<Booking> getBookingsByStudentId(Long studentId);
}
