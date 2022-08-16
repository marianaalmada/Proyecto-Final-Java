package com.informatorio.infonews.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
    
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        ApiError error = new ApiError();
        error.setStatus(status);
        error.setMessage("Valitdation Error");
        error.setErrors(ex.getErrorCount());
        List<ApiSubError> subErrors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> new ApiSubError(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        error.setSubErrors(subErrors);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalOperationException.class)
    public ResponseEntity<Object> IllegalOperationException(IllegalOperationException ex, 
            WebRequest request) {
    ApiError error = new ApiError();
    error.setStatus(HttpStatus.BAD_REQUEST);
    error.setMessage(ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
   }
}
