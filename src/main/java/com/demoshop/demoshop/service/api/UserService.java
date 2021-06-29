package com.demoshop.demoshop.service.api;

import com.demoshop.demoshop.exceptions.AuthenticationException;
import com.demoshop.demoshop.model.Privilege;
import com.demoshop.demoshop.model.Role;
import com.demoshop.demoshop.model.User;

public interface UserService {

    void saveUser(User user) throws AuthenticationException;

    void updateUser(User user);

    User findUserByUsername(String username);

    boolean removeUserByUsername(String username);

    boolean removeUser(User user);

    Role findRoleByName(String name);

    void saveRole(Role role);

    Privilege findPrivilegeByName(String name);

    void savePrivilege(Privilege privilege);
}
