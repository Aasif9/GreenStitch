package com.example.GreenStitchAssignment.Repository;


import com.example.GreenStitchAssignment.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository  extends JpaRepository<UserData, Integer>{

    UserData findByEmail(String username);

}