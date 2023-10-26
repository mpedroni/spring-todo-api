package com.mpedroni.springtodoapi.services;

import com.mpedroni.springtodoapi.controllers.dtos.UpdateTodoDTO;
import com.mpedroni.springtodoapi.models.Todo;
import com.mpedroni.springtodoapi.models.TodoList;

public interface TodoListService {
    TodoList createTodoList(TodoList todoList);

    TodoList getTodoListById(Long id);

    Iterable<TodoList> getTodoLists();

    TodoList updateTodoList(long id, TodoList todoList);

    void deleteTodoListById(long id);

    Todo createTodoInTodoList(long todoListId, Todo todo);

    void deleteTodoById(long todoId);

    Todo updateTodoById(long todoId, UpdateTodoDTO dto);
}
