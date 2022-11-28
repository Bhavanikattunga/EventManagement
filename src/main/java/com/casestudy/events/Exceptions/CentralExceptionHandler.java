package com.casestudy.events.Exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class CentralExceptionHandler {
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(BookingNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
   }



   /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methordArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.joining(","));
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }*/
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethordArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String,String> resp=new HashMap<>();
                e.getBindingResult().getAllErrors().forEach((error)->{
                    String fieldName=((FieldError)error).getField();
                    String message=error.getDefaultMessage();
                    resp.put(fieldName, message);
                });
        return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
    }
}