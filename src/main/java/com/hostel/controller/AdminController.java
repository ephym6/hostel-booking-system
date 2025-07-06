package com.hostel.controller;

import com.hostel.model.Booking;
import com.hostel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    //Admin actions (approve/reject bookings, manage rooms)

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

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