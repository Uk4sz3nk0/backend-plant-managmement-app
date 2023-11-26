package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.model.UserHarvest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * UserHarvestRepository - Repository interface for UserHarvest entity
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

public interface UserHarvestRepository extends JpaRepository<UserHarvest, Long> {

    Page<UserHarvest> findAllByUser(final User user, final Pageable pageable);

    @Query("SELECT uh FROM UserHarvest uh JOIN uh.harvest h WHERE h.plantation = :plantation AND uh.user = :user")
    Page<UserHarvest> findAllByUserAndPlantation(@Param("user") final User user, @Param("plantation") final Plantation plantation, final Pageable pageable);
}
