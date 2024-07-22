package com.todo.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchTodoRequestDto {

    private long id;
    private String title;
    private String content;
    private String manager;
    private String password;

}
