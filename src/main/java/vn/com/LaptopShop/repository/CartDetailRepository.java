package vn.com.LaptopShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.LaptopShop.domain.CartDetail;

@Repository

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
    

}