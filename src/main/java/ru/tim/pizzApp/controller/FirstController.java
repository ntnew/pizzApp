package ru.tim.pizzApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tim.pizzApp.additional.UserMethods;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.service.UserService;
import ru.tim.pizzApp.validator.UserValidator;

import javax.validation.Valid;

@Controller
public class FirstController  {


    @Autowired
    public UserService userService;
    @Autowired
    private UserValidator userValidator;



    @GetMapping("/")
    public String mainPage() {
        User user = userService.getByLogin(UserMethods.getCurrentUsername());
        if(user.getRole().equals("ROLE_USER")){
            return "redirect:user/";
        }
        else if(user.getRole().equals("ROLE_ADMIN")){
            return  "redirect:admin/";
        }
        return null;
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/reg")
    public String regPage(User user) {
        return "regPage";
    }


    @PostMapping("/reg")
    public String addUser( @ModelAttribute("user")@Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            System.out.println("говна наверни");
            return "regPage";
        }
        userService.save(user);
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }




}

