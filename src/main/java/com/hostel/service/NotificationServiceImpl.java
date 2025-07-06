package com.hostel.service;

import com.hostel.model.Notification;
import com.hostel.model.Student;
import com.hostel.repository.NotificationRepository;
import com.hostel.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepo;

    private final StudentRepository studentRepo;

    public NotificationServiceImpl(NotificationRepository notificationRepo, StudentRepository studentRepo) {
        this.notificationRepo = notificationRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Notification> getUnseenNotifications(Long studentId) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));
        return notificationRepo.findByStudentAndSeenFalse(student);
    }

}
