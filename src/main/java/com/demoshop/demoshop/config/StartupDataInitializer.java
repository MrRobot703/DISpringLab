package com.demoshop.demoshop.config;

import com.demoshop.demoshop.exceptions.AuthenticationException;
import com.demoshop.demoshop.model.Privilege;
import com.demoshop.demoshop.model.Role;
import com.demoshop.demoshop.model.User;
import com.demoshop.demoshop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class StartupDataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private boolean isAlreadySetup;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (isAlreadySetup) return;

        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Collections.singletonList(readPrivilege));
        createRoleIfNotFound("ROLE_CUSTOMER", Collections.singletonList(readPrivilege));

        User admin = createAdmin("admin", "admin");
        admin.setRoles(Collections.singletonList(adminRole));
        admin.setEnabled(true);
        try {
            userService.saveUser(admin);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } finally {
            isAlreadySetup = true;
        }
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = userService.findPrivilegeByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            userService.savePrivilege(privilege);
        }
        return privilege;
    }

    @Transactional
    private Role createRoleIfNotFound(String name, List<Privilege> privileges) {
        Role role = userService.findRoleByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            userService.saveRole(role);
        }
        return role;
    }

    private User createAdmin(String login, String password) {
        User admin = new User(login,
                "adminFullName",
                "adminNick",
                null,
                null,
                null,
                null
        );
        admin.setPassword(password);
        return admin;
    }
}
