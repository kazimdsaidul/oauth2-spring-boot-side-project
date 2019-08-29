package com.marcusdacoregio.authservice.exception;

//public class CustomAppException extends Exception {
//
//    private String requestId;
//
//    // Custom error message
//    private String message;
//
//    // Custom error code representing an error in system
//    private String errorCode;
//
//    public CustomAppException (String message) {
//        super(message);
//        this.message = message;
//    }
//
//    public CustomAppException (String requestId, String message, String errorCode) {
//        super(message);
//        this.requestId = requestId;
//        this.message = message;
//        this.errorCode = errorCode;
//    }
//
//    public String getRequestId() {
//        return this.requestId;
//    }
//
//    public void setRequestId(String requestId) {
//        this.requestId = requestId;
//    }
//
//    @Override
//    public String getMessage() {
//        return this.message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getErrorCode() {
//        return this.errorCode;
//    }
//
//    public void setErrorCode(String errorCode) {
//        this.errorCode = errorCode;
//    }
//}


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class CustomAppException{

    @ExceptionHandler({java.sql.SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<String> handleDogsServiceException(SQLIntegrityConstraintViolationException e){

        return error(INTERNAL_SERVER_ERROR, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        return ResponseEntity.status(status).body(e.getMessage());
    }
}