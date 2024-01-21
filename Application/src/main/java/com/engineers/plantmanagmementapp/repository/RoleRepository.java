package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(final String name);
}
