
package com.hostel.service;

import com.hostel.model.Admin;
import com.hostel.model.Student;

import com.hostel.repository.AdminRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.hostel.dto.LoginDTO;
import com.hostel.repository.AdminRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private AdminRepository adminRepo;

    @Override
    public String registerStudent(Student student) {
        studentRepo.save(student);
        return "Student registered successfully";
    }

    @Override
    public String loginStudent(Student student) {
        Student found = studentRepo.findByEmail(student.getEmail());
        if (found != null && found.getPassword().equals(student.getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    @Override
    public String registerAdmin(Admin admin) {
        adminRepo.save(admin);
        return "Admin registered successfully";
    }

    @Override
    public String loginAdmin(Admin admin) {
        Admin found = adminRepo.findByEmail(admin.getEmail());
        if (found != null && found.getPassword().equals(admin.getPassword())) {
            return "Login successful";
        }
        return "Invalid credentials";

    public ResponseEntity<?> registerStudent(Student student) {
        studentRepo.save(student);
        return ResponseEntity.ok("Student registered successfully.");
    }

    @Override
    public ResponseEntity<?> loginStudent(LoginDTO dto) {
        Student student = studentRepo.findByEmail(dto.getEmail());
        if (student != null && student.getPassword().equals(dto.getPassword())) {
            return ResponseEntity.ok("Login successful.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
    }

    @Override
    public ResponseEntity<?> registerAdmin(Admin admin) {
        adminRepo.save(admin);
        return ResponseEntity.ok("Admin registered successfully.");
    }

    @Override
    public ResponseEntity<?> loginAdmin(LoginDTO dto) {
        Admin admin = adminRepo.findByEmail(dto.getEmail());
        if (admin != null && admin.getPassword().equals(dto.getPassword())) {
            return ResponseEntity.ok("Login successful.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
    }
}



