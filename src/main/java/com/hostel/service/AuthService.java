package com.hostel.service;

import com.hostel.model.Admin;
import com.hostel.model.Student;
import com.hostel.dto.LoginDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> registerStudent(Student student);
    ResponseEntity<?> loginStudent(LoginDTO dto);
    ResponseEntity<?> registerAdmin(Admin admin);
    ResponseEntity<?> loginAdmin(LoginDTO dto);
}

    /*
    The AuthService handles the business logic for:

Validating login credentials

Registering users (Student/Admin)

Encrypting passwords (optional)

Returning response messages or tokens (if used)
     */

