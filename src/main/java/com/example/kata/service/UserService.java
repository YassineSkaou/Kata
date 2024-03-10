package com.example.kata.service;

import com.example.kata.model.po.User;
import com.example.kata.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Cacheable("users")
    public User findByUserName(String name) {
        return userRepository.findByUsername(name).orElse(null);
    }

    @CacheEvict(value = "users", allEntries = true)
    public void clearCache() {
        log.info("Effacement du cache des utilisateurs");
    }
}
