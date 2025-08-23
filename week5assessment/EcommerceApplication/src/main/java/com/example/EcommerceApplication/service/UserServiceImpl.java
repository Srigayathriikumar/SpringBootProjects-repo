package com.example.EcommerceApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.EcommerceApplication.domain.User;
import com.example.EcommerceApplication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User loginUser(Long id, String password) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        
        return null;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public  String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User Deleted";
    }
}