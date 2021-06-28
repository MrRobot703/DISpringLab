package com.demoshop.demoshop.web.controller.rest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {

    @GetMapping("/csrfToken")
    public CsrfToken getCsrfToken(CsrfToken token) {
        return token;
    }
}
