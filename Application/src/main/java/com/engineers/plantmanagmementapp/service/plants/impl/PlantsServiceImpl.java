package com.engineers.plantmanagmementapp.service.plants.impl;

import com.engineers.plantmanagmementapp.enums.PlantType;
import com.engineers.plantmanagmementapp.model.Plant;
import com.engineers.plantmanagmementapp.model.PlantVariety;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.repository.PlantRepository;
import com.engineers.plantmanagmementapp.repository.PlantVarietyRepository;
import com.engineers.plantmanagmementapp.service.plants.PlantsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * PlantsServiceImpl - Implementation of plants service interface
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class PlantsServiceImpl implements PlantsService {

    private final PlantRepository plantRepository;
    private final PlantVarietyRepository plantVarietyRepository;

    @Override
    public void addPlant(final Plant plant) {
        plantRepository.save(plant);
    }

    @Override
    public void addVariety(final Plant plant, final PlantVariety plantVariety) {
        plantVariety.setPlant(plant);
        plantVarietyRepository.save(plantVariety);
    }

    @Override
    public void deletePlant(final Long plantId) {
        plantRepository.deleteById(plantId);
    }

    @Override
    public void deleteVariety(final Long varietyId) {
        plantVarietyRepository.deleteById(varietyId);
    }

    @Override
    public void editPlant(final Plant plant) {
        final Plant editPlant = plantRepository.findById(plant.getId())
                .orElseThrow();
        editPlant.setName(plant.getName());
        editPlant.setType(plant.getType());
        plantRepository.save(editPlant);
    }

    @Override
    public void editVariety(final Long plantId, final PlantVariety plantVariety) {
        final PlantVariety variety = plantVarietyRepository.findById(plantVariety.getId())
                .orElseThrow();
        variety.setName(plantVariety.getName());
        variety.setPriceForUnit(plantVariety.getPriceForUnit());
        if (plantId != null) {
            final Plant plant = plantRepository.findById(plantId)
                    .orElseThrow();
            variety.setPlant(plant);
        }
        plantVarietyRepository.save(variety);
    }

    @Override
    public Page<Plant> findPlants(final String searchPhrase, final Pagination pagination) {
        return plantRepository.findAllByNameContainsIgnoreCase(searchPhrase, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public Plant getPlantById(final Long plantId) {
        return plantRepository.findById(plantId)
                .orElseThrow();
    }

    @Override
    public Page<Plant> getPlants(final Pagination pagination) {
        return plantRepository.findAll(PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public Page<Plant> getPlantsByType(final PlantType plantType, final Pagination pagination) {
        return plantRepository.findAllByType(plantType, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public Page<PlantVariety> getVarietiesByPlant(final Plant plant, final Pagination pagination) {
        return plantVarietyRepository.findAllByPlant(plant, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public PlantVariety getVarietyById(final Long varietyId) {
        return plantVarietyRepository.findById(varietyId)
                .orElseThrow();
    }
}
