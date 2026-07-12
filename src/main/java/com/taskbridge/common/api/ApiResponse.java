package com.taskbridge.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
        LocalDateTime timestamp,
        int status,
        String message,
        T data
) {
}
