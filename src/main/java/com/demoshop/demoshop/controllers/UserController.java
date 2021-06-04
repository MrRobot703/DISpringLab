package com.demoshop.demoshop.controllers;

import com.demoshop.demoshop.dao.User;
import com.demoshop.demoshop.service.api.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PutMapping(value = "/putNewUser",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public boolean registerNewAccount(@RequestBody User user) {
        return userRegistrationService.addUser(user);
    }

    @DeleteMapping(value = "/deleteAccount")
    public boolean deleteAccount(@RequestBody String username) {
        return userRegistrationService.removeUserByUsername(username);
    }

    @PostMapping(value = "/getUserData",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User getUserData(@RequestBody String username) {
        return userRegistrationService.getUserByUsername(username);
    }
}
