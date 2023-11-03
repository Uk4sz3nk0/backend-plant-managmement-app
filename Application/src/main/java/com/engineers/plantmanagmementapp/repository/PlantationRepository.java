package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Plantation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantationRepository extends JpaRepository<Plantation, Long> {
}
