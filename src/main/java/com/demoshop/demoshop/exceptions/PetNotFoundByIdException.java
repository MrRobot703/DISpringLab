package com.demoshop.demoshop.exceptions;

public class PetNotFoundByIdException extends RuntimeException {

    public PetNotFoundByIdException(Long id) {
        super("Мы не нашли питомца с id = " + id);
    }
}
