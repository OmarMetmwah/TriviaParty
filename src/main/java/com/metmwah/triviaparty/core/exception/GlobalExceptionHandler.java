package com.metmwah.triviaparty.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserAlreadyExistsException.class})
    public ResponseEntity<Object> handleException(UserAlreadyExistsException exception) {
        return  errorResponse(HttpStatus.CONFLICT,exception);
    }
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleException(NotFoundException exception) {
        return  errorResponse(HttpStatus.NOT_FOUND,exception);
    }
    @ExceptionHandler({WrongCredentialsException.class, BadCredentialsException.class})
    public ResponseEntity<Object> handleException(RuntimeException exception) {
        return errorResponse(HttpStatus.UNAUTHORIZED,new WrongCredentialsException());
    }
    @ExceptionHandler({InvalidTokenException.class})
    public ResponseEntity<Object> handleException(InvalidTokenException exception) {
        return  errorResponse(HttpStatus.UNAUTHORIZED,exception);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR,exception);
    }
    private ResponseEntity<Object> errorResponse(HttpStatus status,RuntimeException exception){
        exception.printStackTrace();
        String errorMessage = exception.getMessage();
        int index = errorMessage.indexOf(":");
        if (index != -1) {
            errorMessage = errorMessage.substring(index + 2);
        }
        return ResponseEntity
                .status(status)
                .body(errorMessageJSON(errorMessage));
    }

    private Map<String,String> errorMessageJSON(String errorMessage){
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("errorMessage",errorMessage);
        return responseBody;
    }

}
