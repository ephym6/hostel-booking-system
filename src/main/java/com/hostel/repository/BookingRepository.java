package com.hostel.repository;

import com.hostel.model.Booking;
import com.hostel.model.Student;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookingRepository extends Repository<Booking, Long> {
    List<Booking> findByStudent(Student student);
}
