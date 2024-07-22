package com.todo.infrastructure;

import com.todo.domain.TodoRepository;
import com.todo.domain.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepository {

    private final TodoJpaRepository todoJpaRepository;

    @Override
    public Todo create(Todo todo) {
        return todoJpaRepository.save(todo);
    }

    @Override
    public Todo patch(Todo todo) {
        return todoJpaRepository.save(todo);
    }

    @Override
    public Optional<Todo> readById(long id) {
        return todoJpaRepository.findById(id);
    }

    @Override
    public List<Todo> readAll() {
        return todoJpaRepository.findAllOrderByCreatedAtDesc();
    }

    @Override
    public void delete(Todo todo) {
        todoJpaRepository.delete(todo);
    }
}
