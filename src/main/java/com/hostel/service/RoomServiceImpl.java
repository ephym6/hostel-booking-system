package com.hostel.service;

import com.hostel.model.Room;
import com.hostel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepo;

    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public List<Room> getAvailableRooms() {
        return roomRepo.findByAvailableTrue();
    }
}
