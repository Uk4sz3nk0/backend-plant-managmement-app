package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.security.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PlantRepository - Repository interface
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
