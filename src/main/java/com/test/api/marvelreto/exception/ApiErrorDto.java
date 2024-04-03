package com.test.api.marvelreto.exception;

public record ApiErrorDto(
        String message,
        String backendMessage,
        String method,
        String url
) {
}
