package com.stackroute.muzixservice.exception;

public class TrackAllReadyExistException extends Exception {

    private String message;
    public TrackAllReadyExistException(){}
    public TrackAllReadyExistException(String message)
    {
        super(message);
        this.message=message;
    }
}
