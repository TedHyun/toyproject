package com.example.main.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// #JPA DATA Version
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
