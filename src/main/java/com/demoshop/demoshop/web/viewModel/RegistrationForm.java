package com.demoshop.demoshop.web.viewModel;

import com.demoshop.demoshop.model.User;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegistrationForm {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;
    private String confirmingPassword;

    @NotNull
    @NotEmpty
    private String fullName;

    private String nickname;

    @NotNull
    @NotEmpty
    private String phoneNumber;

    @NotNull
    @NotEmpty
    private String email;

    private String street;

    private String city;

    public User toUser() {
        User user = new User(username, fullName, nickname, phoneNumber, email, street, city);
        user.setPassword(password);
        return user;
    }
}
