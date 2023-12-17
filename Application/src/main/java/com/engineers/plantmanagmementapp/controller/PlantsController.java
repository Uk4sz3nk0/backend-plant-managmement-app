package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.PlantsHandler;
import com.engineers.plantmanagmementapp.rest.plants.specification.api.PlantsApi;
import com.engineers.plantmanagmementapp.rest.plants.specification.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * PlantsController - controller class for Plants and PlantsVarieties operations
 * Created on: 2023-12-13
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
        log.info("Request \"addPlant\" has called");
        plantsHandler.handleAddPlant(plantDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> addVariety(final Long plantId, final PlantVarietyDto plantVarietyDto) {
        log.info("Request \"addVariety\" has called");
        plantsHandler.handleAddVariety(plantId, plantVarietyDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deletePlant(final Long plantId) {
        log.info("Request \"deletePlant\" has called");
        plantsHandler.handleDeletePlant(plantId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteVariety(final Long varietyId) {
        log.info("Request \"deleteVariety\" has called");
        plantsHandler.handleDeleteVariety(varietyId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> editPlant(final PlantDto plantDto) {
        log.info("Request \"editPlant\" has called");
        plantsHandler.handleEditPlant(plantDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> editVariety(final PlantVarietyDto plantVarietyDto, final Long plantId) {
        log.info("Request \"editVariety\" has called");
        plantsHandler.handleEditVariety(plantId, plantVarietyDto);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<PagedPlantsDto> findPlants(final String searchPhrase, final PageRequestDto pageRequestDto) {
        log.info("Request \"findPlants\" has called");
        return ResponseEntity.ok(plantsHandler.handleFindPlants(searchPhrase, pageRequestDto));
    }

    @Override
    public ResponseEntity<PlantDto> getPlantById(final Long plantId) {
        log.info("Request \"getPlantById\" has called");
        return ResponseEntity.ok(plantsHandler.handleGetPlantById(plantId));
    }

    @Override
    public ResponseEntity<PagedPlantsDto> getPlants(final PageRequestDto pageRequestDto) {
        log.info("Request \"getPlants\" has called");
        return ResponseEntity.ok(plantsHandler.handleGetPlants(pageRequestDto));
    }

    @Override
    public ResponseEntity<PagedPlantsDto> getPlantsByType(final Integer plantType, final PageRequestDto pageRequestDto) {
        log.info("Request \"getPlantsByType\" has called");
        return ResponseEntity.ok(plantsHandler.handleGetPlantsByType(plantType, pageRequestDto));
    }

    @Override
    public ResponseEntity<PagedPlantVarietiesDto> getVarietiesByPlant(final Long plantId, final PageRequestDto pageRequestDto) {
        log.info("Request \"getVarietiesByPlant\" has called");
        return ResponseEntity.ok(plantsHandler.handleGetVarietiesByPlant(plantId, pageRequestDto));
    }

    @Override
    public ResponseEntity<PlantVarietyDto> getVarietyById(final Long varietyId) {
        log.info("Request \"getVarietyById\" has called");
        return ResponseEntity.ok(plantsHandler.handleGetVarietyById(varietyId));
    }
}
