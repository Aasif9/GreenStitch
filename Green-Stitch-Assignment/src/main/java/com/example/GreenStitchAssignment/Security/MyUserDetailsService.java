package com.example.GreenStitchAssignment.Security;
import Model.UserDetail;
import com.example.GreenStitchAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class MyUserDetailsService  implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetail user  = userRepository.findByEmail(username);

        if(user!=null)
        {
            return new MyUserDetails(user);
        }

        throw new UsernameNotFoundException("user not found with this username : "+username);
    }

}