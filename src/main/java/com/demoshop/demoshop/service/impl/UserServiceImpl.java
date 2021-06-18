package com.demoshop.demoshop.service.impl;

import com.demoshop.demoshop.model.User;
import com.demoshop.demoshop.repositories.UserRepository;
import com.demoshop.demoshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean removeUserByUsername(String username) {
        return userRepository.deleteByUsername(username) != null;
    }

    public boolean removeUser(User user) {
        boolean exists = userRepository.findByUsername(user.getUsername()) != null;
        if (exists) {
            userRepository.delete(user);
        }
        return exists;
    }
}
