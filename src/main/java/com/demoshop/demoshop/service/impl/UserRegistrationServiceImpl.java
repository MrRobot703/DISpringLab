package com.demoshop.demoshop.service.impl;

import com.demoshop.demoshop.dao.User;
import com.demoshop.demoshop.dao.repository.UserRepository;
import com.demoshop.demoshop.service.api.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addUser(User user) {
        boolean doesNotExist = userRepository.findByUsername(user.getUsername()) == null;
        if (doesNotExist) {
            userRepository.save(user);
        }
        return doesNotExist;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean removeUserByUsername(String username) {
        return userRepository.deleteByUsername(username) != null;
    }

    @Override
    public boolean removeUser(User user) {
        boolean exists = userRepository.findByUsername(user.getUsername()) != null;
        if (exists) {
            userRepository.delete(user);
        }
        return exists;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User doesn't exist");
    }
}
