package com.mpedroni.springtodoapi.services;

import com.mpedroni.springtodoapi.models.TodoList;

public interface TodoListService {
    TodoList createTodoList(TodoList todoList);
}