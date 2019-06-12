package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exceptions.UserAllReadyExistException;
import com.stackroute.userservice.exceptions.UserNotFoundException;
import com.stackroute.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class UserController {

    private UserService userService;
    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try {
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }
        catch (UserAllReadyExistException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> deleteUser(@RequestBody int id)
    {
        ResponseEntity responseEntity;
        try {
            userService.deleteUser(id);
            responseEntity=new ResponseEntity<String>("Successfully deleted", HttpStatus.CREATED);
        } catch (UserNotFoundException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody int id)
    {
        ResponseEntity responseEntity;
        try {
            userService.updateUser(id);
            responseEntity=new ResponseEntity<String>("Successfully updated", HttpStatus.CREATED);
        } catch (UserNotFoundException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        catch(Exception e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
