package com.hostel.security;

import com.hostel.model.Student;
import com.hostel.repository.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsService implements UserDetailsService {

    private final StudentRepository studentRepo;

    public StudentDetailsService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepo.findByEmail(email);
        if (student == null) {
            throw new UsernameNotFoundException("Student not found");
        }
        return new CustomStudentDetails(student);
    }
}
