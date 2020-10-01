package com.lti.authorization1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.authorization1.Model.User1;



public interface UserRepository extends JpaRepository<User1, Integer> {
    Optional<User1> findByUserName(String userName);
}
