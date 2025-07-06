package com.hostel.repository;

import com.hostel.model.Room;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RoomRepository extends Repository<Room, Long> {
    List<Room> findByAvailableTrue();
    List<Room> findByGender(String gender);
}
