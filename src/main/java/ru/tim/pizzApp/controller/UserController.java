package ru.tim.pizzApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.tim.pizzApp.service.FoodService;

@Controller
public class UserController {

    @Autowired
    public FoodService foodService;

    @GetMapping("/user/")
    public String getAllFood(Model model){
        model.addAttribute("food", foodService.findAll());
        return "user/mainPage";
    }
    @GetMapping("/user/pizza")
    public String getPizza(Model model){
        model.addAttribute("food", foodService.findPizza());
        return "user/pizza";
    }
    @GetMapping("/user/drinks")
    public String getDrinks(Model model){
        model.addAttribute("food", foodService.findDrinks());
        return "user/drinks";
    }
    @GetMapping("/user/snacks")
    public String getSnacks(Model model){
        model.addAttribute("food", foodService.findSnacks());
        return "user/snacks";
    }
}
