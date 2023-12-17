package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.enums.PlantType;
import com.engineers.plantmanagmementapp.handler.PlantsHandler;
import com.engineers.plantmanagmementapp.mapper.PlantsMapper;
import com.engineers.plantmanagmementapp.repository.PlantRepository;
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
    private final PlantRepository plantRepository;

    @Override
    public void handleAddPlant(final PlantDto plantDto) {
        plantsService.addPlant(PlantsMapper.INSTANCE.map(plantDto));
    }

    @Override
    public void handleAddVariety(final Long plantId, final PlantVarietyDto plantVarietyDto) {
        final var plant = plantRepository.findById(plantId)
                .orElseThrow();
        plantsService.addVariety(plant, PlantsMapper.INSTANCE.map(plantVarietyDto));
    }

    @Override
    public void handleDeletePlant(final Long plantId) {
        plantsService.deletePlant(plantId);
    }

    @Override
    public void handleDeleteVariety(final Long varietyId) {
        plantsService.deleteVariety(varietyId);
    }

    @Override
    public void handleEditPlant(final PlantDto plantDto) {
        plantsService.editPlant(PlantsMapper.INSTANCE.map(plantDto));
    }

    @Override
    public void handleEditVariety(final Long plantId, final PlantVarietyDto plantVarietyDto) {
        plantsService.editVariety(plantId, PlantsMapper.INSTANCE.map(plantVarietyDto));
    }

    @Override
    public PagedPlantsDto handleFindPlants(final String searchPhrase, final PageRequestDto pageRequestDto) {
        return PlantsMapper.INSTANCE.map(plantsService.findPlants(searchPhrase, PlantsMapper.INSTANCE.map(pageRequestDto)));
    }

    @Override
    public PlantDto handleGetPlantById(final Long plantId) {
        return PlantsMapper.INSTANCE.map(plantsService.getPlantById(plantId));
    }

    @Override
    public PagedPlantsDto handleGetPlants(final PageRequestDto pageRequestDto) {
        return PlantsMapper.INSTANCE.map(plantsService.getPlants(PlantsMapper.INSTANCE.map(pageRequestDto)));
    }

    @Override
    public PagedPlantsDto handleGetPlantsByType(final Integer plantType, final PageRequestDto pageRequestDto) {

        return PlantsMapper.INSTANCE.map(plantsService.getPlantsByType(PlantType.values()[plantType], PlantsMapper.INSTANCE.map(pageRequestDto)));
    }

    @Override
    public PagedPlantVarietiesDto handleGetVarietiesByPlant(final Long plantId, final PageRequestDto pageRequestDto) {
        final var plant = plantRepository.findById(plantId)
                .orElseThrow();
        return PlantsMapper.INSTANCE.mapVarieties(plantsService.getVarietiesByPlant(plant, PlantsMapper.INSTANCE.map(pageRequestDto)));
    }

    @Override
    public PlantVarietyDto handleGetVarietyById(final Long varietyId) {
        return PlantsMapper.INSTANCE.map(plantsService.getVarietyById(varietyId));
    }
}
