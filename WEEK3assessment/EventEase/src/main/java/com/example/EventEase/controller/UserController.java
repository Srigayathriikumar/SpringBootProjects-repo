package com.example.EventEase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.EventEase.service.UserService;

import jakarta.validation.Valid;

import com.example.EventEase.domain.User;
import com.example.EventEase.dto.UserRequestDTO;
import com.example.EventEase.dto.UserResponseDTO;
import com.example.EventEase.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/all")
    public List<UserResponseDTO> getallusers(){
        List<UserResponseDTO> list = new ArrayList<>();
        for(User user : userService.getAllUsers()) {
            list.add(userMapper.toResponse(user));
        }
        return list;
    }

    @GetMapping("/{id}")
    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public User requestUser(@Valid @RequestBody UserRequestDTO requestdto){
    return userService.createUser(UserMapper.toEntity(requestdto));
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with ID " + id + " deleted successfully.";
    }
}
