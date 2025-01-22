package vn.com.LaptopShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
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

    public void handleAddProductToCart(String email,long productId,HttpSession session){
        User user = this.userService.getUserByEmail(email);

        if(user != null){
            Cart cart = this.cartRepository.findByUser(user);

            if(cart == null){
                Cart orderCart = new Cart();
                orderCart.setUser(user);
                orderCart.setSum(0);
                cart = this.cartRepository.save(orderCart);
                
            }
            // search productById
        Optional<Product> product = this.productRepository.findById(productId);
        if(product.isPresent()){

            CartDetail isExist = this.cartDetailRepository.findByCartAndProduct(cart, product.get());
            if(isExist != null){
                isExist.setQuantity(isExist.getQuantity() + 1);
                this.cartDetailRepository.save(isExist);
                return;
            } else {
                Product realProduct = product.get();
                CartDetail cartDetail = new CartDetail();
                cartDetail.setCart(cart);
                cartDetail.setProduct(realProduct);
                cartDetail.setPrice(realProduct.getPrice());
                cartDetail.setQuantity(1);

                int isSum = cart.getSum()+1;
                cart.setSum(isSum);
                this.cartRepository.save(cart);
                session.setAttribute("sum", isSum);
                this.cartDetailRepository.save(cartDetail);
            }
        }
        
        }
    }

    public Cart fetchByUser(User user) {
        return this.cartRepository.findByUser(user);
    }


    public List<CartDetail> getCart(String email){
        User user = this.userService.getUserByEmail(email);
        if(user != null){
            Cart cart = this.cartRepository.findByUser(user);
            if(cart != null){
                return this.cartDetailRepository.findByCart(cart);
            }
        }
        return null;
    }

    public void handleDeleteProductFromCart(long cartDetailId,HttpSession session){
        Optional<CartDetail> cartDetail = this.cartDetailRepository.findById(cartDetailId);
        if(cartDetail.isPresent()){
            CartDetail realCartDetail = cartDetail.get();
            Cart cart = realCartDetail.getCart();
            int isSum = cart.getSum() - 1;
            cart.setSum(isSum);
            this.cartRepository.save(cart);
            session.setAttribute("sum", isSum);
        }
        
        this.cartDetailRepository.deleteById(cartDetailId);
    }

    public void handleUpdateProductFromCart(long cartDetailId, long quantity){
        Optional<CartDetail> cartDetail = this.cartDetailRepository.findById(cartDetailId);
        if(cartDetail.isPresent()){
            CartDetail realCartDetail = cartDetail.get();
            realCartDetail.setQuantity(quantity);
            this.cartDetailRepository.save(realCartDetail);
        }
    }

    public void handleUpdateCartBeforeCheckout(List<CartDetail> cartDetails) {
        for (CartDetail cartDetail : cartDetails) {
            Optional<CartDetail> cdOptional = this.cartDetailRepository.findById(cartDetail.getId());
            if (cdOptional.isPresent()) {
                CartDetail currentCartDetail = cdOptional.get();
                currentCartDetail.setQuantity(cartDetail.getQuantity());
                this.cartDetailRepository.save(currentCartDetail);
            }
        }
    }

    




}
