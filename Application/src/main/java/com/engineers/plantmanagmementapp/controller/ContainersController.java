package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.ContainersHandler;
import com.engineers.plantmanagmementapp.rest.containers.specification.api.ContainersApi;
import com.engineers.plantmanagmementapp.rest.containers.specification.model.ContainerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ContainerController - Controller class for container operations
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class ContainersController implements ContainersApi {

    private final ContainersHandler containersHandler;

    @Override
    public ResponseEntity<Void> addContainer(final ContainerDto containerDto) {
        log.info("'addContainer' endpoint has called");
        containersHandler.handleAddContainer(containerDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteContainer(final Long containerId) {
        log.info("'deleteContainer' endpoint has called");
        containersHandler.handleDeleteContainer(containerId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> editContainer(final ContainerDto containerDto) {
        log.info("'editContainer' endpoint has called");
        containersHandler.handleEditContainer(containerDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<ContainerDto> getContainerById(final Long containerId) {
        log.info("'getContainerById' endpoint has called");
        return ResponseEntity.ok(containersHandler.handleGetContainerById(containerId));
    }

    @Override
    public ResponseEntity<List<ContainerDto>> getContainers() {
        log.info("'getContainers' endpoint has called");
        return ResponseEntity.ok(containersHandler.handleGetContainers());
    }

    @Override
    public ResponseEntity<List<ContainerDto>> getContainersByOwner(final Long ownerId) {
        log.info("'getContainersByOwner' endpoint has called");
        return ResponseEntity.ok(containersHandler.handleGetContainersByOwner(ownerId));
    }

    @Override
    public ResponseEntity<List<ContainerDto>> getContainersByPlantation(final Long plantationId) {
        log.info("'getContainersByPlantation' endpoint has called");
        return ResponseEntity.ok(containersHandler.handleGetContainersByPlantation(plantationId));
    }
}
