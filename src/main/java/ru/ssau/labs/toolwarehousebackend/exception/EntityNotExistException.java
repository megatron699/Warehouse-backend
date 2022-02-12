package ru.ssau.labs.toolwarehousebackend.exception;

public class EntityNotExistException extends IllegalStateException {
    public EntityNotExistException(String message) {
        super(message);
    }
}
