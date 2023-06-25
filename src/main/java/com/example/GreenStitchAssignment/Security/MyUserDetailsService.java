package com.example.GreenStitchAssignment.Security;

import com.example.GreenStitchAssignment.Model.UserData;
import com.example.GreenStitchAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class MyUserDetailsService  implements UserDetailsService{

    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserData user  = userRepo.findByEmail(username);

        if(user!=null)
        {
            return new MyUserDetails(user);
        }

        throw new UsernameNotFoundException("user not found with this username : "+username);
    }

}