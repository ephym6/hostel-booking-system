package com.hostel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hostel.dto.LoginDTO;
import com.hostel.model.Admin;
import com.hostel.model.Student;
import com.hostel.service.AuthService;

@Controller
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Optional: Login page (if using custom login view)
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }


    // ============================================
    // ============= FORM-BASED FLOW =============
    // ============================================

    // Registration form GET
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    // Registration form POST
    @PostMapping("/register")
    public String registerStudentForm(@ModelAttribute Student student, Model model) {
        String result = authService.registerStudent(student);
        if (result.toLowerCase().contains("exists")) {
            model.addAttribute("error", result);
            return "register";
        }
        return "redirect:/login?success";
    }

    // Login page handled by Spring Security (formLogin) → no need for manual login controller.

    // ============================================
    // ============== API/JSON FLOW ===============
    // ============================================
    @RestController
    @RequestMapping("/api/auth")  // Fixed typo from "/api/auto"
    public static class AuthRestController {

        private final AuthService authService;

        @Autowired
        public AuthRestController(AuthService authService) {
            this.authService = authService;
        }

        @PostMapping("/register")
        public ResponseEntity<String> registerStudent(@RequestBody Student student) {
            System.out.println("Received student: " + student.getEmail());
            return  ResponseEntity.ok(authService.registerStudent(student));  // Fixed method name
        }

        @PostMapping("/login")
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
}

  




    
    
   