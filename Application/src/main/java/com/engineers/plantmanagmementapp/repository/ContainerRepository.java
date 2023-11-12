package com.engineers.plantmanagmementapp.repository;

import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.security.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContainerRepository extends JpaRepository<Container, Long> {

    List<Container> findByOwner(final User owner);

    List<Container> findByPlantation(final Plantation plantation);
}
