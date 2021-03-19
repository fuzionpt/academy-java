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
    private UserRepository userRepository;

    /**
     * Method for add users
     * Calls getUserById to check if user with given id exists first
     * Then encodes the password of the new user
     *
     * @param user
     * @return
     */
    public User addUser(User user) {

        if (!checkIfUserWithGivenUsernameExists(user.getUserName()) && checkIfPasswordIsValid(user.getPwd())) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String encodedPassword = encoder.encode(user.getPwd());

                user.setPwd(encodedPassword);
                user.setUpdateTimeStamp(LocalDateTime.now());
                return userRepository.save(user);

        } else {
            throw new RuntimeException("The user with username " + user.getUserName() + " already exists. Please choose another username");
        }

    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public String deleteUserById(Long id) {

        getUserById(id);

        userRepository.deleteById(id);
        return "User with id " + id + " has been removed";

    }

    public User updateUser(User user) {
        User existingUser = getUserById(user.getId());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPwd());

        existingUser.setName(user.getName());
        existingUser.setUserName(user.getUserName());
        user.setPwd(encodedPassword);
        user.setUpdateTimeStamp(LocalDateTime.now());


        return userRepository.save(existingUser);
    }


    /**
     * Method to check if user with given ID exists
     * If not, throws exception saying that user with certain id is not found
     *
     * @param id
     * @return
     */
    public User getUserById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User with id: " + id + " not found");
        }
        return user;
    }


    /**
     * Method to check if user with given username exists on the repository
     * S     * @return
     */
    public boolean checkIfUserWithGivenUsernameExists(String userName) {
        List<User> users = userRepository.findAll();

        boolean userNameExists = false;

        for (User user : users) {
            if (user.hasUserName(userName)) {
                userNameExists = true;

            }
        }
        return userNameExists;
    }


    /**
     * Method to check if password has length superior to 5
     * Calls method checkIfPasswordIsValid2 to check if password contains one capital letter, one lower letter and at least one number
     * @param password
     * @return
     */
    public boolean checkIfPasswordIsValid(String password) {
        if (password.length() > 5) {
            if(checkIfPasswordIsValid2(password)) {
                return true;
            } else {
                return false;
            }

        } else {

        }
        throw new IllegalArgumentException("Your password is too small!");
    }



    public boolean checkIfPasswordIsValid2(String password) {

        boolean hasNum = false;
        boolean hasCapLetter = false;
        boolean hasLowLetter = false;
        char c;

        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (Character.isDigit(c)) {

                hasNum = true;
            } else if (Character.isUpperCase(c)){
                hasCapLetter = true;

            } else if (Character.isLowerCase(c)){
                hasLowLetter = true;
            }

            } if (hasNum && hasCapLetter && hasLowLetter) {
            return true;
        }

        throw new IllegalArgumentException("Please make sure your password contains at least one capital letter, one lower letter and one number ");
    }

}
