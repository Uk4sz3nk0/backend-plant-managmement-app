package com.engineers.plantmanagmementapp.handler;

import com.engineers.plantmanagmementapp.rest.plants.specification.model.PlantDto;
import com.engineers.plantmanagmementapp.rest.plants.specification.model.VarietyDto;

import java.util.List;

/**
 * PlantsHandler - Plants handler interface
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

public interface PlantsHandler {

    void handleAddPlant(final PlantDto plantDto);

    void handleAddPlantWithVarieties(final PlantDto plantDto);

    void handleAddVariety(final VarietyDto varietyDto);

    void handleDeletePlant(final Long id);

    void handleDeleteVariety(final Long id);

    void handleEditPlant(final PlantDto plantDto);

    void handleEditVariety(final VarietyDto varietyDto);

    PlantDto handleGetPlantById(final Long id);

    List<PlantDto> handleGetPlants();

    List<PlantDto> handleGetPlantsByName(final String name);

    List<PlantDto> handleGetPlantsByType(final String type);

    List<VarietyDto> handleGetVarieties();

    List<VarietyDto> handleGetVarietiesByName(final String name);

    List<VarietyDto> handleGetVarietiesByPlant(final Long plantId);

    VarietyDto handleGetVarietyById(final Long id);
}