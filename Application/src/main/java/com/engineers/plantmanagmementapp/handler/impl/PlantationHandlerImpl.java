package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.PlantationHandler;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.AreaDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.PlantationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PlantationHandlerImpl - Real implementation of plantation handler
 * <p>
 * Created on: 2023-11-06
 *
 * @author Łuaksz Wodniak
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class PlantationHandlerImpl implements PlantationHandler {

    @Override
    public void handleCreatePlantation(final PlantationDto plantationDto) {

    }

    @Override
    public void handleDeletePlantation(final Long plantationId) {

    }

    @Override
    public void handleEditPlantation(final PlantationDto plantationDto) {

    }

    @Override
    public void handleEditArea(final AreaDto areaDto) {

    }

    @Override
    public AreaDto handleGetAreaById(final Long areaId) {
        return null;
    }

    @Override
    public List<AreaDto> handleGetAreas() {
        return null;
    }

    @Override
    public List<AreaDto> handleGetAreasByPlantation(final Long plantationId) {
        return null;
    }

    @Override
    public PlantationDto handleGetPlantationById(final Long plantationId) {
        return null;
    }

    @Override
    public List<PlantationDto> handleGetPlantations() {
        return null;
    }

    @Override
    public List<PlantationDto> handleGetPlantationsByUser(final Long userId) {
        return null;
    }
}
