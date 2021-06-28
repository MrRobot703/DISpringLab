package com.demoshop.demoshop.service.api;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {

    boolean isAuthenticated();

    void autoLogin(String username, String password);
}
