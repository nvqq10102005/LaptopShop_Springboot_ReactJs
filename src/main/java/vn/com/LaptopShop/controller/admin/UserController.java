package vn.com.LaptopShop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.LaptopShop.domain.User;

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
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }
    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/user-detail";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User user) {
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }
    @RequestMapping(value = "/admin/user/create")
    public String createUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    
    @RequestMapping(value = "/admin/user/update/{id}")
    public String updateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("newUser", user);
        model.addAttribute("id", id);
        return "admin/user/update";
    }
    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String postUpdateUser(Model model,@ModelAttribute("newUser") User user){
        User currentUser = this.userService.getUserById(user.getId());
        if(currentUser != null){
            currentUser.setFullName(user.getFullName());
            currentUser.setPhone(user.getPhone());
            currentUser.setAddress(user.getAddress());

            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id){
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
        public String postDeleteUser(@RequestParam("id") Long id) {
        this.userService.deleteUser(id);
        return "redirect:/admin/user";
    }

}