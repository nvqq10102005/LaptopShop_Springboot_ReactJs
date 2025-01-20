package vn.com.LaptopShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.LaptopShop.domain.Cart;
import vn.com.LaptopShop.domain.CartDetail;
import vn.com.LaptopShop.domain.Product;
import vn.com.LaptopShop.domain.User;
import vn.com.LaptopShop.repository.CartDetailRepository;
import vn.com.LaptopShop.repository.CartRepository;
import vn.com.LaptopShop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private UserService userService;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository, CartDetailRepository cartDetailRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    public Product createProduct(Product pr){
        return this.productRepository.save(pr);
    }

    public List<Product> fetchProducts(){
        return this.productRepository.findAll();
    }

    public Optional<Product> getProductById(long id){
        return this.productRepository.findById(id);
    }

    public void deleteProduct(long id){
        this.productRepository.deleteById(id);
    }

    public void handleAddProductToCart(String email,long productId){
        User user = this.userService.getUserByEmail(email);

        if(user != null){
            Cart cart = this.cartRepository.findByUser(user);

            if(cart == null){
                Cart orderCart = new Cart();
                orderCart.setUser(user);
                orderCart.setSum(1);
                cart = this.cartRepository.save(orderCart);
                
            }
            // search productById
        Optional<Product> product = this.productRepository.findById(productId);
        if(product.isPresent()){
            Product realProduct = product.get();
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCart(cart);
            cartDetail.setProduct(realProduct);
            cartDetail.setPrice(realProduct.getPrice());
            cartDetail.setQuantity(1);

            this.cartDetailRepository.save(cartDetail);
        }
        
        }
    }


}
