package com.mpedroni.springtodoapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "todos")
public class Todo {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TodoStatus status = TodoStatus.PENDING;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "todo_list_id", nullable = false)
    @JsonBackReference
    private TodoList todoList;

    public Todo() {
    }

    public Todo(TodoList todoList) {
        this.todoList = todoList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }

    public void doing() {
        this.status = TodoStatus.DOING;
    }

    public void done() {
        this.status = TodoStatus.DONE;
    }

    public void pending() {
        this.status = TodoStatus.PENDING;
    }
}
