package ru.tim.pizzApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.service.UserService;

@Controller
public class FirstController {

    @Autowired
    public UserService userService;

    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }

    @GetMapping("/")
    public String mainPage() {
        return "mainPage";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "regPage";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }
    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
