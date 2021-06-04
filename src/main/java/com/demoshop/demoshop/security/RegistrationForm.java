package com.demoshop.demoshop.security;

import com.demoshop.demoshop.dao.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String nickname;
    private String phoneNumber;
    private String email;
    private String street;
    private String city;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullName,
                nickname, phoneNumber, email, street, city);
    }
}
