package com.hostel.controller;

import com.hostel.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    //Admin actions (approve/reject bookings, manage rooms)

    @Autowired
    private AdminService adminService;

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return adminService.getAllBookings();
    }

    @PostMapping("/approve/{bookingId}")
    public ResponseEntity<String> approve(@PathVariable Long bookingId) {
        adminService.approveBooking(bookingId);
        return ResponseEntity.ok("Booking approved");
    }

    @PostMapping("/reject/{bookingId}")
    public ResponseEntity<String> reject(@PathVariable Long bookingId) {
        adminService.rejectBooking(bookingId);
        return ResponseEntity.ok("Booking rejected");
    }

}