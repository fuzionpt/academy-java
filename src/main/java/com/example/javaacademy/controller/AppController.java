package com.example.javaacademy.controller;

import com.example.javaacademy.entity.User;
import com.example.javaacademy.repository.UserRepository;
import com.example.javaacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;


@Controller
public class AppController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;


    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    /**
     * Metodo para reencaminhar para a pagina de registrar
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    /**
     * Metodo para registar novo utilizador
     * @param user
     * @return
     */
    @PostMapping("/process_register")
    public String addUser(User user) {
        userService.addUser(user);
        return "register_success";

    }

    /**
     * Metodo para listar todos os utilizadores apos estar logado
     * @param model
     * @return
     */
    @GetMapping("/list_users")
    public String listAllUsers(Model model) {
        userService.getUsers(model);
        return "users";

    }

}

/**
 @GetMapping("/updateAtribute")
 public String updateUserAtribute (@RequestParam User user, HttpServletRequest request){
 request.setAttribute("task", service.updateUser(user));
 }

}

    /**
    @GetMapping("/updateAtribute")
    public String updateUserAtribute (@RequestParam User user, HttpServletRequest request){
        request.setAttribute("task", service.updateUser(user));
    }
    **/



