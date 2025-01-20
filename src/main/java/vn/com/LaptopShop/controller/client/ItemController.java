package vn.com.LaptopShop.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.com.LaptopShop.domain.CartDetail;
import vn.com.LaptopShop.domain.Product;
import vn.com.LaptopShop.service.ProductService;

@Controller
public class ItemController {
    
    private final ProductService productService;

    

    public ItemController(ProductService productService ){
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

        List<CartDetail> cart = this.productService.getCart(email);
        double totalPrice = 0;
        for (CartDetail cartDetail : cart) {
            totalPrice += cartDetail.getProduct().getPrice() * cartDetail.getQuantity();
        }
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cart", this.productService.getCart(email));
        return "client/cart/show";
    }

    @PostMapping("/cart/delete/{id}")
    public String deleteProductFromCart(@PathVariable long id){ 
        this.productService.handleDeleteProductFromCart(id);
        return "redirect:/cart";
    }
}
