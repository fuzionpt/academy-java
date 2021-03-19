package com.example.javaacademy.service;

import com.example.javaacademy.entity.User;
import com.example.javaacademy.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void checkIfUserWithGivenUserNameExistsTest() {


        boolean result = userService.checkIfUserWithGivenUsernameExists("rodrig");

        assertTrue(result);


    }

    @Test
    public void checkIfUserWithGivenUserNameExistsTest2 (){

        boolean result = userService.checkIfUserWithGivenUsernameExists("rafael");

        assertFalse(result);

    }

}
