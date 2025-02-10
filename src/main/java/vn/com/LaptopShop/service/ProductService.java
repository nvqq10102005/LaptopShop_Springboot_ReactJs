package vn.com.LaptopShop.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import vn.com.LaptopShop.domain.*;
import vn.com.LaptopShop.repository.*;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    
    private Specification<Product> nameLike(String name){
    return (root, query, criteriaBuilder) 
      -> criteriaBuilder.like(root.get(Product_.class.getName()), "%"+name+"%");
    }


    public ProductService(ProductRepository productRepository, CartRepository cartRepository, CartDetailRepository cartDetailRepository,OrderDetailRepository orderDetailRepository,OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Product createProduct(Product pr){
        return this.productRepository.save(pr);
    }

    public org.springframework.data.domain.Page<Product> fetchProducts(Pageable pageable,String name){
        return this.productRepository.findAll(this.nameLike(name), pageable);
    }

    public Optional<Product> getProductById(long id){
        return this.productRepository.findById(id);
    }

    public void deleteProduct(long id){
        this.productRepository.deleteById(id);
    }
    
    public void handleAddProductToCart(String email, long productId, HttpSession session, long quantity) {
        User user = this.userService.getUserByEmail(email);
        if (user != null) {
            Cart cart = this.cartRepository.findByUser(user);
    
            // Nếu không tìm thấy Cart, tạo mới và lưu vào cơ sở dữ liệu
            if (cart == null) {
                cart = new Cart();
                cart.setUser(user);
                cart.setSum(0);
                cart = this.cartRepository.save(cart);// Lưu Cart vào DB
            }
    
            Optional<Product> productOptional = this.productRepository.findById(productId);
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                CartDetail existingCartDetail = this.cartDetailRepository.findByCartAndProduct(cart, product);
    
                if (existingCartDetail == null) {
                    CartDetail newCartDetail = new CartDetail();
                    newCartDetail.setCart(cart);
                    newCartDetail.setProduct(product);
                    newCartDetail.setPrice(product.getPrice());
                    newCartDetail.setQuantity(quantity);
                    this.cartDetailRepository.save(newCartDetail);
    
                    
                    int updatedSum = cart.getSum() + 1;
                    cart.setSum(updatedSum);
                    this.cartRepository.save(cart); // Cập nhật Cart vào DB
                    session.setAttribute("sum", updatedSum);
                } else {
                    existingCartDetail.setQuantity(existingCartDetail.getQuantity() + quantity);
                    this.cartDetailRepository.save(existingCartDetail);
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

    public void handlePlaceOrder(
            User user, HttpSession session,
            String receiverName, String receiverAddress, String receiverPhone) {

        // step 1: get cart by user
        Cart cart = this.cartRepository.findByUser(user);
        if (cart != null) {
            List<CartDetail> cartDetails = cart.getCartDetails();

            if (cartDetails != null) {

                // create order
                Order order = new Order();
                order.setUser(user);
                order.setReceiverName(receiverName);
                order.setReceiverAddress(receiverAddress);
                order.setReceiverPhone(receiverPhone);
                order.setStatus("PENDING");

                double sum = 0;
                for (CartDetail cd : cartDetails) {
                    sum += cd.getPrice();
                }
                order.setTotalPrice(sum);
                order = this.orderRepository.save(order);

                // create orderDetail

                for (CartDetail cd : cartDetails) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrder(order);
                    orderDetail.setProduct(cd.getProduct());
                    orderDetail.setPrice(cd.getPrice());
                    orderDetail.setQuantity(cd.getQuantity());

                    this.orderDetailRepository.save(orderDetail);
                }

                // step 2: delete cart_detail and cart
                for (CartDetail cd : cartDetails) {
                    this.cartDetailRepository.deleteById(cd.getId());
                }

                this.cartRepository.deleteById(cart.getId());

                // step 3 : update session
                session.setAttribute("sum", 0);
            }
        }
    }
        
    
}
