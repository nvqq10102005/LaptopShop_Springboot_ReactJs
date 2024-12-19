package vn.com.LaptopShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.LaptopShop.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/continue")
    public String getHomepage(){
        return this.userService.handleHello();
    }

    @RequestMapping("/")
    public String getView(){
        return "hello.jsp";
    }
}
