package com.hostel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Booking {
    //Attributes: id, timestamp, status, student, room
    //Composition: has Student and Room
    @Id //primary keys for each booking
    @GeneratedValue
    private Long id;
    private LocalDateTime timestamp;
    private String status; // PENDING, CONFIRMED, CANCELLED

    // Many bookings can be linked to one student
    @ManyToOne
    private Student student;

    // Many bookings can be linked to one room
    @ManyToOne
    private Room room;

    // Constructors with parameters
    public Booking(long id, LocalDateTime timestamp, String status) {
        this.id = id;
        this.timestamp = timestamp;
        this.status = status;
    }

    //Default constructor - for JPA
    public Booking() {
        this.timestamp = LocalDateTime.now(); //default timestamp
        this.status = "PENDING"; //default status
    }

    //Getters and Setters - for encapsulation
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
}
