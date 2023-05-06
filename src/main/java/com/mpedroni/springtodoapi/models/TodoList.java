package com.mpedroni.springtodoapi.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "todo_lists")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;
}
