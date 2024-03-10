package com.example.kata.controller;

import com.example.kata.model.po.User;
import com.example.kata.model.vo.AuthRequest;
import com.example.kata.model.vo.AuthResponse;
import com.example.kata.model.vo.UserResponse;
import com.example.kata.service.JwtService;
import com.example.kata.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@Tag(name = "Gestion des utilisateurs")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addUser")
    @Operation(summary = "Endpoint pour créer un nouvel utilisateur.")
    public UserResponse addNewUser(@Parameter(name = "Objet de type User.") @RequestBody User user) {
        return userInfoService.addUser(user);
    }

    @PostMapping("/generateToken")
    @Operation(summary = "Endpoint pour générer un token JWT après l'authentification de l'utilisateur.")
    public AuthResponse authenticateAndGetToken(@Parameter(name = "Objet de type AuthRequest.") @RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return AuthResponse.builder()
                    .username(authRequest.getUsername())
                    .token(jwtService.generateToken(authRequest.getUsername()))
                    .build();
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
