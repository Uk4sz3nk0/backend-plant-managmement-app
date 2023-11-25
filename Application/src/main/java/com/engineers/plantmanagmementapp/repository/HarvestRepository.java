package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * HarvestRepository - Repository class for Harvest entity
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

public interface HarvestRepository extends JpaRepository<Harvest, Long> {
}
