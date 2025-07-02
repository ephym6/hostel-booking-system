package com.hostel.service;

import com.hostel.model.Room;
import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    List<Room> getAvailableRooms();
}
