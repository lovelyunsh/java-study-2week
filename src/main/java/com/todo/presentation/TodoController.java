package com.todo.presentation;


import com.todo.application.TodoService;
import com.todo.presentation.dto.request.CreateTodoRequestDto;
import com.todo.presentation.dto.request.PatchTodoRequestDto;
import com.todo.presentation.dto.response.TodoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody CreateTodoRequestDto createTodoRequestDto) {
        TodoResponseDto todo = todoService.createTodo(createTodoRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getTodoById(@PathVariable Long id) {
        TodoResponseDto todo = todoService.readTodoById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todo);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getTodoList() {
        List<TodoResponseDto> todoResponseDtoList = todoService.readAllTodoList();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoResponseDtoList);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDto> patchTodo(@RequestBody PatchTodoRequestDto patchTodoRequestDto) {
        TodoResponseDto todoResponseDto = todoService.patchTodo(patchTodoRequestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id,
                                           @RequestParam String password) {
        todoService.deleteTodo(id, password);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

}
