package vn.com.LaptopShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.com.LaptopShop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);  

    List<User> findByEmailAndPassword(String email,String password);
} 