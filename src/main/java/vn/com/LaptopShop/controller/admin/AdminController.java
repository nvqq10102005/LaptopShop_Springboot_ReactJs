package vn.com.LaptopShop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String getDashboard(){
        return "admin/dashboard/show";
    }
}
