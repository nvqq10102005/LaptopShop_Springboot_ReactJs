package vn.com.LaptopShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import vn.com.LaptopShop.domain.User;
import vn.com.LaptopShop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

}
