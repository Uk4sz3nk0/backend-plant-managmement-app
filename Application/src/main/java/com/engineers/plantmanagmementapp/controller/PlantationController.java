package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.PlantationHandler;
import com.engineers.plantmanagmementapp.rest.plantation.specification.api.PlantationApi;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.AreaDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.PlantationDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PlantationController - Controller class for plantation operations
 * <p>
 * Created on: 2023-11-05
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlantationController implements PlantationApi {

    private final PlantationHandler plantationHandler;

    @Override
    public ResponseEntity<Void> createPlantation(final PlantationDto plantationDto) {
        log.info("Endpoint \"createPlantation\" has called");
        plantationHandler.handleCreatePlantation(plantationDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deletePlantation(final Long id) {
        log.info("Endpoint \"deletePlantation\" has called");
        plantationHandler.handleDeletePlantation(id);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> editPlantation(final PlantationDto plantationDto) {
        log.info("Endpoint \"editPlantation\" has called");
        plantationHandler.handleEditPlantation(plantationDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> addArea(final Long plantationId, final AreaDto areaDto) {
        log.info("Endpoint \"addArea\" has called");
        plantationHandler.handleAddArea(areaDto, plantationId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> editArea(final AreaDto areaDto) {
        log.info("Endpoint \"editArea\" has called");
        plantationHandler.handleEditArea(areaDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<AreaDto> getAreaById(final Long areaId) {
        log.info("Endpoint \"getAreaById\" has called");
        return ResponseEntity.ok(plantationHandler.handleGetAreaById(areaId));
    }

    @Override
    public ResponseEntity<List<AreaDto>> getAreas() {
        log.info("Endpoint \"getAreas\" has called");
        return ResponseEntity.ok(plantationHandler.handleGetAreas());
    }

    @Override
    public ResponseEntity<List<AreaDto>> getAreasByPlantation(final Long plantationId) {
        log.info("Endpoint \"getAreasByPlantation\" has called");
        return ResponseEntity.ok(plantationHandler.handleGetAreasByPlantation(plantationId));
    }

    @Override
    public ResponseEntity<PlantationDto> getPlantationById(final Long id) {
        log.info("Endpoint \"getPlantationById\" has called");
        return ResponseEntity.ok(plantationHandler.handleGetPlantationById(id));
    }

    @Override
    public ResponseEntity<List<PlantationDto>> getPlantations() {
        log.info("Endpoint \"getPlantations\" has called");
        return ResponseEntity.ok(plantationHandler.handleGetPlantations());
    }

    @Override
    public ResponseEntity<List<PlantationDto>> getPlantationsByUser(final Long userId) {
        log.info("Endpoint \"getPlantationByUser\" has called");
        return ResponseEntity.ok(plantationHandler.handleGetPlantationsByUser(userId));
    }

    @Override
    public ResponseEntity<Void> deleteArea(final Long areaId) {
        log.info("Endpoint \"deleteArea\" has called");
        plantationHandler.handleDeleteArea(areaId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> addEmployee(final Long plantationId, final Long userId) {
        log.info("Endpoint \"addEmployee\" has called");
        plantationHandler.handleAddEmployee(plantationId, userId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<UserDto>> getEmployees(final Long plantationId) {
        log.info("Endpoint \"getEmployees\" has called");
        return ResponseEntity.ok(plantationHandler.handleGetEmployees(plantationId));
    }
}
