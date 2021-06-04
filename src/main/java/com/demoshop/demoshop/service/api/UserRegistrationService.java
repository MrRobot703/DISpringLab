package com.demoshop.demoshop.service.api;

import com.demoshop.demoshop.dao.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserRegistrationService extends UserDetailsService {

    boolean addUser(User user);
    User getUserByUsername(String username);
    boolean removeUserByUsername(String username);
    boolean removeUser(User user);

}
