package com.hostel.repository;

import com.hostel.model.Notification;
import com.hostel.model.Student;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface NotificationRepository extends Repository<Notification, Long> {
    List<Notification> findByStudentAndSeenFalse(Student student);
}
