package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Harvest;
import com.engineers.plantmanagmementapp.model.Plantation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

/**
 * HarvestRepository - Repository class for Harvest entity
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

public interface HarvestRepository extends JpaRepository<Harvest, Long> {

    Page<Harvest> findAllByPlantation(final Plantation plantation, final Pageable pageable);

    Page<Harvest> findAllByPlantationAndDate(final Plantation plantation, final LocalDate date, final Pageable pageable);

    Page<Harvest> findAllByPlantationAndSeason(final Plantation plantation, final Integer season, final Pageable pageable);

    @Query(value = "SELECT h FROM Harvest h WHERE h.plantationId = :plantationId AND h.date BETWEEN :startDate AND :endDate", nativeQuery = true)
    Page<Harvest> findAllByPlantationInDateRange(@Param("plantationId") final Long plantationId, @Param("startDate") final LocalDate startDate, @Param("endDate") final LocalDate endDate, final Pageable pageable);
}