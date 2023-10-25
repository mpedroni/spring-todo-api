package com.mpedroni.springtodoapi.controllers;

import com.mpedroni.springtodoapi.models.Todo;
import com.mpedroni.springtodoapi.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo-lists/{todoListId}/todos")
public class TodoController {
    private final TodoListService todoListService;

    @Autowired
    public TodoController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PostMapping()
    public Todo createTodo(@PathVariable("todoListId") long id, @RequestBody Todo todo) {
        return this.todoListService.createTodoInTodoList(id, todo);
    }
}
