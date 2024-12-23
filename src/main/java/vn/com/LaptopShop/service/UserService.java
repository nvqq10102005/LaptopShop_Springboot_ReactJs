package vn.com.LaptopShop.service;

import org.springframework.stereotype.Service;

import vn.com.LaptopShop.domain.User;
import vn.com.LaptopShop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User handlesaveUser(User user){
        User getUser = this.userRepository.save(user);
        return getUser;
    }
}
