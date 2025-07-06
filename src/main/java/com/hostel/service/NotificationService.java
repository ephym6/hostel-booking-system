package com.hostel.service;

import com.hostel.model.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> getUnseenNotifications(Long studentId);
}