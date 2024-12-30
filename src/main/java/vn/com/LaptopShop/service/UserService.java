package vn.com.LaptopShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

    public List<User> getAllUsersByEmail(String email){
        return this.userRepository.findAll();
    }

    public User handlesaveUser(User user){
        User getUser = this.userRepository.save(user);
        return getUser;
    }

    public User getUserById(long id){
        User getUserId = this.userRepository.findById(id);
        return getUserId;
    }

    public void deleteUser(long id){
        this.userRepository.deleteById(id);
    }

}
