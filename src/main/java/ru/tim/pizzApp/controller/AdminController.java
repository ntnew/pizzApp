package ru.tim.pizzApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tim.pizzApp.dao.OrderDao;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.service.FoodService;
import ru.tim.pizzApp.service.UserService;

@Controller
public class AdminController {

    @Autowired
    public OrderDao orderDao;
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
    @GetMapping("/admin/foodList")
    public String getAllFood(Model model){
        model.addAttribute("food", foodService.findAll());
        return "admin/foodList";
    }
    @GetMapping("/admin/ordersList")
    public String getAllOrders(Model model){
        model.addAttribute("food", orderDao.findAll());
        return "admin/ordersList";
    }
    @PostMapping("/admin/makeAdmin")
    public String makeAdminByLogin(@ModelAttribute("user") User user){
        userService.makeAdminByLogin(user.getLogin());
        return "redirect:/admin/usersList";
    }
    @PostMapping("/admin/bustAdmin")
    public String bustAdminByLogin(@ModelAttribute("user") User user){
        userService.bustAdminByLogin(user.getLogin());
        return "redirect:/admin/usersList";
    }
    @PostMapping("/admin/deleteUser")
    public String deleteByLogin(@ModelAttribute("user") User user){
        userService.delete(user.getLogin());
        return "redirect:/admin/usersList";
    }

}
