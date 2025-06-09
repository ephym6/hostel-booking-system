package com.hostel.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student extends User {

    private String gender;

    // Student can have many bookings
    @OneToMany
    private List<Booking> bookings;

    //constructor
    public Student(int id, String name, String email, String password, String gender) {
        super(id, name, email, password);
        this.gender = gender;
    }

    // Getters and Setters
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}



}

