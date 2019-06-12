package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exceptions.UserAllReadyExistException;
import com.stackroute.userservice.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User saveUser(User user) throws UserAllReadyExistException;
    public List<User> getAllUsers();
    public User updateUser(int id) throws UserNotFoundException;
    public User deleteUser(int id) throws UserNotFoundException;
}
