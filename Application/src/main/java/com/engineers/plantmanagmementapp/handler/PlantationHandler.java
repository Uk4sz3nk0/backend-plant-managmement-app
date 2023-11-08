package com.engineers.plantmanagmementapp.handler;

import com.engineers.plantmanagmementapp.record.AreaRecord;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.AreaDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.PlantationDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.UserDto;

import java.util.List;

/**
 * PlantationHandler - Handler interface
 * <p>
 * Created on: 2023-11-06
 *
 * @author Łukasz Wodniak
 */

public interface PlantationHandler {

    void handleCreatePlantation(final PlantationDto plantationDto);

    void handleDeletePlantation(final Long plantationId);

    void handleEditPlantation(final PlantationDto plantationDto);

    void handleAddArea(final AreaDto area, final Long plantationId);

    void handleEditArea(final AreaDto areaDto);

    void handleDeleteArea(final Long areaId);

    AreaDto handleGetAreaById(final Long areaId);

    List<AreaDto> handleGetAreas();

    List<AreaDto> handleGetAreasByPlantation(final Long plantationId);

    PlantationDto handleGetPlantationById(final Long plantationId);

    List<PlantationDto> handleGetPlantations();

    List<PlantationDto> handleGetPlantationsByUser(final Long userId);

    void handleAddEmployee(final Long plantationId, final Long userId);

    List<UserDto> handleGetEmployees(final Long plantationId);
}
