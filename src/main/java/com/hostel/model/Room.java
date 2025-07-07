package com.hostel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import jakarta.persistence.Entity;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private String type;     // Room type: Single, Double, etc.
    private String gender;   // Gender-specific room: Male/Female
    private double price;    // Room price
    private boolean available = true; // Availability status

    // List of amenities like Wi-Fi, Fan, etc.
    @ElementCollection
    private List<String> amenities;

    // One room can have many bookings
    @OneToMany
    @JsonIgnore
    private List<Booking> bookings;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public List<String> getAmenities() {
        return amenities;
    }
    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}

