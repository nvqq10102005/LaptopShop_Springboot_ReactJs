package vn.com.LaptopShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import vn.com.LaptopShop.domain.Role;
import vn.com.LaptopShop.domain.User;
import vn.com.LaptopShop.domain.dto.RegisterDTO;
import vn.com.LaptopShop.repository.OrderRepository;
import vn.com.LaptopShop.repository.ProductRepository;
import vn.com.LaptopShop.repository.RoleRepository;
import vn.com.LaptopShop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    

    public UserService(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }

    public User handleSaveUser(User user) {
        User currentUser = this.userRepository.save(user);
        System.out.println(currentUser);
        return currentUser;
    }

    public User getUserById(long id){
        return userRepository.findById(id);
    }

    public void deleteUser(long id){
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name){
        return this.roleRepository.findByName(name);
    }

    public User registerDTOtoUser(RegisterDTO registerDTO){
        User user = new User();

        user.setFullName(registerDTO.getFirstName() +" "+ registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());

        return user;

    }

    public boolean checkEmailExist(String email){
        return this.userRepository.existsByEmail(email);
    }

    public User getUserByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public long countUser(){
        return this.userRepository.count();
    }

    public long countProduct(){
        return this.productRepository.count();
    }

    public long countOrder(){
        return this.orderRepository.count();
    }



}
