package com.demoshop.demoshop.service.api;

public interface SecurityService {

    boolean isAuthenticated();

    void autoLogin(String username, String password);
}
