package com.pedroramos.crudusuarios.exceptions;

public class NoUsersFoundException extends RuntimeException {
    public NoUsersFoundException(String message) {
        super(message);
    }
}
