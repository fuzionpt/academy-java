package com.example.javaacademy.service;

import com.example.javaacademy.entity.User;
import com.example.javaacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User addUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public String removeUserById(Long id) {
        repository.deleteById(id);
        return "User with " + id + "has been removed";
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setUserName(user.getUserName());
        existingUser.setPwd(user.getPwd());

        return repository.save(existingUser);
    }


}
