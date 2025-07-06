package com.hostel.service;

import com.hostel.model.Room;
import com.hostel.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepo;

    public RoomServiceImpl(RoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public List<Room> getAvailableRooms() {
        return roomRepo.findByAvailableTrue();
    }
}
