package com.informatorio.infonews.config;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
    
    private HttpStatus status;
    private String message;
    private int errors;
    private List<ApiSubError> subErrors;

    public ApiError() {
    }

    public ApiError(HttpStatus status, String message, int errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
    }

    @Override
    public String toString() {
        return "ApiError [errors=" + errors + ", message=" + message + ", status=" + status + "]";
    } 
}