package com.engineers.plantmanagmementapp.handler;

import com.engineers.plantmanagmementapp.rest.plants.specification.model.*;

/**
 * PlantsHandler - Handler interface of Plants and PlantsVarieties operations
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

public interface PlantsHandler {

    void handleAddPlant(final PlantDto plantDto);

    void handleAddVariety(final Long plantId, final PlantVarietyDto plantVarietyDto);

    void handleDeletePlant(final Long plantId);

    void handleDeleteVariety(final Long varietyId);

    void handleEditPlant(final PlantDto plantDto);

    void handleEditVariety(final Long plantId, final PlantVarietyDto plantVarietyDto);

    PagedPlantsDto handleFindPlants(final String searchPhrase, final PageRequestDto pageRequestDto);

    PlantDto handleGetPlantById(final Long plantId);

    PagedPlantsDto handleGetPlants(final PageRequestDto pageRequestDto);

    PagedPlantsDto handleGetPlantsByType(final Integer plantType, final PageRequestDto pageRequestDto);

    PagedPlantVarietiesDto handleGetVarietiesByPlant(final Long plantId, final PageRequestDto pageRequestDto);

    PlantVarietyDto handleGetVarietyById(final Long varietyId);


}
