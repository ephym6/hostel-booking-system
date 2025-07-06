package com.hostel.repository;

import com.hostel.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}
