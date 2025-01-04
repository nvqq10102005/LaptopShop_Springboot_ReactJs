package vn.com.LaptopShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.LaptopShop.domain.Role;
import vn.com.LaptopShop.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
