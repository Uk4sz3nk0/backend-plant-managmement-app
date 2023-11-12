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
    public ResponseEntity<Void> addPlant(final PlantDto body) {
        return PlantsApi.super.addPlant(body);
    }

    @Override
    public ResponseEntity<Void> addPlantWithVarieties(final PlantDto body) {
        return PlantsApi.super.addPlantWithVarieties(body);
    }

    @Override
    public ResponseEntity<Void> addVariety(final VarietyDto body) {
        return PlantsApi.super.addVariety(body);
    }

    @Override
    public ResponseEntity<Void> deletePlant(final Long plantId) {
        return PlantsApi.super.deletePlant(plantId);
    }

    @Override
    public ResponseEntity<Void> deleteVariety(final Long varietyId) {
        return PlantsApi.super.deleteVariety(varietyId);
    }

    @Override
    public ResponseEntity<Void> editPlant(final PlantDto body) {
        return PlantsApi.super.editPlant(body);
    }

    @Override
    public ResponseEntity<Void> editVariety(final VarietyDto body) {
        return PlantsApi.super.editVariety(body);
    }

    @Override
    public ResponseEntity<PlantDto> getPlantById(final Long plantId) {
        return PlantsApi.super.getPlantById(plantId);
    }

    @Override
    public ResponseEntity<List<PlantDto>> getPlants() {
        return PlantsApi.super.getPlants();
    }

    @Override
    public ResponseEntity<List<PlantDto>> getPlantsByName(final String name) {
        return PlantsApi.super.getPlantsByName(name);
    }

    @Override
    public ResponseEntity<List<PlantDto>> getPlantsByType(final String plantType) {
        return PlantsApi.super.getPlantsByType(plantType);
    }

    @Override
    public ResponseEntity<List<VarietyDto>> getVarieties() {
        return PlantsApi.super.getVarieties();
    }

    @Override
    public ResponseEntity<List<VarietyDto>> getVarietiesByName(final String name) {
        return PlantsApi.super.getVarietiesByName(name);
    }

    @Override
    public ResponseEntity<List<VarietyDto>> getVarietiesByPlant(final Long plantId) {
        return PlantsApi.super.getVarietiesByPlant(plantId);
    }

    @Override
    public ResponseEntity<VarietyDto> getVarietyById(final Long varietyId) {
        return PlantsApi.super.getVarietyById(varietyId);
    }
}
