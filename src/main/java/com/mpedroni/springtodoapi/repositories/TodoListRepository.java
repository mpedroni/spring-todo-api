package com.mpedroni.springtodoapi.repositories;

import com.mpedroni.springtodoapi.models.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends PagingAndSortingRepository<TodoList, Long>, CrudRepository<TodoList, Long> {
}
