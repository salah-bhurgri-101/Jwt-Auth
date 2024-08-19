package com.codemyth.reposit;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemyth.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}