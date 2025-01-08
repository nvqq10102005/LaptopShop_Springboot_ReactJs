package vn.com.LaptopShop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.com.LaptopShop.domain.Product;
import vn.com.LaptopShop.service.ProductService;

@Controller
public class HomepageController {
    private final ProductService productService;

    public HomepageController(ProductService productService){
        this.productService=productService;
    }


    @GetMapping("/")
    public String getHomepage(Model model){
        List<Product> products = this.productService.fetchProducts();
        model.addAttribute("products", products);
        return "client/homepage/show";
    }
}
