package com.example.GreenStitchAssignment.Controller;

import Model.UserDetail;
import com.example.GreenStitchAssignment.Repository.UserRepository;
import com.example.GreenStitchAssignment.Services.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // register user with given details

    @PostMapping("/app/signup")
    public ResponseEntity<UserDetail> registerUser(@Validated @RequestBody UserDetail user) throws ExecutionControl.UserException
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserDetail p = userService.registerUser(user);

        return new ResponseEntity<UserDetail>(p,HttpStatus.CREATED);
    }

    // first time user login with Email and password and got JWT token

    @GetMapping("/signIn")
    public ResponseEntity<UserDetail> getLoggedInCustomerDetailsHandler(Authentication auth) throws BadCredentialsException{

        UserDetail customer= userRepository.findByEmail(auth.getName());

        if(customer!=null)
        {
            return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
        }

        throw new BadCredentialsException("Invalid Username or password");


    }

    // Authentication with JWT token

    @GetMapping("/logged-in/user")
    public ResponseEntity<String> LoginUser() throws ExecutionControl.UserException
    {
        UserDetail user =  userService.loginUser();

        String message = "Welcome to Shimbhu's Website  : " +user.getFullName();

        return new ResponseEntity<String>(message,HttpStatus.OK);
    }
}
