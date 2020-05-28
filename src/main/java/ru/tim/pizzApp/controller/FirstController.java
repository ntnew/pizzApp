package ru.tim.pizzApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tim.pizzApp.service.UserService;

@Controller
public class FirstController {

    @Autowired
    public UserService userService;

    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }

    @GetMapping("/main")
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
}
