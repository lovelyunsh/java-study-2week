package com.todo.presentation.dto.response;

import com.todo.domain.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class TodoResponseDto {
    private String title;
    private String content;
    private String manager;
    private LocalDateTime createdAt;

    public static TodoResponseDto from(Todo todo) {
        return TodoResponseDto.builder()
                .content(todo.getContent())
                .title(todo.getTitle())
                .manager(todo.getManager())
                .createdAt(todo.getCreatedAt())
                .build();
    }
}
