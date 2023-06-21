package com.example.GreenStitchAssignment.Repository;

import Model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Integer> {
    UserDetail findByEmail(String username);
}
