package com.stackroute.userservice.exceptions;

public class UserAllReadyExistException extends Exception {
    private String message;
    public UserAllReadyExistException(){}
    public UserAllReadyExistException(String message){
        super(message);
        this.message=message;
    }
}
