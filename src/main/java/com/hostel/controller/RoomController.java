package com.hostel.controller;

import com.hostel.model.Room;
import com.hostel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Get all rooms
    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
    /*
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }
     */

    // Get only available rooms
    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }
    /*
    public ResponseEntity<List<Room>> getAvailableRooms() {
        List<Room> availableRooms = roomService.getAvailableRooms();
        return ResponseEntity.ok(availableRooms);
    }
     */
}
