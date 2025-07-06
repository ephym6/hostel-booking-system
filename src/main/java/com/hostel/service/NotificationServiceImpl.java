package com.hostel.service;

import com.hostel.model.Notification;
import com.hostel.model.Student;
import com.hostel.repository.NotificationRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepo;
    @Autowired
    private StudentRepository studentRepo;

    @Override
    public List<Notification> getUnseenNotifications(Long studentId) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        return notificationRepo.findByStudentAndSeenFalse(student);
    }

}
