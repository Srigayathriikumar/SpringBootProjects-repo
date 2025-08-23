package com.example.EcommerceApplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.EcommerceApplication.repository.UserRepository;
import com.example.EcommerceApplication.domain.User;
import java.util.List;
import java.util.Optional;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser(){
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        when(userRepository.save(user)).thenReturn(user);
        User savedUser = userService.saveUser(user);
        assertNotNull(savedUser);
        assertEquals("testuser", savedUser.getUsername());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetAllUsers(){
        User user1 = new User(); user1.setUsername("user1");
        User user2 = new User(); user2.setUsername("user2");
        when(userRepository.findAll()).thenReturn(List.of(user1, user2));
        List<User> users = userService.getAllUsers();
        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).getUsername());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserById(){
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        User foundUser = userService.getUserById(1L);
        assertNotNull(foundUser);
        assertEquals("testuser", foundUser.getUsername());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteUser(){
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }
}