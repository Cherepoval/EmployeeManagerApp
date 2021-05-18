package com.alexcherepov.employee_manager.exeption;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String massage) {
        super(massage);
    }
}
