package com.engineers.plantmanagmementapp.handler;

import com.engineers.plantmanagmementapp.rest.containers.specification.model.ContainerDto;

import java.util.List;

/**
 * ContainersHandler - Containers handler interface
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

public interface ContainersHandler {

    void handleAddContainer(final ContainerDto containerDto);

    void handleDeleteContainer(final Long id);

    void handleEditContainer(final ContainerDto containerDto);

    ContainerDto handleGetContainerById(final Long id);

    List<ContainerDto> handleGetContainers();

    List<ContainerDto> handleGetContainersByOwner(final Long ownerId);

    List<ContainerDto> handleGetContainersByPlantation(final Long plantationId);
}