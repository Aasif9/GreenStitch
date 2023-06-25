package com.example.GreenStitchAssignment.Service;


import com.example.GreenStitchAssignment.Model.UserData;
import com.example.GreenStitchAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserData registerUser(UserData user) {

        return userRepo.save(user);
    }

    @Override
    public UserData loginUser() {

        SecurityContext sc  = SecurityContextHolder.getContext();

        Authentication auth  = sc.getAuthentication();

        String userName = auth.getName();

        UserData user = userRepo.findByEmail(userName);

        return user;

    }

}