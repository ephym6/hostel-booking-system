package com.hostel.service;

import com.hostel.model.Admin;
import com.hostel.model.Student;
import com.hostel.repository.AdminRepository;
import com.hostel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
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
    }
}
