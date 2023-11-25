package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.UserHarvest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserHarvestRepository - Repository interface for UserHarvest entity
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

public interface UserHarvestRepository extends JpaRepository<UserHarvest, Long> {
}
