package com.hostel.controller;

import com.hostel.model.Booking;
import com.hostel.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    //Student actions (register, login, book room, view status)

    private final BookingService bookingService;

    public StudentController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book/{studentId}/{roomId}")
    public ResponseEntity<?> bookRoom(@PathVariable Long studentId, @PathVariable Long roomId) {
        Booking booking = bookingService.createBooking(studentId, roomId);
        return ResponseEntity.ok("Booking submitted: ID " + booking.getId());
    }

    @GetMapping("/{studentId}/bookings")
    public ResponseEntity<?> getStudentBookings(@PathVariable Long studentId) {
        List<Booking> bookings = bookingService.getBookingsByStudentId(studentId);
        return ResponseEntity.ok(bookings);
    }

}