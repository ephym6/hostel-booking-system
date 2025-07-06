package com.hostel.repository;

import com.hostel.model.Notification;
import com.hostel.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStudentAndSeenFalse(Student student);
}
