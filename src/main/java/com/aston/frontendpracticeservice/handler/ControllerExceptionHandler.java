package com.aston.frontendpracticeservice.handler;

import com.aston.frontendpracticeservice.domain.dto.exteptions.ErrorDto;
import com.aston.frontendpracticeservice.domain.exceptions.UserAlreadyExistsException;
import com.aston.frontendpracticeservice.domain.response.SimpleMessage;
import com.aston.frontendpracticeservice.exception.AuthException;
import com.aston.frontendpracticeservice.exception.UserNotFoundException;
import com.aston.frontendpracticeservice.domain.exceptions.ValidationException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, InvalidMediaTypeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected SimpleMessage handleBadRequestExceptions(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new SimpleMessage(exception.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorDto handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorDto(HttpStatus.CONFLICT.value(), ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected SimpleMessage handleUserNotFoundException(UserNotFoundException exception) {
        return new SimpleMessage(exception.getMessage());
    }

    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected SimpleMessage handleAuthException(AuthException exception) {
        return new SimpleMessage(exception.getMessage());
    }

    @ExceptionHandler(JwtException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected SimpleMessage handleJwtException(JwtException exception) {
        return new SimpleMessage(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorDto handleArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleValidationException(ValidationException ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDateTime.now());
    }

}
