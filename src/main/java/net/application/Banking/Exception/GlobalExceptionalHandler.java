package net.application.Banking.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ErrorDetails> handleAccountException(AccountException exception, WebRequest request){
        ErrorDetails details = new ErrorDetails(
                LocalDateTime.now(),exception.getMessage(), request.getDescription(false),"ACCOUNT_NOT_FOUND"
        );
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAccountException(Exception exception, WebRequest request){
        ErrorDetails details = new ErrorDetails(
                LocalDateTime.now(),exception.getMessage(), request.getDescription(false),"ACCOUNT_NOT_FOUND"
        );
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
