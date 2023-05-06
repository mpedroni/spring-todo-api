package com.mpedroni.springtodoapi.exceptions;

public class TodoListNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5071646428281007896L;

    public TodoListNotFoundException(Long todoListId) {
        super(String.format("No to-do list with id %d is available", todoListId));
    }
}
