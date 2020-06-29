package ru.tim.pizzApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.service.UserService;
import ru.tim.pizzApp.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class FirstController  {


    @Autowired
    public UserService userService;
    @Autowired
    private UserValidator userValidator;

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @GetMapping("/")
    public String mainPage() {
        User user = userService.getByLogin(getCurrentUsername());
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

