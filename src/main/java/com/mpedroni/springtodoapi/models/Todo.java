package com.mpedroni.springtodoapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Entity
@Table(
        name = "todos",
        uniqueConstraints = @UniqueConstraint(columnNames = {"description", "todo_list_id"}),
        indexes = @Index(columnList = "todo_list_id"))
public class Todo {
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TodoStatus status = TodoStatus.PENDING;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "todo_list_id", nullable = false)
    @JsonBackReference
    private TodoList todoList;

    @CreationTimestamp(source = SourceType.DB)
    private Date createdAt;

    @UpdateTimestamp(source = SourceType.DB)
    private Date updatedAt;

    public Todo() {
    }

    public Todo(TodoList todoList) {
        this.todoList = todoList;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
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
