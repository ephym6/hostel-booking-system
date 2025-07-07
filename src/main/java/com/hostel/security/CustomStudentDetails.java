package com.hostel.security;

import com.hostel.model.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

public class CustomStudentDetails implements UserDetails {
    private final Student student;

    public CustomStudentDetails(Student student) {
        this.student = student;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // or add roles later eg List.of(new SimpleGrantedAuthority("ROLE_STUDENT"))
    }

    @Override
    public String getUsername() {
        return student.getEmail();
    }

    @Override
    public String getPassword() {
        return student.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Student getStudent() {
        return student;
    }
}
