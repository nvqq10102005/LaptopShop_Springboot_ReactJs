package vn.com.LaptopShop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.com.LaptopShop.service.UserService;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String getDashboard(Model model) {
        model.addAttribute("countUsers", userService.countUser());
        model.addAttribute("countProducts", userService.countProduct());
        model.addAttribute("countOrders", userService.countOrder());

        return "admin/dashboard/show";
    }
}
