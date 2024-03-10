package com.example.kata.service;

import com.example.kata.model.po.User;
import com.example.kata.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByUserName() {

        // Given
        String username = "testUser";
        User user = new User();
        user.setUsername(username);

        // Mocking userRepository.findByUsername(name) method
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        // When
        User result = userService.findByUserName(username);

        // Then
        assertEquals(user, result, "Le résultat doit être l'utilisateur trouvé");
    }

}
