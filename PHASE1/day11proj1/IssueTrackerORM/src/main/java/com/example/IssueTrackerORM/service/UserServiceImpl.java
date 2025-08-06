package com.example.IssueTrackerORM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.IssueTrackerORM.domain.User;

import com.example.IssueTrackerORM.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserById(int id) {
        return userRepository.findById((long) id).orElse(null);
    }
   @Override
public User createUser(User user) {
    return userRepository.save(user);
}
    
}
