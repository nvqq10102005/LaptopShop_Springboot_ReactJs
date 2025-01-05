package vn.com.LaptopShop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
    
    @GetMapping("/")
    public String getHomepage(){
        return "client/homepage/show";
    }
}
