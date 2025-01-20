package vn.com.LaptopShop.controller.client;

import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.com.LaptopShop.domain.Product;
import vn.com.LaptopShop.service.ProductService;

@Controller
public class ItemController {
    
    private final ProductService productService;

    public ItemController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("product/{id}")
    public String getProductPage(Model model, @PathVariable long id){
        Product product = this.productService.getProductById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "client/product/show";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(@PathVariable long id,HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);

        long productId = id;
        String email = (String) session.getAttribute("email");

        this.productService.handleAddProductToCart(email, productId,session);
        
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getCartPage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");

        model.addAttribute("cart", this.productService.getCart(email));
        return "client/cart/show";
    }
}
