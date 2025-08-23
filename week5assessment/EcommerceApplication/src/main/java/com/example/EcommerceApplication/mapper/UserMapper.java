package com.example.EcommerceApplication.mapper;
import com.example.EcommerceApplication.dto.UserRequestDTO;
import com.example.EcommerceApplication.dto.UserResponseDTO;
import com.example.EcommerceApplication.domain.User;

public class UserMapper {
    
    public static User toEntity(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setId(userRequestDTO.getId());
        user.setUsername(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(userRequestDTO.getRole());
        return user;
    }

    public static UserResponseDTO toResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setRole(user.getRole());
        return userResponseDTO;
    }
}
