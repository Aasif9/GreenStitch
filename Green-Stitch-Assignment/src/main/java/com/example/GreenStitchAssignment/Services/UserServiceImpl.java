package com.example.GreenStitchAssignment.Services;

import Model.UserDetail;
import com.example.GreenStitchAssignment.Repository.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetail registerUser(UserDetail user)  {
        return userRepository.save(user);
    }

    @Override
    public UserDetail loginUser() throws ExecutionControl.UserException {
        SecurityContext sc  = SecurityContextHolder.getContext();

        Authentication auth  = sc.getAuthentication();

        String userName = auth.getName();

        UserDetail user = userRepository.findByEmail(userName);

        return null;
    }
}
