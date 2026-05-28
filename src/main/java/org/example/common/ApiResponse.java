package org.example.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter

public class ApiResponse<T> {
    private T data;
    private String message;
    private boolean status;
    private LocalDateTime timestamp;
    public ApiResponse(T data, String message,boolean status) {
        this.data = data;
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
