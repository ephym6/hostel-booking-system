package com.hostel.repository;

import com.hostel.model.Student;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends Repository<Student, Long> {
    // Add custom query methods if needed
    Student findByEmail(String email);
}
