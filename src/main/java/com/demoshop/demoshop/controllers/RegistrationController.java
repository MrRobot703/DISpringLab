package com.demoshop.demoshop.controllers;

import com.demoshop.demoshop.config.security.RegistrationForm;
import com.demoshop.demoshop.service.api.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String registrationForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRegistrationService.addUser(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
