package com.hostel.service;

import com.hostel.model.Booking;
import com.hostel.model.Room;
import com.hostel.model.Student;
import com.hostel.repository.BookingRepository;
import com.hostel.repository.RoomRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Override
    public Booking createBooking(Long studentId, Long roomId) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        Room room = roomRepo.findById(roomId).orElseThrow();
        Booking booking = new Booking();
        booking.setStudent(student);
        booking.setRoom(room);
        booking.setStatus("PENDING");
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getBookingsByStudent(Long studentId) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        return bookingRepo.findByStudent(student);
    }
}
