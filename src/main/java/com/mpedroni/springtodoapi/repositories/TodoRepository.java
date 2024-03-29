package com.mpedroni.springtodoapi.repositories;

import com.mpedroni.springtodoapi.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
