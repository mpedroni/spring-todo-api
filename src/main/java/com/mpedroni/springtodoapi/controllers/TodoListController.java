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

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public TodoList getTodoListById(@PathVariable("id") long id) {
        return this.todoListService.getTodoListById(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Iterable<TodoList> getAllTodoLists() {
        return this.todoListService.getTodoLists();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TodoList createTodoList(@RequestBody TodoList todoList) {
        return this.todoListService.createTodoList(todoList);
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public TodoList updateTodoList(@PathVariable("id") long id, @RequestBody TodoList todoList) {
        return this.todoListService.updateTodoList(id, todoList);
    }
}
