package com.example.EcommerceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import com.example.EcommerceApplication.service.UserService;
import com.example.EcommerceApplication.domain.User;
import com.example.EcommerceApplication.dto.UserRequestDTO;
import com.example.EcommerceApplication.dto.UserResponseDTO;
import com.example.EcommerceApplication.mapper.UserMapper;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDTO> response = users.stream()
            .map(UserMapper::toResponseDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(UserMapper.toResponseDTO(user));
    }

    @PostMapping("/admin")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO requestDTO) {
        User user = UserMapper.toEntity(requestDTO);
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(UserMapper.toResponseDTO(savedUser));
    }

    @PutMapping("admin/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO requestDTO) {
        User user = UserMapper.toEntity(requestDTO);
        user.setId(id);
        User updatedUser = userService.saveUser(user);
        return ResponseEntity.ok(UserMapper.toResponseDTO(updatedUser));
    }

    @DeleteMapping("admin/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}