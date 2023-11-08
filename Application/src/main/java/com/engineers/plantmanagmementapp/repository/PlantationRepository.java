package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlantationRepository extends JpaRepository<Plantation, Long> {

    Optional<List<Plantation>> findByOwner(final User owner);
}
