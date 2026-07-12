package com.taskbridge.common.dto;

import org.springframework.http.HttpStatus;

public final class ApiResponseFactory {

    private ApiResponseFactory() {
    }

    public static <T> ApiResponse<T> success(HttpStatus status, String message, T data) {
        return ApiResponse.success(status, message, data);
    }

    public static <T> ApiResponse<T> success(HttpStatus status, String message) {
        return success(status, message, null);
    }
}
