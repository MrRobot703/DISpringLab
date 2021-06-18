package com.demoshop.demoshop.web.controller.rest.simple;

import com.demoshop.demoshop.exceptions.PetNotFoundByIdException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.demoshop.demoshop.web.controllers.rest.simple")
public class SimpleExceptionHandler {

    @ExceptionHandler(PetNotFoundByIdException.class)
    public String handlerPetNotFounException(PetNotFoundByIdException ex) {
        return "Что-то пошло не так! " + ex.getMessage();
    }
}
