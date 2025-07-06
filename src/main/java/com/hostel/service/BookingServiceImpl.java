package com.hostel.service;

import com.hostel.model.Booking;
import com.hostel.model.Room;
import com.hostel.model.Student;
import com.hostel.repository.BookingRepository;
import com.hostel.repository.RoomRepository;
import com.hostel.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final StudentRepository studentRepo;
    private final RoomRepository roomRepo;

    public BookingServiceImpl(BookingRepository bookingRepo, StudentRepository studentRepo, RoomRepository roomRepo) {
        this.bookingRepo = bookingRepo;
        this.studentRepo = studentRepo;
        this.roomRepo = roomRepo;
    }

    @Override
    public Booking createBooking(Long studentId, Long roomId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));
        Room room = roomRepo.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found with ID: " + roomId));
        Booking booking = new Booking();
        booking.setStudent(student);
        booking.setRoom(room);
        booking.setStatus("PENDING");
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getBookingsByStudentId(Long studentId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));
        return bookingRepo.findByStudent(student);
    }
}
