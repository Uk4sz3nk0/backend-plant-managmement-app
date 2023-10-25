package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Plantation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlantationRepository extends JpaRepository<Plantation, UUID> {
}
