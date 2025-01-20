package vn.com.LaptopShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.LaptopShop.domain.Cart;
import vn.com.LaptopShop.domain.User;

@Repository

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
    
}