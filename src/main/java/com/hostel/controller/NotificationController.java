package com.hostel.controller;

import com.hostel.model.Notification;
import com.hostel.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/unseen/{studentId}")
    public ResponseEntity<?> getUnseen(@PathVariable Long studentId) {
        List<Notification> unseen = notificationService.getUnseenNotifications(studentId);
        return ResponseEntity.ok(unseen);
    }
}
