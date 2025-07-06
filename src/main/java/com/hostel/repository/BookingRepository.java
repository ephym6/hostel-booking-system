package com.hostel.repository;

import com.hostel.model.Booking;
import com.hostel.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByStudent(Student student);
}
