package com.hostel.controller;

import com.hostel.model.Booking;
import com.hostel.model.Student;
import com.hostel.security.CustomStudentDetails;
import com.hostel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Load form
    @GetMapping("/book-room")
    public String showBookingPage(@RequestParam("roomId") Long roomId, Model model) {
        model.addAttribute("roomId", roomId);
        return "book-room";
    }

    // Success page
    @GetMapping("/booking-success")
    public String bookingSuccess() {
        return "booking-success";
    }

    // Handle booking submission
    @PostMapping("/book-room")
    public String bookRoom(@RequestParam("roomId") Long roomId,
                           Authentication auth,
                           RedirectAttributes redirectAttributes) {
        // Retrieve the logged-in student
        CustomStudentDetails userDetails = (CustomStudentDetails) auth.getPrincipal();
        Student student = userDetails.getStudent();

        // ERROR HANDLING
        try {
            Booking booking = bookingService.createBooking(student.getId(), roomId);
            redirectAttributes.addFlashAttribute("message", "Room booked successfully with status: " + booking.getStatus());
            return "redirect:/booking-success";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Booking failed: " + e.getMessage());
            return "redirect:/book-room?roomId=" + roomId;
        }
    }
}