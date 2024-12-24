package vn.com.LaptopShop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.LaptopShop.domain.User;
import vn.com.LaptopShop.repository.UserRepository;
import vn.com.LaptopShop.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService
    ) {
        this.userService = userService;

    }

    @RequestMapping("/")
    public String getView(Model model) {
        List<User> lUsers = this.userService.getAllUsersByEmail("quynv@techzone.io.vn");
        System.out.println(lUsers);
        model.addAttribute("hello", "test");
        model.addAttribute("hoidanit", "from controller");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        return "admin/user/table-user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
        System.out.println(" run here " + user);
        this.userService.handlesaveUser(user);
        return "hello";
    }
    @RequestMapping(value = "/admin/user/create")
    public String createUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }


}
