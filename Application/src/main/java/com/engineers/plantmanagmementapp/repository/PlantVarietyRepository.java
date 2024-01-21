package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Plant;
import com.engineers.plantmanagmementapp.model.PlantVariety;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PlantVarietyRepository - Repository interface for plant variety objects
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

public interface PlantVarietyRepository extends JpaRepository<PlantVariety, Long> {

    Page<PlantVariety> findAllByPlant(final Plant plant, final Pageable pageable);
}
