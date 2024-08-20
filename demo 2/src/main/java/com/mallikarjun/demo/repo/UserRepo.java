package com.mallikarjun.demo.repo;

import com.mallikarjun.demo.model.Student;
import com.mallikarjun.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
