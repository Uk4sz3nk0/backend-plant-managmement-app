package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(final String email);

    List<User> findAllByEmailContainingIgnoreCase(final String email);
}
