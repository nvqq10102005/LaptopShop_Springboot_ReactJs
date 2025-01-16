package vn.com.LaptopShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.LaptopShop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);  

    void deleteById(long id);

    List<User> findOneByEmail(String email);

    List<User> findAll();

    User findById(long id);

    boolean existsByEmail(String email);
    
    User findByEmail(String email);
} 