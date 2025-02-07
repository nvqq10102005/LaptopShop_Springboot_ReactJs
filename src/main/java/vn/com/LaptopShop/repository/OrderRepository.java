package vn.com.LaptopShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.LaptopShop.domain.Order;
import vn.com.LaptopShop.domain.User;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByUser(User user);
}
