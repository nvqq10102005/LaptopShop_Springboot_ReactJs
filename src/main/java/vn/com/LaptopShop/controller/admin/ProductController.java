package vn.com.LaptopShop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.com.LaptopShop.domain.Product;

@Controller
public class ProductController {

        @GetMapping("/admin/product")
    public String getProduct(){
        return "admin/dashboard/product";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model){
        model.addAttribute("newProduct", new Product());
        return "admin/dashboard/create";
    }

}
