package com.stackroute.muzixservice.exception;

import com.stackroute.muzixservice.exception.TrackAllReadyExistException;
import com.stackroute.muzixservice.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    //Exception handling for already presents tracks
    @ExceptionHandler(value= TrackAllReadyExistException.class)
    public ResponseEntity<String> globalException(TrackAllReadyExistException exception)
    {
        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        return responseEntity;
    }
    //Exception handling for track nat present
    @ExceptionHandler(value= TrackNotFoundException.class)
    public ResponseEntity<String> globalException1(TrackNotFoundException exception1)
    {
        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        return responseEntity;
    }
}
