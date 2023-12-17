package com.engineers.plantmanagmementapp.service.plants;

import com.engineers.plantmanagmementapp.enums.PlantType;
import com.engineers.plantmanagmementapp.model.Plant;
import com.engineers.plantmanagmementapp.model.PlantVariety;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.rest.plants.specification.model.*;
import org.springframework.data.domain.Page;

/**
 * PlantsService
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

public interface PlantsService {

    void addPlant(final Plant plant);

    void addVariety(final Plant plant, final PlantVariety plantVariety);

    void deletePlant(final Long plantId);

    void deleteVariety(final Long varietyId);

    void editPlant(final Plant plant);

    void editVariety(final Long plantId, final PlantVariety plantVariety);

    Page<Plant> findPlants(final String searchPhrase, final Pagination pagination);

    Plant getPlantById(final Long plantId);

    Page<Plant> getPlants(final Pagination pagination);

    Page<Plant> getPlantsByType(final PlantType plantType, final Pagination pagination);

    Page<PlantVariety> getVarietiesByPlant(final Plant plant, final Pagination pagination);

    PlantVariety getVarietyById(final Long varietyId);
}
