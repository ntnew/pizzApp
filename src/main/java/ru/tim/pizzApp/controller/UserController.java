package ru.tim.pizzApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tim.pizzApp.additional.UserMethods;
import ru.tim.pizzApp.additional.OrderMethods;
import ru.tim.pizzApp.entity.Bucket;
import ru.tim.pizzApp.entity.Order;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.service.*;


@Controller
public class UserController {


    @Autowired
    public UserService userService;

    @Autowired
    public BucketService bucketService;

    @Autowired
    public FoodService foodService;

    @Autowired
    public AdditiveService additiveService;

    @Autowired
    public OrderService orderService;

    @GetMapping("/user/")
    public String getAllFood(Model model){
        model.addAttribute("food", foodService.findAll());
        model.addAttribute("additive", additiveService.findAll());
        return "user/mainPage";
    }
    @GetMapping("/user/pizza")
    public String getPizza(Model model){
        model.addAttribute("food", foodService.findPizza());
        model.addAttribute("additive", additiveService.findAll());
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

    @PostMapping("/user/addToBucket")
    public String addToBucket(@ModelAttribute Bucket bucket, Model model){
        bucket.setUser_login(UserMethods.getCurrentUsername());
        if (bucket.getAdditives() != null) {
            String[] words = bucket.getAdditives().split(",");
            double AdditivesPrice = 0;
            for(String word : words){
                AdditivesPrice = AdditivesPrice + additiveService.findPriceByName(word);
            }
            bucket.setPrice(bucket.getPrice()+AdditivesPrice);
        }
        bucketService.save(bucket);
        return "redirect:/";
    }

    @GetMapping("/user/bucket")
    public String showBucket(Model model){
        model.addAttribute("bucket", bucketService.findByLogin(UserMethods.getCurrentUsername()));
        model.addAttribute("fullPrice", OrderMethods.getFullPrice(bucketService.findByLogin(UserMethods.getCurrentUsername())));
        return "user/bucket";
    }

    @PostMapping("/user/deleteBucketPosById")
    public String deleteBucketPosById(@ModelAttribute Bucket bucket){
        bucketService.deleteById(bucket.getId());
        return "redirect:/user/bucket";
    }

    @GetMapping("/user/orderReg")
    public String orderRegistration(Model model){
        model.addAttribute("user", userService.getByLogin(UserMethods.getCurrentUsername()));
        model.addAttribute("finalOrder", OrderMethods.getOrderString(bucketService.findByLogin(UserMethods.getCurrentUsername())));
        model.addAttribute("fullPrice", OrderMethods.getFullPrice(bucketService.findByLogin(UserMethods.getCurrentUsername())));
        return "user/orderReg";
    }
    @PostMapping("/user/regOrder")
    public String registerOrder(@ModelAttribute Order order){
        order.setUserLogin(UserMethods.getCurrentUsername());
        order.setStatus("Готовится");
        orderService.save(order);
        bucketService.deleteByLogin(UserMethods.getCurrentUsername());
        return "redirect:/" ;
    }

    @GetMapping("/user/personPage")
    public String personPage(Model model){
        model.addAttribute("user", userService.getByLogin(UserMethods.getCurrentUsername()));
        model.addAttribute("order", orderService.getAllUserOrder(UserMethods.getCurrentUsername()));
        return "user/personPage";
    }
    @PostMapping("/user/editUser")
    public String editUser(@ModelAttribute("user") User user){
        user.setLogin(UserMethods.getCurrentUsername());
        userService.update(user);
        return "redirect:/user/personPage";
    }

    @PostMapping("/user/editPassword")
    public String editPassword(@ModelAttribute("user") User user){
        user.setLogin(UserMethods.getCurrentUsername());
        userService.updatePassword(user);
        return "redirect:/user/personPage";
    }
}
