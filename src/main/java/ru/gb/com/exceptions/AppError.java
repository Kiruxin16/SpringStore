package ru.gb.com.exceptions;

import org.springframework.http.HttpStatus;

public class AppError {
    private int messCode;
    private String message;
    public AppError(int messCode, String message) {
        this.messCode=messCode;
        this.message= message;
    }
}
