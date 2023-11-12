package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.PlantsHandler;
import com.engineers.plantmanagmementapp.rest.plants.specification.model.PlantDto;
import com.engineers.plantmanagmementapp.rest.plants.specification.model.VarietyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PlantsHandlerImpl - Implementation class of PlantsHandler interface
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class PlantsHandlerImpl implements PlantsHandler {

    @Override
    public void handleAddPlant(final PlantDto plantDto) {

    }

    @Override
    public void handleAddPlantWithVarieties(final PlantDto plantDto) {

    }

    @Override
    public void handleAddVariety(final VarietyDto varietyDto) {

    }

    @Override
    public void handleDeletePlant(final Long id) {

    }

    @Override
    public void handleDeleteVariety(final Long id) {

    }

    @Override
    public void handleEditPlant(final PlantDto plantDto) {

    }

    @Override
    public void handleEditVariety(final VarietyDto varietyDto) {

    }

    @Override
    public PlantDto handleGetPlantById(final Long id) {
        return null;
    }

    @Override
    public List<PlantDto> handleGetPlants() {
        return null;
    }

    @Override
    public List<PlantDto> handleGetPlantsByName(final String name) {
        return null;
    }

    @Override
    public List<PlantDto> handleGetPlantsByType(final String type) {
        return null;
    }

    @Override
    public List<VarietyDto> handleGetVarieties() {
        return null;
    }

    @Override
    public List<VarietyDto> handleGetVarietiesByName(final String name) {
        return null;
    }

    @Override
    public List<VarietyDto> handleGetVarietiesByPlant(final Long plantId) {
        return null;
    }

    @Override
    public VarietyDto handleGetVarietyById(final Long id) {
        return null;
    }
}
