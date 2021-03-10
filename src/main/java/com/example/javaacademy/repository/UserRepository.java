package com.example.javaacademy.repository;

import com.example.javaacademy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
