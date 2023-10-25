package com.mpedroni.springtodoapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name = "todo_lists")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @OneToMany(mappedBy = "todoList")
    @JsonManagedReference
    private Set<Todo> todos;

    public TodoList() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }
}
