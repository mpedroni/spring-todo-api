package com.mpedroni.springtodoapi.controllers;

import com.mpedroni.springtodoapi.models.TodoList;
import com.mpedroni.springtodoapi.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo-lists")
public class TodoListController {

    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TodoList createTodoList(@RequestBody TodoList todoList) {
        return this.todoListService.createTodoList(todoList);
    }
}
