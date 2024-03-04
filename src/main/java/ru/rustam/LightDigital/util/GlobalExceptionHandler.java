package ru.rustam.LightDigital.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.rustam.LightDigital.dto.ExceptionResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class, RuntimeException.class})
    protected ResponseEntity<ExceptionResponse> handleConflict(RuntimeException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage());
        return ResponseEntity
                .badRequest()
                .body(response);
    }

    @ExceptionHandler(value = {Error.class, Exception.class})
    protected ResponseEntity<ExceptionResponse> handleInternalServerError(Exception ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage());
        return ResponseEntity
                .internalServerError()
                .body(response);
    }
}
