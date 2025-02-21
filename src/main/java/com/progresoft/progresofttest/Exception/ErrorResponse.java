package com.progresoft.progresofttest.Exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        int code,
        LocalDateTime timestamp,
        String message,
        String description,
        Object errors
) {
}
