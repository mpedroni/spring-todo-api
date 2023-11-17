package com.mpedroni.springtodoapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Getter
@Entity
@Table(name = "todo_lists")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "todoList", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("status, createdAt")
    private List<Todo> todos = new LinkedList<>();

    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt = Instant.now();

    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt = Instant.now();

    public TodoList() {
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
