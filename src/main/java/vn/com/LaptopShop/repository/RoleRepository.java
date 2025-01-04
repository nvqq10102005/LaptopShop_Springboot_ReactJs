package vn.com.LaptopShop.repository;

import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.LaptopShop.domain.Role;
import vn.com.LaptopShop.domain.User;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
    
} 
