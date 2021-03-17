package com.example.javaacademy.controller;

import com.example.javaacademy.entity.User;
import com.example.javaacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller versão original para testar no postman
 */


@RestController
@RequestMapping(("/users"))
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser (@RequestBody User user){
        return userService.addUser(user);

    }

    @GetMapping
    public List<User> getUsers () {
        return userService.getUsers();
    }


    @PutMapping
    public User updateUser (@RequestBody User user ){
        return userService.updateUser(user);
    }

    @DeleteMapping("{id}")
    public String deleteUserById (@PathVariable Long id) {
        return userService.deleteUserById(id);

    }

}
