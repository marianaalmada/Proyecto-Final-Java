package com.informatorio.infonews.config;

public class ApiSubError {

    private final String name;
    private final String message;

    public ApiSubError(String name, String message) {
        this.name = name;
        this.message = message;
    }
    
    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    } 
}
