package ru.tim.pizzApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tim.pizzApp.service.FoodService;
import ru.tim.pizzApp.service.UserService;

@Controller
public class AdminController {

    @Autowired
    public FoodService foodService;
    @Autowired
    public UserService userService;

    @GetMapping("/admin/")
    public String getAdminPage(){
        return "admin/adminPage";
    }

    @GetMapping("/admin/usersList")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "admin/usersList";
    }

}
