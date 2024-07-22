package com.todo.presentation.dto.request;

import com.todo.domain.model.Todo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateTodoRequestDto {


    // TODO: valid
    private String title;
    private String content;
    private String manager;
    private String password;

    public Todo to() {
        return Todo.builder()
                .title(title)
                .content(content)
                .manager(manager)
                .password(password)
                .build();
    }
}
