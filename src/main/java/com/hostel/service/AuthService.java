package com.hostel.service;

import com.hostel.model.Admin;
import com.hostel.model.Student;

public interface AuthService {
    String registerStudent(Student student);
    String loginStudent(Student student);
    String registerAdmin(Admin admin);
    String loginAdmin(Admin admin);
}

/*
    The AuthService handles the business logic for:

Validating login credentials

Registering users (Student/Admin)

Encrypting passwords (optional)

Returning response messages or tokens (if used)
     */
