package com.todo.domain;

import com.todo.domain.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo create(Todo todo);

    Todo patch(Todo todo);

    Optional<Todo> readById(long id);

    List<Todo> readAll();

    void delete(Todo todo);

}
