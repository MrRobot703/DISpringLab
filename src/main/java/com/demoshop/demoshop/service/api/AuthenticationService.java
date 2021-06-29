package com.demoshop.demoshop.service.api;

import com.demoshop.demoshop.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {

    boolean isAuthenticated();

    void autoLogin(String username, String password);

    void updateAuthoritiesInSecurityContext(Authentication authentication);
}
