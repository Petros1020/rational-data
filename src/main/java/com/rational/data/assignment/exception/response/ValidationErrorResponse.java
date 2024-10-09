package com.rational.data.assignment.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class ValidationErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<String> errors;
}
