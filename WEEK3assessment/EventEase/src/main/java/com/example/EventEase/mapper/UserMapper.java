package com.example.EventEase.mapper;
import org.springframework.stereotype.Component;

import com.example.EventEase.domain.User;
import com.example.EventEase.dto.*;
@Component
public class UserMapper {
    
    public static User toEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setId(userRequestDTO.getId());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        
        return user;
    }

    public static UserResponseDTO toResponse(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setEmail(user.getEmail());
        return userResponseDTO;
    }
}
