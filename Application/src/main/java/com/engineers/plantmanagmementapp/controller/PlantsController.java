package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.PlantsHandler;
import com.engineers.plantmanagmementapp.rest.plants.specification.api.PlantsApi;
import com.engineers.plantmanagmementapp.rest.plants.specification.model.PlantDto;
import com.engineers.plantmanagmementapp.rest.plants.specification.model.VarietyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PlantsController - Controller class with endpoints to manage plants
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlantsController implements PlantsApi {

    private final PlantsHandler plantsHandler;

    @Override
    public ResponseEntity<Void> addPlant(final PlantDto plantDto) {
        log.info("'addPlant' endpoint has request");
        plantsHandler.handleAddPlant(plantDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> addPlantWithVarieties(final PlantDto plantDto) {
        log.info("'addPlantWithVarieties' endpoint has called");
        plantsHandler.handleAddPlantWithVarieties(plantDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> addVariety(final VarietyDto varietyDto) {
        log.info("'addVariety' endpoint has called");
        plantsHandler.handleAddVariety(varietyDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deletePlant(final Long plantId) {
        log.info("'deletePlant' endpoint has called");
        plantsHandler.handleDeletePlant(plantId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteVariety(final Long varietyId) {
        log.info("'deleteVariety' endpoint has called");
        plantsHandler.handleDeleteVariety(varietyId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> editPlant(final PlantDto plantDto) {
        log.info("'editPlant' endpoint has called");
        plantsHandler.handleEditPlant(plantDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> editVariety(final VarietyDto varietyDto) {
        log.info("'editVariety' endpoint has called");
        plantsHandler.handleEditVariety(varietyDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<PlantDto> getPlantById(final Long plantId) {
        log.info("'getPlantById' endpoint has called");
        return ResponseEntity.ok(plantsHandler.handleGetPlantById(plantId));
    }

    @Override
    public ResponseEntity<List<PlantDto>> getPlants() {
        log.info("'getPlants' endpoint has called");
        return ResponseEntity.ok(plantsHandler.handleGetPlants());
    }

    @Override
    public ResponseEntity<List<PlantDto>> getPlantsByName(final String name) {
        log.info("'getPlantsByName' endpoint has called");
        return ResponseEntity.ok(plantsHandler.handleGetPlantsByName(name));
    }

    @Override
    public ResponseEntity<List<PlantDto>> getPlantsByType(final String plantType) {
        log.info("'getPlantsByType' endpoint has called");
        return ResponseEntity.ok(plantsHandler.handleGetPlantsByType(plantType));
    }

    @Override
    public ResponseEntity<List<VarietyDto>> getVarieties() {
        log.info("'getVarieties' endpoint has called");
        return ResponseEntity.ok(plantsHandler.handleGetVarieties());
    }

    @Override
    public ResponseEntity<List<VarietyDto>> getVarietiesByName(final String name) {
        log.info("'getVarietiesByName' endpoint has called");
        return ResponseEntity.ok(plantsHandler.handleGetVarietiesByName(name));
    }

    @Override
    public ResponseEntity<List<VarietyDto>> getVarietiesByPlant(final Long plantId) {
        log.info("'getVarietiesByPlant' endpoint has called");
        return ResponseEntity.ok(plantsHandler.handleGetVarietiesByPlant(plantId));
    }

    @Override
    public ResponseEntity<VarietyDto> getVarietyById(final Long varietyId) {
        log.info("'getVarietyById' endpoint has called");
        return ResponseEntity.ok(plantsHandler.handleGetVarietyById(varietyId));
    }
}
