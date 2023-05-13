package com.mpedroni.springtodoapi.services;

import com.mpedroni.springtodoapi.models.TodoList;

public interface TodoListService {
    TodoList createTodoList(TodoList todoList);

    TodoList getTodoListById(Long id);

    Iterable<TodoList> getTodoLists();
}
