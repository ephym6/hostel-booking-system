package com.hostel.service;

import java.util.List;

public interface NotificationService {
    List<Notification> getUnseenNotifications(Long studentId);
}
