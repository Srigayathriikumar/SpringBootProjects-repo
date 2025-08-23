package com.example.EcommerceApplication.service;

import java.util.List;
import com.example.EcommerceApplication.domain.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    User loginUser(Long id, String password);
    String deleteUser(Long id);
}