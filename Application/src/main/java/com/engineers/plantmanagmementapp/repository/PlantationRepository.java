package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlantationRepository extends JpaRepository<Plantation, Long> {

    Optional<List<Plantation>> findByOwner(final User owner);

    @Query("SELECT p FROM Plantation p " +
            "JOIN p.employees e " +
            "WHERE e.id = :employeeId")
    List<Plantation> findPlantationsByEmployee(@Param("employeeId") final Long employeeId);
}
