package com.hostel.service;

import com.hostel.model.Admin;
import com.hostel.model.Student;

import com.hostel.repository.AdminRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.hostel.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {


    private final StudentRepository studentRepo;

    private final AdminRepository adminRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(StudentRepository studentRepo, AdminRepository adminRepo) {
        this.studentRepo = studentRepo;
        this.adminRepo = adminRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String registerStudent(Student student) {
        if (studentRepo.findByEmail(student.getEmail()) != null) {
            return "Email already exists. Please try a different email.";
        }
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepo.save(student);
        return "Student registered successfully";
    }

    @Override
    public String loginStudent(Student student) {
        Student found = studentRepo.findByEmail(student.getEmail());
        if (found != null && passwordEncoder.matches(student.getPassword(), found.getPassword()/*.equals(student.getPassword())*/)) {
            return "Login successful";
        }
        //return "Invalid credentials";
        throw new SecurityException("Invalid credentials for student login.");
    }

    @Override
    public String registerAdmin(Admin admin) {
        if (adminRepo.findByEmail(admin.getEmail()) != null) {
            return "Email already exists. Please try a different email.";
        }
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepo.save(admin);
        return "Admin registered successfully";
    }

    @Override
    public String loginAdmin(Admin admin) {
        Admin found = adminRepo.findByEmail(admin.getEmail());
        if (found != null && passwordEncoder.matches(admin.getPassword(), found.getPassword())) {
            return "Login successful";
        }
        //return "Invalid credentials";
        throw new SecurityException("Invalid credentials for admin login.");
    }

    /*
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
     */
}



