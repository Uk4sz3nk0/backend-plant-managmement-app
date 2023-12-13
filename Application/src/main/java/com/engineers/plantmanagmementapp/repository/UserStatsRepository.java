package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Harvest;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.model.UserStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserStatsRepository - interface that extends jpa repository for getting entities from db
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

public interface UserStatsRepository extends JpaRepository<UserStats, Long> {

    Optional<UserStats> findByHarvestAndUser(final Harvest harvest, final User user);

    Page<UserStats> findAllByUser(final User user, final Pageable pageable);
}
