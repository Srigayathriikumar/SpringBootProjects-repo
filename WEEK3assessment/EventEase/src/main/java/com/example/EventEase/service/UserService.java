package com.example.EventEase.service;
import java.util.List;

import com.example.EventEase.domain.User;
public interface UserService {
    public List<User> getAllUsers();
    public User createUser(User user);
    public User getUserById(Long id);
    public User updateUser(Long id, User user);
    public void deleteUser(Long id);
}
