package com.demoshop.demoshop.service.api;

import com.demoshop.demoshop.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    boolean removeUserByUsername(String username);

    boolean removeUser(User user);
}
