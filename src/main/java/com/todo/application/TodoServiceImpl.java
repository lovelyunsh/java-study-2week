package com.todo.application;

import com.todo.domain.TodoRepository;
import com.todo.domain.model.Todo;
import com.todo.presentation.dto.request.CreateTodoRequestDto;
import com.todo.presentation.dto.request.PatchTodoRequestDto;
import com.todo.presentation.dto.response.TodoResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public TodoResponseDto createTodo(CreateTodoRequestDto createTodoRequestDto) {
        Todo createdTodo = todoRepository.create(createTodoRequestDto.to());
        return TodoResponseDto.from(createdTodo);
    }

    @Override
    public TodoResponseDto readTodoById(long id) {
        // TODO: Exception 변경
        Todo todo = todoRepository.readById(id).orElseThrow(RuntimeException::new);
        return TodoResponseDto.from(todo);
    }

    @Override
    public List<TodoResponseDto> readAllTodoList() {
        List<Todo> todos = todoRepository.readAll();
        return todos.stream().map(TodoResponseDto::from).toList();
    }

    @Override
    @Transactional
    public void deleteTodo(long id, String password) {
        // TODO: Exception 변경
        Todo todo = todoRepository.readById(id).orElseThrow(RuntimeException::new);
        validatePassword(password, todo.getPassword());
        todoRepository.delete(todo);
    }

    @Override
    @Transactional
    public TodoResponseDto patchTodo(PatchTodoRequestDto patchTodoRequestDto) {
        // TODO: Exception 변경
        Todo todo = todoRepository.readById(patchTodoRequestDto.getId())
                .orElseThrow(RuntimeException::new);
        validatePassword(patchTodoRequestDto.getPassword(), todo.getPassword());
        todo.change(patchTodoRequestDto.getTitle(),
                patchTodoRequestDto.getContent(),
                patchTodoRequestDto.getManager());

        Todo patchedTodo = todoRepository.patch(todo);
        return TodoResponseDto.from(patchedTodo);
    }

    private void validatePassword(String password1, String password2) {
        // TODO: Exception 변경
        if (!password1.equals(password2)) throw new RuntimeException();
    }
}
