package com.mpedroni.springtodoapi.services;

import com.mpedroni.springtodoapi.models.TodoList;
import com.mpedroni.springtodoapi.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }


    @Override
    public TodoList createTodoList(TodoList todoList) {
        return this.todoListRepository.save(todoList);
    }
}
