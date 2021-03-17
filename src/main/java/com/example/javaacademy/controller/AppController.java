package com.example.javaacademy.controller;

import com.example.javaacademy.entity.User;
import com.example.javaacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Controller versão 2.0 -  para lidar com o bootstrap frontend
 */


@Controller
public class AppController {


    @Autowired
    private UserService userService;


    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    /**
     * Metodo para reencaminhar para a pagina de registrar
     *
     * @param model
     * @return
     */
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    /**
     * Metodo para registar novo utilizador no localhost
     *
     * @param user
     * @return
     * */
    @PostMapping("/process_register")
    public String addUser(User user) {
        userService.addUser(user);
        return "register_success";

    }

    @PutMapping("/user_update")
    public String updateUser (User user){
        userService.updateUser(user);
        return "update_message";
    }

    /**
     * Metodo para listar todos os utilizadores apos estar logado
     *
     * @param model
     * @return
     */
    @GetMapping("/list_users")
    public String listAllUsers(Model model) {
        model.addAttribute("listUsers", userService.getUsers());
        return "users";

    }

    @GetMapping("/showFormUpdate/{id}")
    public String showForForUpdate(@PathVariable(value = "id") Long id, Model model) {

        //get user from the service
        User user = userService.getUserById(id);
        userService.updateUser(user);

        //set user as a model attribute to pre populate the form
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable (value = "id") Long id) {
        userService.deleteUserById(id);
        return "register_success";
    }

}



