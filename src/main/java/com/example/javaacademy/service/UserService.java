package com.example.javaacademy.service;

import com.example.javaacademy.entity.User;
import com.example.javaacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    /**
     * Method for add users
     * Calls getUserById to check if user with given id exists first
     * Then encodes the password of the new user
     * @param user
     * @return
     */
    public User addUser(User user) {

        List<User> users = getUsers();

        if (!users.contains(user.getUserName())){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPwd());

            user.setPwd(encodedPassword);
            user.setUpdateTimeStamp(LocalDateTime.now());
            return repository.save(user);


        } else {
            throw new RuntimeException("The user with username " + user.getUserName() + " already exists. Please choose another username");
        }

    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public String deleteUserById(Long id) {

        getUserById(id);

        repository.deleteById(id);
        return "User with id " + id + " has been removed";
    }

    public User updateUser(User user) {
        User existingUser = getUserById(user.getId());

        existingUser.setName(user.getName());
        existingUser.setUserName(user.getUserName());
        existingUser.setPwd(user.getPwd());
        existingUser.setUpdateTimeStamp(LocalDateTime.now());

        return repository.save(existingUser);
    }


    /**
     * Method to check if user with given ID exists
     * If not, throws exception saying that user with certain id is not found
     * @param id
     * @return
     */
    public User getUserById(Long id) {
        Optional<User> optional = repository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User with id: " + id + " not found");
        }
        return user;
    }


}
