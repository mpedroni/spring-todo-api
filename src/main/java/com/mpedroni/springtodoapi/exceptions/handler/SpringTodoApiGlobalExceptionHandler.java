package com.mpedroni.springtodoapi.exceptions.handler;

import com.mpedroni.springtodoapi.exceptions.TodoListNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SpringTodoApiGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {TodoListNotFoundException.class})
    public ResponseEntity<?> handleTodoListNotFound(TodoListNotFoundException todoListNotFoundException, WebRequest request) {
        return this.handleExceptionInternal(todoListNotFoundException,
                todoListNotFoundException.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
