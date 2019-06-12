package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exceptions.UserAllReadyExistException;
import com.stackroute.userservice.exceptions.UserNotFoundException;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAllReadyExistException {
        if(userRepository.existsById(user.getId()))
        {
            throw new UserAllReadyExistException("User already exist!!!!");
        }
        User saveUser= (User) userRepository.save(user);
        if(saveUser==null)
        {
            throw new UserAllReadyExistException("User already exist!!!");
        }
        return saveUser;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(int id) throws UserNotFoundException {
        User user1=null;
        if(userRepository.existsById(id)) {
            user1.getFirstName();
            user1.getLastName();
            user1.getAge();
           userRepository.save(user1);
        }
        if(user1==null)
        {
            throw new UserNotFoundException("User not found!");
        }
        return user1;
    }

    @Override
    public User deleteUser(int id) throws UserNotFoundException {
        User user=new User();
        if(userRepository.existsById(id)) {
            userRepository.delete(user);
        }
        if(user==null)
        {
            throw new UserNotFoundException("User not found!");
        }
        return user;
    }
}

