package com.mpedroni.springtodoapi.services;

import com.mpedroni.springtodoapi.controllers.dtos.UpdateTodoDTO;
import com.mpedroni.springtodoapi.exceptions.TodoListNotFoundException;
import com.mpedroni.springtodoapi.models.Todo;
import com.mpedroni.springtodoapi.models.TodoList;
import com.mpedroni.springtodoapi.repositories.TodoListRepository;
import com.mpedroni.springtodoapi.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todoListRepository;
    private final TodoRepository todoRepository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository todoListRepository, TodoRepository todoRepository) {
        this.todoListRepository = todoListRepository;
        this.todoRepository = todoRepository;
    }


    @Override
    public TodoList createTodoList(TodoList todoList) {
        return this.todoListRepository.save(todoList);
    }

    @Override
    public TodoList getTodoListById(Long id) {
        return this.todoListRepository.findById(id)
                .orElseThrow(() -> new TodoListNotFoundException(id));
    }

    @Override
    public Page<TodoList> getTodoLists(Pageable pageable) {
        return this.todoListRepository.findAll(pageable);
    }

    @Override
    public TodoList updateTodoList(long id, TodoList todoList) {
        TodoList existingTodoList = this.todoListRepository.findById(id)
                .orElseThrow(() -> new TodoListNotFoundException(id));

        existingTodoList.setTitle(todoList.getTitle());

        return this.todoListRepository.save(existingTodoList);
    }

    @Override
    public void deleteTodoListById(long id) {
        this.todoListRepository.findById(id)
                .orElseThrow(() -> new TodoListNotFoundException(id));

        this.todoListRepository.deleteById(id);
    }

    @Override
    public Todo createTodoInTodoList(long todoListId, Todo todo) {
        TodoList existingTodoList = this.todoListRepository.findById(todoListId)
                .orElseThrow(() -> new TodoListNotFoundException(todoListId));

        todo.setTodoList(existingTodoList);

        this.todoRepository.save(todo);

        return todo;
    }

    @Override
    public void deleteTodoById(long todoId) {
        this.todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Todo with id " + todoId + " not found."));

        this.todoRepository.deleteById(todoId);
    }

    @Override
    public Todo updateTodoById(long todoId, UpdateTodoDTO dto) {
        var todo = this.todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Todo with id " + todoId + " not found."));

        dto.description().ifPresent(todo::setDescription);

        dto.status().ifPresent(status -> {
            switch (status) {
                case DOING -> todo.doing();
                case DONE -> todo.done();
                case PENDING -> todo.pending();
            }
        });

        return this.todoRepository.save(todo);
    }
}
