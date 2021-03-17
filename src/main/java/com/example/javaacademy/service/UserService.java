package com.example.javaacademy.service;

import com.example.javaacademy.entity.User;
import com.example.javaacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User addUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPwd());
        user.setPwd(encodedPassword);
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public String deleteUserById(Long id) {
        repository.deleteById(id);
        return "User with id " + id + " has been removed";
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setUserName(user.getUserName());
        existingUser.setPwd(user.getPwd());
        //existingUser.setUpdatedDate(LocalDateTime.now());

        return repository.save(existingUser);
    }

//    public User updateUserByUserName (String userName) {
//        User newUser = repository.findByUserName(userName);
//        newUser.setUserName(newUser.getUserName());
//        newUser.setPwd(newUser.getPwd());
//        newUser.setName(newUser.getName());
//
//        return repository.save(newUser);
//    }

    public User getUserById (Long id){
        Optional<User> optional = repository.findById(id);
        User user = null;
        if(optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User with id: " + id + " not found");
        }
        return user;
    }


}
