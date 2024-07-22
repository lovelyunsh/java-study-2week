package com.todo.infrastructure;

import com.todo.domain.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllOrderByCreatedAtDesc();

}
