package vn.com.LaptopShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.LaptopShop.domain.Product;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    

    
} 