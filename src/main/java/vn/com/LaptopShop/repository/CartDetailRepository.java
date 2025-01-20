package vn.com.LaptopShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.LaptopShop.domain.Cart;
import vn.com.LaptopShop.domain.CartDetail;
import vn.com.LaptopShop.domain.Product;

@Repository

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

    List<CartDetail> findByCart(Cart cart);

    CartDetail findByCartAndProduct(Cart cart, Product product);

    

}
