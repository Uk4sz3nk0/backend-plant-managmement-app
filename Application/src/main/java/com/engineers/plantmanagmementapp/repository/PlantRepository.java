package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.enums.PlantType;
import com.engineers.plantmanagmementapp.model.Plant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PlantRepository - Repository interface that extends Jpa repository
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

public interface PlantRepository extends JpaRepository<Plant, Long> {

    Page<Plant> findAllByNameContainsIgnoreCase(final String phrase, final Pageable pageable);

    Page<Plant> findAllByType(final PlantType type, final Pageable pageable);
}
