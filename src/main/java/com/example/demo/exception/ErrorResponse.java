package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String error;
    private String path;
    private int status;
    private String timestamp;
    private String message;

   public ErrorResponse(String error, String path, int status, String timestamp) {
        this.error = error;
        this.path = path;
        this.status = status;
        this.timestamp = timestamp;
    }
}
