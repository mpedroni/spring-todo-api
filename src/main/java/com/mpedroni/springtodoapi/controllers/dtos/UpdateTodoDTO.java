package com.mpedroni.springtodoapi.controllers.dtos;

import com.mpedroni.springtodoapi.models.TodoStatus;

import java.util.Optional;

public record UpdateTodoDTO(
        Optional<String> description,
        Optional<TodoStatus> status
) {
}
