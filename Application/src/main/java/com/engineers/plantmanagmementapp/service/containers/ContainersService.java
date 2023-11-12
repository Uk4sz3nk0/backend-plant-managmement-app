package com.engineers.plantmanagmementapp.service.containers;

import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.security.model.Container;
import com.engineers.plantmanagmementapp.security.model.Plant;

import java.util.List;

/**
 * ContainerService - Container service interface
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

public interface ContainersService {
    void addContainer(final Container container, final User owner, final Plantation plantation, final Plant plant);

    void deleteContainer(final Long id);

    void editContainer(final Container container);

    Container getContainerById(final Long id);

    List<Container> getContainers();

    List<Container> getContainersByOwner(final User owner);

    List<Container> getContainersByPlantation(final Plantation plantation);
}