package ru.tim.pizzApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.tim.pizzApp.additional.OrderMethods;
import ru.tim.pizzApp.dao.OrderDao;
import ru.tim.pizzApp.entity.Food;
import ru.tim.pizzApp.entity.Order;
import ru.tim.pizzApp.entity.User;
import ru.tim.pizzApp.service.FoodService;
import ru.tim.pizzApp.service.OrderService;
import ru.tim.pizzApp.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AdminController {


    @Autowired
    public OrderService orderService;
    @Autowired
    public FoodService foodService;
    @Autowired
    public UserService userService;
    @Value("${upload.path}")
    private String uploadPath;

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
        model.addAttribute("order", orderService.findAll());
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

    @PostMapping("/admin/deleteOrder")
    public String deleteOrder(@ModelAttribute("order") Order order){
        orderService.deleteById(order.getId());
        return "redirect:/admin/ordersList";
    }

    @PostMapping("/admin/deleteFood")
    public String deleteFood(@ModelAttribute("food") Food food){
        foodService.deleteById(food.getId());

        return "redirect:/admin/foodList";
    }

    @GetMapping("/admin/newFood")
    public String newFood(){
        return "admin/newFood";
    }

    @PostMapping("/admin/createNewFood")
    public String createFood(@ModelAttribute("food") Food food,
                             @RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + ".jpg";
                file.transferTo(new File(uploadPath + "/" + resultFilename));

            food.setImage(resultFilename);
        }
        foodService.create(food);
        redirectAttributes.addFlashAttribute("message",
                "Успешно создано, будет добавлено после перезагрузки сервера");
        return "redirect:/admin/foodList";
    }

    @PostMapping("/admin/editFood")
    public String editFood(@ModelAttribute("food") Food food){
        foodService.update(food);
        return "redirect:/admin/foodList";
    }

    @PostMapping("/admin/editOrder")
    public String editOrder(@ModelAttribute("order") Order order){
        if(order.getNotice().equals(null)){
            order.setNotice(" ");
        }
        orderService.updateStatus(order);
        return "redirect:/admin/ordersList";
    }

}
