package vn.com.LaptopShop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.com.LaptopShop.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User save(User user);  
} 