package com.hostel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Notification {
    //Contains student notifications
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    private boolean seen;

    @ManyToOne
    private Student student;

    //Default constructor
    public Notification() {
    }

    //Parameterized constructor
    public Notification(Long id, String message, boolean seen) {
        this.id = id;
        this.message = message;
        this.seen = seen;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isSeen() {
        return seen;
    }
    public void setSeen(boolean seen) {
        this.seen = seen;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
}
