package com.example.javaacademy.repository;

import com.example.javaacademy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User  u WHERE u.userName = ?1 ")
    User findByUserName (String userName);

    @Query ("SELECT u FROM User u where u.userName= ?1")
    Boolean findByUserName2 (String userName);
}
