package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.ContainersHandler;
import com.engineers.plantmanagmementapp.rest.containers.specification.model.ContainerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ContainerHandlerImpl - Implementation class of ContainersHandlerInterface
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ContainersHandlerImpl implements ContainersHandler {

    @Override
    public void handleAddContainer(final ContainerDto containerDto) {

    }

    @Override
    public void handleDeleteContainer(final Long id) {

    }

    @Override
    public void handleEditContainer(final ContainerDto containerDto) {

    }

    @Override
    public ContainerDto handleGetContainerById(final Long id) {
        return null;
    }

    @Override
    public List<ContainerDto> handleGetContainers() {
        return null;
    }

    @Override
    public List<ContainerDto> handleGetContainersByOwner(final Long ownerId) {
        return null;
    }

    @Override
    public List<ContainerDto> handleGetContainersByPlantation(final Long plantationId) {
        return null;
    }
}
