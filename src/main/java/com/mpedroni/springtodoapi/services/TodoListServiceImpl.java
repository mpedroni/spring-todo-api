package com.mpedroni.springtodoapi.services;

import com.mpedroni.springtodoapi.exceptions.TodoListNotFoundException;
import com.mpedroni.springtodoapi.models.Todo;
import com.mpedroni.springtodoapi.models.TodoList;
import com.mpedroni.springtodoapi.repositories.TodoListRepository;
import com.mpedroni.springtodoapi.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Iterable<TodoList> getTodoLists() {
        return this.todoListRepository.findAll();
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
    public Todo createTodoInTodoList(long id, Todo todo) {
        TodoList existingTodoList = this.todoListRepository.findById(id)
                .orElseThrow(() -> new TodoListNotFoundException(id));

        todo.setTodoList(existingTodoList);
        
        this.todoRepository.save(todo);

        return todo;
    }
}
