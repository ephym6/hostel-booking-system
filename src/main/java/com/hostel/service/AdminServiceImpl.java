package com.hostel.service;

import com.hostel.model.Booking;
import com.hostel.repository.BookingRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final BookingRepository bookingRepo;

    public AdminServiceImpl(BookingRepository bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public void approveBooking(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with ID: " + bookingId));
        booking.setStatus("CONFIRMED");
        bookingRepo.save(booking);
    }

    @Override
    public void rejectBooking(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with ID: " + bookingId));
        booking.setStatus("REJECTED");
        bookingRepo.save(booking);
    }
}
