package com.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hostel.dto.LoginDTO;
import com.hostel.model.Admin;
import com.hostel.model.Student;
import com.hostel.service.AuthService;

@RestController
@RequestMapping("/api/auth")  // Fixed typo from "/api/auto"
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/student/register")
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        return  ResponseEntity.ok(authService.registerStudent(student));  // Fixed method name
    }

    @PostMapping("/student/login")
    public ResponseEntity<String> loginStudent(@RequestBody Student student) {
        return ResponseEntity.ok(authService.loginStudent(student));  // Fixed method name and return type
    }

    @PostMapping("/admin/register")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(authService.registerAdmin(admin));  // Fixed method name
    }

    @PostMapping("/admin/login")
    public ResponseEntity<String> loginAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(authService.loginAdmin(admin));  // Fixed method name and return type
    }
}

  




    
    
   