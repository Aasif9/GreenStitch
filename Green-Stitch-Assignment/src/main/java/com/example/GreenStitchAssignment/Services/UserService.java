package com.example.GreenStitchAssignment.Services;

import Model.UserDetail;
import jdk.jshell.spi.ExecutionControl;

public interface UserService {
    public UserDetail registerUser(UserDetail user) throws ExecutionControl.UserException;
    public UserDetail loginUser()  throws ExecutionControl.UserException;
}
