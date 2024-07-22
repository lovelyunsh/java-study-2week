package com.todo.application;

import com.todo.presentation.dto.request.CreateTodoRequestDto;
import com.todo.presentation.dto.request.PatchTodoRequestDto;
import com.todo.presentation.dto.response.TodoResponseDto;

import java.util.List;


public interface TodoService {

    TodoResponseDto createTodo(CreateTodoRequestDto createTodoRequestDto);

    TodoResponseDto readTodoById(long id);

    List<TodoResponseDto> readAllTodoList();

    void deleteTodo(long id, String password);

    TodoResponseDto patchTodo(PatchTodoRequestDto patchTodoRequestDto);

}
