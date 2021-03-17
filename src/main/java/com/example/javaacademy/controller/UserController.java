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
    private UserService service;

    @PostMapping
    public User addUser (@RequestBody User user){
        return service.addUser(user);

    }

    @GetMapping
    public List<User> getUsers () {
        return service.getUsers();
    }


    @DeleteMapping("{id}")
    public String removeUserById (@PathVariable Long id) {
        return service.deleteUserById(id);

    }

    @PutMapping
    public User updateUser (@RequestBody User user ){
        return service.updateUser(user);
    }

}
