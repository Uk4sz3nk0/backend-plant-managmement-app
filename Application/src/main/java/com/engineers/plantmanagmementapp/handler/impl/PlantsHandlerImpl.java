package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.PlantsHandler;
import com.engineers.plantmanagmementapp.rest.plants.specification.model.*;
import com.engineers.plantmanagmementapp.service.plants.PlantsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * PlantsHandlerImpl - Implementation of PlantsHandler interface
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class PlantsHandlerImpl implements PlantsHandler {

    private final PlantsService plantsService;

    @Override
    public void handleAddPlant(final PlantDto plantDto) {

    }

    @Override
    public void handleAddVariety(final Long plantId, final PlantVarietyDto plantVarietyDto) {

    }

    @Override
    public void handleDeletePlant(final Long plantId) {

    }

    @Override
    public void handleDeleteVariety(final Long varietyId) {

    }

    @Override
    public void handleEditPlant(final PlantDto plantDto) {

    }

    @Override
    public void handleEditVariety(final Long plantId, final PlantVarietyDto plantVarietyDto) {

    }

    @Override
    public PagedPlantsDto handleFindPlants(final String searchPhrase, final PageRequestDto pageRequestDto) {
        return null;
    }

    @Override
    public PlantDto handleGetPlantById(final Long plantId) {
        return null;
    }

    @Override
    public PagedPlantsDto handleGetPlants(final PageRequestDto pageRequestDto) {
        return null;
    }

    @Override
    public PagedPlantsDto handleGetPlantsByType(final Integer plantType, final PageRequestDto pageRequestDto) {
        return null;
    }

    @Override
    public PagedPlantVarietiesDto handleGetVarietiesByPlant(final Long plantId, final PageRequestDto pageRequestDto) {
        return null;
    }

    @Override
    public PlantVarietyDto handleGetVarietyById(final Long varietyId) {
        return null;
    }
}
