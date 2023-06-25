package com.example.GreenStitchAssignment.Service;


import com.example.GreenStitchAssignment.Exceptions.UserException;
import com.example.GreenStitchAssignment.Model.UserData;

public interface UserService {
    public UserData registerUser(UserData user) throws UserException;
    public UserData loginUser()  throws UserException;
}
