package vn.com.LaptopShop.controller.client;

import java.util.List;

import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vn.com.LaptopShop.domain.Product;
import vn.com.LaptopShop.domain.User;
import vn.com.LaptopShop.domain.dto.RegisterDTO;
import vn.com.LaptopShop.service.ProductService;
import vn.com.LaptopShop.service.UserService;

@Controller
@Validated
public class HomepageController {
    private final ProductService productService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public HomepageController(ProductService productService,UserService userService,PasswordEncoder passwordEncoder){
        this.productService=productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/")
    public String getHomepage(Model model,HttpServletRequest request){
        List<Product> products = this.productService.fetchProducts();
        model.addAttribute("products", products);

        HttpSession session = request.getSession(false);
        if(session != null){
        String username = (String) session.getAttribute("username");
        
        model.addAttribute("username", username);
        
        }

        return "client/homepage/show";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerUser",new RegisterDTO() );
        return "client/auth/register";
    }
    @GetMapping("/login-account")
    public String getLoginPage(Model model){
        
        return "client/auth/login-account";
        }

        @PostMapping("/register")
        public String handleRegister(
        @ModelAttribute("registerUser") @Valid RegisterDTO registerDTO,
        BindingResult bindingResult) {
        // validate
        if (registerDTO == null) {
            throw new IllegalArgumentException("RegisterDTO is null");
        }
        if (bindingResult.hasErrors()) {
            return "client/auth/register";
        }
        User user = this.userService.registerDTOtoUser(registerDTO);

        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName("USER"));

        if(user.getAvatar() == null || user.getAvatar().isBlank()){
            user.setAvatar("default-avatar.jpg");
        }
        // save
        this.userService.handleSaveUser(user);
        return "redirect:/login-account";
        }

        @GetMapping("/access-denied")
        public String getAccessDeniedPage(){
        return "client/auth/access-denied";
    }
    
}
