package vn.com.LaptopShop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.com.LaptopShop.domain.Role;
import vn.com.LaptopShop.domain.User;
import vn.com.LaptopShop.service.RoleService;
import vn.com.LaptopShop.service.UploadFileService;
import vn.com.LaptopShop.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    private final UploadFileService uploadFileService;

    private final RoleService roleService;
    private PasswordEncoder passwordEncoder;


    public UserController(UserService userService , UploadFileService uploadFileService,
    PasswordEncoder passwordEncoder, RoleService roleService
   ) {
        this.userService = userService;
        this.uploadFileService = uploadFileService;
        this.passwordEncoder = passwordEncoder; 
        this.roleService = roleService;
    }


    @RequestMapping("/admin/user")
        public String getUserPage(Model model,
            @RequestParam("page") Optional<String> pageOptional) {
        int page = 1;
        try {
            if (pageOptional.isPresent()) {
                // convert from String to int
                page = Integer.parseInt(pageOptional.get());
            } else {
                // page = 1
            }
        } catch (Exception e) {
            // page = 1
            // TODO: handle exception
        }
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<User> usersPage = this.userService.getAllUsers(pageable);
        List<User> users = usersPage.getContent();
        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", usersPage.getTotalPages());
        return "admin/user/table-user";  
    }
    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/user-detail";
    }

    @PostMapping("/admin/user/create")
    public String createUserPage(Model model, 
    @ModelAttribute("newUser") @Valid User user,
    BindingResult userBindingResult,
    @RequestParam("laptopShopFile") MultipartFile file
    ) {

        List<FieldError> errors = userBindingResult.getFieldErrors();
        for (FieldError error : errors ) {
        System.out.println (error.getField() + " - " + error.getDefaultMessage());
        }
        
        if(userBindingResult.hasErrors()){
            return "admin/user/create";
        }

        String avatar = this.uploadFileService.handleSaveUploadFile(file,"avatar");
        String hashPassword = this.passwordEncoder.encode(user.getPassword());

        user.setAvatar(avatar);
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName(user.getRole().getName()));
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/create")
    public String createUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    
    @RequestMapping(value = "/admin/user/update/{id}")
    public String updateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        List<Role> roles = this.roleService.getAllRoles();
        String avatar = user.getAvatar();

        model.addAttribute("newUser", user);
        model.addAttribute("id", id);
        model.addAttribute("roles", roles);
        model.addAttribute("avatar", avatar);
        return "admin/user/update";
    }
    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User user, @RequestParam("laptopShopFile") MultipartFile file) {
    User currentUser = this.userService.getUserById(user.getId());
    if (currentUser != null) {
       
        currentUser.setFullName(user.getFullName());
        currentUser.setPhone(user.getPhone());
        currentUser.setAddress(user.getAddress());

        
        if (!file.isEmpty()) {
            String avatar = this.uploadFileService.handleSaveUploadFile(file, "avatar");
            currentUser.setAvatar(avatar);
        }

        Role role = this.roleService.getRoleById(user.getRole().getId());
        currentUser.setRole(role);

        
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