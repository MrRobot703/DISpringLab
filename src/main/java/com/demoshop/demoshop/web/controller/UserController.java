package com.demoshop.demoshop.web.controller;

import com.demoshop.demoshop.model.User;
import com.demoshop.demoshop.service.api.SecurityService;
import com.demoshop.demoshop.service.api.UserService;
import com.demoshop.demoshop.web.validator.UserValidator;
import com.demoshop.demoshop.web.viewModel.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) return "redirect:/";

        if (error != null) model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null) model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }
        model.addAttribute("userDTO", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String processRegistration(@ModelAttribute("userDTO") RegistrationForm form, BindingResult bindingResult) {
        userValidator.validate(form, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User user = form.toUser();
        userService.save(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/";
    }
}
